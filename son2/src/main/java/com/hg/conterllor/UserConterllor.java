package com.hg.conterllor;

import com.hg.entity.User;
import com.hg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by 888 on 2019/11/14.
 */
@Controller
@RequestMapping("user")
public class UserConterllor {
    @Autowired
    private UserService userService;

    @RequestMapping("login.do")
    public ModelAndView login(String username, String password, HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        User u = userService.queryByUsernameAndPassword(username, password);
        if (u != null) {
            session.setAttribute("user",u);
            mv.setViewName("redirect:/jsp/main.jsp");
        } else {
            mv.addObject("mass", "密码或用户名有误");
            mv.setViewName("forward:/jsp/login.jsp");
        }
        return mv;
    }
}
