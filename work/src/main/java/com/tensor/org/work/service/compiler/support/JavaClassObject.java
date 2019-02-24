package com.tensor.org.work.service.compiler.support;

import javax.tools.SimpleJavaFileObject;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

/**
 * @author liaochuntao
 */
public class JavaClassObject extends SimpleJavaFileObject {

    protected ByteArrayOutputStream bos = new ByteArrayOutputStream();

    protected JavaClassObject(String name, Kind kind) {
        super(URI.create("string:///" + name.replace('.', '/') + kind.extension), kind);
    }

    public byte[] getBytes() {
        return bos.toByteArray();
    }

    @Override
    public OutputStream openOutputStream() throws IOException {
        return bos;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        bos.close();
    }
}
