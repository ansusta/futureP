package javaapplication49.controllers;
import javaapplication49.models.ModelLocation;
import interfaces.*;
import java.sql.*;
public class Location {
   private InterfaceLocation vue;
    private Connection connection;
    public Location(InterfaceLocation vue, Connection connection) {
        this.vue = vue;
        this.connection = connection;
    }
    public void addLocation(ModelLocation client) { 
    try {
        ModelLocation.addLocation(connection, client);
        vue.showMessage("reservation added successfully.");
         listLocations(); 
    } catch (SQLException e) {
        vue.showMessage("Error adding reservation: " + e.getMessage());
    }
}
    
    
      public void listLocations() {
        try {var maintenances = ModelLocation.getAllLocations(connection);
            vue.displayLocations(maintenances);
        } catch (SQLException e) {
            vue.showMessage("Error retrieving reservations: " + e.getMessage());
        }
    }

   
public void updateLocation( Integer id , int idEmployee, int idClient ,  int dateDebut, int dateFin, double prixTotal, String status) {
    try {
        boolean success = ModelLocation.updateLocation(connection,id , idEmployee, idClient ,  dateDebut,  dateFin, prixTotal, status);
        if (success) {
            vue.showMessage("reservation updated successfully.");
            listLocations(); 
        } else {
            vue.showMessage("Failed to update reservation.");
        }
    } catch (SQLException e) {
        vue.showMessage("Error updating reservation: " + e.getMessage());
    }
}

 public void deleteLocation(Integer id){
       try {
      ModelLocation.deleteLocation(connection, id );
      vue.showMessage("location deleted successfully.");
listLocations();
    } catch (SQLException e) {
        vue.showMessage("Error deleting location: " + e.getMessage());
    }
  }
 
  public ModelLocation searchLocation(int firstName, int lastName) {
    try {
        return ModelLocation.searchLocation(connection, firstName, lastName);
    } catch (SQLException e) {
        vue.showMessage("Error searching for reservation: " + e.getMessage());
        return null;
    }
}
   public ModelLocation searchLocation(Integer id) {
    try {
        return ModelLocation.searchLocation(connection, id);
    } catch (SQLException e) {
        vue.showMessage("Error searching for reservation: " + e.getMessage());
        return null;
    }
}
}
