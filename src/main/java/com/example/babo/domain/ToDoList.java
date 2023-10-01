package com.example.babo.domain;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ToDoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT", length = 200)
    private String content;

    private LocalDateTime createDate;

    @Column(nullable = false)
    private Boolean completed;

    @PrePersist
    public void prePersist() {
        this.createDate = LocalDateTime.now();
    }

}
