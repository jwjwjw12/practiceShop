package com.example.st.Controller.ApiController;

import com.example.st.Domain.Orders;
import com.example.st.Repository.OrdersRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/orders")
public class OrdersController {
    OrdersRepository orderRepository;

    @GetMapping("/yet/all")
    public List<Orders> findAll(){
        return orderRepository.findByState((long)0);
    }

    @GetMapping("/okay/all")
    public List<Orders> findChecked(){ return orderRepository.findByStateGreaterThan((long)0);}

    @GetMapping("/member/{id}")
    public List<Orders> findByMember(@PathVariable String id){
        Long member_Id = Long.parseLong(id);

        return orderRepository.findByMember_Id(member_Id);
    }

    @GetMapping("/product/{id}")
    public List<Orders> findByProduct(@PathVariable String id){
        Long product_Id = Long.parseLong(id);

        return orderRepository.findByProduct_Id(product_Id);
    }

    @GetMapping("/reviews/product/{id}")
    public List<Orders> findReviewsByProduct_id(@PathVariable String id){
        Long product_id = Long.parseLong(id);

        return orderRepository.findByStateAndProduct_Id((long)2, product_id);
    }

    @GetMapping("/reviews/member/{id}")
    public List<Orders> findReviewsByMember_id(@PathVariable String id){
        Long member_id = Long.parseLong(id);

        return orderRepository.findByStateAndMember_Id((long)2, member_id);
    }

    @GetMapping("/review/add/{id}")
    public String addReview(@PathVariable String id, @RequestParam String review, @RequestParam Long score){
        Long orders_id = Long.parseLong(id);

        Orders orders = orderRepository.findById(orders_id).get();
        orders.setReview(review);
        orders.setState((long)2);
        orders.setScore(score);

        orderRepository.save(orders);

        return "OK";
    }

    @GetMapping("/state/{id}")
    public String setState(@PathVariable String id, @RequestParam String state){
        Long orders_id = Long.parseLong(id);
        Long state_long = Long.parseLong(state);

        Orders orders = orderRepository.findById(orders_id).get();
        orders.setState(state_long);

        orderRepository.save(orders);

        return "OK";
    }

    @GetMapping("/state/list")
    public String checkState(@RequestParam(required = false, value = "ids[]") List<String> ids, @RequestParam String state){
        Long state_long = Long.parseLong(state);

        for(String id : ids){
            Orders orders = orderRepository.findById(Long.parseLong(id)).get();
            orders.setState(state_long);

            orderRepository.save(orders);
        }

        return "OK";
    }
}
