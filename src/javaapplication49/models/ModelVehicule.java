package javaapplication49.models;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ModelVehicule {
    private Integer id;
    private String marque;
    private String model;
    private int anne;
    private String licencePlate;
    private String status;
    private String color;
    private String type;
    public ModelVehicule(String marque, String model, int anne, String licencePlate, String status, String color, String type) {
        this.marque = marque;
        this.model = model;
        this.anne = anne;
        this.licencePlate = licencePlate;
        this.status = status;
        this.color = color;
        this.type = type;

    }
      public ModelVehicule(Integer id ,String marque, String model, int anne, String licencePlate, String status, String color, String type) {
        this.id=id;
          this.marque = marque;
        this.model = model;
        this.anne = anne;
        this.licencePlate = licencePlate;
        this.status = status;
        this.color = color;
        this.type = type;

    }
     public Integer getId(){
    return id;
}
    public String getMarque() {
        return marque;
    }
    public String getModel() {
        return model;
    }
    public int getAnne() {
        return anne;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public String getStatus() {
        return status;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }
    
    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setAnne(int anne) {
        this.anne = anne;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setType(String type) {
        this.type = type;
    }
    public static void addVehicule(Connection connection, ModelVehicule vehicule) throws SQLException {
    String sql = "INSERT INTO vehicules (marque, modele, anne, type, plaque, status, couleur) VALUES (?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setString(1, vehicule.getMarque());
        stmt.setString(2, vehicule.getModel());
        stmt.setInt(3, vehicule.getAnne());
        stmt.setString(4, vehicule.getType());
        stmt.setString(5, vehicule.getLicencePlate());
        stmt.setString(6, vehicule.getStatus());
        stmt.setString(7, vehicule.getColor());
        stmt.executeUpdate();
    }
}
    public static void deleteVehicule(Connection connection , Integer m ) throws SQLException {
        String sql = "DELETE FROM vehicules WHERE idVehicule = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, m);
            stmt.executeUpdate();
        }
    }
    public static ModelVehicule searchVehicule(Connection connection, String marque, String model) throws SQLException {
        String query = "SELECT * FROM vehicules WHERE marque = ? AND modele = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, marque);
            stmt.setString(2, model);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ModelVehicule(
                            rs.getString("marque"),
                            rs.getString("modele"),
                            rs.getInt("anne"),
                            rs.getString("plaque"),
                            rs.getString("status"),
                            rs.getString("couleur"),
                            rs.getString("type")
                    );
                    
                }
            }
        }
        return null;
    }
    
      public static ModelVehicule searchVehicule(Connection connection, Integer id) throws SQLException {
        String query = "SELECT * FROM vehicules WHERE idVehicule=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ModelVehicule(
                            rs.getString("marque"),
                            rs.getString("modele"),
                            rs.getInt("anne"),
                            rs.getString("plaque"),
                            rs.getString("status"),
                            rs.getString("couleur"),
                            rs.getString("type")
                    );
                    
                }
            }
        }
        return null;
    }
public static boolean updateVehicule(Connection connection,Integer id, String marque, String model, String updatedMarque, String updatedModel, int updatedYear, String updatedLicencePlate, String updatedStatus, String updatedColor, String updatedType) throws SQLException {
    String query = "UPDATE vehicules SET marque = ?, modele = ?, anne = ?, plaque = ?, status = ?, couleur = ?, type = ? WHERE idVehicule=?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setString(1, updatedMarque);
        stmt.setString(2, updatedModel);
        stmt.setInt(3, updatedYear);
        stmt.setString(4, updatedLicencePlate);
        stmt.setString(5, updatedStatus);
        stmt.setString(6, updatedColor);
        stmt.setString(7, updatedType);
        stmt.setInt(8, id);
    
        int rowsUpdated = stmt.executeUpdate();
        return rowsUpdated > 0;
    }
}
    public static List<ModelVehicule> getAllVehicules(Connection connection) throws SQLException {
    String sql = "SELECT * FROM vehicules";
    List<ModelVehicule> vehicules = new ArrayList<>();
    try (PreparedStatement stmt = connection.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            vehicules.add(new ModelVehicule(
                    rs.getInt("idVehicule"),
                    rs.getString("marque"),
                    rs.getString("modele"),
                    rs.getInt("anne"),
                    rs.getString("plaque"),
                    rs.getString("status"),
                    rs.getString("couleur"),
                    rs.getString("type")
            ));
            
        }
    }
    return vehicules;
}
    
    public static int getAvailableVehicleCount(Connection connection) throws SQLException {
    String query = "SELECT COUNT(*) AS count FROM vehicules WHERE status = 'disponible'";
    try (PreparedStatement preparedStatement = connection.prepareStatement(query);
         ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
            return resultSet.getInt("count");
        }
    }
    
    return 0; 
}
    
    public static List<ModelVehicule> DisponibleVehicules(Connection connection) throws SQLException{
        String query ="SELECT * FROM  vehicules WHERE status='disponible'";
          List<ModelVehicule> vehicules = new ArrayList<>(); 
          try(
              PreparedStatement stmt = connection.prepareStatement(query);
              ResultSet rs= stmt.executeQuery()){
               while (rs.next()) {
            vehicules.add(new ModelVehicule(
                    rs.getInt("idVehicule"),
                    rs.getString("marque"),
                    rs.getString("modele"),
                    rs.getInt("anne"),
                    rs.getString("plaque"),
                    rs.getString("status"),
                    rs.getString("couleur"),
                    rs.getString("type")
            ));  
        }
          } 
          return vehicules;
    }
    

}
