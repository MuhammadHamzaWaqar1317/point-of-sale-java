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
        System.out.println(admins.getEmail() + admins.getPassword());
        if(email.equals(admins.getEmail()) && password.equals(admins.getPassword())){
            Output.output("Login Successfully");
            return true;
        }
       
        return false;
    }
   
    @Override
    public boolean loginCash(String email, String password)
    {
        cashier cs=new cashier();
        if(email.equals(cs.getEmail()) && password.equals(cs.getPass())){
        Output.output("Cashier login success!");
        return true;
    }
        return false;
    }
}
