package com.example.theerastour.Controller.Home;

import com.example.theerastour.Entities.Bill;
import com.example.theerastour.Entities.Member;
import com.example.theerastour.Entities.Ticket;
import com.example.theerastour.Entities.Tour;
import com.example.theerastour.Service.BillService;
import com.example.theerastour.Service.MemberService;
import com.example.theerastour.Service.TicketService;
import com.example.theerastour.Service.TourService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tour")
@AllArgsConstructor
public class TourController {
    @Autowired
    TourService tourService;
    @Autowired
    TicketService ticketService;
    @Autowired
    MemberService memberService;
    @Autowired
    BillService billService;

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

    @GetMapping("/tour-details")
    public String tourDetails(@RequestParam("idTour") int idTour, Model model,
                              HttpSession session){

        Tour tour = tourService.findTourById(idTour);
        model.addAttribute(tour);

        session.setAttribute("idTour", idTour);

        return "home/tour-details";
    }

    @PostMapping("/tour-details")
    public String showTourDetails(  HttpSession session, Model model, @RequestParam("vip_quantity") String vip_quantity,
                                    @RequestParam("regular_quantity") String regular_quantity,
                                    @RequestParam("economy_quantity") String economy_quantity){
        int idTour = (int)session.getAttribute("idTour");
        int Vip = Integer.parseInt(vip_quantity);
        int Regular = Integer.parseInt(regular_quantity);
        int Economy = Integer.parseInt(economy_quantity);

        Member member = memberService.getCurrentUser();
        Tour tour = tourService.findTourById(idTour);
        int total = Vip+Regular+Economy;
        double totalPrice = Vip*150 + Regular*100 + Economy*50;
        String billId = billService.save(member,total, totalPrice);
        Bill bill = billService.findBilById(billId);
        List<Ticket> ticketList = new ArrayList<>();
        Ticket ticket;
        if(Vip>0){
            for (int i = 0; i < Vip; i++) {
                ticket = ticketService.save("Vip",150,tour,bill);
                ticketList.add(ticket);
            }
        }
        if(Regular>0){
            for (int i = 0; i < Regular; i++) {
                ticket = ticketService.save("Regular",100,tour,bill);
                ticketList.add(ticket);
            }
        }
        if(Economy>0){
            for (int i = 0; i < Economy; i++) {
                ticket = ticketService.save("Economy",50,tour,bill);
                ticketList.add(ticket);
            }
        }

        billService.update(billId, ticketList);





        model.addAttribute(tour);

        return "home/index";
    }




}
