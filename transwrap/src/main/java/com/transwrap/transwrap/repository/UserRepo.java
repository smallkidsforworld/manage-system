package com.transwrap.transwrap.repository;

import com.transwrap.transwrap.entity.ItemCache;
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

    private final ItemCache<User> itemCache = new ItemCache<>();

    @Resource
    UserMapper userMapper;

    public List<User> getAllUser(){
        return userMapper.getAllUser();
    }

    public User getUserById(String user_id){
        return userMapper.queryByUserId(user_id);
    }

    public User getUserByPhone(String phone){
        return userMapper.queryByPhone(phone);
    }

    public boolean updateStatus(String id,String user_authority) {
        userMapper.updateStatus(id,user_authority);


        return true;
    }

}
