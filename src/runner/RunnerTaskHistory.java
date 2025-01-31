/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package runner;

import vendor.*;
import CustomerMenu.NonEditableTableModel;
import CustomerMenu.OrderFile;
import CustomerMenu.ReviewPane;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.TableModel;

/**
 *
 * @author james
 */
public class RunnerTaskHistory extends javax.swing.JFrame {

    /**
     * Creates new form VendorOrder
     */
    
    
    public RunnerTaskHistory() {
        model = new NonEditableTableModel();
        initComponents();
        OrderList = Admin.Runner.getTaskHistory(RunnerLogin.currentRunner);
        OrderTable(OrderList);
    }
    
    private NonEditableTableModel model;
    public static List<OrderFile> OrderList;
    public static int row = -1;
    private String id;
    private String vendor;
    
    
    public void OrderTable(List<OrderFile> OrderList){
        model = new NonEditableTableModel();
        model.addColumn("OrderID");
        model.addColumn("Customer");
        model.addColumn("Vendor");
        model.addColumn("Revenue");
        model.addColumn("Date");
        model.addColumn("Status");
        
        for(OrderFile order:OrderList){
                model.addRow(new Object[]{order.getOrderID(),order.getCustomerID(),order.getVendorName(),5,order.getDate(),order.getOrderStatus()});
            }
        
        Orders.setModel(model);
    }   
        
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Orders = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Orders.setModel(model
        );
        Orders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrdersMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                OrdersMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Orders);

        jButton2.setText("Filter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Get total revenue");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Read review");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton1)
                .addContainerGap(907, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButton1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jButton2)
                        .addGap(77, 77, 77)
                        .addComponent(jButton3)
                        .addGap(30, 30, 30)
                        .addComponent(jButton4)))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        RunnerTask ven = new RunnerTask();
        ven.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void OrdersMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrdersMouseReleased
     // TODO add your handling code here:
    row = Orders.getSelectedRow();
    id = String.valueOf(model.getValueAt(row, 0));
    vendor = String.valueOf(model.getValueAt(row, 2));

    if (row != -1 && evt.getClickCount() == 2 && !evt.isConsumed()) {
        // Handle double-click event
        OrderFile orderSelected = (OrderFile) OrderList.get(row);
        String total = String.valueOf(model.getValueAt(row, 3));
        String date = String.valueOf(model.getValueAt(row, 4));
        String status = String.valueOf(model.getValueAt(row, 5));

        OrderHistoryDetail detail = new OrderHistoryDetail(orderSelected);
        detail.setVisible(true);
        evt.consume();
    }
    }//GEN-LAST:event_OrdersMouseReleased

    private void OrdersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrdersMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_OrdersMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         // Show a dialog or use another UI element to get the user's choice
    String[] options = {"Daily", "Monthly", "Quarterly"}; // Add more options as needed
    String selectedOption = (String) JOptionPane.showInputDialog(
            this,
            "Select time frame:",
            "Filter Orders",
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]
    );

    // Perform filtering based on the user's choice
    if (selectedOption != null) {
        // Call the corresponding function in the OrderFile class
        switch (selectedOption) {
            case "Daily":
                // Get daily orders
                List<OrderFile> dailyOrders = OrderFile.filterByCurrentDate(OrderList);
                OrderTable(dailyOrders);
                break;
            case "Monthly":
                SpinnerNumberModel monthModel = new SpinnerNumberModel(1, 1, 12, 1);
                JSpinner monthSpinner = new JSpinner(monthModel);
                int result = JOptionPane.showOptionDialog(
                        this,
                        monthSpinner,
                        "Select Month",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        null
                );

                if (result == JOptionPane.OK_OPTION) {
                    int selectedMonth = (int) monthSpinner.getValue();
                    List<OrderFile> monthlyOrders = OrderFile.filterByMonth(OrderList,selectedMonth);
                    OrderTable(monthlyOrders);
                }
                break;
            case "Quarterly":
                SpinnerNumberModel quarterModel = new SpinnerNumberModel(1, 1, 4, 1);
                JSpinner quarterSpinner = new JSpinner(quarterModel);
                int quarterResult = JOptionPane.showOptionDialog(
        this,
              quarterSpinner,
               "Select Quarter",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null,
            null,
            null
                );

    if (quarterResult == JOptionPane.OK_OPTION) {
        int selectedQuarter = (int) quarterSpinner.getValue();
        List<OrderFile> quarterlyOrders = OrderFile.filterByQuarter(OrderList, selectedQuarter);
        OrderTable(quarterlyOrders);
    }
    break;
            // Add more cases as needed
        }
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "The total revenue is: "+getTotalRevenue());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(row==-1){
            JOptionPane.showMessageDialog(null, "Please select a row first!");
        }
        else{
            vendorReview rev = new vendorReview();
            rev.setTable(vendor);
            rev.setVisible(true);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    
    private double getTotalRevenue() {
        double totalRevenue = 0;

        TableModel tableModel =  Orders.getModel();
        int rowCount = tableModel.getRowCount();
        totalRevenue = rowCount*5;

        return totalRevenue;
    }
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
            java.util.logging.Logger.getLogger(RunnerTaskHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RunnerTaskHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RunnerTaskHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RunnerTaskHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RunnerTaskHistory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Orders;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
