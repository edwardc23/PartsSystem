package com.example.demo.dao;


import com.example.demo.entity.Admin;
import com.example.demo.entity.Parts;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class CRUD {


    public void createUser(String userName, String password) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Admin.class)
                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();
        session.beginTransaction();

            System.out.println("Creating an employee object...");
           Admin admin= new Admin(userName,password);


            //start a transaction

            System.out.println("Beginning transaction...");

            //save the student object
            session.save(admin);

            System.out.println("Saving the new employee...");

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");


    }
    public void createParts(String partName,String location, String make, String model, String year,double msrp, double price) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Parts.class)
                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();
        session.beginTransaction();

            System.out.println("Creating an employee object...");
           Parts part = new Parts(partName,location,  make, model, year, msrp, price);


            //start a transaction

            System.out.println("Beginning transaction...");

            //save the student object
            session.save(part);

            System.out.println("Saving the new employee...");

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");


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
//    public void printC(List<Customer>e)
//    {
//        for(Customer a:e)
//        {
//            System.out.println(a);
//        }
//    }
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
