package com.example.st.Dto;

import com.example.st.Domain.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {
    private Long id;
    private String name;

    public Category toEntity(){
        return Category.builder()
                .id(id)
                .name(name)
                .build();
    }

    @Builder
    public CategoryDto(Long id, String name){
        this.id = id;
        this.name = name;
    }

}
