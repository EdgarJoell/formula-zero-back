package com.example.formulazero.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "experiences")
public class Experience {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String trackName;

    @Column
    private String country;

    @Column
    private String date;

    @Column
    private double price;

    @Column
    private String imageString;

    @Column
    private String time;

    @Column
    private String car;

    @OneToMany(mappedBy = "experience", orphanRemoval = true)
    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<User> userList;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public Experience() {
    }

    public Experience(Long id, String trackName, String country,  String date, double price) {
        this.id = id;
        this.trackName = trackName;
        this.country = country;
        this.date = date;
        this.price = price;
    }

    public Experience(Long id, String trackName, String country,  String date, double price, String imageString) {
        this.id = id;
        this.trackName = trackName;
        this.country = country;
        this.date = date;
        this.price = price;
        this.imageString = imageString;
    }

    public Experience(Long id, String trackName, String date, double price, String time, String car, List<User> userList) {
        this.id = id;
        this.trackName = trackName;
        this.date = date;
        this.price = price;
        this.time = time;
        this.car = car;
        this.userList = userList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public String getImageString() { return imageString; }

    public void setImageString(String imageString) { this.imageString = imageString; }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", trackName='" + trackName + '\'' +
                ", date='" + date + '\'' +
                ", price=" + price +
                ", time='" + time + '\'' +
                ", car='" + car + '\'' +
                '}';
    }
}
