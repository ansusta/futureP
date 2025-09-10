package javaapplication49.controllers;
import java.sql.Connection;
import java.sql.SQLException;
import javaapplication49.models.ModelClient; 
import interfaces.*; 

public class Client {
    private InterfaceClient vue;
    private Connection connection;
    public Client(InterfaceClient vue, Connection connection) {
        this.vue = vue;
        this.connection = connection;
    }
    public void addClient(ModelClient client) { 
    try {
        ModelClient.addClient(connection, client);
        vue.showMessage("Client added successfully.");
          listClients(); 
    } catch (SQLException e) {
        vue.showMessage("Error adding client: " + e.getMessage());
    }
}
      public void listClients() {
    try {
        var vehicules = ModelClient.getAllClients(connection);
        vue.displayVehicules(vehicules);
    } catch (SQLException e) {
        vue.showMessage("Error retrieving clients: " + e.getMessage());
    }
}
    public ModelClient searchClient(String firstName, String lastName) {
    try {
        return ModelClient.searchClient(connection, firstName, lastName);
    } catch (SQLException e) {
        vue.showMessage("Error searching client: " + e.getMessage());
        return null;
    }
}
     public ModelClient searchClient(Integer id) {
    try {
        return ModelClient.searchClient(connection, id);
    } catch (SQLException e) {
        vue.showMessage("Error searching client: " + e.getMessage());
        return null;
    }
}
    
public void updateClient(Integer id , String updatedName, String updatedSurname, int updatedPhone, String updatedEmail, String updatedAddress, int updatedLicenseNum) {
    try {
        boolean success = ModelClient.updateClient(connection, id,updatedName,updatedSurname,updatedPhone,updatedEmail ,updatedAddress,updatedLicenseNum);
        if (success) {
            vue.showMessage("client updated successfully.");
            listClients(); 
        } else {
            vue.showMessage("Failed to update client");
        }
    } catch (SQLException e) {
        vue.showMessage("Error updating client: " + e.getMessage());
    }
}

  public int getTotalClients() {
        try {
            return ModelClient.getClientCount(connection);
        } catch (SQLException e) {
            return 0;
        }
    }
  
  public void deleteClient(Integer id){
       try {
      ModelClient.deleteClient(connection, id );
      vue.showMessage("client updated successfully.");
listClients();
    } catch (SQLException e) {
        vue.showMessage("Error deleting client: " + e.getMessage());
    }
  }
  
}
