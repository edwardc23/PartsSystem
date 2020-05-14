package com.example.demo.dao;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Parts;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.servlet.http.Part;
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
        Query<Parts> listQuery = sesh.createQuery("from Parts");
        return listQuery.getResultList();
    }

    @Override
    @Transactional
    public void clearInventory() {
        sesh = manager.unwrap(Session.class);
        String hql = String.format("delete from Parts");
        Query query = sesh.createQuery(hql);
        query.executeUpdate();
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
//        Query<Parts> deleteQuery = sesh.createQuery("delete from Parts where id=:ID");
//        deleteQuery.setParameter("ID:", partID);
//        deleteQuery.executeUpdate();
        Parts myParts = sesh.get(Parts.class, partID );
        sesh.delete(myParts);
        //sesh.clear();
    }


    @Override
    @Transactional
    public void saveNew(Parts part) {
        sesh = manager.unwrap(Session.class);
        sesh.saveOrUpdate(part);
    }

    @Override
    @Transactional
    public void saveAdmin(Admin admin) {
        sesh = manager.unwrap(Session.class);
        sesh.saveOrUpdate(admin);
    }

}
