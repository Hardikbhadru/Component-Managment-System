/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component.managment.system;


import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hardik Bhadru
 */
public class Return_history extends javax.swing.JFrame {
    static String sdt="",edt=null;
    static int leap[]={31,29,31,30,31,30,31,31,30,31,30,31};
    static int noLeap[]={31,28,31,30,31,30,31,31,30,31,30,31};
    /**
     * Creates new form Return_history
     */
    public Return_history() {
        initComponents();
        setExtendedState(getExtendedState()|Return_history.MAXIMIZED_BOTH);
    }
    public boolean datecount(String dateCheck){
        int startDate=Integer.parseInt(sdt.substring(0,2));
        int startMonth=Integer.parseInt(sdt.substring(3,5));
        int startYear=Integer.parseInt(sdt.substring(6));
        int endDate=Integer.parseInt(edt.substring(0,2));
        int endMonth=Integer.parseInt(edt.substring(3,5));
        int endYear=Integer.parseInt(edt.substring(6));
        
        int Cdate=Integer.parseInt(dateCheck.substring(0,2));
        int Cmonth=Integer.parseInt(dateCheck.substring(3,5));
        int Cyear=Integer.parseInt(dateCheck.substring(6,10));
        int year=Cyear-startYear;
        int month = Cmonth-startMonth;
        
        int startDiff=-1;
        if(month<0){
            year=year-1;
            month=12-(startMonth-Cmonth);
        }
        if(year>=0){
        int day=Cdate-startDate;
        if(day<0){
            
            month=month-1;
            if(((Cyear%4==0)&& (Cyear%100)!=0) || (Cyear%400==0)){
                System.out.print("Yes");
                System.out.println((startMonth)-(startDate-Cdate));
            day=leap[(startMonth)-(startDate-Cdate)];    
            System.out.println("HEloo");
            }
            else{
                day=noLeap[(startMonth)-(startDate-Cdate)];
            }
            
        }
        if(month>=0 && day>=0 ){
            startDiff=1;
        }
        
        System.out.println(Integer.toString(day)+" "+Integer.toString(month)+" "+Integer.toString(year));
        
        }
        System.out.println(startDiff);
        
        int endDiff=-1;
         int year2=endYear-Cyear;
        int month2 = endMonth-Cmonth;
        if(month2<0){
            year2=year2-1;
            month2=12-(Cmonth-endMonth);
        }
        if(year2>=0){
        int day2=endDate-Cdate;
        if(day2<0){
            
            month2=month2-1;
            if(((endYear%4==0)&& (endYear%100)!=0) || (endYear%400==0)){
            day2=leap[(Cmonth)-(Cdate-endDate)];
            }
            else{
                day2=noLeap[(Cmonth)-(Cdate-endDate)];
            }
            
        }
        if(month2>=0 && day2>=0 ){
            endDiff=1;
        }
        
        System.out.println(Integer.toString(day2)+" "+Integer.toString(month2)+" "+Integer.toString(year2));
        
        }
        System.out.println(endDiff);
       if(startDiff==1 && endDiff==1){
           return true;
       }
       return false;
    }
    public void fatch(){
        String temp=null;
        int count=0;
        if(Integer.parseInt(sdt.substring(6))>Integer.parseInt(edt.substring(6))){
            temp=sdt;
            sdt=edt;
            edt=temp;
        }else{
            if(Integer.parseInt(sdt.substring(3,5))>Integer.parseInt(edt.substring(3,5))){
                temp=sdt;
                sdt=edt;
                edt=temp;
            }else{
                if(Integer.parseInt(sdt.substring(0,2))>Integer.parseInt(edt.substring(0,2))){
                    temp=sdt;
                    sdt=edt;
                    edt=temp;
                }
            }
        }
        String query="SELECT * FROM `return history`";
        try{
            PreparedStatement ps=(PreparedStatement) MyConnection.getConnection().prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                String dt=rs.getString("Date");
               // if(datecount(dt))
                if(datecount(dt)){
                            String roll=rs.getString("Roll_No");
                            String cnm=rs.getString("Component_Name");
                            String qu=rs.getString("Quantity");
                            String co=rs.getString("Condition");
                            String rm=rs.getString("Remarks");
                            count++;
                            DefaultTableModel model= (DefaultTableModel) jTable1.getModel();
                            model.addRow(new Object[]{count,roll,cnm,qu,co,rm,dt});
                }
                /*if(Integer.parseInt(sdt.substring(6))<=Integer.parseInt(dt.substring(6,10)) && Integer.parseInt(dt.substring(6,10))>=Integer.parseInt(edt.substring(6))){
                    if(Integer.parseInt(sdt.substring(3,5))<=Integer.parseInt(dt.substring(3,5)) && Integer.parseInt(dt.substring(3,5))>=Integer.parseInt(edt.substring(3,5))){
                        if(Integer.parseInt(sdt.substring(0,2))<=Integer.parseInt(dt.substring(0,2))){
                            String roll=rs.getString("Roll_No");
                            String cnm=rs.getString("Component_Name");
                            String qu=rs.getString("Quantity");
                            String co=rs.getString("Condition");
                            String rm=rs.getString("Remarks");
                            count++;
                            DefaultTableModel model= (DefaultTableModel) jTable1.getModel();
                            model.addRow(new Object[]{count,roll,cnm,qu,co,rm,dt});
                        }else if(Integer.parseInt(dt.substring(0,2))>=Integer.parseInt(edt.substring(0,2))){
                            String roll=rs.getString("Roll_No");
                            String cnm=rs.getString("Component_Name");
                            String qu=rs.getString("Quantity");
                            String co=rs.getString("Condition");
                            String rm=rs.getString("Remarks");
                            count++;
                            DefaultTableModel model= (DefaultTableModel) jTable1.getModel();
                            model.addRow(new Object[]{count,roll,cnm,qu,co,rm,dt});
                        }
                    }
                }*/
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton3 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
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
                "Sr No.", "Roll No.", "Component Name ", "Quantity ", "Condition ", "Remarks ", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setRowHeight(22);
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(540, 70, 890, 630);

        jLabel5.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 204));
        jLabel5.setText("Starting Date:-");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(80, 140, 290, 30);

        jLabel6.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 204));
        jLabel6.setText("Ending Date:-");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(80, 290, 210, 30);

        jDateChooser2.setAlignmentX(1.0F);
        jDateChooser2.setAlignmentY(1.0F);
        jDateChooser2.setDateFormatString("dd/MM/yyyy"); // NOI18N
        jDateChooser2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jDateChooser2.setMinimumSize(new java.awt.Dimension(30, 25));
        jDateChooser2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser2PropertyChange(evt);
            }
        });
        jPanel2.add(jDateChooser2);
        jDateChooser2.setBounds(80, 330, 280, 40);

        jButton3.setBackground(new java.awt.Color(51, 204, 0));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Export to Excal");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(100, 520, 240, 40);

        jDateChooser1.setDateFormatString("dd/MM/yyyy");
        jDateChooser1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });
        jPanel2.add(jDateChooser1);
        jDateChooser1.setBounds(80, 180, 280, 40);

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
        jButton4.setBounds(60, 440, 140, 40);

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
        jButton2.setBounds(260, 440, 120, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(180, 110, 1480, 830);

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 52)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Return History");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(740, 40, 420, 60);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Created by:- Hardik Bhadru");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(1610, 960, 300, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 2000, 1130);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jDateChooser2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser2PropertyChange
        if ("date".equals(evt.getPropertyName())) {
            //Get Date
            Date date = jDateChooser2.getDateEditor().getDate();
            SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
            //Define the format of Date
            String mydate = sf.format(date);
            edt=mydate;
        } else {
        }
    }//GEN-LAST:event_jDateChooser2PropertyChange

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row=jTable1.getRowCount();
        if(row<=0){
            JOptionPane.showMessageDialog(this, "Table is empty","Error",JOptionPane.ERROR_MESSAGE);
        }else{
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
        if ("date".equals(evt.getPropertyName())) {
            //Get Date
            Date date = jDateChooser1.getDateEditor().getDate();
            SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
            //Define the format of Date
            String mydate = sf.format(date);
            sdt=mydate;
        } else {
        }
    }//GEN-LAST:event_jDateChooser1PropertyChange

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new Admin_Login().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        fatch();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Return_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Return_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Return_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Return_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Return_history().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
