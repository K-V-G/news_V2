package ru.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class NewsTypeDTO {

    private String typeName;
    private String colorType;

    public NewsTypeDTO(NewsType newsType) {
        this.typeName = newsType.getTypeName();
        this.colorType = newsType.getColorType();
    }
}
