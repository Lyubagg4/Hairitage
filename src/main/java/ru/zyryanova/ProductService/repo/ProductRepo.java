package ru.zyryanova.ProductService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zyryanova.ProductService.entity.bd.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
}
