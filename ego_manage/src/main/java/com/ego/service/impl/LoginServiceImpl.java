package com.ego.service.impl;

import com.ego.dubbo.service.ManagerDubboService;
import com.ego.pojo.Manager;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements UserDetailsService {
    @DubboReference
    private ManagerDubboService managerDubboService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Manager manager = managerDubboService.selectManagerByUsername(s);
        if (manager == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return new User(s, manager.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList(""));
    }
}
