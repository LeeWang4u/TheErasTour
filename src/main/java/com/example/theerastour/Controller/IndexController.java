package com.example.theerastour.Controller;

import com.example.theerastour.Entities.Tour;
import com.example.theerastour.Service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    TourService tourService;
    @GetMapping("/")
    public String showHome() {
        return "home/index";
    }

    @GetMapping("/admin")
    public String admin(Model model){
        List<Tour> tourList = tourService.findAllByUpComing();

        model.addAttribute("tourList",tourList);
        return "admin/index";
    }
}
