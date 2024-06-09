package com.example.theerastour.Service.impl;

import com.example.theerastour.Entities.Member;
import com.example.theerastour.Entities.Roles;
import com.example.theerastour.Repository.MemberRepository;
import com.example.theerastour.Service.MemberService;
import com.example.theerastour.Service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberRepository memberRepository;

    @Override


    public List<Member> getMemberByRole(String Role){
        List<Member> members = memberRepository.getAllMemberByRole(Role);
        if (members == null) {
            return List.of();
        }
        return members;
    }

    @Override
    public Member getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Member member = new Member();
            member.setUserId(userDetails.getUsername());
          //  member.setUsername(userDetails.getUsername());
            // Gán các thông tin khác của member từ UserDetails nếu cần
            return member;
        }
        return null;
    }
}
