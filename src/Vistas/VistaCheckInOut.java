package Vistas;

import AccesoDatos.ConsultaData;
import Entidades.DetalleReserva;
import Entidades.Estado;
import Entidades.Huesped;
import Entidades.Reserva;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class VistaCheckInOut extends javax.swing.JInternalFrame {

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

    public VistaCheckInOut() {
        initComponents();
        cargarIcono();
        armarCabeceras();
        jbCheckIn.setEnabled(false);
        jbCheckOut.setEnabled(false);
        cargarFecha();
        jdcFecha.setEnabled(false);
        //cargarCliente();
        cargarReservas();
        capturarClikEnTablaCliente();
        capturarClikEnTablaReserva();
        cargarImagenCheckInOut();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfDni = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtCliente = new javax.swing.JTable();
        jcbIn = new javax.swing.JCheckBox();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtReservasActivas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtDetalleReservas = new javax.swing.JTable();
        jbCheckIn = new javax.swing.JButton();
        jbCheckOut = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jlIn = new javax.swing.JLabel();
        jlOut = new javax.swing.JLabel();
        jlCheckInOut = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Huéspedes");

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setText("Apellido:");

        jtfApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfApellidoKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cliente");

        jLabel4.setText("DNI:");

        jtfDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfDniKeyReleased(evt);
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

        jcbIn.setText("CheckIn");
        jcbIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfDni, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jcbIn)
                        .addGap(18, 18, 18)
                        .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jtfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jtfDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbIn))
                    .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Reservas");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Detalles");

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

        jbCheckIn.setText("CheckIn");
        jbCheckIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCheckInActionPerformed(evt);
            }
        });

        jbCheckOut.setText("CheckOut");
        jbCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCheckOutActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jlIn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jlOut.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbSalir)
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 415, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(245, 245, 245))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbCheckOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbCheckIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlOut)
                            .addComponent(jlIn))
                        .addGap(33, 33, 33)
                        .addComponent(jlCheckInOut, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jbCheckIn)
                                    .addComponent(jlIn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jbCheckOut)
                                    .addComponent(jlOut)))
                            .addComponent(jlCheckInOut, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbSalir)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtReservasActivasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtReservasActivasKeyReleased
        cargarDetallesReserva();
    }//GEN-LAST:event_jtReservasActivasKeyReleased

    private void jtClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtClienteKeyReleased
        cargarReservas();
    }//GEN-LAST:event_jtClienteKeyReleased

    private void jtfApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfApellidoKeyReleased
        cargarReservas();
        jtfDni.setText("");
    }//GEN-LAST:event_jtfApellidoKeyReleased

    private void jtfDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDniKeyReleased
        cargarReservas();
    }//GEN-LAST:event_jtfDniKeyReleased

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jcbInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbInActionPerformed
        cargarReservas();
    }//GEN-LAST:event_jcbInActionPerformed

    private void jbCheckInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCheckInActionPerformed
        Reserva reservaIn = new Reserva();
        ConsultaData checkIn = new ConsultaData();
        reservaIn = checkIn.reservaPorIdReserva((int) modeloReserva.getValueAt(jtReservasActivas.getSelectedRow(), 0));
        reservaIn.setCheckIn(jdcFecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        checkIn.modificarReserva(reservaIn);
        cargarReservas();

    }//GEN-LAST:event_jbCheckInActionPerformed

    private void jbCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCheckOutActionPerformed
        Reserva reservaOut = new Reserva();
        ConsultaData checkOut = new ConsultaData();
        reservaOut = checkOut.reservaPorIdReserva((int) modeloReserva.getValueAt(jtReservasActivas.getSelectedRow(), 0));
        reservaOut.setCheckOut(jdcFecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        reservaOut.setEstado(Estado.Inactiva);
        checkOut.modificarReserva(reservaOut);
        jtfApellido.setText("");
        jtfDni.setText("");
        cargarReservas();
    }//GEN-LAST:event_jbCheckOutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbCheckIn;
    private javax.swing.JButton jbCheckOut;
    private javax.swing.JButton jbSalir;
    private javax.swing.JCheckBox jcbIn;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JLabel jlCheckInOut;
    private javax.swing.JLabel jlIn;
    private javax.swing.JLabel jlOut;
    private javax.swing.JTable jtCliente;
    private javax.swing.JTable jtDetalleReservas;
    private javax.swing.JTable jtReservasActivas;
    private javax.swing.JTextField jtfApellido;
    private javax.swing.JTextField jtfDni;
    // End of variables declaration//GEN-END:variables
private void cargarIcono() {
        ImageIcon icono = new ImageIcon("image/checkInOut.png");
        Image scaledImage = icono.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        setFrameIcon(scaledIcon);
    }

    private void armarCabeceras() {
        // Establecer columnas de tablas
        modeloReserva.addColumn("ID");
        modeloReserva.addColumn("Entrada");
        modeloReserva.addColumn("Salida");
        modeloReserva.addColumn("Estadia");
        modeloReserva.addColumn("Personas");
        modeloReserva.addColumn("Costo");
        modeloReserva.addColumn("C.In");
        modeloReserva.addColumn("C.Out");
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
        jtReservasActivas.getColumnModel().getColumn(6).setPreferredWidth(100);
        jtReservasActivas.getColumnModel().getColumn(7).setPreferredWidth(100);

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
        for (int i = 0; i <= 7; i++) {
            jtReservasActivas.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        for (int i = 0; i <= 6; i++) {
            jtDetalleReservas.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        for (int i = 0; i <= 3; i++) {
            jtCliente.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

    }

    private void capturarClikEnTablaReserva() {
        //Capturar clik en tabla Huesped
        jtReservasActivas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                jbCheckIn.setEnabled(false);
                jbCheckOut.setEnabled(false);
                cargarDetallesReserva();
                cargarHuespedPorIdReserva();
                //cargarReservas();
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
                jbCheckIn.setEnabled(false);
                jbCheckOut.setEnabled(false);
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
        jlIn.setText("");
        jbCheckOut.setEnabled(false);
        List<Reserva> reservas = new ArrayList<>();
        ConsultaData listarReservas = new ConsultaData();
        reservas = listarReservas.listarReservas();
        borrarFilasDetalleReservas();
        borrarFilasReserva();
        borrarFilasCliente();
        for (Reserva reserva : reservas) {
            if (jcbIn.isSelected()) {

                if (reserva.getEstado() == Estado.Activa && reserva.getHuesped().getApellido().toLowerCase().startsWith(jtfApellido.getText().toLowerCase()) && reserva.getHuesped().getDni().startsWith(jtfDni.getText().toLowerCase()) && reserva.getCheckIn() != null) {
                    modeloReserva.addRow(new Object[]{
                        reserva.getIdReserva(),
                        reserva.getFechaEntrada(),
                        reserva.getFechaSalida(),
                        reserva.getCantidadDias(),
                        reserva.getCantidadPersonas(),
                        reserva.getMontoEstadia(),
                        reserva.getCheckIn(),
                        reserva.getCheckOut()
                    });
                }
                boolean huespedReserva = false;
                int f = jtCliente.getRowCount() - 1;
                for (; f >= 0; f--) {
                    if (modeloCliente.getValueAt(f, 2).equals(reserva.getHuesped().getDni())) {
                        huespedReserva = true;
                    }
                }
                if (reserva.getEstado() == Estado.Activa && reserva.getHuesped().getApellido().toLowerCase().startsWith(jtfApellido.getText().toLowerCase()) && reserva.getHuesped().getDni().toLowerCase().startsWith(jtfDni.getText().toLowerCase()) && reserva.getCheckIn() != null && !huespedReserva) {
                    modeloCliente.addRow(new Object[]{
                        reserva.getHuesped().getApellido(),
                        reserva.getHuesped().getNombre(),
                        reserva.getHuesped().getDni(),
                        reserva.getHuesped().getTelefono(),});
                }

            } else {
                if (reserva.getEstado() == Estado.Activa && reserva.getHuesped().getApellido().toLowerCase().startsWith(jtfApellido.getText().toLowerCase()) && reserva.getHuesped().getDni().startsWith(jtfDni.getText().toLowerCase())) {
                    modeloReserva.addRow(new Object[]{
                        reserva.getIdReserva(),
                        reserva.getFechaEntrada(),
                        reserva.getFechaSalida(),
                        reserva.getCantidadDias(),
                        reserva.getCantidadPersonas(),
                        reserva.getMontoEstadia(),
                        reserva.getCheckIn(),
                        reserva.getCheckOut()
                    });
                }

                boolean huespedReserva = false;
                int f = jtCliente.getRowCount() - 1;
                if (jtCliente.getRowCount() != -1) {
                    for (; f >= 0; f--) {
                        if (modeloCliente.getValueAt(f, 2).equals(reserva.getHuesped().getDni())) {
                            huespedReserva = true;
                        }
                    }
                }
                if (reserva.getEstado() == Estado.Activa && reserva.getHuesped().getApellido().toLowerCase().startsWith(jtfApellido.getText().toLowerCase()) && reserva.getHuesped().getDni().toLowerCase().startsWith(jtfDni.getText().toLowerCase()) && !huespedReserva) {
                    modeloCliente.addRow(new Object[]{
                        reserva.getHuesped().getApellido(),
                        reserva.getHuesped().getNombre(),
                        reserva.getHuesped().getDni(),
                        reserva.getHuesped().getTelefono(),});
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

        if (modeloReserva.getValueAt(jtReservasActivas.getSelectedRow(), 6) != null) {
            jlIn.setText(modeloReserva.getValueAt(jtReservasActivas.getSelectedRow(), 6).toString());
        } else {
            if (Date.valueOf(reserva.getFechaEntrada()).after(jdcFecha.getDate()) || Date.valueOf(reserva.getFechaEntrada()).equals(jdcFecha.getDate())) {
                jbCheckIn.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "La fecha de Check In es posterior a la reserva.");
                jbCheckIn.setEnabled(true);
            }
        }
        if (modeloReserva.getValueAt(jtReservasActivas.getSelectedRow(), 7) != null) {
            jlOut.setText(modeloReserva.getValueAt(jtReservasActivas.getSelectedRow(), 7).toString());
        } else {
            if ((Date.valueOf(reserva.getFechaSalida()).after(jdcFecha.getDate()) || Date.valueOf(reserva.getFechaSalida()).equals(jdcFecha.getDate())) && modeloReserva.getValueAt(jtReservasActivas.getSelectedRow(), 6) != null) {
                jbCheckOut.setEnabled(true);
            } else {
                //JOptionPane.showMessageDialog(this, "La fecha de Check Out difiere a la reserva.");
                //jbCheckOut.setEnabled(true);
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

    private void cargarFecha() {
        jdcFecha.setDate(Date.valueOf(LocalDate.now()));
    }
    
    private void cargarImagenCheckInOut(){
    // Cargar la imagen desde un archivo (reemplaza la URL con la ubicación de tu imagen)
        ImageIcon imageIcon = new ImageIcon("image/checkInOut.png");

        if (imageIcon != null) {
            // Obtener el icono de imagen y redimensionarlo al tamaño del JLabel
            Image img = imageIcon.getImage();
            int ancho = 100;
            int alto = 100;
            Image nuevaImagen = img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

            // Establecer la imagen redimensionada en el JLabel
            ImageIcon iconoRedimensionado = new ImageIcon(nuevaImagen);
            jlCheckInOut.setIcon(iconoRedimensionado);
        }
    
    }
    
}
