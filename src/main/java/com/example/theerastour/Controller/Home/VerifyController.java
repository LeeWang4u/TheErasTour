package com.example.theerastour.Controller.Home;

import com.example.theerastour.Service.MailerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class VerifyController {

    @Autowired
    private MailerService mailerService;

    @GetMapping("/verify")
    public String verify(){
        return "home/verify";
    }

//    @PostMapping("/verify")
//    public String verifyCode()
}
