package com.example.theerastour.Service.impl;

import com.example.theerastour.Entities.Member;
import com.example.theerastour.Entities.Roles;
import com.example.theerastour.Repository.MemberRepository;
import com.example.theerastour.Service.MemberService;
import com.example.theerastour.Service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    MemberRepository memberRepository;
    public List<Member> getMemberByRole(String Role){
        List<Member> members = memberRepository.getAllMemberByRole(Role);
        if (members == null) {
            return List.of();
        }
        return members;
    }
}
