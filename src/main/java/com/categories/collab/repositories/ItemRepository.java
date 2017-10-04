package com.categories.collab.repositories;

import com.categories.collab.domain.Category;
import com.categories.collab.domain.Item;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ItemRepository extends PagingAndSortingRepository<Item, Integer> {
    List<Item> findByTitle(String title);

    List<Item> findAllByCategory(Category category);
}
