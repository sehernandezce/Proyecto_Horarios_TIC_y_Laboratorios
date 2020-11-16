/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Entidad.Usuario;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;

/**
 *
 * @author Asus
 */
public class Frame_DetallesSolicitud extends javax.swing.JFrame {

    /** Creates new form Frame_DetallesSolicitud */
    private int x,y;    
    private Usuario usuario;
    private Frame_Main fraim; 
    
    public Frame_DetallesSolicitud() {
        initComponents();
        this.setLocationRelativeTo(null);this.setLocationRelativeTo(null);
        habtext(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void habilitarControles(JTextField text, boolean b) {
          if (b) {
              
                  text.setDisabledTextColor(new Color(0, 0, 0));
                  text.setBackground(new Color(255, 255, 255));
                  text.setEnabled(b);
            } else {
                  text.setDisabledTextColor(new Color(60, 63, 65));
                  text.setBackground(new Color(240, 240, 240));
                  text.setEnabled(b);
           }
              
        }
     
     private void habtext(boolean b){      
         habilitarControles(jF_repeticion,b);
         habilitarControles(jFF_inicio,b);
         habilitarControles(jFF_final,b);
         habilitarControles(jFH_inicio,b);
         habilitarControles(jFH_final,b);
         habilitarControles(jF_motivo,b);
         habilitarControles(jF_obs,b);
         habilitarControles(jF_salon,b);
         habilitarControles(jF_dias,b);
         habilitarControles(jF_nombre_edi,b);   
         habilitarControles(jF_nombre_esp,b);
         
     }
  
     public void llenar_frame(String[] datos, String dia,Usuario u, Frame_Main frame){
        this.usuario=u;
        this.fraim = frame;
        jFF_inicio.setText(datos[0]);
        jFF_final.setText(datos[1]);
        jFH_inicio.setText(datos[2]);
        jFH_final.setText(datos[3]);
        jF_repeticion.setText(datos[4]);
        jF_dias.setText(dia);
        jF_nombre_esp.setText(datos[5]);
        jF_motivo.setText(datos[6]);
        jF_nombre_edi.setText(datos[7]);
        jF_salon.setText(datos[8]);
        jF_obs.setText(datos[9]);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCerrar = new javax.swing.JPanel();
        jlClose1 = new javax.swing.JLabel();
        jlMinimize1 = new javax.swing.JLabel();
        LbUsuario = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jFF_inicio = new javax.swing.JTextField();
        jFH_inicio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jF_repeticion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jF_nombre_esp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jF_nombre_edi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jF_salon = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jFF_final = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jFH_final = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jF_dias = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jF_motivo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jF_obs = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(770, 617));
        setUndecorated(true);
        setSize(new java.awt.Dimension(770, 617));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCerrar.setBackground(new java.awt.Color(153, 153, 153));
        panelCerrar.setForeground(new java.awt.Color(102, 255, 255));
        panelCerrar.setMaximumSize(new java.awt.Dimension(50, 30));
        panelCerrar.setMinimumSize(new java.awt.Dimension(50, 30));
        panelCerrar.setPreferredSize(new java.awt.Dimension(500, 30));
        panelCerrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlClose1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/incorrecto.png"))); // NOI18N
        jlClose1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlClose1MouseClicked(evt);
            }
        });
        panelCerrar.add(jlClose1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 20, -1));

        jlMinimize1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/linea.png"))); // NOI18N
        jlMinimize1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlMinimize1MouseClicked(evt);
            }
        });
        panelCerrar.add(jlMinimize1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 20, -1));

        LbUsuario.setBackground(new java.awt.Color(0, 51, 204));
        LbUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LbUsuario.setForeground(new java.awt.Color(255, 255, 255));
        LbUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo u_preview_rev_1_opt.png"))); // NOI18N
        LbUsuario.setText("Horarios de salas TIC's y Laboratorios");
        panelCerrar.add(LbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 6, 240, 20));

        getContentPane().add(panelCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 30));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setMaximumSize(new java.awt.Dimension(770, 617));
        jPanel1.setMinimumSize(new java.awt.Dimension(770, 617));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel1.setText("Información del evento:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 26, 280, 29));

        jLabel2.setText("Fecha de inicio:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 107, -1, -1));

        jFF_inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFF_inicioActionPerformed(evt);
            }
        });
        jPanel1.add(jFF_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 98, 248, 32));
        jPanel1.add(jFH_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 169, 248, 32));

        jLabel3.setText("Hora de inicio:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 178, -1, -1));
        jPanel1.add(jF_repeticion, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 241, 248, 32));

        jLabel4.setText("Repeticion:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 250, -1, -1));
        jPanel1.add(jF_nombre_esp, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 313, 248, 32));

        jLabel5.setText("Nombre del espacio:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 322, -1, -1));
        jPanel1.add(jF_nombre_edi, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 384, 248, 32));

        jLabel6.setText("Nombre edificio:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 393, -1, -1));
        jPanel1.add(jF_salon, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 453, 103, 32));

        jLabel7.setText("Salón:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 462, -1, -1));

        jFF_final.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFF_finalActionPerformed(evt);
            }
        });
        jPanel1.add(jFF_final, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 98, 248, 32));

        jLabel8.setText("Fecha de final:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 107, -1, -1));
        jPanel1.add(jFH_final, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 169, 248, 32));

        jLabel9.setText("Hora final:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 178, -1, -1));

        jLabel10.setText("Dias:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, -1, -1));
        jPanel1.add(jF_dias, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 241, 248, 32));

        jLabel11.setText("Motivo:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 322, -1, -1));
        jPanel1.add(jF_motivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 313, 248, 32));

        jLabel12.setText("Observaciones:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 393, -1, -1));
        jPanel1.add(jF_obs, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 390, 248, 95));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 770, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlClose1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlClose1MouseClicked
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Desea cerrar el esta ventana?","Exit",dialog);

        if(result == 0){
            this.fraim.setEnabled(true);
            this.dispose();

        }

    }//GEN-LAST:event_jlClose1MouseClicked

    private void jlMinimize1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlMinimize1MouseClicked
        this.setState(Frame_Login.ICONIFIED);
    }//GEN-LAST:event_jlMinimize1MouseClicked

    private void jFF_inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFF_inicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFF_inicioActionPerformed

    private void jFF_finalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFF_finalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFF_finalActionPerformed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        this.setLocation(this.getLocation().x + evt.getX()-x,this.getLocation().y+evt.getY()-y);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        x= evt.getX();   
        y= evt.getY(); 
    }//GEN-LAST:event_formMousePressed

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
            java.util.logging.Logger.getLogger(Frame_DetallesSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_DetallesSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_DetallesSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_DetallesSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_DetallesSolicitud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LbUsuario;
    private javax.swing.JTextField jFF_final;
    private javax.swing.JTextField jFF_inicio;
    private javax.swing.JTextField jFH_final;
    private javax.swing.JTextField jFH_inicio;
    private javax.swing.JTextField jF_dias;
    private javax.swing.JTextField jF_motivo;
    private javax.swing.JTextField jF_nombre_edi;
    private javax.swing.JTextField jF_nombre_esp;
    private javax.swing.JTextField jF_obs;
    private javax.swing.JTextField jF_repeticion;
    private javax.swing.JTextField jF_salon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlClose1;
    private javax.swing.JLabel jlMinimize1;
    private javax.swing.JPanel panelCerrar;
    // End of variables declaration//GEN-END:variables

}
