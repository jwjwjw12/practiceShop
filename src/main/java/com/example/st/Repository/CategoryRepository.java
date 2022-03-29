package com.example.st.Repository;

import com.example.st.Domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findById(long id);
    Optional<Category> findByName(String name);
}
