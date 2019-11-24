package com.zzp.creation.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 浅克隆，使用java的clone实现
 * @Author Garyzeng
 * @since 2019.11.23
 **/
public class ShallowClone {

    public static void main(String[] args) {
        try {
            List<String> roles = new ArrayList<String>();
            roles.add("admin");
            roles.add("director");
            User user = new User(1, "zzp", "123", roles);
            User cloneUser = (User) user.clone();
            System.out.println(user);
            user.setId(2);
            user.getRoles().remove("admin");
            System.out.println(cloneUser);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
