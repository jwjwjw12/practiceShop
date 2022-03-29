package com.example.st.Controller.ApiController;

import com.example.st.Domain.Member;
import com.example.st.Domain.Product;
import com.example.st.Domain.Question;
import com.example.st.Repository.MemberRepository;
import com.example.st.Repository.ProductRepository;
import com.example.st.Repository.QuestionRepository;
import com.example.st.Service.CustomUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/question")
public class QuestionController {
    QuestionRepository questionRepository;
    ProductRepository productRepository;
    MemberRepository memberRepository;

    @GetMapping("/add/{product_Id}")
    public String addQuestion(@PathVariable String product_Id, @RequestParam String question, @AuthenticationPrincipal CustomUser customUser){
        Product product = productRepository.findById(Long.parseLong(product_Id)).get();
        Member member = memberRepository.findById(customUser.getId()).get();
        questionRepository.save(new Question(member, product, 1, question, System.currentTimeMillis()));

        return "success";
    }

    @GetMapping("/product/{id}")
    public List<Question> findByProduct(@PathVariable String id){
        Long product_id = Long.parseLong(id);

        return questionRepository.findByProduct_Id(product_id);
    }

    @GetMapping("/member/{id}")
    public List<Question> findByMember(@PathVariable String id){
        Long member_id = Long.parseLong(id);

        return questionRepository.findByMember_Id(member_id);
    }

    @GetMapping("/answer/{id}")
    public String addAnswer(@PathVariable String id, @RequestParam String answer){
        Long member_id = Long.parseLong(id);

        Question question = questionRepository.findById(member_id).get();
        question.setAnswer(answer);
        question.setState(2);

        questionRepository.save(question);

        return "OK";
    }
}
