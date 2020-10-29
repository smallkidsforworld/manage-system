package com.transwrap.transwrap.repository;

import com.transwrap.transwrap.mapper.UserMapper;
import com.transwrap.transwrap.po.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：yml
 * @date ：Created in 2020/10/29 15:25
 * @description：用戶操作类
 * @modified By：
 */
@Repository
public class UserRepo {

    @Resource
    UserMapper userMapper;

    public List<User> getAllUser(){
        return userMapper.getAllUser();
    }

    public User getUserById(String user_id){
        return userMapper.queryByProductType(user_id);
    }

}
