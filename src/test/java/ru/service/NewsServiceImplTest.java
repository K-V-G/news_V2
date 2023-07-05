package ru.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@ExtendWith(value = SpringExtension.class)
class NewsServiceImplTest {

    @Test
    void findAll() {
    }

    @Test
    void getAllNewsByType() {
    }

    @Test
    void findNewsById() {
    }

    @Test
    void delete() {
    }

    @Test
    void save() {
    }
}