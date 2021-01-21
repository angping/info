package com.zxc.service;

import com.zxc.pojo.Users;

import java.security.NoSuchAlgorithmException;


/**
 * Created with IntelliJ IDEA.
 * User: zxc
 * Date: 2021/01/19 10:34
 * Description:
 * Version: V1.0
 */

public interface UserService {

    /**
     * 根据表单提交的用户数据，实现注册功能
     * @param user
     * @return
     */
    int addUser(Users user);


    /**根据电话和密码查找用户
     *
     * @param user
     * @return
     */
    Users findUserByTelAndPwd(Users user) throws NoSuchAlgorithmException;

    //Users 返回的User信息 括号中传递的参数

    /**
     * 根据电话号码查询用户是否注册
     * @param user
     * @return
     */
    Users queryByUser_tel(Users user);

}
