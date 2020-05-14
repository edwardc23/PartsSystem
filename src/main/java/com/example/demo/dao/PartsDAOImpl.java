package com.example.demo.dao;

import com.example.demo.entity.Parts;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PartsDAOImpl implements DAO{
    private EntityManager manager;
    private Session sesh;

    @Autowired
    public PartsDAOImpl(EntityManager manager){this.manager=manager;}

    @Override
    @Transactional
    public List<Parts> listInventory() {
        sesh = manager.unwrap(Session.class);
        Query<Parts> listQuery = sesh.createQuery("from parts");
        return listQuery.getResultList();
    }

    @Override
    @Transactional
    public void clearInventory(List<Parts> inventory) {
        sesh = manager.unwrap(Session.class);
        Query<Parts> clearQuery = sesh.createQuery("truncate parts"); //query to clear inventory
        //clearQuery.getResultList().clear();
        clearQuery.getResultList();
    }


    @Override
    @Transactional
    public Parts findID(int partID) {
        sesh = manager.unwrap(Session.class);
        Parts item = sesh.get(Parts.class, partID);
        return item;
    }

    @Override
    @Transactional
    public void deleteID(int partID) {
        sesh = manager.unwrap(Session.class);
        Query<Parts> deleteQuery = sesh.createQuery("delete from parts where id=:ID");
        deleteQuery.setParameter("ID:", partID);
        deleteQuery.executeUpdate();
    }


    @Override
    @Transactional
    public void saveNew(Parts part) {
        sesh = manager.unwrap(Session.class);
        sesh.save(part);
    }
}
