package javaapplication49.models;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModelPayment {
    private Integer id;
    private int date;
    private Double cout;
    private String type;
    private int contract;

   
    public ModelPayment(int contract, int date, Double cout, String type) {
            this.contract=contract;
        this.date = date;
        this.cout = cout;
        this.type = type;
    
    }
        public ModelPayment(Integer id , int contract, int date, Double cout, String type) {
            this.id=id;
            this.contract=contract;
        this.date = date;
        this.cout = cout;
        this.type = type;
    
    }
     public Integer getId(){
    return id;
}
     public int getContract() {
        return contract;
    }
    public int getDate() {
        return date;
    }

    public Double getCout() {
        return cout;
    }

    public String getType() {
        return type;
    }

    public void setContract(int date) {
        this.contract = date;
    }
    public void setDate(int date) {
        this.date = date;
    }

    public void setCout(Double cout) {
        this.cout = cout;
    }

    public void setType(String type) {
        this.type = type;
    }
      public static void addPayment(Connection connection, ModelPayment client) throws SQLException {
        String sql = "INSERT INTO paiements (idContrat, datePaiement, somme, typePaiement) VALUES (?,?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1,client.contract);
            stmt.setInt(2, client.date);
            stmt.setDouble(3, client.cout);
            stmt.setString(4, client.type);
            stmt.executeUpdate();
        }
    }
       public static List<ModelPayment> getAllPayments(Connection connection) throws SQLException {
        String sql = "SELECT * FROM paiements";
        List<ModelPayment> payments = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                payments.add(new ModelPayment(
                        rs.getInt("idPaiement"),
                        rs.getInt("idContrat"),
                        rs.getInt("datePaiement"),
                        rs.getDouble("somme"),
                        rs.getString("typePaiement")
                      
                ));
            }
        }
        return payments;
    }

    public static boolean updatePayment(Connection connection, double cout, String type,int date,int idC) throws SQLException {
        String sql = "UPDATE paiements SET idContrat=? , somme = ?, typePaiement = ?,datePaiement=? WHERE idContrat = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, idC);
            stmt.setDouble(2, cout);
            stmt.setString(3, type);
            stmt.setInt(4, date);
              stmt.setInt(5, idC);
             int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        }
    }
       public static void deletePayment(Connection connection, int id ) throws SQLException {
        String sql = "DELETE FROM paiements WHERE idContrat = ? ";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1,id);
            stmt.executeUpdate();
        }
    }
       
           public static ModelPayment searchPayment(Connection connection, int firstName) throws SQLException {
    String query = "SELECT * FROM paiements WHERE idPaiement= ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setInt(1, firstName);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return new ModelPayment(
                        resultSet.getInt("idContrat"),
                        resultSet.getInt("datePaiement"),
                        resultSet.getDouble("somme"),
                        resultSet.getString("typePaiement")     
                );
            }
        }
    }
    return null;
}
       
       
    
    
}
   
 
      
      
    

