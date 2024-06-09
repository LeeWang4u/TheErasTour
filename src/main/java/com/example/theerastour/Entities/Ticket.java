package com.example.theerastour.Entities;
import jakarta.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @Column(name = "id")
    private String id;
    @ManyToOne(fetch=FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="tour_id")
    private Tour tourId;
    @Column(name ="type")
    private String type;
    @Column(name = "price")
    private double price;
    @Column(name = "status")
    private Boolean status;
    @ManyToOne(fetch=FetchType.LAZY,cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name ="bill_id")
    private Bill billId;
    public Ticket() {
    }
    public Ticket(Tour tourId, String type, double price, Bill billId) {
        this.tourId = tourId;
        this.type = type;
        this.price = price;
        this.billId = billId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Tour getTourId() {
        return tourId;
    }

    public void setTourId(Tour tourId) {
        this.tourId = tourId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Bill getBillId() {
        return billId;
    }

    public void setBillId(Bill billId) {
        this.billId = billId;
    }
}
