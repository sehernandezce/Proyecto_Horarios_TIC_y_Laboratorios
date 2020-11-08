package GUI;

import Control.ValidarEspacios;
import Control.ValidarInventario;
import Entidad.Espacio;
import Entidad.Usuario;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Frame_DetallesEspacio extends javax.swing.JFrame {

    private int x,y;
    private Usuario usuario;
    Frame_Main fraim;
    private ValidarInventario validarInventario=new ValidarInventario();
    public Frame_DetallesEspacio() {
        initComponents();
        this.setLocationRelativeTo(null);  
        buttonGroup1.add(jRadioBActivo);
        buttonGroup1.add(jRadioBInactivo);
        habilitarControles(jTextField3,false);
        jButtonEditar.setVisible(false);
        habtext(false);
      
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
        jTextCorreoEncargado = new javax.swing.JTextField();
        jTextNombreEspacio2 = new javax.swing.JTextField();
        jTextCapacidad = new javax.swing.JTextField();
        jTextNombreEdificio = new javax.swing.JTextField();
        jTextNumeroSalon1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextNumeroEdificio3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextCorreoEncargado1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        panelCerrar = new javax.swing.JPanel();
        jlClose1 = new javax.swing.JLabel();
        jlMinimize1 = new javax.swing.JLabel();
        LbUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(770, 617));
        setUndecorated(true);
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
        jLabel1.setText("Correo Encargado:");
        paneldetallesInventario.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Detalles de inventario:");
        paneldetallesInventario.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Capacidad:");
        paneldetallesInventario.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tipo de espacio:");
        paneldetallesInventario.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Nombre del Espacio:");
        paneldetallesInventario.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Nombre Edificio:");
        paneldetallesInventario.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 110, 20));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Estado:");
        paneldetallesInventario.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Salón:");
        paneldetallesInventario.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, -1, -1));

        jRadioBActivo.setBackground(new java.awt.Color(204, 204, 204));
        jRadioBActivo.setForeground(new java.awt.Color(60, 63, 65));
        jRadioBActivo.setSelected(true);
        jRadioBActivo.setText("Activo");
        paneldetallesInventario.add(jRadioBActivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, -1, -1));

        jRadioBInactivo.setBackground(new java.awt.Color(204, 204, 204));
        jRadioBInactivo.setForeground(new java.awt.Color(60, 63, 65));
        jRadioBInactivo.setText("Inactivo");
        paneldetallesInventario.add(jRadioBInactivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 230, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setText("Información del espacio:");
        paneldetallesInventario.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jTable1 = new javax.swing.JTable(){
            public boolean isCellEditable (int rowIndex, int colIndex){
                if(colIndex==1 || colIndex== 2){
                    return true;
                }else{
                    return false;
                }

            }
        };
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setEnabled(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        paneldetallesInventario.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 700, 230));

        jLabelAñadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/anadir.png"))); // NOI18N
        paneldetallesInventario.add(jLabelAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, -1, -1));

        jLabelEliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar.png"))); // NOI18N
        paneldetallesInventario.add(jLabelEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 270, -1, -1));

        jButtonEditar.setBackground(new java.awt.Color(204, 204, 204));
        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });
        paneldetallesInventario.add(jButtonEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 550, 90, 30));

        jButtonGuardar.setBackground(new java.awt.Color(204, 204, 204));
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        paneldetallesInventario.add(jButtonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 550, 100, 30));

        jTextCorreoEncargado.setEnabled(false);
        paneldetallesInventario.add(jTextCorreoEncargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 150, 30));

        jTextNombreEspacio2.setEnabled(false);
        paneldetallesInventario.add(jTextNombreEspacio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 220, 30));

        jTextCapacidad.setEnabled(false);
        paneldetallesInventario.add(jTextCapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 70, 30));

        jTextNombreEdificio.setEnabled(false);
        jTextNombreEdificio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombreEdificioActionPerformed(evt);
            }
        });
        paneldetallesInventario.add(jTextNombreEdificio, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 260, 30));

        jTextNumeroSalon1.setEnabled(false);
        paneldetallesInventario.add(jTextNumeroSalon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 70, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Numero Edificio:");
        paneldetallesInventario.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, 110, 20));

        jTextNumeroEdificio3.setEnabled(false);
        jTextNumeroEdificio3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNumeroEdificio3ActionPerformed(evt);
            }
        });
        paneldetallesInventario.add(jTextNumeroEdificio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, 110, 30));

        jTextField2.setBackground(new java.awt.Color(204, 204, 204));
        jTextField2.setForeground(new java.awt.Color(204, 204, 204));
        jTextField2.setBorder(null);
        jTextField2.setCaretColor(new java.awt.Color(204, 204, 204));
        jTextField2.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jTextField2.setEnabled(false);
        jTextField2.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        jTextField2.setSelectionColor(new java.awt.Color(204, 204, 204));
        paneldetallesInventario.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 150, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Nombre Encargado:");
        paneldetallesInventario.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jTextCorreoEncargado1.setEnabled(false);
        paneldetallesInventario.add(jTextCorreoEncargado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 140, 30));

        jTextField3.setDisabledTextColor(new java.awt.Color(69, 73, 74));
        jTextField3.setEnabled(false);
        paneldetallesInventario.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 150, 30));

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
    
//    public boolean isCellEditable (int rowIndex, int colIndex){
//             return false;
//         }
   
     private void habtext(boolean b){          
        jButtonGuardar.setVisible(b);
        jLabelAñadir.setVisible(b);
        jLabelEliminar1.setVisible(b);         
         habilitarControles(jTextNombreEspacio2,b);
         habilitarControles(jTextCorreoEncargado,b);
         habilitarControles(jTextCorreoEncargado1,b);
         habilitarControles(jTextCapacidad,b);
         habilitarControles(jTextNumeroSalon1,b);
         habilitarControles(jTextNumeroEdificio3,b);
         habilitarControles(jTextNombreEdificio,b); 
         jRadioBActivo.setEnabled(b);
         jRadioBInactivo.setEnabled(b);
         jTable1.setEnabled(b);                  
         
     }
    public void llenarFrame(Usuario u, Espacio esp, Frame_Main frame) throws SQLException{
        this.usuario=u;
        this.fraim = frame;
        jTextCorreoEncargado.setText(esp.getNombre_tipoespacio());
        if(esp.getNombre_espacio().equals(null)){
             jTextNombreEspacio2.setText(" ");
        }else{
             jTextNombreEspacio2.setText(esp.getNombre_espacio());
        }
        jTextField2.setText(String.valueOf(esp.getId_espacio()));
        jTextField3.setText(esp.getNombre_tipoespacio());
        jTextCorreoEncargado.setText(esp.getCorreo_encargado());
        jTextCorreoEncargado1.setText(esp.getNombre_encargado());        
        jTextNumeroSalon1.setText(esp.getNum_Espacio());
        jTextNombreEdificio.setText(esp.getNombre_edificio());
        jTextNumeroEdificio3.setText(String.valueOf(esp.getNum_edificio()));     
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
         tabla, new String [] {"Id inventario", "Nombre", "Descripción" }){                              
                      } 
                         );
          if(usuario.getTipoUsuario()==2){
            jButtonEditar.setVisible(true);
        }
    }
    
    private void habilitarEdit(){
        if(usuario.getTipoUsuario()==2){
          habtext(true);           
        }
        
    }
    
    private Espacio capturarE(){
        Espacio espacio= new Espacio();
                espacio.setId_espacio(Integer.valueOf(jTextField2.getText()));
                espacio.setNombre_espacio(jTextNombreEspacio2.getText());
                espacio.setNum_Espacio(jTextNumeroSalon1.getText());
                espacio.setNombre_edificio(jTextNombreEdificio.getText());
                espacio.setNum_edificio(Integer.valueOf(jTextNumeroEdificio3.getText()));
                espacio.setNombre_encargado(jTextCorreoEncargado1.getText());
                 espacio.setCorreo_encargado(jTextCorreoEncargado.getText());
                if(jRadioBActivo.isSelected()){
                    espacio.setEstado(true);
                }else{
                   espacio.setEstado(false);
                } 
                espacio.setCapacidad(Integer.valueOf(jTextCapacidad.getText()));  
                
                espacio.setNombre_tipoespacio(jTextField3.getText());
                
        
        return espacio;
    }
    
    private void guardar(){
         boolean verif=false;
        try{
            Integer.valueOf(jTextNumeroEdificio3.getText());
            Integer.valueOf(jTextCapacidad.getText());
            Integer.valueOf(jTextCapacidad.getText());
            verif=true;
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, "Ha ingresado un valor no valido",  "Valor no valido", JOptionPane.INFORMATION_MESSAGE);
        }
        if(verif && !jTextCorreoEncargado.getText().equals(usuario.getNombreusuarioInstitucional())){
            ValidarEspacios validarEspacios = new ValidarEspacios ();
             int n= validarEspacios.ValidarInfoEspacio(usuario, capturarE());
             if(n==1){
               JOptionPane.showMessageDialog(null, "Se han actualizado los datos correctamente",  "Guardado", JOptionPane.INFORMATION_MESSAGE);  
              }else if(n==-1 || n==-5){
                 JOptionPane.showMessageDialog(null, "El usuario "+usuario.getNombreusuarioInstitucional()+" no tiene permisos para modificar los espacios" ,  "Accion invalida", JOptionPane.INFORMATION_MESSAGE);   
              }else if(n==-2){
                 JOptionPane.showMessageDialog(null, "Ya existe un espacio con el edificio y salon : "+ jTextNumeroEdificio3.getText() +" " + jTextNumeroSalon1.getText(),  "Accion invalida", JOptionPane.INFORMATION_MESSAGE);   
              }else if(n==-3){
                 JOptionPane.showMessageDialog(null, "El usuario "+jTextCorreoEncargado.getText() +" no existe" ,  "Accion invalida", JOptionPane.INFORMATION_MESSAGE);   
              }else if(n==-4){
                 JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar conectar con el servidor" ,  "Error", JOptionPane.INFORMATION_MESSAGE);   
              }else if(n==-6){
                 JOptionPane.showMessageDialog(null, "Usuario de encargado invalido" ,  "Accion invalida", JOptionPane.INFORMATION_MESSAGE);   
              }         
        }
     }
    private void jlClose1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlClose1MouseClicked
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Desea cerrar el esta ventana?","Exit",dialog);
        
        if(result == 0){
            this.fraim.enable(true);
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

    private void jTextNombreEdificioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombreEdificioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombreEdificioActionPerformed

    private void jTextNumeroEdificio3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNumeroEdificio3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNumeroEdificio3ActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
         habilitarEdit();
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        guardar();
       
    }//GEN-LAST:event_jButtonGuardarActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTextField jTextCorreoEncargado;
    private javax.swing.JTextField jTextCorreoEncargado1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextNombreEdificio;
    private javax.swing.JTextField jTextNombreEspacio2;
    private javax.swing.JTextField jTextNumeroEdificio3;
    private javax.swing.JTextField jTextNumeroSalon1;
    private javax.swing.JLabel jlClose1;
    private javax.swing.JLabel jlMinimize1;
    private javax.swing.JPanel panelCerrar;
    private javax.swing.JPanel paneldetallesInventario;
    // End of variables declaration//GEN-END:variables
}
