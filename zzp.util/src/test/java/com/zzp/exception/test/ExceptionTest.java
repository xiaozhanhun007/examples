package com.zzp.exception.test;

/**
 * @Description 异常测试
 * @Author Garyzeng
 * @since 2020.05.24
 **/
public class ExceptionTest {

    public static void main(String[] args) {
        try {
            sum(20);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sum(int num) throws NullPointerException{
        int total = 0;
        for (int i = 0; i < num; i++) {
            total += total + (i + 1);
        }
        System.out.println(total);
    }

}
