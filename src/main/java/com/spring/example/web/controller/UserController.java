package com.spring.example.web.controller;

import com.spring.example.web.model.User;
import com.spring.example.web.service.UserService;
import com.spring.example.web.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    UserService userService = new UserServiceImpl();

    @GetMapping("/")
    public ModelAndView allUsers() {
        ModelAndView modelAndView = new ModelAndView("all-Users");

        List<User> userList = userService.getAllUsers();
        modelAndView.addObject("userList", userList);

        return modelAndView;
    }

}
