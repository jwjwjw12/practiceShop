package com.example.st.Domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Long price;
    private Long remaining;

    @ManyToOne
    @JoinColumn(name = "category.id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "mini.id")
    private Mini mini;

    @Builder
    public Product(Long id, String name, Long price, Long remaining, Category category, Mini mini){
        this.id = id;
        this.name = name;
        this.price = price;
        this.remaining = remaining;
        this.category = category;
        this.mini = mini;
    }

    public Product(String name, Long price, Long remaining, Category category, Mini mini){
        this.name = name;
        this.price = price;
        this.remaining = remaining;
        this.category = category;
        this.mini = mini;
    }
}
