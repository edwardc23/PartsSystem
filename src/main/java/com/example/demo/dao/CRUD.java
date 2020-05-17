package com.example.demo.dao;


import com.example.demo.entity.Admin;
import com.example.demo.entity.Assets;
import com.example.demo.entity.Parts;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class CRUD {



//    public static void createAssets(String part, int amountOf,double cost, double totalMSRP, double totalPrice) {
//
//        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Assets.class)
//                .buildSessionFactory();
//
//        //create a session this is for hibernate
//        Session session = factory.getCurrentSession();
//        session.beginTransaction();
//
//            System.out.println("Creating an employee object...");
//           Assets asset= new Assets(part, amountOf, cost, totalMSRP, totalPrice);
//
//
//            //start a transaction
//
//            System.out.println("Beginning transaction...");
//
//            //save the student object
//            session.save(asset);
//
//            System.out.println("Saving the new Asset...");
//
//            //commit the transaction
//            session.getTransaction().commit();
//            System.out.println("Done!");
//
//
//    }
//    public static void createParts(String partName,String location, String make, String model, String year,double msrp, double price) {
//
//        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Parts.class)
//                .buildSessionFactory();
//
//        //create a session this is for hibernate
//        Session session = factory.getCurrentSession();
//        session.beginTransaction();
//
//            System.out.println("Creating an employee object...");
//           Parts part = new Parts(partName,location,  make, model, year, msrp, price);
//
//
//            //start a transaction
//
//            System.out.println("Beginning transaction...");
//
//            //save the student object
//            session.save(part);
//
//            System.out.println("Saving the new employee...");
//
//            //commit the transaction
//            session.getTransaction().commit();
//            System.out.println("Done!");
//
//
//    }
    public static boolean checkUserAndPass(Admin admin)
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
//    public void readCustomerRow(int id){
//        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Customer.class)
//                .buildSessionFactory();
//
//        //create a session this is for hibernate
//        Session session = factory.getCurrentSession();
//        session.beginTransaction();
//
//        Customer cust= session.get(Customer.class,id);
//        System.out.println("Customer: "+ cust);
//
//    }
//    public void readTicketRow(int id){
//        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
//                .addAnnotatedClass(TrainTicket.class)
//                .buildSessionFactory();
//
//        //create a session this is for hibernate
//        Session session = factory.getCurrentSession();
//        session.beginTransaction();
//
//        TrainTicket tic= session.get(TrainTicket.class,id);
//        System.out.println("Train Ticket: "+ tic);
//
//    }
//    public void queryRow(String x){
//        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Customer.class)
//                .buildSessionFactory();
//
//        //create a session this is for hibernate
//        Session session = factory.getCurrentSession();
//        session.beginTransaction();
//        List<Customer> workers= session.createQuery("from Customer s where s."+x+"='"+x+"'").getResultList();
//        printC(workers);
//        session.getTransaction().commit();
//        factory.close();
//
//
//    }public void queryTicketRow(String x){
//        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
//                .addAnnotatedClass(TrainTicket.class)
//                .buildSessionFactory();
//
//        //create a session this is for hibernate
//        Session session = factory.getCurrentSession();
//        session.beginTransaction();
//        List<TrainTicket> workers= session.createQuery("from TrainTicket s where s."+x+"='"+x+"'").getResultList();
//        printT(workers);
//        session.getTransaction().commit();
//        factory.close();
//
//
//    }

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
//    public void printT(List<TrainTicket>e)
//    {
//        for(TrainTicket a:e)
//        {
//            System.out.println(a);
//        }
//    }
//    public void deleteRow(int id){
//        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Customer.class)
//                .buildSessionFactory();
//
//        //create a session this is for hibernate
//        Session session = factory.getCurrentSession();
//        session.beginTransaction();
//
//        Customer Emp= session.get(Customer.class,id);
//        System.out.println("Delete employee: "+ Emp.getFirstName()+" "+Emp.getLastName());
//        session.delete(Emp);
//        session.getTransaction().commit();
//        factory.close();
//    }


}
