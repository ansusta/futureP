package javaapplication49.models;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
public class ModelEmployeeParticipe {
    private int idMaintenance;
    private int idEmployee;
    public ModelEmployeeParticipe(int reservationId, int vehiculeIds) {
        this.idMaintenance= reservationId;
        this.idEmployee = vehiculeIds;
    }
    public int getMaintenance() {
        return idMaintenance;
    }
    public void setMaintenance(int reservationId) {
        this.idMaintenance = reservationId;
    }
    public int getEmployee() {
        return idEmployee;
    }
    public void setEmployee(int vehiculeIds) {
        this.idEmployee= vehiculeIds;
    }
  public static void add(Connection connection, ModelEmployeeParticipe vehicule) throws SQLException {
    String sql = "INSERT INTO realiser (idMaintenance,idEmployee) VALUES (?, ?)";
    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, vehicule.getMaintenance());
        stmt.setInt(2, vehicule.getEmployee());
        stmt.executeUpdate();
    }
}
      public static List<ModelEmployeeParticipe> getAll(Connection connection) throws SQLException {
    String sql = "SELECT * FROM realiser";
    List<ModelEmployeeParticipe> vehicules = new ArrayList<>();
    try (PreparedStatement stmt = connection.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            vehicules.add(new ModelEmployeeParticipe(
                    rs.getInt("idMaintenance"),
                    rs.getInt("idEmployee")
                   
            ));
        }
    }
    return vehicules;
}
      
        public static void delete(Connection connection ,int id1 , int id2 ) throws SQLException {
        String sql = "DELETE FROM realiser WHERE idMaintenance =? AND idEmployee = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id1);
            stmt.setInt(2, id2);
            stmt.executeUpdate();
        }
    }
        
}

