package com.example.theerastour.Repository;

import com.example.theerastour.Entities.Ticket;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    @Transactional
    List<Ticket> findAll();

    //List<Ticket> findAllByBillId(int billId);
}