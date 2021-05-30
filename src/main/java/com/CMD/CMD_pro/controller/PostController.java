package com.CMD.CMD_pro.controller;

import com.CMD.CMD_pro.domain.PostVO;
import com.CMD.CMD_pro.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostMapper postMapper;

    @RequestMapping("/")
    public String post(){return "post";}

    @RequestMapping("/post")
    public String main(Model model) throws Exception{

        List<PostVO> list = postMapper.selectPostList();

        for(int i = 0; i < list.size(); i++){
            System.out.println("title : " + list.get(i).getPost_title());
            System.out.println("content : " + list.get(i).getPost_content());
        }
        return "redirect:/post";
    }
}
