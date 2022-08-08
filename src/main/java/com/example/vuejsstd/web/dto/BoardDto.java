package com.example.vuejsstd.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDto implements Serializable {
    private Long id;
    private String title;
    private String contents;
    private String author;
    private String createdAt;
}
