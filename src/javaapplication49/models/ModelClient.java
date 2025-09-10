package javaapplication49.models;
import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelClient {
    private Integer id;
    private String nom;
    private String prenom;
    private int numTel;
    private String adrsMail;
    private int numPermis;
    private String adrs;

    
    public ModelClient(String nom, String prenom, int numTel, String adrsMail, int numPermis, String adrs) {
        this.nom = nom;
        this.prenom = prenom;
        this.numTel = numTel;
        this.adrsMail = adrsMail;
        this.numPermis = numPermis;
        this.adrs = adrs;
    }
    public ModelClient(Integer id, String nom, String prenom, int numTel, String adrsMail, int numPermis, String adrs) {
    this.id = id;
    this.nom = nom;
    this.prenom = prenom;
    this.numTel = numTel;
    this.adrsMail = adrsMail;
    this.numPermis = numPermis;
    this.adrs = adrs;
}


   
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getNumTel() {
        return numTel;
    }

    public String getAdrsMail() {
        return adrsMail;
    }

    public int getNumPermis() {
        return numPermis;
    }

    public String getAdrs() {
        return adrs;
    }
public Integer getId(){
    return id;
}
  
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    public void setAdrsMail(String adrsMail) {
        this.adrsMail = adrsMail;
    }

    public void setNumPermis(int numPermis) {
        this.numPermis = numPermis;
    }

    public void setAdrs(String adrs) {
        this.adrs = adrs;
    }
     public static void addClient(Connection connection, ModelClient client) throws SQLException {
        String sql = "INSERT INTO clients (nom, prenom, numTel, adrsMail, numPermis, adrs) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, client.nom);
            stmt.setString(2, client.prenom);
            stmt.setInt(3, client.numTel);
            stmt.setString(4, client.adrsMail);
            stmt.setInt(5, client.numPermis);
            stmt.setString(6, client.adrs);
            stmt.executeUpdate();
        }
    }

    public static void deleteClient(Connection connection, Integer id) throws SQLException {
        String sql = "DELETE FROM clients WHERE idClient=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1,id);
            stmt.executeUpdate();
        }
    }

    public static List<ModelClient> getAllClients(Connection connection) throws SQLException {
        String sql = "SELECT * FROM clients";
        List<ModelClient> clients = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                clients.add(new ModelClient(
                        rs.getInt("idClient"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getInt("numTel"),
                        rs.getString("adrsMail"),
                        rs.getInt("numPermis"),
                        rs.getString("adrs")
                ));
            }
        }
        return clients;
    }    
    public static ModelClient searchClient(Connection connection, String firstName, String lastName) throws SQLException {
    String query = "SELECT * FROM clients WHERE nom = ? AND prenom = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return new ModelClient(
                    resultSet.getString("nom"),         
                    resultSet.getString("prenom"),      
                    resultSet.getInt("numTel"),         
                    resultSet.getString("adrsMail"),   
                    resultSet.getInt("numPermis"),      
                    resultSet.getString("adrs")         
                );
            }
        }
    }
    return null;
}
        public static ModelClient searchClient(Connection connection, Integer id) throws SQLException {
    String query = "SELECT * FROM clients WHERE idClient= ? ";
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setInt(1, id);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return new ModelClient(
                    resultSet.getString("nom"),         
                    resultSet.getString("prenom"),      
                    resultSet.getInt("numTel"),         
                    resultSet.getString("adrsMail"),   
                    resultSet.getInt("numPermis"),      
                    resultSet.getString("adrs")         
                );
            }
        }
    }
    return null;
}
public static boolean updateClient(Connection connection,Integer id, String updatedName, String updatedSurname, int updatedPhone, String updatedEmail, String updatedAddress, int updatedLicenseNum) throws SQLException {
    String query = "UPDATE clients SET nom = ?, prenom = ?, numTel = ?, adrsMail = ?, adrs = ?, numPermis = ? WHERE idClient=?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, updatedName);
        preparedStatement.setString(2, updatedSurname);
        preparedStatement.setInt(3, updatedPhone);
        preparedStatement.setString(4, updatedEmail);
        preparedStatement.setString(5, updatedAddress);
        preparedStatement.setInt(6, updatedLicenseNum);
        preparedStatement.setInt(7, id);
        int rowsUpdated = preparedStatement.executeUpdate();
        return rowsUpdated > 0;
    }
}
public static int getClientCount(Connection connection) throws SQLException {
    String query = "SELECT COUNT(*) AS count FROM clients";
    try (PreparedStatement preparedStatement = connection.prepareStatement(query);
         ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
            return resultSet.getInt("count");
        }
    }
    return 0;
}  
}

