package com.example.shppyad18.PostOffice;

import com.example.shppyad18.Departure.Departure;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post_offices_table")
public class PostOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "postOffice", cascade = CascadeType.ALL)
    private List<Departure> departureList = new ArrayList<>();

    public PostOffice() {}

    public PostOffice(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String get() {
        return name;
    }

    public void set(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Departure> getDepartureList() {
        return departureList;
    }

    public void setDepartureList(List<Departure> departureList) {
        this.departureList = departureList;
    }

    public void addDeparture(Departure departure) {
        this.departureList.add(departure);
    }
}
