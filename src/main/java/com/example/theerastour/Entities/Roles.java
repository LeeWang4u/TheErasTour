package com.example.theerastour.Entities;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @Column(name = "user_id", nullable = false)
    private String userId;
    @Column(name = "role")
    private String role;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    private Member member;


    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Roles() {
    }
    public Roles(String userId, String role) {
        this.userId = userId;
        this.role = role;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

//    public List<Member> getMembers() {
//        return members;
//    }
//
//    public void setMembers(List<Member> members) {
//        this.members = members;
//    }
}
