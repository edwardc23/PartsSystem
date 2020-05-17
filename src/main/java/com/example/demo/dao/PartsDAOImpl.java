package com.example.demo.dao;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Assets;
import com.example.demo.entity.Parts;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.*;

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
    public List<Assets> listAssets() {

        sesh = manager.unwrap(Session.class);
        Query<Assets> listQuery = sesh.createQuery("from Assets");
        List<Assets> a= listQuery.getResultList();
        //asset(a);
        return a;
    }

    @Override
    @Transactional
    public void clearInventory() {
        deleteAssetsAndInventory();
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
        Parts myParts = sesh.get(Parts.class, partID );
        sesh.delete(myParts);

        //sesh.clear();
    }


    @Override
    @Transactional
    public void saveNew(Parts part) {
        sesh = manager.unwrap(Session.class);
        newAsset(part);
        sesh.saveOrUpdate(part);
    }

    @Override
    @Transactional
    public void saveAdmin(Admin admin) {
        sesh = manager.unwrap(Session.class);
        sesh.saveOrUpdate(admin);
    }



    @Override
    @Transactional
    public void purchase(Parts part,int id) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Assets.class)
                .buildSessionFactory();

        sesh = manager.unwrap(Session.class);
        Assets a = null;

        List<Assets> list=listAssets();
        for(int index=0;index<list.size();index++){
            if(list.get(index).getPart().equals(part.getPartName())){
                a = sesh.get(Assets.class, index+1 );
                a.setAmountOf(list.get(index).getAmountOf()-1);
                a.setTotalMSRP(part.getMsrp()+list.get(index).getTotalMSRP());
                a.setProfit(a.getMsrp()+a.getTotalCost());
                if(a.getAmountOf()==0)
                {
                    deleteID(id);
                }
                sesh.update(a);
                Session session = factory.getCurrentSession();
                session.beginTransaction();
                double s = a.getProfit();
                String q="update Assets set Profit="+s+"";
                session.createQuery(q).executeUpdate();
                session.getTransaction().commit();
                factory.close();

                break;
            }
        }


    }

    public void deleteAssetsAndInventory(){
    sesh = manager.unwrap(Session.class);
    sesh.createSQLQuery("truncate table Assets").executeUpdate();
    sesh.createSQLQuery("truncate table Parts").executeUpdate();
}


    public void newAsset(Parts p)
    {

        int x=1;
        int ans=0;
        double ms=0;

        sesh = manager.unwrap(Session.class);
        Assets a = null;
        List<Assets> list=listAssets();
        for(int index=0;index<list.size();index++){
            if(list.get(index).getPart().equals(p.getPartName())){
                a = sesh.get(Assets.class, index+1 );
                a.setAmountOf(list.get(index).getAmountOf()+1);
                a.setTotalCost(list.get(index).getTotalCost()-p.getPrice());
                a.setProfit(a.getTotalCost());

                sesh.update(a);
                ans++;
                break;
            }
        }
        if(ans==0){
            double tC= Math.negateExact((int)p.getPrice());
         a = new Assets(p.getPartName(),1,p.getPrice(),p.getMsrp(),0.00,tC,tC);
         sesh.saveOrUpdate(a);}





    }
    @Override
    @Transactional
    public  boolean checkUserAndPass(Admin admin)
    {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Admin.class)
                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List info= session.createQuery("From Admin").list();
        factory.close();
        return  check(info,admin);
    }
    public static boolean check(List<Admin>e, Admin admin)
    {

        for(Admin a:e)
        {
            if(admin.getUserName().equals(a.getUserName()))
            {
                if(admin.getPassword().equals(a.getPassword()))
                {

                    return true;
                }
            }
        }
        return false;
    }



}
