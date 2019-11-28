package com.zzp.structure.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 组合模式
 * @Author Garyzeng
 * @since 2019.11.28
 **/
public class Department {

    private Integer id;

    private String name;

    private List<Department> childrens;

    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Department(Integer id, String name, List<Department> childrens) {
        this.id = id;
        this.name = name;
        this.childrens = childrens;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Department> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Department> childrens) {
        this.childrens = childrens;
    }

    public void addChildren(Department children) {
        if (children != null) {
            if (this.childrens == null) {
                this.childrens = new ArrayList<Department>();
            }
            this.childrens.add(children);
        }
    }

    public void removeChildren(Department children) {
        if (children != null) {
            if (this.childrens != null && this.childrens.size() > 0) {
                int index = -1;
                for (int i = 0; i < this.childrens.size(); i++) {
                    Department department = this.childrens.get(i);
                    if (department.getId().equals(children.getId())) {
                        index = i;
                        break;
                    }
                }
                this.childrens.remove(index);
            }
        }
    }
}
