package com.categories.collab.api;

import com.categories.collab.domain.ImageModel;
import com.categories.collab.service.ImageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/image")
public class ImageAPI {
    Logger logger = Logger.getLogger(ImageAPI.class);

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<ImageModel> getAll() {
        return imageService.getImageModelList();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ImageModel getById(@PathVariable long id) {
        return imageService.getImageModelById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ImageModel save(@Valid @RequestBody ImageModel image) {
        return imageService.saveImageModel(image);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable long id) {
        try {
            imageService.deleteImageModel(id);
            return true;
        } catch (Exception ex) {
            logger.info(ex);
            return false;
        }
    }
}
