package com.example.theerastour.Service.impl;

import com.example.theerastour.Entities.Member;
import com.example.theerastour.Entities.Roles;
import com.example.theerastour.Entities.Tour;
import com.example.theerastour.Repository.RolesRepository;
import com.example.theerastour.Service.RolesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {
    RolesRepository rolesRepository;
    public List<Roles> getMemberByRole(String Role){
        List<Roles> roles = rolesRepository.getAllByRole(Role);
        if (roles == null) {
            return List.of();
        }
        return roles;
    }
}
