package services;

import com.categories.collab.Application;
import com.categories.collab.common.Utils;
import com.categories.collab.domain.Category;
import com.categories.collab.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration

public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void testSave() {
        Category category = new Category("Title", "Descripting", "Author");

        assertNull(category.getId());
        categoryService.saveCategory(category);
        assertNotNull(category.getId());

        Category foundCategory = categoryService.getCategoryById(category.getId());
        assertEquals(category.getId(), foundCategory.getId());

        foundCategory.setTitle("Updated Title");
        categoryService.saveCategory(foundCategory);

        Category foundUpdatedCategory = categoryService.getCategoryById(foundCategory.getId());
        assertEquals(foundUpdatedCategory.getTitle(), "Updated Title");

        categoryService.deleteCategory(category.getId());

    }

    @Test
    public void testSaveCategoryList() {
        List<Category> categories = new ArrayList<>();

        categories.add(new Category("Test-Title1"));
        categories.add(new Category("Test-Title2"));

        categoryService.saveCategoryList(categories);
        List<Category> foundCategoryList = Utils.iterableToList(categoryService.getCategoryList());

        boolean result = foundCategoryList.size() > 0;
        assertEquals(result, true);
    }


    @Test
    public void testFindByTitle() {
        Category category = new Category();

        String title = String.valueOf(category.getId());
        category.setTitle(title);

        categoryService.saveCategory(category);

        assertEquals(true, categoryService.getCategoryById(category.getId()) != null);

        categoryService.deleteCategory(category.getId());
        assertNull(categoryService.getCategoryById(category.getId()));
    }
}
