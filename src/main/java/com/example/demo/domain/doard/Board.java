package com.example.demo.domain.doard;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "board_title")
    private String title;

    @NotNull
    @Column(name = "board_content")
    private String content;

    public void update(String name, String title, String content){
        this.name=name;
        this.title=title;
        this.content=content;
    }
}
