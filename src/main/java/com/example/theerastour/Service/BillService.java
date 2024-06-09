package com.example.theerastour.Service;

import com.example.theerastour.Entities.Bill;
import com.example.theerastour.Entities.Member;
import com.example.theerastour.Entities.Ticket;
import com.example.theerastour.Entities.Tour;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BillService {
    Bill findBilById(String is);
    String save(Member member, int ticket, Double price);

    void update(String billId, List<Ticket> ticketList);
}
