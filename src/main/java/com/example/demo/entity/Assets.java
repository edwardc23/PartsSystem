package com.example.demo.entity;

import javax.persistence.*;
@Entity
@Table(name="assets")
public class Assets {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="ID")
        private int id;

        @Column(name="Part_Name")
        private String part;

        @Column(name="Amount")
        private int amountOf;

        @Column(name="Cost")
        private double cost;

        @Column(name="MSRP")
        private double msrp;

        @Column(name="Total_MSRP")
        private double totalMSRP;

        @Column(name="Total_Cost")
        private double totalCost;

        @Column(name="Profit")
        private double profit;

        public Assets(String part, int amountOf, double cost, double msrp, double totalMSRP, double totalCost, double profit) {
            this.part = part;
            this.amountOf=amountOf;
            this.cost = cost;
            this.msrp =msrp;
            this.totalMSRP = totalMSRP;
            this.totalCost = totalCost;
            this.profit = profit;
        }
        public Assets(){}

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPart() {
            return part;
        }

        public void setPart(String part) {
            this.part = part;
        }

        public int getAmountOf() {
            return amountOf;
        }

        public void setAmountOf(int amountOf) {
            this.amountOf = amountOf;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public double getMsrp() { return msrp; }

        public void setMsrp(double msrp) { this.msrp = msrp; }

        public double getTotalMSRP() {
                    return totalMSRP;
                }

        public void setTotalMSRP(double totatMSRP) {
            this.totalMSRP = totatMSRP;
        }

        public double getTotalCost() {
            return totalCost;
        }

        public void setTotalCost(double totalCost) {
            this.totalCost = totalCost;
        }

        public double getProfit() { return profit;}

        public void setProfit(double profit) {this.profit = profit; }

    @Override
        public String toString() {
            return "Assets{" +
                    "part='" + part + '\'' +
                    ", amountOf=" + amountOf +
                    ", cost=" + cost +
                    ", MSRP=" + msrp+
                    ", totalMSRP=" + totalMSRP +
                    ", totalCost=" + totalCost +
                    ", Profit=" + profit +
                    '}';
        }
}
