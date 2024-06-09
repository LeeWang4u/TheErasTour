package com.example.theerastour.Repository;

import com.example.theerastour.Entities.Bill;
import com.example.theerastour.Entities.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Long> {

    Bill findBillById(int id);


    List<Bill> findAll();


    List<Bill> findByIdOrderByIdDesc(Tour tour);

}