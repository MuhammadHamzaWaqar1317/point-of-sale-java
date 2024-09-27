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
public class AcpProject {

    public static void sort(Inventory inventory,Scanner cin){
        int choice=0;
        System.out.println("1. Sort by name");
        System.out.println("2. Sort by Price");
        choice=cin.nextInt();
        
        switch(choice){
            case 1:
                inventory.sortByName();
                break;
                
            case 2:
                inventory.sortByPrice();
                break;
                
            default:
                System.out.println("Invalid Input");
                break;
        }
        
    }
    
    public static void main(String[] args) {
        Inventory inventory=new Inventory();
        int choice=0;
        Scanner cin=new Scanner(System.in);
        
        while(true){
            System.out.println("1. Add new Product");
            System.out.println("2. Update Qty of Product");
            System.out.println("3. Display all Products");
            System.out.println("4. Calculate Total Inventory Cost");
            System.out.println("5. Sort Inventory");
            System.out.println("6. Display Low Stock Items");
            System.out.print("Choose an option: ");
            choice=cin.nextInt();
            
            switch(choice){
                case 1:
                    inventory.addItem();
                    break;
                case 2:
                    inventory.updateQty();
                    break;
                    
                case 3:
                    inventory.viewInventory();
                    break;
                    
                case 4:
                    inventory.inventoryCost();
                    break;
                    
                case 5:
                    sort(inventory,cin);
                    break;
                    
                case 6:
                    inventory.lowStock();
                    break;
                    
                    default:
                        System.out.println("Invalid Input");
                        break;
                    
            }
        }
    }
    
}
