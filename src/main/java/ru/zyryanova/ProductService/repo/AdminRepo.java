package ru.zyryanova.ProductService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zyryanova.ProductService.entity.admin.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {
    Admin findByUsername(String username);
}