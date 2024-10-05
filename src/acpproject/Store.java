/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acpproject;
import Display.Output;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import java.util.ArrayList;
/**
 *
 * @author abdul
 */
public class Store {
    public void storeProd(String name,int quantity,int price,double cost,ArrayList<Products> list){
        File file,file1;
         String path="C:\\Abdullah\\university\\5\\ACP\\Project\\point-of-sale-java\\src\\sale1.txt";
         String path2="C:\\Abdullah\\university\\5\\ACP\\Project\\point-of-sale-java\\src\\sales.txt";
        file=new File(path);
        file1=new File(path2);
             
        if(file.delete() && file1.delete()){
            System.out.println("deleted!");
        }
        else{
            System.out.println("error deleting file");
        }
        
        try{
              if(file.createNewFile()){
                  System.out.println("file created!");    
              }   
           } catch (IOException ex){
                System.out.println("create file failed!");
              }
            
        for (int i = 0; i < list.size(); i++)
        {
            String content=" name: "+list.get(i).getName()+"\n quantity: "+list.get(i).getQty()+"\n price: "+list.get(i).getPrice()+"\n cost: "+list.get(i).getTotalCost()+"\n ----------------\n";
            String content2=list.get(i).getName()+"\n"+list.get(i).getQty()+"\n"+list.get(i).getPrice()+"\n"+list.get(i).getTotalCost();
            try (
            BufferedWriter writer1 = new BufferedWriter(new FileWriter(path,true));
            BufferedWriter writer2 = new BufferedWriter(new FileWriter(path2,true))
        ) {
            writer1.write(content);
            writer2.write(content2);

            System.out.println("Content written to both files successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
        }       
    }
    
}
