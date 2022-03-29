package com.example.st.Service;

import com.example.st.Domain.Member;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;

// lombok 사용
// Security 에서 사용되는 User 에서 파라미터를 추가함.
//@Data         // constructor 도중 에러가 발생하므로 사용하지 않음
@Getter
@Setter
@ToString
public class CustomUser extends User {
    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    // 유저의 정보를 더 추가하고 싶다면 이곳과, 아래의 생성자 파라미터를 조절해야 한다.
    private String viewName;
    private Long id;

    public CustomUser(String username, String password, Collection authorities, String viewName, Long id) {
        super(username, password, authorities);
        this.viewName = viewName;
        this.id = id;
    }
}
