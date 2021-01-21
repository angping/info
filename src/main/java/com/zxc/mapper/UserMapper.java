package com.zxc.mapper;

import com.zxc.pojo.Users;

/**
 * Created with IntelliJ IDEA.
 * User: zxc
 * Date: 2021/01/19 11:06
 * Description:
 * Version: V1.0
 */
public interface UserMapper {

    int addUser(Users user);

    Users findUserByTelAndPwd(Users user);

    Users queryByUser_tel(Users user);
}
