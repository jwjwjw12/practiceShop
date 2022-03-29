package com.example.st.Controller.ApiController;

import com.example.st.Domain.Mini;
import com.example.st.Repository.CategoryRepository;
import com.example.st.Repository.MiniRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/test/api")
public class TestController {
    MiniRepository miniRepository;
    CategoryRepository categoryRepository;

    @GetMapping("/change/{miniId}")
    public Mini findByCategory(@PathVariable String miniId){
        Integer mini_id = Integer.parseInt(miniId);

        Mini mini = miniRepository.findById(mini_id).get();

        mini.setName("바뀜??");

        miniRepository.save(mini);

        return mini;
    }

    @GetMapping("/change2/{miniId}")
    public Mini findByCategory2(@PathVariable String miniId){
        Integer mini_id = Integer.parseInt(miniId);

        Mini mini = miniRepository.findById(mini_id).get();

        mini.setName("공부책");

        miniRepository.save(mini);

        return mini;
    }

    @GetMapping("/check/{miniId}")
    public Mini check(@PathVariable String miniId){
        Integer mini_id = Integer.parseInt(miniId);

        Mini mini = miniRepository.findById(mini_id).get();

        return mini;
    }
}