package com.example.theerastour.Controller.Admin;

import com.example.theerastour.Entities.Member;
import com.example.theerastour.Entities.Roles;
import com.example.theerastour.Entities.Tour;
import com.example.theerastour.Service.MemberService;
import com.example.theerastour.Service.RolesService;
import com.example.theerastour.Service.TourService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class TourAdminController {
    private TourService tourService;
    private RolesService rolesService;
    private MemberService memberService;

    @GetMapping("/admin/tours")
    public String admin(Model model){
        List<Tour> tourList = tourService.findAll();

        model.addAttribute("tourList",tourList);
        return "admin/allTour";
    }

    @GetMapping("/admin/staffs")
    public String showStaff(Model model){
        List<Member> memberList = memberService.getMemberByRole("ROLE_EMPLOYEE");

        model.addAttribute("memberList",memberList);
        return "admin/staffs";
    }



}
