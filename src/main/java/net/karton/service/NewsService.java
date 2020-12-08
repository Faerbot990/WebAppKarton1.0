package net.karton.service;


import net.karton.model.News;

import java.util.List;


public interface NewsService {
    News getOne(Long id);

    List<News> findAll();

    void saveNewsById(String Title,
                             String description,
                             String filename,
                             Long id);
    News save(News news);

}
