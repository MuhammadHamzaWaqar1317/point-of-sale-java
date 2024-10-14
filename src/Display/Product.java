/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Display;

import acpproject.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author abdul
 */
public class Product {
    static JFrame frame;
    static JButton addProduct,back,updateProduct,removeProduct,display,sortByName,sortByPrice;
    static JLabel messageLabel;
    
    public static void productsFrame(){
        frame = new JFrame("Products Frame");
        frame.setSize(400,600);
        frame.setLocation(760, 240);
        frame.setUndecorated(true);
        
        JPanel panel = new JPanel();
        panel.setSize(400,600);
        panel.setLocation(760, 240);
        panel.setLayout(null);
        panel.setBackground(Color.decode("#7DBFFF"));
        frame.add(panel);
        
        messageLabel = new JLabel("Products");
        messageLabel.setBounds(150, 30, 150, 40);
        messageLabel.setFont(new Font("Arial",Font.BOLD,16));
        panel.add(messageLabel);
        
        addProduct = new JButton("Add Products");
        addProduct.setBounds(110, 80, 150, 40);
        addProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                AppProducts.addProducts();
            }
        });
        panel.add(addProduct);
        
        updateProduct = new JButton("Update Products");
        updateProduct.setBounds(110,130,150,40);
        updateProduct.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                UpdateProducts.updateProducts();
            }
        });
        panel.add(updateProduct);
        
        removeProduct = new JButton("Remove Products");
        removeProduct.setBounds(110,180,150,40);
        removeProduct.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                RemoveProducts.removeProduct();
            }
        });
        panel.add(removeProduct);
        
        display = new JButton("Display Products");
        display.setBounds(110,230,150,40);
        display.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Inventory inv = new InventoryImpl();
                inv.viewInventory();
            }
        });
        panel.add(display);
        
        sortByName = new JButton("Sort Products By Name");
        sortByName.setBounds(110,280,150,40);
        sortByName.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                NameSort.sortByName();
            }
        });
        panel.add(sortByName);
        
        sortByPrice = new JButton("sort Products By Price");
        sortByPrice.setBounds(110,330,150,40);
        sortByPrice.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                PriceSort.sortByPrice();
            }
        });
        panel.add(sortByPrice);
        
        back = new JButton("Back");
        back.setBounds(225, 420, 100, 40);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                Login.loginFrame();
            }
        });
        panel.add(back);
        frame.setVisible(true);
    }
}
