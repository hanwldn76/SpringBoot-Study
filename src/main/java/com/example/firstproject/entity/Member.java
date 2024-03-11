package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Member {
    @GeneratedValue
    @Id
    private Long id;
    @Column
    private String email;
    @Column
    private String password;

    public Long getId() {
        return id;
    }
}
