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
    ArrayList<Products> getProds();
    public void addProduct(Products prod);
    public void updateProduct(Products prod);
    public void productPrice();
    public void viewInventory();
    public void removeProd(Products prod);
    public ArrayList<Products> searchProduct(String name);
    public void sortByName(boolean asce, boolean desce);
    public void sortByPrice(boolean asce, boolean desce);
}
