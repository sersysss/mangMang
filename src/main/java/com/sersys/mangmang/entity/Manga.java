package com.sersys.mangmang.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Manga {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @Column
    private String url;

    @ManyToMany(mappedBy = "mangas")
    private List<User> users = new ArrayList<>();

    public Manga(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
