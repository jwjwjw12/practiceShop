package com.example.st.Dto;

import com.example.st.Domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberDto {
    private Long id;
    private String username;
    private String password;
    private String viewName;
    private int auth;

    public Member toEntity(){
        return Member.builder()
                .id(id)
                .username(username)
                .password(password)
                .viewName(viewName)
                .auth(auth)
                .build();
    }

    @Builder
    public MemberDto(Long id, String username, String password, String viewName, int auth){
        this.id = id;
        this.username = username;
        this.password = password;
        this.viewName = viewName;
        this.auth = auth;
    }
}
