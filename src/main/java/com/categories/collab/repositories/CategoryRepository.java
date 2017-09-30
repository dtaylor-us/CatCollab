package com.categories.collab.repositories;

import com.categories.collab.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {


    List<Category> findByTitle(String title);

}
