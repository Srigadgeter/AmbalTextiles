package ambaltextiles;

import ambaltextiles.databaseWorks.DatabaseFunctions;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Sridhar
 */
public class Home extends javax.swing.JFrame {

    DatabaseFunctions df;

    /**
     * Creates new form Home
     *
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public Home() throws SQLException, ClassNotFoundException {
        initComponents();

        df = new DatabaseFunctions();
        df.createCustomersListTable();
        df.createPaymentsListTable();

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
        changePassword = new javax.swing.JLabel();
        placeBill = new javax.swing.JLabel();
        payments = new javax.swing.JLabel();
        ownerInfo = new javax.swing.JLabel();
        developerInfo = new javax.swing.JLabel();
        about = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        addCustomer = new javax.swing.JLabel();
        monthlySales = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(47, 93, 129)));
        jPanel1.setForeground(new java.awt.Color(47, 93, 129));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(47, 93, 129));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ambaltextiles/images/ambal textiles.png"))); // NOI18N

        changePassword.setFont(new java.awt.Font("Supercell-Magic", 0, 10)); // NOI18N
        changePassword.setForeground(new java.awt.Color(224, 153, 94));
        changePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ambaltextiles/images/keychange.png"))); // NOI18N
        changePassword.setText("CHANGE PASSWORD");
        changePassword.setToolTipText("Change Password");
        changePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changePasswordMouseClicked(evt);
            }
        });

        placeBill.setFont(new java.awt.Font("Supercell-Magic", 0, 10)); // NOI18N
        placeBill.setForeground(new java.awt.Color(96, 99, 99));
        placeBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ambaltextiles/images/placebill.png"))); // NOI18N
        placeBill.setText("NEW BILL");
        placeBill.setToolTipText("Place Bill");
        placeBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                placeBillMouseClicked(evt);
            }
        });

        payments.setFont(new java.awt.Font("Supercell-Magic", 0, 10)); // NOI18N
        payments.setForeground(new java.awt.Color(16, 175, 147));
        payments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ambaltextiles/images/balance.png"))); // NOI18N
        payments.setText("CUSTOMER PAYMENTS / SALES");
        payments.setToolTipText("Payments");
        payments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paymentsMouseClicked(evt);
            }
        });

        ownerInfo.setFont(new java.awt.Font("Supercell-Magic", 0, 10)); // NOI18N
        ownerInfo.setForeground(new java.awt.Color(250, 188, 61));
        ownerInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ambaltextiles/images/owner.png"))); // NOI18N
        ownerInfo.setText("OWNER INFO");
        ownerInfo.setToolTipText("Owner Info");
        ownerInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ownerInfoMouseClicked(evt);
            }
        });

        developerInfo.setFont(new java.awt.Font("Supercell-Magic", 0, 10)); // NOI18N
        developerInfo.setForeground(new java.awt.Color(179, 179, 179));
        developerInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ambaltextiles/images/dev.png"))); // NOI18N
        developerInfo.setText("DEVELOPER INFO");
        developerInfo.setToolTipText("Developer Info");
        developerInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                developerInfoMouseClicked(evt);
            }
        });

        about.setFont(new java.awt.Font("Supercell-Magic", 0, 10)); // NOI18N
        about.setForeground(new java.awt.Color(47, 93, 129));
        about.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ambaltextiles/images/about.png"))); // NOI18N
        about.setText("ABOUT ");
        about.setToolTipText("About this Application");
        about.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutMouseClicked(evt);
            }
        });

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ambaltextiles/images/close.png"))); // NOI18N
        close.setToolTipText("Close");
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });

        addCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ambaltextiles/images/addcustomer.png"))); // NOI18N
        addCustomer.setToolTipText("Add Customer");
        addCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addCustomerMouseClicked(evt);
            }
        });

        monthlySales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ambaltextiles/images/calendar.png"))); // NOI18N
        monthlySales.setToolTipText("Monthly Sales View");
        monthlySales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                monthlySalesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(placeBill)
                            .addComponent(ownerInfo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(developerInfo)
                                .addGap(91, 91, 91))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(payments)
                                .addGap(46, 46, 46)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(changePassword)
                            .addComponent(about))
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(close, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addCustomer, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(monthlySales)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(close)
                        .addGap(18, 18, 18)
                        .addComponent(addCustomer)))
                .addGap(18, 18, 18)
                .addComponent(monthlySales)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changePassword)
                    .addComponent(payments)
                    .addComponent(placeBill))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ownerInfo)
                    .addComponent(developerInfo)
                    .addComponent(about))
                .addGap(69, 69, 69))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(760, 440));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void changePasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePasswordMouseClicked
        // TODO add your handling code here:
        setVisible(false);
        new PasswordChangingWindow().setVisible(true);
    }//GEN-LAST:event_changePasswordMouseClicked

    private void placeBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_placeBillMouseClicked
        // TODO add your handling code here:
        Bill bill = new Bill();
        bill.setVisible(true);
    }//GEN-LAST:event_placeBillMouseClicked

    private void paymentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentsMouseClicked
        // TODO add your handling code here:
        Payments pay = new Payments();
        pay.setVisible(true);
    }//GEN-LAST:event_paymentsMouseClicked

    private void ownerInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ownerInfoMouseClicked
        // TODO add your handling code here:
        Owner own = new Owner();
        own.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_ownerInfoMouseClicked

    private void developerInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_developerInfoMouseClicked
        // TODO add your handling code here:
        Developer develop = new Developer();
        develop.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_developerInfoMouseClicked

    private void aboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutMouseClicked
        // TODO add your handling code here:
        About about = new About();
        about.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_aboutMouseClicked

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        // TODO add your handling code here:
        if (isDisplayable()) {
            int flag = JOptionPane.showConfirmDialog(this, "Do you want to close the window ?");
            if (flag == JOptionPane.YES_OPTION) {
                dispose(); // To close this frame
                System.exit(0); // To close the entire operation
            }
        }
    }//GEN-LAST:event_closeMouseClicked

    private void addCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addCustomerMouseClicked
        // TODO add your handling code here:
        AddCustomer ac = new AddCustomer();
        ac.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_addCustomerMouseClicked

    private void monthlySalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monthlySalesMouseClicked
        // TODO add your handling code here:
        MonthlySales month = new MonthlySales();
        month.setVisible(true);
    }//GEN-LAST:event_monthlySalesMouseClicked

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Home().setVisible(true);
                } catch (SQLException | ClassNotFoundException ex) {
                    // don't do anything
                }
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel about;
    private javax.swing.JLabel addCustomer;
    private javax.swing.JLabel changePassword;
    private javax.swing.JLabel close;
    private javax.swing.JLabel developerInfo;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JLabel monthlySales;
    private javax.swing.JLabel ownerInfo;
    private javax.swing.JLabel payments;
    private javax.swing.JLabel placeBill;
    // End of variables declaration//GEN-END:variables
}
