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
    //public void addStart();
    public void addProduct();
    public void updateProduct();
    public void productPrice();
    public void viewInventory();
    public void removeProd();
    public ArrayList<Products> searchProduct(String name);
    public void sortByName(boolean asce, boolean desce);
    public void sortByPrice(int chk);
}
