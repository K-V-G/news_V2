package ru.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "news_v2")
@Getter
@Setter
@Data
public class News {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "short_descr")
    private String shortDescription;
    @Column(name = "full_descr")
    private String fullDescription;

    private String type;
}
