package com.security.ATMDemo.dao;

import com.security.ATMDemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Liviu
 *
 * Added a UserRepository that extents the JpaRepository so we can persists or retrieve users from the DB
 */

public interface UserRepository extends JpaRepository<User, Long> {

    // used to retrieve the user if it exists

    @Query("SELECT u FROM User u where u.userName = :username")
    User findByUserName(@Param("username") String userName);
}
