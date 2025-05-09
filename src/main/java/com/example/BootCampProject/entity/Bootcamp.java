package com.example.BootCampProject.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "bootcamp")
public class Bootcamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToOne()
    @JoinColumn(name = "instructorId")
    private Instructor instructor;
    @Column(name = "startDate")
    private Date startDate;
    @Column(name = "endDate")
    private Date endDate;
    @OneToMany(mappedBy = "bootcamp")
    private List<Application> applications;
    @Column(name = "bootcampState")
    @Enumerated(EnumType.ORDINAL)
    private BootcampState bootcampState;
    public enum BootcampState {
        PREPARING,
        OPEN_FOR_APPLICATION,
        IN_PROGRESS,
        FINISHED,
        CANCELLED
    }

    public Bootcamp() {
    }

    public Bootcamp(int id, String name, Instructor instructor, Date startDate, Date endDate, List<Application> applications, BootcampState bootcampState) {
        this.id = id;
        this.name = name;
        this.instructor = instructor;
        this.startDate = startDate;
        this.endDate = endDate;
        this.applications = applications;
        this.bootcampState = bootcampState;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    public BootcampState getBootcampState() {
        return bootcampState;
    }

    public void setBootcampState(BootcampState bootcampState) {
        this.bootcampState = bootcampState;
    }
}
