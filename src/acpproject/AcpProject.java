/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acpproject;
import Display.*;
import java.sql.*;

/**
 *
 * @author Dell
 */
public class AcpProject {
   
    public static void main(String[] args) {
        
        try {
            Connection connection=JDBC.getConnection();
            Statement statement=connection.createStatement();
            String createTable="create table if not exists products(id INT AUTO_INCREMENT PRIMARY KEY,name VARCHAR(50),price INT,quantity INT, total_cost INT)";
            connection.prepareStatement(createTable);
            statement.executeUpdate(createTable);
            
            Login.loginFrame();
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
}
