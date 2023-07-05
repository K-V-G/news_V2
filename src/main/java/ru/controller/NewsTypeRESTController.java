package ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.model.NewsType;
import ru.model.NewsTypeDTO;
import ru.service.NewsTypeService;

import java.util.List;

@RestController
@RequestMapping("")
public class NewsTypeRESTController {

    NewsTypeService service;

    @Autowired
    public NewsTypeRESTController(NewsTypeService service) {
        this.service = service;
    }


    @PostMapping("/save_news_type")
    public ResponseEntity<NewsTypeDTO> createNewsType(@RequestBody NewsType newsType) {
        NewsTypeDTO type = new NewsTypeDTO(service.save(newsType));
        return new ResponseEntity<>(type, HttpStatus.CREATED);
    }

    @GetMapping("/all_type")
    public ResponseEntity<List<NewsTypeDTO>> findAllNewsType(){
        List<NewsTypeDTO> list = service.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/news_type/{typeName}")
    public ResponseEntity<NewsTypeDTO> findOneNewsType(@PathVariable("typeName") String typeName){
        NewsTypeDTO typeDTO = service.findNewsType(typeName);
        if (typeDTO != null) {
            return new ResponseEntity<>(typeDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/delete_news_type/{typeName}", method = RequestMethod.DELETE)
    public ResponseEntity<NewsType> deleteNewsType(@PathVariable("typeName") String typeName) {
        service.delete(typeName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/update_news_type/{typeName}", method = RequestMethod.PUT)
    public ResponseEntity<NewsType> updateNewsType(@RequestBody NewsType newsType,
                                                   @PathVariable("typeName") String typeName) {
        NewsType newsTypeUpdate = service.update(newsType, typeName);
        if (newsTypeUpdate != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping("/all_name_news_type")
    public ResponseEntity<List<String>> getAllNewsType(){
        List<String> list = service.findAllTypeNews();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
