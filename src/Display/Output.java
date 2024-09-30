/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Display;

import javax.swing.JOptionPane;

/**
 *
 * @author abdul
 */
public class Output {
    public static void output(String message){
        JOptionPane.showMessageDialog(null, message);
    }
    
    public static void errorMsg(String message){
        JOptionPane.showMessageDialog(null,message,"Error",JOptionPane.ERROR_MESSAGE);
    }
}
