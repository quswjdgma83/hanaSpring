package com.hana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //Request를 받아서 처리하는 Spring Container에서 제공하는 클래스
public class MainController {
    @RequestMapping("/")
    public String main() {
        return "main";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("centerpage","login");
        return "main";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("centerpage","register");
        return "main";
    }
}
