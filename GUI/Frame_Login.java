package GUI;

import Control.Validar_Login;
import Control.Validar_Registro;
import Control.ManipularConecciones;
import Entidad.Usuario;
import Hilos.HiloCargando;
import Hilos.HiloFrame_Login;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Frame_Login extends javax.swing.JFrame {

    private Frame_Main frame_Main = new Frame_Main();
    private ManipularConecciones datosConexion = new ManipularConecciones();
    private ManipularConecciones datosConexionTemporal = new ManipularConecciones();
    private static HiloFrame_Login hiloFrame_Login= new HiloFrame_Login();
    private static final HiloCargando hiloCargando= new HiloCargando();;
    private int x, y;

    public Frame_Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        grupo_botones.add(jRBYes);
        grupo_botones.add(jRBNo);
        panelRegistrase.setVisible(false);
        panelRecupararCon.setVisible(false);        
        hiloFrame_Login.setVariable(this);
        hiloCargando.setVariable(jLCargando2);
        jLCargando2.setVisible(false);
    }
    

            

    private void creaConexionTemporal() {
        Usuario us = new Usuario();
        us.setTipoUsuario(-10);
        datosConexionTemporal.crearConeccion(us);
    }

    public void logIn() { 
            
        try {
            creaConexionTemporal();
            Usuario usuario = new Usuario();         

            usuario.setNombreusuarioInstitucional(JtfUsuario.getText());
            usuario.setContrasenia(jPasswordField1.getText());   

            Validar_Login validar_Login = new Validar_Login(datosConexionTemporal);
            usuario.setTipoUsuario(validar_Login.verificarLogin(usuario));
            usuario.setContrasenia("1234567890"); 

            datosConexion.crearConeccion(usuario);
            if (usuario.getTipoUsuario() > 0 && usuario.getTipoUsuario() != 3 && usuario.getTipoUsuario() != 5) {
                frame_Main.entrar_bienvenida(usuario);               
                frame_Main.setVisible(true);
                frame_Main.setdataConexiones(datosConexion);
                hiloCargando.finalizarhilo();
                this.dispose();

            } else if (usuario.getTipoUsuario() == -1 || usuario.getTipoUsuario() == 3 || usuario.getTipoUsuario() == 5) {
                JOptionPane.showMessageDialog(null, "Usuario no Valido", "Longitud nombre", JOptionPane.INFORMATION_MESSAGE);
            } else if (usuario.getTipoUsuario() == -2) {
                JOptionPane.showMessageDialog(null, "Contraseña no Valida", "Longitud contraseña", JOptionPane.INFORMATION_MESSAGE);
            } else if (usuario.getTipoUsuario() == 0) {
                JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos", "Datos incorrectos", JOptionPane.INFORMATION_MESSAGE);
            } else if (usuario.getTipoUsuario() == -3) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar conectar con el servidor de base de datos", "Error", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (ExceptionInInitializerError e) {
            JOptionPane.showMessageDialog(this, "A ocurrido un error: " + e.getClass());
        } catch (Exception ex) {
            Logger.getLogger(Frame_Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        hiloCargando.finalizarhilo();
    }

    private void logUp() { 
        try {
            creaConexionTemporal();
            Validar_Registro validar_Registro = new Validar_Registro(datosConexionTemporal);
           validar_Registro.crearCodC();
           int valReg = validar_Registro.verificarRegistro(usuario_r.getText(),contraseñaR.getText(),conf_contraseñaR.getText(),tipUser(),codico_coordinador.getText());
           if(valReg == 1){
             JOptionPane.showMessageDialog(this,"El usuario ha sido creado exitosamente");
           }else if(valReg == -1){
                JOptionPane.showMessageDialog(null, "Usuario no Valido",  "Usuario no Valido", JOptionPane.INFORMATION_MESSAGE);
            }else if(valReg == -2){
                JOptionPane.showMessageDialog(null, "Contraseña no Valida",  "Contraseña no Valida", JOptionPane.INFORMATION_MESSAGE);
            }else if(valReg == -3){
                 JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden",  "Problema con Contraseñas", JOptionPane.INFORMATION_MESSAGE);
            }else if(valReg == -4){
                JOptionPane.showMessageDialog(null, "La contraseña no es segura. Debe tener al menos un numero, una mayuscula, una minuscula y minimo 9 caracteres",  "Contraseña no segura", JOptionPane.INFORMATION_MESSAGE);
            }else if(valReg == -5){
                JOptionPane.showMessageDialog(null, "El codigo de coordinador no es correcto",  "Codigo incorrecto", JOptionPane.INFORMATION_MESSAGE);
            }else if(valReg == -6){
                JOptionPane.showMessageDialog(null, "El usuario ya existe",  "Usuario ya existe", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "A ocurrido un error, nombre del error: " + e);
        }

    }

    private int tipUser() {
        if (grupo_botones.isSelected(jRBYes.getModel())) {
            return 2;
        } else if (grupo_botones.isSelected(jRBNo.getModel())) {
            return 1; 
        } else {
            return -1;
        }
    }

    private void forgetPass() throws Exception {
        creaConexionTemporal(); 
        Validar_Login validar_Login = new Validar_Login(datosConexionTemporal);
        
        int val = validar_Login.existeUser(usuario_r3.getText());
        if (val == -1) {
            JOptionPane.showMessageDialog(null, "Valide el usuario ingresado", "Error", JOptionPane.INFORMATION_MESSAGE);
        } else if (val == 1) {
            JOptionPane.showMessageDialog(null, "El correo ha sido enviado.", "Enviar codigo", JOptionPane.INFORMATION_MESSAGE);
            jPanelCam.setEnabled(true);
        } else if (val == -2) {
            JOptionPane.showMessageDialog(null, "Ya se ha generado un código, por favor valide el correo.", "Acción no valida", JOptionPane.INFORMATION_MESSAGE);

        } else if (val == -3) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al enviar el correo, por favor intente más tarde.", "Error", JOptionPane.INFORMATION_MESSAGE);

        } else if (val == -4) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al generar el código, por favor intente más tarde.", "Error", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    private void CamPass() throws Exception {
        creaConexionTemporal();
        Validar_Registro validar_Registro = new Validar_Registro(datosConexionTemporal);
        int valReg = validar_Registro.camPass(usuario_r2.getText(), contraseñaR1.getText(), conf_contraseñaR1.getText(), conf_contraseñaR2.getText());
        if (valReg == 1) { 
            JOptionPane.showMessageDialog(this, "La contraseña se ha cambiado exitosamente");
        } else if (valReg == -1) {
            JOptionPane.showMessageDialog(null, "Usuario no Valido", "Usuario no Valido", JOptionPane.INFORMATION_MESSAGE);
        } else if (valReg == -2) {
            JOptionPane.showMessageDialog(null, "Contraseña no Valida", "Contraseña no Valida", JOptionPane.INFORMATION_MESSAGE);
        } else if (valReg == -3) {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Problema con Contraseñas", JOptionPane.INFORMATION_MESSAGE);
        } else if (valReg == -4) {
            JOptionPane.showMessageDialog(null, "La contraseña no es segura. Debe tener al menos un numero, una mayuscula, una minuscula y minimo 9 caracteres", "Contraseña no segura", JOptionPane.INFORMATION_MESSAGE);
        } else if (valReg == -5) {
            JOptionPane.showMessageDialog(null, "Contraseña no Valida",  "Contraseña no Valida", JOptionPane.INFORMATION_MESSAGE);
            }else if(valReg == -6){
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error con el servidor",  "Error", JOptionPane.INFORMATION_MESSAGE);
         
            }
                
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo_botones = new javax.swing.ButtonGroup();
        panelCerrar = new javax.swing.JPanel();
        jlClose1 = new javax.swing.JLabel();
        jlMinimize1 = new javax.swing.JLabel();
        LbUsuario = new javax.swing.JLabel();
        panelIniciarSesion = new javax.swing.JPanel();
        Ingresar = new javax.swing.JButton();
        LbRegistrar = new javax.swing.JLabel();
        JtfUsuario = new javax.swing.JTextField();
        LbContraseña = new javax.swing.JLabel();
        signInTitle = new javax.swing.JLabel();
        userLogoLabel = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        LbUsuario1 = new javax.swing.JLabel();
        LbRegistrar2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLCargando2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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
        conf_contraseña_r1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelRecupararCon = new javax.swing.JPanel();
        registrarse1 = new javax.swing.JButton();
        LbRegistrar3 = new javax.swing.JLabel();
        signInTitle2 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        usuario_r3 = new javax.swing.JTextField();
        usuario_institucional_r3 = new javax.swing.JLabel();
        usuario_institucional_r4 = new javax.swing.JLabel();
        usuario_institucional_r5 = new javax.swing.JLabel();
        usuario_institucional_r6 = new javax.swing.JLabel();
        jPanelCam = new javax.swing.JPanel();
        signInTitle3 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        usuario_r2 = new javax.swing.JTextField();
        usuario_institucional_r2 = new javax.swing.JLabel();
        dominioUn1 = new javax.swing.JLabel();
        contraseñaR1 = new javax.swing.JPasswordField();
        contraseña_r1 = new javax.swing.JLabel();
        conf_contraseñaR1 = new javax.swing.JPasswordField();
        conf_contraseña_r2 = new javax.swing.JLabel();
        conf_contraseña_r3 = new javax.swing.JLabel();
        conf_contraseñaR2 = new javax.swing.JPasswordField();
        registrarse2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCerrar.setBackground(new java.awt.Color(86, 90, 92));
        panelCerrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
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
        panelCerrar.add(jlClose1, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 8, -1, -1));

        jlMinimize1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/linea.png"))); // NOI18N
        jlMinimize1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlMinimize1MouseClicked(evt);
            }
        });
        panelCerrar.add(jlMinimize1, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 10, -1, -1));

        LbUsuario.setBackground(new java.awt.Color(0, 51, 204));
        LbUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LbUsuario.setForeground(new java.awt.Color(255, 255, 255));
        LbUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo u_preview_rev_1_opt.png"))); // NOI18N
        LbUsuario.setText("Horarios de salas TIC's y Laboratorios");
        panelCerrar.add(LbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 6, 240, 20));

        getContentPane().add(panelCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelIniciarSesion.setBackground(new java.awt.Color(166, 28, 26));
        panelIniciarSesion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        panelIniciarSesion.setMaximumSize(new java.awt.Dimension(500, 520));
        panelIniciarSesion.setMinimumSize(new java.awt.Dimension(500, 520));
        panelIniciarSesion.setPreferredSize(new java.awt.Dimension(500, 520));
        panelIniciarSesion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Ingresar.setBackground(new java.awt.Color(0, 255, 240));
        Ingresar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Ingresar.setText("Ingresar");
        Ingresar.setBorder(null);
        Ingresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                IngresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                IngresarMouseExited(evt);
            }
        });
        Ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarActionPerformed(evt);
            }
        });
        panelIniciarSesion.add(Ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 85, 30));

        LbRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LbRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        LbRegistrar.setText("¿Desea registrarse?");
        LbRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LbRegistrarMouseClicked(evt);
            }
        });
        panelIniciarSesion.add(LbRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, 107, -1));

        JtfUsuario.setText("Usuario institucional");
        JtfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtfUsuarioActionPerformed(evt);
            }
        });
        panelIniciarSesion.add(JtfUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 230, 30));

        LbContraseña.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LbContraseña.setForeground(new java.awt.Color(255, 255, 255));
        LbContraseña.setText("Contraseña");
        panelIniciarSesion.add(LbContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 62, -1));

        signInTitle.setBackground(new java.awt.Color(177, 178, 176));
        signInTitle.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        signInTitle.setForeground(new java.awt.Color(177, 178, 176));
        signInTitle.setText("Iniciar sesión");
        panelIniciarSesion.add(signInTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 293, 46));

        userLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario.png"))); // NOI18N
        userLogoLabel.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario.png"))); // NOI18N
        panelIniciarSesion.add(userLogoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 70, -1));

        jPasswordField1.setText("Contraseña");
        jPasswordField1.setMinimumSize(new java.awt.Dimension(15, 20));
        jPasswordField1.setPreferredSize(new java.awt.Dimension(15, 20));
        panelIniciarSesion.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 230, 30));
        panelIniciarSesion.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 310, 10));

        LbUsuario1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LbUsuario1.setForeground(new java.awt.Color(255, 255, 255));
        LbUsuario1.setText("Usuario institucional (sin @unal.edu.co)");
        panelIniciarSesion.add(LbUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 230, -1));

        LbRegistrar2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LbRegistrar2.setForeground(new java.awt.Color(255, 255, 255));
        LbRegistrar2.setText("¿Ha olvidado su contraseña?");
        LbRegistrar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LbRegistrar2MouseClicked(evt);
            }
        });
        panelIniciarSesion.add(LbRegistrar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 160, -1));
        panelIniciarSesion.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));

        jLCargando2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reloj-de-arena.png"))); // NOI18N
        panelIniciarSesion.add(jLCargando2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 389, 16, 16));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo1.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        panelIniciarSesion.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-570, 0, -1, -1));

        getContentPane().add(panelIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, -1));

        panelRegistrase.setBackground(new java.awt.Color(204, 204, 204));
        panelRegistrase.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        panelRegistrase.setMaximumSize(new java.awt.Dimension(500, 520));
        panelRegistrase.setMinimumSize(new java.awt.Dimension(500, 520));
        panelRegistrase.setPreferredSize(new java.awt.Dimension(500, 520));
        panelRegistrase.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usuario_r.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        usuario_r.setText("Usuario institucional");
        panelRegistrase.add(usuario_r, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 140, 30));

        usuario_institucional_r.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        usuario_institucional_r.setForeground(new java.awt.Color(255, 255, 255));
        usuario_institucional_r.setText("Usuario institucional :");
        panelRegistrase.add(usuario_institucional_r, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, 30));

        contraseña_r.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        contraseña_r.setForeground(new java.awt.Color(255, 255, 255));
        contraseña_r.setText("Contraseña: ");
        panelRegistrase.add(contraseña_r, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, -1, 30));

        conf_contraseña_r.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        conf_contraseña_r.setForeground(new java.awt.Color(255, 255, 255));
        conf_contraseña_r.setText(" de espacio?");
        panelRegistrase.add(conf_contraseña_r, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, -1, 30));

        dominioUn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dominioUn.setForeground(new java.awt.Color(255, 255, 255));
        dominioUn.setText("@unal.edu.co");
        panelRegistrase.add(dominioUn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, -1, 30));

        coordinador.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        coordinador.setForeground(new java.awt.Color(255, 255, 255));
        coordinador.setText("¿Es usted cooordinador");
        panelRegistrase.add(coordinador, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, 40));

        registrarse.setBackground(new java.awt.Color(0, 255, 240));
        registrarse.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        registrarse.setText("Registrarse");
        registrarse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registrarseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registrarseMouseExited(evt);
            }
        });
        registrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarseActionPerformed(evt);
            }
        });
        panelRegistrase.add(registrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, 100, 30));

        LbRegistrar1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LbRegistrar1.setForeground(new java.awt.Color(255, 255, 255));
        LbRegistrar1.setText("< Regresar");
        LbRegistrar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LbRegistrar1MouseClicked(evt);
            }
        });
        panelRegistrase.add(LbRegistrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        signInTitle1.setBackground(new java.awt.Color(203, 203, 204));
        signInTitle1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        signInTitle1.setForeground(new java.awt.Color(177, 178, 176));
        signInTitle1.setText("Crear usuario");
        panelRegistrase.add(signInTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, 46));

        contraseñaR.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        contraseñaR.setText("Contraseña");
        panelRegistrase.add(contraseñaR, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 230, 30));

        conf_contraseñaR.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        conf_contraseñaR.setText("Contraseña");
        panelRegistrase.add(conf_contraseñaR, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 230, 30));
        panelRegistrase.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 310, 10));

        jRBYes.setBackground(new java.awt.Color(204, 204, 204));
        jRBYes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRBYes.setForeground(new java.awt.Color(255, 255, 255));
        jRBYes.setText("Si");
        jRBYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBYesActionPerformed(evt);
            }
        });
        panelRegistrase.add(jRBYes, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 50, 30));

        jRBNo.setBackground(new java.awt.Color(204, 204, 204));
        jRBNo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRBNo.setForeground(new java.awt.Color(255, 255, 255));
        jRBNo.setSelected(true);
        jRBNo.setText("No");
        jRBNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBNoActionPerformed(evt);
            }
        });
        panelRegistrase.add(jRBNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, -1, 30));

        codico_coordinador.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        codico_coordinador.setText("Codigo");
        codico_coordinador.setEnabled(false);
        codico_coordinador.setFocusable(false);
        panelRegistrase.add(codico_coordinador, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 110, 30));

        conf_contraseña_r1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        conf_contraseña_r1.setForeground(new java.awt.Color(255, 255, 255));
        conf_contraseña_r1.setText("Confirmar contraseña:");
        panelRegistrase.add(conf_contraseña_r1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo1.jpg"))); // NOI18N
        jLabel3.setText("jLabel2");
        panelRegistrase.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(panelRegistrase, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 500, 520));

        panelRecupararCon.setBackground(new java.awt.Color(204, 204, 204));
        panelRecupararCon.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        panelRecupararCon.setMaximumSize(new java.awt.Dimension(500, 520));
        panelRecupararCon.setMinimumSize(new java.awt.Dimension(500, 520));
        panelRecupararCon.setPreferredSize(new java.awt.Dimension(500, 520));
        panelRecupararCon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        registrarse1.setBackground(new java.awt.Color(0, 255, 240));
        registrarse1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        registrarse1.setText("Enviar");
        registrarse1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registrarse1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registrarse1MouseExited(evt);
            }
        });
        registrarse1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarse1ActionPerformed(evt);
            }
        });
        panelRecupararCon.add(registrarse1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 70, 30));

        LbRegistrar3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LbRegistrar3.setForeground(new java.awt.Color(255, 255, 255));
        LbRegistrar3.setText("< Regresar");
        LbRegistrar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LbRegistrar3MouseClicked(evt);
            }
        });
        panelRecupararCon.add(LbRegistrar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        signInTitle2.setBackground(new java.awt.Color(177, 178, 176));
        signInTitle2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        signInTitle2.setForeground(new java.awt.Color(177, 178, 176));
        signInTitle2.setText("Recuperar contraseña");
        panelRecupararCon.add(signInTitle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, 46));
        panelRecupararCon.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 310, 10));

        usuario_r3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        usuario_r3.setText("Usuario institucional");
        usuario_r3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuario_r3ActionPerformed(evt);
            }
        });
        panelRecupararCon.add(usuario_r3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 160, 30));

        usuario_institucional_r3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        usuario_institucional_r3.setForeground(new java.awt.Color(255, 255, 255));
        usuario_institucional_r3.setText("para cambiar su contraseña.");
        panelRecupararCon.add(usuario_institucional_r3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 170, 30));

        usuario_institucional_r4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        usuario_institucional_r4.setForeground(new java.awt.Color(255, 255, 255));
        usuario_institucional_r4.setText("( sin @unal.edu.co)");
        panelRecupararCon.add(usuario_institucional_r4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 110, -1));

        usuario_institucional_r5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        usuario_institucional_r5.setForeground(new java.awt.Color(255, 255, 255));
        usuario_institucional_r5.setText("Al correo se enviará un código de seguridad,");
        panelRecupararCon.add(usuario_institucional_r5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 250, 30));

        usuario_institucional_r6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        usuario_institucional_r6.setForeground(new java.awt.Color(255, 255, 255));
        usuario_institucional_r6.setText("Usuario institucional:");
        panelRecupararCon.add(usuario_institucional_r6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 120, 30));

        jPanelCam.setBackground(new java.awt.Color(204, 204, 204));
        jPanelCam.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanelCam.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        signInTitle3.setBackground(new java.awt.Color(177, 178, 176));
        signInTitle3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        signInTitle3.setForeground(new java.awt.Color(177, 178, 176));
        signInTitle3.setText("Cambiar contraseña");
        jPanelCam.add(signInTitle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, 46));
        jPanelCam.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 310, 10));

        usuario_r2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        usuario_r2.setText("Usuario institucional");
        usuario_r2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuario_r2ActionPerformed(evt);
            }
        });
        jPanelCam.add(usuario_r2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 140, 30));

        usuario_institucional_r2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        usuario_institucional_r2.setForeground(new java.awt.Color(255, 255, 255));
        usuario_institucional_r2.setText("Usuario institucional :");
        jPanelCam.add(usuario_institucional_r2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, 30));

        dominioUn1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dominioUn1.setForeground(new java.awt.Color(255, 255, 255));
        dominioUn1.setText("@unal.edu.co");
        jPanelCam.add(dominioUn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, 30));

        contraseñaR1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        contraseñaR1.setText("Contraseña");
        jPanelCam.add(contraseñaR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 240, 30));

        contraseña_r1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        contraseña_r1.setForeground(new java.awt.Color(255, 255, 255));
        contraseña_r1.setText("Contraseña nueva: ");
        jPanelCam.add(contraseña_r1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, 30));

        conf_contraseñaR1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        conf_contraseñaR1.setText("Contraseña");
        jPanelCam.add(conf_contraseñaR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 240, 30));

        conf_contraseña_r2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        conf_contraseña_r2.setForeground(new java.awt.Color(255, 255, 255));
        conf_contraseña_r2.setText("Confirmar contraseña:");
        jPanelCam.add(conf_contraseña_r2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, 30));

        conf_contraseña_r3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        conf_contraseña_r3.setForeground(new java.awt.Color(255, 255, 255));
        conf_contraseña_r3.setText("Codigo:");
        jPanelCam.add(conf_contraseña_r3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, -1, 30));

        conf_contraseñaR2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        conf_contraseñaR2.setText("Codigo");
        jPanelCam.add(conf_contraseñaR2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 130, 30));

        registrarse2.setBackground(new java.awt.Color(0, 255, 240));
        registrarse2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        registrarse2.setText("Guardar");
        registrarse2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registrarse2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registrarse2MouseExited(evt);
            }
        });
        registrarse2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarse2ActionPerformed(evt);
            }
        });
        jPanelCam.add(registrarse2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, -1, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo1.jpg"))); // NOI18N
        jLabel5.setText("jLabel2");
        jPanelCam.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelRecupararCon.add(jPanelCam, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 480, 290));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo1.jpg"))); // NOI18N
        jLabel4.setText("jLabel2");
        panelRecupararCon.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-900, 0, -1, -1));

        getContentPane().add(panelRecupararCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 500, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarActionPerformed
        hiloCargando.Iniciar("Cargando_logIn");   
        hiloFrame_Login.Iniciar("logIn", "");         
    }//GEN-LAST:event_IngresarActionPerformed

    private void LbRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbRegistrarMouseClicked
        panelIniciarSesion.setVisible(false);
        panelRegistrase.setVisible(true);
    }//GEN-LAST:event_LbRegistrarMouseClicked

    private void jlClose1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlClose1MouseClicked
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Desea cerrar el programa?", "Exit", dialog);
        if (result == 0) {         
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
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_formMouseDragged

    private void LbRegistrar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbRegistrar1MouseClicked
        panelIniciarSesion.setVisible(true);
        panelRegistrase.setVisible(false);
    }//GEN-LAST:event_LbRegistrar1MouseClicked

    private void jRBYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBYesActionPerformed
        codico_coordinador.setFocusable(true);
        codico_coordinador.setEnabled(true);
    }//GEN-LAST:event_jRBYesActionPerformed

    private void jRBNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBNoActionPerformed
        codico_coordinador.setFocusable(false);
        codico_coordinador.setEnabled(false);
    }//GEN-LAST:event_jRBNoActionPerformed

    private void JtfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtfUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtfUsuarioActionPerformed

    private void registrarse1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarse1ActionPerformed

        try {
            forgetPass();
        } catch (Exception ex) {
            Logger.getLogger(Frame_Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_registrarse1ActionPerformed

    private void LbRegistrar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbRegistrar3MouseClicked
        panelIniciarSesion.setVisible(true);
        panelRecupararCon.setVisible(false);

    }//GEN-LAST:event_LbRegistrar3MouseClicked

    private void usuario_r3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuario_r3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuario_r3ActionPerformed

    private void usuario_r2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuario_r2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuario_r2ActionPerformed

    private void registrarse2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarse2ActionPerformed
        try {
            CamPass();
        } catch (Exception ex) {
            Logger.getLogger(Frame_Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_registrarse2ActionPerformed

    private void LbRegistrar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbRegistrar2MouseClicked
        panelRecupararCon.setVisible(true);
        panelIniciarSesion.setVisible(false);
    }//GEN-LAST:event_LbRegistrar2MouseClicked

    private void IngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IngresarMouseEntered
    
      Ingresar.setBackground(new Color(69, 162, 156));
    }//GEN-LAST:event_IngresarMouseEntered

    private void IngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IngresarMouseExited
      Ingresar.setBackground(new Color(0,255,240));
    }//GEN-LAST:event_IngresarMouseExited

    private void registrarseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarseMouseEntered
      
        registrarse.setBackground(new Color(69, 162, 156));
    }//GEN-LAST:event_registrarseMouseEntered

    private void registrarseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarseMouseExited
      registrarse.setBackground(new Color(0,255,240));
    }//GEN-LAST:event_registrarseMouseExited

    private void registrarse1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarse1MouseEntered
       
       registrarse1.setBackground(new Color(69, 162, 156));
    }//GEN-LAST:event_registrarse1MouseEntered

    private void registrarse1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarse1MouseExited
       registrarse1.setBackground(new Color(0,255,240)); 
    }//GEN-LAST:event_registrarse1MouseExited

    private void registrarse2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarse2MouseEntered
       registrarse2.setBackground(new Color(69, 162, 156));  
    }//GEN-LAST:event_registrarse2MouseEntered

    private void registrarse2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarse2MouseExited
     registrarse2.setBackground(new Color(0,255,240));
    }//GEN-LAST:event_registrarse2MouseExited

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
     
    }//GEN-LAST:event_formWindowOpened

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
    private javax.swing.JLabel LbRegistrar2;
    private javax.swing.JLabel LbRegistrar3;
    private javax.swing.JLabel LbUsuario;
    private javax.swing.JLabel LbUsuario1;
    private javax.swing.JPasswordField codico_coordinador;
    private javax.swing.JPasswordField conf_contraseñaR;
    private javax.swing.JPasswordField conf_contraseñaR1;
    private javax.swing.JPasswordField conf_contraseñaR2;
    private javax.swing.JLabel conf_contraseña_r;
    private javax.swing.JLabel conf_contraseña_r1;
    private javax.swing.JLabel conf_contraseña_r2;
    private javax.swing.JLabel conf_contraseña_r3;
    private javax.swing.JPasswordField contraseñaR;
    private javax.swing.JPasswordField contraseñaR1;
    private javax.swing.JLabel contraseña_r;
    private javax.swing.JLabel contraseña_r1;
    private javax.swing.JLabel coordinador;
    private javax.swing.JLabel dominioUn;
    private javax.swing.JLabel dominioUn1;
    private javax.swing.ButtonGroup grupo_botones;
    public static javax.swing.JLabel jLCargando2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanelCam;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JRadioButton jRBNo;
    private javax.swing.JRadioButton jRBYes;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel jlClose1;
    private javax.swing.JLabel jlMinimize1;
    private javax.swing.JPanel panelCerrar;
    private javax.swing.JPanel panelIniciarSesion;
    private javax.swing.JPanel panelRecupararCon;
    private javax.swing.JPanel panelRegistrase;
    private javax.swing.JButton registrarse;
    private javax.swing.JButton registrarse1;
    private javax.swing.JButton registrarse2;
    private javax.swing.JLabel signInTitle;
    private javax.swing.JLabel signInTitle1;
    private javax.swing.JLabel signInTitle2;
    private javax.swing.JLabel signInTitle3;
    private javax.swing.JLabel userLogoLabel;
    private javax.swing.JLabel usuario_institucional_r;
    private javax.swing.JLabel usuario_institucional_r2;
    private javax.swing.JLabel usuario_institucional_r3;
    private javax.swing.JLabel usuario_institucional_r4;
    private javax.swing.JLabel usuario_institucional_r5;
    private javax.swing.JLabel usuario_institucional_r6;
    private javax.swing.JTextField usuario_r;
    private javax.swing.JTextField usuario_r2;
    private javax.swing.JTextField usuario_r3;
    // End of variables declaration//GEN-END:variables
}
