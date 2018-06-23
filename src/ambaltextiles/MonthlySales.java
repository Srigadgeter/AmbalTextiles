/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ambaltextiles;

import ambaltextiles.databaseWorks.DatabaseFunctions;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.text.MessageFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sridhar
 */
public class MonthlySales extends javax.swing.JFrame {

    DatabaseFunctions df;
    DefaultTableModel dm;
    DefaultTableCellRenderer centerRenderer;

    String[] head;
    private String name, dt, inum, part, vtype, deb;
    int sno = 1;

    /**
     * Creates new form MonthlyPayments
     */
    public MonthlySales() {
        dm = new DefaultTableModel(0, 0);

        initComponents();

        head = new String[]{"SNO", "DATE", "NAME", "INVOICE NUMBER", "PARTICULARS", "VOUCHER TYPE", "DEBIT"}; // declare header fields
        dm.setColumnIdentifiers(head);

        datewisePaymentsTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        datewisePaymentsTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        datewisePaymentsTable.getColumnModel().getColumn(2).setPreferredWidth(380);
        datewisePaymentsTable.getColumnModel().getColumn(3).setPreferredWidth(140);
        datewisePaymentsTable.getColumnModel().getColumn(4).setPreferredWidth(130);
        datewisePaymentsTable.getColumnModel().getColumn(5).setPreferredWidth(120);
        datewisePaymentsTable.getColumnModel().getColumn(6).setPreferredWidth(130);

        // formatting data in cells as center
        centerRenderer = new DefaultTableCellRenderer(); // instance of the DefaultTableCellRenderer
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER); // formatting cell element as center for horizontalAlignment
        // applying the above format to all cells in table
        datewisePaymentsTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        datewisePaymentsTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        datewisePaymentsTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        datewisePaymentsTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        datewisePaymentsTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        datewisePaymentsTable.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        datewisePaymentsTable.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);

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
        close = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        datewisePaymentsTable = new javax.swing.JTable();
        viewByDates = new javax.swing.JButton();
        save = new javax.swing.JLabel();
        tax = new javax.swing.JCheckBox();
        fromDate = new org.jdesktop.swingx.JXDatePicker();
        toDate = new org.jdesktop.swingx.JXDatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(47, 93, 129));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        jPanel1.setForeground(new java.awt.Color(47, 93, 129));

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ambaltextiles/images/close.png"))); // NOI18N
        close.setToolTipText("Close");
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Supercell-Magic", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SALES ANALYSIS WINDOW");

        jLabel2.setFont(new java.awt.Font("Supercell-Magic", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("FROM DATE");

        jLabel3.setFont(new java.awt.Font("Supercell-Magic", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TO DATE");

        datewisePaymentsTable.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        datewisePaymentsTable.setModel(dm);
        datewisePaymentsTable.setToolTipText("Datewise Sales Table");
        datewisePaymentsTable.setRowHeight(20);
        jScrollPane1.setViewportView(datewisePaymentsTable);

        viewByDates.setFont(new java.awt.Font("Supercell-Magic", 0, 10)); // NOI18N
        viewByDates.setText("VIEW");
        viewByDates.setToolTipText("View List Button");
        viewByDates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewByDatesActionPerformed(evt);
            }
        });

        save.setFont(new java.awt.Font("Supercell-Magic", 0, 14)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ambaltextiles/images/file.png"))); // NOI18N
        save.setText("Save");
        save.setToolTipText("Save as File");
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMouseClicked(evt);
            }
        });

        tax.setFont(new java.awt.Font("Supercell-Magic", 0, 10)); // NOI18N
        tax.setText("TAX");
        tax.setToolTipText("Tax Checkbox");

        fromDate.setToolTipText("From Date");

        toDate.setToolTipText("To Date");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(fromDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(toDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tax)
                                .addGap(18, 18, 18)
                                .addComponent(viewByDates)
                                .addGap(28, 28, 28)
                                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 294, Short.MAX_VALUE)
                        .addComponent(close))
                    .addComponent(jScrollPane1))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(viewByDates)
                            .addComponent(save)
                            .addComponent(tax)
                            .addComponent(fromDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(toDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(close))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
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

        setSize(new java.awt.Dimension(1100, 556));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        // TODO add your handling code here:
        if (isDisplayable()) {
            int flag = JOptionPane.showConfirmDialog(this, "Do you want to close the window ?");
            if (flag == JOptionPane.YES_OPTION) {
                dispose(); // To close this frame
            }
        }
    }//GEN-LAST:event_closeMouseClicked

    private void viewByDatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewByDatesActionPerformed
        // TODO add your handling code here:
        datasRecovery();
    }//GEN-LAST:event_viewByDatesActionPerformed

    private void saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseClicked
        // TODO add your handling code here:

        MessageFormat header = new MessageFormat("AMBAL TEXTILES SALES TABLE");
        MessageFormat footer = new MessageFormat("DATEWISE PAYMENTS VIEW FROM "
                + new SimpleDateFormat("dd/MM/yyyy").format(fromDate.getDate())
                + " TO " + new SimpleDateFormat("dd/MM/yyyy").format(toDate.getDate()));

        PrinterJob pj = PrinterJob.getPrinterJob();
        PageFormat pf = pj.defaultPage();
        Paper paper = new Paper();
        double margin = 5;
        paper.setImageableArea(margin, margin, paper.getWidth() - margin * 2, paper.getHeight() - margin * 2);
        pf.setPaper(paper);
        pj.setPrintable(datewisePaymentsTable.getPrintable(JTable.PrintMode.FIT_WIDTH, header, footer), pj.validatePage(pf));
        if (pj.printDialog()) {
            try {
                pj.print();
            } catch (PrinterException e) {
            }
        }

    }//GEN-LAST:event_saveMouseClicked

    private void datasRecovery() {
        try {
            df = new DatabaseFunctions();
            sno = 1;
            
            while (dm.getRowCount() > 0) {
                dm.removeRow(0);
            }

            if (fromDate.getDate() != null && toDate.getDate() != null) {
                ArrayList<MonthlySales> m;
                if (tax.isSelected()) {
                    m = df.findPaymentsByDates(new SimpleDateFormat("dd/MM/yyyy").format(fromDate.getDate()),
                            new SimpleDateFormat("dd/MM/yyyy").format(toDate.getDate()), true);
                } else {
                    m = df.findPaymentsByDates(new SimpleDateFormat("dd/MM/yyyy").format(fromDate.getDate()),
                            new SimpleDateFormat("dd/MM/yyyy").format(toDate.getDate()), false);
                }
                m.forEach((month) -> {
                    dm.addRow(new Object[]{
                        String.valueOf(sno),
                        month.getDt(),
                        month.getName(),
                        month.getInum(),
                        month.getPart(),
                        month.getVtype(),
                        month.getDeb()
                    });
                    sno++;
                });
            }
        } catch (SQLException | ClassNotFoundException ex) {
            // don't do anything
        }
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getInum() {
        return inum;
    }

    public void setInum(String inum) {
        this.inum = inum;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getVtype() {
        return vtype;
    }

    public void setVtype(String vtype) {
        this.vtype = vtype;
    }

    public String getDeb() {
        return deb;
    }

    public void setDeb(String deb) {
        this.deb = deb;
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
            java.util.logging.Logger.getLogger(MonthlySales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MonthlySales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MonthlySales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MonthlySales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MonthlySales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel close;
    private javax.swing.JTable datewisePaymentsTable;
    private org.jdesktop.swingx.JXDatePicker fromDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel save;
    private javax.swing.JCheckBox tax;
    private org.jdesktop.swingx.JXDatePicker toDate;
    private javax.swing.JButton viewByDates;
    // End of variables declaration//GEN-END:variables

}
