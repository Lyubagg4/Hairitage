package ru.zyryanova.ProductService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zyryanova.ProductService.entity.ProductClassificationScore;

public interface ProductClassificationScoreRepo extends JpaRepository<ProductClassificationScore, Integer> {
}
