/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acpproject;
import Display.Output;

import java.util.ArrayList;

/**
 *
 * @author abdul
 */
public class AccountImp implements Account{

    @Override
    public boolean login(String email,String password) {
        Admin admins = new Admin();
        if(email.equals(admins.getEmail()) && password.equals(admins.getPassword())){
            return true;
        }
       
        return false;
    }
}
