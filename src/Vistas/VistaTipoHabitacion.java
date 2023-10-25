package Vistas;

import AccesoDatos.ConsultaData;
import Entidades.TipoHabitacion;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class VistaTipoHabitacion extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        //No permitir edicion de columnas
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public VistaTipoHabitacion() {
        initComponents();
        armarCabeceras();
        // Asignar icono a InternalFrame
        ImageIcon icono = new ImageIcon("image/habitacion.png");
        Image scaledImage = icono.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        setFrameIcon(scaledIcon);
        // Cargar tabla Tipo Habitaciones
        cargarTiposHabitacion();
        // Cambiar texto Boton Guardar
        jbGuardar.setText("Nuevo");
        // Capturar clik en tabla
        jtTiposHabitacion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cargarFormulario();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jtfCodigo = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTiposHabitacion = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfECodigo = new javax.swing.JTextField();
        jtfECapacidad = new javax.swing.JTextField();
        jtfECantidadCamas = new javax.swing.JTextField();
        jtfETiposCamas = new javax.swing.JTextField();
        jtfEPrecioNoche = new javax.swing.JTextField();
        jbGuardar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setTitle("Tipos de Habitación");
        setMinimumSize(new java.awt.Dimension(800, 360));
        setPreferredSize(new java.awt.Dimension(800, 360));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tipos de Habitación");

        jLabel2.setText("Código:");

        jtfCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfCodigoKeyReleased(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jtTiposHabitacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Capacidad", "Cant. Camas", "Tipo de Camas", "Precio Noche"
            }
        ));
        jtTiposHabitacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtTiposHabitacionKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtTiposHabitacion);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel3.setText("Código:");

        jLabel4.setText("Capacidad:");

        jLabel5.setText("Cant. Camas:");

        jLabel6.setText("Tipos de Camas:");

        jLabel7.setText("Precio por Noche:");

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfECodigo)
                            .addComponent(jtfECapacidad)
                            .addComponent(jtfECantidadCamas)
                            .addComponent(jtfETiposCamas)
                            .addComponent(jtfEPrecioNoche, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jbGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbEliminar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfECodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfECapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfECantidadCamas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfETiposCamas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtfEPrecioNoche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jbEliminar))
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodigoKeyReleased
        cargarTiposHabitacion();
        borrarFormulario();
    }//GEN-LAST:event_jtfCodigoKeyReleased

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        try {
            if (!(jtfECodigo.getText().isEmpty() || jtfECapacidad.getText().isEmpty() || jtfECantidadCamas.getText().isEmpty() || jtfETiposCamas.getText().isEmpty() || jtfEPrecioNoche.getText().isEmpty())) {
                TipoHabitacion tipoHabitacion = new TipoHabitacion();
                ConsultaData actualizarTipoHabitacion = new ConsultaData();

                if (jtTiposHabitacion.getSelectedRow() != -1) {
                    // Armar el Tipo Habitación a actualizar
                    tipoHabitacion.setIdTipoHabitacion(actualizarTipoHabitacion.idTipoHabitacionPorCodigo(jtfECodigo.getText()));
                    tipoHabitacion.setCodigo(jtfECodigo.getText());
                    tipoHabitacion.setCapacidad(Integer.parseInt(jtfECapacidad.getText()));
                    tipoHabitacion.setCantidadCamas(Integer.parseInt(jtfECantidadCamas.getText()));
                    tipoHabitacion.setTipoCamas(jtfETiposCamas.getText());
                    tipoHabitacion.setPrecioNoche(Double.parseDouble(jtfEPrecioNoche.getText()));

                    // Realizar update del Tpo de Habitación
                    actualizarTipoHabitacion.modificarTipoHabitacion(tipoHabitacion);
                } else {
                    tipoHabitacion.setCodigo(jtfECodigo.getText());
                    tipoHabitacion.setCapacidad(Integer.parseInt(jtfECapacidad.getText()));
                    tipoHabitacion.setCantidadCamas(Integer.parseInt(jtfECantidadCamas.getText()));
                    tipoHabitacion.setTipoCamas(jtfETiposCamas.getText());
                    tipoHabitacion.setPrecioNoche(Double.parseDouble(jtfEPrecioNoche.getText()));

                    // Insertar un Tpo de Habitación
                    actualizarTipoHabitacion.agregarTipoHabitacion(tipoHabitacion);
                }
                borrarFormulario();
                cargarTiposHabitacion();
            } else {
                JOptionPane.showMessageDialog(this, "Debe ingresar todos los datos para agregar o actualizar un Tipo de Habitación.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Debe ingresar campos numericos válidos para \nCapacidad, Cantidad Camas y Precio por Nonche.");
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        if (jtTiposHabitacion.getSelectedRow() != -1) {
            ConsultaData eliminarTipoHabitacion = new ConsultaData();
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar ese Tipo de Habitación?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                int idTipoHabitacion = eliminarTipoHabitacion.idTipoHabitacionPorCodigo(jtfECodigo.getText());
                eliminarTipoHabitacion.eliminarTipoHabitacion(idTipoHabitacion);
                cargarTiposHabitacion();
                borrarFormulario();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un Tipo Habitación de la tabla para eliminar.");
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jtTiposHabitacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtTiposHabitacionKeyReleased
        cargarFormulario();
    }//GEN-LAST:event_jtTiposHabitacionKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JTable jtTiposHabitacion;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfECantidadCamas;
    private javax.swing.JTextField jtfECapacidad;
    private javax.swing.JTextField jtfECodigo;
    private javax.swing.JTextField jtfEPrecioNoche;
    private javax.swing.JTextField jtfETiposCamas;
    // End of variables declaration//GEN-END:variables

    private void armarCabeceras() {
        modelo.addColumn("Código");
        modelo.addColumn("Capacidad");
        modelo.addColumn("Cant. Camas");
        modelo.addColumn("Tipo de Camas");
        modelo.addColumn("Precio Noche");

        jtTiposHabitacion.setModel(modelo);

        //Establecer ancho de columnas
        jtTiposHabitacion.getColumnModel().getColumn(0).setPreferredWidth(100);
        jtTiposHabitacion.getColumnModel().getColumn(1).setPreferredWidth(75);
        jtTiposHabitacion.getColumnModel().getColumn(2).setPreferredWidth(75);
        jtTiposHabitacion.getColumnModel().getColumn(3).setPreferredWidth(150);
        jtTiposHabitacion.getColumnModel().getColumn(4).setPreferredWidth(75);

        // Crear un renderizador de celdas para centrar el contenido
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i <= 4; i++) {
            jtTiposHabitacion.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    private void borrarFilas() {
        int f = jtTiposHabitacion.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }

    private void cargarTiposHabitacion() {
        List<TipoHabitacion> tipoHabitaciones = new ArrayList<>();
        ConsultaData listarTipoHabitaciones = new ConsultaData();
        tipoHabitaciones = listarTipoHabitaciones.listarTipoHabitacion();
        borrarFilas();
        for (TipoHabitacion tipoHhabitacion : tipoHabitaciones) {
            if (tipoHhabitacion.getCodigo().toLowerCase().startsWith(jtfCodigo.getText().toLowerCase())) {
                modelo.addRow(new Object[]{
                    tipoHhabitacion.getCodigo(),
                    tipoHhabitacion.getCapacidad(),
                    tipoHhabitacion.getCantidadCamas(),
                    tipoHhabitacion.getTipoCamas(),
                    tipoHhabitacion.getPrecioNoche()
                });
            }
        }

    }

    private void borrarFormulario() {
        jtfECodigo.setText("");
        jtfECapacidad.setText("");
        jtfECantidadCamas.setText("");
        jtfETiposCamas.setText("");
        jtfEPrecioNoche.setText("");
        jbGuardar.setText("Nuevo");
    }

    private void cargarFormulario() {
        // Cambiar texto de boton Nuevo a Guardar
        jbGuardar.setText("Guardar");

        // Recuperar información de elemento seleccionado
        jtfECodigo.setText(modelo.getValueAt(jtTiposHabitacion.getSelectedRow(), 0).toString());
        jtfECapacidad.setText(modelo.getValueAt(jtTiposHabitacion.getSelectedRow(), 1).toString());
        jtfECantidadCamas.setText(modelo.getValueAt(jtTiposHabitacion.getSelectedRow(), 2).toString());
        jtfETiposCamas.setText(modelo.getValueAt(jtTiposHabitacion.getSelectedRow(), 3).toString());
        jtfEPrecioNoche.setText(modelo.getValueAt(jtTiposHabitacion.getSelectedRow(), 4).toString());
    }
}
