package ru.service;

import ru.model.NewsType;
import ru.model.NewsTypeDTO;

import java.util.List;

public interface NewsTypeService {

    NewsType save(NewsType newsType);

    List<NewsTypeDTO> findAll();

    NewsTypeDTO findNewsType(String typeName);

    List<String> findAllTypeNews();

    void delete(String typeName);

    NewsType update(NewsType newsType, String typeName);
}
