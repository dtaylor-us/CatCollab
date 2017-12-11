package com.categories.collab.api;

import com.categories.collab.domain.ImageModel;
import com.categories.collab.service.ImageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

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
    public void save(@RequestBody MultipartFile file) {
//        byte[] picBase64 = Base64.getEncoder().encode(model.getPic());
//        byte[] img = Base64.getDecoder().decode(picBase64);
//        model.setPic(img);

//        ImageModel img = new ImageModel();
        try {
//            img.setName(file.getName());
//            img.setPic(bytes);
//            img.setType(file.getContentType());
//        return imageService.saveImageModel(model);
            Files.write(Paths.get("retrieve-dir/" + file.getName()
                    + "." + file.getContentType()), file.getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
//        return img;
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
