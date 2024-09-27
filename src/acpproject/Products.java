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
    
    //////////// METHODS
    
    public double inputPrice(){
        
        while(true){
        System.out.println("Enter Price of Item");
        double price=cin.nextDouble();
        
        if(price<=0){
            System.out.println("Price must be greater than 0");
            continue;
        }
        return price;
        }
    }
    
    public int inputQty(){
        
        while(true){
        System.out.println("Enter Qty of Item");
        int qty=cin.nextInt();
        
        if(qty<=0){
            System.out.println("Qty must be greater than 0");
            continue;
        }
        return qty;
        }
    }
    
    public boolean checkDuplicateItem(Products[] itemArray,String itemName,int counter){
        for (int i = 0; i < counter; i++) {
            if(itemName.equals(itemArray[i].getName())){
                System.out.println("Item already exists");
                return true;
            }
        }
        return false;
    }
    
    public boolean addItem(Products[] itemArray,int counter){
        System.out.println("Enter Item name");
        
        name=cin.nextLine();
        if (checkDuplicateItem(itemArray, name, counter)) {
            return true;
        }
        
        price=inputPrice();
        qty=inputQty();
        
        totalCost=price*qty;
        cin.nextLine();
        
        return false;
    }
}
