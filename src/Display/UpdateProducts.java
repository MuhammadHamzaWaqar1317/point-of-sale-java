/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Display;


import acpproject.InventoryImpl;
import acpproject.Products;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author abdul
 */
public class UpdateProducts {
    static JFrame frame;
    static JLabel messageLabel;
    static JTextField productsName, productsPrice, productsQuantity;
    static JButton addButton, back,searchButton;
    static InventoryImpl inv = new InventoryImpl();
    
    public static void updateProducts(){
        frame = new JFrame("Update Products");
        frame.setSize(400,600);
        frame.setLocation(760, 240);
        frame.setUndecorated(true);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.decode("#7DBFFF"));
        frame.add(panel);
        
        messageLabel = new JLabel("Update Products");
        messageLabel.setBounds(150, 30, 150, 40);
        messageLabel.setFont(new Font("Arial",Font.BOLD,16));
        panel.add(messageLabel);
        
        messageLabel = new JLabel("Enter Products name");
        messageLabel.setBounds(50, 80, 300, 40);
        panel.add(messageLabel);
        
        productsName = new JTextField();
        productsName.setBounds(50, 130, 300, 40);
        panel.add(productsName);
        
        messageLabel = new JLabel("Enter Products Price");
        messageLabel.setBounds(50, 180, 300, 40);
        panel.add(messageLabel);
        
        productsPrice = new JTextField();
        productsPrice.setBounds(50, 230, 300, 40);
        panel.add(productsPrice);
        
        messageLabel = new JLabel("Enter Products Quantity");
        messageLabel.setBounds(50, 280, 300, 40);
        panel.add(messageLabel);
        
        productsQuantity = new JTextField();
        productsQuantity.setBounds(50, 330, 300, 40);
        panel.add(productsQuantity);
        
        searchButton = new JButton("Search");
        searchButton.setBounds(150, 380, 100, 40);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchAction();
            }
        });
        panel.add(searchButton);
        
        addButton = new JButton("Update");
        addButton.setBounds(75, 420, 100, 40);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAction();
            }
        });
        panel.add(addButton);
        
        back = new JButton("Back");
        back.setBounds(225, 420, 100, 40);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                Product.productsFrame();
            }
        });
        panel.add(back);
        
        frame.setVisible(true);
    }
    
    public static void searchAction(){
       String name = productsName.getText();
        ArrayList<Products> prods = inv.searchProduct(name);
        for(int i=0;i<prods.size();i++){
            Products prod = prods.get(i);
            productsName.setText(prod.getName());
            productsPrice.setText(String.valueOf(prod.getPrice()));
            productsQuantity.setText(String.valueOf(prod.getQty()));
        }
        productsName.disable();
         
    }
    
    public static void handleAction(){
        String name = productsName.getText();
        int price = Integer.parseInt(productsPrice.getText());
        int quantity = Integer.parseInt(productsQuantity.getText());
        double total = price * quantity;
        Products prod = new Products(name, price, quantity, total);
        
        inv.updateProduct(prod);
    }
}
