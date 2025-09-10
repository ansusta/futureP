package javaapplication49.models;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
public class ModelVehiculeReserve {
    private int idReservation;
    private int idVehicule;
    public ModelVehiculeReserve(int reservationId, int vehiculeIds) {
        this.idReservation= reservationId;
        this.idVehicule = vehiculeIds;
    }
    public int getReservationId() {
        return idReservation;
    }
    public void setReservationId(int reservationId) {
        this.idReservation = reservationId;
    }
    public int getVehiculeIds() {
        return idVehicule;
    }
    public void setVehiculeIds(int vehiculeIds) {
        this.idVehicule = vehiculeIds;
    }
  public static void add(Connection connection, ModelVehiculeReserve vehicule) throws SQLException {
    String sql = "INSERT INTO reservation_cars (idReservation,idVehicule) VALUES (?, ?)";
    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, vehicule.getReservationId());
        stmt.setInt(2, vehicule.getVehiculeIds());
    
        stmt.executeUpdate();
    }
}
      public static List<ModelVehiculeReserve> getAllVehicules(Connection connection) throws SQLException {
    String sql = "SELECT * FROM reservation_cars";
    List<ModelVehiculeReserve> vehicules = new ArrayList<>();
    try (PreparedStatement stmt = connection.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            vehicules.add(new ModelVehiculeReserve(
                    rs.getInt("idReservation"),
                    rs.getInt("idVehicule")
                   
            ));
        }
    }
    return vehicules;
}
      
        public static void deleteVehicule(Connection connection ,int id1 , int id2 ) throws SQLException {
        String sql = "DELETE FROM reservation_cars WHERE idReservation =? AND idVehicule = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id1);
            stmt.setInt(2, id2);
            stmt.executeUpdate();
        }
    }
        
}
