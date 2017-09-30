package com.categories.collab.service;

import com.categories.collab.domain.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> readyByCategoryName(String title);

    Iterable<Category> getCategoryList();

    Category getCategoryById(Integer id);

    Category saveCategory(Category category);

    Iterable<Category> saveCategoryList(Iterable<Category> items);

    void deleteCategory(Integer id);

}
