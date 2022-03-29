package com.example.st.Controller.ViewController;

import com.example.st.Domain.*;
import com.example.st.Repository.*;
import com.example.st.Service.CustomUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    CategoryRepository categoryRepository;
    MiniRepository miniRepository;
    ProductRepository productRepository;

    @GetMapping("/add/category")
    public String addCategory(@RequestParam String category_name){
        categoryRepository.save(new Category(category_name));

        return "redirect:/admin/product";
    }

    @GetMapping("/add/mini")
    public String addMini(@RequestParam String mini_name, @RequestParam String category_id){
        Category category = categoryRepository.findById(Long.parseLong(category_id)).get();
        miniRepository.save(new Mini(mini_name, category));

        return "redirect:/admin/product";
    }

    @GetMapping("/add/product")
    public String addProduct(@RequestParam String product_name, @RequestParam String product_price, @RequestParam String product_remaining, @RequestParam String category_id, @RequestParam String mini_id){

        System.out.println("categoryId = " + category_id);
        System.out.println("miniId = " + mini_id);
        System.out.println("price, remaining, productName = " + product_price + ", " + product_remaining + ", " + product_name);


        Category category = categoryRepository.findById(Long.parseLong(category_id)).get();
        Mini mini = miniRepository.findById(Long.parseLong(mini_id)).get();

        long price = Long.parseLong(product_price);
        long remaining = Long.parseLong(product_remaining);
        productRepository.save(new Product(product_name, price, remaining, category, mini));

        return "redirect:/admin/product";
    }

    @GetMapping("/product")
    public String productPage(){
        return "admin/productControlPage";
    }

    @GetMapping("/order")
    public String orderPage(){
        return "admin/orderControlPage";
    }

    @GetMapping("/question")
    public String questionPage(){
        return "admin/questionControlPage";
    }

    @GetMapping("/qna")
    public String qnaPage(){
        return "admin/productControlPage";
    }

    @GetMapping("/event")
    public String eventPage(){
        return "admin/productControlPage";
    }

    @GetMapping("/notice")
    public String noticePage(){
        return "admin/productControlPage";
    }
}

