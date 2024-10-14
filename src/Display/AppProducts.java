/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Display;

import acpproject.*;
import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author abdul
 */
public class AppProducts {
    static JFrame frame;
    static JLabel messageLabel;
    static JTextField productsName, productsPrice, productsQuantity;
    static JButton addButton, back;
    
    public static void addProducts(){
        frame = new JFrame("Add Products");
        frame.setSize(400,600);
        frame.setLocation(760, 240);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.decode("#7DBFFF"));
        frame.add(panel);
        
        messageLabel = new JLabel("Add Products");
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
        
        addButton = new JButton("Add");
        addButton.setBounds(75, 380, 100, 40);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAction();
            }
        });
        panel.add(addButton);
        
        back = new JButton("Back");
        back.setBounds(225, 380, 100, 40);
        panel.add(back);
        
        frame.setVisible(true);
        
    }
    
    public static void handleAction(){
        String name = productsName.getText();
        int price = Integer.parseInt(productsPrice.getText());
        int quantity = Integer.parseInt(productsQuantity.getText());
        double total = price*quantity;
        
        InventoryImpl inv = new InventoryImpl();
        Products prod = new Products(name,price,quantity,total);
        inv.addProduct(prod);
        Output.output("Product Added Successfully");
    }
}
