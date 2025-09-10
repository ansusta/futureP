package interfaces;
import javaapplication49.controllers.Location;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.util.List;
import javaapplication49.DataBaseConnection;
import javaapplication49.models.ModelLocation;
import javax.swing.ButtonGroup;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
public class InterfaceLocation extends javax.swing.JFrame {
    private Location controller;
    public InterfaceLocation() {
        initComponents();
         Connection connection = DataBaseConnection.getConnection();
        controller = new Location(this, connection);
         controller.listLocations();
         ButtonGroup statusGroup = new ButtonGroup();
statusGroup.add(DONE);
statusGroup.add(UNDONE);
statusGroup.add(CANCELLED);         
          tableLocations.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedRow = tableLocations.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) tableLocations.getModel();
            jTextField1.setText(model.getValueAt(selectedRow, 1).toString());
            jTextField2.setText(model.getValueAt(selectedRow, 2).toString());
            t1.setText(model.getValueAt(selectedRow, 3).toString());
            t2.setText(model.getValueAt(selectedRow, 4).toString());
            t3.setText(model.getValueAt(selectedRow, 5).toString());
            String status = model.getValueAt(selectedRow, 6).toString();
            if ("terminer".equalsIgnoreCase(status)) {
                DONE.setSelected(true);
            } else if ("encours".equalsIgnoreCase(status)) {
                UNDONE.setSelected(true);
            }else if ("annuler".equalsIgnoreCase(status)) {
                CANCELLED.setSelected(true);}
        }
    }});
    }

   
    @SuppressWarnings("unchecked")
     public void showMessage(String message) {
        javax.swing.JOptionPane.showMessageDialog(null, message);
    }
       public void displayLocations(List<ModelLocation> employees) {
        DefaultTableModel model = (DefaultTableModel) tableLocations.getModel();
        model.setRowCount(0); 
        for (ModelLocation employee : employees) {
            model.addRow(new Object[]{
                employee.getId(),
                employee.getClient(),
                employee.getVehicule(),
                employee.getDateDebut(),
                employee.getDateFin(),
                employee.getPrixTotal(),
                employee.getStatus(),
            });
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        t3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        b1 = new javax.swing.JButton();
        CANCELLED = new javax.swing.JRadioButton();
        UNDONE = new javax.swing.JRadioButton();
        DONE = new javax.swing.JRadioButton();
        t1 = new javax.swing.JTextField();
        t2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLocations = new javax.swing.JTable();
        tableLocations.getTableHeader().setFont(new java.awt.Font("Times New Roman",java.awt.Font.PLAIN,18));
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        searchTextField = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(1920, 1080));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 255));
        jLabel1.setText("location");

        t3.setBackground(new java.awt.Color(153, 153, 255));
        t3.setText("                                       ");
        t3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 255));
        jLabel2.setText("date debut");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 255));
        jLabel3.setText("date fin");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 255));
        jLabel4.setText("cout total");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 255));
        jLabel5.setText("statut");

        b1.setBackground(new java.awt.Color(153, 153, 255));
        b1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        b1.setText("ajouter");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        CANCELLED.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        CANCELLED.setForeground(new java.awt.Color(153, 153, 255));
        CANCELLED.setText("annuler");

        UNDONE.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        UNDONE.setForeground(new java.awt.Color(153, 153, 255));
        UNDONE.setText("on cours");

        DONE.setForeground(new java.awt.Color(153, 153, 255));
        DONE.setText("terminee");
        DONE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DONEActionPerformed(evt);
            }
        });

        t1.setBackground(new java.awt.Color(153, 153, 255));
        t1.setText("                                       ");
        t1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t1ActionPerformed(evt);
            }
        });

        t2.setBackground(new java.awt.Color(153, 153, 255));
        t2.setText("                                       ");
        t2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(153, 153, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setText("reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 153, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton2.setText("return");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tableLocations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "client", "vehicule", "date debut", "dateFin", "cout total", "status"
            }
        ));
        jScrollPane1.setViewportView(tableLocations);

        jTextField1.setBackground(new java.awt.Color(153, 153, 255));
        jTextField1.setText("                                       ");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setBackground(new java.awt.Color(153, 153, 255));
        jTextField2.setText("                                       ");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 255));
        jLabel6.setText("client");

        jLabel7.setText("jLabel7");

        jLabel8.setText("jLabel8");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 255));
        jLabel9.setText("employee");

        jButton3.setBackground(new java.awt.Color(153, 153, 255));
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton3.setText("update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(153, 153, 255));
        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton4.setText("delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(153, 153, 255));
        jButton5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton5.setText("search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        searchTextField.setText("                           ");
        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(633, 633, 633)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(CANCELLED)
                                .addGap(30, 30, 30)
                                .addComponent(UNDONE))
                            .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(DONE)
                        .addGap(745, 745, 745))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(319, 319, 319))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(b1)
                        .addGap(87, 87, 87)
                        .addComponent(jButton4)
                        .addGap(806, 806, 806))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(jButton1)
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(962, 962, 962)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jButton5)
                            .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                        .addGap(42, 42, 42)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(CANCELLED)
                                            .addComponent(UNDONE)
                                            .addComponent(DONE))
                                        .addGap(49, 49, 49)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jButton3)
                                            .addComponent(jButton1))
                                        .addGap(36, 36, 36)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(b1)
                                            .addComponent(jButton4))
                                        .addGap(110, 110, 110))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)))
                                .addComponent(jButton2)
                                .addGap(0, 403, Short.MAX_VALUE)))))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DONEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DONEActionPerformed
     
    }//GEN-LAST:event_DONEActionPerformed

    private void t1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t1ActionPerformed
       
    }//GEN-LAST:event_t1ActionPerformed

    private void t3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t3ActionPerformed
       
    }//GEN-LAST:event_t3ActionPerformed

    private void t2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t2ActionPerformed
       
    }//GEN-LAST:event_t2ActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
 String c = jTextField1.getText().trim();
    String v = jTextField2.getText().trim(); 
    String dd = t1.getText().trim();
    String df = t2.getText().trim();
    String ct = t3.getText().trim();
    String status;

    if (DONE.isSelected()) {
        status = "terminer";
    } else if (CANCELLED.isSelected()) {
        status = "annuler";
    } else {
        status = "encours";
    }

    if (c.isEmpty() || v.isEmpty() || dd.isEmpty() || df.isEmpty() || ct.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill all fields.");
        return;
    }

    try {
        int idC = Integer.parseInt(c);
        int idV = Integer.parseInt(v);
        int dateD=Integer.parseInt(dd);
        int dateF=Integer.parseInt(df);
        double coutT = Double.parseDouble(ct);

 /*
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dd = dd.length() == 8 ? dd.substring(0, 2) + "/" + dd.substring(2, 4) + "/" + dd.substring(4) : dd;
        df = df.length() == 8 ? df.substring(0, 2) + "/" + df.substring(2, 4) + "/" + df.substring(4) : df;

        // Convert String to LocalDate
        LocalDate startDate = LocalDate.parse(dd, formatter);
        LocalDate endDate = LocalDate.parse(df, formatter);

        // Validate Date Order
        if (startDate.isAfter(endDate)) {
            JOptionPane.showMessageDialog(this, "Starting date cannot be after the end date.");
            return;
        }

        // Convert LocalDate to java.sql.Date
        Date dateD = Date.valueOf(startDate);
        Date dateF = Date.valueOf(endDate); */

        // Pass correct data types to ModelLocation
        ModelLocation vehicule = new ModelLocation(idC, idV, dateD, dateF, coutT, status);
        controller.addLocation(vehicule);

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "ID and cost must be numeric.");
    }       
    }//GEN-LAST:event_b1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 Home c=new Home();
        c.setVisible(true);
        this.dispose();          
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         String s=("                                       ");
            jTextField1.setText(s);  
            jTextField2.setText(s);
            t1.setText(s);
            t2.setText(s);
            t3.setText(s);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    int selectedRow = tableLocations.getSelectedRow(); 
if (selectedRow != -1) { 
    try {
        String idString = tableLocations.getValueAt(selectedRow, 0).toString();
        int id = Integer.parseInt(idString);
        int n = Integer.parseInt(jTextField1.getText().trim());
        int s =  Integer.parseInt(jTextField2.getText().trim());
        int e =  Integer.parseInt(t1.getText().trim());
        int adrs =  Integer.parseInt(t2.getText().trim());
        Double numT = Double.parseDouble(t3.getText().trim());
         String status;
if (DONE.isSelected()) {
    status = "terminer";
} else if (CANCELLED.isSelected()) {
    status = "annuler";
} else {
    status = "encours";
       
    }  controller.updateLocation(id,n, s, e, adrs,numT, status); }catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Invalid input. Please check the data.");
    }
} else {
    JOptionPane.showMessageDialog(null, "Please select a reservation to update.");
} 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
int selectedRow = tableLocations.getSelectedRow(); 
if (selectedRow != -1) {
    try {
        String idString = tableLocations.getValueAt(selectedRow, 0).toString();
        int id = Integer.parseInt(idString);

        controller.deleteLocation(id);
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Invalid ID format. Please check the data.");
    }
} else {
    JOptionPane.showMessageDialog(null, "Please select a reservation to delete.");
}       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
      
    }//GEN-LAST:event_searchTextFieldActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
String searchTerm = searchTextField.getText().trim();
if (searchTerm.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Please enter a search term.");
    return;
}
String[] parts = searchTerm.split("\\s+");
if (parts.length == 2) {
    int num1, num2;
try {
    num1 = Integer.parseInt(parts[0].trim());
    num2 = Integer.parseInt(parts[1].trim());
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Please enter valid numbers.");
    return;
}
    ModelLocation client = controller.searchLocation(num1,num2); 
    if (client != null) {
        jTextField1.setText(String.valueOf(client.getClient()));
        jTextField2.setText(String.valueOf(client.getVehicule()));
        t1.setText(String.valueOf(client.getDateDebut()));
        t2.setText(String.valueOf(client.getDateFin()));
        t3.setText(String.valueOf(client.getPrixTotal()));
       
    } else {
        JOptionPane.showMessageDialog(this, "location not found.");
    }
  
}else if(parts.length==1){
     ModelLocation client = controller.searchLocation(Integer.parseInt(searchTerm)); 
    if (client != null) {
        jTextField1.setText(String.valueOf(client.getClient()));
        jTextField2.setText(String.valueOf(client.getVehicule()));
        t1.setText(String.valueOf(client.getDateDebut()));
        t2.setText(String.valueOf(client.getDateFin()));
        t3.setText(String.valueOf(client.getPrixTotal()));
       
    } else {
        JOptionPane.showMessageDialog(this, "location not found.");
    }
    
    
}else{
    JOptionPane.showMessageDialog(this,"invalid search format , try id or client and reservation id");
}        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
       
    }//GEN-LAST:event_jTextField2ActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
       new InterfaceLocation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton CANCELLED;
    private javax.swing.JRadioButton DONE;
    private javax.swing.JRadioButton UNDONE;
    private javax.swing.JButton b1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t3;
    private javax.swing.JTable tableLocations;
    // End of variables declaration//GEN-END:variables
}
