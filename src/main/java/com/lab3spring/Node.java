package com.lab3spring;

import javax.persistence.*;
// Это сама модель. Если быть точнее - объекто-ориентированное отражение реляционной модели из БД
@Entity
@Table(name = "node")
public class Node {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "country")
    private String country;
    @Column(name = "status")
    private boolean status;

    public Node() {

    }

    public Node(String name, String country, boolean status) {
        this.name = name;
        this.country = country;
        this.status = status;
    }

    public Node(Integer id, String name, String country, boolean status) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.status = status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public boolean getStatus() {
        return status;
    }
}
