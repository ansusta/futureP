package interfaces;
import javax.swing.JOptionPane;
import javaapplication49.controllers.*;
import java.util.List;
import java.sql.Connection;
import javaapplication49.DataBaseConnection;  
import javaapplication49.models.ModelClient;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
public class InterfaceClient extends javax.swing.JFrame {
private Client controller;
    public InterfaceClient() {
        initComponents();
         Connection connection = DataBaseConnection.getConnection(); 
    controller = new Client(this, connection);
    controller.listClients();
    tableClients.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedRow = tableClients.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) tableClients.getModel();
            textFieldName.setText(model.getValueAt(selectedRow, 1).toString());
            textFieldSurname.setText(model.getValueAt(selectedRow, 2).toString());
             textFieldPhone.setText(model.getValueAt(selectedRow, 3).toString());
            textFieldEmail.setText(model.getValueAt(selectedRow, 4).toString());
             textFieldLicence.setText(model.getValueAt(selectedRow, 5).toString());
            textFieldAddress.setText(model.getValueAt(selectedRow, 6).toString());
        }
    }
});    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        textFieldSurname = new javax.swing.JTextField();
        textFieldEmail = new javax.swing.JTextField();
        textFieldAddress = new javax.swing.JTextField();
        textFieldLicence = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        textFieldName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textFieldPhone = new javax.swing.JTextField();
        Update = new javax.swing.JButton();
        searchTextField = new javax.swing.JTextField();
        returnButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableClients = new javax.swing.JTable();
        tableClients.getTableHeader().setFont(new java.awt.Font("Times New Roman",java.awt.Font.PLAIN,18));
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 1080));

        textFieldSurname.setBackground(new java.awt.Color(153, 153, 255));
        textFieldSurname.setText("                                       ");
        textFieldSurname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldSurnameActionPerformed(evt);
            }
        });

        textFieldEmail.setBackground(new java.awt.Color(153, 153, 255));
        textFieldEmail.setText("                                       ");
        textFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldEmailActionPerformed(evt);
            }
        });

        textFieldAddress.setBackground(new java.awt.Color(153, 153, 255));
        textFieldAddress.setText("                                       ");

        textFieldLicence.setBackground(new java.awt.Color(153, 153, 255));
        textFieldLicence.setText("                                       ");

        btnAdd.setBackground(new java.awt.Color(153, 153, 255));
        btnAdd.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnAdd.setText("ajouter");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\thile\\Downloads\\NEYTTTTTT.png")); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 255));
        jLabel1.setText("CLIENT");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 255));
        jLabel2.setText("nom");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 255));
        jLabel3.setText("prenom");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 255));
        jLabel4.setText("adresse mail");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 255));
        jLabel5.setText("numero de telephone");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 255));
        jLabel6.setText("numero de permis");

        btnDelete.setBackground(new java.awt.Color(153, 153, 255));
        btnDelete.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnDelete.setText("reset");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(153, 153, 255));
        btnSearch.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSearch.setText("chercher");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        textFieldName.setBackground(new java.awt.Color(153, 153, 255));
        textFieldName.setText("                                       ");
        textFieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNameActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(153, 153, 255));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 255));
        jLabel7.setText("adresse");

        textFieldPhone.setBackground(new java.awt.Color(153, 153, 255));
        textFieldPhone.setText("                                       ");
        textFieldPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPhoneActionPerformed(evt);
            }
        });

        Update.setBackground(new java.awt.Color(153, 153, 255));
        Update.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Update.setText("modifier");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        searchTextField.setText("                                   ");
        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });

        returnButton.setBackground(new java.awt.Color(153, 153, 255));
        returnButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        returnButton.setText("return");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        tableClients.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tableClients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "nom", "prenom", "numtel", "adrsMail", "licence", "adrs"
            }
        ));
        jScrollPane1.setViewportView(tableClients);

        jButton1.setBackground(new java.awt.Color(153, 153, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setText("delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(106, 106, 106)
                            .addComponent(btnSearch)
                            .addGap(57, 57, 57)
                            .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(205, 205, 205)
                            .addComponent(jLabel1)
                            .addGap(465, 465, 465)
                            .addComponent(jLabel8))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(707, 707, 707)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(60, 60, 60)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textFieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldLicence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAdd)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(170, 170, 170)
                                        .addComponent(Update)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(77, 77, 77)
                                .addComponent(btnDelete))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(943, 943, 943)
                        .addComponent(returnButton)))
                .addContainerGap(1243, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(btnSearch)
                            .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel8)
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(textFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textFieldSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(textFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldLicence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(textFieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(Update)
                            .addComponent(jButton1)
                            .addComponent(btnDelete))))
                .addGap(51, 51, 51)
                .addComponent(returnButton)
                .addContainerGap(433, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 2510, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void showMessage(String message) {
        javax.swing.JOptionPane.showMessageDialog(null, message);
    }
      public void displayVehicules(List<ModelClient> clients) {
        DefaultTableModel model = (DefaultTableModel) tableClients.getModel();
        model.setRowCount(0); 
        for (ModelClient client : clients) {  
            model.addRow(new Object[]{
                client.getId(),
                client.getNom(),
                client.getPrenom(),
                client.getNumTel(),
                client.getAdrsMail(),
                client.getNumPermis(),
                client.getAdrs()
            });
        }
    }

    private void textFieldNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNameActionPerformed
    
    }//GEN-LAST:event_textFieldNameActionPerformed

    private void textFieldSurnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldSurnameActionPerformed
        
    }//GEN-LAST:event_textFieldSurnameActionPerformed

    private void textFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldEmailActionPerformed
        
    }//GEN-LAST:event_textFieldEmailActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
     String nom = textFieldName.getText().trim();
    String prenom = textFieldSurname.getText().trim();
    String numTel = textFieldPhone.getText().trim();
    String adrsMail = textFieldEmail.getText().trim();
    String adrs = textFieldAddress.getText().trim();
    String numPermis = textFieldLicence.getText().trim();
    if (nom.isEmpty() || prenom.isEmpty() || numTel.isEmpty() || adrsMail.isEmpty() || adrs.isEmpty() || numPermis.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill all fields.");
        return;
    }
    try {
        int phone = Integer.parseInt(numTel);
        int license = Integer.parseInt(numPermis);
        ModelClient client = new ModelClient(nom, prenom, phone, adrsMail, license, adrs);
        controller.addClient(client);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Phone number and license number must be numeric AND under 10 degits");
    }
    }//GEN-LAST:event_btnAddActionPerformed

    private void textFieldPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPhoneActionPerformed
     
    }//GEN-LAST:event_textFieldPhoneActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
         String s=("                                       ");
            textFieldName.setText(s);  
            textFieldSurname.setText(s);
            textFieldEmail.setText(s);
            textFieldPhone.setText(s);
            textFieldAddress.setText(s);
            textFieldLicence.setText(s);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
     String searchTerm = searchTextField.getText().trim();
    if (searchTerm.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a search term.");
        return;
    }
    String[] names = searchTerm.split("\\s+"); 
    if (names.length == 2) {
      
    String firstName = names[0].trim();
    String lastName = names[1].trim();
      ModelClient client = controller.searchClient(firstName, lastName); 
       if (client != null) {
        textFieldName.setText(client.getNom());
        textFieldSurname.setText(client.getPrenom());
        textFieldPhone.setText(String.valueOf(client.getNumTel()));
        textFieldEmail.setText(client.getAdrsMail());
        textFieldAddress.setText(client.getAdrs());
        textFieldLicence.setText(String.valueOf(client.getNumPermis()));
    } else {
        JOptionPane.showMessageDialog(this, "No client found.");
    }
    }else{
         ModelClient client = controller.searchClient(Integer.parseInt(searchTerm)); 
          if (client != null) {
        textFieldName.setText(client.getNom());
        textFieldSurname.setText(client.getPrenom());
        textFieldPhone.setText(String.valueOf(client.getNumTel()));
        textFieldEmail.setText(client.getAdrsMail());
        textFieldAddress.setText(client.getAdrs());
        textFieldLicence.setText(String.valueOf(client.getNumPermis()));
    } else {
        JOptionPane.showMessageDialog(this, "No client found.");
    }
    }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
int selectedRow = tableClients.getSelectedRow(); 

if (selectedRow != -1) { 
    try {
        String idString = tableClients.getValueAt(selectedRow, 0).toString();
        int id = Integer.parseInt(idString);
        String n = textFieldName.getText().trim();
        String s = textFieldSurname.getText().trim();
        String e = textFieldEmail.getText().trim();
        int numT = Integer.parseInt(textFieldPhone.getText().trim());
        String adrs = textFieldAddress.getText().trim();
        int P = Integer.parseInt(textFieldLicence.getText().trim());
        controller.updateClient(id,n, s, numT,e, adrs, P); 
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Invalid input. Please check the data.");
    }
} else {
    JOptionPane.showMessageDialog(null, "Please select a client to update.");
}
    }//GEN-LAST:event_UpdateActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
 Home c=new Home();
        c.setVisible(true);
        this.dispose();        
    }//GEN-LAST:event_returnButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      int selectedRow = tableClients.getSelectedRow(); 
if (selectedRow != -1) {
    try {
        String idString = tableClients.getValueAt(selectedRow, 0).toString();
        int id = Integer.parseInt(idString);

        controller.deleteClient(id);

        JOptionPane.showMessageDialog(null, "Client deleted successfully.");
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Invalid ID format. Please check the data.");
    }
} else {
    JOptionPane.showMessageDialog(null, "Please select a client to delete.");
}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
       
    }//GEN-LAST:event_searchTextFieldActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceClient().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Update;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton returnButton;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTable tableClients;
    private javax.swing.JTextField textFieldAddress;
    private javax.swing.JTextField textFieldEmail;
    private javax.swing.JTextField textFieldLicence;
    private javax.swing.JTextField textFieldName;
    private javax.swing.JTextField textFieldPhone;
    private javax.swing.JTextField textFieldSurname;
    // End of variables declaration//GEN-END:variables
 }
