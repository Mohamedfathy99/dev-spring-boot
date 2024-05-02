package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImplementation implements AccountDAO{
    @Override
    public void addSillyMember() {

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }
}
