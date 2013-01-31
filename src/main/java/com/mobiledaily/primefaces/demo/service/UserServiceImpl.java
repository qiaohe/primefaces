package com.mobiledaily.primefaces.demo.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Johnson
 * Date: 1/25/13
 * Time: 4:36 PM
 * To change this template use File | Settings | File Templates.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Override
    public List getUsers() {
        return null;
    }

    @Override
    public String getUsersAsString() {
        return "Hello World";
    }
}
