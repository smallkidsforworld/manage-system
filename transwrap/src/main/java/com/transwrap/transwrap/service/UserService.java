package com.transwrap.transwrap.service;

import com.transwrap.transwrap.po.User;
import com.transwrap.transwrap.repository.UserRepo;
import com.transwrap.transwrap.utils.ApiResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：yml
 * @date ：Created in 2020/10/29 16:02
 * @description：用户服务类
 * @modified By：
 */
@Service
public class UserService {
    @Resource
    UserRepo userRepo;

    public ApiResult getAllUserInfo() {
        List<User> userList = userRepo.getAllUser();
        if (userList == null)
            ApiResult.fail("无法查询到数据");
        return ApiResult.success(userList);
    }

    public ApiResult getUserInfoById(String user_id) {
        User user = userRepo.getUserById(user_id);
        if(user==null)
            ApiResult.fail("没有对应的用户");
        return ApiResult.success(user);
    }

}
