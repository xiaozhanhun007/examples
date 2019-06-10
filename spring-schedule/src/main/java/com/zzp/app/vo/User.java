package com.zzp.app.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author karyzeng
 * @since 2019.05.08
 **/
@Data
public class User implements Serializable{

    private static final long serialVersionUID = -1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 登录名
     */
    private String loginId;

    public String toString() {
        return id + ", " + userName + ", " + loginId;
    }

}
