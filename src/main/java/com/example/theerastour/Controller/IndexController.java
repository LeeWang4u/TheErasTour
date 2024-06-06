package com.example.theerastour.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String showHome() {
        return "home/index";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin/index";
    }
}
