/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salonproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import oracle.jdbc.pool.OracleDataSource;
/**
 *
 * @author PC
 */
public class ShowEmployee extends javax.swing.JFrame {

    /**
     * Creates new form ShowEmployee
     */
    public ShowEmployee() {
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        show = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        show1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N
        jLabel1.setText("Show Employees  ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 318, -1));

        show.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        show.setText("Show all");
        show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showActionPerformed(evt);
            }
        });
        jPanel1.add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 120, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 602, 370));

        jButton7.setBackground(new java.awt.Color(0, 0, 0));
        jButton7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("PDF");
        jButton7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 530, 329, 34));

        jButton8.setBackground(new java.awt.Color(0, 0, 0));
        jButton8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Generate Report");
        jButton8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, 329, 34));

        show1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        show1.setText("Back");
        show1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show1ActionPerformed(evt);
            }
        });
        jPanel1.add(show1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 130, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showActionPerformed
        // TODO add your handling code here:
              try {
            OracleDataSource ods= new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            ods.setUser("c##lena");
            ods.setPassword("654321");
            Connection con=ods.getConnection();
            Statement stmt=con.createStatement();
            String strsql="select * from EMPLOYEE ";
             ResultSet rs=stmt.executeQuery(strsql);
             this.jTextArea1.setText("EMPLOYEEID\t FIRSTNAME\t  LASTNAME\t  STREET\t ZIPCODE\t PAYRATE\t\n");
             this.jTextArea1.append("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
             this.jTextArea1.append("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
           while(rs.next()){
               String EID=rs.getString("EMPLOYEEID");
                String fname= rs.getString("FIRSTNAME");
               String lname= rs.getString("LASTNAME");
               String street=rs.getString("STREET");
               String city=rs.getString("ZIPCODE");
               String pay=rs.getString("PAYRATE");
;
               this.jTextArea1.append(EID+"\t"+fname+"\t"+lname+"\t"+street+city+"\t"+pay+"\n");
               
           }
            
        con.close();
             
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());

        }  
        
        
    }//GEN-LAST:event_showActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
       //OracleDataSource ods;
            try{
            OracleDataSource ods=new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            ods.setUser("c##lena");
            ods.setPassword("654321");
            Connection con=ods.getConnection();
            InputStream in =new FileInputStream(new File("customer.jrxml"));
            JasperDesign jd=JRXmlLoader.load(in);
            JasperReport jr=JasperCompileManager.compileReport(jd);
            //Map<String,Object> para=new HashMap<String,Object>();
            //para.put("Parameter1",t1.getText());
            JasperPrint jp=JasperFillManager.fillReport(jr,null,con);
            OutputStream ou=new FileOutputStream(new File("lena.pdf"));
            JasperExportManager.exportReportToPdfStream(jp,ou);
            ou.close();
            in.close();
            con.close();
            JOptionPane.showMessageDialog(null, "pdf report created successfully");
            }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString());
            
    }                                        
    
    }                                        

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
       
         try{
            OracleDataSource ods=new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            ods.setUser("c##lena");
            ods.setPassword("654321");
            Connection con=ods.getConnection();
            InputStream in =new FileInputStream(new File("customer.jrxml"));
            JasperDesign jd=JRXmlLoader.load(in);
            JasperReport jr=JasperCompileManager.compileReport(jd);
            //Map<String,Object> para=new HashMap<String,Object>();
            //para.put("Parameter1",t1.getText());
            JasperPrint jp=JasperFillManager.fillReport(jr,null,con);
            //OutputStream ou=new FileOutputStream(new File("lena.pdf"));
            //asperExportManager.exportReportToPdfStream(jp,ou);
            JFrame frame=new JFrame("Report");

            frame.getContentPane().add(new JRViewer(jp));
            frame.pack();
            frame.setVisible(true);
            in.close();
            con.close();
            }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString());
            
    }
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void show1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        adminmenu ob = new adminmenu();
        ob.setVisible(true);
    }//GEN-LAST:event_show1ActionPerformed

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
            java.util.logging.Logger.getLogger(ShowEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton show;
    private javax.swing.JButton show1;
    // End of variables declaration//GEN-END:variables
}
