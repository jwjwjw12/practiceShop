package com.example.st.Domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Mini {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "category.id")
    private Category category;

    @Builder
    public Mini(Long id, String name, Category category){
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public Mini(String name, Category category){
        this.name = name;
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }
}
