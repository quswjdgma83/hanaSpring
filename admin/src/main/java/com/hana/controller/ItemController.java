package com.hana.controller;

import com.hana.app.data.dto.ItemDto;
import com.hana.app.service.ItemService;
import com.hana.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/item")
@RequiredArgsConstructor
@Slf4j
public class ItemController {
    String dir = "item/";
    private final ItemService itemService;

    @Value("${app.dir.imgdir}")
    String imgdir;

    @Value("${app.dir.imgsave}")
    String imgsave;
    @RequestMapping("/add")
    public String add(Model model) throws Exception{
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

    @RequestMapping("/updateimpl")
    public String updateimpl(Model model, ItemDto itemDto) throws Exception{
        //이미지 X
        if(itemDto.getImage().isEmpty()){
            itemDto.setImgName( itemDto.getImage().getOriginalFilename());
        } else{
            String oldimg = itemDto.getImgName();
            itemDto.setImgName(itemDto.getImage().getOriginalFilename());
            itemService.modify(itemDto);

            FileUploadUtil.saveFile(itemDto.getImage(),imgsave);
            FileUploadUtil.deleteFile(oldimg,imgsave);
        }
        //이미지 저장
        return "redirect:/item/detail?id="+itemDto.getItemId();
    }

//    @RequestMapping("/updateimpl")
//    public String updateimpl(Model model, ItemDto itemDto, @RequestParam("image") MultipartFile newImage) throws Exception{
//        // 이미지를 새로 넣었을 때
//        if(!newImage.isEmpty()){
//            // 새 이미지가 있으면, 새 이미지의 이름으로 설정
//            itemDto.setImgName(newImage.getOriginalFilename());
//            // 이미지 파일 저장
//            FileUploadUtil.saveFile(newImage, imgsave);
//        }
//        // 아이템 정보 수정 (이미지가 변경되었든 안 되었든 상관없이 호출)
//        itemService.modify(itemDto);
//
//        // 이미지를 새로 넣지 않았을 경우에 대한 별도의 처리는 필요하지 않음
//        // 이 경우, itemDto에 이미 설정된 이미지 이름이 그대로 사용됩니다.
//
//        return "redirect:/item/detail?id=" + itemDto.getItemId();
//    }


    @RequestMapping("/get")
    public String get(Model model) throws Exception{
        List<ItemDto> list = new ArrayList<>();
        try {
            list = itemService.get();
            model.addAttribute("itemList",list);
            model.addAttribute("center",dir+"get");
        } catch (Exception e) {
            throw new Exception("EI001");
        }
        return "index";
    }

    @RequestMapping("/detail")
    public String detail(Model model, @RequestParam("id") int id) throws Exception{
        ItemDto itemDto = null;
        try {
            itemDto = itemService.get(id);
            model.addAttribute("item",itemDto);
            model.addAttribute("center",dir+"detail");
        } catch (Exception e) {
            throw new Exception("EI001");
        }
        return "index";
    }
}
