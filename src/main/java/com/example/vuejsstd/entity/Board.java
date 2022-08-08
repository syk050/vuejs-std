package com.example.vuejsstd.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String title;
    private String contents;
    private String author;
    private LocalDateTime createdat;

    @Builder
    public Board(String title, String contents, String author, LocalDateTime createdat) {
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.createdat = createdat;
    }
}
