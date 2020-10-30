package GUI;

import Control.ValidarInventario;
import Entidad.Espacio;
import Entidad.Usuario;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Frame_DetallesEspacio extends javax.swing.JFrame {

    private int x,y;
    private Usuario usuario;
    private ValidarInventario validarInventario=new ValidarInventario();
    public Frame_DetallesEspacio() {
        initComponents();
        this.setLocationRelativeTo(null);  
        buttonGroup1.add(jRadioBActivo);
        buttonGroup1.add(jRadioBInactivo); 
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        paneldetallesInventario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jRadioBActivo = new javax.swing.JRadioButton();
        jRadioBInactivo = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelAñadir = new javax.swing.JLabel();
        jLabelEliminar1 = new javax.swing.JLabel();
        jButtonEditar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextNombreEspacio2 = new javax.swing.JTextField();
        jTextCapacidad = new javax.swing.JTextField();
        jTextNumeroEdificio2 = new javax.swing.JTextField();
        jTextNumeroSalon1 = new javax.swing.JTextField();
        panelCerrar = new javax.swing.JPanel();
        jlClose1 = new javax.swing.JLabel();
        jlMinimize1 = new javax.swing.JLabel();
        LbUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(770, 617));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(770, 617));
        setResizable(false);
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

        paneldetallesInventario.setBackground(new java.awt.Color(204, 204, 204));
        paneldetallesInventario.setMaximumSize(new java.awt.Dimension(770, 617));
        paneldetallesInventario.setMinimumSize(new java.awt.Dimension(770, 617));
        paneldetallesInventario.setPreferredSize(new java.awt.Dimension(770, 617));
        paneldetallesInventario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Encargado:");
        paneldetallesInventario.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Detalles de inventario:");
        paneldetallesInventario.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Capacidad:");
        paneldetallesInventario.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Tipo de espacio:");
        paneldetallesInventario.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        paneldetallesInventario.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 150, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Nombre del Espacio:");
        paneldetallesInventario.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Edificio:");
        paneldetallesInventario.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Estado:");
        paneldetallesInventario.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Salón:");
        paneldetallesInventario.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, -1, -1));

        jRadioBActivo.setBackground(new java.awt.Color(204, 204, 204));
        jRadioBActivo.setForeground(new java.awt.Color(0, 0, 0));
        jRadioBActivo.setSelected(true);
        jRadioBActivo.setText("Activo");
        jRadioBActivo.setEnabled(false);
        paneldetallesInventario.add(jRadioBActivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, -1, -1));

        jRadioBInactivo.setBackground(new java.awt.Color(204, 204, 204));
        jRadioBInactivo.setForeground(new java.awt.Color(0, 0, 0));
        jRadioBInactivo.setText("Inactivo");
        jRadioBInactivo.setEnabled(false);
        paneldetallesInventario.add(jRadioBInactivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Información del espacio:");
        paneldetallesInventario.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jScrollPane1.setViewportView(jTable1);

        paneldetallesInventario.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 700, 230));

        jLabelAñadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/anadir.png"))); // NOI18N
        paneldetallesInventario.add(jLabelAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, -1, -1));

        jLabelEliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar.png"))); // NOI18N
        paneldetallesInventario.add(jLabelEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 270, -1, -1));

        jButtonEditar.setBackground(new java.awt.Color(204, 204, 204));
        jButtonEditar.setText("Editar");
        paneldetallesInventario.add(jButtonEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 550, 90, 30));

        jButtonGuardar.setBackground(new java.awt.Color(204, 204, 204));
        jButtonGuardar.setText("Guardar");
        paneldetallesInventario.add(jButtonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 550, 100, 30));

        jTextField1.setEnabled(false);
        paneldetallesInventario.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 150, 30));

        jTextNombreEspacio2.setEnabled(false);
        paneldetallesInventario.add(jTextNombreEspacio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 220, 30));

        jTextCapacidad.setEnabled(false);
        paneldetallesInventario.add(jTextCapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 70, 30));

        jTextNumeroEdificio2.setEnabled(false);
        paneldetallesInventario.add(jTextNumeroEdificio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 130, 30));

        jTextNumeroSalon1.setEnabled(false);
        paneldetallesInventario.add(jTextNumeroSalon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 110, 30));

        getContentPane().add(paneldetallesInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 770, 600));

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void llenarFrame(Usuario u, Espacio esp) throws SQLException{
        this.usuario=u;
        
        jTextField1.setText(esp.getNombre_tipoespacio());
        if(esp.getNombre_espacio().equals(null)){
             jTextNombreEspacio2.setText(" ");
        }else{
             jTextNombreEspacio2.setText(esp.getNombre_espacio());
        }
       
        jComboBox1.addItem(esp.getNombre_encargado());
        jTextNumeroSalon1.setText(esp.getNum_Espacio());
        jTextNumeroEdificio2.setText(esp.getNombre_edificio());
        jTextCapacidad.setText(String.valueOf(esp.getCapacidad()));       
        
        if(esp.getEstado()){
            jRadioBActivo.setSelected(true);
            jRadioBInactivo.setSelected(false);
        }else{
             jRadioBActivo.setSelected(false);
            jRadioBInactivo.setSelected(true);
        }
       Object[][] tabla=validarInventario.llenarMatrizInv(esp.getId_espacio(), u);        
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
         tabla, new String [] {"Id inventario", "Nombre", "Descripción" }) 
                         );
    }
    
    private void jlClose1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlClose1MouseClicked
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Desea cerrar el esta ventana?","Exit",dialog);
        
        if(result == 0){
            this.dispose();
        }
    }//GEN-LAST:event_jlClose1MouseClicked

    private void jlMinimize1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlMinimize1MouseClicked
        this.setState(Frame_Login.ICONIFIED);
    }//GEN-LAST:event_jlMinimize1MouseClicked

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
            java.util.logging.Logger.getLogger(Frame_DetallesEspacio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_DetallesEspacio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_DetallesEspacio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_DetallesEspacio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_DetallesEspacio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LbUsuario;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAñadir;
    private javax.swing.JLabel jLabelEliminar1;
    private javax.swing.JRadioButton jRadioBActivo;
    private javax.swing.JRadioButton jRadioBInactivo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextCapacidad;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextNombreEspacio2;
    private javax.swing.JTextField jTextNumeroEdificio2;
    private javax.swing.JTextField jTextNumeroSalon1;
    private javax.swing.JLabel jlClose1;
    private javax.swing.JLabel jlMinimize1;
    private javax.swing.JPanel panelCerrar;
    private javax.swing.JPanel paneldetallesInventario;
    // End of variables declaration//GEN-END:variables
}
