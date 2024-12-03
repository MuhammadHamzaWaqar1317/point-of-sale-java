/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acpproject;

import Display.Output;
import Display.Product;
import java.util.ArrayList;

/**
 *
 * @author abdul
 */
public class InventoryImpl implements Inventory {
    public static ArrayList<Products> prods;
    private Products productActions;
    private JDBC jdbc;

    public InventoryImpl() {
        productActions = new Products();
        jdbc = new JDBC();
        prods = jdbc.loadAllProducts();
    }

    @Override
    public ArrayList<Products> getProds() {
        return prods;
    }
    
    public boolean checkDuplicates(Products prod) {
        for (int i = 0; i < prods.size(); i++) {
            if(prods.get(i).getName().equals(prod.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addProduct(Products prod) {
        boolean duplicateProduct = false;
        do {            
            duplicateProduct = checkDuplicates(prod);
            if (duplicateProduct) {
                Output.errorMsg("Item Already Present in Inventory");
            }
        } while (duplicateProduct);
        
        Products newProduct = new Products(prod);
        prods.add(newProduct);
        jdbc.saveProduct(newProduct);
        
        Output.output("Product Added Successfully");
        sortByName(true, false);
    }

    @Override
    public void updateProduct(Products prod) {
        boolean found = false;
        for(int i = 0; i < prods.size(); i++) {
            Products product = prods.get(i);
            if(product.getName().equals(prod.getName())) {
                product.setPrice(prod.getPrice());
                product.setQty(prod.getQty());
                product.setTotalCost(prod.getTotalCost());
                jdbc.updateProduct(product);
                Output.output("Product Updated Successfully");
                found = true;
                break;
            }
        }
        if(!found) {
            Output.output("Product Not Found");
        }
        sortByName(true, false);
    }

    @Override
    public void viewInventory() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < prods.size(); i++) {
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
    public int searchProduct(String name) {
        
        for(int i = 0; i < prods.size(); i++) {
            Products product = prods.get(i);
            if(product.getName().equals(name)) {
                return i;
            }
            
        }
        return -1;
    }

    @Override
    public void sortByName(boolean asce, boolean desce) {
        if(asce) {
            for(int i = 1; i < prods.size(); i++) {
                Products product = prods.get(i);
                int j = i-1;
                while(j >= 0 && prods.get(j).getName().compareTo(product.getName()) > 0) {
                    prods.set(j+1, prods.get(j));
                    j--;
                }
                prods.set(j+1, product);
            }
        }
        else if(desce) {
            for(int i = 1; i < prods.size(); i++) {
                Products product = prods.get(i);
                int j = i-1;
                while(j >= 0 && prods.get(j).getName().compareTo(product.getName()) < 0) {
                    prods.set(j+1, prods.get(j));
                    j--;
                }
                prods.set(j+1, product);
            }
        }
    }

    @Override
    public void sortByPrice(boolean asce, boolean desc) {
            if(asce) {
                for(int i = 1; i < prods.size(); i++) {
                    Products product = prods.get(i);
                    int j = i-1;
                    while (j >= 0 && prods.get(j).getPrice() > 0 && prods.get(j).getPrice() > product.getPrice()) {
                        prods.set(j+1, prods.get(j));
                        j--;
                    }
                    prods.set(j+1, product);
                }
            }
            else if(desc) {
                for(int i = 1; i < prods.size(); i++) {
                    Products product = prods.get(i);
                    int j = i-1;
                    while (j >= 0 && prods.get(j).getPrice() > 0 && prods.get(j).getPrice() < product.getPrice()) {
                        prods.set(j+1, prods.get(j));
                        j--;
                    }
                    prods.set(j+1, product);
                }
            }
    }

    @Override
    public void productPrice() {
        int totalPrice = 0;
        for(int i = 0; i < prods.size(); i++) {
            Products product = prods.get(i);
            totalPrice += product.getPrice() * product.getQty();
        }
        Output.output("Total Price: " + totalPrice);
    }

    @Override
    public void removeProd(Products prod) {
        boolean found = false;
        for (int i = 0; i < prods.size(); i++) {
            if(prods.get(i).getName().equals(prod.getName())) {
                jdbc.deleteProduct(prod.getName());
                prods.remove(i);
                found = true;
                break;
            }
        }
        if(!found) {
            Output.output("Product not found in inventory!");
        } else {
            Output.output("Product removed successfully!");
            sortByName(true, false);
        }
    }

    public ArrayList<Products> access() {
        return prods;
    }
}