package com.example.st.Dto;

import com.example.st.Domain.Category;
import com.example.st.Domain.Mini;
import com.example.st.Domain.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private Long price;
    private Long remaining;
    private Category category;
    private Mini mini;

    public Product toEntity(){
        return Product.builder()
                .id(id)
                .name(name)
                .price(price)
                .remaining(remaining)
                .category(category)
                .mini(mini)
                .build();
    }

    @Builder
    public ProductDto(Long id, String name, Long price, Long remaining, Category category, Mini mini){
        this.id = id;
        this.name = name;
        this.price = price;
        this.remaining = remaining;
        this.category = category;
        this.mini = mini;
    }
}
