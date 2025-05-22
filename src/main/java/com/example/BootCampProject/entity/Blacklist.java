package com.example.BootCampProject.entity;

import com.example.BootCampProject.common.entity.BaseEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;

@Entity
@Table(name = "blacklist")
@SQLRestriction(value = "deleted_at IS NULL")
public class Blacklist extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "reason")
    private String reason;
    @Column(name = "date")
    private LocalDateTime date;
    @ManyToOne()
    @JoinColumn(name = "applicantId")
    private Applicant applicant;

    public Blacklist() {
    }

    public Blacklist(int id, String reason, LocalDateTime date, Applicant applicant) {
        this.id = id;
        this.reason = reason;
        this.date = date;
        this.applicant = applicant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @PrePersist
    protected void onCreate() {
        this.date = LocalDateTime.now();
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }
}

