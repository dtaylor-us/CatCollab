package com.categories.collab.service.impl;

import com.categories.collab.domain.Category;
import com.categories.collab.repositories.CategoryRepository;
import com.categories.collab.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> readyByCategoryName(String categoryName) {
        return categoryRepository.findByTitle(categoryName);
    }

    @Override
    public Iterable<Category> getCategoryList() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public Category saveCategory(@Valid Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Iterable<Category> saveCategoryList(Iterable<Category> categories) {
        return categoryRepository.save(categories);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.delete(id);
    }
}
