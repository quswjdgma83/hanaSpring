package com.hana.controller;

import com.hana.app.data.dto.CustDto;
import com.hana.app.data.dto.RankDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
public class AjaxImplController {
    @RequestMapping("/getservertime")
    public Object getservertime(){
        Date date = new Date();
        return date;
    }

    @RequestMapping("/getdata")
    public Object getdata(){
        List<CustDto> list = new ArrayList<>();
        list.add(new CustDto("id01","pwd01","james"));
        list.add(new CustDto("id01","pwd01","james"));
        list.add(new CustDto("id01","pwd01","james"));
        list.add(new CustDto("id01","pwd01","james"));
        list.add(new CustDto("id01","pwd01","james"));
        return list;
    }

    @RequestMapping("/getrank")
    public Object getrank(){
        List<RankDto> list = new ArrayList<>();
        list.add(new RankDto("집가고싶다1"));
        list.add(new RankDto("집가고싶다2"));
        list.add(new RankDto("집가고싶다3"));
        list.add(new RankDto("집가고싶다4"));
        list.add(new RankDto("집가고싶다5"));
        list.add(new RankDto("집가고싶다6"));
        list.add(new RankDto("집가고싶다7"));
        list.add(new RankDto("집가고싶다8"));
        list.add(new RankDto("집가고싶다9"));
        list.add(new RankDto("집가고싶다10"));

        Collections.shuffle(list);
        return list;
    }


    @RequestMapping("/checkid")
    public Object checkid(@RequestParam("id") String id){
        String result = "1";
        if(id.equals("qqq")){
            result = "0";
        }
        return result;
    }
}
