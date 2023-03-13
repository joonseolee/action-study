package com.joonseolee.actionstudy.module;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Table
@Getter
public class Company {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "company")
    private List<Employee> employees;

    public Company() {}

    public Company(String name) {
        this.name = name;
    }
}
