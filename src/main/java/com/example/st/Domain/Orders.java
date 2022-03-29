package com.example.st.Domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Orders {

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
    state = 0  : 고객이 주문 요청한 상태
    state = 1  : 구매 확정된 상태
    state = 2  : 리뷰가 작성된 상태

    state = -1 : 주문 취소된 상태 이때 review 는 주문취소 사유
     */

    private Long state;
    private String review;
    private Long score;
    private Long date;

    @Builder
    public Orders(Long id, Member member, Product product, Long state, String review, Long date, Long score){
        this.id = id;
        this.member = member;
        this.product = product;
        this.state = state;
        this.review = review;
        this.date = date;
        this.score = score;
    }

    public Orders(Member member, Product product, Long state, String review, Long date, Long score){
        this.member = member;
        this.product = product;
        this.state = state;
        this.review = review;
        this.date = date;
        this.score = score;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public void setScore(Long score) { this.score = score;
    }
}
