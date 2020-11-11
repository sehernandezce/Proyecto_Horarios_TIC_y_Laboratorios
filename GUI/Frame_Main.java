package GUI;

import Control.EnviarCorreo;
import Control.ValidarEspacios;
import Control.Validar_administrar_solicitud;
import Entidad.Correo;
import Entidad.Espacio;
import Entidad.Usuario;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.AddressException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Frame_Main extends javax.swing.JFrame{
    
    private int x,y;
    private Usuario usuario;
    private ValidarEspacios  validarEspacios = new  ValidarEspacios ();
    private String idEspacioSeleccionado;
    private boolean tablaTocada = false;
    private Validar_administrar_solicitud validarSolicitudes=new Validar_administrar_solicitud();
    private TableRowSorter TRSFiltro;  
    
    public Frame_Main() {
        initComponents();
        this.setLocationRelativeTo(null);  
         ocultar_todosPaneles();
         Paneles_Menu.setVisible(false);         
         
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tipo_estados = new javax.swing.ButtonGroup();
        panelCerrar = new javax.swing.JPanel();
        jlClose1 = new javax.swing.JLabel();
        jlMinimize1 = new javax.swing.JLabel();
        LbUsuario = new javax.swing.JLabel();
        Paneles_Menu = new javax.swing.JPanel();
        Menu_UE = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        userLabel1 = new javax.swing.JLabel();
        roleLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        Menu_UC = new javax.swing.JPanel();
        jSeparator20 = new javax.swing.JSeparator();
        jSeparator21 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator22 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jSeparator23 = new javax.swing.JSeparator();
        jSeparator24 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator25 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        jSeparator26 = new javax.swing.JSeparator();
        jSeparator27 = new javax.swing.JSeparator();
        jSeparator28 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        userLabel2 = new javax.swing.JLabel();
        roleLabel1 = new javax.swing.JLabel();
        Solicitar_Espacio = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jSeparator12 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSpinner5 = new javax.swing.JSpinner();
        jSpinner6 = new javax.swing.JSpinner();
        jLabel15 = new javax.swing.JLabel();
        jSpinner7 = new javax.swing.JSpinner();
        jSpinner8 = new javax.swing.JSpinner();
        jLabel27 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jCalendar2 = new com.toedter.calendar.JCalendar();
        jButton3 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jTextMotivoSolicitud = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jLabelCargandoSE = new javax.swing.JLabel();
        Bienvenida = new javax.swing.JPanel();
        MensajeBienvenida = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        controlPanelTitle = new javax.swing.JLabel();
        Administrar_Solicitudes = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        Aceptar_sol_boton = new javax.swing.JButton();
        Rechazar_sol_boton = new javax.swing.JButton();
        Buscador = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        Jcbox_espera = new javax.swing.JCheckBox();
        Jcbox_aceptada = new javax.swing.JCheckBox();
        Jcbox_cancelada = new javax.swing.JCheckBox();
        Jcbox_rechazada = new javax.swing.JCheckBox();
        Categorias = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabelCargandoAS = new javax.swing.JLabel();
        Estadisticas = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel34 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jMonthChooser2 = new com.toedter.calendar.JMonthChooser();
        jYearChooser2 = new com.toedter.calendar.JYearChooser();
        jScrollPane7 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton8 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1024, 550));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1024, 550));
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
        panelCerrar.setMaximumSize(new java.awt.Dimension(1024, 30));
        panelCerrar.setMinimumSize(new java.awt.Dimension(1024, 30));
        panelCerrar.setPreferredSize(new java.awt.Dimension(1024, 30));
        panelCerrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlClose1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/incorrecto.png"))); // NOI18N
        jlClose1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlClose1MouseClicked(evt);
            }
        });
        panelCerrar.add(jlClose1, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 10, -1, -1));

        jlMinimize1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/linea.png"))); // NOI18N
        jlMinimize1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlMinimize1MouseClicked(evt);
            }
        });
        panelCerrar.add(jlMinimize1, new org.netbeans.lib.awtextra.AbsoluteConstraints(965, 10, -1, -1));

        LbUsuario.setBackground(new java.awt.Color(0, 51, 204));
        LbUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LbUsuario.setForeground(new java.awt.Color(255, 255, 255));
        LbUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo u_preview_rev_1_opt.png"))); // NOI18N
        LbUsuario.setText("Horarios de salas TIC's y Laboratorios");
        panelCerrar.add(LbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 6, 240, 20));

        getContentPane().add(panelCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Paneles_Menu.setBackground(new java.awt.Color(204, 204, 204));
        Paneles_Menu.setMinimumSize(new java.awt.Dimension(170, 520));
        Paneles_Menu.setPreferredSize(new java.awt.Dimension(170, 520));
        Paneles_Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menu_UE.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Menu_UE.setMinimumSize(new java.awt.Dimension(170, 520));
        Menu_UE.setPreferredSize(new java.awt.Dimension(170, 520));

        jLabel1.setText("Espacios");

        jLabel2.setText("Laboratorio");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        jLabel3.setText("Sala de reuniones");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });

        jLabel4.setText("sala de computadores");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });

        jLabel5.setText("Auditorios");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });

        jLabel6.setText("Administrar espacios");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
        });

        jLabel7.setText("Cerrar sesion");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo-universidad-nacional-de-colombia-sede-manizales-1-638_preview_rev_1_opt.png"))); // NOI18N

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario.png"))); // NOI18N
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel18MousePressed(evt);
            }
        });

        userLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        userLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userLabel1.setText("Username");

        roleLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        roleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roleLabel.setText("Usuario Coordinador");

        jLabel8.setText("Estadisticas");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel8MousePressed(evt);
            }
        });

        javax.swing.GroupLayout Menu_UELayout = new javax.swing.GroupLayout(Menu_UE);
        Menu_UE.setLayout(Menu_UELayout);
        Menu_UELayout.setHorizontalGroup(
            Menu_UELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addComponent(jSeparator3)
            .addComponent(jSeparator4)
            .addComponent(jSeparator5)
            .addComponent(jSeparator6)
            .addGroup(Menu_UELayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Menu_UELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator7)
                    .addComponent(jSeparator10)
                    .addGroup(Menu_UELayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(Menu_UELayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel17)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Menu_UELayout.createSequentialGroup()
                .addGroup(Menu_UELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator8)
                    .addComponent(jSeparator9)
                    .addGroup(Menu_UELayout.createSequentialGroup()
                        .addGroup(Menu_UELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Menu_UELayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(Menu_UELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel6)))
                            .addGroup(Menu_UELayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2))
                            .addGroup(Menu_UELayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel3))
                            .addGroup(Menu_UELayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel4))
                            .addGroup(Menu_UELayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel5))
                            .addGroup(Menu_UELayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7))
                            .addGroup(Menu_UELayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel18)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(Menu_UELayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Menu_UELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(roleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        Menu_UELayout.setVerticalGroup(
            Menu_UELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Menu_UELayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(roleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Paneles_Menu.add(Menu_UE, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 520));

        Menu_UC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Menu_UC.setMinimumSize(new java.awt.Dimension(170, 520));

        jLabel16.setText("Espacios");

        jLabel19.setText("Laboratorio");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel19MousePressed(evt);
            }
        });

        jLabel20.setText("Sala de reuniones");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel20MousePressed(evt);
            }
        });

        jLabel21.setText("sala de computadores");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel21MousePressed(evt);
            }
        });

        jLabel22.setText("Auditorios");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel22MousePressed(evt);
            }
        });

        jLabel23.setText("Mis solicitudes");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel23MousePressed(evt);
            }
        });

        jLabel24.setText("Cerrar sesion");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo-universidad-nacional-de-colombia-sede-manizales-1-638_preview_rev_1_opt.png"))); // NOI18N

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario.png"))); // NOI18N
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel26MousePressed(evt);
            }
        });

        userLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        userLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userLabel2.setText("Username");

        roleLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        roleLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roleLabel1.setText("Usuario estandar");

        javax.swing.GroupLayout Menu_UCLayout = new javax.swing.GroupLayout(Menu_UC);
        Menu_UC.setLayout(Menu_UCLayout);
        Menu_UCLayout.setHorizontalGroup(
            Menu_UCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator20)
            .addComponent(jSeparator21)
            .addComponent(jSeparator22)
            .addComponent(jSeparator23)
            .addComponent(jSeparator24)
            .addComponent(jSeparator25)
            .addComponent(jSeparator26)
            .addGroup(Menu_UCLayout.createSequentialGroup()
                .addGroup(Menu_UCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator27)
                    .addComponent(jSeparator28)
                    .addGroup(Menu_UCLayout.createSequentialGroup()
                        .addGroup(Menu_UCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Menu_UCLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(Menu_UCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel23)))
                            .addGroup(Menu_UCLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel19))
                            .addGroup(Menu_UCLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel20))
                            .addGroup(Menu_UCLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel21))
                            .addGroup(Menu_UCLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel22))
                            .addGroup(Menu_UCLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel24))
                            .addGroup(Menu_UCLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel26))
                            .addGroup(Menu_UCLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel25)))
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(Menu_UCLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Menu_UCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(roleLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        Menu_UCLayout.setVerticalGroup(
            Menu_UCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Menu_UCLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel26)
                .addGap(5, 5, 5)
                .addComponent(userLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roleLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(jSeparator27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Paneles_Menu.add(Menu_UC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 520));

        getContentPane().add(Paneles_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 170, 520));

        Solicitar_Espacio.setBackground(new java.awt.Color(204, 204, 204));
        Solicitar_Espacio.setPreferredSize(new java.awt.Dimension(854, 520));
        Solicitar_Espacio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setMinimumSize(new java.awt.Dimension(854, 520));
        jPanel2.setPreferredSize(new java.awt.Dimension(854, 520));

        jTable3 = new javax.swing.JTable(){
            public boolean isCellEditable (int rowIndex, int colIndex){
                return false;
            }
        };
        jTable3.setBackground(new java.awt.Color(204, 204, 204));
        jTable3.getTableHeader().setReorderingAllowed(false);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jTable4 = new javax.swing.JTable(){
            public boolean isCellEditable (int rowIndex, int colIndex){
                return false;
            }
        };
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(jTable4);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Solicitar espacio:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Tipo de espacio:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("¿En que horario desea reservar el espacio? ");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Hora de inicio:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Hora final:");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setText("¿El evento se repite?");

        jCheckBox3.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("Personalizar");
        jButton2.setEnabled(false);

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel28.setText("Motivo solicitud:");

        jComboBox2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccion" }));

        jCalendar2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendar2PropertyChange(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("Solicitar");

        jLabel36.setBackground(new java.awt.Color(255, 255, 255));
        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextMotivoSolicitud.setEnabled(false);

        jButton9.setText("Borrar El Espacio Seleccionado");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabelCargandoSE.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jSeparator12)
                .addGap(89, 89, 89))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton9)
                .addGap(164, 164, 164))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSpinner6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jSpinner7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSpinner8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextMotivoSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCalendar2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelCargandoSE, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(70, 70, 70))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jSpinner6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jSpinner7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinner8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton2))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextMotivoSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCalendar2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3)
                            .addComponent(jLabelCargandoSE, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );

        Solicitar_Espacio.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(Solicitar_Espacio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        Bienvenida.setBackground(new java.awt.Color(204, 204, 204));
        Bienvenida.setMaximumSize(new java.awt.Dimension(854, 520));
        Bienvenida.setMinimumSize(new java.awt.Dimension(854, 520));
        Bienvenida.setPreferredSize(new java.awt.Dimension(854, 520));
        Bienvenida.setRequestFocusEnabled(false);
        Bienvenida.setLayout(new java.awt.BorderLayout());

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("\n  Bienvenido al sistema de horarios de  salas TIC´s y laboratorios\n\n    Pasos a seguir si quiere solicitar un espacio:\n\n         1. Elija el tipo de espacio en la barra lateral.\n         2. Seleccione el espacio que necesita. Puede dar click en ultima columna a la derecha para mas información del espacio.\n         3. Verifique si el espacio en la fecha y hora que necesita esta disponible.\n         4. Realice la solicitud llenando los campos. Si el espacio se encuentra disponible, quedara la solicitud en espera a que \n             el coordinador valide y acepte la solicitud.\n         5. Para validar el estado o ver información de su solicitud, en la barra lateral izquierda debe seleccionar mis solicitudes.");
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        controlPanelTitle.setBackground(new java.awt.Color(203, 203, 204));
        controlPanelTitle.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        controlPanelTitle.setText("Bienvenid@");

        javax.swing.GroupLayout MensajeBienvenidaLayout = new javax.swing.GroupLayout(MensajeBienvenida);
        MensajeBienvenida.setLayout(MensajeBienvenidaLayout);
        MensajeBienvenidaLayout.setHorizontalGroup(
            MensajeBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MensajeBienvenidaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(MensajeBienvenidaLayout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(controlPanelTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MensajeBienvenidaLayout.setVerticalGroup(
            MensajeBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MensajeBienvenidaLayout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(controlPanelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        Bienvenida.add(MensajeBienvenida, java.awt.BorderLayout.CENTER);

        getContentPane().add(Bienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 854, 520));

        Administrar_Solicitudes.setBackground(new java.awt.Color(204, 204, 204));
        Administrar_Solicitudes.setMinimumSize(new java.awt.Dimension(854, 520));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel30.setText("Administrar Solicitudes");

        jTable2 = new javax.swing.JTable(){
            public boolean isCellEditable (int rowIndex, int colIndex){
                return false;
            }
        };
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_SOLICITUD", "USUARIOINTITUCIONAL", "FECHA_INICIO", "FECHA_TRMINA", "NOMBRE_ESPACIO", "ID_EDIFICIO", "ID_ESTADO", "FECHA_SOLICITUD"
            }
        ));
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jTable2);

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("Aceptar o rechazar solicitud seleccionada:");

        jLabel32.setText("Observaciones:");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        Aceptar_sol_boton.setText("Aceptar");
        Aceptar_sol_boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Aceptar_sol_botonActionPerformed(evt);
            }
        });

        Rechazar_sol_boton.setText("Rechazar");
        Rechazar_sol_boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rechazar_sol_botonActionPerformed(evt);
            }
        });

        Buscador.setToolTipText("Buscar por nombre");
        Buscador.setName(""); // NOI18N
        Buscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscadorActionPerformed(evt);
            }
        });
        Buscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BuscadorKeyTyped(evt);
            }
        });

        jButton6.setText("Buscar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton10.setText("Cancelar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        Tipo_estados.add(Jcbox_espera);
        Jcbox_espera.setText("En espera");
        Jcbox_espera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jcbox_esperaActionPerformed(evt);
            }
        });

        Tipo_estados.add(Jcbox_aceptada);
        Jcbox_aceptada.setText("Aceptada");
        Jcbox_aceptada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jcbox_aceptadaActionPerformed(evt);
            }
        });

        Tipo_estados.add(Jcbox_cancelada);
        Jcbox_cancelada.setText("Cancelada");
        Jcbox_cancelada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jcbox_canceladaActionPerformed(evt);
            }
        });

        Tipo_estados.add(Jcbox_rechazada);
        Jcbox_rechazada.setText("Rechazada");
        Jcbox_rechazada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jcbox_rechazadaActionPerformed(evt);
            }
        });

        Categorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID_SOLICITUD", "USUARIOINTITUCIONAL", "FECHA_INICIO", "FECHA_TRMINA", "NOMBRE_ESPACIO", "ID_EDIFICIO", "ID_ESTADO", "FECHA_SOLICITUD" }));
        Categorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoriasActionPerformed(evt);
            }
        });

        jLabel9.setText("Filtro:");

        jLabelCargandoAS.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabelCargandoAS.setText("5");

        javax.swing.GroupLayout Administrar_SolicitudesLayout = new javax.swing.GroupLayout(Administrar_Solicitudes);
        Administrar_Solicitudes.setLayout(Administrar_SolicitudesLayout);
        Administrar_SolicitudesLayout.setHorizontalGroup(
            Administrar_SolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Administrar_SolicitudesLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(Administrar_SolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelCargandoAS, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Administrar_SolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(Administrar_SolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addGroup(Administrar_SolicitudesLayout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addGroup(Administrar_SolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Rechazar_sol_boton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Aceptar_sol_boton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel30)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Administrar_SolicitudesLayout.createSequentialGroup()
                            .addComponent(jLabel31)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Jcbox_rechazada)
                            .addGap(15, 15, 15)
                            .addComponent(Jcbox_cancelada)
                            .addGap(18, 18, 18)
                            .addComponent(Jcbox_aceptada)
                            .addGap(18, 18, 18)
                            .addComponent(Jcbox_espera))
                        .addGroup(Administrar_SolicitudesLayout.createSequentialGroup()
                            .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton6)
                            .addGap(31, 31, 31)
                            .addGroup(Administrar_SolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(Categorias, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(141, 141, 141))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        Administrar_SolicitudesLayout.setVerticalGroup(
            Administrar_SolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Administrar_SolicitudesLayout.createSequentialGroup()
                .addGroup(Administrar_SolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Administrar_SolicitudesLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel30)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Administrar_SolicitudesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(Administrar_SolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6)
                    .addComponent(Categorias, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(Administrar_SolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Administrar_SolicitudesLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel31))
                    .addGroup(Administrar_SolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Jcbox_espera)
                        .addComponent(Jcbox_aceptada)
                        .addComponent(Jcbox_cancelada)
                        .addComponent(Jcbox_rechazada)))
                .addGap(6, 6, 6)
                .addComponent(jLabel32)
                .addGroup(Administrar_SolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Administrar_SolicitudesLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Administrar_SolicitudesLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(Aceptar_sol_boton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Rechazar_sol_boton)
                        .addGap(13, 13, 13)
                        .addComponent(jButton10)))
                .addGap(18, 18, 18)
                .addComponent(jLabelCargandoAS, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getContentPane().add(Administrar_Solicitudes, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        Estadisticas.setBackground(new java.awt.Color(204, 204, 204));
        Estadisticas.setMinimumSize(new java.awt.Dimension(854, 520));
        Estadisticas.setName(""); // NOI18N
        Estadisticas.setPreferredSize(new java.awt.Dimension(854, 520));
        Estadisticas.setRequestFocusEnabled(false);

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel33.setText("Estadísticas");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane6.setViewportView(jTextArea2);

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("Estadísticas Por Tipo De Espacio");

        jButton7.setText("Buscar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel35.setText("Tipo de espacio:");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane7.setViewportView(jList1);

        jButton8.setText("Buscar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane8.setViewportView(jTextArea3);

        javax.swing.GroupLayout EstadisticasLayout = new javax.swing.GroupLayout(Estadisticas);
        Estadisticas.setLayout(EstadisticasLayout);
        EstadisticasLayout.setHorizontalGroup(
            EstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EstadisticasLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(EstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jButton7)
                .addGap(50, 50, 50)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(EstadisticasLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel34))
            .addGroup(EstadisticasLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(EstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addGroup(EstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jMonthChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(EstadisticasLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(EstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jYearChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8))))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        EstadisticasLayout.setVerticalGroup(
            EstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EstadisticasLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(EstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EstadisticasLayout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(68, 68, 68)
                        .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EstadisticasLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EstadisticasLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EstadisticasLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addComponent(jLabel34)
                .addGap(3, 3, 3)
                .addGroup(EstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EstadisticasLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel35)
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EstadisticasLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jMonthChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jYearChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton8))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(Estadisticas, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));
        Estadisticas.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    public void entrar_bienvenida(Usuario usuario2){ //Selecciona el tipo de menu segun el usuario        
       ocultar_todosPaneles();
        Bienvenida.setVisible(true);
        Paneles_Menu.setVisible(true);
        this.usuario = usuario2;
        if(usuario.getTipoUsuario() == 1 || usuario.getTipoUsuario() == 4){
              Menu_UE.setVisible(false);
              userLabel2.setText(usuario.getNombreusuarioInstitucional());
         }else if(usuario.getTipoUsuario() == 2 ){             
              Menu_UC.setVisible(false);
              userLabel1.setText(usuario.getNombreusuarioInstitucional());
         }else{
              Paneles_Menu.setVisible(false);
         }
        
    }
    
    private void ocultar_todosPaneles(){ // Oculta todos los paneles menos el menu
        Bienvenida.setVisible(false);
        Solicitar_Espacio.setVisible(false);       
        Administrar_Solicitudes.setVisible(false);
        Estadisticas.setVisible(false);
    }
    
    private void logOut(){ //Cerrar sesion        
       Frame_Login frame_Login =new Frame_Login();  
       this.setVisible(false);  
       frame_Login.setVisible(true);
    }
    
    
           
    public void solicitar_Espacio(String Espacio) throws SQLException{ //Para mostrar la informacion en el panel de solicitar espacios     
           
            ocultar_todosPaneles();
            Solicitar_Espacio.setVisible(true);
            jLabelCargandoSE.setText("Cargando...");
             jLabel36.setText(Espacio);
             jLabel37.setText("");
             jTable3.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][]{}, new String [] {" ID", "Nombre espacio", "Salon", "Edificio", "Encargado", "Estado","Información adicional"}) 
                         );
             jTable4.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][]{}, new String [] {"Horas ocupadas"}) 
                         );
             llenarTabla(Espacio);
            jLabelCargandoSE.setText("");  
    }
    
    
    private void mostrar_misSolicitudes(int idUsuario){ //Para mostrar la mis solicitudes
        ocultar_todosPaneles();
       
        
    }
    
    private void administrar_Solicitudes(){ //Para mostrar las solicitudes en el administrador
        ocultar_todosPaneles();   
        if(usuario.getTipoUsuario() == 1 || usuario.getTipoUsuario() == 4){
            Aceptar_sol_boton.setEnabled(false);
            Rechazar_sol_boton.setEnabled(false);
            Administrar_Solicitudes.setVisible(true);
        }else{
            Administrar_Solicitudes.setVisible(true);
        }
        
       try {
            llenarTabla_solicitudes("Todos");
        } catch (SQLException ex) {
            Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
       Tipo_estados.clearSelection();
      
    }
    
     private void ver_Estadisticas(){ //Para ver estadisticas
        ocultar_todosPaneles();
       Estadisticas.setVisible(true); 
        
    }
     
      private void llenarTabla(String tipo) throws SQLException{//modelo tabla
        
        Object[][] tabla=validarEspacios.llenarMatriz(tipo, usuario);        
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
         tabla, new String [] {" ID", "Nombre espacio", "Salon", "Edificio", "Encargado", "Estado","Información adicional" }) 
                         );
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(SwingConstants.CENTER);
        jTable3.getColumnModel().getColumn(5).setCellRenderer(render);
    }
      
      
      private void llenarTabla_espacios(int id_espacio,String fecha, int day) throws SQLException{//modelo tabla espacios
        jLabelCargandoSE.setText("Cargando...");
        Object[][] tabla=validarEspacios.llenarMatriz_horas(id_espacio, fecha, usuario, day);
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
        tabla, new String [] {"Horas ocupadas"}));
         jLabelCargandoSE.setText("");
    }
      
       private void llenarTabla_solicitudes(String tipo_e) throws SQLException{//modelo tabla espacios
        Object[][] tabla= validarSolicitudes.llenarMatriz(usuario, tipo_e);
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
        tabla, new String [] {
        "ID_SOLICITUD", "USUARIOINTITUCIONAL", "FECHA_INICIO", "FECHA_TRMINA", "NOMBRE_ESPACIO", "ID_EDIFICIO", "ID_ESTADO", "FECHA_SOLICITUD"
            }
        ));
    }
      
      private String obtener_fecha(){
          
          int año = jCalendar2.getCalendar().get(Calendar.YEAR);
          int mes = jCalendar2.getCalendar().get(Calendar.MONTH)+1;
          int dia = jCalendar2.getCalendar().get(Calendar.DAY_OF_MONTH);
          
          return año+"-"+mes+"-"+dia;
      }
      
      private int obt_diaSemana(){
          TimeZone timezone = TimeZone.getDefault();
         Calendar calendar = new GregorianCalendar(timezone);
         calendar.set(jCalendar2.getCalendar().get(Calendar.YEAR), jCalendar2.getCalendar().get(Calendar.MONTH), jCalendar2.getCalendar().get(Calendar.DAY_OF_MONTH));
         int nD=calendar.get(Calendar.DAY_OF_WEEK);
         return nD;
      }
      
      private void verDetalles(Object obj){
          jLabelCargandoSE.setText("Cargando...");           
          try{
            
             Espacio espacio = new Espacio();
             espacio = validarEspacios.BuscarInfoEspacio(usuario, Integer.valueOf(obj.toString()));
             Frame_DetallesEspacio frame_DetallesEspacio= new Frame_DetallesEspacio();
             frame_DetallesEspacio.setVisible(true); 
             frame_DetallesEspacio.llenarFrame(usuario, espacio, this);    
             this.enable(false);
             frame_DetallesEspacio.setVisible(true); 
             jLabelCargandoSE.setText("");
          }catch (Exception e){
              System.out.println(e);
          }
          
          
          
            // crear el frame
      }
      
      
      
      public int categoria_fil(String categoria){
          if(categoria.equals("ID_SOLICITUD")){
              return 1;
          }else if(categoria.equals("USUARIOINTITUCIONAL")){
              return 2;
          }else if(categoria.equals("FECHA_INICIO")){
              return 3;
          }else if(categoria.equals("FECHA_TRMINA")){
              return 4;
          }else if(categoria.equals("NOMBRE_ESPACIO")){
              return 5;
          }else if(categoria.equals("ID_EDIFICIO")){
              return 6;
          }else if(categoria.equals("ID_ESTADO")){
              return 7;
          }else if(categoria.equals("FECHA_SOLICITUD")){
              return 8;
          }else{
              return 0;
          }
   
      }
      
     private void cambiarEstado(String tipE) throws AddressException{
       jLabelCargandoAS.setText("Cargando...");
         if(jTable2.getSelectedRow()!=-1 && jTable2.getSelectedColumn()!=-1){ 
            int res= validarSolicitudes.cambiarEstado(usuario, tipE, jTable2.getValueAt(jTable2.getSelectedRow(),0).toString(),jTextField2.getText());
                 if(res==1){
                    JOptionPane.showMessageDialog(null, "Se han guardado los cambios",  "Cambiar estado de la solicitud", JOptionPane.INFORMATION_MESSAGE);  
                    if(!tipE.equals("Cancelada")){
                       int dialog = JOptionPane.YES_NO_OPTION;
                        int result = JOptionPane.showConfirmDialog(null, "¿Desea notificar por correo al usuario?","Exit",dialog);
                        if(result ==0){
                           String contrasenia=JOptionPane.showInputDialog(null,"Ingrese la contraseña del correo: horariosdesalastics@gmail.com","Enviar correo",JOptionPane.QUESTION_MESSAGE);
                          if(!contrasenia.equals("") || contrasenia==null){
                           Correo correo =new Correo();
                           correo.setAsunto("Respuesta a su solicitud con ID: "+ jTable2.getValueAt(jTable2.getSelectedRow(),0).toString());
                           correo.setMensaje("Estimado/a <b>Usuario</b>,<br> Queremos informale que su solicitud con id: "+jTable2.getValueAt(jTable2.getSelectedRow(),0).toString()
                            +"Ha cambiado al estado:<b> "+tipE+"</b>. A continuación se muestra la/s observacion/es indicadas por el coordinador:<br>"+jTextField2.getText()+"<br>Muchas gracias por su atención.<br>Por favor, no reponder ha este correo.");
                           correo.setCorreoReceptor(jTable2.getValueAt(jTable2.getSelectedRow(),1).toString()+"@unal.edu.co");
                           correo.setPasswordRemitente(contrasenia);
                           EnviarCorreo enviarCorreo=new EnviarCorreo();
                           boolean c=enviarCorreo.enviarC(correo);
                             if(c){
                                JOptionPane.showMessageDialog(null, "Se ha notificado al usuario: "+jTable2.getValueAt(jTable2.getSelectedRow(),1).toString()+"@unal.edu.co"); 
                             }else{
                              JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar enviar el correo");  
                             }
                             
                            }else{
                             JOptionPane.showMessageDialog(null, "Valor no valido",  "Valor no valido", JOptionPane.INFORMATION_MESSAGE);     
                          }
                        } 
                    }
                    
                     
                }else if(res==-1 && res==-3 ){
                     JOptionPane.showMessageDialog(null, "Accion no valida",  "Accion no valida", JOptionPane.INFORMATION_MESSAGE);
                }else if(res==-2){
                 JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar conectar con el servidor",  "Error", JOptionPane.INFORMATION_MESSAGE);   
                }else if(res==-4){
                      JOptionPane.showMessageDialog(null, "No tiene permisos para cancelar solicitudes de otros usuarios",  "Accion no valida", JOptionPane.INFORMATION_MESSAGE);    
                }
            }
         jLabelCargandoAS.setText("");
        
     }
             
      
     
      /*
      private String obtener_estado(){
          if(Jcbox_rechazada.isSelected()){
              return "Rechazada";
          }
          if(Jcbox_cancelada.isSelected()){
              return "Cancelada";
          }
          if(Jcbox_aceptada.isSelected()){
              return "Aceptada";
          }
          if(Jcbox_espera.isSelected()){
              return "Espera";
          }
      return null;    
      }
      */
    
    /// Acciones de los botones y labels
    
    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
       
        try {
            solicitar_Espacio("Laboratorios");
        } catch (SQLException ex) {
            Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        if(usuario.getTipoUsuario() != 2){  //Si el usuario no es coordinador, deshabilitar el botón para eliminar espacios.
            this.jButton9.setVisible(false);
        }
        
    }//GEN-LAST:event_jLabel2MousePressed

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

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
       logOut();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
       logOut();
    }//GEN-LAST:event_jLabel24MouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        x= evt.getX();   
        y= evt.getY(); 
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
       this.setLocation(this.getLocation().x + evt.getX()-x,this.getLocation().y+evt.getY()-y);
    }//GEN-LAST:event_formMouseDragged

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jLabel19MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MousePressed
   
        try {
            solicitar_Espacio("Laboratorios");
        } catch (SQLException ex) {
            Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }//GEN-LAST:event_jLabel19MousePressed

    private void jLabel20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MousePressed
      
        try {
            solicitar_Espacio("Sala de reuniones");
        } catch (SQLException ex) {
            Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_jLabel20MousePressed

    private void jLabel21MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MousePressed
      
        try {
            solicitar_Espacio("Sala de computadores");
        } catch (SQLException ex) {
            Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_jLabel21MousePressed

    private void jLabel22MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MousePressed
      
        try {
            solicitar_Espacio("Auditorios");
        } catch (SQLException ex) {
            Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }//GEN-LAST:event_jLabel22MousePressed

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
     
        try {
            solicitar_Espacio("Sala de reuniones");
        } catch (SQLException ex) {
            Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        if(usuario.getTipoUsuario() != 2){  //Si el usuario no es coordinador, deshabilitar el botón para eliminar espacios.
            this.jButton9.setVisible(false);
        }
    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        
        try {
            solicitar_Espacio("Sala de computadores");
        } catch (SQLException ex) {
            Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(usuario.getTipoUsuario() != 2){  //Si el usuario no es coordinador, deshabilitar el botón para eliminar espacios.
            this.jButton9.setVisible(false);
        }
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
       
        try {
            solicitar_Espacio("Auditorios");
        } catch (SQLException ex) {
            Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        if(usuario.getTipoUsuario() != 2){  //Si el usuario no es coordinador, deshabilitar el botón para eliminar espacios.
            this.jButton9.setVisible(false);
        }
    }//GEN-LAST:event_jLabel5MousePressed

    private void jLabel23MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MousePressed
       administrar_Solicitudes();
        
    }//GEN-LAST:event_jLabel23MousePressed

    private void jLabel26MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MousePressed
        ocultar_todosPaneles();
        Bienvenida.setVisible(true); 
    }//GEN-LAST:event_jLabel26MousePressed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void Aceptar_sol_botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Aceptar_sol_botonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Aceptar_sol_botonActionPerformed

    private void BuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscadorActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
       administrar_Solicitudes();
    }//GEN-LAST:event_jLabel6MousePressed

    private void jLabel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MousePressed
       ver_Estadisticas();
    }//GEN-LAST:event_jLabel8MousePressed

    private void jLabel18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MousePressed
        tablaTocada = false;
        ocultar_todosPaneles();
        Bienvenida.setVisible(true);
    }//GEN-LAST:event_jLabel18MousePressed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        tablaTocada = true;
        if(jTable3.getSelectedRow()!=-1 && jTable3.getSelectedColumn()!=-1){
            if(jTable3.getSelectedColumn()==6){
                     verDetalles(jTable3.getValueAt(jTable3.getSelectedRow(),0));
             }
              String edificio=(jTable3.getValueAt(jTable3.getSelectedRow(),3)).toString();
              String Salon=(jTable3.getValueAt(jTable3.getSelectedRow(),2)).toString();
              jLabel37.setText(Salon+" - "+edificio+"  ");
              idEspacioSeleccionado = (jTable3.getValueAt(jTable3.getSelectedRow(), 0)).toString();
        }
      
      
    }//GEN-LAST:event_jTable3MouseClicked

    private void jCalendar2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendar2PropertyChange
        // TODO add your handling code here:
        if(jTable3.getSelectedRow()!=-1 && jTable3.getSelectedColumn()!=-1){
            int id_espacio=Integer.valueOf(jTable3.getValueAt(jTable3.getSelectedRow(),0).toString());
            //jCalendar2.get
            String fecha=obtener_fecha();
            int day=obt_diaSemana();
            System.out.println(day);
            try {
                llenarTabla_espacios(id_espacio,fecha,day);
            } catch (SQLException ex) {
                Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }//GEN-LAST:event_jCalendar2PropertyChange

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
      
        if(!tablaTocada){
            JOptionPane.showMessageDialog(null, "No ha seleccionado un espacio para borrar.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }else{
           jLabelCargandoSE.setText("Cargando...");
            validarEspacios.borrarEspacio(usuario,idEspacioSeleccionado);
            JOptionPane.showMessageDialog(null, "El espacio fue borrado.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
               jLabelCargandoSE.setText("");
        }
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void CategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoriasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CategoriasActionPerformed

    private void Jcbox_rechazadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jcbox_rechazadaActionPerformed
        try {
            llenarTabla_solicitudes("Rechazada");
        } catch (SQLException ex) {
            Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Jcbox_rechazadaActionPerformed

    private void Jcbox_esperaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jcbox_esperaActionPerformed
        try {
            llenarTabla_solicitudes("Espera");
        } catch (SQLException ex) {
            Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Jcbox_esperaActionPerformed

    private void Jcbox_canceladaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jcbox_canceladaActionPerformed
        try {
            llenarTabla_solicitudes("Cancelada");
        } catch (SQLException ex) {
            Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Jcbox_canceladaActionPerformed

    private void Jcbox_aceptadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jcbox_aceptadaActionPerformed
        try {
            llenarTabla_solicitudes("Aceptada");
        } catch (SQLException ex) {
            Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Jcbox_aceptadaActionPerformed

    private void BuscadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscadorKeyTyped
        String categoria=(String)Categorias.getSelectedItem();
        System.out.println(categoria_fil(categoria));
        Buscador.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent ke) {
                TRSFiltro.setRowFilter(RowFilter.regexFilter("(?i)"+Buscador.getText(), (categoria_fil(categoria)-1)));
            }
        });
        TRSFiltro = new TableRowSorter(jTable2.getModel());
        jTable2.setRowSorter(TRSFiltro);
    }//GEN-LAST:event_BuscadorKeyTyped

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        try {
            cambiarEstado("Cancelada");
        } catch (AddressException ex) {
            Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void Rechazar_sol_botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rechazar_sol_botonActionPerformed
        try {
            cambiarEstado("Rechazada");
        } catch (AddressException ex) {
            Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Rechazar_sol_botonActionPerformed

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
            java.util.logging.Logger.getLogger(Frame_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar_sol_boton;
    private javax.swing.JPanel Administrar_Solicitudes;
    private javax.swing.JPanel Bienvenida;
    private javax.swing.JTextField Buscador;
    private javax.swing.JComboBox<String> Categorias;
    private javax.swing.JPanel Estadisticas;
    private javax.swing.JCheckBox Jcbox_aceptada;
    private javax.swing.JCheckBox Jcbox_cancelada;
    private javax.swing.JCheckBox Jcbox_espera;
    private javax.swing.JCheckBox Jcbox_rechazada;
    private javax.swing.JLabel LbUsuario;
    private javax.swing.JPanel MensajeBienvenida;
    private javax.swing.JPanel Menu_UC;
    private javax.swing.JPanel Menu_UE;
    private javax.swing.JPanel Paneles_Menu;
    private javax.swing.JButton Rechazar_sol_boton;
    private javax.swing.JPanel Solicitar_Espacio;
    private javax.swing.ButtonGroup Tipo_estados;
    private javax.swing.JLabel controlPanelTitle;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JCalendar jCalendar2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCargandoAS;
    private javax.swing.JLabel jLabelCargandoSE;
    private javax.swing.JList<String> jList1;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private com.toedter.calendar.JMonthChooser jMonthChooser2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator28;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JSpinner jSpinner6;
    private javax.swing.JSpinner jSpinner7;
    private javax.swing.JSpinner jSpinner8;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextMotivoSolicitud;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private com.toedter.calendar.JYearChooser jYearChooser2;
    private javax.swing.JLabel jlClose1;
    private javax.swing.JLabel jlMinimize1;
    private javax.swing.JPanel panelCerrar;
    private javax.swing.JLabel roleLabel;
    private javax.swing.JLabel roleLabel1;
    private javax.swing.JLabel userLabel1;
    private javax.swing.JLabel userLabel2;
    // End of variables declaration//GEN-END:variables

}