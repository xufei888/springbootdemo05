package com.openlab.dao;

import com.openlab.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDao extends JpaRepository<Users,Long> {

    public Users findByName(String name);
    public Users findByNameAndAge(String name,Integer age);
}
