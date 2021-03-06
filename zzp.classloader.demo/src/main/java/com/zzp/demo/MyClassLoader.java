package com.zzp.demo;

import java.io.InputStream;

/**
 * 自定义类加载器
 * @author karyZeng
 * @since 2019.09.22
 */
public class MyClassLoader extends ClassLoader {

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return loadClass(name, false);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        try {
            // 先查找是否已经存在该类
            Class clazz = findLoadedClass(name);
            if (clazz == null) {
                String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                // 当前类加载器先去加载指定的类
                InputStream inputStream = getClass().getResourceAsStream(fileName);
                if (inputStream == null) {
                    // 如果当前类加载器没有加载到类，则委托父类去加载
                    return super.loadClass(name, resolve);
                }
                byte[] bytes = new byte[inputStream.available()];
                inputStream.read(bytes);
                clazz = defineClass(name, bytes, 0, bytes.length);

                if (resolve) {
                    resolveClass(clazz);
                }
            }
            return clazz;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
