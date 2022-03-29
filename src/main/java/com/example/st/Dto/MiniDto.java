package com.example.st.Dto;

import com.example.st.Domain.Category;
import com.example.st.Domain.Mini;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MiniDto {
    private Long id;
    private String name;
    private Category category;

    public Mini toEntity(){
        return Mini.builder()
                .id(id)
                .name(name)
                .category(category)
                .build();
    }

    @Builder
    public MiniDto(Long id, String name, Category category){
        this.id = id;
        this.name = name;
        this.category = category;
    }
}
