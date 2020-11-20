package com.ego.controller;

import com.ego.commons.pojo.EgoResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ManageController {

    @RequestMapping("/")
    public String login() {
        System.out.println("执行控制器");
        return "login";
    }

    @RequestMapping("/main")
    public String showIndex() {
        return "index";
    }

    @RequestMapping("/success")
    @ResponseBody
    public EgoResult success() {
        return EgoResult.ok();
    }

    @RequestMapping("/fail")
    @ResponseBody
    public EgoResult fail() {
        return EgoResult.error("账户或密码错误");
    }

}
