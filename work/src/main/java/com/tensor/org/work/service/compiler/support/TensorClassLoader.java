package com.tensor.org.work.service.compiler.support;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author liaochuntao
 */
public class TensorClassLoader extends URLClassLoader {

    public TensorClassLoader(ClassLoader parent) {
        super(new URL[0], parent);
    }

    public Class loadClass(String name, JavaClassObject jco) {
        byte[] classData = jco.getBytes();
        return this.defineClass(name, classData, 0, classData.length);
    }
}
