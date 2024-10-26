/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Display;
import acpproject.*;
import java.awt.*;
import java.awt.event.*;
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
    static JLabel Email,Password,messageLabel;
    
    public static void loginFrame(){
        frame = new JFrame("Login Frame");
        frame.setSize(400,600);
        frame.setLocation(760, 240);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GridLayout GL = new GridLayout(2,2,10,10);
        BorderLayout BL = new BorderLayout(10,10);
        JPanel background = new JPanel(BL);
        
        JPanel panel = new JPanel(GL);
        background.setBackground(Color.decode("#7DBFFF"));
        panel.setSize(200, 200);
        frame.add(background);
        background.add(panel,BorderLayout.CENTER);
        
        messageLabel = new JLabel("LOGIN");
        Email = new JLabel("Enter Email");
        Password = new JLabel("Enter Password");
        
        emailField = new JTextField();
        
        passwordField = new JPasswordField();
        
        background.add(messageLabel,BorderLayout.NORTH);
        
        login = new JButton("Login");
        login.setBounds(150,300,100,40);
        login.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                handleLogin();
            }
        });
        
        panel.add(Email);
        panel.add(emailField);
        panel.add(Password);
        panel.add(passwordField);
        background.add(login,BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    
    public static void handleLogin(){
        Account account = new AccountImp();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        boolean isAdmin = account.login(email,password);
        if(isAdmin){
            frame.setVisible(false);
            Output.output("Login Successful");
            Product.productsFrame();
        }
        else{
            Output.output("wrong credentials!");
        }
    }
 }


