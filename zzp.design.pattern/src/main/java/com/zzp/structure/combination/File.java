package com.zzp.structure.combination;

import java.util.List;

/**
 * @Description 文件
 * @Author Garyzeng
 * @since 2020.07.21
 **/
public class File implements Component{

    private String name;

    private Component parent;

    public File(String name, Component parent) {
        this.name = name;
        this.parent = parent;
    }

    public String getName() {
        return this.name;
    }

    public void addChild(Component child) {
        throw new UnsupportedOperationException("叶子节点不支持添加子节点操作");
    }

    public void removeChild(Component child) {
        throw new UnsupportedOperationException("叶子节点不支持删除子节点操作");
    }

    public List<Component> getChilds() {
        throw new UnsupportedOperationException("叶子节点不支持获取子节点操作");
    }

    public void print() {
        System.out.println("节点名称为：" + this.name);
    }

    public Component getParent() {
        return this.parent;
    }

    public void printParent() {
        if (parent != null) {
            System.out.println(parent.getName());
            parent.printParent();
        }
    }
}
