package com.categories.collab.service;

import com.categories.collab.domain.ImageModel;
import org.springframework.stereotype.Service;

@Service
public interface ImageService {

    Iterable<ImageModel> getImageModelList();

    ImageModel getImageModelById(Long id);

    ImageModel saveImageModel(ImageModel image);

    Iterable<ImageModel> saveImageModelList(Iterable<ImageModel> images);

    void deleteImageModel(Long id);
}
