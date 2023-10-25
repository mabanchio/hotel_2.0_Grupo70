package Vistas;

import AccesoDatos.ConsultaData;
import Entidades.DetalleReserva;
import Entidades.Habitacion;
import Entidades.Huesped;
import Entidades.Reserva;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class VistaReserva extends javax.swing.JInternalFrame {

    private DefaultTableModel modeloCliente = new DefaultTableModel() {
        //No permitir edicion de columnas
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private DefaultTableModel modeloDisponibilidad = new DefaultTableModel() {
        //No permitir edicion de columnas
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private DefaultTableModel modeloDetalleReserva = new DefaultTableModel() {
        //No permitir edicion de columnas
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public VistaReserva(String dni) {
        initComponents();
        armarCabeceras();
        cargarIcono();
        jtfDni.setText(dni);
        cargarHuesped();
        capturarClikEnTabla();
        jtCliente.setRowSelectionInterval(0, 0);
        cargarDisponibilidad();
    }

    public VistaReserva() {
        initComponents();
        armarCabeceras();
        cargarIcono();
        cargarHuesped();
        capturarClikEnTabla();
        cargarDisponibilidad();
        jbAgregarHabitacion.setEnabled(false);
        cargarImagenReserva();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jdcDesde = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jdcHasta = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jtfCantPersonas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfPiso = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtDisponibilidad = new javax.swing.JTable();
        jbAgregarHabitacion = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtfDni = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCliente = new javax.swing.JTable();
        jbAltaCliente = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jtfCantidadPersonasReserva = new javax.swing.JTextField();
        jlReserva = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtDetalleReserva = new javax.swing.JTable();
        jbEliminarHabitacion = new javax.swing.JButton();
        jbReservar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Reservas");

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Disponibilidad");

        jLabel3.setText("Fecha desde:");

        jdcDesde.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdcDesdePropertyChange(evt);
            }
        });

        jLabel4.setText("Fecha hasta:");

        jdcHasta.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdcHastaPropertyChange(evt);
            }
        });

        jLabel5.setText("Cantidad Personas:");

        jtfCantPersonas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfCantPersonasKeyReleased(evt);
            }
        });

        jLabel6.setText("Piso:");

        jtfPiso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfPisoKeyReleased(evt);
            }
        });

        jtDisponibilidad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "N° Habitación", "Código", "Capacidad", "Cantidad Camas", "Tipo Camas", "Precio Noche"
            }
        ));
        jScrollPane2.setViewportView(jtDisponibilidad);

        jbAgregarHabitacion.setText("Agregar Habitación");
        jbAgregarHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarHabitacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCantPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbAgregarHabitacion)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jtfCantPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)
                                .addComponent(jtfPiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jdcHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(jdcDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbAgregarHabitacion))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Cliente");

        jLabel8.setText("DNI:");

        jtfDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfDniKeyReleased(evt);
            }
        });

        jtCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "DNI", "Teléfono", "e-mail"
            }
        ));
        jScrollPane1.setViewportView(jtCliente);

        jbAltaCliente.setText("Alta Cliente");
        jbAltaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAltaClienteActionPerformed(evt);
            }
        });

        jLabel10.setText("Cantidad de Personas:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jtfDni, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCantidadPersonasReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbAltaCliente)
                    .addComponent(jlReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jtfDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jtfCantidadPersonasReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbAltaCliente)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Habitaciones a Reservar");

        jtDetalleReserva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "N° Habitación", "Código", "Capacidad", "Cantidad Camas", "Tipo Camas", "Precio Noche"
            }
        ));
        jScrollPane3.setViewportView(jtDetalleReserva);

        jbEliminarHabitacion.setText("Eliminar Habitación");
        jbEliminarHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarHabitacionActionPerformed(evt);
            }
        });

        jbReservar.setText("Reservar");
        jbReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbReservarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jbReservar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(33, 33, 33))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jbEliminarHabitacion)
                        .addContainerGap(18, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jbEliminarHabitacion)
                        .addGap(18, 18, 18)
                        .addComponent(jbReservar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDniKeyReleased
        cargarHuesped();
    }//GEN-LAST:event_jtfDniKeyReleased

    private void jbAltaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAltaClienteActionPerformed
        if (!jtfDni.getText().isEmpty()) {
            Menu.escritorio.removeAll();
            Menu.escritorio.repaint();
            VistaAltaCliente vac = new VistaAltaCliente(jtfDni.getText());
            vac.setLocation((Menu.escritorio.getWidth() - vac.getWidth()) / 2, (Menu.escritorio.getHeight() - vac.getHeight()) / 2);
            vac.setVisible(true);
            Menu.escritorio.add(vac);
            Menu.escritorio.moveToFront(vac);
            vac.setMaximizable(false);
            vac.setClosable(true);
        } else {
            Menu.escritorio.removeAll();
            Menu.escritorio.repaint();
            VistaAltaCliente vac = new VistaAltaCliente();
            vac.setLocation((Menu.escritorio.getWidth() - vac.getWidth()) / 2, (Menu.escritorio.getHeight() - vac.getHeight()) / 2);
            vac.setVisible(true);
            Menu.escritorio.add(vac);
            Menu.escritorio.moveToFront(vac);
            vac.setMaximizable(false);
            vac.setClosable(true);
        }
    }//GEN-LAST:event_jbAltaClienteActionPerformed

    private void jdcDesdePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcDesdePropertyChange
        if (jdcDesde.getDate() != null && jdcHasta.getDate() != null) {
            cargarDisponibilidad();
        }

    }//GEN-LAST:event_jdcDesdePropertyChange

    private void jdcHastaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcHastaPropertyChange
        if (jdcDesde.getDate() != null && jdcHasta.getDate() != null) {
            cargarDisponibilidad();
        }
    }//GEN-LAST:event_jdcHastaPropertyChange

    private void jtfCantPersonasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCantPersonasKeyReleased
        cargarDisponibilidad();
    }//GEN-LAST:event_jtfCantPersonasKeyReleased

    private void jtfPisoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPisoKeyReleased
        cargarDisponibilidad();
    }//GEN-LAST:event_jtfPisoKeyReleased

    private void jbAgregarHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarHabitacionActionPerformed
        if (jtDisponibilidad.getSelectedRow() != -1) {
            modeloDetalleReserva.addRow(new Object[]{
                modeloDisponibilidad.getValueAt(jtDisponibilidad.getSelectedRow(), 0),
                modeloDisponibilidad.getValueAt(jtDisponibilidad.getSelectedRow(), 1),
                modeloDisponibilidad.getValueAt(jtDisponibilidad.getSelectedRow(), 2),
                modeloDisponibilidad.getValueAt(jtDisponibilidad.getSelectedRow(), 3),
                modeloDisponibilidad.getValueAt(jtDisponibilidad.getSelectedRow(), 4),
                modeloDisponibilidad.getValueAt(jtDisponibilidad.getSelectedRow(), 5)
            });
            modeloDisponibilidad.removeRow(jtDisponibilidad.getSelectedRow());
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una habtación disponible para agregar a la reserva.");
        }
    }//GEN-LAST:event_jbAgregarHabitacionActionPerformed

    private void jbEliminarHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarHabitacionActionPerformed
        if (jtDetalleReserva.getSelectedRow() != -1) {
            modeloDisponibilidad.addRow(new Object[]{
                modeloDetalleReserva.getValueAt(jtDetalleReserva.getSelectedRow(), 0),
                modeloDetalleReserva.getValueAt(jtDetalleReserva.getSelectedRow(), 1),
                modeloDetalleReserva.getValueAt(jtDetalleReserva.getSelectedRow(), 2),
                modeloDetalleReserva.getValueAt(jtDetalleReserva.getSelectedRow(), 3),
                modeloDetalleReserva.getValueAt(jtDetalleReserva.getSelectedRow(), 4),
                modeloDetalleReserva.getValueAt(jtDetalleReserva.getSelectedRow(), 5)
            });
            modeloDetalleReserva.removeRow(jtDetalleReserva.getSelectedRow());
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una habtación para eliminar de la reserva.");
        }
    }//GEN-LAST:event_jbEliminarHabitacionActionPerformed

    private void jbReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbReservarActionPerformed
        if(jtDetalleReserva.getRowCount() > 0){
            try {
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Esta seguro que quiere registrar la Reserva?", "Confirmar Reserva", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                ConsultaData agregarReserva = new ConsultaData();
                List<DetalleReserva> detallesReserva = new ArrayList<>();
                Reserva reserva = new Reserva();
                Habitacion habitacion = new Habitacion();
                Huesped huesped = agregarReserva.huespedPorDni(modeloCliente.getValueAt(jtCliente.getSelectedRow(), 2).toString());
                if (jdcDesde.getDate() != null || jdcHasta.getDate() != null) {
                    // Construir Reserva
                    reserva.setFechaEntrada(jdcDesde.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                    reserva.setFechaSalida(jdcHasta.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                    reserva.setCantidadDias((int) TimeUnit.DAYS.convert(jdcHasta.getDate().getTime() - jdcDesde.getDate().getTime(), TimeUnit.MILLISECONDS));
                    reserva.setCantidadPersonas(Integer.parseInt(jtfCantidadPersonasReserva.getText()));
                    reserva.setHuesped(huesped);
                    // Construir Detalle Reserva
                    int f = jtDetalleReserva.getRowCount() - 1;
                    for (int i = 0; i <= f; i++) {
                        DetalleReserva detalleReserva = new DetalleReserva();
                        detalleReserva.setIdDetalleReserva(reserva.getIdReserva());
                        detalleReserva.setHabitacion(agregarReserva.habitacionPorNumero((int) modeloDetalleReserva.getValueAt(i, 0)));
                        detallesReserva.add(detalleReserva);
                    }
                    agregarReserva.agregarReserva(reserva, detallesReserva);
                    limpiarFormulario();
                    borrarFilasDetalleReserva();
                    cargarHuesped();
                    cargarDisponibilidad();
                    
                } else {
                    JOptionPane.showMessageDialog(this, "Debe marcar una fecha de inicio y de final de la estadía.");
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Debe ingresar la cantidad de personas para la reserva.");
        }
        }else{
            JOptionPane.showMessageDialog(this, "No hay habitaciones en la Reserva.");
        }
    }//GEN-LAST:event_jbReservarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbAgregarHabitacion;
    private javax.swing.JButton jbAltaCliente;
    private javax.swing.JButton jbEliminarHabitacion;
    private javax.swing.JButton jbReservar;
    private com.toedter.calendar.JDateChooser jdcDesde;
    private com.toedter.calendar.JDateChooser jdcHasta;
    private javax.swing.JLabel jlReserva;
    private javax.swing.JTable jtCliente;
    private javax.swing.JTable jtDetalleReserva;
    private javax.swing.JTable jtDisponibilidad;
    private javax.swing.JTextField jtfCantPersonas;
    private javax.swing.JTextField jtfCantidadPersonasReserva;
    private javax.swing.JTextField jtfDni;
    private javax.swing.JTextField jtfPiso;
    // End of variables declaration//GEN-END:variables

    private void armarCabeceras() {
        // Establecer columnas de tablas
        modeloCliente.addColumn("Apellido");
        modeloCliente.addColumn("Nombre");
        modeloCliente.addColumn("DNI");
        modeloCliente.addColumn("Teléfono");
        modeloCliente.addColumn("e-mail");
        jtCliente.setModel(modeloCliente);

        modeloDisponibilidad.addColumn("N° Habitación");
        modeloDisponibilidad.addColumn("Código");
        modeloDisponibilidad.addColumn("Capacidad");
        modeloDisponibilidad.addColumn("Cant. Camas");
        modeloDisponibilidad.addColumn("Tipo de Camas");
        modeloDisponibilidad.addColumn("Precio Noche");
        jtDisponibilidad.setModel(modeloDisponibilidad);

        modeloDetalleReserva.addColumn("N° Habitación");
        modeloDetalleReserva.addColumn("Código");
        modeloDetalleReserva.addColumn("Capacidad");
        modeloDetalleReserva.addColumn("Cant. Camas");
        modeloDetalleReserva.addColumn("Tipo de Camas");
        modeloDetalleReserva.addColumn("Precio Noche");
        jtDetalleReserva.setModel(modeloDetalleReserva);

        //Establecer ancho de columnas
        jtCliente.getColumnModel().getColumn(0).setPreferredWidth(75);
        jtCliente.getColumnModel().getColumn(1).setPreferredWidth(75);
        jtCliente.getColumnModel().getColumn(2).setPreferredWidth(50);
        jtCliente.getColumnModel().getColumn(3).setPreferredWidth(50);
        jtCliente.getColumnModel().getColumn(4).setPreferredWidth(150);

        jtDisponibilidad.getColumnModel().getColumn(0).setPreferredWidth(75);
        jtDisponibilidad.getColumnModel().getColumn(1).setPreferredWidth(100);
        jtDisponibilidad.getColumnModel().getColumn(2).setPreferredWidth(75);
        jtDisponibilidad.getColumnModel().getColumn(3).setPreferredWidth(75);
        jtDisponibilidad.getColumnModel().getColumn(4).setPreferredWidth(150);
        jtDisponibilidad.getColumnModel().getColumn(5).setPreferredWidth(75);

        jtDetalleReserva.getColumnModel().getColumn(0).setPreferredWidth(75);
        jtDetalleReserva.getColumnModel().getColumn(1).setPreferredWidth(100);
        jtDetalleReserva.getColumnModel().getColumn(2).setPreferredWidth(75);
        jtDetalleReserva.getColumnModel().getColumn(3).setPreferredWidth(75);
        jtDetalleReserva.getColumnModel().getColumn(4).setPreferredWidth(150);
        jtDetalleReserva.getColumnModel().getColumn(5).setPreferredWidth(75);

        // Crear un renderizador de celdas para centrar el contenido
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i <= 4; i++) {
            jtCliente.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        for (int i = 0; i <= 5; i++) {
            jtDisponibilidad.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            jtDetalleReserva.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    private void cargarIcono() {
        ImageIcon icono = new ImageIcon("image/reserva.png");
        Image scaledImage = icono.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        setFrameIcon(scaledIcon);
    }

    private void borrarFilasCliente() {
        int f = jtCliente.getRowCount() - 1;
        for (; f >= 0; f--) {
            modeloCliente.removeRow(f);
        }
    }

    private void borrarFilasDisponibilidad() {
        int f = jtDisponibilidad.getRowCount() - 1;
        for (; f >= 0; f--) {
            modeloDisponibilidad.removeRow(f);
        }
    }

    private void borrarFilasDetalleReserva() {
        int f = jtDetalleReserva.getRowCount() - 1;
        for (; f >= 0; f--) {
            modeloDetalleReserva.removeRow(f);
        }
    }

    private void cargarHuesped() {
        jbAgregarHabitacion.setEnabled(false);
        List<Huesped> huespedes = new ArrayList<>();
        ConsultaData listarHuesped = new ConsultaData();
        huespedes = listarHuesped.listarHuespedes();
        borrarFilasCliente();
        for (Huesped huesped : huespedes) {
            if (huesped.getDni().startsWith(jtfDni.getText())) {
                modeloCliente.addRow(new Object[]{
                    huesped.getApellido(),
                    huesped.getNombre(),
                    huesped.getDni(),
                    huesped.getTelefono(),
                    huesped.getEmail()
                });
            }
        }
    }

    private void cargarDisponibilidad() {
        List<Habitacion> habitacionesDisponibles = new ArrayList<>();
        ConsultaData consultarDisponibilidad = new ConsultaData();
        LocalDate desde, hasta;
        if (jdcDesde.getDate() == null || jdcHasta.getDate() == null) {
            desde = LocalDate.now();
            hasta = LocalDate.now();
        } else {
            desde = jdcDesde.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            hasta = jdcHasta.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
        habitacionesDisponibles = consultarDisponibilidad.listarDisponibilidad(desde, hasta);
        borrarFilasDisponibilidad();
        for (Habitacion habitacion : habitacionesDisponibles) {
            if (String.valueOf(habitacion.getTipoHabitacion().getCapacidad()).startsWith(jtfCantPersonas.getText()) && String.valueOf(habitacion.getPiso()).startsWith(jtfPiso.getText())) {
                modeloDisponibilidad.addRow(new Object[]{
                    habitacion.getNumero(),
                    habitacion.getTipoHabitacion().getCodigo(),
                    habitacion.getTipoHabitacion().getCapacidad(),
                    habitacion.getTipoHabitacion().getCantidadCamas(),
                    habitacion.getTipoHabitacion().getTipoCamas(),
                    habitacion.getTipoHabitacion().getPrecioNoche()
                });
            }
        }
    }

    private void capturarClikEnTabla() {
        //Capturar clik en tabla Huesped
        jtCliente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jbAgregarHabitacion.setEnabled(true);
            }
        });
    }
    
    private void limpiarFormulario(){
        jtfDni.setText("");
        jtfCantidadPersonasReserva.setText("");
        jtfCantPersonas.setText("");
        jtfPiso.setText("");
    }
    
    private void cargarImagenReserva() {
        // Cargar la imagen desde un archivo (reemplaza la URL con la ubicación de tu imagen)
        ImageIcon imageIcon = new ImageIcon("image/reserva.png");

        if (imageIcon != null) {
            // Obtener el icono de imagen y redimensionarlo al tamaño del JLabel
            Image img = imageIcon.getImage();
            int ancho = 100;
            int alto = 100;
            Image nuevaImagen = img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

            // Establecer la imagen redimensionada en el JLabel
            ImageIcon iconoRedimensionado = new ImageIcon(nuevaImagen);
            jlReserva.setIcon(iconoRedimensionado);
        }

    }
    
}
