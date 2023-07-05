package ru.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.repository.NewsRepoImpl;
import ru.repository.NewsTypeRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(value = SpringExtension.class)
class NewsServiceImplTest {
    @Autowired
    NewsRepoImpl newsRepo;

    @Autowired
    NewsTypeRepo newsTypeRepo;


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