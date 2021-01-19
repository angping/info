package com.zxc.service;

import com.zxc.pojo.Users;


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
}
