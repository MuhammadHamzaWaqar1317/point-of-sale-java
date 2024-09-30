/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acpproject;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public interface Inventory {
    public void addProduct();
    public void updateProduct();
    public int productPrice();
    public StringBuilder viewInventory();
    public ArrayList<Products> searchProduct(String name);
    public void sortByName(boolean asce, boolean desce);
    public void sortByPrice(boolean asce, boolean desce);
    
//    private int counter;
//    private Products[] productsArray;
//    Scanner cin=new Scanner(System.in);
//    
//    
//    Inventory(){
//       productsArray= new Products[1];
//       productsArray[0]=new Products();
//       
//       counter=0;
//    }
//    
//    public void expandArray(){
//        int newSize=counter+1;
//        Products[] newProductsArray= new Products[newSize];
//        for (int i = 0; i < newSize; i++) {
//            newProductsArray[i]=new Products();
//            if(counter==i){
//                break;
//            }
//            newProductsArray[i]=productsArray[i];
//        }
//        productsArray=newProductsArray;
//    }
//    
//    public void addItem(){
//        System.out.println("");
//        boolean alreadyPresent=productsArray[counter].addItem(productsArray,counter);
//        if(alreadyPresent){
//            return;
//        }
//        System.out.println("");
//        counter++;
//        expandArray();
//    }
//    
//    public void updateQty(){
//        System.out.println("Enter Item Name to update Qty");
//        String itemName=cin.nextLine();
//        boolean flag=true;
//        
//        for (int i = 0; i < counter; i++) {
//            if(itemName.equals(productsArray[i].getName())){
//                int qty=productsArray[i].inputQty();
//                productsArray[i].setQty(qty);
//                productsArray[i].setTotalCost(productsArray[i].getPrice()*productsArray[i].getQty());
//                System.out.println("Qty updated Successfully");
//                flag=false;
//                break;
//            }
//        }
//        
//        if (flag) {
//            System.out.println("Item not Found!!!");
//        }
//        cin.nextLine();
//    }
//    
//    public int viewInventory(){
//        System.out.println("");
//        int sum=0;
//        for (int i = 0; i < counter; i++) {
//            System.out.println((i+1)+". "+productsArray[i].getName()+" - $"+productsArray[i].getPrice()+" (x"+productsArray[i].getQty()+")" );
//            sum+=productsArray[i].getTotalCost();
//        }
//        
//        System.out.println("");
//        return sum;
//    }
//    
//    public void inventoryCost(){
//        int totalCost=viewInventory();
//        System.out.println("Total Cost: "+totalCost);
//        
//    }
//    
//    public void sortByName(){
//        
//        for (int i = 1; i < productsArray.length-1; ++i) {
//                Products key = new Products(productsArray[i]); 
//                int j = i - 1;
//
//                
//                while (j >= 0 && productsArray[j].getName().compareTo(key.getName()) > 0) {
//                    productsArray[j + 1] = productsArray[j]; 
//                    j = j - 1; 
//                }
//                productsArray[j + 1] = key; 
//        }
//        
//    }
//    
//    public void sortByPrice(){
//        for (int i = 1; i < productsArray.length-1; ++i) {
//                Products key = new Products(productsArray[i]); 
//                int j = i - 1;
//
//                
//                while (j >= 0 && productsArray[j].getPrice() > key.getPrice()) {
//                    productsArray[j + 1] = productsArray[j]; 
//                    j = j - 1; 
//                }
//                productsArray[j + 1] = key; 
//        }
//    }
//    
//    public void lowStock(){
//        boolean flag=true;
//        for (int i = 0; i < productsArray.length-1; i++) {
//            if(productsArray[i].getQty()<3){
//                System.out.println("Low Stock: "+ productsArray[i].getName()+"   Qty: "+productsArray[i].getQty());
//                flag=false;
//            }
//        }
//        
//        if(flag){
//            System.out.println("All Items are in Stock");
//        }
//    }
}
