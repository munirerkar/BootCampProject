package com.example.BootCampProject.entity;

import com.example.BootCampProject.common.entity.BaseEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

@Entity
@Table(name = "instructors")
@SQLRestriction(value = "deleted_at IS NULL")
public class Instructor extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "companyName")
    private String companyName;
    @ManyToOne()
    @JoinColumn(name = "userId")
    private User user;
    @OneToMany(mappedBy = "instructor")
    private List<Bootcamp> bootcamps;

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
