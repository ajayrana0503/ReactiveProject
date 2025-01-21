package org.reactive.reactiveproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/fake-users")
    public Mono<String> getFakeUsers() {
        return webClientBuilder.build()
                .get()
                .uri("https://jsonplaceholder.typicode.com/users")
                .retrieve()
                .bodyToMono(String.class);
    }

    @GetMapping("/fake-posts")
    public Mono<String> getFakePosts() {
        return webClientBuilder.build()
                .get()
                .uri("https://jsonplaceholder.typicode.com/posts")
                .retrieve()
                .bodyToMono(String.class);
    }
}