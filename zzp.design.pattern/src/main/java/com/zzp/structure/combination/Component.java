package com.zzp.structure.combination;

import java.util.List;

/**
 * 抽象接口（例子为文件系统，定义的方法为文件系统相关的）
 * @author Garyzeng
 * @since 2020.07.21
 */
public interface Component {

    String getName();

    void addChild(Component child);

    void removeChild(Component child);

    void print();

    List<Component> getChilds();

    void printParent();

    Component getParent();

}
