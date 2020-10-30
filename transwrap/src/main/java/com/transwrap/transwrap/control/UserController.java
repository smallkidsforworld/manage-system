package com.transwrap.transwrap.control;

import com.transwrap.transwrap.exception.UserException;
import com.transwrap.transwrap.service.UserService;
import com.transwrap.transwrap.utils.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author ：yml
 * @date ：Created in 2020/10/29 15:38
 * @description：用户接口
 * @modified By：
 */
@Api(tags = "UseOperate")
@RestController
@RequestMapping(value = "/user")
public class UserController {


    @Resource
    UserService userService;

    @ApiOperation("获得全部用户")
    @GetMapping(value = "/getAllUser")
    public ApiResult getAllUser() {
        return userService.getAllUserInfo();
    }

    @ApiOperation("获得单个用户")
    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    public ApiResult getUserById(@RequestParam String user_id) {
        return userService.getUserInfoById(user_id);
    }

    @ApiOperation("用户登录")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ApiResult userLogin(@RequestParam String password, @RequestParam String userId) {
        return userService.userLogin(password,userId);
    }

    @ApiOperation("用户权限修改")
    @RequestMapping(value = "/update/user_authority",method = RequestMethod.POST)
    public ApiResult userAuthorityUpdate(@RequestParam String id, @RequestParam String authority) throws UserException {
        return userService.userAuthorityUpdate(id,authority);
    }


}
