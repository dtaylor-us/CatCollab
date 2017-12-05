package com.categories.collab.service.impl;

import com.categories.collab.domain.ImageModel;
import com.categories.collab.repositories.ImageRepository;
import com.categories.collab.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Iterable<ImageModel> getImageModelList() {
        return imageRepository.findAll();
    }

    @Override
    public ImageModel getImageModelById(Long id) {
        return imageRepository.findOne(id);
    }

    @Override
    public ImageModel saveImageModel(ImageModel image) {
        return imageRepository.save(image);
    }

    @Override
    public Iterable<ImageModel> saveImageModelList(Iterable<ImageModel> images) {
        return imageRepository.save(images);
    }

    @Override
    public void deleteImageModel(Long id) {
        imageRepository.delete(id);
    }

}
