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
import java.text.SimpleDateFormat;

/**
 *
 * @author julia
 */
public class rezerwacja extends javax.swing.JFrame {

    Connection polaczenie;
    PreparedStatement prepstmt;
    DefaultTableModel deftab;

    
    /**
     * Creates new form rezerwacja
     */
    public rezerwacja() {
        initComponents();
        dbpolacz();
        IDrezerwacja();
        NumerPokoju();
        TypPokoju();
        LiczbaOsob();
        TypLozka();
        OdswiezRezerwacja();
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

    public void IDrezerwacja() {
    try {
        Statement skladnia = polaczenie.createStatement();
        ResultSet rezultat = skladnia.executeQuery("SELECT MAX(id_rezerwacja) FROM rezerwacja");
        rezultat.next();
        String maxId = rezultat.getString("MAX(id_rezerwacja)");

        if (maxId == null) {
            boldtext_nrrezerwacji.setText("0001");
        } else {
            long id = Long.parseLong(maxId);
            id++;
            boldtext_nrrezerwacji.setText(String.format("%04d", id));
        }
    } catch (SQLException ex) {
        Logger.getLogger(rezerwacja.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
    public void NumerPokoju()
    {
        try {
            prepstmt = polaczenie.prepareStatement("select Distinct id_pokoj from pokoj");
            ResultSet rezultat = prepstmt.executeQuery();
            lista_nrpokoju.removeAllItems();
             
             while(rezultat.next())
             {
                 lista_nrpokoju.addItem(rezultat.getString("id_pokoj"));
             }
        } 
            catch (SQLException ex) {
            Logger.getLogger(rezerwacja.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }    
   
    public void TypPokoju()
    {
        try {
            prepstmt = polaczenie.prepareStatement("select Distinct standard from pokoj");
            ResultSet rezultat = prepstmt.executeQuery();
            lista_standard.removeAllItems();
             
             while(rezultat.next())
             {
                 lista_standard.addItem(rezultat.getString("standard"));
             }
        } 
            catch (SQLException ex) {
            Logger.getLogger(rezerwacja.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
     
    public void LiczbaOsob()
    {
        try {
            prepstmt = polaczenie.prepareStatement("select Distinct liczba_osob from pokoj");
            ResultSet rezultat = prepstmt.executeQuery();
            lista_liczbaosob.removeAllItems();
             
             while(rezultat.next())
             {
                 lista_liczbaosob.addItem(rezultat.getString("liczba_osob"));
             }
        } 
            catch (SQLException ex) {
            Logger.getLogger(rezerwacja.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    
    public void TypLozka()
    {
        try {
            prepstmt = polaczenie.prepareStatement("select Distinct typ_lozka from pokoj");
            ResultSet rezultat = prepstmt.executeQuery();
            lista_typlozka.removeAllItems();
             
             while(rezultat.next())
             {
                 lista_typlozka.addItem(rezultat.getString("typ_lozka"));
             }
        } 
            catch (SQLException ex) {
            Logger.getLogger(rezerwacja.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void OdswiezRezerwacja() {
    int zmienna;
    try {
        prepstmt = polaczenie.prepareStatement("select * from rezerwacja");
        ResultSet rs = prepstmt.executeQuery();
        ResultSetMetaData rsd = rs.getMetaData();
        zmienna = rsd.getColumnCount();
        deftab = (DefaultTableModel)tab_rezerwacje.getModel();
        deftab.setRowCount(0);
        while (rs.next()) {
            Vector v2 = new Vector();
            for (int i = 1; i <= zmienna; i++) {
                v2.add(rs.getString("id_rezerwacja"));
                v2.add(rs.getString("imie"));
                v2.add(rs.getString("nazwisko"));
                v2.add(rs.getString("nr_telefonu"));
                v2.add(rs.getString("checkin"));
                v2.add(rs.getString("checkout"));
                v2.add(rs.getString("id_pokoj"));
                v2.add(rs.getString("standard"));
                v2.add(rs.getString("liczba_osob"));
		v2.add(rs.getString("typ_lozka"));
                v2.add(rs.getString("koszt"));
            }
            deftab.addRow(v2);
        }
    } catch (SQLException ex) {
        Logger.getLogger(rezerwacja.class.getName()).log(Level.SEVERE, null, ex);
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
        text_nrrezerwacji = new javax.swing.JLabel();
        text_imie = new javax.swing.JLabel();
        text_nazwisko = new javax.swing.JLabel();
        text_telefon = new javax.swing.JLabel();
        text_start = new javax.swing.JLabel();
        text_koniec = new javax.swing.JLabel();
        text_nrpokoju = new javax.swing.JLabel();
        text_standard = new javax.swing.JLabel();
        text_liczbaosob = new javax.swing.JLabel();
        text_typlozka = new javax.swing.JLabel();
        text_koszt = new javax.swing.JLabel();
        data_start = new com.toedter.calendar.JDateChooser();
        data_koniec = new com.toedter.calendar.JDateChooser();
        field_imie = new javax.swing.JTextField();
        field_nazwisko = new javax.swing.JTextField();
        field_numer = new javax.swing.JTextField();
        lista_nrpokoju = new javax.swing.JComboBox<>();
        lista_standard = new javax.swing.JComboBox<>();
        lista_liczbaosob = new javax.swing.JComboBox<>();
        lista_typlozka = new javax.swing.JComboBox<>();
        field_koszt = new javax.swing.JTextField();
        button_zapisz = new javax.swing.JButton();
        button_edytuj = new javax.swing.JButton();
        button_usun = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_rezerwacje = new javax.swing.JTable();
        boldtext_nrrezerwacji = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("System rezerwacji pokojów hotelowych");

        text_nrrezerwacji.setText("Numer rezerwacji");

        text_imie.setText("Imie");

        text_nazwisko.setText("Nazwisko");

        text_telefon.setText("Numer telefonu");

        text_start.setText("Początek pobytu");

        text_koniec.setText("Koniec pobytu");

        text_nrpokoju.setText("Numer pokoju");

        text_standard.setText("Standard");

        text_liczbaosob.setText("Liczba osób");

        text_typlozka.setText("Typ łóżka");

        text_koszt.setText("Koszt");

        field_imie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_imieActionPerformed(evt);
            }
        });

        lista_typlozka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lista_typlozkaActionPerformed(evt);
            }
        });

        field_koszt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_kosztActionPerformed(evt);
            }
        });

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

        tab_rezerwacje.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nr rezerwacji", "Imie", "Nazwisko", "Nr telefonu", "Początek pobytu", "Koniec pobytu", "Standard", "Nr pokoju", "Liczba osób", "Typ łóżka", "Koszt"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tab_rezerwacje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_rezerwacjeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tab_rezerwacje);

        boldtext_nrrezerwacji.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        boldtext_nrrezerwacji.setText("nrrezerwacji");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(text_nrpokoju)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lista_nrpokoju, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(text_liczbaosob, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lista_liczbaosob, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(text_standard, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lista_standard, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(text_typlozka, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lista_typlozka, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(text_koszt, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(button_zapisz)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(text_imie, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(field_imie, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(text_nazwisko, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(field_nazwisko, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(text_telefon)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(field_numer, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(text_start, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(data_start, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(text_koniec, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_edytuj))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(data_koniec, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(field_koszt, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_usun)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(text_nrrezerwacji)
                        .addGap(18, 18, 18)
                        .addComponent(boldtext_nrrezerwacji, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(344, 344, 344)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_nrrezerwacji)
                    .addComponent(boldtext_nrrezerwacji))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(text_imie)
                                .addComponent(field_imie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(text_nazwisko)
                                .addComponent(field_nazwisko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(text_telefon)
                                .addComponent(field_numer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(text_start))
                            .addComponent(data_start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_nrpokoju)
                            .addComponent(lista_nrpokoju, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_liczbaosob)
                            .addComponent(lista_liczbaosob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_standard)
                            .addComponent(lista_standard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_typlozka)
                            .addComponent(lista_typlozka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(data_koniec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(text_koniec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_koszt)
                    .addComponent(field_koszt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_zapisz)
                    .addComponent(button_edytuj)
                    .addComponent(button_usun))
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_zapiszActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_zapiszActionPerformed
        String numerrezerwacji = boldtext_nrrezerwacji.getText();
        String imie = field_imie.getText();
        String nazwisko = field_nazwisko.getText();
        String nrtelefonu = field_numer.getText();
        SimpleDateFormat dateFormatStart = new SimpleDateFormat("yyyy-MM-dd");
        String start = dateFormatStart.format(data_start.getDate());
        SimpleDateFormat dateFormatEnd = new SimpleDateFormat("yyyy-MM-dd");
        String koniec = dateFormatEnd.format(data_koniec.getDate());
        
        String numerpokoju = lista_nrpokoju.getSelectedItem().toString();
        String standard = lista_standard.getSelectedItem().toString();
        String liczbaosob = lista_liczbaosob.getSelectedItem().toString();
	String lozko = lista_typlozka.getSelectedItem().toString();
        String koszt = field_koszt.getText();

        try {
            prepstmt = polaczenie.prepareStatement("insert into rezerwacja(id_rezerwacja, imie, nazwisko, nr_telefonu, checkin, checkout, id_pokoj, standard, liczba_osob, typ_lozka, koszt) values(?,?,?,?,?,?,?,?,?,?,?)");
            prepstmt.setString(1, numerrezerwacji);
            prepstmt.setString(2, imie);
            prepstmt.setString(3, nazwisko);
            prepstmt.setString(4, nrtelefonu);
            prepstmt.setString(5, start);
            prepstmt.setString(6, koniec);
            prepstmt.setString(7, numerpokoju);
            prepstmt.setString(8, standard);
            prepstmt.setString(9, liczbaosob);
            prepstmt.setString(10, lozko);
            prepstmt.setString(11, koszt); 
            prepstmt.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Rezerwacja dodana");
            
           
            field_imie.setText("");
            field_nazwisko.setText("");
            field_numer.setText("");
            data_start.setDate(null);
            data_koniec.setDate(null);
            lista_standard.setSelectedIndex(-1);
            lista_liczbaosob.setSelectedIndex(-1);
            lista_typlozka.setSelectedIndex(-1);
            field_koszt.setText("");
  
            IDrezerwacja();
            OdswiezRezerwacja();
            
        } catch (SQLException ex) {
            Logger.getLogger(rezerwacja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button_zapiszActionPerformed

    private void button_edytujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_edytujActionPerformed
       String numerrezerwacji = boldtext_nrrezerwacji.getText();
        String imie = field_imie.getText();
        String nazwisko = field_nazwisko.getText();
        String nrtelefonu = field_numer.getText();
        SimpleDateFormat dateFormatStart = new SimpleDateFormat("yyyy-MM-dd");
        String start = dateFormatStart.format(data_start.getDate());
        SimpleDateFormat dateFormatEnd = new SimpleDateFormat("yyyy-MM-dd");
        String koniec = dateFormatEnd.format(data_koniec.getDate());
        
        String numerpokoju = lista_nrpokoju.getSelectedItem().toString();
        String standard = lista_standard.getSelectedItem().toString();
        String liczbaosob = lista_liczbaosob.getSelectedItem().toString();
	String lozko = lista_typlozka.getSelectedItem().toString();
        String koszt = field_koszt.getText();

        try {
            prepstmt = polaczenie.prepareStatement("update rezerwacja set imie = ?, nazwisko = ?, nr_telefonu = ?, checkin = ?, checkout = ?, id_pokoj = ?, standard = ?, liczba_osob = ?, typ_lozka = ?, koszt = ? where id_rezerwacja = ?");
            prepstmt.setString(1, imie);
            prepstmt.setString(2, nazwisko);
            prepstmt.setString(3, nrtelefonu);
            prepstmt.setString(4, start);
            prepstmt.setString(5, koniec);
            prepstmt.setString(6, numerpokoju);
            prepstmt.setString(7, standard);
            prepstmt.setString(8, liczbaosob);
            prepstmt.setString(9, lozko);
            prepstmt.setString(10, koszt); 
	    prepstmt.setString(11, numerrezerwacji); 
            prepstmt.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Rezerwacja edytowana");
            
           
            field_imie.setText("");
            field_nazwisko.setText("");
            field_numer.setText("");
            data_start.setDate(null);
            data_koniec.setDate(null);
            lista_standard.setSelectedIndex(-1);
            lista_liczbaosob.setSelectedIndex(-1);
            lista_typlozka.setSelectedIndex(-1);
            field_koszt.setText("");
  
            IDrezerwacja();
            OdswiezRezerwacja();
            
	    button_zapisz.setEnabled(true);
			
        } catch (SQLException ex) {
            Logger.getLogger(rezerwacja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button_edytujActionPerformed

    private void field_imieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_imieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_imieActionPerformed

    private void field_kosztActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_kosztActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_kosztActionPerformed

    private void lista_typlozkaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lista_typlozkaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lista_typlozkaActionPerformed

    private void tab_rezerwacjeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_rezerwacjeMouseClicked
        deftab = (DefaultTableModel)tab_rezerwacje.getModel();
        int selectIndex = tab_rezerwacje.getSelectedRow();
        
        boldtext_nrrezerwacji.setText(deftab.getValueAt(selectIndex, 0).toString());
	field_imie.setText(deftab.getValueAt(selectIndex, 1).toString());
	field_nazwisko.setText(deftab.getValueAt(selectIndex, 2).toString());
	field_numer.setText(deftab.getValueAt(selectIndex, 3).toString());
	data_start.setDate(null);
        data_koniec.setDate(null);
	lista_nrpokoju.setSelectedItem(deftab.getValueAt(selectIndex, 6).toString());	
        lista_standard.setSelectedItem(deftab.getValueAt(selectIndex, 7).toString());
        lista_liczbaosob.setSelectedItem(deftab.getValueAt(selectIndex, 8).toString());
	lista_typlozka.setSelectedItem(deftab.getValueAt(selectIndex, 9).toString());
        field_koszt.setText(deftab.getValueAt(selectIndex, 10).toString());
        
        button_zapisz.setEnabled(false);        // TODO add your handling code here:
    }//GEN-LAST:event_tab_rezerwacjeMouseClicked

    private void button_usunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_usunActionPerformed

        String numerrezerwacji = boldtext_nrrezerwacji.getText();

        try {
            prepstmt = polaczenie.prepareStatement("delete from rezerwacja where id_rezerwacja = ?");
            prepstmt.setString(1, numerrezerwacji);
            prepstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Rezerwacja usunięta");
            
            field_imie.setText("");
            field_nazwisko.setText("");
            field_numer.setText("");
            data_start.setDate(null);
            data_koniec.setDate(null);
            lista_standard.setSelectedIndex(-1);
            lista_liczbaosob.setSelectedIndex(-1);
            lista_typlozka.setSelectedIndex(-1);
            field_koszt.setText("");
  
            IDrezerwacja();
            OdswiezRezerwacja();
            
	    button_zapisz.setEnabled(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(rezerwacja.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(rezerwacja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(rezerwacja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(rezerwacja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(rezerwacja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rezerwacja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel boldtext_nrrezerwacji;
    private javax.swing.JButton button_edytuj;
    private javax.swing.JButton button_usun;
    private javax.swing.JButton button_zapisz;
    private com.toedter.calendar.JDateChooser data_koniec;
    private com.toedter.calendar.JDateChooser data_start;
    private javax.swing.JTextField field_imie;
    private javax.swing.JTextField field_koszt;
    private javax.swing.JTextField field_nazwisko;
    private javax.swing.JTextField field_numer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> lista_liczbaosob;
    private javax.swing.JComboBox<String> lista_nrpokoju;
    private javax.swing.JComboBox<String> lista_standard;
    private javax.swing.JComboBox<String> lista_typlozka;
    private javax.swing.JTable tab_rezerwacje;
    private javax.swing.JLabel text_imie;
    private javax.swing.JLabel text_koniec;
    private javax.swing.JLabel text_koszt;
    private javax.swing.JLabel text_liczbaosob;
    private javax.swing.JLabel text_nazwisko;
    private javax.swing.JLabel text_nrpokoju;
    private javax.swing.JLabel text_nrrezerwacji;
    private javax.swing.JLabel text_standard;
    private javax.swing.JLabel text_start;
    private javax.swing.JLabel text_telefon;
    private javax.swing.JLabel text_typlozka;
    // End of variables declaration//GEN-END:variables
}
