package com.example.st.Repository;

import com.example.st.Domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    Optional<Orders> findById(Long id);
    List<Orders> findByMember_Id(Long member_Id);
    List<Orders> findByProduct_Id(Long product_Id);
    List<Orders> findByStateAndProduct_Id(Long state, Long product_Id);
    List<Orders> findByStateAndMember_Id(Long state, Long member_Id);
    List<Orders> findByState(Long state);
    List<Orders> findByStateGreaterThan(Long state);
}
