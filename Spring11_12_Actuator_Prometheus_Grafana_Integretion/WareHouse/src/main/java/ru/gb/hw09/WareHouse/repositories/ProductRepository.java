package ru.gb.hw09.WareHouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.hw09.WareHouse.models.Product;

/**
 * Репозиторий для работы с сущностью товара.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {



}
