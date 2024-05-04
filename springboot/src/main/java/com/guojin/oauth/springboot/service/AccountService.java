package com.guojin.oauth.springboot.service;

import com.guojin.oauth.springboot.model.Account;
import com.guojin.oauth.springboot.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AccountService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void register(Account user) {
        Account existUser = accountRepository.findByEmail(user.getEmail());
        if(existUser != null){
        }else{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            accountRepository.save(user);
        }



    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(email);
        if(account != null){
            return new org.springframework.security.core.userdetails.User(
                    account.getEmail(),account.getPassword(),getAuthorities());
        }
        throw new UsernameNotFoundException("User not found");
    }



    private Collection<? extends GrantedAuthority> getAuthorities(){

        List<GrantedAuthority> authorities = new ArrayList<>();

        return  authorities;
    }
}
