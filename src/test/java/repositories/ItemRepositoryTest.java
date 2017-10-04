package repositories;

import com.categories.collab.common.Utils;
import com.categories.collab.configuration.RepositoryConfiguration;
import com.categories.collab.domain.Category;
import com.categories.collab.domain.Item;
import com.categories.collab.repositories.CategoryRepository;
import com.categories.collab.repositories.ItemRepository;
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
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testSave() {
        Item item = new Item();

        assertNull(item.getId());
        itemRepository.save(item);
        assertNotNull(item.getId());

        Item foundItem = itemRepository.findOne(item.getId());
        assertEquals(item.getId(), foundItem.getId());

        foundItem.setTitle("Updated Title");
        itemRepository.save(foundItem);

        Item foundUpdatedItem = itemRepository.findOne(foundItem.getId());
        assertEquals(foundUpdatedItem.getTitle(), "Updated Title");

        itemRepository.delete(item.getId());

    }

    @Test
    public void testSaveItemList() {
        List<Item> categories = new ArrayList<>();

        categories.add(new Item("Test-Title1"));
        categories.add(new Item("Test-Title2"));

        itemRepository.save(categories);
        List<Item> foundItemList = Utils.iterableToList(itemRepository.findAll());

        boolean result = foundItemList.size() > 0;
        assertEquals(result, true);

        itemRepository.delete(itemRepository.findByTitle("Test-Title1"));
        itemRepository.delete(itemRepository.findByTitle("Test-Title2"));
    }


    @Test
    public void testFindByTitle() {
        Item item = new Item();

        String title = String.valueOf(item.getId());
        item.setTitle(title);

        itemRepository.save(item);
        List<Item> foundItem = itemRepository.findByTitle(title);

        boolean result = foundItem.stream().anyMatch(cat -> cat.getTitle().equals(title));

        assertEquals(result, true);

        //cleanup
        itemRepository.delete(item.getId());
    }


    @Test
    public void testSaveCategoryItem() {
        Category category = new Category("Category Parent");
        categoryRepository.save(category);

        Item item = new Item("Child",  category);
        itemRepository.save(item);

        Item item1 = itemRepository.findOne(item.getId());
        assertEquals(true, item1 != null);

        itemRepository.delete(item);
    }

    @Test
    public void testDeleteItem() {
        Item item = new Item();
        itemRepository.save(item);

        assertEquals(true, itemRepository.findOne(item.getId()) != null);

        itemRepository.delete(item);
        assertNull(itemRepository.findOne(item.getId()));
    }


    @Test
    public void testGetItemsByCategory() {
        Category category = new Category("Category Parent");
        categoryRepository.save(category);

        Item item = new Item("Child",  category);
        Item item2 = new Item("Child2",  category);
        Item item3 = new Item("Child3",  category);

        List<Item> items = new ArrayList<>();
        items.add(item);
        items.add(item2);
        items.add(item3);
        itemRepository.save(items);

        List<Item> categoryItems = itemRepository.findAllByCategory(category);
        assertEquals(true, categoryItems.size() == 3);

        itemRepository.delete(item);
    }
}
