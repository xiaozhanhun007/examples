package com.zzp.demo;

/**
 * @Description 测试自定义类加载器
 * @Author karyzeng
 * @since 2019.09.22
 **/
public class MyClassCoaderTest {

    public static void main(String[] args) {
        try {
            MyClassLoader myClassLoader = new MyClassLoader();
            Class clazz = myClassLoader.loadClass("com.zzp.demo.MyClassCoaderTest");
            Object object = clazz.newInstance();
            System.out.println(object.getClass());
            System.out.println(object.getClass().getClassLoader());

            System.out.println("-------------------------");

            MyClassCoaderTest test = new MyClassCoaderTest();
            System.out.println(test.getClass());
            System.out.println(test.getClass().getClassLoader());

            if (object instanceof MyClassCoaderTest) {
                System.out.println("相等");
            } else {
                System.out.println("不相等");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
