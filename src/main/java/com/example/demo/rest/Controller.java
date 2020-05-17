package com.example.demo.rest;


import com.example.demo.dao.CRUD;
import com.example.demo.dao.DAO;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Assets;
import com.example.demo.entity.Parts;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController

public class Controller {
    private final DAO dao;

    public Controller(DAO dao) {
        this.dao = dao;
    }


    //grabs entire inventory listing
    @GetMapping("/grabInventory")
    public List<Parts> listInventory(){return dao.listInventory();}

    @GetMapping("/grabAssets")
    public List<Assets> listAssets(){return dao.listAssets();}

    //retrieves a single item by ID
    @GetMapping("/retrieveItem/{partID}")
    public Parts item(@PathVariable int partID){
        Parts item = dao.findID(partID);
        if(item == null){
            throw new RuntimeException("Couldn't find an item in inventory with ID:" + partID);
        }

        return item;
    }
    //retrieves a single item by ID
    @GetMapping("/purchaseItem/{partID}")
    public Parts puchase(@PathVariable int partID){
        List<Parts> partsList= dao.listInventory();
        double total=0;
        for(Parts a: partsList)
        {
            total=total+a.getPrice();
        }
        Parts item = dao.findID(partID);
        dao.purchase(item,total);
        if(item == null){
            throw new RuntimeException("Couldn't find an item in inventory with ID:" + partID);
        }


        return item;
    }

    //deletes entire inventory
    @DeleteMapping("/deleteStockList")
    public String clearInventory(){
//        if (inventory.size() == 0){
//            throw new RuntimeException("The stock list is already empty");
//        }
        dao.clearInventory();
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
        System.out.println(item);
        return item;
    }

    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin admin){
        admin.setId(0);
        dao.saveAdmin(admin);
        System.out.println(admin);
        return admin;
    }

    @PostMapping("/checkAdmin")
    public String checker(@RequestBody Admin admin)
    {
        if(CRUD.checkUserAndPass(admin))
        {
            return "Success";
        }
        else
        {
            return "Failure";
        }
//        return "Success";

    }
    @DeleteMapping("/delete/{partID}")
    public String removeItem(@PathVariable int partID){
        Parts item = dao.findID(partID);
        if(item == null){
            throw new RuntimeException("Couldn't find an item in inventory with ID:" + partID);
        }
        dao.deleteID(partID);
        return "Deleted item from inventory with ID:" + partID;
    }
}
