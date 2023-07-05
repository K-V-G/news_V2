package ru.service;

import ru.model.News;
import ru.model.NewsDTO;

import java.util.List;

public interface NewsService {
    News save(News news);

    List<NewsDTO> findAll();

    List<NewsDTO> getAllNewsByType(String typeName);

    NewsDTO findNewsById(int id);

     void delete(int id);
}
