package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/user")
    public String showUser(Model model) {
        User user = new User();
        user.setName("Hiroshi");
        user.setAge(41);
        model.addAttribute("user",user);
        return "user";

    }

}
