package com.example.st.Repository;

import com.example.st.Domain.Mini;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MiniRepository extends JpaRepository<Mini, Long> {
    List<Mini> findByCategory_Id(long category_Id);
    Optional<Mini> findById(long id);
    Optional<Mini> findByName(String name);
}
