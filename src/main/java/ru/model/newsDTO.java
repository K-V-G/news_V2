package ru.model;

import lombok.Data;

@Data
public class newsDTO {
    private Integer id;
    private String name;
    private String shortDescription;
    private String fullDescription;

    private String type;

    public newsDTO(news news) {
        this.id = news.getId();
        this.name = news.getName();
        this.shortDescription = news.getShortDescription();
        this.fullDescription = news.getFullDescription();
        this.type = news.getType();
    }

}
