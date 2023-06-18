/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import javax.swing.JOptionPane;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author julia
 */
public class pokoj extends javax.swing.JFrame {

    Connection polaczenie;
    PreparedStatement prepstmt;
    DefaultTableModel deftab;
    /**
     * Creates new form pokoj
     */
    public pokoj() {
        initComponents();
        dbpolacz();
        IDpokoj();
        odswiez_pokoj();
    }

    
    public void dbpolacz()
    {
        try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	polaczenie = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hotel", "user", "user");			
        } catch (Exception e) {
            field_koszt.setText("Wystąpił błąd:"+e.getMessage());
        }
    }
    
public void IDpokoj() {
    try {
        Statement skladnia = polaczenie.createStatement();
        ResultSet rezultat = skladnia.executeQuery("SELECT MAX(id_pokoj) FROM pokoj");
        rezultat.next();
        String maxId = rezultat.getString("MAX(id_pokoj)");

        if (maxId == null) {
            boldtext_nrpokoju.setText("0001");
        } else {
            long id = Long.parseLong(maxId);
            id++;
            boldtext_nrpokoju.setText(String.format("%04d", id));
        }
    } catch (SQLException ex) {
        Logger.getLogger(pokoj.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
    public void odswiez_pokoj()
    {
        
        int zmienna;
        
        try {
            prepstmt = polaczenie.prepareStatement("select * from pokoj");
            ResultSet rs = prepstmt.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            zmienna = rsd.getColumnCount();
            
            deftab = (DefaultTableModel)tab_pokoje.getModel();
            deftab.setRowCount(0);
            
            while(rs.next())
            {
                Vector v2 = new Vector();
                
                for(int i =1; i<=zmienna; i++)
                {
                    v2.add(rs.getString("id_pokoj"));
                    v2.add(rs.getString("standard"));
                    v2.add(rs.getString("liczba_osob"));
                    v2.add(rs.getString("typ_lozka"));
                    v2.add(rs.getString("koszt"));
                    
                }              
                deftab.addRow(v2);               
            }          
        } catch (SQLException ex) {
            Logger.getLogger(pokoj.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        text_nrpokoju = new javax.swing.JLabel();
        text_standard = new javax.swing.JLabel();
        text_koszt = new javax.swing.JLabel();
        boldtext_nrpokoju = new javax.swing.JLabel();
        text_liczbaosob = new javax.swing.JLabel();
        button_zapisz = new javax.swing.JButton();
        button_edytuj = new javax.swing.JButton();
        button_usun = new javax.swing.JButton();
        lista_standard = new javax.swing.JComboBox<>();
        lista_liczbaosob = new javax.swing.JComboBox<>();
        lista_typlozka = new javax.swing.JComboBox<>();
        text_typlozka = new javax.swing.JLabel();
        field_koszt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tab_pokoje = new javax.swing.JTable();

        jLabel1.setText("jLabel1");

        jButton1.setText("jButton1");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        text_nrpokoju.setText("Numer pokoju");

        text_standard.setText("Standard");

        text_koszt.setText("Koszt");

        boldtext_nrpokoju.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        boldtext_nrpokoju.setText("nrpokoju");

        text_liczbaosob.setText("Liczba osób");

        button_zapisz.setText("Zapisz");
        button_zapisz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_zapiszActionPerformed(evt);
            }
        });

        button_edytuj.setText("Edytuj");
        button_edytuj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_edytujActionPerformed(evt);
            }
        });

        button_usun.setText("Usuń");
        button_usun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_usunActionPerformed(evt);
            }
        });

        lista_standard.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pokój standardowy", "pokój ekonomiczny", "pokój superior ", "pokój deluxe ", "pokój premier", "pokój executive" }));

        lista_liczbaosob.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        lista_typlozka.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1x pojedyncze", "1x podwójne", "2x pojedyncze", "2x podwójne" }));

        text_typlozka.setText("Typ łóżka");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(button_zapisz)
                .addGap(18, 18, 18)
                .addComponent(button_edytuj)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button_usun)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(text_koszt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(text_typlozka, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(text_liczbaosob, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(text_standard, javax.swing.GroupLayout.Alignment.LEADING))
                        .addComponent(text_nrpokoju, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lista_liczbaosob, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(boldtext_nrpokoju, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lista_standard, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lista_typlozka, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(field_koszt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(67, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_nrpokoju)
                    .addComponent(boldtext_nrpokoju))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_standard)
                    .addComponent(lista_standard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_liczbaosob)
                    .addComponent(lista_liczbaosob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(text_typlozka)
                    .addComponent(lista_typlozka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_koszt)
                    .addComponent(field_koszt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_edytuj)
                    .addComponent(button_usun)
                    .addComponent(button_zapisz))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        jLabel2.setText("Pokoje hotelowe");

        tab_pokoje.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Numer pokoju", "Standard", "Liczba osób", "Typ łóżka", "Koszt"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tab_pokoje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_pokojeMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tab_pokoje);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(203, 203, 203))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(26, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(188, 188, 188))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_zapiszActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_zapiszActionPerformed
        String numerpokoju = boldtext_nrpokoju.getText();
        String standard = lista_standard.getSelectedItem().toString();
        String liczbaosob = lista_liczbaosob.getSelectedItem().toString();
	String lozko = lista_typlozka.getSelectedItem().toString();
        String koszt = field_koszt.getText();
        
         try {
            prepstmt = polaczenie.prepareStatement("insert into pokoj(id_pokoj,standard,liczba_osob,typ_lozka,koszt) values(?,?,?,?,?)");
            prepstmt.setString(1, numerpokoju);
            prepstmt.setString(2, standard);
            prepstmt.setString(3, liczbaosob);
            prepstmt.setString(4, lozko);
	    prepstmt.setString(5, koszt);
            prepstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Pokój dodany ");
            
            lista_standard.setSelectedIndex(-1);
            lista_liczbaosob.setSelectedIndex(-1);
	    lista_typlozka.setSelectedIndex(-1);
            field_koszt.setText("");
            IDpokoj();
            odswiez_pokoj();
            
        } catch (SQLException ex) {
            Logger.getLogger(pokoj.class.getName()).log(Level.SEVERE, null, ex);
        }       
        
    }//GEN-LAST:event_button_zapiszActionPerformed

    private void button_edytujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_edytujActionPerformed
        // TODO add your handling code here:
    String numerpokoju = boldtext_nrpokoju.getText();
    String standard = lista_standard.getSelectedItem().toString();
    String liczbaosob = lista_liczbaosob.getSelectedItem().toString();
    String lozko = lista_typlozka.getSelectedItem().toString();
    String koszt = field_koszt.getText();
        
         try {
            prepstmt = polaczenie.prepareStatement("update pokoj set standard = ?, liczba_osob = ?, typ_lozka = ?, koszt = ? where id_pokoj = ?");
            prepstmt.setString(1, standard);
            prepstmt.setString(2, liczbaosob);
            prepstmt.setString(3, lozko);
            prepstmt.setString(4, koszt);
            prepstmt.setString(5, numerpokoju);
            prepstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Pokój edytowany ");
            
            lista_standard.setSelectedIndex(-1);
            lista_liczbaosob.setSelectedIndex(-1);
	    lista_typlozka.setSelectedIndex(-1);
            field_koszt.setText("");
            IDpokoj();
            odswiez_pokoj();
			
	    button_zapisz.setEnabled(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(pokoj.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
    }//GEN-LAST:event_button_edytujActionPerformed

    private void tab_pokojeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_pokojeMouseClicked
        deftab = (DefaultTableModel)tab_pokoje.getModel();
        int selectIndex = tab_pokoje.getSelectedRow();
        
        boldtext_nrpokoju.setText(deftab.getValueAt(selectIndex, 0).toString());
        lista_standard.setSelectedItem(deftab.getValueAt(selectIndex, 1).toString());
        lista_liczbaosob.setSelectedItem(deftab.getValueAt(selectIndex, 2).toString());
	lista_typlozka.setSelectedItem(deftab.getValueAt(selectIndex, 3).toString());
        field_koszt.setText(deftab.getValueAt(selectIndex, 4).toString());
        
        button_zapisz.setEnabled(false);
    }//GEN-LAST:event_tab_pokojeMouseClicked

    private void button_usunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_usunActionPerformed
            String numerpokoju = boldtext_nrpokoju.getText();
      
        
        try {
            prepstmt = polaczenie.prepareStatement("delete from pokoj where id_pokoj = ?");
            prepstmt.setString(1, numerpokoju);
            prepstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Pokój usunięty");
            
            lista_standard.setSelectedIndex(-1);
            lista_liczbaosob.setSelectedIndex(-1);
            lista_typlozka.setSelectedIndex(-1);
            field_koszt.setText("");
            IDpokoj();
            odswiez_pokoj();
            button_zapisz.setEnabled(true);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(pokoj.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button_usunActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(pokoj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pokoj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pokoj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pokoj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pokoj().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel boldtext_nrpokoju;
    private javax.swing.JButton button_edytuj;
    private javax.swing.JButton button_usun;
    private javax.swing.JButton button_zapisz;
    private javax.swing.JTextField field_koszt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JComboBox<String> lista_liczbaosob;
    private javax.swing.JComboBox<String> lista_standard;
    private javax.swing.JComboBox<String> lista_typlozka;
    private javax.swing.JTable tab_pokoje;
    private javax.swing.JLabel text_koszt;
    private javax.swing.JLabel text_liczbaosob;
    private javax.swing.JLabel text_nrpokoju;
    private javax.swing.JLabel text_standard;
    private javax.swing.JLabel text_typlozka;
    // End of variables declaration//GEN-END:variables
}