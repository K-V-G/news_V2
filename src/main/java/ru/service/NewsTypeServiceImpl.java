package ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.model.NewsType;
import ru.model.NewsTypeDTO;
import ru.repository.NewsTypeRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsTypeServiceImpl implements NewsTypeService {

    NewsTypeRepo newsTypeRepo;

    @Autowired
    public NewsTypeServiceImpl(NewsTypeRepo newsTypeRepo) {
        this.newsTypeRepo = newsTypeRepo;
    }

    @Override
    public NewsType save(NewsType newsType) {
        NewsType newsTypeNew = newsTypeRepo.save(newsType);
        return newsTypeNew;
    }

    @Override
    public List<NewsTypeDTO> findAll() {
        return newsTypeRepo.findAll().stream().map(NewsTypeDTO::new).collect(Collectors.toList());
    }

    public NewsTypeDTO findNewsType(String typeName) {
        NewsType newsType = newsTypeRepo.findNewsTypeByTypeName(typeName);
        if (newsType != null) {
            return new NewsTypeDTO(newsType);
        }
        return null;
    }

    @Override
    public List<String> findAllTypeNews() {
        List<NewsTypeDTO> newsTypeDTOList = findAll();
        List<String> types = new ArrayList<>();
        for (NewsTypeDTO newsTypeDTO : newsTypeDTOList) {
            types.add(newsTypeDTO.getTypeName());
        }
        return types;
    }

    @Override
    public void delete(String typeName) {
        newsTypeRepo.deleteById(typeName);
    }

    @Override
    public NewsType update(NewsType newsTypeValue, String typeName) {
        NewsType newsType = newsTypeRepo.findNewsTypeByTypeName(typeName);
        if (newsType != null) {
            newsType.setColorType(newsTypeValue.getColorType());
            return newsTypeRepo.save(newsType);
        }
        return null;
    }

}
