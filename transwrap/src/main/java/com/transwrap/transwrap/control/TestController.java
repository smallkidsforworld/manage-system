package com.transwrap.transwrap.control;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Api(tags = "测试功能")
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping(value = "/test_all_response")
    public String hello() {
        return "hello";
    }

    @PutMapping(value = "/test_put")
    public String testRequestParam(@RequestParam String send_info, @RequestParam String send_id) {
        return "success " + "send_id" + send_id + " send_info " + send_info;
    }

    @GetMapping(value = "/test.jsp")
    public String testURL() {
        return "Success";
    }

    @GetMapping(value = "/testError")
    public void testError() throws Exception {
        throw new Exception("test throw exception");
    }

    @GetMapping(value="/test_ip_address")
    public String testIpAddress(@RequestParam HttpServletRequest httpServletRequest){
        return httpServletRequest.getRemoteAddr();
    }


}
