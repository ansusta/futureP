package javaapplication49.controllers;

import java.sql.Connection;
import java.sql.SQLException;
import javaapplication49.models.ModelVehicule;
import interfaces.InterfaceVehicule;

public class Vehicule {
    private InterfaceVehicule vue;
    private Connection connection;

    public Vehicule(InterfaceVehicule vue, Connection connection) {
        this.vue = vue;
        this.connection = connection;
    }

    public void addVehicule(ModelVehicule vehicule) {
        try {
            ModelVehicule.addVehicule(connection, vehicule);
            vue.showMessage("Vehicule added successfully.");
            listVehicules(); 
        } catch (SQLException e) {
            vue.showMessage("Error adding vehicule: " + e.getMessage());
        }
    }


    public ModelVehicule searchVehicule(String make, String model) {
        try {
            return ModelVehicule.searchVehicule(connection, make, model);  
        } catch (SQLException e) {
            vue.showMessage("Error searching vehicule: " + e.getMessage());
            return null;
        }
    }
       public ModelVehicule searchVehicule(Integer id) {
        try {
            return ModelVehicule.searchVehicule(connection, id);  
        } catch (SQLException e) {
            vue.showMessage("Error searching vehicule: " + e.getMessage());
            return null;
        }
    }

public void updateVehicule(Integer id, String marque, String model, int anne, String licencePlate, String status, String color, String type) {
    try {
        boolean success = ModelVehicule.updateVehicule(connection, id , marque, model, marque, model, anne, licencePlate, status, color, type);
        if (success) {
            vue.showMessage("Vehicule updated successfully.");
            listVehicules(); 
        } else {
            vue.showMessage("Failed to update vehicule.");
        }
    } catch (SQLException e) {
        vue.showMessage("Error updating vehicule: " + e.getMessage());
    }
    
}

    
    
    public void listVehicules() {
    try {
        var vehicules = ModelVehicule.getAllVehicules(connection);
        vue.displayVehicules(vehicules); 
    } catch (SQLException e) {
        vue.showMessage("Error retrieving vehicules: " + e.getMessage());
    }
}   
      public int getAvailableVehicles() {
        try {
            return ModelVehicule.getAvailableVehicleCount(connection);
        } catch (SQLException e) {
            return 0; 
        }
    }
           public void deleteVehicule(Integer id){
       try {
      ModelVehicule.deleteVehicule(connection, id);
      vue.showMessage("vehicule deleted successfully.");
listVehicules();
    } catch (SQLException e) {
        vue.showMessage("Error deleting vehicule: " + e.getMessage());
    }
  }
           
             public void listDisponibles() {
    try {
        var vehicules = ModelVehicule.DisponibleVehicules(connection);
        vue.displayVehicules(vehicules); 
    } catch (SQLException e) {
        vue.showMessage("Error retrieving vehicules: " + e.getMessage());
    }
}          
}
