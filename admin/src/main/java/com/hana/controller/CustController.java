package com.hana.controller;

import com.hana.app.data.dto.AddrDto;
import com.hana.app.data.dto.CustDto;
import com.hana.app.service.CustService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cust")
@RequiredArgsConstructor
public class CustController {
    String dir = "cust/";
    final CustService custService;


    @RequestMapping("/get")
    public String get(Model model) throws Exception{
        List<CustDto> list = new ArrayList<>();
        try {
            list = custService.get();
            model.addAttribute("custs", list);
            model.addAttribute("center", dir + "get");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "index";
    }

    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("center", dir+"add");
        return "index";
    }

    @RequestMapping("/addimpl")
    public String addimpl(Model model, CustDto custDto) throws Exception {
        // Database에서 데이터를 가지고 온다.
        try {
            custService.add(custDto);
            return "redirect:/cust/detail?id="+custDto.getId();
        } catch (Exception e) {
            throw new Exception("ER0001");
        }
    }

    @RequestMapping("/detail")
    public String detail(Model model, @RequestParam("id") String id) {
        // Database에서 데이터를 가지고 온다.
        CustDto custDto = null;
        try {
            custDto = custService.get(id);
            model.addAttribute("cust", custDto);
            model.addAttribute("center", dir + "detail");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "index";
    }

    @RequestMapping("/update")
    public String update(Model model, CustDto custDto) {
        // Database에서 데이터를 가지고 온다.
        try {
            custService.modify(custDto);
            return "redirect:/cust/detail?id="+custDto.getId();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/delete")
    public String delete(Model model, @RequestParam("id") String id) {
        // Database에서 데이터를 가지고 온다.
        try {
            custService.del(id);
            return "redirect:/cust/get";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
