package GUI;

import Control.ValidarEspacios;
import Control.Validar_administrar_solicitud;
import Entidad.Espacio;
import Entidad.Evento;
import Entidad.Solicitud;
import Entidad.Usuario;
import GUI.Frame_DetallesEspacio;
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.AddressException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Frame_Main extends javax.swing.JFrame{
    
    
    private int x,y;
    
    private Usuario usuario;
    private Solicitud solicitud;
    private Evento evento;
    private ValidarEspacios validarEspacios = new ValidarEspacios();
    private Validar_administrar_solicitud validarSolIngresada = new Validar_administrar_solicitud();
    private String idEspacioSeleccionado;
    private Validar_administrar_solicitud validarSolicitudes = new Validar_administrar_solicitud();
    private TableRowSorter TRSFiltro;
    private String fechaTermina;
    private int[] diasRepeticion = {0, 0, 0, 0, 0, 0, 0};
    private int indiceRepeticion;
    private String nombreRepeticion = "Diariamente";
    private boolean tipo_rechazada=false;
    private boolean tipo_espera=false;
    private boolean tipo_aceptada=false;
    private boolean tipo_cancelada=false;
    
    public String Tipo;
    public Frame_Main() {
        initComponents();
        this.setLocationRelativeTo(null);
        ocultar_todosPaneles();
        Paneles_Menu.setVisible(false);

    }

    public void setNombreRepeticion(String nombreRepeticion) {
        this.nombreRepeticion = nombreRepeticion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tipo_estados = new javax.swing.ButtonGroup();
        Solicitar_Espacio = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jSeparator12 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jButtonPersonalizar = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jComboMotivos = new javax.swing.JComboBox<>();
        jCalendar2 = new com.toedter.calendar.JCalendar();
        jButton3 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jTextMotivoSolicitud = new javax.swing.JTextField();
        jLabelCargandoSE = new javax.swing.JLabel();
        jLabelRepeticion = new javax.swing.JLabel();
        jSpinnerHorainicio = new javax.swing.JSpinner();
        jLabelAñadir2 = new javax.swing.JLabel();
        jSpinnerMinutosInicio = new javax.swing.JSpinner();
        jSpinnerHorafinal = new javax.swing.JSpinner();
        jSpinnerMinutosFinal = new javax.swing.JSpinner();
        jLabelEliminar1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
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
        jButton10 = new javax.swing.JButton();
        Jcbox_espera = new javax.swing.JCheckBox();
        Jcbox_aceptada = new javax.swing.JCheckBox();
        Jcbox_cancelada = new javax.swing.JCheckBox();
        Jcbox_rechazada = new javax.swing.JCheckBox();
        Categorias = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabelCargandoAS = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        Bienvenida = new javax.swing.JPanel();
        MensajeBienvenida = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        controlPanelTitle = new javax.swing.JLabel();
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

        Solicitar_Espacio.setBackground(new java.awt.Color(204, 204, 204));
        Solicitar_Espacio.setPreferredSize(new java.awt.Dimension(854, 520));
        Solicitar_Espacio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setMinimumSize(new java.awt.Dimension(854, 520));
        jPanel2.setPreferredSize(new java.awt.Dimension(854, 520));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 810, 112));
        jPanel2.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 892, -1));

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

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 319, 160, 140));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Datos del espacio");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 200, -1, 20));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("¿En que horario desea reservar el espacio? ");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 262, 20));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Tipo de espacio");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, 90, 20));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Hora final:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, -1, 20));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setText("¿El evento se repite?");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, 30));

        jCheckBox3.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, -1, 14));

        jButtonPersonalizar.setBackground(new java.awt.Color(204, 204, 204));
        jButtonPersonalizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonPersonalizar.setText("Personalizar");
        jButtonPersonalizar.setEnabled(false);
        jButtonPersonalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPersonalizarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonPersonalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, -1, -1));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel28.setText("Observaciones:");
        jPanel2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 100, 20));

        jComboMotivos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jComboMotivos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccion" }));
        jComboMotivos.setToolTipText("");
        jComboMotivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboMotivosActionPerformed(evt);
            }
        });
        jPanel2.add(jComboMotivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 168, -1));

        jCalendar2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendar2PropertyChange(evt);
            }
        });
        jPanel2.add(jCalendar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 325, 223));

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("Solicitar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, -1, -1));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel36.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        jPanel2.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 250, 158, 20));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel37.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        jPanel2.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 290, 160, 20));

        jTextMotivoSolicitud.setEnabled(false);
        jPanel2.add(jTextMotivoSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 168, 50));

        jLabelCargandoSE.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jPanel2.add(jLabelCargandoSE, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 480, 90, 20));

        jLabelRepeticion.setToolTipText("");
        jPanel2.add(jLabelRepeticion, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 350, 260, 24));
        jPanel2.add(jSpinnerHorainicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 56, -1));

        jLabelAñadir2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/anadir.png"))); // NOI18N
        jLabelAñadir2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAñadir2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabelAñadir2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, -1, -1));
        jPanel2.add(jSpinnerMinutosInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 50, -1));
        jPanel2.add(jSpinnerHorafinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 55, -1));
        jPanel2.add(jSpinnerMinutosFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 50, -1));

        jLabelEliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar.png"))); // NOI18N
        jLabelEliminar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEliminar1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabelEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setText("Información de los espacios");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel29.setText("Solicitar espacio");
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, -1, -1));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel39.setText("Fecha de inicio");
        jPanel2.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, -1, 20));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel40.setText("Salon - Edificio");
        jPanel2.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, 90, 20));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel41.setText("Motivo solicitud:");
        jPanel2.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, 20));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel42.setText("Hora de inicio:");
        jPanel2.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, 20));

        Solicitar_Espacio.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(Solicitar_Espacio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, 520));

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

        jLabel6.setText("Administrar solicitudes");
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

        Administrar_Solicitudes.setBackground(new java.awt.Color(204, 204, 204));
        Administrar_Solicitudes.setMinimumSize(new java.awt.Dimension(854, 520));
        Administrar_Solicitudes.setPreferredSize(new java.awt.Dimension(854, 520));
        Administrar_Solicitudes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel30.setText("Administrar Solicitudes");
        Administrar_Solicitudes.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

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
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable2);

        Administrar_Solicitudes.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 115, 768, 149));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel31.setText("Aceptar, cancelar o rechazar solicitud");
        Administrar_Solicitudes.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel32.setText("Buscar: ");
        Administrar_Solicitudes.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        Administrar_Solicitudes.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 580, 120));

        Aceptar_sol_boton.setBackground(new java.awt.Color(204, 204, 204));
        Aceptar_sol_boton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Aceptar_sol_boton.setText("Aceptar");
        Aceptar_sol_boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Aceptar_sol_botonActionPerformed(evt);
            }
        });
        Administrar_Solicitudes.add(Aceptar_sol_boton, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 340, 84, -1));

        Rechazar_sol_boton.setBackground(new java.awt.Color(204, 204, 204));
        Rechazar_sol_boton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Rechazar_sol_boton.setText("Rechazar");
        Rechazar_sol_boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rechazar_sol_botonActionPerformed(evt);
            }
        });
        Administrar_Solicitudes.add(Rechazar_sol_boton, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 390, -1, -1));

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
        Administrar_Solicitudes.add(Buscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 68, 260, -1));

        jButton10.setBackground(new java.awt.Color(204, 204, 204));
        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton10.setText("Cancelar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        Administrar_Solicitudes.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 440, 84, -1));

        Jcbox_espera.setBackground(new java.awt.Color(204, 204, 204));
        Tipo_estados.add(Jcbox_espera);
        Jcbox_espera.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Jcbox_espera.setText("En espera");
        Jcbox_espera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jcbox_esperaActionPerformed(evt);
            }
        });
        Administrar_Solicitudes.add(Jcbox_espera, new org.netbeans.lib.awtextra.AbsoluteConstraints(726, 275, -1, -1));

        Jcbox_aceptada.setBackground(new java.awt.Color(204, 204, 204));
        Tipo_estados.add(Jcbox_aceptada);
        Jcbox_aceptada.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Jcbox_aceptada.setText("Aceptada");
        Jcbox_aceptada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jcbox_aceptadaActionPerformed(evt);
            }
        });
        Administrar_Solicitudes.add(Jcbox_aceptada, new org.netbeans.lib.awtextra.AbsoluteConstraints(626, 275, -1, -1));

        Jcbox_cancelada.setBackground(new java.awt.Color(204, 204, 204));
        Tipo_estados.add(Jcbox_cancelada);
        Jcbox_cancelada.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Jcbox_cancelada.setText("Cancelada");
        Jcbox_cancelada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jcbox_canceladaActionPerformed(evt);
            }
        });
        Administrar_Solicitudes.add(Jcbox_cancelada, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 275, -1, -1));

        Jcbox_rechazada.setBackground(new java.awt.Color(204, 204, 204));
        Tipo_estados.add(Jcbox_rechazada);
        Jcbox_rechazada.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Jcbox_rechazada.setText("Rechazada");
        Jcbox_rechazada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jcbox_rechazadaActionPerformed(evt);
            }
        });
        Administrar_Solicitudes.add(Jcbox_rechazada, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 275, -1, -1));

        Categorias.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Categorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selección", "ID Solicitud", "Fecha solicitud", "Estado", "Fecha de modificación", "Usuario institucional", "Salon/Edificio", "Fecha inicio", "Fecha termina", "Observaciones" }));
        Categorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoriasActionPerformed(evt);
            }
        });
        Administrar_Solicitudes.add(Categorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 67, 194, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Filtro:");
        Administrar_Solicitudes.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, -1, -1));

        jLabelCargandoAS.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        Administrar_Solicitudes.add(jLabelCargandoAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(721, 596, 90, 20));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel38.setText("Observaciones:");
        Administrar_Solicitudes.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));

        getContentPane().add(Administrar_Solicitudes, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

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

    public void entrar_bienvenida(Usuario usuario2) { //Selecciona el tipo de menu segun el usuario        
        ocultar_todosPaneles();
        Bienvenida.setVisible(true);
        Paneles_Menu.setVisible(true);
        this.usuario = usuario2;
        if (usuario.getTipoUsuario() == 1 || usuario.getTipoUsuario() == 4) {
            Menu_UE.setVisible(false);
            userLabel2.setText(usuario.getNombreusuarioInstitucional());
            jLabelEliminar1.setVisible(false);
            jLabelAñadir2.setVisible(false);
            if (usuario.getTipoUsuario() == 4) {
                roleLabel1.setText("Usuario Encargado");
            }
        } else if (usuario.getTipoUsuario() == 2) {
            Menu_UC.setVisible(false);
            jLabelEliminar1.setVisible(true);
            jLabelAñadir2.setVisible(true);
            userLabel1.setText(usuario.getNombreusuarioInstitucional());
        } else {
            Paneles_Menu.setVisible(false);
        }

    }

    private void ocultar_todosPaneles() { // Oculta todos los paneles menos el menu
        Bienvenida.setVisible(false);
        Solicitar_Espacio.setVisible(false);
        Administrar_Solicitudes.setVisible(false);
        Estadisticas.setVisible(false);
    }

    private void logOut() { //Cerrar sesion        
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Desea cerrar sesión?","Cerrar sesión",dialog);
        if(result == 0){
        Frame_Login frame_Login = new Frame_Login();
        frame_Login.setVisible(true);
        this.dispose();
        }
    }

    public void llenarMotivos(Usuario us) {
        String[] lista = validarSolicitudes.obtenerListaMotivos(us);

        for (String lista1 : lista) {
            jComboMotivos.addItem(lista1);
        }

    }

    public void solicitar_Espacio(String Espacio) throws SQLException { //Para mostrar la informacion en el panel de solicitar espacios     
        
        jLabelRepeticion.setText("No se repite");
        fechaTermina = obtener_fecha();
        indiceRepeticion = 4;
        llenarMotivos(usuario);
        ocultar_todosPaneles();
        Solicitar_Espacio.setVisible(true);
        jLabelCargandoSE.setText("Cargando...");
        jLabel36.setText(Espacio);
        jLabel37.setText("");
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{}, new String[]{" ID", "Nombre espacio", "Salon", "Edificio", "Encargado", "Estado", "Información adicional"})
        );
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{}, new String[]{"Horas ocupadas"})
        );
        llenarTabla(Espacio);
        jLabelCargandoSE.setText("");
    }

    private void verTodoSolicitud() {
        Buscador.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                TRSFiltro.setRowFilter(RowFilter.regexFilter("(?i)" + "Ver más", (categoria_fil("Selección") - 1)));
            }
        });
        TRSFiltro = new TableRowSorter(jTable2.getModel());
        jTable2.setRowSorter(TRSFiltro);
    }

    private void administrar_Solicitudes() { //Para mostrar las solicitudes en el administrador
        ocultar_todosPaneles();
        Categorias.setSelectedIndex(0);
       
       
        if (usuario.getTipoUsuario() == 1 || usuario.getTipoUsuario() == 4) {
            Aceptar_sol_boton.setVisible(false);
            Rechazar_sol_boton.setVisible(false);
            Administrar_Solicitudes.setVisible(true);
            jLabel31.setText("Cancelar solicitud");
        } else {
            Administrar_Solicitudes.setVisible(true);
        }

        try {
            llenarTabla_solicitudes("Todos");
        } catch (SQLException ex) {
            Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Tipo_estados.clearSelection();

    }

    private void ver_Estadisticas() { //Para ver estadisticas
        ocultar_todosPaneles();
        Estadisticas.setVisible(true);

    }

    private void llenarTabla(String tipo) throws SQLException {//modelo tabla

        Object[][] tabla = validarEspacios.llenarMatriz(tipo, usuario);
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
                tabla, new String[]{" ID", "Nombre espacio", "Salon", "Edificio", "Encargado", "Estado", "Información adicional"})
        );
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(SwingConstants.CENTER);
        jTable3.getColumnModel().getColumn(5).setCellRenderer(render);
    }

    private void llenarTabla_espacios(int id_espacio, String fecha, int day) throws SQLException {//modelo tabla espacios
        jLabelCargandoSE.setText("Cargando...");
        Object[][] tabla = validarEspacios.llenarMatriz_horas(id_espacio, fecha, usuario, day);
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
                tabla, new String[]{"Horas ocupadas"}));
        jLabelCargandoSE.setText("");
    }

    private void llenarTabla_solicitudes(String tipo_e) throws SQLException {//modelo tabla espacios
        Administrar_Solicitudes.setEnabled(false);              
        Categorias.setSelectedIndex(0);
        Buscador.setText("");
        Object[][] tabla = validarSolicitudes.llenarMatriz(usuario, tipo_e);
        jTable2.setModel(new javax.swing.table.DefaultTableModel( //fechas con horas
                tabla, new String[]{
                    "ID SOLICITUD", "FECHA SOLICITUD", "ESTADO", "FECHA DE MODIFICACIÓN", "USUARIO INTITUCIONAL", "SALON/EDIFICIO", "FECHA INICIO", "FECHA TERMINA", "OBSERVACIONES", "INFORMACIÓN ADICIONAL"

                }
        ));
        if(jTable2.getRowCount()==0){
          JOptionPane.showMessageDialog(null, "No tiene registros de solicitudes", "Sin registros", JOptionPane.INFORMATION_MESSAGE);
        }
        verTodoSolicitud();
        Administrar_Solicitudes.setEnabled(true);
    }

    private String obtener_fecha() {

        int año = jCalendar2.getCalendar().get(Calendar.YEAR);
        int mes = jCalendar2.getCalendar().get(Calendar.MONTH) + 1;
        int dia = jCalendar2.getCalendar().get(Calendar.DAY_OF_MONTH);

        return año + "-" + mes + "-" + dia;
    }

    private int obt_diaSemana() {
        TimeZone timezone = TimeZone.getDefault();
        Calendar calendar = new GregorianCalendar(timezone);
        calendar.set(jCalendar2.getCalendar().get(Calendar.YEAR), jCalendar2.getCalendar().get(Calendar.MONTH), jCalendar2.getCalendar().get(Calendar.DAY_OF_MONTH));
        int nD = calendar.get(Calendar.DAY_OF_WEEK);
        return nD;
    }

    private void verDetalles(Object obj) {
        jLabelCargandoSE.setText("Cargando...");
        try {

            Espacio espacio = new Espacio();
            espacio = validarEspacios.BuscarInfoEspacio(usuario, Integer.valueOf(obj.toString()));
            Frame_DetallesEspacio frame_DetallesEspacio = new Frame_DetallesEspacio();
            frame_DetallesEspacio.setVisible(true);
            frame_DetallesEspacio.llenarFrame(usuario, espacio, this);
            this.setEnabled(false);
            frame_DetallesEspacio.setVisible(true);
            jLabelCargandoSE.setText("");
        } catch (Exception e) {
            System.out.println(e);
        }

        // crear el frame
    }

    private void verDetalles_solicitudes(Object obj){           
          try{
             String[] datos=validarSolicitudes.datos_solicitud(usuario, Integer.valueOf(obj.toString()));
             String dias=validarSolicitudes.dias_sol(usuario, Integer.valueOf(obj.toString()));
             Frame_DetallesSolicitud frame_DetalleSolicitud= new Frame_DetallesSolicitud();
             frame_DetalleSolicitud.setVisible(true); 
             frame_DetalleSolicitud.llenar_frame(datos, dias, usuario,this);    
             this.setEnabled(false);
             frame_DetalleSolicitud.setVisible(true); 
          }catch (Exception e){
              System.out.println(e);
          }
                    
            // crear el frame
      }
    
    public void limpiarTabla() {

        DefaultTableModel M = (DefaultTableModel) jTable2.getModel();
        M.getDataVector().removeAllElements();
        M.fireTableDataChanged();
    }

    public int categoria_fil(String categoria) {
        if (categoria.equals("ID Solicitud")) {
            return 1;
        } else if (categoria.equals("Fecha solicitud")) {
            return 2;
        } else if (categoria.equals("Estado")) {
            return 3;
        } else if (categoria.equals("Fecha de modificación")) {
            return 4;
        } else if (categoria.equals("Usuario institucional")) {
            return 5;
        } else if (categoria.equals("Salon/Edificio")) {
            return 6;
        } else if (categoria.equals("Fecha inicio")) {
            return 7;
        } else if (categoria.equals("Fecha termina")) {
            return 8;
        } else if (categoria.equals("Observaciones")) {
            return 9;
        } else if (categoria.equals("Selección")) {
            return 10;
        } else {
            return 0;
        }

    }

    private void cambiarEstado(String tipE) throws AddressException {
        jLabelCargandoAS.setText("Cargando...");
        
        if (jTable2.getSelectedRow() != -1 && jTable2.getSelectedColumn() != -1) {

            int res = validarSolicitudes.cambiarEstado(usuario, tipE, jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString(), jTextField2.getText(), jTable2.getValueAt(jTable2.getSelectedRow(), 2).toString());
            if (res == 1) {
                jLabelCargandoSE.setText("Cargando...");
                JOptionPane.showMessageDialog(null, "Se han guardado los cambios", "Cambiar estado de la solicitud", JOptionPane.INFORMATION_MESSAGE);
                
                if (!tipE.equals("Cancelada")) {
                    int dialog = JOptionPane.YES_NO_OPTION;                                       
                    int result = JOptionPane.showConfirmDialog(null, "¿Desea notificar por correo al usuario?", "Exit", dialog);
                    if (result == 0) {                        
                       int a=-1;
                        while(true){
                           JPanel panel = new JPanel();
                        JPasswordField contrasenia2= new JPasswordField();        
                        contrasenia2.setPreferredSize(new Dimension(155,20));
                        panel.add(new JLabel("Ingrese la contraseña del Correo: horariosdesalastics@gmail.com"));
                        panel.add(contrasenia2);
                        a=JOptionPane.showConfirmDialog( null, panel, "Enviar correo", JOptionPane.OK_CANCEL_OPTION); 
                        String contrasenia = contrasenia2.getText();
                        if (!contrasenia.equals("") && a==0) {
                            
                            boolean c = validarSolicitudes.verificarEnvio(contrasenia, jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString(), tipE, jTable2.getValueAt(jTable2.getSelectedRow(), 4).toString(), jTextField2.getText());
                            if (c) {
                                JOptionPane.showMessageDialog(null, "Se ha notificado al usuario: " + jTable2.getValueAt(jTable2.getSelectedRow(), 4).toString() + "@unal.edu.co");
                            } else {
                                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar enviar el correo");
                            }
                            break;
                        }else if(a==0){
                             JOptionPane.showMessageDialog(null, "Valor no valido para la contraseña.");
                        }else{
                            break;
                        }
                        }
                         
                    }
                }
                administrar_Solicitudes();                
            } else if (res == -1 || res == -3) {
                JOptionPane.showMessageDialog(null, "Accion no valida", "Accion no valida", JOptionPane.INFORMATION_MESSAGE);
            } else if (res == -2) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar conectar con el servidor", "Error", JOptionPane.INFORMATION_MESSAGE);
            } else if (res == -4) {
                JOptionPane.showMessageDialog(null, "No tiene permisos para cancelar solicitudes de otros usuarios", "Accion no valida", JOptionPane.INFORMATION_MESSAGE);
            } else if (res == -5) {
                JOptionPane.showMessageDialog(null, "No es posible cambiar de estado la solicitud", "Accion no valida", JOptionPane.INFORMATION_MESSAGE);
            } else if (res == -6) {
                JOptionPane.showMessageDialog(null, "Ya existe un evento que se cruza con el evento de esta solicitud", "Accion no valida", JOptionPane.INFORMATION_MESSAGE);
            } 
            jLabelCargandoSE.setText("");
        }else{
             JOptionPane.showMessageDialog(null, "No ha seleccionado una solicitud para gestionar", "Accion no valida", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void setFechaTermina(String fechaTermina) {
        this.fechaTermina = fechaTermina;
    }

    public void setDiasRepeticion(int[] diasRepeticion) {
        this.diasRepeticion = diasRepeticion;
    }

    public void setIndiceRepeticion(int indiceRepeticion) {
        this.indiceRepeticion = indiceRepeticion;
    }

    private void abrirPersonalizacionHoras(Frame_Main frame) {
        Frame_PersonalizarRepeticion personalizar = new Frame_PersonalizarRepeticion();
        personalizar.setVisible(true);
        personalizar.setFramePadre(this);
        personalizar.setDia_Semana(obt_diaSemana());
        personalizar.setFechaInicio(obtener_fecha());
        this.setEnabled(false);

    }

    public void setTextoMuestralabel(String text) {
        this.jLabelRepeticion.setText(text);
    }

    public void verificarIngresoSolicitud() {

        evento = new Evento(0,
                (Integer) jSpinnerHorainicio.getValue() + ":0" + (Integer) jSpinnerMinutosInicio.getValue() + ":00",
                nombreRepeticion,
                obtener_fecha(),
                fechaTermina,
                (Integer) jSpinnerHorafinal.getValue() + ":0" + (Integer) jSpinnerMinutosFinal.getValue() + ":00",
                jTextMotivoSolicitud.getText(),
                -1,
                indiceRepeticion,
                diasRepeticion,
                jComboMotivos.getSelectedIndex());
        
        solicitud = new Solicitud(0,
                validarSolIngresada.fechaBD(usuario),
                "",
                "2",
                "",
                idEspacioSeleccionado,
                evento);
        
        String validacionFecha = validarSolIngresada.verificarFechaActual(usuario, fechaTermina, obtener_fecha());
        String validacionHoras = validarSolIngresada.verificarHorasMinutosIngresadas((Integer) jSpinnerHorainicio.getValue(), 
                (Integer) jSpinnerMinutosInicio.getValue(), 
                (Integer) jSpinnerHorafinal.getValue(), 
                (Integer) jSpinnerMinutosFinal.getValue());
        String valicacionMotivoSolicitud = validarSolIngresada.verificarMotivoSolicitud(jComboMotivos.getItemAt(jComboMotivos.getSelectedIndex()), 
                jTextMotivoSolicitud.getText());
        String verificacionConcurrencia = (validarSolIngresada.verificarCruceEventos(usuario, solicitud))? "El evento se puede registrar" :"Un evento ya aceptado se cruza con este o no seleccionó ningún espacio donde hacer la solicitud";
        
        boolean validado = validarSolIngresada.verificarDatosSolicitudNueva(usuario, 
                solicitud, 
                jComboMotivos.getItemAt(jComboMotivos.getSelectedIndex()), 
                jTextMotivoSolicitud.getText(), 
                fechaTermina, 
                obtener_fecha(), 
                (Integer) jSpinnerHorainicio.getValue(), 
                (Integer) jSpinnerMinutosInicio.getValue(), 
                (Integer) jSpinnerHorafinal.getValue(), 
                (Integer) jSpinnerMinutosFinal.getValue());
        
        validacionFecha = ("La fecha es valida".equals(validacionFecha)) ? "" : " <tr><td>"+validacionFecha+"</td></tr>";
        validacionHoras = ("Las horas están correctas".equals(validacionHoras)) ? "" : "<tr><td>"+validacionHoras+"</td></tr>";
        valicacionMotivoSolicitud = ("Motivo ingresado correctamente".equals(valicacionMotivoSolicitud)) ? "" : "<tr><td>"+valicacionMotivoSolicitud+"</td></tr>";
        verificacionConcurrencia = ("El evento se puede registrar".equals(verificacionConcurrencia)) ? "" : "<tr><td>"+verificacionConcurrencia+"</td></tr>";
        
        
        if(validado == false){
            JOptionPane.showMessageDialog(null, "<html>Se observan los siguientes detalles, por favor verifique: <br><br> " + "<table class=\"egt\" border=\"1\">"
                +validacionFecha
                +validacionHoras
                +valicacionMotivoSolicitud
                +verificacionConcurrencia
                +"</table>" + "</html>");
        
        }else{
           validarSolIngresada.ingresarSolicitudNueva(usuario, solicitud);
            JOptionPane.showMessageDialog(null, "Solicitud ingresada con exito");
        }

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
            Logger.getLogger(Frame_Main.class
                    .getName()).log(Level.SEVERE, null, ex);
        }



    }//GEN-LAST:event_jLabel2MousePressed

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

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        logOut();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        logOut();
    }//GEN-LAST:event_jLabel24MouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_formMouseDragged

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        nombreRepeticion = "No se repite";
        indiceRepeticion = 4;
        jLabelRepeticion.setText("No se repite");
        if (jCheckBox3.isSelected()) {
            jButtonPersonalizar.setEnabled(true);
        } else {
            jButtonPersonalizar.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jLabel19MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MousePressed

        try {
            solicitar_Espacio("Laboratorios");
        } catch (SQLException ex) {
            Logger.getLogger(Frame_Main.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jLabel19MousePressed

    private void jLabel20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MousePressed

        try {
            solicitar_Espacio("Sala de reuniones");
        } catch (SQLException ex) {
            Logger.getLogger(Frame_Main.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jLabel20MousePressed

    private void jLabel21MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MousePressed

        try {
            solicitar_Espacio("Sala de computadores");
        } catch (SQLException ex) {
            Logger.getLogger(Frame_Main.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jLabel21MousePressed

    private void jLabel22MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MousePressed

        try {
            solicitar_Espacio("Auditorios");
        } catch (SQLException ex) {
            Logger.getLogger(Frame_Main.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jLabel22MousePressed

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed

        try {
            solicitar_Espacio("Sala de reuniones");
        } catch (SQLException ex) {
            Logger.getLogger(Frame_Main.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        llenarMotivos(usuario);
    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed

        try {
            solicitar_Espacio("Sala de computadores");
        } catch (SQLException ex) {
            Logger.getLogger(Frame_Main.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        llenarMotivos(usuario);
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed

        try {
            solicitar_Espacio("Auditorios");
        } catch (SQLException ex) {
            Logger.getLogger(Frame_Main.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        llenarMotivos(usuario);
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
        try {
            cambiarEstado("Aceptada");
        } catch (AddressException ex) {
            Logger.getLogger(Frame_Main.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Aceptar_sol_botonActionPerformed

    private void BuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscadorActionPerformed

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

        ocultar_todosPaneles();
        Bienvenida.setVisible(true);
    }//GEN-LAST:event_jLabel18MousePressed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked

        if (jTable3.getSelectedRow() != -1 && jTable3.getSelectedColumn() != -1) {
            if (jTable3.getSelectedColumn() == 6) {
                verDetalles(jTable3.getValueAt(jTable3.getSelectedRow(), 0));
            }
            String edificio = (jTable3.getValueAt(jTable3.getSelectedRow(), 3)).toString();
            String Salon = (jTable3.getValueAt(jTable3.getSelectedRow(), 2)).toString();
            jLabel37.setText(Salon + " - " + edificio + "  ");
            idEspacioSeleccionado = (jTable3.getValueAt(jTable3.getSelectedRow(), 0)).toString();
            jLabelCargandoSE.setText("Cargando...");
            String fecha = obtener_fecha();
            int day = obt_diaSemana();     
            
            try {
                llenarTabla_espacios(Integer.valueOf(jTable3.getValueAt(jTable3.getSelectedRow(), 0).toString()), fecha, day);
            } catch (SQLException ex) {
                Logger.getLogger(Frame_Main.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            jLabelCargandoSE.setText("");
        }


    }//GEN-LAST:event_jTable3MouseClicked

    private void jCalendar2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendar2PropertyChange
        // TODO add your handling code here:
        fechaTermina = obtener_fecha();
        indiceRepeticion = 4;
        jLabelRepeticion.setText("No se repite");
        int[] d ={0, 0, 0, 0, 0, 0, 0};
        d[obt_diaSemana()-1] = obt_diaSemana();
        diasRepeticion = d;
        
        if (jTable3.getSelectedRow() != -1 && jTable3.getSelectedColumn() != -1) {
            jLabelCargandoSE.setText("Cargando...");
            int id_espacio = Integer.valueOf(jTable3.getValueAt(jTable3.getSelectedRow(), 0).toString());
            
            String fecha = obtener_fecha();
            
            int day = obt_diaSemana();
            System.out.println(day);
            try {
                llenarTabla_espacios(id_espacio, fecha, day);
            } catch (SQLException ex) {
                Logger.getLogger(Frame_Main.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            jLabelCargandoSE.setText("");
        }
    }//GEN-LAST:event_jCalendar2PropertyChange

    private void CategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoriasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CategoriasActionPerformed

    private void Jcbox_rechazadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jcbox_rechazadaActionPerformed
        try {
            if(tipo_rechazada){              
               llenarTabla_solicitudes("Todos"); 
               tipo_rechazada=false;
                Tipo_estados.clearSelection();
            }else{
                tipo_rechazada=true;
                llenarTabla_solicitudes("Rechazada");         
            }
                     
            } catch (SQLException ex) {
            Logger.getLogger(Frame_Main.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Jcbox_rechazadaActionPerformed

    private void Jcbox_esperaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jcbox_esperaActionPerformed
        try {
            if(tipo_espera){              
               llenarTabla_solicitudes("Todos"); 
               tipo_espera=false;
                Tipo_estados.clearSelection();
            }else{
                 tipo_espera=true;
               llenarTabla_solicitudes("Espera");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Frame_Main.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Jcbox_esperaActionPerformed

    private void Jcbox_canceladaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jcbox_canceladaActionPerformed
        try {
             if(tipo_cancelada){              
               llenarTabla_solicitudes("Todos"); 
               tipo_cancelada=false;
                Tipo_estados.clearSelection();
            }else{
             tipo_cancelada=true;
               llenarTabla_solicitudes("Cancelada");
             }
        } catch (SQLException ex) {
            Logger.getLogger(Frame_Main.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Jcbox_canceladaActionPerformed

    private void Jcbox_aceptadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jcbox_aceptadaActionPerformed
        try {
            if(tipo_aceptada){              
               llenarTabla_solicitudes("Todos"); 
               tipo_aceptada=false;
                Tipo_estados.clearSelection();
            }else{
            tipo_aceptada=true;
            llenarTabla_solicitudes("Aceptada");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Frame_Main.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_Jcbox_aceptadaActionPerformed

    private void BuscadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscadorKeyTyped
        String categoria = (String) Categorias.getSelectedItem();
        if (categoria_fil(categoria) != 10) {
            Buscador.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent ke) {
                    TRSFiltro.setRowFilter(RowFilter.regexFilter("(?i)" + Buscador.getText(), (categoria_fil(categoria) - 1)));
                }
            });
            TRSFiltro = new TableRowSorter(jTable2.getModel());
            jTable2.setRowSorter(TRSFiltro);
        }
    }//GEN-LAST:event_BuscadorKeyTyped

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        try {
            cambiarEstado("Cancelada");
        } catch (AddressException ex) {
            Logger.getLogger(Frame_Main.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void Rechazar_sol_botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rechazar_sol_botonActionPerformed
        try {
            cambiarEstado("Rechazada");
        } catch (AddressException ex) {
            Logger.getLogger(Frame_Main.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Rechazar_sol_botonActionPerformed

    private void jButtonPersonalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPersonalizarActionPerformed
        abrirPersonalizacionHoras(this);
    }//GEN-LAST:event_jButtonPersonalizarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jLabelCargandoSE.setText("Cargando...");
        verificarIngresoSolicitud();
        jLabelCargandoSE.setText("");
          
           /* 
        System.out.println(solicitud.getEspacioidEspacio()+"\n"
        +solicitud.getEstadoSolicitud()+"\n"
        +solicitud.getEvento().getFechaEvento()+"\n"
        +solicitud.getEvento().getFechaTerminaEvento()+"\n"
        +solicitud.getEvento().getDiasRepite()[0]
        +solicitud.getEvento().getDiasRepite()[1]
        +solicitud.getEvento().getDiasRepite()[2]
        +solicitud.getEvento().getDiasRepite()[3]
        +solicitud.getEvento().getDiasRepite()[4]
        +solicitud.getEvento().getDiasRepite()[5]
        +solicitud.getEvento().getDiasRepite()[6]);
        */
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboMotivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboMotivosActionPerformed
        if (!"Seleccion".equals(jComboMotivos.getItemAt(jComboMotivos.getSelectedIndex()))) {
            jTextMotivoSolicitud.setEnabled(true);
        } else {
            jTextMotivoSolicitud.setEnabled(false);
        }
    }//GEN-LAST:event_jComboMotivosActionPerformed

    private void jLabelAñadir2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAñadir2MouseClicked
        jLabelCargandoSE.setText("Cargando...");
        Frame_DetallesEspacio frame_DetallesEspacio = new Frame_DetallesEspacio();
        try {
            Tipo=jLabel36.getText();
            frame_DetallesEspacio.setVisible(true);
            frame_DetallesEspacio.crearEspacio(Tipo,this,usuario);
            this.setEnabled(false);
            frame_DetallesEspacio.setVisible(true);
            
            jLabelCargandoSE.setText("");
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jLabelAñadir2MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        if(jTable2.getSelectedRow()!=-1 && jTable2.getSelectedColumn()!=-1){
            if(jTable2.getSelectedColumn()==9){
                     verDetalles_solicitudes(jTable2.getValueAt(jTable2.getSelectedRow(),0));
             }
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jLabelEliminar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEliminar1MouseClicked
      
        if (jTable3.getSelectedRow() != -1 && jTable3.getSelectedColumn() != -1) {
        String edificio = (jTable3.getValueAt(jTable3.getSelectedRow(), 3)).toString();
        String Salon = (jTable3.getValueAt(jTable3.getSelectedRow(), 2)).toString();
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar el espacio: "+Salon+" - "+edificio+"?", "Exit", dialog);
          if (result == 0) {
           
                jLabelCargandoSE.setText("Cargando...");
                int n= validarEspacios.borrarEspacio(usuario, idEspacioSeleccionado);

                if(n==1){
                    try {
                        solicitar_Espacio(jLabel36.getText());
                    } catch (SQLException ex) {
                        Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(null, "El espacio fue borrado.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }else if(n==-1){
                  JOptionPane.showMessageDialog(null, "Ha ocurrido un error al conectar con la base de datos.", "Error", JOptionPane.INFORMATION_MESSAGE); 
                }else if(n==-2){
                   JOptionPane.showMessageDialog(null, "No es posible eliminar el espacio ya que tiene solicitudes en espera.", "Acción no valida", JOptionPane.INFORMATION_MESSAGE);  
                }else if(n==-3){
                   JOptionPane.showMessageDialog(null, "No tiene permisos para ejecutar esta acción", "Acción no valida", JOptionPane.INFORMATION_MESSAGE);    
                }
                jLabelCargandoSE.setText("");
                 
             }
                    }else{
              JOptionPane.showMessageDialog(null, "No ha seleccionado un espacio para borrar.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jLabelEliminar1MouseClicked
    
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
            java.util.logging.Logger.getLogger(Frame_Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButtonPersonalizar;
    private com.toedter.calendar.JCalendar jCalendar2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JComboBox<String> jComboMotivos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAñadir2;
    private javax.swing.JLabel jLabelCargandoAS;
    private javax.swing.JLabel jLabelCargandoSE;
    private javax.swing.JLabel jLabelEliminar1;
    private javax.swing.JLabel jLabelRepeticion;
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
    private javax.swing.JSpinner jSpinnerHorafinal;
    private javax.swing.JSpinner jSpinnerHorainicio;
    private javax.swing.JSpinner jSpinnerMinutosFinal;
    private javax.swing.JSpinner jSpinnerMinutosInicio;
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
