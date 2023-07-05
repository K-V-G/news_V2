package ru.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.model.News;

import java.util.List;

public interface NewsRepoImpl extends JpaRepository<News, Integer> {
    List<News> findNewsByType(String typeName);
}
