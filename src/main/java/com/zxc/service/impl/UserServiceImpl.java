package com.zxc.service.impl;

import com.zxc.mapper.UserMapper;
import com.zxc.pojo.Users;
import com.zxc.service.UserService;
import com.zxc.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * User: zxc
 * Date: 2021/01/19 10:40
 * Description:  在此类中进行用户的相关业务逻辑处理
 * Version: V1.0
 */
@Service  //注解
public class UserServiceImpl implements UserService {
    //进行业务逻辑处理后，还得传递给数据访问层（mapper,mybits）进行相关操作
    @Autowired(required = false)  //如果没有依赖，返回空
    private UserMapper userMapper;


    @Override
    public int addUser(Users user) {

        try {
            //密码加密：通过MD5加密
            String new_pwd= MD5.getMD5(user.getUser_pwd()).toString();
            //将加密后的密文再次赋给传递的对象，将原来的明文替换为加密后的密码
            user.setUser_pwd(new_pwd);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return userMapper.addUser(user);
    }

    @Override
    public Users findUserByTelAndPwd(Users user) throws NoSuchAlgorithmException {


            //密码加密：通过MD5加密
            String new_pwd= MD5.getMD5(user.getUser_pwd()).toString();
            //将加密后的密文再次赋给传递的对象，将原来的明文替换为加密后的密码
            user.setUser_pwd(new_pwd);


        return userMapper.findUserByTelAndPwd(user);
    }

    @Override
    public Users queryByUser_tel(Users user) {
        return userMapper.queryByUser_tel(user);
    }
}
