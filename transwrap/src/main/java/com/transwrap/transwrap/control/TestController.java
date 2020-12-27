package com.transwrap.transwrap.control;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping(value = "/test_all_response")
    public String hello() {
        return "hello";
    }

    @PutMapping(value = "/test_put")
    public String paramers(@RequestParam String send_info, @RequestParam String send_id) {
        return "success";
    }

    @GetMapping(value = "/test.jsp")
    public String testURL() {
        return "Success";
    }



}
