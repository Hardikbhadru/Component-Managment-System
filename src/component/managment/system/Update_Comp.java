/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component.managment.system;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Hardik Bhadru
 */
public class Update_Comp extends javax.swing.JFrame {
    static String q=null,qu=null;
    /**
     * Creates new form Update_Comp
     */
    public Update_Comp() {
        initComponents();
        setExtendedState(getExtendedState()|Update_Comp.MAXIMIZED_BOTH);
        fetch1();
    }
    public void fetch1(){
        try{
            int count=0;
            String query="SELECT * FROM `component`";
            PreparedStatement ps=null;
            ps= (PreparedStatement) MyConnection.getConnection().prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            rs=ps.executeQuery(query);
            while(rs.next())
            {
                count++;
                String sr=Integer.toString(count);
                String e = rs.getString("Component_Name");
                String f = rs.getString("Quantity");
                String g = rs.getString("Cost");
                    DefaultTableModel model= (DefaultTableModel) jTable1.getModel();
                    model.addRow(new Object[]{sr,e,f,g});
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void del(){
        DefaultTableModel dtm=(DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(51, 0, 102));
        jPanel2.setLayout(null);

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr No.", "Component Name", "Quantity", "Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.setRowHeight(22);
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(100, 90, 640, 470);

        jButton2.setBackground(new java.awt.Color(0, 153, 204));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("View");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(100, 600, 120, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(130, 120, 810, 790);

        jPanel3.setBackground(new java.awt.Color(51, 0, 102));
        jPanel3.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 204));
        jLabel5.setText("Componrent  Name:-");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(60, 100, 290, 30);

        jLabel6.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 204));
        jLabel6.setText("Quantity:-");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(60, 250, 160, 30);

        jLabel7.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 204));
        jLabel7.setText("Cost:-");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(60, 410, 110, 30);

        jTextField1.setBackground(new java.awt.Color(255, 255, 204));
        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField1);
        jTextField1.setBounds(60, 140, 390, 40);

        jTextField2.setBackground(new java.awt.Color(255, 255, 204));
        jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField2);
        jTextField2.setBounds(60, 290, 390, 40);

        jTextField3.setBackground(new java.awt.Color(255, 255, 204));
        jTextField3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField3);
        jTextField3.setBounds(60, 450, 390, 40);

        jButton3.setBackground(new java.awt.Color(204, 0, 0));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);
        jButton3.setBounds(140, 590, 140, 40);

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(330, 590, 130, 40);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(1100, 120, 720, 790);

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 52)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Update Component Details");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(640, 30, 730, 60);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Created by:- Hardik Bhadru");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(1610, 960, 300, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1950, 1080);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row = jTable1.getSelectedRow();
        DefaultTableModel model= (DefaultTableModel) jTable1.getModel();
        String cnm=model.getValueAt(row, 1).toString();
        String qua=model.getValueAt(row, 2).toString();
        String cost=model.getValueAt(row, 3).toString();
        jTextField1.setText(cnm);
        jTextField2.setText(qua);
        jTextField3.setText(cost);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new Admin_Login().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       PreparedStatement ps=null;
            ResultSet rs=null;
            String cnm=jTextField1.getText();
            String qua=jTextField2.getText();
            String cost=jTextField3.getText();
            try{
                String query2="SELECT * FROM `component` WHERE `Component_Name`=?";
                try{
                    ps=(PreparedStatement)MyConnection.getConnection().prepareStatement(query2);  
                    ps.setString(1,cnm);
                    rs=ps.executeQuery();
                    if(rs.next()){
                        q=rs.getString("Quantity");
                    }
                    }catch(Exception e ){
                        JOptionPane.showMessageDialog(this, e);
                    }
                String query3="SELECT * FROM `avaliable_comp` WHERE `Component Name`=?";
                try{
                    ps=(PreparedStatement)MyConnection.getConnection().prepareStatement(query3);  
                    ps.setString(1,cnm);
                    rs=ps.executeQuery();
                if(rs.next()){
                    qu=rs.getString("Quantity");
                }
            }catch(Exception e ){
                JOptionPane.showMessageDialog(this, e);
            }
                        int quan=((Integer.parseInt(q))-(Integer.parseInt(qu)));
                        int quantit=(Integer.parseInt(qua))-quan;
                        String quantity=Integer.toString(quantit);
                        String queryup="UPDATE `component` SET `Component_Name`=?,`Quantity`=?,`Cost`=? WHERE `Component_Name`='"+cnm+"'";
                        ps=(PreparedStatement) MyConnection.getConnection().prepareStatement(queryup);
                        ps.setString(1, cnm);
                        ps.setString(2, qua);
                        ps.setString(3, cost);
                        ps.executeUpdate();
                        String queryupd="UPDATE `avaliable_comp` SET `Component Name`=?,`Quantity`=? WHERE `Component Name`='"+cnm+"'";
                        ps=(PreparedStatement) MyConnection.getConnection().prepareStatement(queryupd);
                        ps.setString(1, cnm);
                        ps.setString(2, quantity);
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Update Data Successfully","Information",JOptionPane.INFORMATION_MESSAGE);
                        jTextField1.setText("");
                        jTextField2.setText("");
                        jTextField3.setText("");
                    }catch(Exception ew){
                        JOptionPane.showMessageDialog(this, ew);
                    }
            del();
            fetch1();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Update_Comp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Update_Comp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Update_Comp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Update_Comp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Update_Comp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
