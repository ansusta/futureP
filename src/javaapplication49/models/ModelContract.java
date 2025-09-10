package javaapplication49.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModelContract {
    private int location;
    private String termes;
    private Integer id;
    public ModelContract(int l , String termes) {
        this.location=l;
        this.termes = termes;
    }
     public ModelContract(Integer id,int l , String termes) {
         this.id=id;
        this.location=l;
        this.termes = termes;
    }
    public Integer getId(){
    return id;
}
    public int getLocation() {
        return location;
    }
    public String getTermes() {
        return termes;
    }    
        public void setLocation(int location) {
        this.location = location;
    }
    public void setTermes(String termes) {
        this.termes = termes;
    }
       public static void addContract(Connection connection, ModelContract contrat) throws SQLException {
        String sql = "INSERT INTO contrats (idReservation,termes) VALUES (?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, contrat.location);
            stmt.setString(2, contrat.termes);
            stmt.executeUpdate();
        }
    }
      public static List<ModelContract> getAllContracts(Connection connection) throws SQLException {
        String sql = "SELECT * FROM contrats";
        List<ModelContract> contracts = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                contracts.add(new ModelContract(
                        rs.getInt("idContrat"),
                        rs.getInt("idReservation"),
                        rs.getString("termes")
                ));
            }
        }
        return contracts;
    }

public static boolean updateContract(Connection connection,Integer id ,  int updatedReservation, String updatedTerms) throws SQLException {
    String query = "UPDATE contrats SET idReservation = ?, termes = ? WHERE idContrat = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setInt(1, updatedReservation);  
        stmt.setString(2, updatedTerms);     
        stmt.setInt(3, id);                
        int rowsUpdated = stmt.executeUpdate();
        return rowsUpdated > 0;            
    }
}

   public static void deleteContract(Connection connection, int id ) throws SQLException {
        String sql = "DELETE FROM contrats WHERE idReservation = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1,id);
            stmt.executeUpdate();
        }
    }
   
       public static ModelContract searchContract(Connection connection, int firstName) throws SQLException {
    String query = "SELECT * FROM contrats WHERE idContrat = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setInt(1, firstName);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return new ModelContract(
                        resultSet.getInt("idContrat"),
                    resultSet.getInt("idReservation"),         
                    resultSet.getString("termes")     
        
                );
            }
        }
    }
    return null;
}
       
       

}
