package javaapplication49.controllers;
import javaapplication49.models.ModelEmployeeParticipe;
import interfaces.InterfaceEmployeeParticipant;
import java.sql.Connection;
import java.sql.SQLException;
public class EmployeeParticipe {
    private InterfaceEmployeeParticipant vue;
    private Connection connection;

    public EmployeeParticipe(InterfaceEmployeeParticipant vue, Connection connection) {
        this.vue = vue;
        this.connection = connection;
    }

    public void add(ModelEmployeeParticipe vehicule) {
        try {
            ModelEmployeeParticipe.add(connection, vehicule); 
            vue.showMessage("added successfully.");
            list();  
        } catch (SQLException e) {
            vue.showMessage("Error adding : " + e.getMessage());
        }
    } 


    public void list() {
        try {
            var reservations = ModelEmployeeParticipe.getAll(connection);
            vue.displayM(reservations); 
        } catch (SQLException e) {
            vue.showMessage("Error retrieving: " + e.getMessage());
        }
    }
    
       public void delete(int id1,int id2){
       try {
      ModelEmployeeParticipe.delete(connection, id1,id2);
      vue.showMessage("deleted successfully.");
list();
    } catch (SQLException e) {
        vue.showMessage("Error deleting : " + e.getMessage());
    }
  }


}
