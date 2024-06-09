package com.example.theerastour.Service.impl;

import com.example.theerastour.Entities.Bill;
import com.example.theerastour.Entities.Member;
import com.example.theerastour.Entities.Ticket;
import com.example.theerastour.Entities.Tour;
import com.example.theerastour.Repository.BillRepository;
import com.example.theerastour.Service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    BillRepository billRepository;
    @Override
    public int save(Member member, int ticket, Double price){
        Bill bill = new Bill(ticket,price,member);
        billRepository.save(bill);
        return (int)bill.getId();
    }

    @Override
    public Bill findBilById(int id){
        return billRepository.findBillById(id);
    }

    @Override
    public void update(int billId, List<Ticket> ticketList){
        Bill bill = billRepository.findBillById(billId);
        bill.setTickets(ticketList);
        billRepository.save(bill);
    }
}
