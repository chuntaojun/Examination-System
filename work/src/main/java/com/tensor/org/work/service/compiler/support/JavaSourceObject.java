package com.tensor.org.work.service.compiler.support;

import javax.tools.SimpleJavaFileObject;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

/**
 * @author liaochuntao
 */
public class JavaSourceObject extends SimpleJavaFileObject {

    private String code;
    private ByteArrayOutputStream os;

    protected JavaSourceObject(String name, String code) {
        super(URI.create("string:///" + name.replace('.','/') + Kind.SOURCE.extension), Kind.SOURCE);
        this.code = code;
        this.os = new ByteArrayOutputStream();
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
        return code;
    }

    @Override
    public OutputStream openOutputStream() throws IOException {
        return os;
    }
}
