/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acpproject;

import Display.Input;
import Display.Output;
import java.util.ArrayList;

/**
 *
 * @author abdul
 */
public class InventoryImpl implements Inventory{
    public ArrayList<Products> prods = new ArrayList<>();
    private Products productActions;
    public InventoryImpl() {
        productActions=new Products();
    }

    @Override
    public void addProduct() {
        String name = Input.Input("Enter Product name: ");
        int price = productActions.getPositiveValue("Price");
        int quantity = productActions.getPositiveValue("Qty");
        Products newProduct=new Products(name,price,quantity,price*quantity);
        prods.add(newProduct);
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
        if (prods.isEmpty()) {
             Output.output("No products in inventory.");

        }

        for (Products product : prods) {
            sb.append("Name: ").append(product.getName())
              .append(", Price: ").append(product.getPrice())
              .append(", Quantity: ").append(product.getQty())
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
    public void productPrice() {
        int totalPrice = 0;
        for(int i=0;i<prods.size();i++){
            Products product = prods.get(i);
            totalPrice += product.getPrice() * product.getQty();
            
        }
        Output.output("Total Price: " + totalPrice);
        
    }
    
    
}
