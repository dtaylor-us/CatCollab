package com.categories.collab.service.impl;

import com.categories.collab.configuration.Constants;
import com.categories.collab.domain.Item;
import com.categories.collab.repositories.ItemRepository;
import com.categories.collab.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Override
    public List<Item> getItemByTitle(String title) {
        return itemRepository.findByTitle(title);
    }

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Page<Item> getItemPages(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, Constants.PAGE_SIZE, Sort.Direction.DESC, "title");
        return itemRepository.findAll(request);
    }

    @Override
    public Iterable<Item> listAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Integer id) {
        return itemRepository.findOne(id);
    }

    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Iterable<Item> saveItemList(Iterable<Item> items) {
        return itemRepository.save(items);
    }

    @Override
    public void deleteItem(Integer id) {
        itemRepository.delete(id);
    }
}
