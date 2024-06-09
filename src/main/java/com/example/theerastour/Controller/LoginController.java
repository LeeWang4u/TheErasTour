package com.example.theerastour.Controller;

import com.example.theerastour.Entities.Ticket;
import com.example.theerastour.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LoginController {
    @Autowired
    TicketService ticketService;

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {
        return "login/login";
    }
    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "login/access-denied";
    }

    @GetMapping("/acc")
    public String acc(Model model){
        List<Ticket> ticketList = ticketService.findAll();
        model.addAttribute("ticketList",ticketList);
        return "login/acc-management";
    }
}

