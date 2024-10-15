/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acpproject;

import Display.Input;
import Display.Output;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class CartImpl implements Cart
{
    ArrayList<Products> ps;
    ArrayList<Products> newCart=new ArrayList<>();
    InventoryImpl pl;
    cashier cs;
    int quan=0;

    
    
    
    
     public CartImpl(ArrayList<Products> ps){
        this.ps=ps;
    }
    
    @Override
    public void addItems()
    {   
        File file;
        
        String pathe="C:\\Abdullah\\university\\5\\ACP\\Project\\point-of-sale-java\\src\\sales.txt";
        
        file=new File(pathe);
            String name;
            Products temp=new Products();
            boolean isFound=false;
            name=Input.getInput("enter name of item: ");
            double calc=0.0;
            for (int i = 0; i < ps.size(); i++)
        {
            if(name.equals(ps.get(i).getName())){
                isFound=true;
                do{
                quan=Integer.parseInt(Input.getInput("enter quantity: "));
                if(quan>ps.get(i).getQty()){
                    Output.output("not enough in inventory!");
                }
                }while(quan>ps.get(i).getQty());
                temp=new Products(ps.get(i).getName(),ps.get(i).getPrice(),quan,ps.get(i).getPrice()*quan);
                newCart.add(temp);
                calc=temp.getTotalCost();
                break;
            }
            ps.get(i).setQty(ps.get(i).getQty()-quan);          
            double tot=ps.get(i).getTotalCost();                
            ps.get(i).setTotalCost(tot-calc);
        }
        
        File fl;
        String path="Cart.txt";
        fl=new File(path);
        fl.delete();
        try
        {
            
            fl.createNewFile();
            
        } catch (IOException ex)
        {
            System.out.println("error creating file!");
        }
        
        //writing to cart
        
        for (int i = 0; i <newCart.size(); i++)
        {
        String content="\nitem name: "+newCart.get(i).getName()+"\nitem price: "+newCart.get(i).getPrice()+"\nitem quantity: "+quan+"\ncost: "+newCart.get(i).getTotalCost();
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(fl,true))){
            bw.write(content);
            System.out.println("writing successful");
        } catch (IOException ex)
        {
            Output.output("Error writing to file!");
        }
        }
        
        //writing back to inventory file
        String path2="C:\\Abdullah\\university\\5\\ACP\\Project\\point-of-sale-java\\src\\Cart.txt";
        File file2;
        file2=new File(path2);
        
        file.delete();
        for (int i = 0; i < ps.size(); i++)
        {
           try(BufferedWriter bm=new BufferedWriter(new FileWriter(file2,true))){
               String content3=" name: "+ps.get(i).getName()+"\n quantity: "+ps.get(i).getQty()+"\n price: "+ps.get(i).getPrice()+"\n cost: "+ps.get(i).getTotalCost()+"\n ----------------\n";
            bm.write(content3);
            
        } catch (IOException ex)
        {
            System.out.println("error writing to file!");
        }
        }
        
        
        
        try
        {
            file.createNewFile();
        } catch (IOException ex)
        {
            System.out.println("error creating file!");
        }
        for (int i = 0; i < ps.size(); i++)
        {
            try(BufferedWriter bf=new BufferedWriter(new FileWriter(file))){
                String content2=ps.get(i).getName()+"\n"+ps.get(i).getQty()+"\n"+ps.get(i).getPrice()+"\n"+ps.get(i).getTotalCost()+"\n";
            bf.write(content2);
            
        } catch (IOException ex)
        {
            System.out.println("error writing to file!");
        }
        }
    }
    
    @Override
    public void removeItems()
    {
        boolean tried=false;
        String name=Input.getInput("enter product name to remove from cart!");
        for (int i = 0; i < newCart.size(); i++)
        {
            if(name.equals(newCart.get(i).getName())){
                newCart.remove(i);
                tried=true;
            }
        }
        if(!tried){
            Output.output("product not found!");
        }
       File fl;
        String path="Cart.txt";
        fl=new File(path);
        fl.delete();
        try
        {
            
            fl.createNewFile();
            
        } catch (IOException ex)
        {
            System.out.println("error creating file!");
        }
        
        //writing to cart
        
        for (int i = 0; i <newCart.size(); i++)
        {
        String content="\nitem name: "+newCart.get(i).getName()+"\nitem price: "+newCart.get(i).getPrice()+"\nitem quantity: "+quan+"\ncost: "+newCart.get(i).getTotalCost();
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(fl,true))){
            bw.write(content);
            System.out.println("writing successful");
        } catch (IOException ex)
        {
            Output.output("Error writing to file!");
        }
        }
    }

    @Override
    public void viewCart()
    {
         StringBuilder sb = new StringBuilder();
            for(int i=0; i<newCart.size();i++){
                Products product = newCart.get(i);
                 sb.append("Name: ").append(product.getName())
                .append(", Price: ").append(product.getPrice())
                .append(", Quantity: ").append(product.getQty())
                .append(", Total Price: ").append(product.getTotalCost())
                .append("\n");
            }
            
            Output.output(sb.toString());  
       
    }

    @Override
    public void checkOut()
    {
        double total=0;
        for (int i = 0; i < newCart.size(); i++)
        {
            total=total+newCart.get(i).getTotalCost();
        }
         StringBuilder sb = new StringBuilder();
            for(int i=0; i<newCart.size();i++){
                Products product = ps.get(i);
                 sb.append("Name: ").append(product.getName())
                .append(", Price: ").append(product.getPrice())
                .append(", Quantity: ").append(product.getQty())
                .append(", Total Price: ").append(product.getTotalCost())
                .append("\n")
                 .append("your total bill is: ").append(total);
            }
        
    }
    
}
