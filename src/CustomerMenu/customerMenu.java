/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CustomerMenu;

import vendor.MenuItem;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import vendor.vendorReview;

/**
 *
 * @author james
 */
public class customerMenu extends javax.swing.JFrame {

    /**
     * Creates new form customerMenu
     */
    
    private NonEditableTableModel model = new NonEditableTableModel();
    private String ColumnName[] = {"Food ID","Name","Price","Vendor Name"};
    private int row=-1;
    public static String ID="";
    public static String name="";
    public static String price="";
    public static String vendorname="";
    
    public customerMenu() {
        initComponents();
        model.setColumnIdentifiers(ColumnName);
        menuTable();
    }
    
    public void menuTable(){
        readAllVendorMenus();
    }
    
    public void readAllVendorMenus() {
    File folder = new File("menu"); // Directory where all menu files are stored
    File[] listOfFiles = folder.listFiles();

    for (File file : listOfFiles) {
        if (file.isFile() && file.getName().endsWith("MENU.txt")) {
            readMenuFile(file);
        }
    }
    }

    private void readMenuFile(File file) {
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = reader.readLine()) != null) {
            // Assuming each line in the file represents a menu item
            String[] MenuData = line.split(",");
            if (MenuData.length == 4) {
                String FoodId = MenuData[0];
                String Name = MenuData[1];
                String Price = MenuData[2];
                String vendor_name = MenuData[3];
                MenuItem menuItemObj = new MenuItem(FoodId, Name, Price, vendor_name);
                model.addRow(new Object[]{FoodId,Name,Price,vendor_name});
            } else {
                System.out.println("Invalid line: " + line);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
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

        jOptionPane1 = new javax.swing.JOptionPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        Menu = new javax.swing.JTable();
        back = new javax.swing.JButton();
        CartButton = new javax.swing.JButton();
        ViewReview = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Menu.setModel(model
        );
        Menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MenuMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Menu);

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        CartButton.setText("Add to cart");
        CartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CartButtonActionPerformed(evt);
            }
        });

        ViewReview.setText("View review");
        ViewReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewReviewActionPerformed(evt);
            }
        });

        jButton1.setText("View cart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(back)
                    .addComponent(CartButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(292, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ViewReview)
                        .addGap(67, 67, 67))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(back)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CartButton)
                        .addGap(51, 51, 51)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ViewReview)
                    .addComponent(jButton1))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CartButtonActionPerformed
        // TODO add your handling code here:
        if(row==-1){
            JOptionPane.showMessageDialog(this,"Please select a row");
        }
        else{
        AddToCart addtocart = new AddToCart();
        addtocart.setVisible(true);
        }
    }//GEN-LAST:event_CartButtonActionPerformed

    private void ViewReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewReviewActionPerformed
        // TODO add your handling code here:
        if(row==-1){
            JOptionPane.showMessageDialog(this,"Please select a row");
        }
        else{
            vendorReview rev = new vendorReview();
            rev.setTable(vendorname);
            rev.setVisible(true);
        }
    }//GEN-LAST:event_ViewReviewActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        CustomerUI UI = new CustomerUI();
        UI.setVisible(true);
        dispose();
    }//GEN-LAST:event_backActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(!CartItem.cartExist()){
            JOptionPane.showMessageDialog(null, "There is nothing in the cart!");
        }
        else{
            Cart cart = new Cart();
            cart.setVisible(true);
            dispose();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void MenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuMouseReleased
        // TODO add your handling code here:
        row = Menu.getSelectedRow();
        ID =String.valueOf(model.getValueAt(row, 0)) ;
        name =String.valueOf(model.getValueAt(row, 1)) ;
        price =String.valueOf(model.getValueAt(row, 2)) ;
        vendorname = String.valueOf(model.getValueAt(row, 3));
    }//GEN-LAST:event_MenuMouseReleased

    
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
            java.util.logging.Logger.getLogger(customerMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(customerMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(customerMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(customerMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new customerMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CartButton;
    private javax.swing.JTable Menu;
    private javax.swing.JButton ViewReview;
    private javax.swing.JButton back;
    private javax.swing.JButton jButton1;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
