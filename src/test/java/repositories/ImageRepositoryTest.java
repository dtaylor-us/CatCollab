package repositories;

import com.categories.collab.configuration.RepositoryConfiguration;
import com.categories.collab.domain.ImageModel;
import com.categories.collab.repositories.ImageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.nio.file.Files;
import java.nio.file.Paths;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class ImageRepositoryTest {

    @Autowired
    private ImageRepository imageRepository;

    @Test
    public void saveImage() throws Exception {
        ClassPathResource backImgFile = new ClassPathResource("image/spider-man-background.jpg");
        byte[] arrayPic = new byte[(int) backImgFile.contentLength()];
        backImgFile.getInputStream().read(arrayPic);
        ImageModel spiderManImg = new ImageModel(1, "SPIDER-MAN-BACKGROUND", "jpg", arrayPic);

        imageRepository.save(spiderManImg);

        Files.write(Paths.get("retrieve-dir/" + spiderManImg.getName()
                + "." + spiderManImg.getType()), spiderManImg.getPic());

//        imageRepository.delete(spiderManImg);
    }


}
