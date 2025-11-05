package com.controller;


import com.bean.Login;
import com.service.LogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogInController {

    @Autowired
    LogInService ls;

    @RequestMapping("/")
    public ModelAndView homePage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index.jsp");
        return mv;
    }

    @RequestMapping(value = "signup",method = RequestMethod.GET)
    public ModelAndView showSignup(){
        ModelAndView mv = new ModelAndView();

        mv.setViewName("signup.jsp");

        return mv;
    }

    @RequestMapping(value = "signin",method = RequestMethod.GET)
    public ModelAndView showSignin(){
        ModelAndView mv = new ModelAndView();

        mv.setViewName("signin.jsp");

        return mv;
    }

    @RequestMapping(value = "signout",method = RequestMethod.GET)
    public ModelAndView signout(){
        ModelAndView mv = new ModelAndView();

        mv.setViewName("index.jsp");

        return mv;
    }


    @RequestMapping(value = "signup",method = RequestMethod.POST)
    public ModelAndView signUp(HttpServletRequest req){
        ModelAndView mv = new ModelAndView();
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Login ll = new Login();
        ll.setEmail(email);
        ll.setPassword(password);

        String message = ls.signUp(ll);

        if(message.equals("Account created successfully")){
            mv.addObject("success", "Signup successful! Please Login");
        }else{
            mv.addObject("error", "Signup failed. Please try again.");
        }
        mv.setViewName("index.jsp");

        return mv;
    }

    @RequestMapping(value = "signin",method = RequestMethod.POST)
    public ModelAndView signIn(HttpServletRequest req){
        ModelAndView mv = new ModelAndView();
        String emailId = req.getParameter("email");
        String password = req.getParameter("password");

        Login ll = new Login();
        ll.setEmail(emailId);
        ll.setPassword(password);

        String message = ls.signIn(ll);
        if(message.equals("Successfully logged in")){
            mv.addObject("user",emailId.substring(0,emailId.indexOf('@')));
            mv.setViewName("home.jsp");
        }else {
            mv.addObject("error","Signin failed. Please try again.");
            mv.setViewName("signin.jsp");
        }
        return mv;
    }
}
