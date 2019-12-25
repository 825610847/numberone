package com.gt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class PageController {

    @RequestMapping("index")
    public String toIndex()
    {
        return "index";
    }
    @RequestMapping("index2")
    public String toIndex2()
    {
        return "index2";
    }

    @RequestMapping("page/{module}")
    public String toPage(@PathVariable String module, Model model){
        model.addAttribute("type",module);
        return module+"_page";
    }

    @RequestMapping("layer/{module}")
    public String showLayer(@PathVariable String module, Model model){
        return "../commons/"+module+"_layer";
    }
}
