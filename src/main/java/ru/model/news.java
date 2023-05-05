package ru.model;


import javax.persistence.*;

@Entity
@Table(name = "news_v2")
public class news {
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


    public news() {
    }

    public news(String name, String shortDescription, String fullDescription, String type) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String  getType() {
        return type;
    }

    public Integer getId() {
        return id;
    }
}
