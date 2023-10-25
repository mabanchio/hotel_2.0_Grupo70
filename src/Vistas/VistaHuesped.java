package Vistas;

import AccesoDatos.ConsultaData;
import Entidades.Huesped;
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

public class VistaHuesped extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        //No permitir edicion de columnas
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public VistaHuesped() {
        initComponents();
        armarCabeceras();
        cargarHuesped();
        jbGuardar.setText("Nuevo");
        //Asignar icono a InternalFrame
        ImageIcon icono = new ImageIcon("image/cliente.png");
        Image scaledImage = icono.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        setFrameIcon(scaledIcon);

        //Capturar clik en tabla Huesped
        jtHuesped.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jbGuardar.setText("Guardar");
                jtfEApellido.setText(modelo.getValueAt(jtHuesped.getSelectedRow(), 0).toString());
                jtfENombre.setText(modelo.getValueAt(jtHuesped.getSelectedRow(), 1).toString());
                jtfEDni.setText(modelo.getValueAt(jtHuesped.getSelectedRow(), 2).toString());
                jtfETelefono.setText(modelo.getValueAt(jtHuesped.getSelectedRow(), 3).toString());
                jtfEMail.setText(modelo.getValueAt(jtHuesped.getSelectedRow(), 4).toString());
            }
        });
        cargarImagenHuesped();
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
        jtfDni = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtHuesped = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jtfEApellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfENombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfEDni = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfETelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jbGuardar = new javax.swing.JButton();
        jtfEMail = new javax.swing.JTextField();
        jbEliminar = new javax.swing.JButton();
        jlHuesped = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setTitle("Administración de Huesped");
        setMinimumSize(new java.awt.Dimension(800, 360));
        setPreferredSize(new java.awt.Dimension(800, 360));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Administración de Huésped");

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setText("Apellido:");

        jtfApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfApellidoKeyReleased(evt);
            }
        });

        jLabel3.setText("DNI:");

        jtfDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfDniKeyReleased(evt);
            }
        });

        jtHuesped.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Apellido", "Nombre", "DNI", "Teléfono", "e-mail"
            }
        ));
        jtHuesped.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtHuespedKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtHuesped);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfDni, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jtfDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel4.setText("Apellido");

        jLabel5.setText("Nombre");

        jLabel6.setText("DNI");

        jLabel7.setText("Teléfono");

        jLabel8.setText("e-mail");

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

        jlHuesped.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jtfEMail, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(jtfEApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(jtfENombre)
                            .addComponent(jLabel6)
                            .addComponent(jtfEDni)
                            .addComponent(jLabel7)
                            .addComponent(jtfETelefono)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jtfEApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfENombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfEDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jtfETelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addComponent(jbEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfEMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbGuardar))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfApellidoKeyReleased
        cargarHuesped();
        limpiarFormulario();
    }//GEN-LAST:event_jtfApellidoKeyReleased

    private void jtfDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDniKeyReleased
        cargarHuesped();
        limpiarFormulario();
    }//GEN-LAST:event_jtfDniKeyReleased

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        try {
            ConsultaData agregarModificarHuesped = new ConsultaData();
            int dni = Integer.parseInt(jtfEDni.getText());
            Huesped huesped = new Huesped();
            Boolean formulario = false;
            if (!(jtfEApellido.getText().isEmpty() || jtfENombre.getText().isEmpty() || jtfEDni.getText().isEmpty() || jtfETelefono.getText().isEmpty() || jtfEMail.getText().isEmpty())) {
                formulario = true;
            }

            if (jtHuesped.getSelectedRow() != -1 && formulario) {
                // Armar huesped
                System.out.println(agregarModificarHuesped.idHuespedPorDni(jtfEDni.getText()));
                huesped.setIdHuesped(agregarModificarHuesped.idHuespedPorDni(jtfEDni.getText()));
                huesped.setApellido(jtfEApellido.getText());
                huesped.setNombre(jtfENombre.getText());
                huesped.setDni(jtfEDni.getText());
                huesped.setTelefono(jtfETelefono.getText());
                huesped.setEmail(jtfEMail.getText());
                // Realizar un Update
                agregarModificarHuesped.modificarHuesped(huesped);
                limpiarFormulario();
                cargarHuesped();

            } else if (formulario) {
                // Armar huesped
                huesped.setApellido(jtfEApellido.getText());
                huesped.setNombre(jtfENombre.getText());
                huesped.setDni(jtfEDni.getText());
                huesped.setTelefono(jtfETelefono.getText());
                huesped.setEmail(jtfEMail.getText());
                // Realizar un Insert
                agregarModificarHuesped.agregarHuesped(huesped);
                limpiarFormulario();
                cargarHuesped();
            } else {
                JOptionPane.showMessageDialog(this, "Debe ingresar todos los datos del huesped.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un número de DNI válido.");
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        ConsultaData eliminarHuesped = new ConsultaData();
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar este Huesped?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            int idHuesped = eliminarHuesped.idHuespedPorDni(jtfEDni.getText());
            eliminarHuesped.eliminarHuesped(idHuesped);
            cargarHuesped();
            limpiarFormulario();
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jtHuespedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtHuespedKeyReleased
        jbGuardar.setText("Guardar");
                jtfEApellido.setText(modelo.getValueAt(jtHuesped.getSelectedRow(), 0).toString());
                jtfENombre.setText(modelo.getValueAt(jtHuesped.getSelectedRow(), 1).toString());
                jtfEDni.setText(modelo.getValueAt(jtHuesped.getSelectedRow(), 2).toString());
                jtfETelefono.setText(modelo.getValueAt(jtHuesped.getSelectedRow(), 3).toString());
                jtfEMail.setText(modelo.getValueAt(jtHuesped.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_jtHuespedKeyReleased


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
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JLabel jlHuesped;
    private javax.swing.JTable jtHuesped;
    private javax.swing.JTextField jtfApellido;
    private javax.swing.JTextField jtfDni;
    private javax.swing.JTextField jtfEApellido;
    private javax.swing.JTextField jtfEDni;
    private javax.swing.JTextField jtfEMail;
    private javax.swing.JTextField jtfENombre;
    private javax.swing.JTextField jtfETelefono;
    // End of variables declaration//GEN-END:variables

    private void armarCabeceras() {
        modelo.addColumn("Apellido");
        modelo.addColumn("Nombre");
        modelo.addColumn("DNI");
        modelo.addColumn("Teléfono");
        modelo.addColumn("e-mail");

        jtHuesped.setModel(modelo);

        //Establecer ancho de columnas
        jtHuesped.getColumnModel().getColumn(0).setPreferredWidth(75);
        jtHuesped.getColumnModel().getColumn(1).setPreferredWidth(75);
        jtHuesped.getColumnModel().getColumn(2).setPreferredWidth(50);
        jtHuesped.getColumnModel().getColumn(3).setPreferredWidth(50);
        jtHuesped.getColumnModel().getColumn(4).setPreferredWidth(150);

        // Crear un renderizador de celdas para centrar el contenido
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i <= 4; i++) {
            jtHuesped.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    private void borrarFilas() {
        int f = jtHuesped.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }

    private void cargarHuesped() {
        List<Huesped> huespedes = new ArrayList<>();
        ConsultaData listarHuesped = new ConsultaData();
        huespedes = listarHuesped.listarHuespedes();
        borrarFilas();
        for (Huesped huesped : huespedes) {
            if (huesped.getApellido().toLowerCase().startsWith(jtfApellido.getText().toLowerCase()) && huesped.getDni().toLowerCase().startsWith(jtfDni.getText().toLowerCase())) {
                modelo.addRow(new Object[]{
                    huesped.getApellido(),
                    huesped.getNombre(),
                    huesped.getDni(),
                    huesped.getTelefono(),
                    huesped.getEmail()
                });
            }

        }
    }

    private void limpiarFormulario() {
        jtfEApellido.setText("");
        jtfENombre.setText("");
        jtfEDni.setText("");
        jtfETelefono.setText("");
        jtfEMail.setText("");
        jbGuardar.setText("Nuevo");
    }
    
    private void cargarImagenHuesped(){
    // Cargar la imagen desde un archivo (reemplaza la URL con la ubicación de tu imagen)
        ImageIcon imageIcon = new ImageIcon("image/cliente.png");

        if (imageIcon != null) {
            // Obtener el icono de imagen y redimensionarlo al tamaño del JLabel
            Image img = imageIcon.getImage();
            int ancho = 100;
            int alto = 100;
            Image nuevaImagen = img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

            // Establecer la imagen redimensionada en el JLabel
            ImageIcon iconoRedimensionado = new ImageIcon(nuevaImagen);
            jlHuesped.setIcon(iconoRedimensionado);
        }
    
    }
}
