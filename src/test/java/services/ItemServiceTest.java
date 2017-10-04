package services;

import com.categories.collab.Application;
import com.categories.collab.common.Utils;
import com.categories.collab.domain.Category;
import com.categories.collab.domain.Item;
import com.categories.collab.service.CategoryService;
import com.categories.collab.service.ItemService;
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

public class ItemServiceTest {

    @Autowired
    private ItemService itemService;

    @Autowired
    private CategoryService categoryService;

    @Test
    public void testSave() {
        Item item = new Item();

        assertNull(item.getId());
        itemService.saveItem(item);
        assertNotNull(item.getId());

        Item foundItem = itemService.getItemById(item.getId());
        assertEquals(item.getId(), foundItem.getId());

        foundItem.setTitle("Updated Title");
        itemService.saveItem(foundItem);

        Item foundUpdatedItem = itemService.getItemById(foundItem.getId());
        assertEquals(foundUpdatedItem.getTitle(), "Updated Title");

        itemService.deleteItem(item.getId());

    }

    @Test
    public void testSaveItemList() {
        List<Item> categories = new ArrayList<>();

        categories.add(new Item("Test-Title1"));
        categories.add(new Item("Test-Title2"));

        itemService.saveItemList(categories);
        List<Item> foundItemList = Utils.iterableToList(itemService.getItemList());

        boolean result = foundItemList.size() > 0;
        assertEquals(result, true);
    }


    @Test
    public void testFindByTitle() {
        Item item = new Item();

        String title = String.valueOf(item.getId());
        item.setTitle(title);

        itemService.saveItem(item);
        List<Item> foundItem = itemService.getItemByTitle(title);

        boolean result = foundItem.stream().anyMatch(cat -> cat.getTitle().equals(title));

        assertEquals(result, true);

        //cleanup
        itemService.deleteItem(item.getId());
    }


    @Test
    public void testSaveCategoryItem() {
        Category category = new Category("Category Parent");
        categoryService.saveCategory(category);

        Item item = new Item("Child",  category);
        itemService.saveItem(item);

        Item item1 = itemService.getItemById(item.getId());
        assertEquals(true, item1 != null);

        itemService.deleteItem(item.getId());
    }

    @Test
    public void testDeleteItem() {
        Item item = new Item();
        itemService.saveItem(item);

        assertEquals(true, itemService.getItemById(item.getId()) != null);

        itemService.deleteItem(item.getId());
        assertNull(itemService.getItemById(item.getId()));
    }

    @Test
    public void testGetItemsByCategory() {
        Category category = new Category("Category Parent");
        categoryService.saveCategory(category);

        Item item = new Item("Child",  category);
        Item item2 = new Item("Child2",  category);
        Item item3 = new Item("Child3",  category);

        List<Item> items = new ArrayList<>();
        items.add(item);
        items.add(item2);
        items.add(item3);
        itemService.saveItemList(items);

        List<Item> categoryItems = itemService.getItemsByCategory(category);
        assertEquals(true, categoryItems.size() == 3);

        itemService.deleteItem(item.getId());
        itemService.deleteItem(item2.getId());
        itemService.deleteItem(item3.getId());
        categoryService.deleteCategory(category.getId());
    }
}
