/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project;
import java.sql.*;

/**
 *
 * @author NANCY
 */
public class SQL_CONNECTION {
    public static Connection getcon(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_examination", "root", "");
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Log the exception stack trace
            return null; // Or throw a custom exception to handle it elsewhere
        }
    }
}

