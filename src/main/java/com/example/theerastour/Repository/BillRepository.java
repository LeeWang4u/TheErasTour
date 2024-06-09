package com.example.theerastour.Repository;

import com.example.theerastour.Entities.Bill;
import com.example.theerastour.Entities.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Long> {

    Bill findBillById(int id);

    @Query("SELECT b FROM Bill b JOIN b.userId m WHERE m.userId = :id")
    List<Bill> findAllByUserId(@Param("id") String id);

    List<Bill> findAll();


    List<Bill> findByIdOrderByIdDesc(Tour tour);

}