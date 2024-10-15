/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acpproject;

import java.io.*;
import Display.Input;
import Display.Output;
import java.util.ArrayList;

/**
 *
 * @author abdul
 */
public class InventoryImpl implements Inventory{
    private ArrayList<Products> prods = new ArrayList<>();
     Store store=new Store();
    private Products productActions;
    public InventoryImpl() {
       productActions=new Products();
       store.addStart(prods);
             
    }
    @Override
    public ArrayList<Products> getProds() {
        return prods;
    }
    
    public boolean checkDuplicates(Products prod){
        for (int i = 0; i < prods.size(); i++) {
            
            if(prods.get(i).getName().equals(prod.getName())){
                return true;
            }
        }
        return false;
    }

    @Override
    public void addProduct(Products prod) {
        boolean duplicateProduct=false;
        do {            
            duplicateProduct=checkDuplicates(prod);
            if (duplicateProduct) {
                Output.errorMsg("Item Already Present in Inventory");
            }
        } while (duplicateProduct);
        String name = prod.getName();
        int price = prod.getPrice();
        int quantity = prod.getQty();
        Products newProduct=new Products(prod);
        prods.add(newProduct);
        double cost=price*quantity;
        store.storeProd(name,price,quantity,cost,prods);
        Output.output("Product Added Successfully");
        sortByName(true, false);
    }

    @Override
    public void updateProduct(Products prod) {
        boolean found = false;
        for(int i=0;i<prods.size();i++){
            Products product = prods.get(i);
            if(product.getName().equals(prod.getName())){
                product.setPrice(prod.getPrice());
                product.setQty(prod.getQty());
                product.setTotalCost(prod.getTotalCost());
                store.storeProd(prod.getName(), prod.getPrice(), prod.getQty(), prod.getTotalCost(), prods);
                Output.output("Product Updated Successfully");
                found = true;
                break;
            }
        }
        if(!found){
            Output.output("Product Not Found");
        }
        sortByName(true, false);
    }

    @Override
    public void viewInventory() {
        StringBuilder sb = new StringBuilder();
            for(int i=0; i<prods.size();i++){
                Products product = prods.get(i);
                 sb.append("Name: ").append(product.getName())
                .append(", Price: ").append(product.getPrice())
                .append(", Quantity: ").append(product.getQty())
                .append(", Total Price: ").append(product.getTotalCost())
                .append("\n");
            }
            
            Output.output(sb.toString());        
    }
   

    @Override
    public ArrayList<Products> searchProduct(String name) {
        for(int i=0;i<prods.size();i++){
            Products product = new Products();
            if(product.getName().equals(name)){
                return prods;
            }
        }
        return prods;
    }

    @Override
    public void sortByName(boolean asce, boolean desce) {
        if(asce ){
           for(int i=1;i<prods.size();i++){

                Products product=prods.get(i);
                int j=i-1;

                while(j>=0 && prods.get(j).getName().compareTo(product.getName())>0){

                    prods.set(j+1,prods.get(j));
                    j--;
                        }
                prods.set(j+1,product);
                }
        }
        
        else if(desce ){
            for(int i=1;i<prods.size();i++){
                Products product = prods.get(i);
                int j=i-1;

                while(j>=0 && prods.get(j).getName().compareTo(product.getName())<0){
                            prods.set(j+1, prods.get(j));
                    j--;
                        }
                prods.set(j+1,product);
                }
        }
//        store.storeAfterRemove(prods);
    }
    //try commit ;)
    @Override
    public void sortByPrice(boolean asce,boolean desc) {
       if(asce){
        for(int i=1;i<prods.size();i++){

                Products product=prods.get(i);
                int j=i-1;

                 while (j >= 0 && prods.get(j).getPrice() > 0 && prods.get(j).getPrice() > product.getPrice()){

                    prods.set(j+1,prods.get(j));
                    j--;
                        }
                prods.set(j+1,product);
                }
        }
    
       else if(desc){
            for(int i=1;i<prods.size();i++){

                Products product=prods.get(i);
                int j=i-1;

                 while (j >= 0 && prods.get(j).getPrice() > 0 && prods.get(j).getPrice() < product.getPrice()){

                    prods.set(j+1,prods.get(j));
                    j--;
                        }
                prods.set(j+1,product);
                }
        }
//        store.storeAfterRemove(prods);
    }

    @Override
    public void productPrice() {
        int totalPrice = 0;
        for(int i=0;i<prods.size();i++){
            Products product = prods.get(i);
            totalPrice += product.getPrice() * product.getQty();
            
        }
        Output.output("Total Price: " + totalPrice);
        
    }

    @Override
    public void removeProd(Products prod)
    {
        boolean found=false;
        for (int i = 0; i < prods.size(); i++)
        {
            if(prod.getName().equals(prods.get(i).getName())){
                prods.remove(i);
                found=true;
                break;
            }
            else{
                continue;
            }
        }
        if(!found){
            Output.output("product not found in inventory!");
        }
        Output.output("product removed success!");
        store.storeAfterRemove(prods);
        sortByName(true, false);
    }
    public ArrayList<Products> access(){
        return prods;
    }
    
}