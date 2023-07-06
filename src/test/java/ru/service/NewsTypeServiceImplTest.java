package ru.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.model.NewsType;
import ru.repository.NewsTypeRepo;

import java.util.ArrayList;
import java.util.List;
@SpringBootTest(properties = "spring.config.name=test")
@ExtendWith(value = SpringExtension.class)
@Import(NewsTypeServiceImpl.class)
class NewsTypeServiceImplTest {

    @Autowired
    private NewsTypeRepo newsTypeRepo;

    @Autowired
    private NewsTypeServiceImpl newsTypeService;

    @BeforeEach
    void setUp() {
        newsTypeRepo.saveAll(this.getNewsTypeTest());
    }

    @Test
    void save() {
        NewsType newsType = new NewsType("Ну такая", "Ну такой");
        newsTypeRepo.save(newsType);
        Assertions.assertNotNull(newsTypeRepo.findAll());
        Assertions.assertEquals(5, newsTypeRepo.findAll().size());
        NewsType newsTypeNew = newsTypeRepo.findNewsTypeByTypeName("Ну такая");
        Assertions.assertNotNull(newsTypeNew);

    }

    @Test
    void findAll() {
        Assertions.assertNotNull(newsTypeRepo.findAll());
        Assertions.assertEquals(4, newsTypeRepo.findAll().size());
    }

    @Test
    void findNewsType() {
        NewsType newsType = newsTypeRepo.findNewsTypeByTypeName("Очень хорошая новость");
        Assertions.assertEquals("Очень хорошая новость", newsType.getTypeName());
        Assertions.assertEquals("Оранжевый", newsType.getColorType());

    }

    @Test
    void findAllTypeNews() {
        List<NewsType> newsTypeDTOList = newsTypeRepo.findAll();
        List<String> types = new ArrayList<>();
        for (NewsType newsType : newsTypeDTOList) {
            types.add(newsType.getTypeName());
        }
        Assertions.assertEquals(4, types.size());
        Assertions.assertAll(
                () -> Assertions.assertTrue(types.contains("Хорошая новость")),
                () -> Assertions.assertTrue(types.contains("Очень хорошая новость")),
                () -> Assertions.assertTrue(types.contains("Плохая новость")),
                () -> Assertions.assertTrue(types.contains("Очень плохая новость"))
        );
    }

    @Test
    void delete() {
        newsTypeRepo.deleteById("Плохая новость");
        Assertions.assertNotNull(newsTypeRepo.findAll());
        Assertions.assertEquals(3, newsTypeRepo.findAll().size());
        NewsType newsType = newsTypeRepo.findNewsTypeByTypeName("Плохая новость");
        Assertions.assertNull(newsType);
    }

    @Test
    void update() {
        NewsType newsType = newsTypeRepo.findNewsTypeByTypeName("Хорошая новость");
        if (newsType != null) {
            newsType.setColorType("Зелёный");
            newsTypeRepo.save(newsType);
        }
        NewsType newsTypeNew = newsTypeRepo.findNewsTypeByTypeName("Хорошая новость");
        Assertions.assertNotNull(newsType);
        Assertions.assertEquals("Зелёный", newsTypeNew.getColorType());
        Assertions.assertNotEquals("Желтый", newsTypeNew.getColorType());
    }

    public ArrayList<NewsType> getNewsTypeTest() {
        ArrayList<NewsType> arrayListNewsType = new ArrayList<>();

        NewsType newsType1 = new NewsType("Хорошая новость", "Желтый");
        NewsType newsType2 = new NewsType("Очень хорошая новость", "Оранжевый");
        NewsType newsType3 = new NewsType("Плохая новость", "Красный");
        NewsType newsType4 = new NewsType("Очень плохая новость", "Черный");

        arrayListNewsType.add(newsType1);
        arrayListNewsType.add(newsType2);
        arrayListNewsType.add(newsType3);
        arrayListNewsType.add(newsType4);

        return  arrayListNewsType;
    }
}