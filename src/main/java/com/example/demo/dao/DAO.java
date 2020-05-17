package com.example.demo.dao;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Assets;
import com.example.demo.entity.Parts;

import java.util.List;

public interface DAO {
    List<Parts> listInventory();
    List<Assets> listAssets();
    void clearInventory();
    Parts findID (int partID);
    void deleteID (int partID);
    void saveNew(Parts part);
    void saveAdmin(Admin admin);
    void purchase(Parts part, double price);
}
