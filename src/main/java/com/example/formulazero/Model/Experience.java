package com.example.formulazero.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private String date;

    @Column
    private double price;

    @Column
    private String time;

    @Column
    private String car;

    @OneToMany(mappedBy = "experience")
    @JsonIgnore
    private List<User> userList;

    public Experience() {
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
