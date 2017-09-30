package repositories;

import com.categories.collab.common.Utils;
import com.categories.collab.configuration.RepositoryConfiguration;
import com.categories.collab.domain.Category;
import com.categories.collab.repositories.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testSave() {
        Category category = new Category("Title", "Descripting", "Author");

        assertNull(category.getId());
        categoryRepository.save(category);
        assertNotNull(category.getId());

        Category foundCategory = categoryRepository.findOne(category.getId());
        assertEquals(category.getId(), foundCategory.getId());

        foundCategory.setTitle("Updated Title");
        categoryRepository.save(foundCategory);

        Category foundUpdatedCategory = categoryRepository.findOne(foundCategory.getId());
        assertEquals(foundUpdatedCategory.getTitle(), "Updated Title");

        categoryRepository.delete(category.getId());

    }

    @Test
    public void testSaveCategoryList() {
        List<Category> categories = new ArrayList<>();

        categories.add(new Category("Test-Title1"));
        categories.add(new Category("Test-Title2"));

        categoryRepository.save(categories);
        List<Category> foundCategoryList = Utils.iterableToList(categoryRepository.findAll());

        boolean result = foundCategoryList.size() > 0;
        assertEquals(result, true);

        categoryRepository.delete(categoryRepository.findByTitle("Test-Title1"));
        categoryRepository.delete(categoryRepository.findByTitle("Test-Title2"));
    }


    @Test
    public void testFindByTitle() {
        Category category = new Category();

        String title = String.valueOf(category.getId());
        category.setTitle(title);

        categoryRepository.save(category);
        List<Category> foundCategory = categoryRepository.findByTitle(title);

        boolean result = foundCategory.stream().anyMatch(cat -> cat.getTitle().equals(title));
        assertEquals(result, true);

        //cleanup
        categoryRepository.delete(category.getId());
    }

    @Test
    public void testDeleteCategory() {
        Category category = new Category();
        categoryRepository.save(category);

        assertEquals(true, categoryRepository.findOne(category.getId()) != null);

        categoryRepository.delete(category);
        assertNull(categoryRepository.findOne(category.getId()));
    }
}
