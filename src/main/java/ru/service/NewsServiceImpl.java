package ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.model.News;
import ru.model.NewsDTO;
import ru.repository.NewsRepoImpl;
import ru.repository.NewsTypeRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsServiceImpl implements NewsService {
    NewsRepoImpl newsRepo;
    NewsTypeRepo newsTypeRepo;


    @Autowired
    public NewsServiceImpl(NewsRepoImpl newsRepo, NewsTypeRepo newsTypeRepo) {
        this.newsRepo = newsRepo;
        this.newsTypeRepo = newsTypeRepo;
    }

    @Override
    public List<NewsDTO> findAll() {
        return newsRepo.findAll().stream().map(NewsDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<NewsDTO> getAllNewsByType(String typeName) {
        return newsRepo.findNewsByType(typeName).stream().map(NewsDTO::new).collect(Collectors.toList());
    }

    @Override
    public NewsDTO findNewsById(int id) {
        News news = newsRepo.findById(id).orElseThrow();
        return new NewsDTO(news);
    }

    @Override
    public void delete(int id) {
        newsRepo.deleteById(id);
    }

    @Override
    public News save(News news) {
        return newsRepo.save(news);
    }




}
