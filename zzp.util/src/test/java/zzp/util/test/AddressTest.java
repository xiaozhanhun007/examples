package zzp.util.test;

import java.lang.reflect.Field;

public class AddressTest {

    public static void main(String[] args) {
        Integer a = 0;
        String s = "zzp";
        System.out.println("a:" + a.hashCode());
        System.out.println("b:" + s.hashCode());

        a = 1234;
        s = "zzpzjl";

        System.out.println("a:" + a.hashCode());
        System.out.println("b:" + s.hashCode());


        Integer j1 = 2;
        Integer j2 = 2;
        System.out.println("j1 = j2? " + (j1 == j2));  //true
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            field.set(j2,129);
            System.out.println( "j1+"+j1+"+j2+" + j2
                    +"\nSystem.identityHashCode(j1)"+System.identityHashCode(j1)
                    +"\nSystem.identityHashCode(j2)"+System.identityHashCode(j2)
                    +"\nj1 == j2" + (j1 == j2));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Integer j3 = 2;
        Integer j4 = 2;
        System.out.println("j3+"+j3+"\nSystem.identityHashCode(j3)"+System.identityHashCode(j3)+"\nj3 = j4? " + (j3 == j4));
    }
}
