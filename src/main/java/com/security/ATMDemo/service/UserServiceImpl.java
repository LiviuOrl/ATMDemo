package com.security.ATMDemo.service;

import com.security.ATMDemo.dao.UserRepository;
import com.security.ATMDemo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Liviu
 *
 * Implementation for the UserService
 */

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log =
            LoggerFactory.getLogger(UserServiceImpl.class);

    // inject userRepository
    @Autowired
    private UserRepository userRepository;

    // inject passwordEncoder
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // used to retrieve the user if it exists
    @Override
    @Transactional
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    // Once the user has authenticated, we check the authority for roles.
    // I don't really have roles for this app but I need to implement the below method
    // because I'm using the "UserDetailsService" interface
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.info("===LoadUserByUsername method beginning ");

        User user = userRepository.findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        log.info("===User found: " + user);

        // return a UserDetails object
        return new org.springframework.security.core.userdetails.User(user.getUserName(),
                user.getPassword(), getAuthorities());
    }


    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

        list.add(new SimpleGrantedAuthority("ROLE_"));

        return list;
    }
}
