package ru.gb.WebClient.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.gb.WebClient.models.Order;
import ru.gb.WebClient.models.Product;

import java.util.List;

@FeignClient(name = "storage")
public interface StorageClientApi {

    @GetMapping
    List<Product> getProducts();

    @PostMapping("/{id}/reserve")
    ResponseEntity<?> reserveProduct(@PathVariable Long id, @RequestBody Order order);

    @PostMapping("/{id}/reserve/rollback")
    void rollbackReserve(@PathVariable Long id, @RequestBody Order order);

    @PostMapping("/{id}")
    ResponseEntity<?> bay(@PathVariable Long id, @RequestBody Order order);

}
