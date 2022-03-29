package com.example.st.Domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Question {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member.id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "product.id")
    private Product product;

    /*
        state = 1  :  질문 O 답 X
        state = 2  :  질문 O 답 O
     */
    private int state;
    private String question;
    private String answer;
    private Long date;

    @Builder
    public Question(Long id, Member member, Product product, int state, String question, String answer, Long date){
        this.id = id;
        this.member = member;
        this.product = product;
        this.state = state;
        this.question = question;
        this.answer = answer;
        this.date = date;
    }

    public Question(Member member, Product product, int state, String question, Long date){
        this.member = member;
        this.product = product;
        this.state = state;
        this.question = question;
        this.answer = answer;
        this.date = date;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setState(int state) {
        this.state = state;
    }
}
