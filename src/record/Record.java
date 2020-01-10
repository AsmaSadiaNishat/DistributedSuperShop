/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package record;

import dsupershop.*;
import java.awt.Color;
import java.awt.Image;
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Record extends javax.swing.JFrame {

    Connection conn = null;
    Statement s = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    public ArrayList<AddProduct> getMenu() {

        ArrayList<AddProduct> menu = new ArrayList<AddProduct>();
        //conn = def.connect.connect();
        String sql = "SELECT * FROM add_product";
        AddProduct obj;

        try {

            s = conn.createStatement();
            rs = s.executeQuery(sql);

            while (rs.next()) {
                obj = new AddProduct(
                        rs.getInt("pro_id"),
                        rs.getString("pro_group"),
                        rs.getString("pro_name"),
                        rs.getString("supplier"),
                        rs.getString("q_type"),
                        rs.getInt("pur_price"),
                        rs.getInt("sale_price")
                );
                menu.add(obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return menu;
    }

    public void showAddProduct() {

        ArrayList<AddProduct> table = getMenu();

        String[] columnName = {"PRODUCT_ID", "PRODUCT_GROUP", "PRODUCT_NAME", "SUPPLIER", "Q_TYPE", "PUR_PRICE", "SALE_PRICE"};
        Object[][] record = new Object[table.size()][7];

        for (int i = 0; i < table.size(); i++) {
            record[i][0] = table.get(i).getCode();
            record[i][1] = table.get(i).getCategory();
            record[i][2] = table.get(i).getFood();
            record[i][3] = table.get(i).getPrice();
            record[i][4] = table.get(i).getDate();
            record[i][5] = table.get(i).getPur();
            record[i][6] = table.get(i).getSale();

            TableModel model = new TableModel(record, columnName);
            jtable.setModel(model);
            jtable.setRowHeight(50);
            jtable.getColumnModel().getColumn(6).setPreferredWidth(200);

        }
    }

    public ArrayList<SaleProduct> getSale() {

        ArrayList<SaleProduct> sale = new ArrayList<SaleProduct>();
        //conn = def.connect.connect();
        String sql = "SELECT * FROM sale_product";
        SaleProduct obj;

        try {
            s = conn.createStatement();
            rs = s.executeQuery(sql);

            while (rs.next()) {
                obj = new SaleProduct(
                        rs.getInt("pro_id"),
                        rs.getString("pro_name"),
                        rs.getInt("cust_id"),
                        rs.getInt("quantity"),
                        rs.getInt("price")
                );
                sale.add(obj);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return sale;
    }

    public void showSaleProduct() {

        ArrayList<SaleProduct> table = getSale();

        String[] columnName = {"PRODUCT_ID", "PRODUCT_NAME", "CUSTOMER_ID", "QUANTITY", "PRICE"};
        Object[][] record = new Object[table.size()][5];

        for (int i = 0; i < table.size(); i++) {
            record[i][0] = table.get(i).getCode();
            record[i][1] = table.get(i).getName();
            record[i][2] = table.get(i).getCustID();
            record[i][3] = table.get(i).getQty();
            record[i][4] = table.get(i).getPrice();

            TableModel model = new TableModel(record, columnName);
            jtable.setModel(model);
            jtable.setRowHeight(50);
            jtable.getColumnModel().getColumn(4).setPreferredWidth(200);

        }
    }

    public ArrayList<CustomerData> getDetails() {

        ArrayList<CustomerData> sale = new ArrayList<CustomerData>();
        //conn = def.connect.connect();
        String sql = "SELECT A.PRO_NAME, S.QUANTITY, S.PRICE, C.C_NAME, C.C_PHONE, C.C_ADDRESS FROM CUSTOMER C,  SALE_PRODUCT S, ADD_PRODUCT A "
                + "WHERE C.C_ID = S.CUST_ID AND A.PRO_ID = S.PRO_ID";
        CustomerData obj;

        try {
            s = conn.createStatement();
            rs = s.executeQuery(sql);

            while (rs.next()) {
                obj = new CustomerData(
                        rs.getString("add_product.pro_name"),
                        rs.getInt("sale_product.quantity"),
                        rs.getInt("sale_product.price"),
                        rs.getString("customer.c_name"),
                        rs.getString("customer.c_phone"),
                        rs.getString("customer.c_address"),
                        rs.getInt("customer.c_id"),
                        rs.getInt("sale_product.pro_id")
                );
                sale.add(obj);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }

        return sale;
    }

    public void showDetails() {

        ArrayList<CustomerData> table = getDetails();

        String[] columnName = {"PRODUCT_NAME", "QUANTITY", "PRICE", "CUSTOMER_NAME", "CUSTOMER_PHONE", "CUSTOMER_ADDRESS"};
        Object[][] record = new Object[table.size()][6];

        for (int i = 0; i < table.size(); i++) {
            record[i][0] = table.get(i).getPname();
            record[i][1] = table.get(i).getQty();
            record[i][2] = table.get(i).getPrice();
            record[i][3] = table.get(i).getCname();
            record[i][4] = table.get(i).getPhone();
            record[i][5] = table.get(i).getAddress();

            TableModel model = new TableModel(record, columnName);
            jtable.setModel(model);
            jtable.setRowHeight(50);
            jtable.getColumnModel().getColumn(5).setPreferredWidth(200);

        }
    }
    
    public void fetch(){
        
        String sql = "SELECT A.PRO_NAME, S.QUANTITY, S.PRICE, C.C_NAME, C.C_PHONE, C.C_ADDRESS FROM CUSTOMER C,  SALE_PRODUCT S, ADD_PRODUCT A "
                + "WHERE C.C_ID = S.CUST_ID AND A.PRO_ID = S.PRO_ID";
        try{
            
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            jtable.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public Record() {
        conn = First_Program.First_Program();
        //Connection connection = MysqlConn.connect();
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

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        exit = new javax.swing.JButton();
        exit1 = new javax.swing.JButton();
        exit2 = new javax.swing.JButton();
        exit3 = new javax.swing.JButton();
        exit4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Stencil", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Distributed Super Shop");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(153, 51, 255)));

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setFont(new java.awt.Font("Monotype Corsiva", 1, 24)); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jtable.setBackground(new java.awt.Color(0, 204, 204));
        jtable.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODE", "CATEGORY", "FOOD_NAME", "PRICE", "DATE", "IMAGE"
            }
        ));
        jtable.getTableHeader().setReorderingAllowed(false);
        jtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtable);
        if (jtable.getColumnModel().getColumnCount() > 0) {
            jtable.getColumnModel().getColumn(0).setPreferredWidth(1);
            jtable.getColumnModel().getColumn(1).setPreferredWidth(7);
            jtable.getColumnModel().getColumn(2).setPreferredWidth(12);
            jtable.getColumnModel().getColumn(3).setPreferredWidth(5);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 993, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Status", jPanel2);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        exit.setFont(new java.awt.Font("Script MT Bold", 1, 30)); // NOI18N
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        exit1.setFont(new java.awt.Font("Script MT Bold", 1, 30)); // NOI18N
        exit1.setText("Product");
        exit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit1ActionPerformed(evt);
            }
        });

        exit2.setFont(new java.awt.Font("Script MT Bold", 1, 30)); // NOI18N
        exit2.setText("Sale");
        exit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit2ActionPerformed(evt);
            }
        });

        exit3.setFont(new java.awt.Font("Script MT Bold", 1, 30)); // NOI18N
        exit3.setText("Home");
        exit3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit3ActionPerformed(evt);
            }
        });

        exit4.setFont(new java.awt.Font("Script MT Bold", 1, 30)); // NOI18N
        exit4.setText("Customer");
        exit4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(exit3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exit1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exit2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exit4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exit1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exit2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exit3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exit4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed

        int opt = JOptionPane.showConfirmDialog(this, "Confirm to Exit", "EXIT", JOptionPane.YES_NO_OPTION);
        if (opt == 0) {
            System.exit(0);
        } else {
        }
    }//GEN-LAST:event_exitActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        //showTable();
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableMouseClicked

    }//GEN-LAST:event_jtableMouseClicked

    private void exit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit1ActionPerformed
        // TODO add your handling code here:
        showAddProduct();
    }//GEN-LAST:event_exit1ActionPerformed

    private void exit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit2ActionPerformed
        // TODO add your handling code here:
        showSaleProduct();
    }//GEN-LAST:event_exit2ActionPerformed

    private void exit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit3ActionPerformed
        // TODO add your handling code here:
        new Home().setVisible(true);
        dispose();
    }//GEN-LAST:event_exit3ActionPerformed

    private void exit4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit4ActionPerformed
        // TODO add your handling code here:
        fetch();
    }//GEN-LAST:event_exit4ActionPerformed

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
            java.util.logging.Logger.getLogger(Record.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Record.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Record.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Record.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Record().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit;
    private javax.swing.JButton exit1;
    private javax.swing.JButton exit2;
    private javax.swing.JButton exit3;
    private javax.swing.JButton exit4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jtable;
    // End of variables declaration//GEN-END:variables
}
