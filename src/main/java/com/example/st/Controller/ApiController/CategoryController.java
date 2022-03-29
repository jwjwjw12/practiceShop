package com.example.st.Controller.ApiController;

import com.example.st.Domain.Category;
import com.example.st.Repository.CategoryRepository;
import com.example.st.Repository.MiniRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {
    CategoryRepository categoryRepository;
    MiniRepository miniRepository;

    @GetMapping("")
    public List<Category> getAllCategories(){

        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategoryById(@PathVariable String id){
        Integer categoryId = Integer.parseInt(id);

        return categoryRepository.findById(categoryId);
    }

    @GetMapping("/delete/{category_Id}")
    public String deleteCategory(@PathVariable String category_Id){
        if(miniRepository.findByCategory_Id(Long.parseLong(category_Id)).size() != 0)
            return "fail";
        else {
            categoryRepository.delete(categoryRepository.findById(Long.parseLong(category_Id)).get());
            return "success";
        }
    }
}
