package com.example.onlinevote.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "vote_items")
public class VoteItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int count = 0;
}
