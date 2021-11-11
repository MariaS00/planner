package com.example.planner.controller;

import com.example.planner.model.Task;
import com.example.planner.model.User;
import com.example.planner.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {

    @NonNull
    private final UserService userService;

    @GetMapping("/users")
    public String getAll(Model model) {
        model.addAttribute("users",userService.getUsers());
        model.addAttribute("newUser",new User());
        return "welcome";
    }

    @PostMapping("/add-user")
    public String addUser(@ModelAttribute User user){
        userService.createUser(user.getName());
        return "redirect:/users";
    }
}
