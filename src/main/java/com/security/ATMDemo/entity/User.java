package com.security.ATMDemo.entity;

import javax.persistence.*;

/**
 * Created by Liviu on 12/11/2020
 *
 * This entity will also be used to create the "user" table
 * in the in memory DB (H2)
 */

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "amount")
    private int amount;

    public User() {
    }

    public User(String userName, String password, int amount) {
        this.userName = userName;
        this.password = password;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", amount=" + amount +
                '}';
    }
}
