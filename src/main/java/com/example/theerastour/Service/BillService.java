package com.example.theerastour.Service;

import com.example.theerastour.Entities.Bill;
import com.example.theerastour.Entities.Member;
import com.example.theerastour.Entities.Ticket;
import com.example.theerastour.Entities.Tour;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BillService {
    Bill findBilById(int id);
    int save(Member member, int ticket, Double price);

    void update(int billId, List<Ticket> ticketList);

    List<Bill> findAllByUserId(String id);
}
