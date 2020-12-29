//package com.transwrap.transwrap.aspect;
//
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//
////@Aspect
////@Component
//public class AuthorityVerification {
//
//    @Resource
//    HttpServletRequest httpServletRequest;
//
//    @Before(value = "execution(* com.transwrap.transwrap.control.*.*(..))")
//    public void commonOperatorValid(){
//        httpServletRequest.getCookies();
//    }
//
//
//
//}
