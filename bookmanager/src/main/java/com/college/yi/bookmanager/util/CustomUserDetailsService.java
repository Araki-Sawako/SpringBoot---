package com.college.yi.bookmanager.util;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User as SecurityUser; // 別名にしないと自作の User と名前が衝突します

import org.springframework.stereotype.Service;
import com.college.yi.bookmanager.Mapper.UserMapper;
import com.college.yi.bookmanager.entity.User;

import java.util.Collections;

class userSecurity{
	
}

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserMapper userMapper;

    public CustomUserDetailsService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("ユーザーが見つかりません: " + username);
        }

        // ユーザーの権限を設定（ROLE_ 前置詞を付加）
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + user.getRole());

        return new UserDetails(
            user.getUsername(),
            user.getPassword(),
            user.isEnabled(),        // enabled
            true,                    // accountNonExpired
            true,                    // credentialsNonExpired
            true,                    // accountNonLocked
            Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole()))   //光ってないけど大丈夫そ？？
                );
    }
}
