package com.example.demo.dao;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Assets;
import com.example.demo.entity.Parts;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.servlet.http.Part;
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
        asset();
        sesh = manager.unwrap(Session.class);
        Query<Assets> listQuery = sesh.createQuery("from Assets");
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

    @Override
    public void purchase(Parts part, double total) {
        sesh = manager.unwrap(Session.class);
        double totalMSRP=0.00;
        totalMSRP=totalMSRP+part.getMsrp();

    }
public void deleteAssets(){
    sesh = manager.unwrap(Session.class);
    sesh.createSQLQuery("truncate table Assets").executeUpdate();
}
    public void asset()
    {
        deleteAssets();
        int index=0;
        List<Parts>parts = listInventory();
        Assets assets= new Assets();
        ArrayList<Assets> l= new ArrayList<>();
        double total=0;
        double totalCost=0;
        int x=1;
        HashMap<Parts, Integer> listed= new HashMap<>();

        for(Parts a: parts)
        {
           if(index!=0&&parts.get(index-1).getPartName().equals(a.getPartName())){
               x++;

           }
           else {
               x=1;
               index++;
           }
            listed.put(a,x);
        }
        for(var p :listed.entrySet())
        {

            total=p.getValue()*p.getKey().getPrice();
            totalCost=totalCost+total;
            assets.setPart(p.getKey().getPartName());
            assets.setAmountOf(p.getValue());
            assets.setCost(total);
            assets.setTotalCost(totalCost);
            total=0;
            assets.setTotalMSRP(0.00);


            l.add(assets);

            CRUD.createAssets(assets.getPart(),assets.getAmountOf(),assets.getCost(),assets.getTotalMSRP(),assets.getTotalCost());

        }





    }
    public void updateAsset()
    {

    }

}
