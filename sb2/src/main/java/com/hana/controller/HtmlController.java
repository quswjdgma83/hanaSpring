package com.hana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/html")
public class HtmlController {
    String dir= "html/";
    @RequestMapping("/")
    public String main(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center",dir+"center");
        return "index";
    }
    @RequestMapping("/html1")
    public String html1(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center",dir+"html1");
        return "index";
    }
    @RequestMapping("/html2")
    public String html2(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center",dir+"html2");
        return "index";
    }
    @RequestMapping("/html3")
    public String html3(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center",dir+"html3");
        return "index";
    }
}
