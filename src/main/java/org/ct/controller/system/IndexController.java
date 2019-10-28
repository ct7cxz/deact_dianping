package org.ct.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 建立初始化页面
 */
@RequestMapping(path = "/index")
@Controller
public class IndexController {

    @RequestMapping(path = "/login")
    public String login(){
        return "system/login";
    }

    @RequestMapping
    public String index(){
        return "/system/index";
    }

    /*将请求转发到list页面*/
    @RequestMapping(path = "/list")
    public String toList(){
        return "content/list";
    }

    /*将请求转发到新增广告页面*/
    @RequestMapping(path = "/addAd")
    public String toModify(){
        return "content/addAd";
    }

    /*将请求转发表广告的列表页面*/
    @RequestMapping(path = "/listAd")
    public String listAd(){
        return "redirect:/ad";
    }

    /*将请求转发到商户管理列表界面*/
    @RequestMapping(path = "/listBusiness")
    public String listBusiness(){
        return "redirect:/business";
    }

}
