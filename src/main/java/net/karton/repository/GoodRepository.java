package net.karton.repository;


import net.karton.model.Good;
import net.karton.model.GoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodRepository extends JpaRepository<Good, Long> {

    List<Good> getAllByCategory(GoodCategory category);
}
