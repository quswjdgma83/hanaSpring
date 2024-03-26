package com.hana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/item")
public class ItemController {
    String dir = "item/";

    @RequestMapping("add")
    public String add(Model model) {
        model.addAttribute("centerpage",dir + "add");
        return "main";
    }

    @RequestMapping("get")
    public String get(Model model) {
        model.addAttribute("centerpage",dir + "get");
        return "main";
    }
}
