package com.example.st.Controller.ApiController;

import com.example.st.Domain.Product;
import com.example.st.Repository.CategoryRepository;
import com.example.st.Repository.MiniRepository;
import com.example.st.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    ProductRepository productRepository;
    MiniRepository miniRepository;
    CategoryRepository categoryRepository;

    @GetMapping("{category}")
    public List<Product> findByCategory(@PathVariable String category){
        return productRepository.findByCategory_Id(Long.parseLong(category));
    }

    @GetMapping("/category/{category}/mini/{mini}")
    public List<Product> findByCategoryAndMini(@PathVariable String category, @PathVariable String mini){
        return productRepository.findByCategory_IdAndMini_Id(Long.parseLong(category), Long.parseLong(mini));
    }

    @GetMapping("/all")
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    @GetMapping("/delete/{product_Id}")
    public String deleteCategory(@PathVariable String product_Id){
        productRepository.delete(productRepository.findById(Long.parseLong(product_Id)).get());

        return "";
    }
}
