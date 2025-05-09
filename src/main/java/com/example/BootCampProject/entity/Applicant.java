package com.example.BootCampProject.entity;

import jakarta.persistence.*;

import java.util.List;

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
    @OneToMany(mappedBy = "applicant")
    private List<Application> applications;
    @OneToMany(mappedBy = "applicant")
    private List<Blacklist> blacklists;

    public Applicant() {
    }

    public Applicant(int id, String about, User user, List<Application> applications, List<Blacklist> blacklists) {
        this.id = id;
        this.about = about;
        this.user = user;
        this.applications = applications;
        this.blacklists = blacklists;
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

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    public List<Blacklist> getBlacklists() {
        return blacklists;
    }

    public void setBlacklists(List<Blacklist> blacklists) {
        this.blacklists = blacklists;
    }

}
