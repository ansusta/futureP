
package javaapplication49.controllers;
import java.sql.*;
import javaapplication49.models.ModelContract;
import interfaces.*;


public class Contract {
        private InterfaceContrat vue;
    private Connection connection;
    public Contract(InterfaceContrat vue, Connection connection) {
        this.vue = vue;
        this.connection = connection;
    }

        public void addContract(ModelContract client) { 
    try {
        ModelContract.addContract(connection, client);
          listContracts();
        vue.showMessage("Contract added successfully.");
    } catch (SQLException e) {
        vue.showMessage("Error adding contract: " + e.getMessage());
    }
}
        
        public void updateContract(Integer id ,int idR ,String t) {
    try {
        boolean success = ModelContract.updateContract(connection, id  , idR,  t);
        if (success) {
            vue.showMessage("contract updated successfully.");
            listContracts();
        } else {
            vue.showMessage("Failed to update contract.");
        }
    } catch (SQLException e) {
        vue.showMessage("Error updating contract: " + e.getMessage());
    }
}

    public void listContracts() {
    try {
        var vehicules = ModelContract.getAllContracts(connection); 
        vue.displayContracts(vehicules); 
    } catch (SQLException e) {
        vue.showMessage("Error retrieving contract: " + e.getMessage());
    }
}     public void deleteContract(int id){
       try {
      ModelContract.deleteContract(connection, id );
      vue.showMessage("contract updated successfully.");
listContracts();
    } catch (SQLException e) {
        vue.showMessage("Error deleting contract: " + e.getMessage());
    }
  }

 public ModelContract searchContract(int firstName) {
    try {
        return ModelContract.searchContract(connection, firstName);
    } catch (SQLException e) {
        vue.showMessage("Error searching client: " + e.getMessage());
        return null;
    }
}
 
 
 
}
