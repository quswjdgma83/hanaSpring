package com.hana.controller;

import com.hana.app.data.dto.AddrDto;
import com.hana.app.data.dto.CustDto;
import com.hana.app.service.AddrService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
@Slf4j
public class MypageController {
    String dir = "mypage/";
    final AddrService addrService;


    @RequestMapping("/")
    public String main(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center",dir+"center");
        return "index";
    }
    @RequestMapping("/get")
    public String dada(Model model, HttpSession session) {
        try {
            String id = (String) session.getAttribute("id");
            List<AddrDto> addrs = addrService.findByCustId(id);
            model.addAttribute("addrs", addrs);
            model.addAttribute("left", dir + "left");
            model.addAttribute("center", dir + "get");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "index";
    }
    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center",dir+"add");
        return "index";
    }

    @RequestMapping("/addimpl")
    public String addimpl(Model model, AddrDto addrDto, HttpSession session){
        String id = (String) session.getAttribute("id");
        addrDto.setCustId(id);
        log.info("----\n\n"+addrDto.toString()+"\n\n");
        try {
            addrService.add(addrDto);
        } catch (Exception e) {
            //throw new RuntimeException(e);
            model.addAttribute("left", dir+"left");
//            model.addAttribute("center","registerfail");
            return "index";
        }
        return "redirect:/mypage/get";
    }

}
