package ru.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class NewsDTO {

    private Integer id;
    private String name;
    private String shortDescription;
    private String fullDescription;

    private String type;

    public NewsDTO(News news) {
        this.id = news.getId();
        this.name = news.getName();
        this.shortDescription = news.getShortDescription();
        this.fullDescription = news.getFullDescription();
        this.type = news.getType();
    }

}
