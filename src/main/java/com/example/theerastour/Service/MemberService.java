package com.example.theerastour.Service;
import com.example.theerastour.Entities.Member;
import com.example.theerastour.Entities.Roles;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {
    List<Member> getMemberByRole(String Role);

}
