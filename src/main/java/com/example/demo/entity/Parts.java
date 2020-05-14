package com.example.demo.entity;

import javax.persistence.*;


@Entity
@Table(name="parts")
public class Parts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;

    @Column(name="Part_Name")
    private String partName;

    @Column(name="Location")
    private String location;

    @Column(name="Make")
    private String make;

    @Column(name="Model")
    private String model;

    @Column(name="Model_Year")
    private String year;

    @Column(name="MSRP")
    private double msrp;

    @Column(name="Price")
    private double price;



    public Parts(){}

    public Parts(String partName,String location, String make, String model, String year,double msrp, double price)
    {

        this.partName=partName;
        this.location=location;
        this.make=make;
        this.model=model;
        this.year=year;
        this.msrp=msrp;
        this.price=price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getMsrp() {
        return msrp;
    }

    public void setMsrp(double msrp) {
        this.msrp = msrp;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Parts{" +
                "id=" + id +
                ", Part Name='" + partName + '\'' +
                ", Location='" + location + '\'' +
                ", Make='" + make + '\'' +
                ", Model='" + model + '\'' +
                ", Model Year='" + year + '\'' +
                ", MSRP=" + msrp +
                ", Price=" + price +
                '}';

    }
}
