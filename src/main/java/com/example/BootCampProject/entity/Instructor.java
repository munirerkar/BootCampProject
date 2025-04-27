package com.example.BootCampProject.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "instructors")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "companyName")
    private String companyName;
    @ManyToOne()
    @JoinColumn(name = "userId")
    private User user;

    public Instructor() {
    }

    public Instructor(int id, String companyName, User user) {
        this.id = id;
        this.companyName = companyName;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
