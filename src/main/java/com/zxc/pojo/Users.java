package com.zxc.pojo;

/**
 * Created with IntelliJ IDEA.
 * User: zxc
 * Date: 2021/01/18 17:11
 * Description:
 * Version: V1.0
 */
public class Users {
    private String user_tel; //电话号码
    private String user_email;//邮箱地址
    private String user_pwd; //密码

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }
}
