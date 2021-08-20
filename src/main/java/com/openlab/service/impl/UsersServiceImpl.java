package com.openlab.service.impl;

import com.openlab.dao.UsersDao;
import com.openlab.pojo.Users;
import com.openlab.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersDao usersDao;

    @Override
    public List<Users> getUsersList() {
        return usersDao.findAll();
    }

    @Override
    public void createUsers(Users users) {
        usersDao.save(users);
    }

    @Override
    public Users getUsersById(Long id) {
        return usersDao.getById(id);
    }

    @Override
    public void updateUsers(Long id, Users users) {
        users.setId(id);
        usersDao.saveAndFlush(users);
    }

    @Override
    public void deleteById(Long id) {
        usersDao.deleteById(id);
    }
}
