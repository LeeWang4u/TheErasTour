package com.example.theerastour.Repository;

import com.example.theerastour.Entities.Member;
import com.example.theerastour.Entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RolesRepository extends JpaRepository<Roles, Long> {

    @Query("select r from Roles as r join Member as m on m.userId = r.userId where r.userId = ?1")
    List<Roles> getAllByRole(String role);

}