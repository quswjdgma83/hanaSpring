package com.hana.controller;

import com.hana.app.data.dto.Chart2Dto;
import com.hana.app.data.dto.CustDto;
import com.hana.app.data.dto.ShopDto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class AjaxImplController {
    @RequestMapping("/getservertime")
    public Object getservertime(){
        Date date = new Date();
        return date;
    }
    @RequestMapping("/geo/getdata")
    public Object geogetdata(){
        List<ShopDto> list = new ArrayList<>();
        list.add(new ShopDto(100,"순대국","a.jpg",37.5547611, 127.0654625));
        list.add(new ShopDto(101,"파스타","b.jpg",37.5747611, 127.0554625));
        list.add(new ShopDto(102,"햄버거","c.jpg",37.5147611, 127.0154625));

        return list;
    }

    @RequestMapping("/geo/seouldata")
    public Object getseouldata(){
        List<ShopDto> list = new ArrayList<>();
        list.add(new ShopDto(100,"순대국","a.jpg",37.5547611, 127.0654625));
//        list.add(new ShopDto(101,"파스타","b.jpg",37.5747611, 127.0554625));
//        list.add(new ShopDto(102,"햄버거","c.jpg",37.5147611, 127.0154625));
        return list;
    }

    @RequestMapping("/geo/busandata")
    public Object getsbusandata(){
        List<ShopDto> list = new ArrayList<>();
        list.add(new ShopDto(100,"순대국","a.jpg",35.1290483, 129.0446982));
//        list.add(new ShopDto(101,"파스타","b.jpg",37.5747611, 127.0554625));
//        list.add(new ShopDto(102,"햄버거","c.jpg",37.5147611, 127.0154625));
        return list;
    }

    @RequestMapping("/geo/jejudata")
    public Object getsjejudata(){
        List<ShopDto> list = new ArrayList<>();
        list.add(new ShopDto(100,"순대국","a.jpg",33.3846216, 126.5534925));
//        list.add(new ShopDto(101,"파스타","b.jpg",37.5747611, 127.0554625));
//        list.add(new ShopDto(102,"햄버거","c.jpg",37.5147611, 127.0154625));
        return list;
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

    @RequestMapping("/checkid")
    public Object checkid(@RequestParam("id") String id){
        String result = "1";
        if(id.equals("qqq")){
            result = "0";
        }
        return result;
    }

    @RequestMapping("/chart2")
    public Object chart2(){
        JSONArray ja = new JSONArray();

        List<Chart2Dto> list = new ArrayList<>();
        // [{},{},{},{},{}]
        list.add(new Chart2Dto("S001",10,20,30,30,10,15));
        list.add(new Chart2Dto("S002",30,10,70,10,0,35));
        list.add(new Chart2Dto("S003",40,40,30,40,20,15));
        list.add(new Chart2Dto("S004",30,70,90,10,100,50));

        list.stream().forEach(c->{
            JSONObject jo = new JSONObject();
            jo.put("name",c.getName());
            jo.put("data", c.getM());
            ja.add(jo);
        });

//        for(Chart2Dto c:list){
//            JSONObject jo = new JSONObject();
//            jo.put("name",c.getName());
//            jo.put("data", c.getM());
//            ja.add(jo);
//        }

        return ja;
    }

    @RequestMapping("/chart3")
    public Object chart3(){
        JSONArray resultArray= new JSONArray();

        List<Chart2Dto> list = new ArrayList<>();

        // [{},{},{},{},{}]
        list.add(new Chart2Dto("S001", 30, 15, 10, 30, 20, 10));
        list.add(new Chart2Dto("S002", 0, 10, 30, 10, 35, 70));
        list.add(new Chart2Dto("S003", 15, 20, 40, 40, 40, 30));
        list.add(new Chart2Dto("S004", 100, 10, 50, 90, 30, 70));
        list.add(new Chart2Dto("S005", 30, 15, 10, 20, 30, 10));
        list.add(new Chart2Dto("S006", 10, 10, 35, 30, 70, 0));
        list.add(new Chart2Dto("S007", 40, 30, 15, 40, 40, 20));
        list.add(new Chart2Dto("S008", 50, 30, 70, 100, 90, 10));
        list.add(new Chart2Dto("S009", 30, 10, 15, 20, 30, 10));
        list.add(new Chart2Dto("S0010", 70, 10, 35, 30, 10, 0));
        list.add(new Chart2Dto("S0011", 40, 30, 40, 40, 20, 15));
        list.add(new Chart2Dto("S0012", 100, 50, 10, 70, 30, 90));


        for (int i = 0; i < list.size(); i += 4) {
            JSONArray ja = new JSONArray(); // 분할된 리스트를 처리할 JSONArray
            List<Chart2Dto> subList = list.subList(i, Math.min(i + 4, list.size())); // 서브리스트 생성

            for (Chart2Dto c : subList) {
                JSONObject jo = new JSONObject();
                jo.put("name", c.getName());
                jo.put("data", c.getM());
                ja.add(jo); // 서브리스트의 각 요소를 처리하여 JSONArray에 추가
            }

            resultArray.add(ja); // 각 분할 처리 결과를 상위 JSONArray에 추가
        }

        return resultArray;
    }

    @RequestMapping("/chart4")
    public Object chart4(@RequestParam("gender") String gender){
        JSONArray ja = new JSONArray();

        List<Chart2Dto> list = new ArrayList<>();
        // [{},{},{},{},{}]
        list.add(new Chart2Dto("f",30,10,10,10,20,20));
        list.add(new Chart2Dto("m",40,10,10,10,10,20));

        list.stream().filter(c->c.getName().equals(gender)).forEach(c->{
            c.getM().stream().forEach(n->{
                JSONArray ja2 = new JSONArray();
                ja2.add("Netflix");
                ja2.add(n);
                ja.add(ja2);
              });
        });
        //{"data":[], "title":"f"}
        JSONObject jo = new JSONObject();
        jo.put("data",ja);
        jo.put("title",gender);
        return jo;
    }
}
