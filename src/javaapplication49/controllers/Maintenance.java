package javaapplication49.controllers;

import java.sql.Connection;
import java.sql.SQLException;
import javaapplication49.models.*;
import interfaces.*;

public class Maintenance {
    private InterfaceMaintenance vue;
    private Connection connection;

    public Maintenance(InterfaceMaintenance vue, Connection connection) {
        this.vue = vue;
        this.connection = connection;
    }
    public void addMaintenance(ModelMaintenance maintenance) {
        try {
            ModelMaintenance.addMaintenance(connection, maintenance);
            vue.showMessage("Maintenance added successfully.");
             listMaintenances(); 
        } catch (SQLException e) {
            vue.showMessage("Error adding maintenance: " + e.getMessage());
        }
    }

    public void listMaintenances() {
        try {var maintenances = ModelMaintenance.getAllMaintenances(connection);
            vue.displayMaintenances(maintenances);
        } catch (SQLException e) {
            vue.showMessage("Error retrieving maintenances: " + e.getMessage());
        }
    }

   public void updateMaintenance(Integer id , int date , Double cout , int vehicule , String description,String status) {
    try {
        boolean success = ModelMaintenance.updateMaintenance(connection, id , date ,  cout , vehicule , description, status);
        if (success) {
            vue.showMessage("maintenance updated successfully.");
            listMaintenances(); 
        } else {
            vue.showMessage("Failed to update maintenance.");
        }
    } catch (SQLException e) {
        vue.showMessage("Error updating maintenance: " + e.getMessage());
    }
  
}
   
        public void deleteMaintenance(int nom ){
       try {
      ModelMaintenance.deleteMaintenance(connection, nom );
      vue.showMessage("maintenance deleted successfully.");
listMaintenances();
    } catch (SQLException e) {
        vue.showMessage("Error deleting maintenance: " + e.getMessage());
    }
  }
         public ModelMaintenance searchMaintenance(int firstName) {
    try {
        return ModelMaintenance.searchMaintenance(connection, firstName);
    } catch (SQLException e) {
        vue.showMessage("Error searching maintenance: " + e.getMessage());
        return null;
    }
}
}