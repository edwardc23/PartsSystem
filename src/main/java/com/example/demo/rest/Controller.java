package com.example.demo.rest;


import com.example.demo.dao.CRUD;
import com.example.demo.dao.DAO;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Parts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController

public class Controller {
    private final DAO dao;

    @Autowired
    public Controller(DAO dao) {this.dao = dao;}

    //grabs entire inventory listing
    @GetMapping("/grabInventory")
    public List<Parts> listInventory(){return dao.listInventory();}

    //retrieves a single item by ID
    @GetMapping("/retrieveItem/{itemID}")
    public Parts item(@PathVariable int partID){
        Parts item = dao.findID(partID);
        if(item == null){
            throw new RuntimeException("Couldn't find an item in inventory with ID:" + partID);
        }

        return item;
    }


    //deletes entire inventory
    @DeleteMapping("/deleteStockList")
    public String clearInventory(@PathVariable List<Parts> inventory){
        if (inventory.size() == 0){
            throw new RuntimeException("The stock list is already empty");
        }
        dao.clearInventory(inventory);
        return "The entire inventory has been wiped";
    }

    //updates item by ID
    @PutMapping("/update")
    public Parts updateItem(@RequestBody Parts newItem){
        dao.saveNew(newItem);
        return newItem;
    }

    //adds and stores a new item
    @PostMapping("/addItem")
    public Parts addItem(@RequestBody Parts item){
        item.setId(0);
        dao.saveNew(item);
        return item;
    }

    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin admin){
       CRUD.createUser(admin.getUserName(), admin.getPassword());
//       admin.setUserName("Test");
//       admin.setPassword("Psswd123");
       return admin;
    }

    @DeleteMapping("/delete/{itemID}")
    public String removeItem(@PathVariable int partID){
        Parts item = dao.findID(partID);
        if(item == null){
            throw new RuntimeException("Couldnt find an item in inventory with ID:" + partID);
        }
        dao.deleteID(partID);
        return "Deleted item from inventory with ID:" + partID;
    }
}
