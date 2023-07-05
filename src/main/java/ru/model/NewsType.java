package ru.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "newstype_v2")
@Getter
@Setter
@Data
public class NewsType {
    @Id
    @Column(name = "type_name")
    private String typeName;
    @Column(name = "color_type")
    private String colorType;
}