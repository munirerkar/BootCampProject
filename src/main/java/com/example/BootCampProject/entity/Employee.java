package com.example.BootCampProject.entity;

import com.example.BootCampProject.common.entity.BaseEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "employees")
@SQLRestriction(value = "deleted_at IS NULL")
public class Employee extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "position")
    private String position;
    @ManyToOne()
    @JoinColumn(name = "userId")
    private User user;

    public Employee() {
    }

    public Employee(int id, String position, User user) {
        this.id = id;
        this.position = position;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

