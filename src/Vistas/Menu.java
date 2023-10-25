package Vistas;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatVuesionIJTheme;
import javafx.scene.shape.Arc;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
        // Asignar icono de ventana
        ImageIcon icono = new ImageIcon("image/hotel.png");
        this.setIconImage(icono.getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jmHabitación = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jmHuesped = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jmReservas = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jmiCheckInOut = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmCerrar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 900));
        setPreferredSize(new java.awt.Dimension(1000, 900));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 829, Short.MAX_VALUE)
        );

        jMenu1.setText("Administración");

        jMenu3.setText("Habitaciones");

        jmHabitación.setText("Habitación");
        jmHabitación.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmHabitaciónActionPerformed(evt);
            }
        });
        jMenu3.add(jmHabitación);

        jMenuItem1.setText("Tipo de Habitaciones");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenu1.add(jMenu3);

        jmHuesped.setText("Huesped");
        jmHuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmHuespedActionPerformed(evt);
            }
        });
        jMenu1.add(jmHuesped);

        jMenuBar1.add(jMenu1);

        jMenu5.setText("Reservas");

        jmReservas.setText("Alta Reserva");
        jmReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmReservasActionPerformed(evt);
            }
        });
        jMenu5.add(jmReservas);

        jMenuItem2.setText("Administración Reservas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem2);

        jmiCheckInOut.setText("CheckIn / Out");
        jmiCheckInOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCheckInOutActionPerformed(evt);
            }
        });
        jMenu5.add(jmiCheckInOut);

        jMenuBar1.add(jMenu5);

        jMenu2.setText("Salir");

        jmCerrar.setText("Cerrar");
        jmCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCerrarActionPerformed(evt);
            }
        });
        jMenu2.add(jmCerrar);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jmCerrarActionPerformed

    private void jmHuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmHuespedActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        VistaHuesped vh = new VistaHuesped();
        vh.setLocation((escritorio.getWidth() - vh.getWidth()) / 2, (escritorio.getHeight() - vh.getHeight()) / 2);
        vh.setVisible(true);
        escritorio.add(vh);
        escritorio.moveToFront(vh);
        vh.setMaximizable(true);
        vh.setClosable(true);
    }//GEN-LAST:event_jmHuespedActionPerformed

    private void jmHabitaciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmHabitaciónActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        VistaHabitacion vhab = new VistaHabitacion();
        vhab.setLocation((escritorio.getWidth() - vhab.getWidth()) / 2, (escritorio.getHeight() - vhab.getHeight()) / 2);
        vhab.setVisible(true);
        escritorio.add(vhab);
        escritorio.moveToFront(vhab);
        vhab.setMaximizable(true);
        vhab.setClosable(true);
    }//GEN-LAST:event_jmHabitaciónActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        VistaTipoHabitacion vthab = new VistaTipoHabitacion();
        vthab.setLocation((escritorio.getWidth() - vthab.getWidth()) / 2, (escritorio.getHeight() - vthab.getHeight()) / 2);
        vthab.setVisible(true);
        escritorio.add(vthab);
        escritorio.moveToFront(vthab);
        vthab.setMaximizable(true);
        vthab.setClosable(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jmReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmReservasActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        VistaReserva vr = new VistaReserva();
        vr.setLocation((escritorio.getWidth() - vr.getWidth()) / 2, (escritorio.getHeight() - vr.getHeight()) / 2);
        vr.setVisible(true);
        escritorio.add(vr);
        escritorio.moveToFront(vr);
        vr.setMaximizable(false);
        vr.setClosable(true);
    }//GEN-LAST:event_jmReservasActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        VistaAdminReserva var = new VistaAdminReserva();
        var.setLocation((escritorio.getWidth() - var.getWidth()) / 2, (escritorio.getHeight() - var.getHeight()) / 2);
        var.setVisible(true);
        escritorio.add(var);
        escritorio.moveToFront(var);
        var.setMaximizable(false);
        var.setClosable(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jmiCheckInOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCheckInOutActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        VistaCheckInOut vcio = new VistaCheckInOut();
        vcio.setLocation((escritorio.getWidth() - vcio.getWidth()) / 2, (escritorio.getHeight() - vcio.getHeight()) / 2);
        vcio.setVisible(true);
        escritorio.add(vcio);
        escritorio.moveToFront(vcio);
        vcio.setMaximizable(false);
        vcio.setClosable(true);
    }//GEN-LAST:event_jmiCheckInOutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //FlatVuesionIJTheme.setup();
        try {
            UIManager.setLookAndFeel(new FlatCarbonIJTheme());
        } catch (Exception e) {
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jmCerrar;
    private javax.swing.JMenuItem jmHabitación;
    private javax.swing.JMenuItem jmHuesped;
    private javax.swing.JMenuItem jmReservas;
    private javax.swing.JMenuItem jmiCheckInOut;
    // End of variables declaration//GEN-END:variables
}
