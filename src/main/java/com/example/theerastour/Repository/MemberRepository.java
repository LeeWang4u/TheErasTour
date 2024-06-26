package com.example.theerastour.Repository;

import com.example.theerastour.Entities.Member;
import com.example.theerastour.Entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

//    @Query(
//            value =" select m from Member as m join Bill as b on b.userId = m.userId " +
//                    "join Ticket as ti on b.id = ti.billId where ti.tourId = ?1  " //+
//            // "join Tour as to on to.id = ti.tourId"
//            ,nativeQuery = true
//    )
//    List<Member> findByIdTourOrderByUserIdDesc(int TourId);
//
//    @Query(
//            value =" select m from Member as m where m.roles = ?1"
//            ,nativeQuery = true
//    )
//    List<Member> findAllByRolesId(String roleID);

//    @Query("select m from Member as m join  Roles as r   on m.userId = r.userId where r.role = ?1")
//    @Query("SELECT m FROM Member m JOIN m.roles r WHERE r.role = ?1")
    @Query("SELECT m FROM Member m JOIN m.roles r WHERE r.role = :role")
    List<Member> getAllMemberByRole(@Param("role") String role);

    // List<Member> findByIdOrderByUserIdDesc(Bill bill);

    Member getMemberByUserId(String user_id);

    Member findAllByUserId(String id);


}