package com.zzp.structure.combination;

/**
 * @Description 组合模式测试
 * @Author Garyzeng
 * @since 2019.11.28
 **/
public class Test {

    public static void main(String[] args) {

        Department children1 = new Department(1, "子公司1");
        Department children2 = new Department(2, "子公司2");
        Department children3 = new Department(3, "子公司3");
        Department department = new Department(4, "总公司");
        department.addChildren(children1);
        department.addChildren(children2);
        department.addChildren(children3);

        department.removeChildren(children1);

        System.out.println(department);
    }

}
