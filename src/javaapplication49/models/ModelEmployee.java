package javaapplication49.models;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModelEmployee {
    private Integer id;
    private String nom;
    private String prenom;
    private String role;
    private String adrs;
    private Double salaire;
    private int numTel;
    private String adrsMail;
    public ModelEmployee(String nom, String prenom, String role, Double salaire, String adrs, String adrsMail, int numTel) {
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.adrs = adrs;
        this.salaire = salaire;
        this.numTel = numTel;
        this.adrsMail = adrsMail;
    }
      public ModelEmployee(Integer id,String nom, String prenom, String role, Double salaire, String adrs, String adrsMail, int numTel) {
        this.id=id;
          this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.adrs = adrs;
        this.salaire = salaire;
        this.numTel = numTel;
        this.adrsMail = adrsMail;
    }
    public Integer getId(){
    return id;
}
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getRole() {
        return role;
    }
    public String getAdrs() {
        return adrs;
    }
    public Double getSalaire() {
        return salaire;
    }
    public int getNumTel() {
        return numTel;
    }
    public String getAdrsMail() {
        return adrsMail;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public void setAdrs(String adrs) {
        this.adrs = adrs;
    }
    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }
    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }
    public void setAdrsMail(String adrsMail) {
        this.adrsMail = adrsMail;
    }
    
         public static void addEmployee(Connection connection, ModelEmployee client) throws SQLException {
        String sql = "INSERT INTO employee (nom, prenom, numTel, adrsMail, salaire, adrs,role) VALUES (?, ?, ?, ?, ?, ?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, client.nom);
            stmt.setString(2, client.prenom);
            stmt.setInt(3, client.numTel);
            stmt.setString(4, client.adrsMail);
            stmt.setDouble(5, client.salaire);
            stmt.setString(6, client.adrs);
            stmt.setString(7, client.role);
            stmt.executeUpdate();
        }
    }
         
            public static List<ModelEmployee> getAllEmployees(Connection connection) throws SQLException {
    String sql = "SELECT * FROM employee";
    List<ModelEmployee> employees = new ArrayList<>();
    try (PreparedStatement stmt = connection.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
             employees.add(new ModelEmployee(
                     rs.getInt("idEmployee"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("role"),
                    rs.getDouble("salaire"), 
                     rs.getString("adrs"),
                     rs.getString("adrsMail"), rs.getInt("numTel")
            ));
             
        }
    }
    return employees;
}
            
            
    public static boolean updateEmployee(Connection connection,Integer id , String n , String p, String nom, String prenom, String role, String address, Double salaire, int numTel, String adrsMail) throws SQLException {
    String query = "UPDATE Employee SET nom = ?, prenom= ?, role = ?, adrs = ?, salaire = ?,numTel = ?, adrsMail = ? WHERE idEmployee=?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setString(1, nom);
        stmt.setString(2, prenom);
        stmt.setString(3, role);
        stmt.setString(4, address);
        stmt.setDouble(5, salaire);
        stmt.setInt(6, numTel);
        stmt.setString(7, adrsMail);
        stmt.setInt(8, id);
       
        int rowsUpdated = stmt.executeUpdate();
        return rowsUpdated > 0;
    }
}
            
               public static void deleteEmployee(Connection connection, Integer id) throws SQLException {
        String sql = "DELETE FROM Employee WHERE idEmployee=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1,id);
            stmt.executeUpdate();
        }
    }
               
                   public static ModelEmployee searchEmployee(Connection connection, String firstName, String lastName) throws SQLException {
    String query = "SELECT * FROM Employee WHERE nom = ? AND prenom = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return new ModelEmployee(
                    resultSet.getString("nom"),         
                    resultSet.getString("prenom"),
                    resultSet.getString("role"),
                         resultSet.getDouble("salaire"),  
                          resultSet.getString("adrs") ,
                                            resultSet.getString("adrsMail")    ,

                    resultSet.getInt("numTel")        
   
    
                      
                );
            }
        }
    }
    return null;
}
                   
                      public static ModelEmployee searchEmployee(Connection connection, Integer id) throws SQLException {
    String query = "SELECT * FROM Employee WHERE idEmployee=?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setInt(1, id);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return new ModelEmployee(
                    resultSet.getString("nom"),         
                    resultSet.getString("prenom"),
                    resultSet.getString("role"),
                         resultSet.getDouble("salaire"),  
                          resultSet.getString("adrs") ,
                                            resultSet.getString("adrsMail")    ,

                    resultSet.getInt("numTel")        
   
    
                      
                );
            }
        }
    }
    return null;
}
                   
                   
    
    
    
}
