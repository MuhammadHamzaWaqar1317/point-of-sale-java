/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Display;

import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author abdul
 */
public class Products {
    static JFrame frame;
    static JButton addProduct;
    static JButton updateProduct;
    static JButton removeProduct;
    static JButton display;
    static JButton sortByName;
    static JButton sortByPrice;
    
    
    public static void productsFrame(){
        frame = new JFrame("Products Frame");
        frame.setSize(400,600);
        frame.setLocation(760, 240);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.decode("#7DBFFF"));
        frame.add(panel);
        
        addProduct = new JButton("Add Products");
        addProduct.setBounds(110, 20, 150, 40);
        panel.add(addProduct);
        
        updateProduct = new JButton("Update Products");
        updateProduct.setBounds(110,70,150,40);
        panel.add(updateProduct);
        
        removeProduct = new JButton("Remove Products");
        removeProduct.setBounds(110,130,150,40);
        panel.add(removeProduct);
        
        display = new JButton("Display Products");
        display.setBounds(110,180,150,40);
        panel.add(display);
        
        sortByName = new JButton("Sort Products By Name");
        sortByName.setBounds(110,230,150,40);
        panel.add(sortByName);
        
        sortByPrice = new JButton("sort Products By Price");
        sortByPrice.setBounds(110,280,150,40);
        panel.add(sortByPrice);
        
        frame.setVisible(true);
    }
}
