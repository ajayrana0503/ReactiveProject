package org.reactive.reactiveproject.service;

import org.reactive.reactiveproject.model.Item;
import org.reactive.reactiveproject.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Flux<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Mono<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    public Mono<Item> createItem(Item item) {
        return itemRepository.save(item);
    }

    public Mono<Void> deleteItem(Long id) {
        return itemRepository.deleteById(id);
    }
}