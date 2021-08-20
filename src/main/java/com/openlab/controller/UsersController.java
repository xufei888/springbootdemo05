package com.openlab.controller;

import com.openlab.pojo.Users;

import com.openlab.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/")
    public String getUsersList(Model model){
        List<Users> usersList = usersService.getUsersList();
        model.addAttribute("page",usersList);
        return "user/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "user/userAdd";  //跳转到userAdd页面
    }

    @RequestMapping("/add")
    public String createUsers(Users users){
        usersService.createUsers(users);
        return "redirect:/users/";
    }

    @RequestMapping("/toEdit/{id}")
    public String toEdit(Model model, @PathVariable("id")Long id){
        Users users = usersService.getUsersById(id);
        model.addAttribute("users",users);
        return "user/userEdit";    //跳转到userEdit页面
    }

    @RequestMapping("/edit")
    public String edit(Users users){
        usersService.updateUsers(users.getId(),users);
        return "redirect:/users/";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUsers(@PathVariable("id")Long id){
        usersService.deleteById(id);
        return "redirect:/users/";
    }
}
