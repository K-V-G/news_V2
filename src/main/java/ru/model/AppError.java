package ru.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AppError {
    public int code;
    public String message;

    public AppError(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
