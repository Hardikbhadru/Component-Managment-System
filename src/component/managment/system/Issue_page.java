/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component.managment.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hardik Bhadru
 */
public class Issue_page extends javax.swing.JFrame {
    static int srn=0;
    static String NAME,com,qun;
    private Connection cn=null;    
    private PreparedStatement ps;
    private ResultSet rs;
    static String quantity="";
    /**
     * Creates new form Issue_page
     */
    public Issue_page() {
        initComponents();
        fillcombo();
        display1();
        setExtendedState(getExtendedState()|Issue_page.MAXIMIZED_BOTH);
    }
    void display2(String name){
        this.NAME=name;
        }
    void display1(){
        jLabel5.setText(NAME);
        }
    private void fillcombo(){
        jLabel6.setText("");
        jLabel7.setText("");
        String query="SELECT * FROM `avaliable_comp`";
        try{
            ps=MyConnection.getConnection().prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next()){
                String item=rs.getString("Component Name");
                jComboBox1.addItem(item);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
    public void nextava(String cnm,String qua){
        String dat;
        String query2="SELECT * FROM `component` WHERE `Component_Name`=?";
                    try{
                        ps=(PreparedStatement)MyConnection.getConnection().prepareStatement(query2);  
                        ps.setString(1,cnm);
                        rs=ps.executeQuery();
                        if(rs.next()){
                            quantity=null;
                            quantity=rs.getString("Quantity");
                        }
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(this, e);
                    }
        if(Integer.parseInt(quantity)>Integer.parseInt(qua)){
            String query3="SELECT * FROM `component_issue` WHERE `Component_Name`=?";
                    try{
                        ps=(PreparedStatement)MyConnection.getConnection().prepareStatement(query3);  
                        ps.setString(1,cnm);
                        rs=ps.executeQuery();
                        if(rs.next()){
                            Date date=new Date();
                            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
                            String dt=sdf.format(date);
                            dat=rs.getString("Date");
                            int d=Integer.parseInt(dt.substring(0, 2));
                            int mo=Integer.parseInt(dat.substring(3,5));
                            int yr=Integer.parseInt(dt.substring(6));
                            System.out.println(d);
                            int dif=0;
                            dif=15-d+Integer.parseInt(dat.substring(0,2));
                            if(dif>0){
                                jLabel6.setText("Next Availablity:-");
                                jLabel7.setText(cnm+" Next Available in "+dif+" days");
                            }else{
                                if(mo==4||mo==6||mo==9||mo==11){
                                    dif=30-Integer.parseInt(dat.substring(0,2));
                                    dif=15-dif+d;
                                    jLabel6.setText("Next Availablity:-");
                                    jLabel7.setText(cnm+" Next Available in "+dif+" days");
                                }else if(mo==2){
                                    if(yr%4==0){
                                        dif=29-Integer.parseInt(dat.substring(0,2));
                                        dif=15-dif+d;
                                        jLabel6.setText("Next Availablity:-");
                                        jLabel7.setText(cnm+" Next Available in "+dif+" days");
                                    }else{
                                        dif=28-Integer.parseInt(dat.substring(0,2));
                                        dif=15-dif+d;
                                        jLabel6.setText("Next Availablity:-");
                                        jLabel7.setText(cnm+" Next Available in "+dif+" days");
                                    }
                                }else{
                                    dif=31-Integer.parseInt(dat.substring(0,2));
                                    dif=15-dif+d;
                                    jLabel6.setText("Next Availablity:-");
                                    jLabel7.setText(cnm+" Next Available in "+dif+" days");
                                }
                            }
                        }
                    }catch(Exception e ){
                        JOptionPane.showMessageDialog(this, e);
                    }
        }else{
            JOptionPane.showMessageDialog(this, "Not that much component available in ICT","Error",JOptionPane.ERROR_MESSAGE);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 52)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Issue Component ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(780, 36, 500, 70);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Created by:- Hardik Bhadru");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(1610, 960, 300, 23);

        jPanel2.setBackground(new java.awt.Color(51, 0, 102));
        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 204));
        jLabel3.setText("Quantity:-");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(140, 180, 120, 20);

        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1);
        jTextField1.setBounds(260, 180, 240, 30);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 204));
        jLabel1.setText("Search Component:-");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(40, 100, 220, 30);

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(260, 100, 240, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jLabel6);
        jLabel6.setBounds(70, 520, 470, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jLabel7);
        jLabel7.setBounds(70, 550, 470, 30);

        jButton1.setBackground(new java.awt.Color(0, 153, 204));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(550, 310, 120, 40);

        jButton2.setBackground(new java.awt.Color(204, 0, 0));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Remove");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(380, 310, 120, 40);

        jButton3.setBackground(new java.awt.Color(0, 153, 51));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Issue Component");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(110, 310, 220, 40);

        jButton4.setBackground(new java.awt.Color(204, 0, 0));
        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(10, 700, 110, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(100, 160, 720, 750);

        jPanel3.setBackground(new java.awt.Color(51, 0, 102));
        jPanel3.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Name:-");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(10, 50, 80, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jLabel5);
        jLabel5.setBounds(90, 50, 550, 30);

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr No.", "Roll No.", "Component Name", "Quantity", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.setRowHeight(22);
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(60, 110, 670, 600);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(990, 160, 780, 750);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1920, 1000);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row = jTable1.getSelectedRow();
        int col=3;
        DefaultTableModel model= (DefaultTableModel)jTable1.getModel();
        String selected = model.getValueAt(row, col).toString();
        String nm=model.getValueAt(row, 2).toString();
        String qu=model.getValueAt(row, 3).toString();     
     String query2="SELECT * FROM `avaliable_comp` WHERE `Component Name`=?";
     try{
          ps=MyConnection.getConnection().prepareStatement(query2);  
          ps.setString(1,nm);
          rs=ps.executeQuery();
          if(rs.next()){
              quantity=rs.getString("Quantity");
          }
     }catch(Exception e )
     {
         JOptionPane.showMessageDialog(this, e);
         System.out.println(e);
     }        
            if (row >= 0) {
                try {
                    try{
                        String queryup="UPDATE `avaliable_comp` SET `Component Name`=?,`Quantity`=? WHERE `Component Name`='"+nm+"'";
                        ps=null;
                        ps=MyConnection.getConnection().prepareStatement(queryup);
                        ps.setString(1, nm);
                        int co=(Integer.parseInt(quantity))+(Integer.parseInt(qu));
                        String upd=Integer.toString(co);
                        ps.setString(2, upd);
                        ps.executeUpdate();
                    }catch(Exception ew){
                        JOptionPane.showMessageDialog(this, ew);
                    }
                    ps = MyConnection.getConnection().prepareStatement("DELETE FROM `component_issue` WHERE `Date`='"+selected+"' ");
                    ps.executeUpdate();
                    model.removeRow(row);
                }
                catch (Exception w) {
                    JOptionPane.showMessageDialog(this, w);
                }           
            }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    int rows=jTable1.getRowCount();
    if(rows<=0){
        new HomePage().setVisible(true);
        this.setVisible(false);
    }else{
        JOptionPane.showMessageDialog(this, "Component Issue Successfully!!...");
        new HomePage().setVisible(true);
        this.setVisible(false);
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JOptionPane.showMessageDialog(this, "Component Issue Successfully!!...");
        new HomePage().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
        jLabel6.setText("");
        jLabel7.setText("");
        String roll=Login.No;
        String nm=jComboBox1.getModel().getSelectedItem().toString();
        String qu=jTextField1.getText();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date=new Date();
        String dt=sdf.format(date);
        //String dt="06/04/2020 13:12:10";
        if(nm.equals("")||qu.equals("")){
            JOptionPane.showMessageDialog(this, "Please Enter all values...","Error",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            String query1="SELECT * FROM `avaliable_comp` WHERE `Component Name`=?";
            try{
                ps= (PreparedStatement) MyConnection.getConnection().prepareStatement(query1);
                ps.setString(1, nm);
                rs=ps.executeQuery();
                if(rs.next()){
                String cou=rs.getString("Quantity");
                if(Integer.parseInt(qu)<=Integer.parseInt(cou)){
                try{
                    String queryco = "INSERT INTO `component_issue`(`Roll_No`, `Component_Name`, `Quantity`, `Date`) VALUES (?,?,?,?)";
                    ps=MyConnection.getConnection().prepareStatement(queryco);
                    ps.setString(1, roll);
                    ps.setString(2, nm);
                    ps.setString(3, qu);
                    ps.setString(4, dt);
                    ps.addBatch();
                    ps.executeBatch();
                    ps=null;
                    String query="INSERT INTO `history`(`Roll_No`, `Component_Name`, `Quantity`, `Date`) VALUES (?,?,?,?)";
                    ps=MyConnection.getConnection().prepareStatement(query);
                    ps.setString(1, roll);
                    ps.setString(2, nm);
                    ps.setString(3, qu);
                    ps.setString(4, dt);
                    ps.addBatch();
                    ps.executeBatch();
                    int count;
                    count=(Integer.parseInt(cou))-(Integer.parseInt(qu));
                    String upd=Integer.toString(count);
                    try{
                        String queryup="UPDATE `avaliable_comp` SET `Component Name`=?,`Quantity`=? WHERE `Component Name`='"+nm+"'";
                        ps=null;
                        ps=MyConnection.getConnection().prepareStatement(queryup);
                        ps.setString(1, nm);
                        ps.setString(2, upd);
                        srn++;
                        String sr=Integer.toString(srn);
                        if(ps.executeUpdate()>0){
                            DefaultTableModel model= (DefaultTableModel) jTable1.getModel();
                            model.addRow(new Object[]{sr,roll,nm,jTextField1.getText(),dt});
                            jTextField1.setText(null); 
                        }
                    }catch(Exception ew){
                        JOptionPane.showMessageDialog(this, ew);
                    }                 
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this, e);
            }
        }else{
                    JOptionPane.showMessageDialog(this, "Sorry No.of component not avaliable..","",JOptionPane.ERROR_MESSAGE);
                    nextava(nm,qu);
                    jTextField1.setText(null);
        }
    }else{
                    JOptionPane.showMessageDialog(this, "Invalid");
    }
}catch(Exception ex){
                    JOptionPane.showMessageDialog(this, ex);
}
}
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Please Enter All Value","Error",JOptionPane.ERROR_MESSAGE);
        }
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
            java.util.logging.Logger.getLogger(Issue_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Issue_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Issue_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Issue_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Issue_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    // End of variables declaration//GEN-END:variables
}
