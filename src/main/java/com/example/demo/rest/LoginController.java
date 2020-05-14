package com.example.demo.rest;

import com.example.demo.dao.DAO;
import com.example.demo.dao.LoginDAO;
import com.example.demo.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class LoginController {
    private final LoginDAO loginDAO;

    @Autowired
    public LoginController(DAO dao, LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }
    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin admin){
        admin.setId(0);
        loginDAO.saveAdmin(admin);
        System.out.println(admin);
        return admin;
    }

}
