package com.security.ATMDemo.service;

import com.security.ATMDemo.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by Liviu
 */

public interface UserService extends UserDetailsService {

    // used to retrieve the user if it exists
    User findByUserName(String userName);
}
