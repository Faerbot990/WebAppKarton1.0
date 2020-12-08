package net.karton.service.impl;

import net.karton.model.News;
import net.karton.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsServiceImpl implements NewsRepository {

    private final NewsRepository newsRepository;
@Autowired
    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public News getOne(Long id) {
        return newsRepository.getOne(id);
    }

    @Override
    public List<News> findAll() {
        return newsRepository.findAll();
    }

    @Override
    public void saveNewsInfoById(String Title, String description, String filename, Long id
    ) {
      newsRepository.saveNewsInfoById(Title, description, filename, id);
    }
    @Override
    public News save(News news) {
        return newsRepository.save(news);
    }

    @Override
    public List<News> findAll(Sort sort) {
        return null;
    }

    @Override
    public List<News> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public <S extends News> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends News> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<News> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public <S extends News> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends News> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public Page<News> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<News> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(News news) {

    }

    @Override
    public void deleteAll(Iterable<? extends News> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends News> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends News> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends News> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends News> boolean exists(Example<S> example) {
        return false;
    }
}
