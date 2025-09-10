package javaapplication49.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ModelLocation {
    private Integer id;
   private int client;
   private int vehicule;
    private int dateDebut;
    private int dateFin;
    private Double prixTotal;
    private String status;
    
    public ModelLocation(int c, int v, int dateDebut, int dateFin, Double prixTotal, String status) {
        this.client=c;
        this.vehicule=v;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prixTotal = prixTotal;
        this.status = status;
    }
       public ModelLocation(Integer id ,int c, int v, int dateDebut, int dateFin, Double prixTotal, String status) {
        this.id=id;
           this.client=c;
        this.vehicule=v;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prixTotal = prixTotal;
        this.status = status;
    }
     public Integer getId(){
    return id;
}
  public int getClient() {
        return client;
    }
  public int getVehicule() {
        return vehicule;
    }
    public int getDateDebut() {
        return dateDebut;
    }
    public int getDateFin() {
        return dateFin;
    }
    public Double getPrixTotal() {
        return prixTotal;
    }
    public String getStatus() {
        return status;
    }
 public void setClient(int dateDebut) {
        this.client = dateDebut;
    }
  public void setVehicule(int dateDebut) {
        this.vehicule = dateDebut;
    }
    public void setDateDebut(int dateDebut) {
        this.dateDebut = dateDebut;
    }
    public void setDateFin(int dateFin) {
        this.dateFin = dateFin;
    }
    public void setPrixTotal(Double prixTotal) {
        this.prixTotal = prixTotal;
    }
    public void setStatus(String status) {
        this.status = status;
    }
     public static void addLocation(Connection connection, ModelLocation client) throws SQLException {
        String sql = "INSERT INTO locations (idClient,idEmployee,dateDebut, dateFin, coutTotal, statut) VALUES (?,?,?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, client.client);
            stmt.setInt(2, client.vehicule);
            stmt.setInt(3, client.dateDebut);
            stmt.setInt(4, client.dateFin);
            stmt.setDouble(5, client.prixTotal);
            stmt.setString(6, client.status);
            stmt.executeUpdate();
        }
    }
     public static List<ModelLocation> getAllLocations(Connection connection) throws SQLException {
        String sql = "SELECT * FROM locations";
        List<ModelLocation> locations = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                locations.add(new ModelLocation(
                        rs.getInt("idLocation"),
                        rs.getInt("idEmployee"),
                        rs.getInt("idClient"),
                        rs.getInt("dateDebut"),
                        rs.getInt("dateFin"),
                        rs.getDouble("coutTotal"),
                        rs.getString("statut")
                ));
            }
        }
        return locations;
    }
    public static boolean updateLocation(Connection connection, Integer id, int idEmployee, int idClient , int dateDebut, int dateFin, double prixTotal, String status) throws SQLException {
        String sql = "UPDATE locations SET idEmployee=? , idClient=?, dateDebut = ?, dateFin = ?, coutTotal = ?, statut = ? WHERE idLocation=? ";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idEmployee);
            stmt.setInt(2, idClient);
            stmt.setInt(3, dateDebut);
            stmt.setInt(4, dateFin);
            stmt.setDouble(5, prixTotal);
            stmt.setString(6, status);
            stmt.setInt(7, id);
           
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        }
}
       public static void deleteLocation(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM Locations WHERE idLocation=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1,id);
            stmt.executeUpdate();
        }
    }
       
           public static ModelLocation searchLocation(Connection connection, int firstName, int lastName) throws SQLException {
    String query = "SELECT * FROM locations WHERE idEmployee = ? AND idClient = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setInt(1, firstName);
        preparedStatement.setInt(2, lastName);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return new ModelLocation(
               resultSet.getInt("idEmployee"),
                        resultSet.getInt("idClient"),
                        resultSet.getInt("dateDebut"),
                        resultSet.getInt("dateFin"),
                        resultSet.getDouble("coutTotal"),
                        resultSet.getString("statut")     
                );
            }
        }
    }
    return null;
}
           
           
           public static ModelLocation searchLocation(Connection connection, int id) throws SQLException {
    String query = "SELECT * FROM locations WHERE idLocation=?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setInt(1, id);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return new ModelLocation(
               resultSet.getInt("idEmployee"),
                        resultSet.getInt("idClient"),
                        resultSet.getInt("dateDebut"),
                        resultSet.getInt("dateFin"),
                        resultSet.getDouble("coutTotal"),
                        resultSet.getString("statut")     
                );
            }
        }
    }
    return null;
}

}