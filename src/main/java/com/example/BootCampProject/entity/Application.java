package com.example.BootCampProject.entity;

import com.example.BootCampProject.common.entity.BaseEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "applications")
@SQLRestriction(value = "deleted_at IS NULL")
public class Application extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne()
    @JoinColumn(name = "applicantId")
    private Applicant applicant;
    @ManyToOne()
    @JoinColumn(name = "bootcampId")
    private Bootcamp bootcamp;
    @Column(name = "applicationState")
    @Enumerated(EnumType.ORDINAL)
    private ApplicationState applicationState;
    public enum ApplicationState {
        PENDING,
        APPROVED,
        REJECTED,
        IN_REVIEW,
        CANCELLED
    }

    public Application() {
    }

    public Application(int id, Applicant applicant, Bootcamp bootcamp, ApplicationState applicationState) {
        this.id = id;
        this.applicant = applicant;
        this.bootcamp = bootcamp;
        this.applicationState = applicationState;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Bootcamp getBootcamp() {
        return bootcamp;
    }

    public void setBootcamp(Bootcamp bootcamp) {
        this.bootcamp = bootcamp;
    }

    public ApplicationState getApplicationState() {
        return applicationState;
    }

    public void setApplicationState(ApplicationState applicationState) {
        this.applicationState = applicationState;
    }
}
