package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.model.NewsType;

public interface NewsTypeRepo extends JpaRepository<NewsType, String> {

    NewsType findNewsTypeByTypeName(String typeName);

}
