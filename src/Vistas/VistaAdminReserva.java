package Vistas;

import AccesoDatos.ConsultaData;
import Entidades.DetalleReserva;
import Entidades.Estado;
import Entidades.Huesped;
import Entidades.Reserva;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class VistaAdminReserva extends javax.swing.JInternalFrame {

    private DefaultTableModel modeloReserva = new DefaultTableModel() {
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

    private DefaultTableModel modeloCliente = new DefaultTableModel() {
        //No permitir edicion de columnas
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public VistaAdminReserva() {
        initComponents();
        cargarIcono();
        armarCabeceras();
        capturarClikEnTablaReserva();
        capturarClikEnTablaCliente();
        cargarCliente();
        cargarReservas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcCalendario = new com.toedter.calendar.JCalendar();
        label1 = new java.awt.Label();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfApellido = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfDni = new javax.swing.JTextField();
        jmcMes = new com.toedter.calendar.JMonthChooser();
        jycAño = new com.toedter.calendar.JYearChooser();
        jcbMesAño = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtCliente = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtReservasActivas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtDetalleReservas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jbAnularReserva = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        setTitle("Administración de Reservas");
        setMaximumSize(new java.awt.Dimension(865, 500));
        setMinimumSize(new java.awt.Dimension(865, 500));
        setPreferredSize(new java.awt.Dimension(865, 500));

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label1.setText("Administración de Reservas");

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setText("Apellido:");

        jtfApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfApellidoKeyReleased(evt);
            }
        });

        jLabel2.setText("DNI:");

        jtfDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfDniKeyReleased(evt);
            }
        });

        jmcMes.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jmcMesPropertyChange(evt);
            }
        });

        jycAño.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jycAñoPropertyChange(evt);
            }
        });

        jcbMesAño.setText("Filtro Mes/Año");
        jcbMesAño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMesAñoActionPerformed(evt);
            }
        });

        jtCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "DNI", "Télefono"
            }
        ));
        jtCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtClienteKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jtCliente);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfApellido)
                    .addComponent(jtfDni, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                        .addComponent(jmcMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jycAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbMesAño)
                        .addGap(32, 32, 32)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jtfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jmcMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbMesAño)
                    .addComponent(jycAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jtfDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jtReservasActivas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Entrada", "Salida", "Estadía", "Personas", "Costo"
            }
        ));
        jtReservasActivas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtReservasActivasKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtReservasActivas);

        jtDetalleReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Número", "Piso", "Codigo", "Capacidad", "Cantidad Camas", "Tipo Camas", "Precio Noche"
            }
        ));
        jScrollPane2.setViewportView(jtDetalleReservas);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Reservas");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Detalles");

        jbAnularReserva.setText("Anular");
        jbAnularReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnularReservaActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jcCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jbAnularReserva)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSalir)
                .addGap(193, 193, 193))
            .addGroup(layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(222, 222, 222))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalir)
                    .addComponent(jbAnularReserva))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jtfApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfApellidoKeyReleased
        jtfDni.setText("");
        cargarCliente();
        cargarReservas();
    }//GEN-LAST:event_jtfApellidoKeyReleased

    private void jtfDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDniKeyReleased
        //jlCliente.setText("");
        cargarCliente();
        cargarReservas();
    }//GEN-LAST:event_jtfDniKeyReleased

    private void jmcMesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jmcMesPropertyChange
        if (jcbMesAño.isSelected()) {
            LocalDate nuevaFecha = LocalDate.of(jycAño.getYear(), jmcMes.getMonth() + 1, 1);
            jcCalendario.setDate(Date.valueOf(nuevaFecha));
            cargarReservas();

        } else {
            LocalDate nuevaFecha = LocalDate.of(jycAño.getYear(), jmcMes.getMonth() + 1, 1);
            jcCalendario.setDate(Date.valueOf(nuevaFecha));

        }
    }//GEN-LAST:event_jmcMesPropertyChange

    private void jycAñoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jycAñoPropertyChange
        if (jcbMesAño.isSelected()) {
            LocalDate nuevaFecha = LocalDate.of(jycAño.getYear(), jmcMes.getMonth() + 1, 1);
            jcCalendario.setDate(Date.valueOf(nuevaFecha));
            cargarReservas();
        } else {
            LocalDate nuevaFecha = LocalDate.of(jycAño.getYear(), jmcMes.getMonth() + 1, 1);
            jcCalendario.setDate(Date.valueOf(nuevaFecha));
        }
    }//GEN-LAST:event_jycAñoPropertyChange

    private void jtReservasActivasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtReservasActivasKeyReleased
        cargarHuespedPorIdReserva();
        cargarCliente();
        cargarDetallesReserva();

    }//GEN-LAST:event_jtReservasActivasKeyReleased

    private void jcbMesAñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMesAñoActionPerformed
        //jlCliente.setText("");
        cargarReservas();
    }//GEN-LAST:event_jcbMesAñoActionPerformed

    private void jbAnularReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnularReservaActionPerformed
        if (jtReservasActivas.getSelectedRow() != -1) {
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Esta seguro que quiere anular la Reserva?", "Confirmar Reserva", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                ConsultaData eliminarReserva = new ConsultaData();
                eliminarReserva.eliminarReserva((int) modeloReserva.getValueAt(jtReservasActivas.getSelectedRow(), 0));
                borrarFilasDetalleReservas();
                cargarReservas();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una reserva a anular.");
        }
    }//GEN-LAST:event_jbAnularReservaActionPerformed

    private void jtClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtClienteKeyReleased
        cargarClientePorDni();
        cargarReservas();
    }//GEN-LAST:event_jtClienteKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbAnularReserva;
    private javax.swing.JButton jbSalir;
    private com.toedter.calendar.JCalendar jcCalendario;
    private javax.swing.JCheckBox jcbMesAño;
    private com.toedter.calendar.JMonthChooser jmcMes;
    private javax.swing.JTable jtCliente;
    private javax.swing.JTable jtDetalleReservas;
    private javax.swing.JTable jtReservasActivas;
    private javax.swing.JTextField jtfApellido;
    private javax.swing.JTextField jtfDni;
    private com.toedter.calendar.JYearChooser jycAño;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables

    private void armarCabeceras() {
        // Establecer columnas de tablas
        modeloReserva.addColumn("ID");
        modeloReserva.addColumn("Entrada");
        modeloReserva.addColumn("Salida");
        modeloReserva.addColumn("Estadia");
        modeloReserva.addColumn("Personas");
        modeloReserva.addColumn("Costo");
        jtReservasActivas.setModel(modeloReserva);

        modeloDetalleReserva.addColumn("Número");
        modeloDetalleReserva.addColumn("Piso");
        modeloDetalleReserva.addColumn("Código");
        modeloDetalleReserva.addColumn("Capacidad");
        modeloDetalleReserva.addColumn("Camas");
        modeloDetalleReserva.addColumn("Tipo Camas");
        modeloDetalleReserva.addColumn("Precio Noche");
        jtDetalleReservas.setModel(modeloDetalleReserva);

        modeloCliente.addColumn("Nombre");
        modeloCliente.addColumn("Apellido");
        modeloCliente.addColumn("DNI");
        modeloCliente.addColumn("Teléfono");
        jtCliente.setModel(modeloCliente);

        //Establecer ancho de columnas
        jtReservasActivas.getColumnModel().getColumn(0).setPreferredWidth(75);
        jtReservasActivas.getColumnModel().getColumn(1).setPreferredWidth(100);
        jtReservasActivas.getColumnModel().getColumn(2).setPreferredWidth(100);
        jtReservasActivas.getColumnModel().getColumn(3).setPreferredWidth(75);
        jtReservasActivas.getColumnModel().getColumn(4).setPreferredWidth(75);
        jtReservasActivas.getColumnModel().getColumn(5).setPreferredWidth(100);

        jtDetalleReservas.getColumnModel().getColumn(0).setPreferredWidth(75);
        jtDetalleReservas.getColumnModel().getColumn(1).setPreferredWidth(75);
        jtDetalleReservas.getColumnModel().getColumn(2).setPreferredWidth(100);
        jtDetalleReservas.getColumnModel().getColumn(3).setPreferredWidth(100);
        jtDetalleReservas.getColumnModel().getColumn(4).setPreferredWidth(75);
        jtDetalleReservas.getColumnModel().getColumn(5).setPreferredWidth(150);
        jtDetalleReservas.getColumnModel().getColumn(6).setPreferredWidth(125);

        jtCliente.getColumnModel().getColumn(0).setPreferredWidth(100);
        jtCliente.getColumnModel().getColumn(1).setPreferredWidth(100);
        jtCliente.getColumnModel().getColumn(2).setPreferredWidth(100);
        jtCliente.getColumnModel().getColumn(3).setPreferredWidth(100);

        // Crear un renderizador de celdas para centrar el contenido
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i <= 5; i++) {
            jtReservasActivas.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        for (int i = 0; i <= 6; i++) {
            jtDetalleReservas.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        for (int i = 0; i <= 3; i++) {
            jtCliente.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    private void cargarIcono() {
        ImageIcon icono = new ImageIcon("image/reserva.png");
        Image scaledImage = icono.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        setFrameIcon(scaledIcon);
    }

    private void capturarClikEnTablaReserva() {
        //Capturar clik en tabla Huesped
        jtReservasActivas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cargarHuespedPorIdReserva();
                cargarCliente();
                cargarDetallesReserva();
            }
        });
    }

    private void capturarClikEnTablaCliente() {
        //Capturar clik en tabla Huesped
        jtCliente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cargarClientePorDni();
                cargarReservas();
            }
        });
    }

    private void borrarFilasReserva() {
        int f = jtReservasActivas.getRowCount() - 1;
        for (; f >= 0; f--) {
            modeloReserva.removeRow(f);
        }
    }

    private void borrarFilasDetalleReservas() {
        int f = jtDetalleReservas.getRowCount() - 1;
        for (; f >= 0; f--) {
            modeloDetalleReserva.removeRow(f);
        }
    }

    private void borrarFilasCliente() {
        int f = jtCliente.getRowCount() - 1;
        for (; f >= 0; f--) {
            modeloCliente.removeRow(f);
        }
    }

    public void cargarReservas() {
        List<Reserva> reservas = new ArrayList<>();
        ConsultaData listarReservas = new ConsultaData();
        reservas = listarReservas.listarReservas();
        borrarFilasDetalleReservas();
        borrarFilasReserva();
        for (Reserva reserva : reservas) {
            if (jtCliente.getSelectedRow() != -1) {
                if (!jcbMesAño.isSelected()) {
                    if (reserva.getEstado() == Estado.Activa && reserva.getHuesped().getApellido().toLowerCase().startsWith(modeloCliente.getValueAt(jtCliente.getSelectedRow(), 0).toString().toLowerCase()) && reserva.getHuesped().getDni().startsWith(modeloCliente.getValueAt(jtCliente.getSelectedRow(), 2).toString().toLowerCase())) {
                        modeloReserva.addRow(new Object[]{
                            reserva.getIdReserva(),
                            reserva.getFechaEntrada(),
                            reserva.getFechaSalida(),
                            reserva.getCantidadDias(),
                            reserva.getCantidadPersonas(),
                            reserva.getMontoEstadia()
                        });
                    }
                } else {
                    if (reserva.getFechaEntrada().getMonthValue() == (jmcMes.getMonth() + 1) && reserva.getEstado() == Estado.Activa && reserva.getHuesped().getApellido().toLowerCase().startsWith(modeloCliente.getValueAt(jtCliente.getSelectedRow(), 0).toString().toLowerCase()) && reserva.getHuesped().getDni().startsWith(modeloCliente.getValueAt(jtCliente.getSelectedRow(), 2).toString().toLowerCase())) {
                        modeloReserva.addRow(new Object[]{
                            reserva.getIdReserva(),
                            reserva.getFechaEntrada(),
                            reserva.getFechaSalida(),
                            reserva.getCantidadDias(),
                            reserva.getCantidadPersonas(),
                            reserva.getMontoEstadia()
                        });
                    }
                }
            } else {
                if (!jcbMesAño.isSelected()) {
                    if (reserva.getEstado() == Estado.Activa && reserva.getHuesped().getApellido().toLowerCase().startsWith(jtfApellido.getText().toLowerCase()) && reserva.getHuesped().getDni().startsWith(jtfDni.getText())) {
                        modeloReserva.addRow(new Object[]{
                            reserva.getIdReserva(),
                            reserva.getFechaEntrada(),
                            reserva.getFechaSalida(),
                            reserva.getCantidadDias(),
                            reserva.getCantidadPersonas(),
                            reserva.getMontoEstadia()
                        });
                    }
                } else {
                    if (reserva.getFechaEntrada().getMonthValue() == (jmcMes.getMonth() + 1) && reserva.getFechaEntrada().getYear() == jycAño.getYear() && reserva.getEstado() == Estado.Activa && reserva.getHuesped().getApellido().toLowerCase().startsWith(jtfApellido.getText().toLowerCase()) && reserva.getHuesped().getDni().startsWith(jtfDni.getText())) {
                        modeloReserva.addRow(new Object[]{
                            reserva.getIdReserva(),
                            reserva.getFechaEntrada(),
                            reserva.getFechaSalida(),
                            reserva.getCantidadDias(),
                            reserva.getCantidadPersonas(),
                            reserva.getMontoEstadia()
                        });
                    }
                }
            }
        }
    }

    public void cargarDetallesReserva() {
        List<DetalleReserva> detallesReserva = new ArrayList<>();
        Reserva reserva = new Reserva();
        ConsultaData listarDetallesReserva = new ConsultaData();
        detallesReserva = listarDetallesReserva.listarDetalleReserva();
        reserva = listarDetallesReserva.reservaPorIdReserva((int) modeloReserva.getValueAt(jtReservasActivas.getSelectedRow(), 0));
        //jlCliente.setText(reserva.getHuesped().getApellido() + ", " + reserva.getHuesped().getNombre() + " - DNI: " + reserva.getHuesped().getDni());
        borrarFilasDetalleReservas();
        for (DetalleReserva detalleReserva : detallesReserva) {
            if (detalleReserva.getReserva().getIdReserva() == (int) modeloReserva.getValueAt(jtReservasActivas.getSelectedRow(), 0)) {
                modeloDetalleReserva.addRow(new Object[]{
                    detalleReserva.getHabitacion().getNumero(),
                    detalleReserva.getHabitacion().getPiso(),
                    detalleReserva.getHabitacion().getTipoHabitacion().getCodigo(),
                    detalleReserva.getHabitacion().getTipoHabitacion().getCapacidad(),
                    detalleReserva.getHabitacion().getTipoHabitacion().getCantidadCamas(),
                    detalleReserva.getHabitacion().getTipoHabitacion().getTipoCamas(),
                    detalleReserva.getHabitacion().getTipoHabitacion().getPrecioNoche()
                });
            }
        }

    }

    private void cargarCliente() {
        List<Huesped> huespedes = new ArrayList<>();
        ConsultaData listarHuesped = new ConsultaData();
        huespedes = listarHuesped.listarHuespedes();
        borrarFilasCliente();
        for (Huesped huesped : huespedes) {
            if (huesped.getApellido().toLowerCase().startsWith(jtfApellido.getText().toLowerCase()) && huesped.getDni().toLowerCase().startsWith(jtfDni.getText().toLowerCase())) {
                modeloCliente.addRow(new Object[]{
                    huesped.getApellido(),
                    huesped.getNombre(),
                    huesped.getDni(),
                    huesped.getTelefono(), //huesped.getEmail()
                });
            }

        }
    }

    private void cargarHuespedPorIdReserva() {
        Reserva reserva = new Reserva();
        ConsultaData consultaHuesped = new ConsultaData();
        reserva = consultaHuesped.reservaPorIdReserva((int) modeloReserva.getValueAt(jtReservasActivas.getSelectedRow(), 0));
        jtfApellido.setText(reserva.getHuesped().getApellido());
        jtfDni.setText(reserva.getHuesped().getDni());
    }

    private void cargarClientePorDni() {
        Huesped huesped = new Huesped();
        ConsultaData consultaHuesped = new ConsultaData();
        huesped = consultaHuesped.huespedPorDni(String.valueOf(modeloCliente.getValueAt(jtCliente.getSelectedRow(), 2)));
        jtfApellido.setText(huesped.getApellido());
        jtfDni.setText(huesped.getDni());
    }
}
