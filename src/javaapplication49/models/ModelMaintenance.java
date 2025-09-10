package javaapplication49.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ModelMaintenance {
    private Integer id;
    private int vehicule;
    private int date;
    private String description;
    private Double cout;
    private String status;
    public ModelMaintenance(int vehicule , int date, Double cout, String description, String status) {
        this.vehicule=vehicule;
        this.date = date;
         this.cout = cout;
        this.description = description;
       
        this.status = status;
    }
        public ModelMaintenance(Integer id , int vehicule , int date, Double cout, String description, String status) {
            this.id=id;
        this.vehicule=vehicule;
        this.date = date;
         this.cout = cout;
        this.description = description;
       
        this.status = status;
    }
     public Integer getId(){
    return id;
}
     public int getVehicule() {
        return vehicule;
    }
    public int getDate() {
        return date;
    }
    public String getDescription() {
        return description;
    }
    public Double getCout() {
        return cout;
    }
    public String getStatus() {
        return status;
    }
    public void setVehicule(int date) {
        this.vehicule = date;
    }
    public void setDate(int date) {
        this.date = date;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCout(Double cout) {
        this.cout = cout;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
         public static void addMaintenance(Connection connection, ModelMaintenance maintenance) throws SQLException {
        String sql = "INSERT INTO maintenance(idVehicule, description, coutMaintenance,dateMaintenance, statut) VALUES (?,?, ?, ?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, maintenance.getVehicule());
            stmt.setString(2, maintenance.getDescription());
            stmt.setDouble(3, maintenance.getCout());
            stmt.setInt(4, maintenance.getDate());
            stmt.setString(5, maintenance.getStatus());
            stmt.executeUpdate();
        }
    }

    public static List<ModelMaintenance> getAllMaintenances(Connection connection) throws SQLException {
        String sql = "SELECT * FROM maintenance";
        List<ModelMaintenance> maintenances = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                maintenances.add(new ModelMaintenance(
                        rs.getInt("idMaintenance"),
                        rs.getInt("idVehicule"),
                        rs.getInt("dateMaintenance"),
                        rs.getDouble("coutMaintenance"),
                        rs.getString("description"),
                        rs.getString("statut")
                ));
            }
        }
        return maintenances;
    }
    
     public static boolean updateMaintenance(Connection connection,Integer id, int date,Double cout , int vehicule, String description, String status) throws SQLException {
        String sql = "UPDATE maintenance SET description = ?, coutMaintenance = ?, statut = ?, dateMaintenance=?, idVehicule=? WHERE idMaintenance = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, description);
            stmt.setDouble(2, cout);
            stmt.setString(3, status);
              stmt.setInt(4,date);
            stmt.setInt(5, vehicule);
             stmt.setInt(6, id);
          
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        }
    }
        public static void deleteMaintenance(Connection connection, int id ) throws SQLException {
        String sql = "DELETE FROM maintenance WHERE idMaintenance= ? ";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1,id);
            stmt.executeUpdate();
        }
    }
        
            public static ModelMaintenance searchMaintenance(Connection connection, int id) throws SQLException {
    String query = "SELECT * FROM maintenance WHERE idMaintenance = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setInt(1, id);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return new ModelMaintenance(
                        resultSet.getInt("idVehicule"),
                        resultSet.getInt("dateMaintenance"),
                        resultSet.getDouble("coutMaintenance"),
                        resultSet.getString("description"),
                        resultSet.getString("statut")        
                );
            }
        }
    }
    return null;
}
            
            
    
}
