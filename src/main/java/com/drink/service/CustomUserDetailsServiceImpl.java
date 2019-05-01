package com.drink.service;

import com.drink.entity.Role;
import com.drink.entity.UserDetail;
import com.drink.mapper.AuthMapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * 登陆身份认证
 * @author: JoeTao
 * createAt: 2018/9/14
 */
@Component(value="CustomUserDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    private final AuthMapper authMapper;

    public CustomUserDetailsServiceImpl(AuthMapper authMapper) {
        this.authMapper = authMapper;
    }

    @Override
    public UserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetail userDetail = authMapper.findByUsername(username);
        if (userDetail == null) {
            throw new UsernameNotFoundException(String.format("No userDetail found with username '%s'.", username));
        }
//        Role role = authMapper.findRoleByUserId(userDetail.getId());
//        userDetail.setRole(role);
        return userDetail;
    }
}
