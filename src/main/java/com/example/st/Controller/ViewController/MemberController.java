package com.example.st.Controller.ViewController;

import com.example.st.Dto.MemberDto;
import com.example.st.Service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private MemberService memberService;

    @GetMapping("/signup")
    public String signupForm(Model model){
        model.addAttribute("member", new MemberDto());

        return "/member/signupForm";
    }

    @PostMapping("/signup")
    public String signup(MemberDto memberDto){
        memberService.signup(memberDto);

        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(){
        return "/member/loginForm";
    }
}
