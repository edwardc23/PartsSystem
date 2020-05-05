package com.example.demo.dao;

import com.example.demo.entity.Parts;

import java.util.List;

public interface DAO {
    List<Parts> listInventory();
    void clearInventory(List<Parts> inventory);
    Parts findID (int partID);
    void deleteID (int partID);
    void saveNew(Parts part);
}
