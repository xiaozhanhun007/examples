package com.zzp.structure.combination;

/**
 * @Description 组合模式客户端
 * @Author Garyzeng
 * @since 2019.11.28
 **/
public class Client {

    public static void main(String[] args) {
        Component root = new Folder("root", null);

        Component folder1 = new Folder("学习", root);
        Component folder2 = new Folder("工作", root);
        Component file1 = new File("根目录配置.txt", root);
        root.addChild(folder1);
        root.addChild(folder2);
        root.addChild(file1);

        Component file2 = new File("Java从入门到放弃.pdf", folder1);
        Component file3 = new File("MySql从入门到放弃.pdf", folder1);
        Component file4 = new File("工作日志.txt", folder2);

        folder1.addChild(file2);
        folder1.addChild(file3);
        folder2.addChild(file4);

        folder1.print();
        System.out.println("-------");
        file4.printParent();
    }

}
