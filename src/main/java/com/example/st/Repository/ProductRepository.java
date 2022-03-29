package com.example.st.Repository;

import com.example.st.Domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory_Id(Long category);
    List<Product> findByCategory_IdAndMini_Id(Long category_Id, Long mini_Id);

    Optional<Product> findById(Long id);

    @Query(value = "select * from product order by rand() limit 4", nativeQuery = true)
    List<Product> findByRandLimitFour();
}
