package ru.zyryanova.ProductService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.zyryanova.ProductService.entity.bd.ProductClassScore;

import java.util.Optional;

public interface ProductClassScoreRepo extends JpaRepository<ProductClassScore, Integer> {
    ProductClassScore findByProductId(int productId);
}
