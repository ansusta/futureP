package javaapplication49.controllers;

import javaapplication49.models.ModelEmployee;
import interfaces.*;
import java.sql.*;
public class Employee {
   private InterfaceEmployee vue;
    private Connection connection;
    public Employee(InterfaceEmployee vue, Connection connection) {
        this.vue = vue;
        this.connection = connection;
    }
    public void addEmployee(ModelEmployee client) { 
    try {
        ModelEmployee.addEmployee(connection, client);
        vue.showMessage("employee added successfully.");
          listEmployee(); 
    } catch (SQLException e) {
        vue.showMessage("Error adding employee : " + e.getMessage());
    }
}
     public void listEmployee() {
    try {
        var vehicules = ModelEmployee.getAllEmployees(connection);
        vue.displayEmployees(vehicules); 
    } catch (SQLException e) {
        vue.showMessage("Error retrieving employee: " + e.getMessage());
    }
}
     
     public void updateEmployee(Integer id , String nom, String prenom, String role, Double salaire, String address, String adrsMail, int numTel) {
    try {
        boolean success = ModelEmployee.updateEmployee(connection,id ,  nom, prenom, nom,prenom, role, address , salaire , numTel , adrsMail);
        if (success) {
            vue.showMessage("Employee updated successfully.");
            listEmployee(); 
        } else {
            vue.showMessage("Failed to update employee.");
        }
    } catch (SQLException e) {
        vue.showMessage("Error updating Employee: " + e.getMessage());
    }
}
      public void deleteEmployee(Integer id){
       try {
      ModelEmployee.deleteEmployee(connection, id );
      vue.showMessage("Employee deleted successfully.");
listEmployee();
    } catch (SQLException e) {
        vue.showMessage("Error deleting Employee: " + e.getMessage());
    }
  }
       public ModelEmployee searchEmployee(String firstName, String lastName) {
    try {
        return ModelEmployee.searchEmployee(connection, firstName, lastName);
    } catch (SQLException e) {
        vue.showMessage("Error searching employee: " + e.getMessage());
        return null;
    }
}
        public ModelEmployee searchEmployee(Integer id) {
    try {
        return ModelEmployee.searchEmployee(connection, id);
    } catch (SQLException e) {
        vue.showMessage("Error searching employee: " + e.getMessage());
        return null;
    }
}
}
