package org.reactive.reactiveproject.controller;

import org.reactive.reactiveproject.model.Item;
import org.reactive.reactiveproject.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public Flux<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Mono<Item> getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @PostMapping
    public Mono<Item> createItem(@RequestBody Item item) {
            if (item.getName() == null || item.getName().isEmpty()) {
                throw new IllegalArgumentException("Item name must not be null or empty");
            }
        return itemService.createItem(item);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteItem(@PathVariable Long id) {
        return itemService.deleteItem(id);
    }
}