package ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.model.*;
import ru.service.NewsService;
import ru.service.NewsTypeService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("")
public class NewsRESTController {
    NewsService newsService;
    NewsTypeService newsTypeService;

    @Autowired
    public NewsRESTController(NewsService service, NewsTypeService newsTypeService) {
        this.newsService = service;
        this.newsTypeService = newsTypeService;
    }

    @GetMapping("/all_news")
    public ResponseEntity<List<NewsDTO>> findAllNews() {
        List<NewsDTO> newsList = newsService.findAll();
        return new ResponseEntity<>(newsList, HttpStatus.OK);

    }

    @GetMapping("/news/{id}")
    public ResponseEntity<?> getOne(@PathVariable("id") Integer id) {
        try {
            NewsDTO news = newsService.findNewsById(id);
            return new ResponseEntity<>(news, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    "Product with id " + id + " nor found"), HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value = "/delete_news/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<NewsType> deleteNewsType(@PathVariable("id") Integer id) {
        newsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/save_news")
    public ResponseEntity<?> createNewsType(@RequestBody News news) {
        NewsTypeDTO type = newsTypeService.findNewsType(news.getType());
        if (type != null) {
            NewsDTO newsNew = new NewsDTO(newsService.save(news));
            return new ResponseEntity<>(newsNew, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(),
                "News can not save"), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/get_all_news_by_type_name/{typeNews}")
    public ResponseEntity<List<NewsDTO>> getAllNewsByType(@PathVariable("typeNews") String typeNews) {
        try {
            List<NewsDTO> newsDTOList = newsService.getAllNewsByType(typeNews);
            if (newsDTOList.size() != 0) {
                return new ResponseEntity<>(newsDTOList, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
