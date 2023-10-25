package Vistas;

import AccesoDatos.ConsultaData;
import Entidades.Estado;
import Entidades.Habitacion;
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

public class VistaHabitacion extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        //No permitir edicion de columnas
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public VistaHabitacion() {
        initComponents();
        armarCabeceras();
        cargarCboPisoYTipo();
        cargarCboTipoHabitacion();
        cargarCboEstado();
        limpiarFormulario();
        //Asignar icono a InternalFrame
        ImageIcon icono = new ImageIcon("image/habitacion.png");
        Image scaledImage = icono.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        setFrameIcon(scaledIcon);
        //Cargar lista de habitaciones
        cargarHabitaciones();
        // Modificar texto boton Guardar a Nuevo
        jbEGuardar.setText("Nuevo");
        //Capturar clik en tabla Huesped
        jtHabitacion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cargarFormulario();
            }
        });
        cargarImagenHabitacion();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfNumero = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jcbPiso = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jcbTipoHabitacion = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtHabitacion = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtfENumero = new javax.swing.JTextField();
        jcbETipo = new javax.swing.JComboBox<>();
        jcbEEstado = new javax.swing.JComboBox<>();
        jbEGuardar = new javax.swing.JButton();
        jbEEliminar = new javax.swing.JButton();
        jcbEPiso = new javax.swing.JComboBox<>();
        jlHabitacion = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(800, 360));
        setPreferredSize(new java.awt.Dimension(800, 360));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Administración de Habitaciones");

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setText("Número:");

        jtfNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfNumeroKeyReleased(evt);
            }
        });

        jLabel3.setText("Piso:");

        jcbPiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPisoActionPerformed(evt);
            }
        });

        jLabel4.setText("Tipo Habitación:");

        jcbTipoHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoHabitacionActionPerformed(evt);
            }
        });

        jtHabitacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Número", "Piso", "Tipo", "Estado"
            }
        ));
        jtHabitacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtHabitacionKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtHabitacion);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jcbPiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jcbTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel5.setText("Número:");

        jLabel6.setText("Piso:");

        jLabel7.setText("Tipo:");

        jLabel8.setText("Estado:");

        jbEGuardar.setText("Guardar");
        jbEGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEGuardarActionPerformed(evt);
            }
        });

        jbEEliminar.setText("Eliminar");
        jbEEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEEliminarActionPerformed(evt);
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
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcbETipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbEEstado, 0, 100, Short.MAX_VALUE)
                            .addComponent(jcbEPiso, 0, 60, Short.MAX_VALUE)
                            .addComponent(jtfENumero))
                        .addGap(18, 18, 18)
                        .addComponent(jlHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jbEGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(jbEEliminar)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jtfENumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jcbEPiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jcbETipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jcbEEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jlHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEGuardar)
                    .addComponent(jbEEliminar))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfNumeroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNumeroKeyReleased
        limpiarFormulario();
        cargarHabitaciones();
    }//GEN-LAST:event_jtfNumeroKeyReleased

    private void jcbPisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPisoActionPerformed
        cargarHabitaciones();
    }//GEN-LAST:event_jcbPisoActionPerformed

    private void jcbTipoHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoHabitacionActionPerformed
        cargarHabitaciones();
    }//GEN-LAST:event_jcbTipoHabitacionActionPerformed

    private void jbEGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEGuardarActionPerformed
        try {
            if (!(jtfENumero.getText().isEmpty() || jcbEPiso.getSelectedIndex() == -1 || jcbETipo.getSelectedIndex() == -1 || jcbEEstado.getSelectedIndex() == -1)) {
                if (jtHabitacion.getSelectedRow() != -1) {
                    // Realizar un Update
                    ConsultaData actualizarHabitacion = new ConsultaData();
                    Habitacion habitacion = new Habitacion();
                    Estado estadoHabitacion = Estado.Libre;
                    // Armar objeto Habitación
                    habitacion.setIdHabitacion(actualizarHabitacion.idHabitacionPorNumeroYPiso(Integer.parseInt(jtfENumero.getText()), Integer.parseInt(jcbEPiso.getSelectedItem().toString())));
                    habitacion.setNumero(Integer.parseInt(jtfENumero.getText()));
                    habitacion.setPiso(Integer.parseInt(jcbEPiso.getSelectedItem().toString()));
                    // Recuperar Estado
                    for (Estado estado : Estado.values()) {
                        if (estado.toString().equalsIgnoreCase(jcbEEstado.getSelectedItem().toString())) {
                            estadoHabitacion = estado;
                        }
                    }
                    habitacion.setEstado(estadoHabitacion);
                    habitacion.setTipoHabitacion(actualizarHabitacion.tipoHabitacionPorCodigo(jcbETipo.getSelectedItem().toString()));
                    // Ejecutar la actualización
                    actualizarHabitacion.modificarHabitacion(habitacion);
                    // Cargar Habitaciones
                    cargarHabitaciones();
                    limpiarFormulario();

                } else {
                    // Realizar un Insert
                    ConsultaData agregarHabitacion = new ConsultaData();
                    Habitacion habitacion = new Habitacion();
                    Estado estadoHabitacion = Estado.Libre;
                    // Armar objeto Habitación
                    habitacion.setNumero(Integer.parseInt(jtfENumero.getText()));
                    habitacion.setPiso(Integer.parseInt(jcbEPiso.getSelectedItem().toString()));
                    // Recuperar Estado
                    for (Estado estado : Estado.values()) {
                        if (estado.toString().equalsIgnoreCase(jcbEEstado.getSelectedItem().toString())) {
                            estadoHabitacion = estado;
                        }
                    }
                    habitacion.setEstado(estadoHabitacion);
                    habitacion.setTipoHabitacion(agregarHabitacion.tipoHabitacionPorCodigo(jcbETipo.getSelectedItem().toString()));
                    // Ejecutar la actualización
                    agregarHabitacion.agregarHabitacion(habitacion);
                    // Cargar Habitaciones
                    cargarHabitaciones();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe ingresar todos los datos para agregar o modificar una Habitación.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un número de habitación válido");
        }
    }//GEN-LAST:event_jbEGuardarActionPerformed

    private void jbEEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEEliminarActionPerformed
        if (jtHabitacion.getSelectedRow() != -1) {
            ConsultaData eliminarHabitacion = new ConsultaData();
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar esta Habitación?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                int idHabitacion = eliminarHabitacion.idHabitacionPorNumeroYPiso(Integer.parseInt(jtfENumero.getText()), Integer.parseInt(jcbEPiso.getSelectedItem().toString()));
                eliminarHabitacion.eliminarHabitacion(idHabitacion);
                cargarHabitaciones();
                limpiarFormulario();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una Habitación de la tabla a eliminar.");
        }


    }//GEN-LAST:event_jbEEliminarActionPerformed

    private void jtHabitacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtHabitacionKeyReleased
        cargarFormulario();
    }//GEN-LAST:event_jtHabitacionKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbEEliminar;
    private javax.swing.JButton jbEGuardar;
    private javax.swing.JComboBox<String> jcbEEstado;
    private javax.swing.JComboBox<String> jcbEPiso;
    private javax.swing.JComboBox<String> jcbETipo;
    private javax.swing.JComboBox<String> jcbPiso;
    private javax.swing.JComboBox<String> jcbTipoHabitacion;
    private javax.swing.JLabel jlHabitacion;
    private javax.swing.JTable jtHabitacion;
    private javax.swing.JTextField jtfENumero;
    private javax.swing.JTextField jtfNumero;
    // End of variables declaration//GEN-END:variables

    private void armarCabeceras() {
        modelo.addColumn("Número");
        modelo.addColumn("Piso");
        modelo.addColumn("Tipo");
        modelo.addColumn("Estado");

        jtHabitacion.setModel(modelo);

        //Establecer ancho de columnas
        jtHabitacion.getColumnModel().getColumn(0).setPreferredWidth(75);
        jtHabitacion.getColumnModel().getColumn(1).setPreferredWidth(75);
        jtHabitacion.getColumnModel().getColumn(2).setPreferredWidth(100);
        jtHabitacion.getColumnModel().getColumn(3).setPreferredWidth(100);

        // Crear un renderizador de celdas para centrar el contenido
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i <= 3; i++) {
            jtHabitacion.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    private void borrarFilas() {
        int f = jtHabitacion.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }

    private void cargarHabitaciones() {
        try {
            List<Habitacion> habitaciones = new ArrayList<>();
            ConsultaData listarjtHabitaciones = new ConsultaData();
            habitaciones = listarjtHabitaciones.listarHabitaciones();
            borrarFilas();
            jbEGuardar.setText("Nuevo");
            for (Habitacion habitacion : habitaciones) {
                String piso = "";
                String tipoHab = "";

                if (jcbPiso.getSelectedIndex() != -1) {
                    piso = jcbPiso.getSelectedItem().toString();
                }
                if (jcbTipoHabitacion.getSelectedIndex() != -1) {
                    tipoHab = jcbTipoHabitacion.getSelectedItem().toString();
                }

                if (String.valueOf(habitacion.getNumero()).startsWith(jtfNumero.getText()) && String.valueOf(habitacion.getPiso()).startsWith(piso) && habitacion.getTipoHabitacion().getCodigo().startsWith(tipoHab)) {
                    modelo.addRow(new Object[]{
                        habitacion.getNumero(),
                        habitacion.getPiso(),
                        habitacion.getTipoHabitacion().getCodigo(),
                        habitacion.getEstado()
                    });
                }

            }

        } catch (NullPointerException e) {
        }
        jtfENumero.setText("");
        jcbEPiso.setSelectedIndex(-1);
        jcbETipo.setSelectedIndex(-1);
        jcbEEstado.setSelectedIndex(-1);
    }

    private void limpiarFormulario() {
        jcbTipoHabitacion.setSelectedIndex(-1);
        jcbPiso.setSelectedIndex(-1);
        //jtfNumero.setText("");
        jtfENumero.setText("");
        jcbEPiso.setSelectedIndex(-1);
        jcbETipo.setSelectedIndex(-1);
        jcbEEstado.setSelectedIndex(-1);
        jbEGuardar.setText("Nuevo");
    }

    private void cargarCboPisoYTipo() {
        List<Integer> pisos = new ArrayList<>();
        ConsultaData obtenerPisos = new ConsultaData();
        pisos = obtenerPisos.pisosActivos();
        jcbPiso.removeAllItems();
        jcbEPiso.removeAllItems();
        jcbPiso.addItem("");
        for (int piso : pisos) {
            jcbPiso.addItem(String.valueOf(piso));
            jcbEPiso.addItem(String.valueOf(piso));
        }
    }

    ;
    
    private void cargarCboTipoHabitacion() {
        List<String> tiposHabitacion = new ArrayList<>();
        ConsultaData obtenerTiposHabitacion = new ConsultaData();
        tiposHabitacion = obtenerTiposHabitacion.listaTipoHabitacion();
        jcbTipoHabitacion.removeAllItems();
        jcbETipo.removeAllItems();
        jcbTipoHabitacion.addItem("");
        for (String tipoHabitacion : tiposHabitacion) {
            jcbTipoHabitacion.addItem(tipoHabitacion);
            jcbETipo.addItem(tipoHabitacion);
        }
    }

    private void cargarCboEstado() {
        jcbEEstado.addItem("Libre");
        jcbEEstado.addItem("Ocupada");
    }

    private void cargarFormulario() {
        // Cambiar texto de boton Nuevo a Guardar
        jbEGuardar.setText("Guardar");

        jtfENumero.setText(modelo.getValueAt(jtHabitacion.getSelectedRow(), 0).toString());
        // Recuperar indeice de piso
        for (int i = 0; i < jcbEPiso.getItemCount(); i++) {
            Object item = jcbEPiso.getItemAt(i);
            if (item != null && item.toString().equals(modelo.getValueAt(jtHabitacion.getSelectedRow(), 1).toString())) {
                jcbEPiso.setSelectedIndex(i);
                break;
            }
        }
        // Recuperar Tipo Habitacion
        for (int i = 0; i < jcbETipo.getItemCount(); i++) {
            Object item = jcbETipo.getItemAt(i);
            if (item != null && item.toString().equals(modelo.getValueAt(jtHabitacion.getSelectedRow(), 2).toString())) {
                jcbETipo.setSelectedIndex(i);
                break;
            }
        }
        // Recuperar estado
        for (int i = 0; i < jcbEEstado.getItemCount(); i++) {
            Object item = jcbEEstado.getItemAt(i);
            if (item != null && item.toString().equals(modelo.getValueAt(jtHabitacion.getSelectedRow(), 3).toString())) {
                jcbEEstado.setSelectedIndex(i);
                break;
            }
        }
    }

     private void cargarImagenHabitacion(){
    // Cargar la imagen desde un archivo (reemplaza la URL con la ubicación de tu imagen)
        ImageIcon imageIcon = new ImageIcon("image/habitacion.png");

        if (imageIcon != null) {
            // Obtener el icono de imagen y redimensionarlo al tamaño del JLabel
            Image img = imageIcon.getImage();
            int ancho = 100;
            int alto = 100;
            Image nuevaImagen = img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

            // Establecer la imagen redimensionada en el JLabel
            ImageIcon iconoRedimensionado = new ImageIcon(nuevaImagen);
            jlHabitacion.setIcon(iconoRedimensionado);
        }
    
    }
    
}
