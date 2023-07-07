package ru.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "newstype")
@Getter
@Setter
@Data
@NoArgsConstructor
public class NewsType {
    @Id
    @Column(name = "type_name")
    private String typeName;
    @Column(name = "color_type")
    private String colorType;


    public NewsType(String typeName, String colorType) {
        this.typeName = typeName;
        this.colorType = colorType;
    }
}