package com.example.st.Domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private String viewName;

    @Column(columnDefinition = "Long default 1")
    private int auth = 1;

    @Builder
    public Member(Long id, String username, String password, String viewName, int auth){
        this.id = id;
        this.username = username;
        this.password = password;
        this.viewName = viewName;
        this.auth = auth;
    }
}
