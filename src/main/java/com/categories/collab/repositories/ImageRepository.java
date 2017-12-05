package com.categories.collab.repositories;

import com.categories.collab.domain.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ImageRepository extends JpaRepository<ImageModel, Long>{

}