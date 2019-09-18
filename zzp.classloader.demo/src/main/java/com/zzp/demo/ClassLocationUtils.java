package com.zzp.demo;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;

/**
 * @Description 查找类的加载源工具类
 * @Author karyzeng
 * @since 2019.09.18
 **/
public class ClassLocationUtils {

    /**
     * 查找类的加载源
     * @param cls 类对象
     * @return String
     */
    public static String findClassLoadSource(final Class cls) {
        if (cls == null){
            throw new IllegalArgumentException("cls不能为空");
        }
        URL result = null;
        final String clsAsResource = cls.getName().replace('.', '/').concat(".class");
        final ProtectionDomain pd = cls.getProtectionDomain();
        if (pd != null) {
            final CodeSource cs = pd.getCodeSource();
            if (cs != null) {
                result = cs.getLocation();
            }
            if (result != null) {
                if ("file".equals(result.getProtocol())) {
                    try {
                        if (result.toExternalForm().endsWith(".jar") || result.toExternalForm().endsWith(".zip")) {
                            result = new URL("jar:".concat(result.toExternalForm()).concat("!/").concat(clsAsResource));
                        } else if (new File(result.getFile()).isDirectory()) {
                            result = new URL(result, clsAsResource);
                        }
                    }
                    catch (MalformedURLException ignore) {

                    }
                }
            }
        }
        if (result == null) {
            final ClassLoader clsLoader = cls.getClassLoader();
            result = clsLoader != null ? clsLoader.getResource(clsAsResource) : ClassLoader.getSystemResource(clsAsResource);
        }
        return result.toString();
    }

    /**
     * 查找类的加载源
     * @param classFullName 类的全限定名，例如java.lang.Thread
     * @return String
     */
    public static String findClassLoadSource(final String classFullName) {
        try {
            Class cls = Class.forName(classFullName);
            return findClassLoadSource(cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(java.lang.Thread.class.getName());
        System.out.println(ClassLocationUtils.findClassLoadSource(java.lang.Thread.class));
        System.out.println(ClassLocationUtils.findClassLoadSource("java.lang.Thread"));
    }

}
