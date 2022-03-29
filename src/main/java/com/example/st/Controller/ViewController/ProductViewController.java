package com.example.st.Controller.ViewController;

import com.example.st.Domain.*;
import com.example.st.Repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class ProductViewController {
    ProductRepository productRepository;
    MiniRepository miniRepository;
    CategoryRepository categoryRepository;
    MemberRepository memberRepository;
    OrdersRepository ordersRepository;

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("/home/index");

        mav.addObject("products", productRepository.findByRandLimitFour());

        return mav;
    }

    @GetMapping(value = "/productList/{category}")
    public ModelAndView productList(@PathVariable String category){
        ModelAndView mav = new ModelAndView("/product/productList");

        Long categoryId = Long.parseLong(category);

        List<Product> products = productRepository.findByCategory_Id(categoryId);

        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        mav.addObject("category", products.get(0).getCategory().getName());
        mav.addObject("minis", miniRepository.findByCategory_Id(categoryId));
        mav.addObject("products", products);

        return mav;
    }

    @GetMapping(value = "/product/{id}")
    public ModelAndView productInfo(@PathVariable String id){
        ModelAndView mav = new ModelAndView("/product/productInfo");

        Long productId = Long.parseLong(id);

        Optional<Product> product = productRepository.findById(productId);
        Optional<Mini> mini = miniRepository.findById(product.get().getMini().getId());
        Optional<Category> category = categoryRepository.findById(product.get().getCategory().getId());

        mav.addObject("product", product.get());
        mav.addObject("mini", mini.get().getName());
        mav.addObject("category", category.get().getName());

        return mav;
    }

    @GetMapping(value = "/orders/{id}")
    public ModelAndView productOrders(@PathVariable String id){
        ModelAndView mav = new ModelAndView("/product/productBuy");

        Optional<Product> product = productRepository.findById(Long.parseLong(id));

        mav.addObject("product", product.get());

        return mav;
    }
}
