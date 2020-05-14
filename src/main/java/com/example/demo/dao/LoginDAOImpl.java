package com.example.demo.dao;

import com.example.demo.entity.Admin;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
public class LoginDAOImpl implements LoginDAO {
    private EntityManager entityManager;

    @Autowired
    public LoginDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveAdmin(Admin admin) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(admin);
    }
}
