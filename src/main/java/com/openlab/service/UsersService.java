package com.openlab.service;

import com.openlab.pojo.Users;

import java.util.List;


public interface UsersService {

    public List<Users> getUsersList();
    public void createUsers(Users users);
    public Users getUsersById(Long id);
    public void updateUsers(Long id,Users users);
    public void deleteById(Long id);
}
