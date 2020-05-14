package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="admininfo")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;

    @Column(name="Username")
    private String userName;

    @Column(name="Password")
    private String password;

    public Admin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    public Admin()
    {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                ", Username='" + userName + '\'' +
                ", Password='" + password + '\'' +
                '}';
    }
}
