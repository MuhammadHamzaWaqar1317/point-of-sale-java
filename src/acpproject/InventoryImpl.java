/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acpproject;

import Display.Output;
import java.util.ArrayList;

/**
 *
 * @author abdul
 */
public class InventoryImpl implements Inventory{
    public ArrayList<Products> prods = new ArrayList<>();

    public InventoryImpl() {}

    @Override
    public void addProduct(Products prod) {
        prods.add(prod);
    }

    @Override
    public void updateProduct(Products prod) {
        boolean isFound = false;
        for(int i=0;i<prods.size();i++){
            Products product = new Products();
            if(product.getName().equals(prod.getName())){
                product.setPrice(prod.getPrice());
                product.setQty(prod.getQty());
                isFound = true;
                break;
            }
        }
        if(!isFound){
            Output.output("Product Updated");
        }
        else{
            Output.output("Product Not Found");
        }
    }

    @Override
    public StringBuilder viewInventory() {
        StringBuilder sb = new StringBuilder();
        if (prods.isEmpty()) {
            return sb;
        }

        for (Products product : prods) {
            sb.append("Name: ").append(product.getName())
              .append(", Price: ").append(product.getPrice())
              .append(", Quantity: ").append(product.getQty())
              .append("\n");
        }
        return sb;
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
        if(asce == true && desce == false){
           for(int i=0;i<prods.size();i++){
                Products product = prods.get(i);
                int j=i-1;

                while(j>=0 && prods.get(i).getName().compareTo(product.getName())>0){
                    prods.set(j+1, prods.get(j));
                    j--;
                }
                prods.set(j+1,product);
            }
           
        }
        else if(asce == false && desce == true){
            for(int i=0;i<prods.size();i++){
                Products product = prods.get(i);
                int j=i-1;

                while(j>=0 && prods.get(i).getName().compareTo(product.getName())<0){
                    prods.set(j+1, prods.get(j));
                    j--;
                }
                prods.set(j+1,product);
            } 
        }
    }

    @Override
    public void sortByPrice(boolean asce, boolean desce) {
        if(asce == true && desce == false){
           for(int i=0;i<prods.size();i++){
                Products product = prods.get(i);
                int j=i-1;

                while(j>=0 && prods.get(i).getPrice()>product.getPrice()){
                    prods.set(j+1, prods.get(j));
                    j--;
                }
                prods.set(j+1,product);
            }
           
        }
        else if(asce == false && desce == true){
            for(int i=0;i<prods.size();i++){
                Products product = prods.get(i);
                int j=i-1;

                while(j>=0 && prods.get(i).getPrice()<product.getPrice()){
                    prods.set(j+1, prods.get(j));
                    j--;
                }
                prods.set(j+1,product);
            } 
        }
    }

    @Override
    public int productPrice() {
        int totalPrice = 0;
        for(int i=0;i<prods.size();i++){
            Products product = prods.get(i);
            totalPrice += product.getPrice() + product.getQty();
            
        }
        return totalPrice;
    }
    
    
}
