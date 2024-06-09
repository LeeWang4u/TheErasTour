package com.example.theerastour.Service.impl;

import com.example.theerastour.Entities.Bill;
import com.example.theerastour.Entities.Ticket;
import com.example.theerastour.Entities.Tour;
import com.example.theerastour.Repository.TicketRepository;
import com.example.theerastour.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketRepository ticketRepository;

    @Override
    public Ticket save(String type, double price, Tour tourID, Bill billId){
        Ticket ticket = new Ticket(tourID,type,price, billId);
        ticketRepository.save(ticket);
        return ticket;
    }

    @Override
    public List<Ticket> findAll(){
        return ticketRepository.findAll();
    }

//    @Override
//    public List<Ticket> findAllByBillID(int billId){
//        return ticketRepository.findAllByBillId(billId);
//    }
}
