/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component.managment.system;

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
public class Over_due_list extends javax.swing.JFrame {
    static String sdt="",edt=null;
    /**
     * Creates new form Over_due_list
     */
    public Over_due_list() {
        initComponents();
        showdata();
        //display();
        setExtendedState(getExtendedState()|Over_due_list.MAXIMIZED_BOTH);
        
    }
    public void showdata()
    {
        String query="SELECT * FROM `component_issue`";
        try{
            PreparedStatement ps=MyConnection.getConnection().prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                String dat=rs.getString("Date");
                Date date=new Date();
                SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
                String dt=sdf.format(date);
                int year1=Integer.parseInt(dat.substring(6,10));
                int month1=Integer.parseInt(dat.substring(3,5));
                int date1=Integer.parseInt(dat.substring(0,2));
                int cyear=Integer.parseInt(dt.substring(6));
                int cmonth=Integer.parseInt(dt.substring(3,5));
                int cdate=Integer.parseInt(dt.substring(0,2));
                int datecount;
                for(int i=year1;i<=cyear;i++)
                {
                    for(int j=month1;j<=cmonth;j++)
                    {
                        if(j==4||j==6||j==9||j==11){
                            if(j==cmonth){
                                if(i==cyear){
                                    datecount=cdate;
                                }else{
                                    datecount=30;
                                }
                            }else{
                                datecount=30;
                            }
                        }else if(j==2){
                            if(j==cmonth){
                                if(i==cyear){
                                    datecount=cdate;
                                }else{
                                    if(cyear%4==0 && cyear%100==0 || cyear%400==0){
                                        datecount=29;
                                    }else{
                                        datecount=28;
                                    }
                                }
                            }else{
                                if(cyear%4==0 && cyear%100==0 || cyear%400==0){
                                    datecount=29;
                                }else{
                                    datecount=28;
                                }
                            }
                        }else{
                            if(j==cmonth){
                                if(i==cyear){
                                    datecount=cdate;
                                }else{
                                    datecount=31;
                                }
                            }else{
                                datecount=31;
                            }
                        }
                        System.err.println(datecount);
                    }
                }
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex);
        }
    }
    
    /*public void display(){
        String query="SELECT * FROM `component_issue`";
        ResultSet rs=null;
        try{
            PreparedStatement ps=MyConnection.getConnection().prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next())
            {
            String roll=rs.getString("Roll_No");
            String cnm=rs.getString("Component_Name");
            String qua=rs.getString("Quantity");
            String dat=rs.getString("Date");
            Date date=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
            String dt=sdf.format(date);
            int pr=Integer.parseInt(dat.substring(0,2));
            int da=Integer.parseInt(dt.substring(0, 2));
            int mo=Integer.parseInt(dat.substring(3,5));
            int pmo=Integer.parseInt(dt.substring(3,5));
            int yr=Integer.parseInt(dt.substring(6));
            int dif=0;
            dif=da-Integer.parseInt(dat.substring(0,2));
            if(dif>0)
		{
			if(dif<15)
			{
                           	DefaultTableModel model= (DefaultTableModel) jTable1.getModel();
                                model.addRow(new Object[]{roll,cnm,qua,dat,dif});
                        }
                }
		else
		{
			if(mo==4||mo==6||mo==9||mo==11)
			{
				dif=30-pr+da;
				if(dif>15)
				{
					DefaultTableModel model= (DefaultTableModel) jTable1.getModel();
                                        model.addRow(new Object[]{roll,cnm,qua,dat,dif});
				}
			}
			else if(mo==2)
			{
				if(yr%4==0 && yr%100==0 || yr%400==0)
				{
                                        dif=29-pr+da;
					if(dif>15)
					{
                                		DefaultTableModel model= (DefaultTableModel) jTable1.getModel();
                                                model.addRow(new Object[]{roll,cnm,qua,dat,dif});
					}
				}
				else
				{
                                        dif=28-pr+da;
					if(dif>15)
					{
                                		DefaultTableModel model= (DefaultTableModel) jTable1.getModel();
                                                model.addRow(new Object[]{roll,cnm,qua,dat,dif});
					}                              
      				}
			}
			else{
				dif=31-pr+da;
				if(dif>15)
				{
					DefaultTableModel model= (DefaultTableModel) jTable1.getModel();
                                        model.addRow(new Object[]{roll,cnm,qua,dat,dif});
				}
			}
		}
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 52)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Over Due Student List");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(600, 20, 620, 60);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Created by:- Hardik Bhadru");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(1610, 960, 300, 23);

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Component Name", "Quantity", "Date of issue", "Days "
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
        jTable1.setRowHeight(20);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(520, 120, 770, 570);

        jButton2.setBackground(new java.awt.Color(204, 0, 0));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(800, 760, 150, 50);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1940, 1030);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Admin_Login().setVisible(true);
        this.setVisible(false);
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
            java.util.logging.Logger.getLogger(Over_due_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Over_due_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Over_due_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Over_due_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Over_due_list().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
