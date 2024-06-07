package com.example.theerastour.Controller.Home;

import com.example.theerastour.Entities.Tour;
import com.example.theerastour.Service.TourService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tour")
@AllArgsConstructor
public class TourController {
    @Autowired
    TourService tourService;

    @GetMapping("/us-tour")
    public String showUsTour(Model model){
        List<Tour> tourList = tourService.findAllByType("US");
        model.addAttribute("tourList",tourList);
        return "home/us-tour";
    }

    @GetMapping("/international-tour")
    public String showInternationalTour(Model model){
        List<Tour> tourList = tourService.findAllByType("International");
        model.addAttribute("tourList",tourList);
        return "home/international-tour";
    }

    @GetMapping("/micro-tour")
    public String showMicroTour(Model model){
        List<Tour> tourList = tourService.findAllByType("Micro");
        model.addAttribute("tourList",tourList);
        return "home/micro-tour";
    }

    @GetMapping("/streaming")
    public String showStreaming(Model model){
        List<Tour> tourList = tourService.findAllByType("Streaming");
        model.addAttribute("tourList",tourList);
        return "home/streaming";
    }


}
