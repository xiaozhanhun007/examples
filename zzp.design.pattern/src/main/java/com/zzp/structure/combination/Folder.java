package com.zzp.structure.combination;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description 文件夹
 * @Author karyzeng
 * @since 2020.07.21
 **/
public class Folder implements Component{

    private String name;

    private Component parent;

    private List<Component> childs;

    public Folder(String name, Component parent) {
        this.name = name;
        this.parent = parent;
        childs = new LinkedList<Component>();
    }

    public String getName() {
        return this.name;
    }

    public void addChild(Component child) {
        if (child != null) {
            childs.add(child);
        }
    }

    public void removeChild(Component child) {
        childs.remove(child);
    }

    public void print() {
        System.out.println("节点名称为：" + name);
        for (Component child : childs) {
            child.print();
        }
    }

    public List<Component> getChilds() {
        return this.childs;
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
