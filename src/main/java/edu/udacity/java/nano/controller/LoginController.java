package edu.udacity.java.nano.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam String username, Model model){
        model.addAttribute("username", username);
        model.addAttribute("webSocketUrl", "ws://localhost:8080/chat/" + username);
        return "/chat";
    }

}