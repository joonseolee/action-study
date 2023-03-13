package com.joonseolee.actionstudy.module;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table
@Getter
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Company company;
}
