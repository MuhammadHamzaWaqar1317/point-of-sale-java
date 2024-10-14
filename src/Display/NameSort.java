/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Display;

import acpproject.InventoryImpl;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author abdul
 */
public class NameSort {
    static JFrame frame;
    static JLabel messageLabel;
    static JButton ascending, descending,back;
    static InventoryImpl inv = new InventoryImpl();
    
    public static void sortByName(){
        frame = new JFrame("Sort Products");
        frame.setSize(400,400);
        frame.setLocation(760, 240);
        frame.setUndecorated(true);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.decode("#7DBFFF"));
        frame.add(panel);
        
        messageLabel = new JLabel("Sort Products");
        messageLabel.setBounds(150, 30, 150, 40);
        messageLabel.setFont(new Font("Arial",Font.BOLD,16));
        panel.add(messageLabel);
        
        ascending = new JButton("Ascending");
        ascending.setBounds(125,100,150,40);
        ascending.addActionListener(new ActionListener(){
           @Override
            public void actionPerformed(ActionEvent e) {
                inv.sortByName(true, false);
                inv.viewInventory();
            } 
        });
        panel.add(ascending);
        
        descending = new JButton("Descending");
        descending.setBounds(125,150,150,40);
        descending.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                inv.sortByName(false, true);
                inv.viewInventory();
            }
        });
        panel.add(descending);
        
        back = new JButton("Back");
        back.setBounds(125,200,150,40);
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
}
