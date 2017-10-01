package com.categories.collab.service;

import com.categories.collab.domain.Item;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {

    List<Item> getItemByTitle(String title);

    public Page<Item> getItemPages(Integer pageNumber);

    Iterable<Item> getItemList();

    Item getItemById(Integer id);

    Item saveItem(Item item);

    Iterable<Item> saveItemList(Iterable<Item> items);

    void deleteItem(Integer id);
}
