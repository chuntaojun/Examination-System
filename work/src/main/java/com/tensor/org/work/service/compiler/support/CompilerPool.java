package com.tensor.org.work.service.compiler.support;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.tools.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author liaochuntao
 */
@Slf4j
@Component
@Scope("singleton")
public final class CompilerPool {

    private final static int COMPILER_POOL_SIZE = Runtime.getRuntime().availableProcessors();
    private final static ConcurrentLinkedQueue<TensorJavaCompiler> COMPILER_POOL = new ConcurrentLinkedQueue<>();
    private final static ClassLoader parentClassloader = CompilerPool.class.getClassLoader();

    static {
        for (int i = 0; i < COMPILER_POOL_SIZE; i ++) {
            COMPILER_POOL.add(new TensorJavaCompiler());
        }
    }

    public CompilerResult work(String javaName, String javaSourceCode) {
        TensorJavaCompiler compiler = COMPILER_POOL.poll();
        if (compiler == null) {
            return new CompilerResult();
        }
        return compiler.buildTask(javaName, javaSourceCode).compile(new CompilerResult());
    }

    private final static class TensorJavaCompiler {

        private volatile boolean isRunning;
        private JavaCompiler compiler;
        private DiagnosticCollector<JavaFileObject> diagnostics;
        private String javaName;
        private JavaCompiler.CompilationTask task;
        private TensorClassLoader classLoader;
        private String classpath;
        private ClassFileManager fileManager;

        private TensorJavaCompiler() {
            isRunning = false;
            compiler = ToolProvider.getSystemJavaCompiler();
            diagnostics = new DiagnosticCollector<>();
            classLoader = new TensorClassLoader(parentClassloader);
            fileManager = new ClassFileManager(compiler.getStandardFileManager(diagnostics, null, null));
            buildClassPath();
        }

        void buildClassPath() {
            this.classpath = null;
            StringBuilder sb = new StringBuilder();
            for (URL url : this.classLoader.getURLs()) {
                String p = url.getFile();
                sb.append(p).append(File.pathSeparator);
            }
            this.classpath = sb.toString();
        }

        TensorJavaCompiler buildTask(String name, String source) {
            javaName = name;
            List<JavaFileObject> fileObjects = new ArrayList<>();
            fileObjects.add(new JavaSourceObject(javaName, source));
            List<String> options = new ArrayList<>();
            options.add("-encoding");
            options.add("UTF-8");
            options.add("-classpath");
            options.add(this.classpath);
            task = compiler.getTask(null, fileManager, diagnostics, options, null, fileObjects);
            return this;
        }

        CompilerResult compile(CompilerResult result) {
            isRunning = true;
            if (task.call()) {
                try {
                    //更改System,out流的位置，因为有的方法是有向控制台输出的
                    PrintStream old = System.out;
                    ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);
                    PrintStream print = new PrintStream(bos);
                    System.setOut(print);
                    JavaClassObject classObject = fileManager.getJavaClassObject();
                    // 获取加载的类
                    Class cls = classLoader.loadClass(javaName, classObject);
                    // 反射调用main方法
                    result.setResult(cls.getDeclaredMethod("main", String[].class).invoke(null, new Object[]{null}));
                    System.setOut(old);
                    result.setPrintMsg(bos.toString());
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    log.error("compiler exception is ", e);
                }
            } else {
                String compilerErr = "";
                for (Diagnostic diagnostic : diagnostics.getDiagnostics()) {
                    compilerErr += compilePrint(diagnostic);
                }
                result.setCompilerErr(compilerErr);
            }
            result.setTimeout(false);
            release();
            return result;
        }

        public boolean isRunning() {
            return isRunning;
        }

        private void release() {
            isRunning = false;
            COMPILER_POOL.add(this);
        }

        private String compilePrint(Diagnostic diagnostic) {
            StringBuffer res = new StringBuffer();
            res.append("Code:[").append(diagnostic.getCode()).append("]\n");
            res.append("Kind:[").append(diagnostic.getKind()).append("]\n");
            res.append("Position:[").append(diagnostic.getPosition()).append("]\n");
            res.append("Start Position:[").append(diagnostic.getStartPosition()).append("]\n");
            res.append("End Position:[").append(diagnostic.getEndPosition()).append("]\n");
            res.append("Source:[").append(diagnostic.getSource()).append("]\n");
            res.append("Message:[").append(diagnostic.getMessage(null)).append("]\n");
            res.append("LineNumber:[").append(diagnostic.getLineNumber()).append("]\n");
            res.append("ColumnNumber:[").append(diagnostic.getColumnNumber()).append("]\n");
            return res.toString();
        }

    }

}
