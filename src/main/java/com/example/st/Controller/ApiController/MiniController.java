package com.example.st.Controller.ApiController;

import com.example.st.Domain.Category;
import com.example.st.Domain.Mini;
import com.example.st.Repository.CategoryRepository;
import com.example.st.Repository.MiniRepository;
import com.example.st.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/mini")
public class MiniController {
    MiniRepository miniRepository;
    CategoryRepository categoryRepository;
    ProductRepository productRepository;

    @GetMapping("/all")
    public List<Mini> findAll(){
        return miniRepository.findAll();
    }

    @GetMapping("/category/{category}")
    public List<Mini> findByCategory(@PathVariable String category){
        Integer categoryId = Integer.parseInt(category);

        return  miniRepository.findByCategory_Id(categoryId);
    }

    @GetMapping("/id/{id}")
    public Optional<Mini> getCategoryById(@PathVariable String id){
        Integer categoryId = Integer.parseInt(id);

        return miniRepository.findById(categoryId);
    }

    @GetMapping("/delete/{mini_Id}")
    public String deleteCategory(@PathVariable String mini_Id){
        Mini mini = miniRepository.findById(Long.parseLong(mini_Id)).get();
        if(productRepository.findByCategory_IdAndMini_Id(mini.getCategory().getId(), mini.getId()).size() != 0)
            return "fail";
        else {
            miniRepository.delete(mini);
            return "success";
        }
    }
}