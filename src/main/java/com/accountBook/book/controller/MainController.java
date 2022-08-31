package com.accountBook.book.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("hello", "Hello SungBin");
        return "index";
    }
}

