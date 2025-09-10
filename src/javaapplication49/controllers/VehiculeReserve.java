package javaapplication49.controllers;

import java.sql.Connection;
import java.sql.SQLException;
import javaapplication49.models.ModelVehiculeReserve;
import interfaces.InterfaceVehiculeReserve;

public class VehiculeReserve {
    private InterfaceVehiculeReserve vue;
    private Connection connection;

    public VehiculeReserve(InterfaceVehiculeReserve vue, Connection connection) {
        this.vue = vue;
        this.connection = connection;
    }
    public void add(ModelVehiculeReserve vehicule) {
        try {
            ModelVehiculeReserve.add(connection, vehicule); 
            vue.showMessage("added successfully.");
            listVehicules();  
        } catch (SQLException e) {
            vue.showMessage("Error adding: " + e.getMessage());
        }
    } 


    public void listVehicules() {
        try {
            var reservations = ModelVehiculeReserve.getAllVehicules(connection);
            vue.displayReservations(reservations); 
        } catch (SQLException e) {
            vue.showMessage("Error retrieving : " + e.getMessage());
        }
    }
    
       public void deleteVehicule(int id1,int id2){
       try {
      ModelVehiculeReserve.deleteVehicule(connection, id1,id2);
      vue.showMessage("deleted successfully.");
listVehicules();
    } catch (SQLException e) {
        vue.showMessage("Error deleting : " + e.getMessage());
    }
  }


}
