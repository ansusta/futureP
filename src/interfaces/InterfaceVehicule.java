package interfaces;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javaapplication49.controllers.*;
import java.util.List;
import java.sql.Connection;
import javaapplication49.DataBaseConnection;
import javaapplication49.models.ModelVehicule;
import javax.swing.ButtonGroup;
public class InterfaceVehicule extends javax.swing.JFrame {
    private Vehicule controller;
    private boolean showingAvailableCars=false;
    public InterfaceVehicule() {
        initComponents();
        ButtonGroup statusGroup = new ButtonGroup();
statusGroup.add(radioAvailable);
statusGroup.add(radioUnavailable);
        Connection connection = DataBaseConnection.getConnection();
        controller = new Vehicule(this, connection);
         controller.listVehicules();
tableVehicules.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedRow = tableVehicules.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) tableVehicules.getModel();
            textFieldMarque.setText(model.getValueAt(selectedRow, 1).toString());
            textFieldModele.setText(model.getValueAt(selectedRow, 2).toString());
            textFieldAnne.setText(model.getValueAt(selectedRow, 3).toString());
            textFieldPlaque.setText(model.getValueAt(selectedRow, 4).toString());
            textFieldColor.setText(model.getValueAt(selectedRow, 6).toString());
            textFieldType.setText(model.getValueAt(selectedRow, 5).toString());
            String status = model.getValueAt(selectedRow, 7).toString();
            if ("Available".equalsIgnoreCase(status)) {
                radioAvailable.setSelected(true);
            } else if ("Unavailable".equalsIgnoreCase(status)) {
                radioUnavailable.setSelected(true);
            }
        }
    }
});       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        buttonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        radioAvailable = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        radioUnavailable = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textFieldMarque = new javax.swing.JTextField();
        textFieldModele = new javax.swing.JTextField();
        textFieldAnne = new javax.swing.JTextField();
        textFieldType = new javax.swing.JTextField();
        t = new javax.swing.JLabel();
        textFieldPlaque = new javax.swing.JTextField();
        t1 = new javax.swing.JLabel();
        textFieldColor = new javax.swing.JTextField();
        t2 = new javax.swing.JLabel();
        recherche = new javax.swing.JButton();
        TextFieldRecherche = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVehicules = new javax.swing.JTable();
        tableVehicules.getTableHeader().setFont(new java.awt.Font("Times New Roman",java.awt.Font.PLAIN,18));
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 1080));

        radioAvailable.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        radioAvailable.setForeground(new java.awt.Color(153, 153, 255));
        radioAvailable.setText("diponible");

        jLabel1.setBackground(new java.awt.Color(153, 153, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 255));
        jLabel1.setText("VEHICULES");

        radioUnavailable.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        radioUnavailable.setForeground(new java.awt.Color(153, 153, 255));
        radioUnavailable.setText("non-disponible");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 255));
        jLabel2.setText("marque");

        btnAdd.setBackground(new java.awt.Color(153, 153, 255));
        btnAdd.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnAdd.setText("ajouter");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 255));
        jLabel3.setText("modele");

        jButton2.setBackground(new java.awt.Color(153, 153, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton2.setText("reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 255));
        jLabel4.setText("annee");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 255));
        jLabel6.setText("statut");

        textFieldMarque.setBackground(new java.awt.Color(153, 153, 255));
        textFieldMarque.setText("                                       ");
        textFieldMarque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldMarqueActionPerformed(evt);
            }
        });

        textFieldModele.setBackground(new java.awt.Color(153, 153, 255));
        textFieldModele.setText("                                       ");
        textFieldModele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldModeleActionPerformed(evt);
            }
        });

        textFieldAnne.setBackground(new java.awt.Color(153, 153, 255));
        textFieldAnne.setText("                                       ");
        textFieldAnne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldAnneActionPerformed(evt);
            }
        });

        textFieldType.setBackground(new java.awt.Color(153, 153, 255));
        textFieldType.setText("                                       ");

        t.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        t.setForeground(new java.awt.Color(153, 153, 255));
        t.setText("plate");

        textFieldPlaque.setBackground(new java.awt.Color(153, 153, 255));
        textFieldPlaque.setText("                                       ");

        t1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        t1.setForeground(new java.awt.Color(153, 153, 255));
        t1.setText("type");

        textFieldColor.setBackground(new java.awt.Color(153, 153, 255));
        textFieldColor.setText("                                       ");

        t2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        t2.setForeground(new java.awt.Color(153, 153, 255));
        t2.setText("couleur");

        recherche.setBackground(new java.awt.Color(153, 153, 255));
        recherche.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        recherche.setText("rechercher");
        recherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechercheActionPerformed(evt);
            }
        });

        TextFieldRecherche.setText("                               ");
        TextFieldRecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldRechercheActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(153, 153, 255));
        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton4.setText("update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        tableVehicules.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "marque", "model", "anne", "plaque", "type", "coleur", "status"
            }
        ));
        jScrollPane1.setViewportView(tableVehicules);

        jButton1.setBackground(new java.awt.Color(153, 153, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setText("return");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(153, 153, 255));
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton3.setText("delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(153, 153, 255));
        jButton5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton5.setText("show disponibles");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(recherche)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(415, 415, 415)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(98, 98, 98)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4)
                                .addGap(98, 98, 98))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(216, 216, 216)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addGap(84, 84, 84)
                                .addComponent(jButton1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(t)
                                    .addComponent(t1)
                                    .addComponent(t2))
                                .addGap(53, 53, 53)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textFieldAnne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldPlaque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldModele, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(52, 52, 52)
                                .addComponent(textFieldMarque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(53, 53, 53)
                                .addComponent(radioAvailable)
                                .addGap(77, 77, 77)
                                .addComponent(radioUnavailable)))
                        .addGap(41, 41, 41)))
                .addComponent(jButton2)
                .addContainerGap(644, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(recherche)
                            .addComponent(TextFieldRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1)
                        .addGap(97, 97, 97)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(textFieldMarque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textFieldModele, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(textFieldAnne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textFieldPlaque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t2))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioAvailable)
                            .addComponent(radioUnavailable)
                            .addComponent(jLabel6))
                        .addGap(108, 108, 108)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(jButton2)
                            .addComponent(jButton4)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jButton1))))
                .addContainerGap(401, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public String getInput(String prompt) {
        return javax.swing.JOptionPane.showInputDialog(prompt);
    }

    public void showMessage(String message) {
        javax.swing.JOptionPane.showMessageDialog(null, message);
    }
     public void displayVehicules(List<ModelVehicule> vehicules) {
        DefaultTableModel model = (DefaultTableModel) tableVehicules.getModel();
        model.setRowCount(0); 
        for (ModelVehicule vehicule : vehicules) {
            model.addRow(new Object[]{
                vehicule.getId(),
                vehicule.getMarque(),
                vehicule.getModel(),
                vehicule.getAnne(),
                vehicule.getLicencePlate(),
                vehicule.getType(),
                vehicule.getColor(),
                vehicule.getStatus()
            });
        }
    } 
    private void textFieldMarqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldMarqueActionPerformed
      
    }//GEN-LAST:event_textFieldMarqueActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
    String marque = textFieldMarque.getText().trim();
    String modele = textFieldModele.getText().trim();
    String type = textFieldType.getText().trim();
    String annee = textFieldAnne.getText().trim();
    String couleur = textFieldColor.getText().trim();
    String P = textFieldPlaque.getText().trim();
     String status = radioAvailable.isSelected() ? "disponible" : "non-disponible";
if (marque.isEmpty() || modele.isEmpty() || type.isEmpty() || annee.isEmpty() || couleur.isEmpty() || P.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill all fields.");
        return;
    }
try{
    int a=Integer.parseInt(annee.trim());
    ModelVehicule vehicule = new ModelVehicule(marque, modele, a, P, status,couleur,type);
    controller.addVehicule(vehicule);
     } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "year must be numeric.");
    }
    }//GEN-LAST:event_btnAddActionPerformed

    private void textFieldModeleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldModeleActionPerformed
 
    }//GEN-LAST:event_textFieldModeleActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          String s=("                                       ");
            textFieldModele.setText(s);  
            textFieldMarque.setText(s);
            textFieldAnne.setText(s);
            textFieldType.setText(s);
            textFieldPlaque.setText(s);
            textFieldColor.setText(s);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void rechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechercheActionPerformed
String searchTerm = TextFieldRecherche.getText().trim();
if (searchTerm.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Please enter a search term.");
    return;
}
String[] terms = searchTerm.split("\\s+"); 
if (terms.length == 2) {
    String brand = terms[0].trim();
String marque = terms[1].trim();

ModelVehicule vehicule = controller.searchVehicule(brand,marque);  
if (vehicule != null) {
    textFieldMarque.setText(vehicule.getMarque());
    textFieldModele.setText(vehicule.getModel());
    textFieldAnne.setText(String.valueOf(vehicule.getAnne()));
    textFieldPlaque.setText(vehicule.getLicencePlate());
    textFieldColor.setText(vehicule.getColor());
    textFieldType.setText(vehicule.getType());
} else {
    JOptionPane.showMessageDialog(this, "No vehicule found.");
} 
}else if(terms.length==1){
    ModelVehicule vehicule = controller.searchVehicule(Integer.parseInt(searchTerm));  
if (vehicule != null) {
    textFieldMarque.setText(vehicule.getMarque());
    textFieldModele.setText(vehicule.getModel());
    textFieldAnne.setText(String.valueOf(vehicule.getAnne()));
    textFieldPlaque.setText(vehicule.getLicencePlate());
    textFieldColor.setText(vehicule.getColor());
    textFieldType.setText(vehicule.getType());
} else {
    JOptionPane.showMessageDialog(this, "No vehicule found.");
}  
}else{
    JOptionPane.showMessageDialog(this,"ivalid search format , please try searching by  id or brand and model");
}
    }//GEN-LAST:event_rechercheActionPerformed

    private void TextFieldRechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldRechercheActionPerformed
     
    }//GEN-LAST:event_TextFieldRechercheActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
int selectedRow = tableVehicules.getSelectedRow();
if (selectedRow != -1) { 
    try {
        String idString = tableVehicules.getValueAt(selectedRow, 0).toString(); 
        int id = Integer.parseInt(idString); 
        String marque = textFieldMarque.getText();
        String model = textFieldModele.getText();
        int anne = Integer.parseInt(textFieldAnne.getText());
        String licencePlate = textFieldPlaque.getText();
        String color = textFieldColor.getText();
        String type = textFieldType.getText();
        String status = radioAvailable.isSelected() ? "disponible" : "non-disponible";
        controller.updateVehicule(id, marque, model, anne, licencePlate, status, color, type);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Invalid ID format. Please check the data.");
    }
} else {
    JOptionPane.showMessageDialog(null, "Please select a row to update.");
}
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 Home c=new Home();
        c.setVisible(true);
        this.dispose();          
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
int selectedRow = tableVehicules.getSelectedRow();
if (selectedRow != -1) {
    try {
        String idString = tableVehicules.getValueAt(selectedRow, 0).toString();
        int id = Integer.parseInt(idString);
        controller.deleteVehicule(id);
        JOptionPane.showMessageDialog(null, "Vehicle deleted successfully.");
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Invalid ID format. Please check the data.");
    }
} else {
    JOptionPane.showMessageDialog(null, "Please select a row to delete.");
}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
if (showingAvailableCars) {
        controller.listVehicules(); 
        showingAvailableCars = false;
        jButton5.setText("Show Available Cars");
    } else {
        controller.listDisponibles();
        showingAvailableCars = true;
        jButton5.setText("Hide Available Cars");
    }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void textFieldAnneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldAnneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldAnneActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceVehicule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextFieldRecherche;
    private javax.swing.JButton btnAdd;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton radioAvailable;
    private javax.swing.JRadioButton radioUnavailable;
    private javax.swing.JButton recherche;
    private javax.swing.JLabel t;
    private javax.swing.JLabel t1;
    private javax.swing.JLabel t2;
    private javax.swing.JTable tableVehicules;
    private javax.swing.JTextField textFieldAnne;
    private javax.swing.JTextField textFieldColor;
    private javax.swing.JTextField textFieldMarque;
    private javax.swing.JTextField textFieldModele;
    private javax.swing.JTextField textFieldPlaque;
    private javax.swing.JTextField textFieldType;
    // End of variables declaration//GEN-END:variables
}
