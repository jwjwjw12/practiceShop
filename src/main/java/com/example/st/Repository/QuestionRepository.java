package com.example.st.Repository;

import com.example.st.Domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Optional<Question> findById(Long id);
    List<Question> findByProduct_Id(Long product_id);
    List<Question> findByMember_Id(Long member_id);
}
