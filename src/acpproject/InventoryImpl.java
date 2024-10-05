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
    public ArrayList<Products> prods = new ArrayList<>();
     Store store=new Store();
    private Products productActions;
    public InventoryImpl() {
       productActions=new Products();
       store.addStart(prods);
             
    }

    @Override
    public void addProduct() {
        String name = Input.Input("Enter Product name: ");
        int price = productActions.getPositiveValue("Price");
        int quantity = productActions.getPositiveValue("Qty");
        Products newProduct=new Products(name,price,quantity,price*quantity);
        prods.add(newProduct);
       double cost=price*quantity;
        store.storeProd(name,price,quantity,cost,prods);
        Output.output("Product Added Successfully");
        
    }

    @Override
    public void updateProduct() {
        
        String name = Input.Input("Enter Product name to Search in Inventory: ");
        
        
        boolean notFound = false;
        for(int i=0;i<prods.size();i++){
            Products product = prods.get(i);
            if(name.equals(product.getName())){
                product.setPrice(productActions.getPositiveValue("Price"));
                product.setQty(productActions.getPositiveValue("Qty"));
                product.setTotalCost(product.getPrice()*product.getQty());
                store.storeProd(prods.get(i).getName(),prods.get(i).getQty(),prods.get(i).getPrice(),prods.get(i).getTotalCost(),prods);
                notFound = true;
                break;
            }
        }
        
        if(notFound){
            Output.output("Product Updated");
        }
        else{
            Output.errorMsg("Product Not Found");
        }
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
    public void sortByPrice(int chk) {
       Products temp=new Products();
       int n=prods.size();
       boolean swapped;
       if(chk==0){
        for (int i = 0; i < n-1; i++)
        {
           swapped=false;
            for (int j = 0; j < n-1-i; j++)
            {
                if(prods.get(j).getPrice()>prods.get(j).getPrice()){
                    temp.setPrice( prods.get(j).getPrice());
                    temp.setName(prods.get(j).getName());
                    temp.setQty(prods.get(j).getQty());
                    temp.setTotalCost(prods.get(j).getTotalCost());
                    
                    prods.get(j).setPrice(prods.get(j+1).getPrice());
                    prods.get(j).setName(prods.get(j+1).getName());
                    prods.get(j).setQty(prods.get(j+1).getQty());
                    prods.get(j).setTotalCost(prods.get(j+1).getTotalCost());
                    
                    prods.get(j+1).setPrice(temp.getPrice());
                    prods.get(j+1).setName(temp.getName());
                    prods.get(j+1).setQty(temp.getQty());
                    prods.get(j+1).setTotalCost(temp.getTotalCost());
                    swapped=true;
                }
            }
            if(!swapped){
                break;
            }
        }
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
       else if(chk==1){
           for (int i = 0; i < n-1; i++)
        {
           swapped=false;
            for (int j = 0; j < n-1-i; j++)
            {
                if(prods.get(j).getPrice()<prods.get(j).getPrice()){
                    temp.setPrice( prods.get(j).getPrice());
                    temp.setName(prods.get(j).getName());
                    temp.setQty(prods.get(j).getQty());
                    temp.setTotalCost(prods.get(j).getTotalCost());
                    
                    prods.get(j).setPrice(prods.get(j+1).getPrice());
                    prods.get(j).setName(prods.get(j+1).getName());
                    prods.get(j).setQty(prods.get(j+1).getQty());
                    prods.get(j).setTotalCost(prods.get(j+1).getTotalCost());
                    
                    prods.get(j+1).setPrice(temp.getPrice());
                    prods.get(j+1).setName(temp.getName());
                    prods.get(j+1).setQty(temp.getQty());
                    prods.get(j+1).setTotalCost(temp.getTotalCost());
                    swapped=true;
                }
            }
            if(!swapped){
                break;
            } 
        }
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
    public void removeProd()
    {
        String name="";
        boolean found=false;
        name=Input.Input("enter name of product: ");
        for (int i = 0; i < prods.size(); i++)
        {
            if(name.equals(prods.get(i).getName())){
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
    }
    
    
}