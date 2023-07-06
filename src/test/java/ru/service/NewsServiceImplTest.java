package ru.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.model.News;
import ru.model.NewsType;
import ru.repository.NewsRepoImpl;
import ru.repository.NewsTypeRepo;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest(properties = "spring.config.name=test")
@ExtendWith(value = SpringExtension.class)
@Import(NewsServiceImpl.class)
class NewsServiceImplTest {
    @Autowired
    private NewsRepoImpl newsRepo;

    @Autowired
    private NewsTypeRepo newsTypeRepo;

    @Autowired
    private NewsServiceImpl newsService;


    @BeforeEach
    public void setUp() {
        newsTypeRepo.saveAll(this.getNewsTypeTest());
        newsRepo.saveAll(this.getTestNews());
    }

    @AfterEach
    public void after() {
        newsTypeRepo.deleteAll();
        newsRepo.deleteAll();
    }


    @Test
    public void findAll() {
        Assertions.assertNotNull(newsRepo.findAll());
        Assertions.assertEquals(8, newsRepo.findAll().size());
    }

    @Test
    public void getAllNewsByType() {
        Assertions.assertNotNull(newsRepo.findNewsByType("Хорошая новость"));
        Assertions.assertEquals(2, newsRepo.findNewsByType("Хорошая новость").size());
    }

    @Test
    public void findNewsById() {
        News news = newsRepo.findById(2).orElseThrow();
        Assertions.assertEquals("Название 2", news.getName());
        Assertions.assertEquals("Короткое описание 2", news.getShortDescription());
        Assertions.assertEquals("Длинное описание 2", news.getFullDescription());
        Assertions.assertEquals("Хорошая новость", news.getType());

    }

    @Test
    public void delete() {
        newsRepo.deleteById(1);
        Assertions.assertEquals(7, newsRepo.findAll().size());
        List<News> arrayListNewsGoodNews = newsRepo.findNewsByType("Хорошая новость");
        Assertions.assertEquals(1, arrayListNewsGoodNews.size());
        Assertions.assertNotEquals("Название 1", arrayListNewsGoodNews.get(0).getName());


    }

    @Test
    public void save() {
        NewsType newsType = new NewsType("Ну такая", "Ну такой");
        newsTypeRepo.save(newsType);
        News news = new News("Название 9", "Короткое описание 9", "Длинное описание 9", "Ну такая");
        News newsSaaving = newsRepo.save(news);
        List<News> newNews = newsRepo.findNewsByType("Ну такая");
        Assertions.assertEquals(1, newNews.size());
        Assertions.assertEquals("Название 9", newNews.get(0).getName());
        Assertions.assertEquals("Короткое описание 9", newNews.get(0).getShortDescription());
        Assertions.assertEquals("Длинное описание 9", newNews.get(0).getFullDescription());
        Assertions.assertEquals("Название 9",newsSaaving.getName());
        Assertions.assertEquals("Короткое описание 9", newsSaaving.getShortDescription());
        Assertions.assertEquals("Длинное описание 9", newsSaaving.getFullDescription());
    }

    public ArrayList<News> getTestNews() {
        ArrayList<News> arrayListNews = new ArrayList<>();
        News news1 = new News("Название 1", "Короткое описание 1", "Длинное описание 1", "Хорошая новость");
        News news2 = new News("Название 2", "Короткое описание 2", "Длинное описание 2", "Хорошая новость");
        News news3 = new News("Название 3", "Короткое описание 3", "Длинное описание 3", "Очень хорошая новость");
        News news4 = new News("Название 4", "Короткое описание 4", "Длинное описание 4", "Очень хорошая новость");
        News news5 = new News("Название 5", "Короткое описание 5", "Длинное описание 5", "Плохая новость");
        News news6 = new News("Название 6", "Короткое описание 6", "Длинное описание 6", "Плохая новость");
        News news7 = new News("Название 7", "Короткое описание 7", "Длинное описание 7", "Очень плохая новость");
        News news8 = new News("Название 8", "Короткое описание 8", "Длинное описание 8", "Очень плохая новость");

        arrayListNews.add(news1);
        arrayListNews.add(news2);
        arrayListNews.add(news3);
        arrayListNews.add(news4);
        arrayListNews.add(news5);
        arrayListNews.add(news6);
        arrayListNews.add(news7);
        arrayListNews.add(news8);

        return arrayListNews;

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