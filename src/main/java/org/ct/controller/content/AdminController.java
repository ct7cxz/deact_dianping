package org.ct.controller.content;

import org.ct.bean.SysUser;
import org.ct.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/admin")
@SessionAttributes
public class AdminController {

    @Autowired
    private ISysUserService userService;

    /**
     * 登录
     * @return
     */
    @RequestMapping(path = "/login")
    public String login(SysUser user, HttpSession session){
        if(userService.findSysUser(user)){
            session.setAttribute("user",user);
            return "redirect:/index";
        }else {
            return "redirect:/index/login";
        }
    }
}
