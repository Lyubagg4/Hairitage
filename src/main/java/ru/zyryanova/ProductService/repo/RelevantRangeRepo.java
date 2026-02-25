package ru.zyryanova.ProductService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zyryanova.ProductService.entity.bd.Ingredient;
import ru.zyryanova.ProductService.entity.bd.RelevantRange;

import java.util.List;
import java.util.Optional;

@Repository
public interface RelevantRangeRepo extends JpaRepository<RelevantRange, Integer> {
    Optional<Ingredient> findByPurposeIngId(Integer id);

    List<RelevantRange> findByHairType_HairTypeIdIn(List<Integer> hairTypeIds);

}