package com.transwrap.transwrap.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.transwrap.transwrap.entity.ItemCache;
import com.transwrap.transwrap.po.User;
import com.transwrap.transwrap.repository.UserRepo;
import com.transwrap.transwrap.utils.ApiResult;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

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

    private final ItemCache<User> itemCache = new ItemCache<>();
    private final ItemCache<String> phoneCache = new ItemCache<>();

    @Resource
    UserRepo userRepo;

    public ApiResult getAllUserInfo() {
        List<User> userList = userRepo.getAllUser();
        if (userList == null)
            ApiResult.fail("无法查询到数据");
        return ApiResult.success(userList);
    }

    public ApiResult getUserInfoById(String user_id) {
        if (!itemCache.containsObject(user_id)) {
            User user = userRepo.getUserById(user_id);
            if (user == null)
                ApiResult.fail("没有对应的用户");
        }
        return ApiResult.success(itemCache.getCached(user_id));
    }


    public ApiResult userLogin(String password, String user_id) {
        User user;
        if (!itemCache.containsObject(user_id)) {
            if (!phoneCache.containsObject(user_id)) {
                user = userRepo.getUserById(user_id);
                if (user == null) {
                    user = userRepo.getUserByPhone(user_id);
                    phoneCache.updateCache(user_id, String.valueOf(user.getId()));
                    itemCache.updateCache(String.valueOf(user.getId()), user);
                } else
                    itemCache.updateCache(user_id, user);
            } else
                user = itemCache.getCached(phoneCache.getCached(user_id));
        } else
            user = itemCache.getCached(user_id);
        if (DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())) {
            return ApiResult.success("the password is right!");
        } else
            return ApiResult.fail("the password is wrong!");
    }

    public ApiResult userAuthorityUpdate(String id, String user_authority)  {
        userRepo.updateStatus(id, user_authority);
        itemCache.getCached(id).setUserAuthority(Long.parseLong(user_authority));
        itemCache.updateCache(id, itemCache.getCached(id));
        return ApiResult.success();
    }

    public PageInfo testThePageHelper(){
        PageHelper.startPage(1,10);
        return PageInfo.of(userRepo.getAllUser());
    }

}
