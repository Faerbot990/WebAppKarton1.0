package net.karton.service;


import lombok.RequiredArgsConstructor;
import net.karton.model.Good;
import net.karton.model.GoodCategory;
import net.karton.repository.GoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GoodService {

    private final GoodRepository goodRepository;


    public List<Good> findAll() {
        return goodRepository.findAll();
    }

    public Good save(Good good) {
        return goodRepository.save(good);
    }

    public void delete(Good good) {
        goodRepository.delete(good);
    }

    public Good update(Good goodFromDb, Good good) {
        String name = good.getName();
        GoodCategory goodCategory = good.getCategory();
        String description = good.getDescription();

        if (name != null) {
            goodFromDb.setName(name);
        }
        if (goodCategory != null) {
            goodFromDb.setCategory(goodCategory);
        }
        if (description != null) {
            goodFromDb.setDescription(description);
        }

        return goodRepository.save(goodFromDb);
    }

    public List<Good> findAllByCategory(String category) {
        try {
            GoodCategory goodCategory = GoodCategory.valueOf(category);
            return goodRepository.getAllByCategory(goodCategory);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
