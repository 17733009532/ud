package com.baihi.controller;

import com.baihi.Service.CarouselService;
import com.baihi.entity.Carousel;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("carousel")///carousel/download
public class CarouselController {
    @Autowired
    private CarouselService carouselService;


    @RequestMapping("/uploading")
    public String uploading(String status,String title,MultipartFile addFile, HttpServletRequest request){
        System.out.println("11"+status+"22"+title);
        String realPath =  request.getSession().getServletContext().getRealPath("/upload");
        System.out.println(realPath);
        String name = addFile.getOriginalFilename();
        System.out.println(name);
        new File(realPath).mkdir();
        try {
            addFile.transferTo(new File(realPath+"\\"+name));
            carouselService.inser(new Carousel(UUID.randomUUID().toString().replace("-",""),title,name,status,new Date()));
            return "redirect:/carousel/querall";
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "add";
    }


    @RequestMapping("querall")
    public String querall(Model model){
        model.addAttribute("querall",carouselService.selectAll());
        return "index";
    }

    @RequestMapping("/download")
    public void download(HttpServletRequest request, HttpServletResponse response,String url){
        System.out.println("进入并传入了一个文件名"+url);
        //根据文件名，到文件储存位置加载到一个文件
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        File file = new File(realPath+"/"+url);
        try {
            //以流的方式，以附件的方式响应出去
            //用iso-8859-1传输，空格和横杠都能传
            url=new String (url.getBytes("utf-8"),"iso-8859-1");
            //设置响应头部信息，指定以附件的方式响应内容,如果不设置，或者设置错误，不会下载，会直接播放音频
            response.setHeader("content-disposition", "attachment;filename="+url);
            //把File转换成响应输出流
            FileUtils.copyFile(file, response.getOutputStream());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
