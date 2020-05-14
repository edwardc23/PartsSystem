package com.example.demo.dao;

import com.example.demo.entity.Admin;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

public interface LoginDAO {
        void saveAdmin(Admin admin);
        //void createUser(Login newUser);


}
