package org.reactive.reactiveproject.service;

import org.reactive.reactiveproject.model.Item;
import org.reactive.reactiveproject.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.logging.Logger;

@Service
public class ItemService {

    private static final Logger logger = Logger.getLogger(ItemService.class.getName());

    @Autowired
    private ItemRepository itemRepository;

    public Flux<Item> getAllItems() {
        logger.info("Fetching all items");
//        return itemRepository.findAll().delayElements(Duration.ofSeconds(2));
        return itemRepository.findAllWithDelay();
    }

    public Mono<Item> getItemById(Long id) {
        logger.info("Fetching item by id: " + id);
        return itemRepository.findById(id);
    }

    public Mono<Item> createItem(Item item) {
        logger.info("Creating item: " + item);
        return itemRepository.save(item);
    }

    public Mono<Void> deleteItem(Long id) {
        logger.info("Deleting item by id: " + id);
        return itemRepository.deleteById(id);
    }
}