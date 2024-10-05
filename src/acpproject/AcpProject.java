/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acpproject;
import Display.*;

/**
 *
 * @author Dell
 */
public class AcpProject {
   
    public static void main(String[] args) {
        Inventory inventory = new InventoryImpl();
        Products prod = new Products();
        Account account = new AccountImp();
        int id = 0;
        boolean exit = false;
        
        while (!exit) {
            String message =  "1) Login Account\n"
                            + "2) Exit";
            int choice = Integer.parseInt(Input.Input(message));
            switch (choice) {
                case 1:
                    String email = Input.Input("Enter Email:");
                    String password = Input.Input("Enter Password:");
                    boolean isAdmin = account.login(email, password);
                    
                    if (isAdmin) {
                        do {
                            message = "1. Add new Product\n"
                                    + "2. Update Qty of Product\n"
                                    + "3. Display all Products\n"
                                    + "4. Calculate Total Inventory Cost\n"
                                    + "5. Sort Inventory\n"
                                    + "6. Sort by Price\n"
                                    + "7. Remove an item\n"
                                    + "8) Exit";
                            choice = Integer.parseInt(Input.Input(message));
                            
                            switch (choice) {
                                case 1:
                                    inventory.addProduct();
                                    break;
                                case 2:
                                    inventory.updateProduct();
                                    break;
                                case 3:
                                    inventory.viewInventory();
                                    break;
                                case 4:
                                    inventory.productPrice();
                                    break;
                                case 5:
                                    do {
                                        message = "1) Ascending Order\n"
                                                + "2) Descending Order\n"
                                                + "3) Exit";
                                        choice = Integer.parseInt(Input.Input(message));
                                        switch (choice) {
                                            case 1:
                                                inventory.sortByName(true, false);
                                                break;
                                            case 2:
                                                inventory.sortByName(false, true);
                                                break;
                                            case 3:
                                                break;
                                            default:
                                                Output.output("Invalid option!!!");
                                                break;
                                        }
                                    } while (choice != 3); 
                                    break;
                                case 6:
                                    do {
                                        message = "1) Ascending Order\n"
                                                + "2) Descending Order\n"
                                                + "3) Exit";
                                        choice = Integer.parseInt(Input.Input(message));
                                        switch (choice) {
                                            case 1:
                                                inventory.sortByPrice(0);
                                                break;
                                            case 2:
                                                inventory.sortByPrice(1);
                                                
                                                break;
                                            case 3:
                                                break; 
                                            default:
                                                Output.output("Invalid option!!!");
                                                break;
                                        }
                                    } while (choice != 3);
                                    break;
                                case 7:
                                        inventory.removeProd();
                                        break;
                                case 8:
                                    exit = true;
                                    break;
                                default:
                                    Output.output("Invalid option!!!");
                                    break;
                            }
                        } while (!exit);
                    } else {
                        Output.output("Login Failed, Account Not Found");
                    }
                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    Output.output("Invalid option!!!");
                    break;
            }
        }           
    }
}