package com.tensor.org.work.service.compiler.support;

import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import java.io.IOException;

/**
 * @author liaochuntao
 */
public class ClassFileManager extends ForwardingJavaFileManager {

    private JavaClassObject classObject;

    protected ClassFileManager(JavaFileManager fileManager) {
        super(fileManager);
    }

    @Override
    public JavaFileObject getJavaFileForOutput(Location location, String className, JavaFileObject.Kind kind, FileObject sibling)
            throws IOException {
        if (classObject == null) {
            classObject = new JavaClassObject(className, kind);
        }
        return classObject;
    }

    public JavaClassObject getJavaClassObject() {
        return classObject;
    }
}
