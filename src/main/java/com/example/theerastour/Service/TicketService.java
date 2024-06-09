package com.example.theerastour.Service;

import com.example.theerastour.Entities.Bill;
import com.example.theerastour.Entities.Ticket;
import com.example.theerastour.Entities.Tour;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketService {

    Ticket save(String type, double price, Tour tourID, Bill billId);

    List<Ticket> findAll();

//    List<Ticket> findAllByBillID(int billId);
}
