/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acpproject;

import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Products {
    private String name;
    private double price;
    private int qty;
    private double totalCost;
    Scanner cin=new Scanner(System.in);

    Products(){
        name="";
    }
    
    Products(Products obj){
        name=obj.name;
        price=obj.price;
        qty=obj.qty;
        totalCost=obj.totalCost;
    }
    
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
