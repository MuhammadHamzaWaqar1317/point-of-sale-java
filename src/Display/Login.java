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
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author abdul
 */
public class Login {
    static JFrame frame;
    static JTextField emailField;
    static JPasswordField passwordField;
    static JButton login;
    
    public static void loginFrame(){
        frame = new JFrame("Login Frame");
        frame.setSize(400,600);
        frame.setLocation(760, 240);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.decode("#7DBFFF"));
        frame.add(panel);
        
        JLabel messageLabel = new JLabel("LOGIN");
        messageLabel.setBounds(150, 30, 100, 40);
        messageLabel.setFont(new Font("Arial",Font.BOLD,24));
        panel.add(messageLabel);
        
        messageLabel = new JLabel("Enter Email");
        messageLabel.setBounds(50, 80, 300, 40);
        
        panel.add(messageLabel);
        
        emailField = new JTextField();
        emailField.setBounds(50, 130, 300, 40);
        panel.add(emailField);
        
        messageLabel = new JLabel("Enter Password");
        messageLabel.setBounds(50, 180, 300, 40);
        panel.add(messageLabel);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(50, 230, 300, 40);
        panel.add(passwordField);
        
        login = new JButton("Login");
        login.setBounds(150,300,100,40);
        login.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                handleLogin();
            }
        });
        panel.add(login);
        frame.setVisible(true);
    }
    
    public static void handleLogin(){
        Account account = new AccountImp();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        boolean isAdmin = account.login(email,password);
        boolean isCashier=account.loginCash(email, password);
        InventoryImpl inv=new InventoryImpl();
        CartImpl cart=new CartImpl(inv.getProds());
        if(isAdmin){
            frame.setVisible(false);
            Output.output("Login Successful");
            Product.productsFrame();
        }
        else if(isCashier){
            frame.setVisible(false);
                                    int cho=0;
                                    int chi=0;
                        do{
                        String message="1. add items\n"+
                                "2. remove items\n"+
                                "3. view cart\n"+
                                "4. checkout\n"+
                                "5. exit\n"+
                                "6. back";
                        cho=Integer.parseInt(Input.getInput(message));
                        switch(cho){
                            case 1:
                                cart.addItems();
                                break;
                            case 2:
                                cart.removeItems();
                                break;
                            case 3:
                                cart.viewCart();
                                break;
                            case 4:
                                cart.checkOut();
                                break;
                            case 5:
                                System.exit(0);
                            case 6:
                                chi=1;
                                frame.setVisible(true);
                                break;
                            default:
                                Output.output("enter a valid choice!");
                        }
                        }while(cho!=6);
                    }
        else{
            Output.output("wrong credentials!");
        }
        }
        
    
}

