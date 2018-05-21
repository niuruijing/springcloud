package com.hj.oauth.service;

import com.hj.oauth.entity.OauthRoleView;
import com.hj.oauth.mapper.OauthRoleViewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by niuruijing on 2018/5/18.
 */
@Service(value = "userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private OauthRoleViewMapper oauthRoleViewMapper;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        String username = s.toLowerCase();
        List<OauthRoleView> oauthRoleView = oauthRoleViewMapper.getListOauthByUsername(username);
        if (oauthRoleView.size()>0){
            Set<GrantedAuthority> userAuthotities = new HashSet<>();
            for(OauthRoleView authority : oauthRoleView){
                userAuthotities.add(new SimpleGrantedAuthority(authority.getAuthorityValue()));
            }
            return new User(oauthRoleView.get(0).getUsername(),oauthRoleView.get(0).getPassword(),userAuthotities);
        }
        return null;
    }


}
