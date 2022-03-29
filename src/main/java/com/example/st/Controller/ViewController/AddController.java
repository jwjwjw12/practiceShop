package com.example.st.Controller.ViewController;

import com.example.st.Domain.Category;
import com.example.st.Domain.Member;
import com.example.st.Domain.Orders;
import com.example.st.Domain.Product;
import com.example.st.Repository.CategoryRepository;
import com.example.st.Repository.MemberRepository;
import com.example.st.Repository.OrdersRepository;
import com.example.st.Repository.ProductRepository;
import com.example.st.Service.CustomUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/add")
public class AddController {
    OrdersRepository ordersRepository;
    ProductRepository productRepository;
    MemberRepository memberRepository;
    CategoryRepository categoryRepository;

    @GetMapping("/orders/{product_Id}")
    public String addOrders(@AuthenticationPrincipal CustomUser customUser, @PathVariable String product_Id){
        Product product = productRepository.findById(Long.parseLong(product_Id)).get();
        Member member = memberRepository.findById(customUser.getId()).get();
        ordersRepository.save(new Orders(member, product, (long)0, "", System.currentTimeMillis(), (long)0));

        return "redirect:/my";
    }
}
