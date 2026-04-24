package com.fundoonotes.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "notes")
@Data
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId; // important (no relation mapping)

    private String title;

    private String content;

    private boolean isPinned = false;

    private boolean isArchived = false;

    private boolean isTrashed = false;
}