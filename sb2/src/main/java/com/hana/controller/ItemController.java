package com.hana.controller;

import com.hana.app.data.dto.CustDto;
import com.hana.app.data.dto.ItemDto;
import com.hana.app.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {
    String dir= "item/";

    final ItemService itemService;
    @RequestMapping("/")
    public String main(Model model) throws Exception {
        List<ItemDto> list = null;

        list = itemService.get();
        model.addAttribute("items", list);
        model.addAttribute("left", dir+"left");
        model.addAttribute("center",dir+"get");

        return "index";
    }

    @RequestMapping("/detail")
    public String detail(Model model,@RequestParam("id") int id) throws Exception {
        ItemDto itemDto = null;
        itemDto = itemService.get(id);
        model.addAttribute("item", itemDto);
        model.addAttribute("left", dir+"left");
        model.addAttribute("center",dir+"detail");
        return "index";
    }

    @RequestMapping("/get")
    public String get(Model model){
        List<ItemDto> list = null;
        try {
            list = itemService.get();
            model.addAttribute("items", list);
            model.addAttribute("left", dir+"left");
            model.addAttribute("center",dir+"get");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "index";
    }

    @RequestMapping("/add")
    public String add(Model model) throws Exception{
        model.addAttribute("left", dir+"left");
        model.addAttribute("center",dir+"add");
        return "index";
    }

    @RequestMapping("/addimpl")
    public String addimpl(Model model, ItemDto itemDto) throws Exception{
        //데이터 입력
        itemDto.setImgName(itemDto.getImage().getOriginalFilename());
        itemService.add(itemDto);

        return "redirect:/item/get?id="+itemDto.getItemId();
    }

}