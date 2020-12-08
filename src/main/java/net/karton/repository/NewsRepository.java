package net.karton.repository;

import net.karton.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface NewsRepository extends JpaRepository<News, Long> {


    @Modifying
    @Transactional
    @Query("update News n set n.title = ?1, n.description = ?2, n.filename = ?3 where n.id = ?4")
    void saveNewsInfoById(String Title,
                             String description,
                             String filename,
                             Long id);
}

