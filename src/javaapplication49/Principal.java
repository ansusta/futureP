package javaapplication49;

import java.sql.Connection;
import javaapplication49.controllers.*; 
import interfaces.*;
import javaapplication49.models.*;

public class Principal {
    

    public static void main(String[] args) {
        Connection connection = DataBaseConnection.getConnection(); 
        if (connection == null) {
            System.err.println("Failed to connect to the database. Exiting...");
            return;
        }

        java.awt.EventQueue.invokeLater(() -> new Home().setVisible(true));
      
    }
}
