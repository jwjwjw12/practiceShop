package com.example.st.Controller.ViewController;

import com.example.st.Repository.OrdersRepository;
import com.example.st.Service.CustomUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/my")
public class MyPageViewController {
    OrdersRepository orderRepository;

    @GetMapping
    public String myPage(@AuthenticationPrincipal CustomUser customUser){

        if(customUser != null) {
            System.out.println(customUser.getId());
            return "home/myPage";
        }
        else {
            System.out.println("비로그인 !!");
            return "redirect:/";
        }
    }
}
