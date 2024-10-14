/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acpproject;

import Display.Input;
import Display.Output;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Products {
    private String name;
    private int price;
    private int qty;
    private double totalCost;

    public Products(){
        name="";
    }
    
    public Products(Products obj){
        name=obj.name;
        price=obj.price;
        qty=obj.qty;
        totalCost=obj.totalCost;
    }

    public Products(String name, int price, int qty, double totalCost) {
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.totalCost = totalCost;
    }
    
    public String getName() {
        return name;
    }

    public int getPrice() {
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

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    

}
