/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acpproject;

/**
 *
 * @author abdul
 */
public class Admin {
    private String adminrole;
    Inventory inv ;
    int id;
    String name;
    String email;
    String Password;
    
    public Admin(int user_id, String user_name, String email, String Password) {
        this.id = user_id;
        this.name = user_name;
        this.email = email;
        this.Password = Password;
    }

    Admin() {
        id = 1;
        name = "admin";
        email = "admin";
        Password = "admin";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return Password;
    } 
}
