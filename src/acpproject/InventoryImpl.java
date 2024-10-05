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
        
        int count=0;
        String path="E:\\Code Projects\\Netbeans JAVA Projects\\AcpProject\\src\\sales.txt";
        ArrayList<String> example=new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null){
               count++;
               example.add(line);    
            }
             
             int countpro=0;
             for (int i = 0; i < count/4; i++)
            {
                String name = example.get(countpro);
                int qty = Integer.parseInt(example.get(countpro + 1));
                int price = Integer.parseInt(example.get(countpro + 2));
                double total = Double.parseDouble(example.get(countpro + 3));
                Products products = new Products(name,price,qty,total);
                prods.add(products);
                countpro += 4;
            }
             } catch (IOException e) {
            Output.errorMsg("Error reading file: ");
        }catch (NumberFormatException e) {
            Output.errorMsg("Error parsing number: ");
        }
             
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
//       int count=0;
//        String path="E:\\Code Projects\\Netbeans JAVA Projects\\AcpProject\\src\\sales.txt";
//        ArrayList<String> example=new ArrayList<>();
//        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
//            String line;
//            while ((line = reader.readLine()) != null){
//               count++;
//               example.add(line);    
//            }
//             
//             int countpro=0;
//             for (int i = 0; i < count/4; i++)
//            {
//                String name = example.get(countpro);
//                int qty = Integer.parseInt(example.get(countpro + 1));
//                int price = Integer.parseInt(example.get(countpro + 2));
//                double total = Double.parseDouble(example.get(countpro + 3));
//                Products products = new Products(name,price,qty,total);
//                prods.add(products);
//                countpro += 4;
//            }
            for(int i=0; i<prods.size();i++){
                Products product = prods.get(i);
                 sb.append("Name: ").append(product.getName())
                .append(", Price: ").append(product.getPrice())
                .append(", Quantity: ").append(product.getQty())
                .append(", Total Price: ").append(product.getTotalCost())
                .append("\n");
            }
            
            Output.output(sb.toString());
//        } catch (IOException e) {
//            Output.errorMsg("Error reading file: ");
//        }catch (NumberFormatException e) {
//            Output.errorMsg("Error parsing number: ");
//        }
        
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