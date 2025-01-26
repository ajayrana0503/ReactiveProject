package org.reactive.reactiveproject.repository;

import org.reactive.reactiveproject.model.Item;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ItemRepository extends ReactiveCrudRepository<Item, Long> {

    @Query("SELECT * FROM items WHERE id IN (SELECT id FROM items, pg_sleep(2))")
    Flux<Item> findAllWithDelay();
}