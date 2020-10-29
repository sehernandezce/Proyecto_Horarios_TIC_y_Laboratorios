
package GUI;

import Control.Validar_Login;
import Control.Validar_Registro;
import Entidad.Usuario;
import javax.swing.JOptionPane;


public class Frame_Login extends javax.swing.JFrame {

   
    private Frame_Main frame_Main =new Frame_Main();
    private int x,y;
    
    public Frame_Login() {
       initComponents();
       this.setLocationRelativeTo(null);  
       grupo_botones.add(jRBYes);
       grupo_botones.add(jRBNo);
       panelRegistrase.setVisible(false);  
      
    }
    
    
    private void logIn(){ //Iniciar Sesion
        
       try{
            Usuario usuario =new Usuario();      
            //Aqui va lo de ingresar datos usuario
            Validar_Login validar_Login=new Validar_Login();    
            usuario.setNombreusuarioInstitucional(JtfUsuario.getText());
            usuario.setContrasenia(jPasswordField1.getText());  // Falta el hash       
            usuario.setTipoUsuario(validar_Login.verificarLogin(usuario));
            usuario.setContrasenia("1234567890"); // esto sera para que luego de logearse, el hash se borre
            if( usuario.getTipoUsuario()>0){
             this.setVisible(false);
             frame_Main.entrar_bienvenida(usuario);
             frame_Main.setVisible(true);
            }else{
                //Error, no existe =0, ver el validar login
        }
            
            //
            

            
            //
       }catch(Exception e){
            JOptionPane.showMessageDialog(this,"A ocurrido un error: "+e); 
       }
       
       
    }
    
    private void logUp(){ //Registrarse
        try{
           Validar_Registro validar_Registro =new Validar_Registro();
           int valReg=validar_Registro.verificarRegistro(usuario_r.getText(),contraseñaR.getText(),conf_contraseñaR.getText(),tipUser(),codico_coordinador.getText());
           if(valReg == 1){
             JOptionPane.showMessageDialog(this,"El usuario ha sido creado exitosamente");
           }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"A ocurrido un error: "+e); 
        }
       
    }
    
    private int tipUser(){
        if(grupo_botones.isSelected(jRBYes.getModel())){
            return 2; //User estandar
        }else if(grupo_botones.isSelected(jRBNo.getModel())){
            return 1; // User Coordinador
        }else{
            return -1;
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo_botones = new javax.swing.ButtonGroup();
        panelCerrar = new javax.swing.JPanel();
        jlClose1 = new javax.swing.JLabel();
        jlMinimize1 = new javax.swing.JLabel();
        panelIniciarSesion = new javax.swing.JPanel();
        Ingresar = new javax.swing.JButton();
        LbRegistrar = new javax.swing.JLabel();
        JtfUsuario = new javax.swing.JTextField();
        LbUsuario = new javax.swing.JLabel();
        LbContraseña = new javax.swing.JLabel();
        LbResaturarC = new javax.swing.JLabel();
        signInTitle = new javax.swing.JLabel();
        userLogoLabel = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        panelRegistrase = new javax.swing.JPanel();
        usuario_r = new javax.swing.JTextField();
        usuario_institucional_r = new javax.swing.JLabel();
        contraseña_r = new javax.swing.JLabel();
        conf_contraseña_r = new javax.swing.JLabel();
        dominioUn = new javax.swing.JLabel();
        coordinador = new javax.swing.JLabel();
        registrarse = new javax.swing.JButton();
        LbRegistrar1 = new javax.swing.JLabel();
        signInTitle1 = new javax.swing.JLabel();
        contraseñaR = new javax.swing.JPasswordField();
        conf_contraseñaR = new javax.swing.JPasswordField();
        jSeparator3 = new javax.swing.JSeparator();
        jRBYes = new javax.swing.JRadioButton();
        jRBNo = new javax.swing.JRadioButton();
        codico_coordinador = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(500, 550));
        setMinimumSize(new java.awt.Dimension(500, 550));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(500, 550));
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

        panelCerrar.setBackground(new java.awt.Color(0, 51, 204));
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
        panelCerrar.add(jlClose1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, -1, -1));

        jlMinimize1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/linea.png"))); // NOI18N
        jlMinimize1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlMinimize1MouseClicked(evt);
            }
        });
        panelCerrar.add(jlMinimize1, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 10, -1, -1));

        getContentPane().add(panelCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelIniciarSesion.setBackground(new java.awt.Color(204, 204, 204));
        panelIniciarSesion.setMaximumSize(new java.awt.Dimension(500, 520));
        panelIniciarSesion.setMinimumSize(new java.awt.Dimension(500, 520));
        panelIniciarSesion.setPreferredSize(new java.awt.Dimension(500, 520));
        panelIniciarSesion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Ingresar.setText("Ingresar");
        Ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarActionPerformed(evt);
            }
        });
        panelIniciarSesion.add(Ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, 85, 28));

        LbRegistrar.setText("¿Desea registrarse?");
        LbRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LbRegistrarMouseClicked(evt);
            }
        });
        panelIniciarSesion.add(LbRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, -1, -1));
        panelIniciarSesion.add(JtfUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 230, -1));

        LbUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LbUsuario.setText("Usuario institucional");
        panelIniciarSesion.add(LbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, -1));

        LbContraseña.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LbContraseña.setText("Contraseña");
        panelIniciarSesion.add(LbContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, -1, -1));

        LbResaturarC.setText("¿Ha olvidado la contraseña?");
        LbResaturarC.setEnabled(false);
        panelIniciarSesion.add(LbResaturarC, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, -1, -1));

        signInTitle.setBackground(new java.awt.Color(203, 203, 204));
        signInTitle.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        signInTitle.setForeground(new java.awt.Color(255, 255, 255));
        signInTitle.setText("Iniciar sesión");
        panelIniciarSesion.add(signInTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, 46));

        userLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario.png"))); // NOI18N
        userLogoLabel.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario.png"))); // NOI18N
        panelIniciarSesion.add(userLogoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 70, -1));
        panelIniciarSesion.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 230, -1));
        panelIniciarSesion.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 310, 10));

        getContentPane().add(panelIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, -1));

        panelRegistrase.setBackground(new java.awt.Color(204, 204, 204));
        panelRegistrase.setMaximumSize(new java.awt.Dimension(500, 520));
        panelRegistrase.setMinimumSize(new java.awt.Dimension(500, 520));
        panelRegistrase.setPreferredSize(new java.awt.Dimension(500, 520));
        panelRegistrase.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRegistrase.add(usuario_r, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 98, -1));

        usuario_institucional_r.setText("Usuario institucional");
        panelRegistrase.add(usuario_institucional_r, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, -1, -1));

        contraseña_r.setText("Contraseña");
        panelRegistrase.add(contraseña_r, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, -1));

        conf_contraseña_r.setText("Confirmar contraseña");
        panelRegistrase.add(conf_contraseña_r, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, -1));

        dominioUn.setText("@unal.edu.co");
        panelRegistrase.add(dominioUn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, -1, 20));

        coordinador.setText("¿Es usted cooordinador de espacio?");
        panelRegistrase.add(coordinador, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        registrarse.setText("Registrarse");
        registrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarseActionPerformed(evt);
            }
        });
        panelRegistrase.add(registrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, -1, -1));

        LbRegistrar1.setText("< Regresar");
        LbRegistrar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LbRegistrar1MouseClicked(evt);
            }
        });
        panelRegistrase.add(LbRegistrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        signInTitle1.setBackground(new java.awt.Color(203, 203, 204));
        signInTitle1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        signInTitle1.setForeground(new java.awt.Color(0, 0, 0));
        signInTitle1.setText("Crear usuario");
        panelRegistrase.add(signInTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, 46));
        panelRegistrase.add(contraseñaR, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 190, -1));
        panelRegistrase.add(conf_contraseñaR, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 190, 20));
        panelRegistrase.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 310, 10));

        jRBYes.setText("Si");
        panelRegistrase.add(jRBYes, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, -1, -1));

        jRBNo.setSelected(true);
        jRBNo.setText("No");
        panelRegistrase.add(jRBNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 320, 50, -1));
        panelRegistrase.add(codico_coordinador, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 100, 30));

        getContentPane().add(panelRegistrase, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 500, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarActionPerformed
        logIn();
    }//GEN-LAST:event_IngresarActionPerformed

    private void LbRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbRegistrarMouseClicked
        panelIniciarSesion.setVisible(false);
        panelRegistrase.setVisible(true);           
    }//GEN-LAST:event_LbRegistrarMouseClicked

    private void jlClose1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlClose1MouseClicked
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Desea cerrar el programa?","Exit",dialog);
        if(result ==0){
            
            System.exit(0);
        }
    }//GEN-LAST:event_jlClose1MouseClicked

    private void jlMinimize1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlMinimize1MouseClicked
        this.setState(Frame_Login.ICONIFIED);
    }//GEN-LAST:event_jlMinimize1MouseClicked

    private void registrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarseActionPerformed
       logUp();        
    }//GEN-LAST:event_registrarseActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        x= evt.getX();   
        y= evt.getY(); 
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        this.setLocation(this.getLocation().x + evt.getX()-x,this.getLocation().y+evt.getY()-y);
    }//GEN-LAST:event_formMouseDragged

    private void LbRegistrar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbRegistrar1MouseClicked
        panelIniciarSesion.setVisible(true);
        panelRegistrase.setVisible(false);  
    }//GEN-LAST:event_LbRegistrar1MouseClicked

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
            java.util.logging.Logger.getLogger(Frame_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_Login().setVisible(true);
            }
        });
        
        
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Ingresar;
    private javax.swing.JTextField JtfUsuario;
    private javax.swing.JLabel LbContraseña;
    private javax.swing.JLabel LbRegistrar;
    private javax.swing.JLabel LbRegistrar1;
    private javax.swing.JLabel LbResaturarC;
    private javax.swing.JLabel LbUsuario;
    private javax.swing.JPasswordField codico_coordinador;
    private javax.swing.JPasswordField conf_contraseñaR;
    private javax.swing.JLabel conf_contraseña_r;
    private javax.swing.JPasswordField contraseñaR;
    private javax.swing.JLabel contraseña_r;
    private javax.swing.JLabel coordinador;
    private javax.swing.JLabel dominioUn;
    private javax.swing.ButtonGroup grupo_botones;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JRadioButton jRBNo;
    private javax.swing.JRadioButton jRBYes;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel jlClose1;
    private javax.swing.JLabel jlMinimize1;
    private javax.swing.JPanel panelCerrar;
    private javax.swing.JPanel panelIniciarSesion;
    private javax.swing.JPanel panelRegistrase;
    private javax.swing.JButton registrarse;
    private javax.swing.JLabel signInTitle;
    private javax.swing.JLabel signInTitle1;
    private javax.swing.JLabel userLogoLabel;
    private javax.swing.JLabel usuario_institucional_r;
    private javax.swing.JTextField usuario_r;
    // End of variables declaration//GEN-END:variables
}
