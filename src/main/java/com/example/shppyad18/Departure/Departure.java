package com.example.shppyad18.Departure;

import com.example.shppyad18.PostOffice.PostOffice;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "departures_table")
public class Departure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    @Column(name = "date")
    private String date;

    @ManyToOne
    @JsonIgnore
    private PostOffice postOffice;

    public Departure() {}

    public Departure(String type, String date) {
        this.type = type;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public PostOffice getPostOffice() {
        return postOffice;
    }

    public void setPostOffice(PostOffice postOffice) {
        this.postOffice = postOffice;
    }
}