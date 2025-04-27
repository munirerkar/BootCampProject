package com.example.BootCampProject.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "applicants")
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "about")
    private String about;
    @ManyToOne()
    @JoinColumn(name = "userId")
    private User user;

    public Applicant() {
    }

    public Applicant(int id, String about, User user) {
        this.id = id;
        this.about = about;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
