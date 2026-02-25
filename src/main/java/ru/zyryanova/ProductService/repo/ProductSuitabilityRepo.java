package ru.zyryanova.ProductService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.zyryanova.ProductService.entity.bd.ProductSuitability;

@Repository
public interface ProductSuitabilityRepo extends JpaRepository<ProductSuitability, Integer> {
    @Modifying
    @Query(value = """
        insert into product_suitability (product_id, hair_type_id)
        values (:productId, :hairTypeId)
        on conflict (product_id, hair_type_id) do nothing
        """, nativeQuery = true)
    void insertIfNotExists(@Param("productId") Integer productId,
                           @Param("hairTypeId") Integer hairTypeId);

}
