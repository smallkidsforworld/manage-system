package com.transwrap.transwrap.aspect;

import com.google.gson.Gson;
import com.transwrap.transwrap.po.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class AuthorityVerification {

    @Resource
    private HttpServletRequest httpServletRequest;

    @Pointcut(value = "within(com.transwrap.transwrap.control.*)")
    public void control() {
    }

    @Around("control()")
    public Object judgeWhether(ProceedingJoinPoint pjp) throws Throwable {
        Cookie[] cookies = httpServletRequest.getCookies();
        Gson gson = new Gson();
        Map<String, User> map = new HashMap<>();
        if (cookies == null || cookies.length == 0)
            return null;
        for (Cookie cookie : cookies) {
            map.put("user1", gson.fromJson(cookie.getValue(), User.class));
        }
        if (map.get("user1").getUserAuthority() < 3)
            return null;
        return pjp.proceed();
    }


}
