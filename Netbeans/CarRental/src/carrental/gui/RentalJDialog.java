/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrental.gui;

import carrental.model.Car;
import carrental.model.Driver;
import carrental.model.IModel;
import carrental.model.Rental;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class RentalJDialog extends javax.swing.JDialog implements TableModelListener {

    private IModel model;
    private List<Driver> drivers;
    private List<Car> cars;
    private List<Rental> rentals;
    private DefaultTableModel dtm;
    private JComboBox carsComboBox = new JComboBox();
    private JComboBox driversComboBox = new JComboBox();
    private JDialog thisJDialog;

    public RentalJDialog(java.awt.Frame parent, IModel model) {

        super(parent, true);
        initComponents();
        this.model = model;
        this.thisJDialog = this;

        setLocationRelativeTo(parent);
        setTitle("Rental manager");

        rentalJTable.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent e) {

                int row = rentalJTable.rowAtPoint(e.getPoint());

                int col = rentalJTable.columnAtPoint(e.getPoint());

                if (col == 1) {
                    
                    RentalTimeJDialog rentalTimeJDialog = new RentalTimeJDialog(thisJDialog, row);
                    rentalTimeJDialog.setVisible(true);
                    
                }

            }

        });

        try {

            this.cars = model.getAllCar();
            this.drivers = model.getAllDriver();
            this.rentals = model.getAllRental();

        } catch (SQLException ex) {

            MainWindow.networkError(this, ex);

        }

        setUpCarColumn(rentalJTable, rentalJTable.getColumnModel().getColumn(3));
        setUpDriverColumn(rentalJTable, rentalJTable.getColumnModel().getColumn(4));

        dtm = (DefaultTableModel) rentalJTable.getModel();

        dtm.addTableModelListener(
                this);

        updateTable();

    }

    private void updateTable() {

        dtm.getDataVector().clear();
        dtm.fireTableDataChanged();

        for (Rental rental : rentals) {

            Vector row = new Vector();

            try {

                rental = (Rental) model.getRentalMap().get(rental.getId());

            } catch (SQLException ex) {

                MainWindow.networkError(this, ex);

            }

            String from = "";
            String to = "";

            if (rental.getTimestampFrom() != null) {

                from = rental.getTimestampFrom().toString();
                from = from.replaceAll("-", ".");
                from = from.substring(0, from.indexOf(":")) + "h";

            }

            if (rental.getTimestampTo() != null) {

                to = rental.getTimestampTo().toString();
                to = to.replaceAll("-", ".");
                to = to.substring(0, to.indexOf(":")) + "h";

            }

            row.add(rental.getId());
            row.add(from);
            row.add(to);
            row.add(rental.getCar());
            row.add(rental.getDriver());
            carsComboBox.getModel().setSelectedItem(rental.getCar());
            driversComboBox.getModel().setSelectedItem(rental.getDriver());
            row.add(rental.getPrice());

            dtm.addRow(row);

        }

    }

    public void setUpCarColumn(JTable table, TableColumn carColumn) {

        for (Car car : cars) {

            carsComboBox.addItem(car);

        }

        carColumn.setCellEditor(new DefaultCellEditor(carsComboBox));

        DefaultTableCellRenderer renderer
                = new DefaultTableCellRenderer();
        renderer.setToolTipText("Click here to select another car");
        carColumn.setCellRenderer(renderer);
    }

    public void setUpDriverColumn(JTable table,
            TableColumn driverColumn) {

        drivers.forEach((driver) -> {

            driversComboBox.addItem(driver);

        });

        driverColumn.setCellEditor(new DefaultCellEditor(driversComboBox));

        DefaultTableCellRenderer renderer
                = new DefaultTableCellRenderer();
        renderer.setToolTipText("Click here to select another driver");
        driverColumn.setCellRenderer(renderer);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        rentalJTable = new javax.swing.JTable();
        newRentalButton = new javax.swing.JButton();
        deleteJButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        rentalJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Rent from", "Rent to", "Car", "Driver", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(rentalJTable);

        newRentalButton.setText("New rental");
        newRentalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newRentalButtonActionPerformed(evt);
            }
        });

        deleteJButton.setText("Delete rental");
        deleteJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJButtonActionPerformed(evt);
            }
        });

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newRentalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteJButton)
                    .addComponent(closeButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {closeButton, deleteJButton, newRentalButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newRentalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116)
                        .addComponent(deleteJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(closeButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {closeButton, deleteJButton, newRentalButton});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newRentalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newRentalButtonActionPerformed

        Vector row = new Vector();
        Car car = null;
        Driver driver = null;

        try {

            car = model.getCarMap().get(0);
            driver = model.getDriverMap().get(0);

        } catch (SQLException ex) {

            MainWindow.networkError(this, ex);

        }

        Rental rental = new Rental(new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), car, driver, 0);
        int id = 0;

        try {

            model.addRental(rental);
            Thread.sleep(200);
            Map<Integer, Rental> rentalMap = model.getRentalMap();

            for (Map.Entry<Integer, Rental> entry : rentalMap.entrySet()) {

                if (entry.getKey() > id) {

                    id = entry.getKey();

                }

            }

            rentals = model.getAllRental();

        } catch (SQLException | InterruptedException ex) {

            MainWindow.networkError(this, ex);

        }

        row.add(0, id);
        dtm = (DefaultTableModel) rentalJTable.getModel();
        dtm.addRow(row);

    }//GEN-LAST:event_newRentalButtonActionPerformed

    private void deleteJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJButtonActionPerformed

        dtm = (DefaultTableModel) rentalJTable.getModel();

        try {

            int[] selectedRows = rentalJTable.getSelectedRows();
            int[] ids = new int[selectedRows.length];

            if (selectedRows.length > 0) {

                for (int i = selectedRows.length - 1; i >= 0; i--) {

                    ids[i] = (int) dtm.getValueAt(selectedRows[i], 0);

                    if (ids[i] != 0) {

                        dtm.removeRow(selectedRows[i]);
                        Rental rental = model.getRentalMap().get(ids[i]);
                        model.deleteRental(rental);

                    } else {

                        JOptionPane.showMessageDialog(rootPane, "You can't delete this!");

                    }

                }

            }

        } catch (SQLException ex) {

            MainWindow.networkError(this, ex);

        }

    }//GEN-LAST:event_deleteJButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed

        try {

            Map<Integer, Rental> rentalMap = model.getRentalMap();

            for (Map.Entry<Integer, Rental> entry : rentalMap.entrySet()) {

                if (((Rental) entry.getValue()).getId() != 0
                        && (((Rental) entry.getValue()).getCar().getId() == 0
                        || ((Rental) entry.getValue()).getDriver().getId() == 0)) {

                    model.deleteRental(entry.getValue());

                }

            }

        } catch (SQLException ex) {

            MainWindow.networkError(this, ex);

        }

        setVisible(false);

    }//GEN-LAST:event_closeButtonActionPerformed

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
            java.util.logging.Logger.getLogger(RentalJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RentalJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RentalJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RentalJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JButton deleteJButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newRentalButton;
    private javax.swing.JTable rentalJTable;
    // End of variables declaration//GEN-END:variables

    @Override
    public void tableChanged(TableModelEvent e) {

        if (e.getType() == TableModelEvent.UPDATE
                && e.getFirstRow() >= 0 && e.getColumn() >= 0) {

            int rowIndex = e.getFirstRow();
            int columnIndex = e.getColumn();

            Object newValue = dtm.getValueAt(rowIndex, columnIndex);

            try {

                rentals = model.getAllRental();

            } catch (SQLException ex) {

                MainWindow.networkError(this, ex);

            }

            Rental rental = rentals.get(rowIndex);

            switch (columnIndex) {

                case 3:
                    rental.setCar(((Car) newValue));
                    break;

                case 4:
                    rental.setDriver((Driver) newValue);
                    break;

                case 5:
                    rental.setPrice((int) newValue);
                    break;

            }

            try {

                model.updateRental(rental);
                rentals = model.getAllRental();

            } catch (SQLException ex) {

                MainWindow.networkError(this, ex);

            }

        }

    }
    

}
