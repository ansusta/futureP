package javaapplication49.controllers;
import javaapplication49.models.ModelPayment;
import interfaces.*;
import java.sql.*;
public class Payment {
    private InterfacePayment vue;
    private Connection connection;
    public Payment(InterfacePayment vue, Connection connection) {
        this.vue = vue;
        this.connection = connection;
    }
    public void addPayment(ModelPayment client) { 
    try {
        ModelPayment.addPayment(connection, client);
        vue.showMessage("payment added successfully.");
           listPayments(); 
    } catch (SQLException e) {
        vue.showMessage("Error adding payment: " + e.getMessage());
    }
}
    
      public void updatePayment( Double somme,String type,int date,int contract) {
    try {
        boolean success = ModelPayment.updatePayment(connection , somme , type,date,contract);
        if (success) {
            vue.showMessage("payment updated successfully.");
            listPayments(); 
        } else {
            vue.showMessage("Failed to update payment.");
        }
    } catch (SQLException e) {
        vue.showMessage("Error updating payment: " + e.getMessage());
    }
  
}
      
            public void listPayments() {
    try {
        var vehicules = ModelPayment.getAllPayments(connection);
        vue. displayPayments(vehicules);
    } catch (SQLException e) {
        vue.showMessage("Error retrieving payment: " + e.getMessage());
    }
}
                 public void deletePayment(int nom ){
       try {
      ModelPayment.deletePayment(connection, nom  );
      vue.showMessage("payment deleted successfully.");
listPayments();
    } catch (SQLException e) {
        vue.showMessage("Error deleting payment: " + e.getMessage());
    }
  }
                  public ModelPayment searchPayment(int firstName) {
    try {
        return ModelPayment.searchPayment(connection, firstName);
    } catch (SQLException e) {
        vue.showMessage("Error searching Payments: " + e.getMessage());
        return null;
    }
}
}
