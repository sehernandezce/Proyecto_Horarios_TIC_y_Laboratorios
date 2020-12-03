package GUI;

import Control.ValidarEspacios;
import Control.Validar_Registro;
import Control.Validar_administrar_solicitud;
import Entidad.Espacio;
import Entidad.Evento;
import Entidad.Solicitud;
import Entidad.Usuario;
import GUI.Frame_DetallesEspacio;
import java.awt.Color;
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
import Control.GraficarEstadisticas;
import Control.ManipularConecciones;
import Hilos.HiloCargando;
import Hilos.HiloFrame_Main;
import Control.ValidarInventario;
import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.ImageIcon;
import java.io.IOException;
import javax.swing.JFileChooser;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

public class Frame_Main extends javax.swing.JFrame {

    private int x, y;

    private Usuario usuario;
    private Solicitud solicitud;
    private Evento evento;
    private ValidarEspacios validarEspacios;
    private ValidarInventario validarInventario;
    private ManipularConecciones manipulacionConexiones;
    private String idEspacioSeleccionado;
    private Validar_administrar_solicitud validarSolicitudes;
    private GraficarEstadisticas graficar;
    private TableRowSorter TRSFiltro;
    private String fechaTermina;
    private int[] diasRepeticion = {0, 0, 0, 0, 0, 0, 0};
    private int indiceRepeticion;
    private String nombreRepeticion = "Diariamente";
    private boolean tipo_rechazada = false;
    private boolean tipo_espera = false;
    private boolean tipo_aceptada = false;
    private boolean tipo_cancelada = false;
    public HiloCargando hiloCargando=new HiloCargando();
    public static HiloFrame_Main hiloFrame_Main= new HiloFrame_Main();
    private int EstadisticasSeleccion;    
    public String Tipo;
    JFileChooser seleccionar=new JFileChooser();
    private File archivo;
    private byte[] imagen;
    private FileOutputStream salida;
            
    

    public Frame_Main() {
        initComponents();
        this.setLocationRelativeTo(null);
        ocultar_todosPaneles();
        Paneles_Menu.setVisible(false);
        jLCargando.setVisible(false);        
    }

   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tipo_estados = new javax.swing.ButtonGroup();
        Estadisticas_por_tipo = new javax.swing.ButtonGroup();
        panelCerrar = new javax.swing.JPanel();
        jlClose1 = new javax.swing.JLabel();
        jlMinimize1 = new javax.swing.JLabel();
        LbUsuario = new javax.swing.JLabel();
        Paneles_Menu = new javax.swing.JPanel();
        Menu_UC = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jlLab = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jlSalaR = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jlAdm = new javax.swing.JLabel();
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
        jLabel11 = new javax.swing.JLabel();
        jSeparator17 = new javax.swing.JSeparator();
        jLCargando = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        Menu_UE = new javax.swing.JPanel();
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
        jLabel43 = new javax.swing.JLabel();
        jSeparator18 = new javax.swing.JSeparator();
        jLCargandos0 = new javax.swing.JLabel();
        jSeparator19 = new javax.swing.JSeparator();
        jLabel57 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        Bienvenida = new javax.swing.JPanel();
        MensajeBienvenida = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        controlPanelTitle = new javax.swing.JLabel();
        Fondo1 = new javax.swing.JLabel();
        Solicitar_Espacio = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        masInfoSolicitud2 = new javax.swing.JLabel();
        masInfoSolicitud = new javax.swing.JLabel();
        masInfoSolicitud3 = new javax.swing.JLabel();
        masInfoSolicitud4 = new javax.swing.JLabel();
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
        jLabelRepeticion = new javax.swing.JLabel();
        jSpinnerHorainicio = new javax.swing.JSpinner();
        jLabelAñadir2 = new javax.swing.JLabel();
        jLabelEliminar1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        dudaSolicitud = new javax.swing.JLabel();
        dudaSolicitud2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboSelectDuracion = new javax.swing.JComboBox<>();
        dudaSolicitud3 = new javax.swing.JLabel();
        dudaSolicitud4 = new javax.swing.JLabel();
        Fondo5 = new javax.swing.JLabel();
        Configuraciones = new javax.swing.JPanel();
        Menu_confg = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel45 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        jLabel46 = new javax.swing.JLabel();
        opcion3 = new javax.swing.JLabel();
        opcion1 = new javax.swing.JLabel();
        opcion2 = new javax.swing.JLabel();
        about = new javax.swing.JPanel();
        controlPanelTitle3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        Fondo2 = new javax.swing.JLabel();
        CambiarContraseña = new javax.swing.JPanel();
        controlPanelTitle1 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        LbContraseña = new javax.swing.JLabel();
        JtfUsuario = new javax.swing.JTextField();
        LbUsuario1 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        LbContraseña1 = new javax.swing.JLabel();
        jPasswordField3 = new javax.swing.JPasswordField();
        LbUsuario2 = new javax.swing.JLabel();
        LbContraseña2 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        Fondo3 = new javax.swing.JLabel();
        notificaciones = new javax.swing.JPanel();
        controlPanelTitle2 = new javax.swing.JLabel();
        JtfUsuario1 = new javax.swing.JTextField();
        LbContraseña3 = new javax.swing.JLabel();
        jPasswordField4 = new javax.swing.JPasswordField();
        LbUsuario3 = new javax.swing.JLabel();
        JtfUsuario2 = new javax.swing.JTextField();
        LbContraseña4 = new javax.swing.JLabel();
        jPasswordField5 = new javax.swing.JPasswordField();
        LbUsuario4 = new javax.swing.JLabel();
        jPasswordField6 = new javax.swing.JPasswordField();
        LbContraseña5 = new javax.swing.JLabel();
        LbContraseña6 = new javax.swing.JLabel();
        jPasswordField7 = new javax.swing.JPasswordField();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        LbContraseña7 = new javax.swing.JLabel();
        dudaCorreo = new javax.swing.JLabel();
        masInfoCodigo = new javax.swing.JLabel();
        dudaCodigo = new javax.swing.JLabel();
        masInfoCorreo = new javax.swing.JLabel();
        Fondo4 = new javax.swing.JLabel();
        Administrar_Solicitudes = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
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
        jLabel38 = new javax.swing.JLabel();
        dudaadmSolicitud1 = new javax.swing.JLabel();
        dudaadmSolicitud2 = new javax.swing.JLabel();
        dudaadmSolicitud3 = new javax.swing.JLabel();
        masInfoAceptar = new javax.swing.JLabel();
        masInfoCancelar = new javax.swing.JLabel();
        masInfoRechazar = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        Fondo6 = new javax.swing.JLabel();
        Estadisticas = new javax.swing.JPanel();
        masInfoEstadisticas = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jLabel34 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel35 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jButton8 = new javax.swing.JButton();
        jMonthChooser2 = new com.toedter.calendar.JMonthChooser();
        jYearChooser2 = new com.toedter.calendar.JYearChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        dudaEstadisticas = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        Fondo7 = new javax.swing.JLabel();

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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCerrar.setBackground(new java.awt.Color(86, 90, 92));
        panelCerrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlClose1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlClose1MouseExited(evt);
            }
        });
        panelCerrar.add(jlClose1, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 10, -1, -1));

        jlMinimize1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/linea.png"))); // NOI18N
        jlMinimize1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlMinimize1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlMinimize1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlMinimize1MouseExited(evt);
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

        Menu_UC.setBackground(new java.awt.Color(148, 180, 59));
        Menu_UC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        Menu_UC.setMinimumSize(new java.awt.Dimension(170, 520));
        Menu_UC.setPreferredSize(new java.awt.Dimension(170, 520));
        Menu_UC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Menu_UC.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 141, 166, 1));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Menu_UC.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 173, 166, 1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Espacios");
        Menu_UC.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 147, -1, 30));

        jlLab.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jlLab.setForeground(new java.awt.Color(255, 255, 255));
        jlLab.setText("Laboratorio");
        jlLab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlLabMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlLabMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlLabMousePressed(evt);
            }
        });
        Menu_UC.add(jlLab, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 175, -1, 30));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Menu_UC.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 203, 166, 1));

        jlSalaR.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jlSalaR.setForeground(new java.awt.Color(255, 255, 255));
        jlSalaR.setText("Sala de reuniones");
        jlSalaR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlSalaRMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlSalaRMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlSalaRMousePressed(evt);
            }
        });
        Menu_UC.add(jlSalaR, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 210, -1, 30));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Menu_UC.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 233, 166, 1));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Menu_UC.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 263, 166, 1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Sala con computadores");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });
        Menu_UC.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 240, -1, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Auditorios");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });
        Menu_UC.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 270, -1, 30));

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Menu_UC.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 293, 170, 1));

        jlAdm.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jlAdm.setForeground(new java.awt.Color(255, 255, 255));
        jlAdm.setText("Administrar solicitudes");
        jlAdm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlAdmMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlAdmMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlAdmMousePressed(evt);
            }
        });
        Menu_UC.add(jlAdm, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 297, -1, 30));

        jSeparator7.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Menu_UC.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 323, 160, 1));

        jSeparator8.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Menu_UC.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 436, 160, 1));

        jSeparator9.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Menu_UC.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 468, 160, 1));

        jLabel7.setText("Cerrar sesion");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });
        Menu_UC.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 446, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo-universidad-nacional-de-colombia-sede-manizales-1-638_preview_rev_1_opt.png"))); // NOI18N
        Menu_UC.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 476, -1, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario.png"))); // NOI18N
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel18MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel18MousePressed(evt);
            }
        });
        Menu_UC.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 17, -1, -1));

        userLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        userLabel1.setForeground(new java.awt.Color(177, 178, 176));
        userLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userLabel1.setText("Username");
        Menu_UC.add(userLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 87, 154, 21));

        roleLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        roleLabel.setForeground(new java.awt.Color(255, 255, 255));
        roleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roleLabel.setText("Usuario Coordinador");
        Menu_UC.add(roleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 113, 154, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Estadisticas");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel8MousePressed(evt);
            }
        });
        Menu_UC.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 325, -1, 30));

        jSeparator10.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Menu_UC.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 160, 1));

        jLabel11.setBackground(new java.awt.Color(0, 0, 102));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/configuraciones.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });
        Menu_UC.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 17, -1, -1));

        jSeparator17.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator17.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Menu_UC.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 1, 518));

        jLCargando.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reloj-de-arena.png"))); // NOI18N
        Menu_UC.add(jLCargando, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 415, 16, 16));

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo2 2.jpg"))); // NOI18N
        Menu_UC.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 0, -1, -1));

        Paneles_Menu.add(Menu_UC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 520));

        Menu_UE.setBackground(new java.awt.Color(148, 180, 59));
        Menu_UE.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), null, new java.awt.Color(0, 0, 0)));
        Menu_UE.setMinimumSize(new java.awt.Dimension(170, 520));
        Menu_UE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Menu_UE.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 147, 166, 1));

        jSeparator21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Menu_UE.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 179, 166, 1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("Espacios");
        Menu_UE.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 157, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Laboratorio");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel19MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel19MousePressed(evt);
            }
        });
        Menu_UE.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 187, -1, -1));

        jSeparator22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Menu_UE.add(jSeparator22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 209, 166, 1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Sala de reuniones");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel20MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel20MousePressed(evt);
            }
        });
        Menu_UE.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 217, -1, -1));

        jSeparator23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Menu_UE.add(jSeparator23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 239, 166, 1));

        jSeparator24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Menu_UE.add(jSeparator24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 269, 166, 1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Sala con computadores");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel21MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel21MousePressed(evt);
            }
        });
        Menu_UE.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 247, -1, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Auditorios");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel22MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel22MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel22MousePressed(evt);
            }
        });
        Menu_UE.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 277, -1, -1));

        jSeparator25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Menu_UE.add(jSeparator25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 299, 166, 1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Mis solicitudes");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel23MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel23MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel23MousePressed(evt);
            }
        });
        Menu_UE.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 307, -1, -1));

        jSeparator26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Menu_UE.add(jSeparator26, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 329, 166, 1));

        jSeparator27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Menu_UE.add(jSeparator27, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 436, 160, 1));

        jSeparator28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Menu_UE.add(jSeparator28, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 468, 160, 1));

        jLabel24.setText("Cerrar sesion");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel24MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel24MouseExited(evt);
            }
        });
        Menu_UE.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 446, -1, -1));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo-universidad-nacional-de-colombia-sede-manizales-1-638_preview_rev_1_opt.png"))); // NOI18N
        Menu_UE.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 476, -1, -1));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario.png"))); // NOI18N
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel26MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel26MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel26MousePressed(evt);
            }
        });
        Menu_UE.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 17, -1, -1));

        userLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        userLabel2.setForeground(new java.awt.Color(177, 178, 176));
        userLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userLabel2.setText("Username");
        Menu_UE.add(userLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 154, 21));

        roleLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        roleLabel1.setForeground(new java.awt.Color(255, 255, 255));
        roleLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roleLabel1.setText("Usuario estandar");
        Menu_UE.add(roleLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 154, -1));

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/configuraciones.png"))); // NOI18N
        jLabel43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel43MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel43MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel43MouseExited(evt);
            }
        });
        Menu_UE.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 17, -1, -1));

        jSeparator18.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator18.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Menu_UE.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 1, 519));

        jLCargandos0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reloj-de-arena.png"))); // NOI18N
        Menu_UE.add(jLCargandos0, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 415, 16, 16));

        jSeparator19.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Menu_UE.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 160, 1));

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Estadisticas");
        jLabel57.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel57MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel57MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel57MousePressed(evt);
            }
        });
        Menu_UE.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, 30));

        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo2 2.jpg"))); // NOI18N
        Menu_UE.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 0, -1, -1));

        Paneles_Menu.add(Menu_UE, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 520));

        getContentPane().add(Paneles_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 170, 520));

        Bienvenida.setBackground(new java.awt.Color(204, 204, 204));
        Bienvenida.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Bienvenida.setMaximumSize(new java.awt.Dimension(854, 520));
        Bienvenida.setMinimumSize(new java.awt.Dimension(854, 520));
        Bienvenida.setPreferredSize(new java.awt.Dimension(854, 520));
        Bienvenida.setRequestFocusEnabled(false);
        Bienvenida.setLayout(new java.awt.BorderLayout());

        MensajeBienvenida.setBackground(new java.awt.Color(166, 28, 26));
        MensajeBienvenida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        MensajeBienvenida.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("\n  Bienvenido/a al sistema de horarios de  salas TIC´s y laboratorios\n\n    Pasos a seguir si quiere solicitar un espacio:\n\n         1. Elija el tipo de espacio en la barra lateral.\n         2. Seleccione el espacio que necesita. Puede dar click en ultima columna a la derecha para mas información del espacio.\n         3. Verifique si el espacio en la fecha y hora que necesita esta disponible.\n         4. Realice la solicitud llenando los campos. Si el espacio se encuentra disponible, quedara la solicitud en espera a que \n             el coordinador valide y acepte la solicitud.\n         5. Para validar el estado o ver información de su solicitud, en la barra lateral izquierda debe seleccionar mis solicitudes.");
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        MensajeBienvenida.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 188, 842, 270));

        controlPanelTitle.setBackground(new java.awt.Color(177, 178, 176));
        controlPanelTitle.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        controlPanelTitle.setText("Bienvenid@");
        MensajeBienvenida.add(controlPanelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 82, -1, 47));

        Fondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo_blanco1 1 .jpg"))); // NOI18N
        MensajeBienvenida.add(Fondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 880, -1));

        Bienvenida.add(MensajeBienvenida, java.awt.BorderLayout.CENTER);

        getContentPane().add(Bienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 854, 520));

        Solicitar_Espacio.setBackground(new java.awt.Color(204, 204, 204));
        Solicitar_Espacio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Solicitar_Espacio.setPreferredSize(new java.awt.Dimension(854, 520));
        Solicitar_Espacio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setMinimumSize(new java.awt.Dimension(854, 520));
        jPanel2.setPreferredSize(new java.awt.Dimension(854, 520));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        masInfoSolicitud2.setBackground(new java.awt.Color(255, 255, 255));
        masInfoSolicitud2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        masInfoSolicitud2.setText("<html><Center> Seleccione la fecha y espacio <p>para conocer en que horas del dia<p>esta ocupado el espacio. ");
        masInfoSolicitud2.setOpaque(true);
        jPanel2.add(masInfoSolicitud2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, 190, 70));

        masInfoSolicitud.setBackground(new java.awt.Color(255, 255, 255));
        masInfoSolicitud.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        masInfoSolicitud.setText("<html><Center> No se permite realizar<p> eventos los dias domingos. ");
        masInfoSolicitud.setOpaque(true);
        jPanel2.add(masInfoSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 146, 130, 70));

        masInfoSolicitud3.setBackground(new java.awt.Color(255, 255, 255));
        masInfoSolicitud3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        masInfoSolicitud3.setText("<html><Center> Calcular hora final: Hora final=Hora de inicio + duración en horas.<p> Solo se permite eventos de 2 horas para las siguientes horas de inicio<p> 7,9,11,14,16,18,20 ");
        masInfoSolicitud3.setOpaque(true);
        jPanel2.add(masInfoSolicitud3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 230, 90));

        masInfoSolicitud4.setBackground(new java.awt.Color(255, 255, 255));
        masInfoSolicitud4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        masInfoSolicitud4.setText("<html><Center> Ingrese la hora inicial en horario militar en el rango de 6 a 21.<p> La hora debe ser exacta sin ',' o '.'");
        masInfoSolicitud4.setOpaque(true);
        jPanel2.add(masInfoSolicitud4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 360, 40));

        jTable3 = new javax.swing.JTable(){
            public boolean isCellEditable (int rowIndex, int colIndex){
                return false;
            }
        };
        jTable3.getTableHeader().setReorderingAllowed(false);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 810, 112));

        jSeparator12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 170, 920, 1));

        jTable4 = new javax.swing.JTable(){
            public boolean isCellEditable (int rowIndex, int colIndex){
                return false;
            }
        };
        jTable4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
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
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 240, 20));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Tipo de espacio");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, 90, 20));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Duración en horas:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, 20));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setText("¿El evento se repite?");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, 30));

        jCheckBox3.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, -1, 14));

        jButtonPersonalizar.setBackground(new java.awt.Color(0, 255, 240));
        jButtonPersonalizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonPersonalizar.setText("Personalizar");
        jButtonPersonalizar.setEnabled(false);
        jButtonPersonalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonPersonalizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonPersonalizarMouseExited(evt);
            }
        });
        jButtonPersonalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPersonalizarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonPersonalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, -1, 30));

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
        jPanel2.add(jComboMotivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 379, 168, 30));

        jCalendar2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jCalendar2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendar2PropertyChange(evt);
            }
        });
        jPanel2.add(jCalendar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 350, 223));
        jCalendar2.setFont(new java.awt.Font("Segoe UI", 1, 10));

        jButton3.setBackground(new java.awt.Color(0, 255, 240));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("Solicitar");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, -1, 30));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel36.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        jPanel2.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 250, 158, 20));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel37.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        jPanel2.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 290, 160, 20));

        jTextMotivoSolicitud.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextMotivoSolicitud.setEnabled(false);
        jPanel2.add(jTextMotivoSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 168, 50));

        jLabelRepeticion.setToolTipText("");
        jPanel2.add(jLabelRepeticion, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 314, 260, 60));

        jSpinnerHorainicio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel2.add(jSpinnerHorainicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 56, 30));

        jLabelAñadir2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/anadir.png"))); // NOI18N
        jLabelAñadir2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAñadir2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAñadir2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelAñadir2MouseExited(evt);
            }
        });
        jPanel2.add(jLabelAñadir2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, -1, -1));

        jLabelEliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar.png"))); // NOI18N
        jLabelEliminar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEliminar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelEliminar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelEliminar1MouseExited(evt);
            }
        });
        jPanel2.add(jLabelEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, -1, -1));

        jLabel14.setBackground(new java.awt.Color(0, 102, 255));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 255));
        jLabel14.setText("Información de los espacios");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel29.setBackground(new java.awt.Color(0, 102, 255));
        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 102, 255));
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
        jPanel2.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, 20));

        dudaSolicitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/signo-de-pregunta-en-circulos.png"))); // NOI18N
        dudaSolicitud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dudaSolicitudMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dudaSolicitudMouseExited(evt);
            }
        });
        jPanel2.add(dudaSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 220, -1, -1));

        dudaSolicitud2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/signo-de-pregunta-en-circulos.png"))); // NOI18N
        dudaSolicitud2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dudaSolicitud2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dudaSolicitud2MouseExited(evt);
            }
        });
        jPanel2.add(dudaSolicitud2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 203, -1, -1));

        jLabel2.setBackground(new java.awt.Color(0, 255, 255));
        jLabel2.setOpaque(true);
        jLabel2.setPreferredSize(new java.awt.Dimension(32, 32));
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, -1, -1));

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setOpaque(true);
        jLabel3.setPreferredSize(new java.awt.Dimension(32, 32));
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, -1, -1));

        jComboSelectDuracion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 Hora", "2 Horas" }));
        jPanel2.add(jComboSelectDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 80, 30));

        dudaSolicitud3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/signo-de-pregunta-en-circulos.png"))); // NOI18N
        dudaSolicitud3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dudaSolicitud3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dudaSolicitud3MouseExited(evt);
            }
        });
        jPanel2.add(dudaSolicitud3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, -1, -1));

        dudaSolicitud4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/signo-de-pregunta-en-circulos.png"))); // NOI18N
        dudaSolicitud4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dudaSolicitud4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dudaSolicitud4MouseExited(evt);
            }
        });
        jPanel2.add(dudaSolicitud4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, -1));

        Fondo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo_blanco1 1 .jpg"))); // NOI18N
        jPanel2.add(Fondo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 880, -1));

        Solicitar_Espacio.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(Solicitar_Espacio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, 520));

        Configuraciones.setBackground(new java.awt.Color(255, 255, 255));
        Configuraciones.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Configuraciones.setMaximumSize(new java.awt.Dimension(854, 520));
        Configuraciones.setMinimumSize(new java.awt.Dimension(854, 520));
        Configuraciones.setPreferredSize(new java.awt.Dimension(854, 520));
        Configuraciones.setRequestFocusEnabled(false);
        Configuraciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menu_confg.setBackground(new java.awt.Color(86, 90, 92));
        Menu_confg.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Menu_confg.setForeground(new java.awt.Color(102, 255, 255));
        Menu_confg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel44.setText("Cambiar contraseña");
        jLabel44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel44MouseClicked(evt);
            }
        });
        Menu_confg.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 122, 20));
        Menu_confg.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 120, 10));

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel45.setText("Notificaciones y código");
        jLabel45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel45MouseClicked(evt);
            }
        });
        Menu_confg.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 150, 20));

        jSeparator13.setOrientation(javax.swing.SwingConstants.VERTICAL);
        Menu_confg.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 5, 20, 20));
        Menu_confg.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 140, 10));

        jSeparator15.setOrientation(javax.swing.SwingConstants.VERTICAL);
        Menu_confg.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 5, 20, 20));
        Menu_confg.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 120, 10));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel46.setText("About & Contact");
        jLabel46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel46MouseClicked(evt);
            }
        });
        Menu_confg.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 122, 20));

        opcion3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Menu_confg.add(opcion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 160, 30));

        opcion1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Menu_confg.add(opcion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 30));

        opcion2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Menu_confg.add(opcion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 140, 30));

        Configuraciones.add(Menu_confg, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 24, 806, 30));

        about.setBackground(new java.awt.Color(204, 204, 204));
        about.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        about.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        controlPanelTitle3.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        controlPanelTitle3.setForeground(new java.awt.Color(177, 178, 176));
        controlPanelTitle3.setText("About & contact");
        about.add(controlPanelTitle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, -1));

        jTextArea4.setEditable(false);
        jTextArea4.setColumns(20);
        jTextArea4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextArea4.setForeground(java.awt.SystemColor.info);
        jTextArea4.setRows(5);
        jTextArea4.setText("\n      Esta aplicación fue desarrollada por estudiantes del programa Ingeniería de sistemas y computación\n      de la Universidad Nacional de Colombia: \n      \n       *Sebastián Hernández Cerón\n       *Yeison Cuervo Basurto\n       *Sebastian Camilo Casas Rojas\n       *Diego Esteban Morales Granados\n       *Rodrigo Sierra Agredo\n\n     Con el acompañamiento del profesor Henry Roberto Umana Acosta.\n\n     \n    \t\t\t\t\t            v.3.0.0 7/12/2020");
        jTextArea4.setEnabled(false);
        jScrollPane2.setViewportView(jTextArea4);

        about.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 630, 260));

        Fondo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo_blanco1 1 .jpg"))); // NOI18N
        about.add(Fondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 880, -1));

        Configuraciones.add(about, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 54, 806, 446));

        CambiarContraseña.setBackground(new java.awt.Color(204, 204, 204));
        CambiarContraseña.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        CambiarContraseña.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        controlPanelTitle1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        controlPanelTitle1.setForeground(new java.awt.Color(177, 178, 176));
        controlPanelTitle1.setText("Cambiar contraseña");
        CambiarContraseña.add(controlPanelTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 350, -1));

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario_1.png"))); // NOI18N
        jLabel47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel47MousePressed(evt);
            }
        });
        CambiarContraseña.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, -1, -1));

        jPasswordField1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPasswordField1.setText("Contraseña");
        jPasswordField1.setPreferredSize(new java.awt.Dimension(15, 20));
        CambiarContraseña.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 230, 30));

        LbContraseña.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LbContraseña.setText("Contraseña actual");
        CambiarContraseña.add(LbContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 100, 30));

        JtfUsuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JtfUsuario.setText("Usuario institucional");
        JtfUsuario.setEnabled(false);
        JtfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtfUsuarioActionPerformed(evt);
            }
        });
        CambiarContraseña.add(JtfUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 230, 30));

        LbUsuario1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LbUsuario1.setText("(sin @unal.edu.co)");
        CambiarContraseña.add(LbUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 120, -1));

        jPasswordField2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPasswordField2.setText("Contraseña");
        jPasswordField2.setPreferredSize(new java.awt.Dimension(15, 20));
        CambiarContraseña.add(jPasswordField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, 230, 30));

        LbContraseña1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LbContraseña1.setText("Confirmar nueva contraseña");
        CambiarContraseña.add(LbContraseña1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 160, 30));

        jPasswordField3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPasswordField3.setText("Contraseña");
        jPasswordField3.setPreferredSize(new java.awt.Dimension(15, 20));
        CambiarContraseña.add(jPasswordField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 230, 30));

        LbUsuario2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LbUsuario2.setText("Usuario institucional ");
        CambiarContraseña.add(LbUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 120, -1));

        LbContraseña2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LbContraseña2.setText("Nueva contraseña ");
        CambiarContraseña.add(LbContraseña2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 110, 30));

        jButton11.setBackground(new java.awt.Color(0, 255, 240));
        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton11.setText("Guardar");
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton11MouseExited(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        CambiarContraseña.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 84, 30));

        Fondo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo_blanco1 1 .jpg"))); // NOI18N
        CambiarContraseña.add(Fondo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 880, -1));

        Configuraciones.add(CambiarContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 54, 806, 446));

        notificaciones.setBackground(new java.awt.Color(204, 204, 204));
        notificaciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        notificaciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        controlPanelTitle2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        controlPanelTitle2.setForeground(new java.awt.Color(177, 178, 176));
        controlPanelTitle2.setText("Configurar notificaciones y código");
        notificaciones.add(controlPanelTitle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        JtfUsuario1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JtfUsuario1.setText("Usuario institucional");
        JtfUsuario1.setEnabled(false);
        JtfUsuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtfUsuario1ActionPerformed(evt);
            }
        });
        notificaciones.add(JtfUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 200, 30));

        LbContraseña3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LbContraseña3.setText("Contraseña");
        notificaciones.add(LbContraseña3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 62, -1));

        jPasswordField4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPasswordField4.setText("Contraseña");
        jPasswordField4.setPreferredSize(new java.awt.Dimension(15, 20));
        notificaciones.add(jPasswordField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 200, 30));

        LbUsuario3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LbUsuario3.setText("Usuario institucional (sin @unal.edu.co)");
        notificaciones.add(LbUsuario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 230, -1));

        JtfUsuario2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JtfUsuario2.setText("Correo");
        JtfUsuario2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtfUsuario2ActionPerformed(evt);
            }
        });
        notificaciones.add(JtfUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 230, 30));

        LbContraseña4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LbContraseña4.setText("Contraseña");
        notificaciones.add(LbContraseña4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 62, -1));

        jPasswordField5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPasswordField5.setText("Contraseña");
        jPasswordField5.setPreferredSize(new java.awt.Dimension(15, 20));
        notificaciones.add(jPasswordField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 230, 30));

        LbUsuario4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LbUsuario4.setText("Correo para notificar");
        notificaciones.add(LbUsuario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 120, -1));

        jPasswordField6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPasswordField6.setText("Contraseña");
        jPasswordField6.setPreferredSize(new java.awt.Dimension(15, 20));
        notificaciones.add(jPasswordField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 230, 30));

        LbContraseña5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LbContraseña5.setText("Confirmar contraseña");
        notificaciones.add(LbContraseña5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 130, -1));

        LbContraseña6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LbContraseña6.setText("NOTA: Para modificar los datos es necesario que ingrese su contraseña.");
        notificaciones.add(LbContraseña6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, 400, 50));

        jPasswordField7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPasswordField7.setText("Contraseña");
        jPasswordField7.setPreferredSize(new java.awt.Dimension(15, 20));
        notificaciones.add(jPasswordField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 210, 30));

        jButton12.setBackground(new java.awt.Color(0, 255, 240));
        jButton12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton12.setText("Cambiar código");
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton12MouseExited(evt);
            }
        });
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        notificaciones.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 270, 120, 30));

        jButton13.setBackground(new java.awt.Color(0, 255, 240));
        jButton13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton13.setText("Guardar");
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton13MouseExited(evt);
            }
        });
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        notificaciones.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 84, 30));

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/seguro.png"))); // NOI18N
        notificaciones.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, 70, 80));

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario_1.png"))); // NOI18N
        jLabel49.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel49MousePressed(evt);
            }
        });
        notificaciones.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, -1));

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/aplicacion-de-bandeja-de-entrada-de-correo (1).png"))); // NOI18N
        notificaciones.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 70, 80));

        LbContraseña7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LbContraseña7.setText("Código nuevo");
        notificaciones.add(LbContraseña7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 90, -1));

        dudaCorreo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/signo-de-pregunta-en-circulos.png"))); // NOI18N
        dudaCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dudaCorreoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dudaCorreoMouseExited(evt);
            }
        });
        notificaciones.add(dudaCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, -1, -1));

        masInfoCodigo.setText("<html><center> Este código permite crear usuarios con rol coordinador.");
        notificaciones.add(masInfoCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 165, 200, -1));

        dudaCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/signo-de-pregunta-en-circulos.png"))); // NOI18N
        dudaCodigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dudaCodigoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dudaCodigoMouseExited(evt);
            }
        });
        notificaciones.add(dudaCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 200, -1, -1));

        masInfoCorreo.setText("<html><center> Este correo permite notificar a otros usuarios <p> sobre su solicitud o recordar la <p>contraseña");
        notificaciones.add(masInfoCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 250, -1));

        Fondo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo_blanco1 1 .jpg"))); // NOI18N
        notificaciones.add(Fondo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 880, -1));

        Configuraciones.add(notificaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 54, 806, 446));

        getContentPane().add(Configuraciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 854, 520));

        Administrar_Solicitudes.setBackground(new java.awt.Color(204, 204, 204));
        Administrar_Solicitudes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Administrar_Solicitudes.setMinimumSize(new java.awt.Dimension(854, 520));
        Administrar_Solicitudes.setPreferredSize(new java.awt.Dimension(854, 520));
        Administrar_Solicitudes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setBackground(new java.awt.Color(177, 178, 176));
        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 102, 255));
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
        jLabel31.setForeground(new java.awt.Color(0, 102, 255));
        jLabel31.setText("Aceptar, cancelar o rechazar solicitud");
        Administrar_Solicitudes.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel32.setText("Buscar: ");
        Administrar_Solicitudes.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        Aceptar_sol_boton.setBackground(new java.awt.Color(0, 255, 240));
        Aceptar_sol_boton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Aceptar_sol_boton.setText("Aceptar");
        Aceptar_sol_boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Aceptar_sol_botonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Aceptar_sol_botonMouseExited(evt);
            }
        });
        Aceptar_sol_boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Aceptar_sol_botonActionPerformed(evt);
            }
        });
        Administrar_Solicitudes.add(Aceptar_sol_boton, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 340, 84, 30));

        Rechazar_sol_boton.setBackground(new java.awt.Color(0, 255, 240));
        Rechazar_sol_boton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Rechazar_sol_boton.setText("Rechazar");
        Rechazar_sol_boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Rechazar_sol_botonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Rechazar_sol_botonMouseExited(evt);
            }
        });
        Rechazar_sol_boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rechazar_sol_botonActionPerformed(evt);
            }
        });
        Administrar_Solicitudes.add(Rechazar_sol_boton, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 390, 84, 30));

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

        jButton10.setBackground(new java.awt.Color(0, 255, 240));
        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton10.setText("Cancelar");
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton10MouseExited(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        Administrar_Solicitudes.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 440, 84, 30));

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

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel38.setText("Observaciones:");
        Administrar_Solicitudes.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));

        dudaadmSolicitud1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/signo-de-pregunta-en-circulos.png"))); // NOI18N
        dudaadmSolicitud1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dudaadmSolicitud1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dudaadmSolicitud1MouseExited(evt);
            }
        });
        Administrar_Solicitudes.add(dudaadmSolicitud1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 350, -1, -1));

        dudaadmSolicitud2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/signo-de-pregunta-en-circulos.png"))); // NOI18N
        dudaadmSolicitud2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dudaadmSolicitud2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dudaadmSolicitud2MouseExited(evt);
            }
        });
        Administrar_Solicitudes.add(dudaadmSolicitud2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 400, -1, -1));

        dudaadmSolicitud3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/signo-de-pregunta-en-circulos.png"))); // NOI18N
        dudaadmSolicitud3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dudaadmSolicitud3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dudaadmSolicitud3MouseExited(evt);
            }
        });
        Administrar_Solicitudes.add(dudaadmSolicitud3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 450, -1, -1));

        masInfoAceptar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        masInfoAceptar.setText("Solo puede aceptar solicitudes en espera.");
        Administrar_Solicitudes.add(masInfoAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 320, 220, 20));

        masInfoCancelar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        masInfoCancelar.setText("Solo puede cancelar solicitudes propias en espera o aceptadas.");
        Administrar_Solicitudes.add(masInfoCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 420, 340, 20));

        masInfoRechazar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        masInfoRechazar.setText("Solo puede rechazar solicitudes en espera.");
        Administrar_Solicitudes.add(masInfoRechazar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 370, 230, 20));

        jTextField2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        Administrar_Solicitudes.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 580, 120));

        Fondo6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo_blanco1 1 .jpg"))); // NOI18N
        Administrar_Solicitudes.add(Fondo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 880, -1));

        getContentPane().add(Administrar_Solicitudes, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        Estadisticas.setBackground(new java.awt.Color(204, 204, 204));
        Estadisticas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Estadisticas.setMinimumSize(new java.awt.Dimension(854, 520));
        Estadisticas.setName(""); // NOI18N
        Estadisticas.setPreferredSize(new java.awt.Dimension(854, 520));
        Estadisticas.setRequestFocusEnabled(false);
        Estadisticas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        masInfoEstadisticas.setBackground(new java.awt.Color(255, 255, 255));
        masInfoEstadisticas.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        masInfoEstadisticas.setText("<html><Center> Las graficas solo tienen encuenta<p> las solicitudes aceptadas. Los espacio<p>que no salen en las graficas es porque<p> no tienen solicitudes aceptadas.");
        masInfoEstadisticas.setOpaque(true);
        Estadisticas.add(masInfoEstadisticas, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 150, 130));

        jLabel33.setBackground(new java.awt.Color(177, 178, 176));
        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 102, 255));
        jLabel33.setText("Estadísticas");
        Estadisticas.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 200, 60));
        Estadisticas.add(jYearChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 100, 110, 30));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setText("POR TIPO DE ESPACIO");
        Estadisticas.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 130, 20));

        jButton7.setBackground(new java.awt.Color(0, 255, 240));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton7.setText("Mostrar");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton7MouseExited(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        Estadisticas.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 480, 80, 30));

        Estadisticas_por_tipo.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jRadioButton2.setText("Auditorio");
        Estadisticas.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, 110, 20));

        Estadisticas_por_tipo.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jRadioButton3.setText("Sala de Reuniones");
        Estadisticas.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, 160, 20));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setText("Seleccióne un mes y año:");
        Estadisticas.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 150, 20));

        Estadisticas_por_tipo.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Laboratorio");
        Estadisticas.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 110, 20));

        Estadisticas_por_tipo.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jRadioButton4.setText("Sala de Computadores");
        Estadisticas.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, 160, 20));
        Estadisticas.add(jMonthChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, -1, 30));

        jButton8.setBackground(new java.awt.Color(0, 255, 240));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton8.setText("Mostrar");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton8MouseExited(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        Estadisticas.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 480, 80, 30));
        Estadisticas.add(jMonthChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 120, 30));
        Estadisticas.add(jYearChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 80, 30));

        jPanel1.setEnabled(false);
        jPanel1.setFocusable(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Estadisticas.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 370, 330));

        jPanel3.setEnabled(false);
        jPanel3.setFocusable(false);
        jPanel3.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Estadisticas.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 370, 330));

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 0, 0));
        jLabel51.setText("POR ESPACIOS");
        Estadisticas.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 90, 20));

        jLabel54.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(0, 0, 0));
        jLabel54.setText("Seleccióne un");
        Estadisticas.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 100, 20));

        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(0, 0, 0));
        jLabel55.setText("Seleccióne un mes y año:");
        Estadisticas.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 150, 30));

        dudaEstadisticas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/signo-de-pregunta-en-circulos.png"))); // NOI18N
        dudaEstadisticas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dudaEstadisticasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dudaEstadisticasMouseExited(evt);
            }
        });
        Estadisticas.add(dudaEstadisticas, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, -1));

        jLabel56.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(0, 0, 0));
        jLabel56.setText("tipo de espacio:");
        Estadisticas.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 110, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/descargar.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });
        Estadisticas.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 485, -1, -1));

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 0, 0));
        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/descargar.png"))); // NOI18N
        jLabel58.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel58MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel58MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel58MouseExited(evt);
            }
        });
        Estadisticas.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 485, -1, 20));

        Fondo7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo_blanco1 1 .jpg"))); // NOI18N
        Estadisticas.add(Fondo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, -1));

        getContentPane().add(Estadisticas, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));
        Estadisticas.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void setNombreRepeticion(String nombreRepeticion) {
        this.nombreRepeticion = nombreRepeticion;
    }
    
    public void setdataConexiones(ManipularConecciones con) {
        this.manipulacionConexiones = con;
        validarEspacios = new ValidarEspacios(con);
        validarSolicitudes = new Validar_administrar_solicitud(con);
        validarInventario = new ValidarInventario(con);
        graficar = new GraficarEstadisticas(con);
    }
    
    public void cargando(){        
        this.hiloCargando=new HiloCargando();
         if (usuario.getTipoUsuario() == 1 || usuario.getTipoUsuario() == 4) {
         hiloCargando.setVariable(this.jLCargandos0);
         }else if(usuario.getTipoUsuario() == 2){
            hiloCargando.setVariable(this.jLCargando);  
         }
          
    }
            
    public void entrar_bienvenida(Usuario usuario2) {
        ocultar_todosPaneles();
        Bienvenida.setVisible(true);
        Paneles_Menu.setVisible(true);
        this.usuario = usuario2;
        this.hiloFrame_Main.setVariable(this);
        if (usuario.getTipoUsuario() == 1 || usuario.getTipoUsuario() == 4) {
            Menu_UC.setVisible(false);
            userLabel2.setText(usuario.getNombreusuarioInstitucional());
            JtfUsuario.setText(usuario.getNombreusuarioInstitucional());
            JtfUsuario1.setText(usuario.getNombreusuarioInstitucional());
            jLabelEliminar1.setVisible(false);
            jLabelAñadir2.setVisible(false);
            dudaadmSolicitud1.setVisible(false);
            dudaadmSolicitud2.setVisible(false);
            hiloCargando.setVariable(this.jLCargandos0);           
            if (usuario.getTipoUsuario() == 4) {
                roleLabel1.setText("Usuario Encargado");
            }else{
                jLabel57.setVisible(false);
                jSeparator19.setVisible(false);
            }
        } else if (usuario.getTipoUsuario() == 2) {
            Menu_UE.setVisible(false);
            jLabelEliminar1.setVisible(true);
            jLabelAñadir2.setVisible(true);
            dudaadmSolicitud1.setVisible(true);
            dudaadmSolicitud2.setVisible(true);
            hiloCargando.setVariable(this.jLCargando);
            userLabel1.setText(usuario.getNombreusuarioInstitucional());
            JtfUsuario.setText(usuario.getNombreusuarioInstitucional());
            JtfUsuario1.setText(usuario.getNombreusuarioInstitucional());
        } else {
            Paneles_Menu.setVisible(false);
        }

    }

    private void ocultar_masInfo() {
        masInfoCorreo.setVisible(false);
        masInfoCodigo.setVisible(false);
        masInfoSolicitud.setVisible(false);
        masInfoSolicitud2.setVisible(false);
        masInfoAceptar.setVisible(false);
        masInfoRechazar.setVisible(false);
        masInfoCancelar.setVisible(false);
        masInfoEstadisticas.setVisible(false);
        masInfoSolicitud3.setVisible(false);
        masInfoSolicitud4.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);

    }

    private void ocultar_todosPaneles() {
        Bienvenida.setVisible(false);
        Solicitar_Espacio.setVisible(false);
        Administrar_Solicitudes.setVisible(false);
        Estadisticas.setVisible(false);
        Configuraciones.setVisible(false);
        ocultar_masInfo();
    }

    private void logOut() { //Cerrar sesion        
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Desea cerrar sesión?", "Cerrar sesión", dialog);
        if (result == 0) {
            Frame_Login frame_Login = new Frame_Login();
            frame_Login.setVisible(true);
            hiloCargando.finalizarhilo();                  
            this.dispose();
        }
    }

    public void llenarMotivos(Usuario us) {
       jComboMotivos.removeAllItems();       
       jComboMotivos.addItem("Seleccion");
       try{
         String[] lista = validarSolicitudes.obtenerListaMotivos(us);

        for (String lista1 : lista) {
            jComboMotivos.addItem(lista1);
        } 
        
       }catch(Exception e){
           
       }
        
        

    }

    public void solicitar_Espacio(String Espacio) throws SQLException {
        try{
        jLabelRepeticion.setText("No se repite");
        fechaTermina = obtener_fecha();
        indiceRepeticion = 4;
        llenarMotivos(usuario);            
        ocultar_todosPaneles();
        Solicitar_Espacio.setVisible(true);           
        jLabel36.setText(Espacio);
        jLabel37.setText("");
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{}, new String[]{" ID", "Nombre espacio", "Salon", "Edificio", "Encargado", "Estado", "Información adicional"})
        );

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{}, new String[]{"Horas ocupadas"})
        );
        llenarTabla(Espacio); 
        if (jTable3.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No se han creado espacios de tipo " + Espacio, "Sin registros", JOptionPane.INFORMATION_MESSAGE);
        }
         }catch (Exception e){
            
        }
        hiloCargando.finalizarhilo();
    }

    private void verTodoSolicitud() {
        try{
          Buscador.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                TRSFiltro.setRowFilter(RowFilter.regexFilter("(?i)" + "Ver más", (categoria_fil("Selección") - 1)));
            }
        });
        TRSFiltro = new TableRowSorter(jTable2.getModel());
        jTable2.setRowSorter(TRSFiltro);   
        }catch(Exception e){
               System.out.println("Exception en verTodoSolicitud e "+e);
        }            
       
    }

    private void administrar_Solicitudes() {
       try{ 
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
           cargando();  
           hiloCargando.Iniciar("llenarTabla_solicitudes1");   
           hiloFrame_Main.Iniciar("llenarTabla_solicitudes", "Todos");            
        } catch (Exception ex) {
            Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Tipo_estados.clearSelection();
        }catch (Exception e){
            
        }
    }

    private void ver_Estadisticas() {
        ocultar_todosPaneles();
        mostrarPorEspacios();
        mostrarPorTipEspacio();
        Estadisticas.setVisible(true);

    }

    private void llenarTabla(String tipo) throws SQLException {
        try{
             Object[][] tabla = validarEspacios.llenarMatriz(tipo, usuario);
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
                tabla, new String[]{" ID", "Nombre espacio", "Salon", "Edificio", "Encargado", "Estado", "Información adicional"})
        );
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(SwingConstants.CENTER);
        jTable3.getColumnModel().getColumn(5).setCellRenderer(render); 
        }catch(Exception e){
               System.out.println("Exception en llenarTabla_solicitudes e "+e);
        }
            
      
    }

    private void llenarTabla_espacios(int id_espacio, String fecha, int day) throws SQLException {//modelo tabla espacios
        try{
            Object[][] tabla = validarEspacios.llenarMatriz_horas(id_espacio, fecha, usuario, day);
            jTable4.setModel(new javax.swing.table.DefaultTableModel(
                tabla, new String[]{"Horas ocupadas"}));  
        }catch (Exception e){
            
        }      
    }

    public void llenarTabla_solicitudes(String tipo_e) throws SQLException {
       try{  
        Administrar_Solicitudes.setEnabled(false);
        Categorias.setSelectedIndex(0);
        Buscador.setText("");
        Object[][] tabla = validarSolicitudes.llenarMatriz(usuario, tipo_e);
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                tabla, new String[]{
                    "ID SOLICITUD", "FECHA SOLICITUD", "ESTADO", "FECHA DE MODIFICACIÓN", "USUARIO INTITUCIONAL", "SALON/EDIFICIO", "FECHA INICIO", "FECHA TERMINA", "OBSERVACIONES", "INFORMACIÓN ADICIONAL"

                }
        ));
        
        verTodoSolicitud();
        Administrar_Solicitudes.setEnabled(true);
        if (jTable2.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No tiene registros de solicitudes", "Sin registros", JOptionPane.INFORMATION_MESSAGE);
        }
         }catch (Exception e){
            System.out.println("Exception en llenarTabla_solicitudes e "+e);
        }
       
        hiloCargando.finalizarhilo();
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

        try {

            Espacio espacio = new Espacio();
            espacio = validarEspacios.BuscarInfoEspacio(usuario, Integer.valueOf(obj.toString()));
            Frame_DetallesEspacio frame_DetallesEspacio = new Frame_DetallesEspacio();
            frame_DetallesEspacio.setDataConexiones(manipulacionConexiones, validarEspacios, validarInventario);
            frame_DetallesEspacio.setVisible(true);
            frame_DetallesEspacio.llenarFrame(usuario, espacio, this);
            this.setEnabled(false);
            frame_DetallesEspacio.setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void verDetalles_solicitudes(Object obj) {
        try {
            String[] datos = validarSolicitudes.datos_solicitud(usuario, Integer.valueOf(obj.toString()));
            String dias = validarSolicitudes.dias_sol(usuario, Integer.valueOf(obj.toString()));
            Frame_DetallesSolicitud frame_DetalleSolicitud = new Frame_DetallesSolicitud();
            frame_DetalleSolicitud.llenar_frame(datos, dias, usuario, this);
            frame_DetalleSolicitud.setVisible(true);
            this.setEnabled(false);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void limpiarTabla() {
        try{
        DefaultTableModel M = (DefaultTableModel) jTable2.getModel();
        M.getDataVector().removeAllElements();
        M.fireTableDataChanged();
         }catch (Exception e){
            
        }
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

    public void cambiarEstado(String tipE) throws AddressException, Exception {
        try{
        if (jTable2.getSelectedRow() != -1 && jTable2.getSelectedColumn() != -1) {
            
            int res = validarSolicitudes.cambiarEstado(usuario, tipE, jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString(), jTextField2.getText(), jTable2.getValueAt(jTable2.getSelectedRow(), 2).toString());
            if (res == 1) {

                JOptionPane.showMessageDialog(null, "Se han guardado los cambios.", "Cambiar estado de la solicitud", JOptionPane.INFORMATION_MESSAGE);

                if (!tipE.equals("Cancelada")) {
                    int dialog = JOptionPane.YES_NO_OPTION;
                    int result = JOptionPane.showConfirmDialog(null, "¿Desea notificar por correo al usuario?", "Exit", dialog);
                    if (result == 0) {
                        boolean c = validarSolicitudes.verificarEnvio("", jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString(), tipE, jTable2.getValueAt(jTable2.getSelectedRow(), 4).toString(), jTextField2.getText());
                        if (c) {
                            JOptionPane.showMessageDialog(null, "Se ha notificado al usuario: " + jTable2.getValueAt(jTable2.getSelectedRow(), 4).toString() + "@unal.edu.co");
                        } else {
                            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar enviar el correo");
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

        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado una solicitud para gestionar", "Accion no valida", JOptionPane.INFORMATION_MESSAGE);
        }
        
        }catch (Exception e){
            System.out.println("Exception en cambiarEstado e "+e);
        }        
        hiloCargando.finalizarhilo();
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
        try{
        int val;

        if (jComboSelectDuracion.getSelectedIndex() == 0) {
            val = 1;
        } else {
            val = 2;
        }

        evento = new Evento(0,
                (Integer) jSpinnerHorainicio.getValue() + ":0" + "0" + ":00",
                nombreRepeticion,
                obtener_fecha(),
                fechaTermina,
                ((Integer) jSpinnerHorainicio.getValue() + val) + ":0" + "0" + ":00",
                jTextMotivoSolicitud.getText(),
                -1,
                indiceRepeticion,
                diasRepeticion,
                jComboMotivos.getSelectedIndex());
        
        solicitud = new Solicitud(0,
                validarSolicitudes.fechaBD(usuario),
                "",
                "2",
                "",
                idEspacioSeleccionado,
                evento);
        
        String validado = validarSolicitudes.verificarDatosSolicitudNueva(usuario,
                solicitud,
                jComboMotivos.getItemAt(jComboMotivos.getSelectedIndex()),
                jTextMotivoSolicitud.getText(),
                fechaTermina,
                obtener_fecha(),
                (Integer) jSpinnerHorainicio.getValue(),
                0,
                (Integer) jSpinnerHorainicio.getValue() + val,
                0,
                (String) jTable3.getValueAt(jTable3.getSelectedRow(), 5));
        
        if (validado.equals("ok")) {
            JOptionPane.showMessageDialog(null, "Solicitud ingresada con exito");
        } else {
            JOptionPane.showMessageDialog(null, validado);
        }
        }catch (Exception e){
            
        }
        hiloCargando.finalizarhilo();
    }

    private void ocultar_todosPanelesconfig() {
        about.setVisible(false);
        CambiarContraseña.setVisible(false);
        notificaciones.setVisible(false);

    }

    private void configurar() {
        ocultar_todosPaneles();
        ocultar_todosPanelesconfig();
        Configuraciones.setVisible(true);
        CambiarContraseña.setVisible(true);
        jPasswordField4.setText("Contraseña");
        jPasswordField1.setText("Contraseña");
        pintartodos();
        opcion2.setOpaque(true);
        if (usuario.getTipoUsuario() != 2) {
            habilitar_notificar(false);

        }
        Menu_confg.repaint();

    }

    private void pintartodos() {
        opcion1.setOpaque(false);
        opcion2.setOpaque(false);
        opcion3.setOpaque(false);
    }

    private void habilitar_notificar(boolean b) {
        jLabel45.setVisible(b);
        jSeparator14.setVisible(b);
        jSeparator15.setVisible(b);
        opcion3.setVisible(b);

    }

    public void guardarCamContrasenia() {
        try {
           
            usuario.setContrasenia(jPasswordField1.getText());
           
            Validar_Registro validar_Registro = new Validar_Registro(manipulacionConexiones);
            int val = validar_Registro.cambiarcontrasenia(usuario, jPasswordField3.getText(), jPasswordField2.getText());
            if (val == 1) {
                JOptionPane.showMessageDialog(null, "Se ha cambiado la contraseña satisfactoriamente", "Guardado", JOptionPane.INFORMATION_MESSAGE);
            } else if (val == 0) {
                JOptionPane.showMessageDialog(null, "Contraseña actual incorrecta", "Acción no valida", JOptionPane.INFORMATION_MESSAGE);
            } else if (val == -1) {
                JOptionPane.showMessageDialog(null, "Usuario no Valido", "Acción no valida", JOptionPane.INFORMATION_MESSAGE);
            } else if (val == -2) {
                JOptionPane.showMessageDialog(null, "Contraseña actual o nueva no Valida", "Acción no valida", JOptionPane.INFORMATION_MESSAGE);
            } else if (val == -3) {
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden para la nueva contraseña", "Acción no valida", JOptionPane.INFORMATION_MESSAGE);
            } else if (val == -4) {
                JOptionPane.showMessageDialog(null, "La nueva contraseña no es segura.Debe tener minimo 8 caracteres con minimo una letra en mayucula, minucula y un numero", "Acción no valida", JOptionPane.INFORMATION_MESSAGE);
            } else if (val == -5) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar conectar con la base de datos", "Error", JOptionPane.INFORMATION_MESSAGE);
            } else if (val == -6) {
                JOptionPane.showMessageDialog(null, "La nueva contraseña coincide con la contraseña actual", "Acción no valida", JOptionPane.INFORMATION_MESSAGE);
            }
            usuario.setContrasenia("1234567890");
         
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "A ocurrido un error: " + e);
        }
           
            hiloCargando.finalizarhilo();
           
    }

    public void camCodig() {

        try {
            usuario.setContrasenia(jPasswordField4.getText());
            Validar_Registro validar_Registro = new Validar_Registro(manipulacionConexiones);
            int val = validar_Registro.cambiarCod(usuario, jPasswordField7.getText());
            if (val == 1) {
                JOptionPane.showMessageDialog(null, "Se ha cambiado el código satisfactoriamente", "Guardado", JOptionPane.INFORMATION_MESSAGE);
                usuario.setContrasenia("1234567890");
            } else if (val == 0) {
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Acción no valida", JOptionPane.INFORMATION_MESSAGE);
            } else if (val == -1) {
                JOptionPane.showMessageDialog(null, "Usuario no Valido", "Acción no valida", JOptionPane.INFORMATION_MESSAGE);
            } else if (val == -2) {
                JOptionPane.showMessageDialog(null, "Contraseña no Valida", "Acción no valida", JOptionPane.INFORMATION_MESSAGE);
            } else if (val == -3) {
                JOptionPane.showMessageDialog(null, "Código no valido. Debe tener minimo 8 caracteres con minimo una letra en mayucula, minucula y un numero", "Acción no valida", JOptionPane.INFORMATION_MESSAGE);
            } else if (val == -4) {
                JOptionPane.showMessageDialog(null, "El código no es seguro.", "Acción no valida", JOptionPane.INFORMATION_MESSAGE);
            } else if (val == -5) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar conectar con la base de datos", "Error", JOptionPane.INFORMATION_MESSAGE);
            } else if (val == -6) {
                JOptionPane.showMessageDialog(null, "No tiene permisos para ejecutar esta acción", "Acción no valida", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "A ocurrido un error: " + e);
        }
        hiloCargando.finalizarhilo();
    }

    public void camCorreoNotificar() {
        try {
            usuario.setContrasenia(jPasswordField4.getText());
            Validar_Registro validar_Registro = new Validar_Registro(manipulacionConexiones);
            int val = validar_Registro.camCorreoNot(usuario, JtfUsuario2.getText(), jPasswordField5.getText(), jPasswordField6.getText());
            if (val == 1) {
                JOptionPane.showMessageDialog(null, "Se ha cambiado los datos satisfactoriamente", "Guardado", JOptionPane.INFORMATION_MESSAGE);
                usuario.setContrasenia("1234567890");
            } else if (val == 0) {
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Acción no valida", JOptionPane.INFORMATION_MESSAGE);
            } else if (val == -1) {
                JOptionPane.showMessageDialog(null, "Usuario no Valido", "Acción no valida", JOptionPane.INFORMATION_MESSAGE);
            } else if (val == -2) {
                JOptionPane.showMessageDialog(null, "Contraseña no Valida", "Acción no valida", JOptionPane.INFORMATION_MESSAGE);
            } else if (val == -3) {
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Acción no valida", JOptionPane.INFORMATION_MESSAGE);
            } else if (val == -4) {
                JOptionPane.showMessageDialog(null, "Correo y/o contraseña no valida", "Acción no valida", JOptionPane.INFORMATION_MESSAGE);
            } else if (val == -5) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar conectar con la base de datos", "Error", JOptionPane.INFORMATION_MESSAGE);
            } else if (val == -6) {
                JOptionPane.showMessageDialog(null, "No tiene permisos para ejecutar esta acción", "Acción no valida", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "A ocurrido un error: " + e);
        }
         hiloCargando.finalizarhilo();        
    }

    public int tipoEspacio_estadistica(){
        if(jRadioButton4.isSelected()){
            return 3;
        }
        if(jRadioButton1.isSelected()){
            return 1;
        }
        if(jRadioButton2.isSelected()){
            return 4;
        }
        if(jRadioButton3.isSelected()){
            return 2;
        }
    return 0;
    }

    public void mostrarPorTipEspacio(){
        jPanel3.removeAll();
        jPanel3.setLayout(new java.awt.BorderLayout());
        JFreeChart chart = null;
        try {
            chart=graficar.graficarGeneral(usuario,jMonthChooser2.getMonth()+1, jYearChooser2.getYear());
        } catch (IOException ex) {
            Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        ChartPanel cpa=new ChartPanel(chart);
        jPanel3.add(cpa,BorderLayout.CENTER);
        jPanel3.validate();
         hiloCargando.finalizarhilo();
    }
    
     public void mostrarPorEspacios(){
        jPanel1.removeAll();
        jPanel1.setLayout(new java.awt.BorderLayout());
        JFreeChart chart = null;
        try {
            chart=graficar.graficarEspecifico(usuario, tipoEspacio_estadistica(), jMonthChooser1.getMonth()+1, jYearChooser1.getYear());
        } catch (IOException ex) {
            Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        ChartPanel cp=new ChartPanel(chart);        
        jPanel1.add(cp,BorderLayout.CENTER);
        jPanel1.validate();
        hiloCargando.finalizarhilo();
    }
     

         
    public String GuardarArchivo(File archivo,JFreeChart chart){
        String mensaje=null;
        try{
            int ancho=800; 
            int alto=600;            
            if(archivo.getName().endsWith("jpg")||archivo.getName().endsWith("png")){
                File F= new File(archivo.getAbsolutePath()); 
                ChartUtilities.saveChartAsPNG(F, chart ,ancho,alto);   
            }else{
                File F= new File(archivo.getAbsolutePath()+".png"); 
                ChartUtilities.saveChartAsPNG(F, chart ,ancho,alto);               
            }
            mensaje="Archivo Guardado";
        }catch(Exception e){            
        }
        return mensaje;
    }

    private void jlLabMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlLabMousePressed
        cargando();
        hiloCargando.Iniciar("Laboratorios");   
        hiloFrame_Main.Iniciar("solicitar_Espacio", "Laboratorios");       
    }//GEN-LAST:event_jlLabMousePressed

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
        cargando();
        hiloCargando.Iniciar("Laboratorios2");   
        hiloFrame_Main.Iniciar("solicitar_Espacio", "Laboratorios");    
    }//GEN-LAST:event_jLabel19MousePressed

    private void jLabel20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MousePressed
        cargando();
        hiloCargando.Iniciar("Sala de reuniones2");   
        hiloFrame_Main.Iniciar("solicitar_Espacio", "Sala de reuniones");    
    }//GEN-LAST:event_jLabel20MousePressed

    private void jLabel21MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MousePressed
        cargando();
        hiloCargando.Iniciar("Sala de computadores2");   
        hiloFrame_Main.Iniciar("solicitar_Espacio", "Sala de computadores");   
     
    }//GEN-LAST:event_jLabel21MousePressed

    private void jLabel22MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MousePressed
        cargando();
        hiloCargando.Iniciar("Auditorios2");   
        hiloFrame_Main.Iniciar("solicitar_Espacio", "Auditorios"); 
    }//GEN-LAST:event_jLabel22MousePressed

    private void jlSalaRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSalaRMousePressed
        cargando();
        hiloCargando.Iniciar("Sala de reuniones");   
        hiloFrame_Main.Iniciar("solicitar_Espacio", "Sala de reuniones");        
    }//GEN-LAST:event_jlSalaRMousePressed

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        cargando();
        hiloCargando.Iniciar("Sala de computadores");   
        hiloFrame_Main.Iniciar("solicitar_Espacio", "Sala de computadores"); 
        
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        cargando();
        hiloCargando.Iniciar("Auditorios");   
        hiloFrame_Main.Iniciar("solicitar_Espacio", "Auditorios"); 
        
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
        cargando();
            hiloCargando.Iniciar("Aceptada1");   
            hiloFrame_Main.Iniciar("cambiarEstado", "Aceptada");
       
    }//GEN-LAST:event_Aceptar_sol_botonActionPerformed

    private void BuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscadorActionPerformed

    private void jlAdmMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAdmMousePressed
        administrar_Solicitudes();
    }//GEN-LAST:event_jlAdmMousePressed

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
                jLCargando.setVisible(false);
                jLCargandos0.setVisible(false);
                verDetalles(jTable3.getValueAt(jTable3.getSelectedRow(), 0));
            }
            String edificio = (jTable3.getValueAt(jTable3.getSelectedRow(), 3)).toString();
            String Salon = (jTable3.getValueAt(jTable3.getSelectedRow(), 2)).toString();
            jLabel37.setText(Salon + " - " + edificio + "  ");

            String fecha = obtener_fecha();
            int day = obt_diaSemana();

            try {
                llenarTabla_espacios(Integer.valueOf(jTable3.getValueAt(jTable3.getSelectedRow(), 0).toString()), fecha, day);
            } catch (SQLException ex) {
                Logger.getLogger(Frame_Main.class
                        .getName()).log(Level.SEVERE, null, ex);
            }

        }


    }//GEN-LAST:event_jTable3MouseClicked

    private void jCalendar2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendar2PropertyChange
        // TODO add your handling code here:
    try{
        fechaTermina = obtener_fecha();
        indiceRepeticion = 4;
        jLabelRepeticion.setText("No se repite");
        int[] d = {0, 0, 0, 0, 0, 0, 0};
        d[obt_diaSemana() - 1] = obt_diaSemana();
        diasRepeticion = d;

        if (jTable3.getSelectedRow() != -1 && jTable3.getSelectedColumn() != -1) {

            int id_espacio = Integer.valueOf(jTable3.getValueAt(jTable3.getSelectedRow(), 0).toString());

            String fecha = obtener_fecha();

            int day = obt_diaSemana();            
            try {
                llenarTabla_espacios(id_espacio, fecha, day);
            } catch (SQLException ex) {
                Logger.getLogger(Frame_Main.class
                        .getName()).log(Level.SEVERE, null, ex);
            }

        }
        }catch (Exception e){
            
        }
    }//GEN-LAST:event_jCalendar2PropertyChange

    private void CategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoriasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CategoriasActionPerformed

    private void Jcbox_rechazadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jcbox_rechazadaActionPerformed
        try {
            if (tipo_rechazada) {                
                cargando();  
                hiloCargando.Iniciar("llenarTabla_solicitudes2");   
                hiloFrame_Main.Iniciar("llenarTabla_solicitudes", "Todos");
                tipo_rechazada = false;
                Tipo_estados.clearSelection();
            } else {
                tipo_rechazada = true;
                 cargando();  
                hiloCargando.Iniciar("llenarTabla_solicitudes3");   
                hiloFrame_Main.Iniciar("llenarTabla_solicitudes", "Rechazada");                
            }

        } catch (Exception ex) {
            Logger.getLogger(Frame_Main.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Jcbox_rechazadaActionPerformed

    private void Jcbox_esperaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jcbox_esperaActionPerformed
        try {
            if (tipo_espera) {
                cargando();  
                hiloCargando.Iniciar("llenarTabla_solicitudes8");   
                hiloFrame_Main.Iniciar("llenarTabla_solicitudes", "Todos");                
                tipo_espera = false;
                Tipo_estados.clearSelection();
            } else {
                tipo_espera = true;
                cargando();  
                hiloCargando.Iniciar("llenarTabla_solicitudes9");   
                hiloFrame_Main.Iniciar("llenarTabla_solicitudes", "Espera");                
            }
        } catch (Exception ex) {
            Logger.getLogger(Frame_Main.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Jcbox_esperaActionPerformed

    private void Jcbox_canceladaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jcbox_canceladaActionPerformed
        try {
            if (tipo_cancelada) {
                cargando();  
                hiloCargando.Iniciar("llenarTabla_solicitudes4");   
                hiloFrame_Main.Iniciar("llenarTabla_solicitudes", "Todos");                
                tipo_cancelada = false;
                Tipo_estados.clearSelection();
            } else {
                tipo_cancelada = true;
                cargando();  
                hiloCargando.Iniciar("llenarTabla_solicitudes5");   
                hiloFrame_Main.Iniciar("llenarTabla_solicitudes", "Cancelada");                
            }
        } catch (Exception ex) {
            Logger.getLogger(Frame_Main.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Jcbox_canceladaActionPerformed

    private void Jcbox_aceptadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jcbox_aceptadaActionPerformed
        try {
            if (tipo_aceptada) {
                cargando();  
                hiloCargando.Iniciar("llenarTabla_solicitudes6");   
                hiloFrame_Main.Iniciar("llenarTabla_solicitudes", "Todos");  
                tipo_aceptada = false;
                Tipo_estados.clearSelection();
            } else {
                tipo_aceptada = true;
                cargando();  
                hiloCargando.Iniciar("llenarTabla_solicitudes7");   
                hiloFrame_Main.Iniciar("llenarTabla_solicitudes", "Aceptada");                  
            }
        } catch (Exception ex) {
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
        cargando();  
        hiloCargando.Iniciar("Cancelada1");   
        hiloFrame_Main.Iniciar("cambiarEstado", "Cancelada");  
    }//GEN-LAST:event_jButton10ActionPerformed

    private void Rechazar_sol_botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rechazar_sol_botonActionPerformed
           cargando();  
           hiloCargando.Iniciar("Rechazada1");   
           hiloFrame_Main.Iniciar("cambiarEstado", "Rechazada");  
    }//GEN-LAST:event_Rechazar_sol_botonActionPerformed

    private void jButtonPersonalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPersonalizarActionPerformed
        abrirPersonalizacionHoras(this);
    }//GEN-LAST:event_jButtonPersonalizarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      try{ 
        if (jTable3.getSelectedRow() != -1 && jTable3.getSelectedColumn() != -1) {
            idEspacioSeleccionado = (jTable3.getValueAt(jTable3.getSelectedRow(), 0)).toString();
            String[] fechaVec0 = fechaTermina.split("-");

            TimeZone timezone = TimeZone.getDefault();
            Calendar calendarfinal = new GregorianCalendar(timezone);
            calendarfinal.set(Integer.valueOf(fechaVec0[0]), Integer.valueOf(fechaVec0[1]) - 1, Integer.valueOf(fechaVec0[2]));
            int dia_terminaSemana = calendarfinal.get(Calendar.DAY_OF_WEEK);

            if (obt_diaSemana() != 1 && dia_terminaSemana != 1) {
                cargando();
                hiloCargando.Iniciar("Solicitar");   
                hiloFrame_Main.Iniciar("verificarIngresoSolicitud", "");      
            } else {
                JOptionPane.showMessageDialog(null, "La fecha de inicio o fecha de final no pueden ser un Domingo", "Acción no valida", JOptionPane.INFORMATION_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún espacio", "Acción no valida", JOptionPane.INFORMATION_MESSAGE);

        }
       }catch (Exception e){
            
        }  
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboMotivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboMotivosActionPerformed
        if (!"Seleccion".equals(jComboMotivos.getItemAt(jComboMotivos.getSelectedIndex()))) {
            jTextMotivoSolicitud.setEnabled(true);
        } else {
            jTextMotivoSolicitud.setEnabled(false);
        }
    }//GEN-LAST:event_jComboMotivosActionPerformed

    private void jLabelAñadir2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAñadir2MouseClicked
        try{
        Frame_DetallesEspacio frame_DetallesEspacio = new Frame_DetallesEspacio();
        frame_DetallesEspacio.setDataConexiones(manipulacionConexiones, validarEspacios, validarInventario);

        try {
            Tipo = jLabel36.getText();
            frame_DetallesEspacio.setVisible(true);
            frame_DetallesEspacio.crearEspacio(Tipo, this, usuario);
            this.setEnabled(false);
            frame_DetallesEspacio.setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
        }
        
        }catch (Exception e){
            
        }
        
    }//GEN-LAST:event_jLabelAñadir2MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        if (jTable2.getSelectedRow() != -1 && jTable2.getSelectedColumn() != -1) {
            if (jTable2.getSelectedColumn() == 9) {
                verDetalles_solicitudes(jTable2.getValueAt(jTable2.getSelectedRow(), 0));
            }
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jLabelEliminar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEliminar1MouseClicked

        if (jTable3.getSelectedRow() != -1 && jTable3.getSelectedColumn() != -1) {
            String edificio = (jTable3.getValueAt(jTable3.getSelectedRow(), 3)).toString();
            String Salon = (jTable3.getValueAt(jTable3.getSelectedRow(), 2)).toString();
            int dialog = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar el espacio: " + Salon + " - " + edificio + "?", "Exit", dialog);
            if (result == 0) {

                idEspacioSeleccionado = (jTable3.getValueAt(jTable3.getSelectedRow(), 0)).toString();
                int n = validarEspacios.borrarEspacio(usuario, idEspacioSeleccionado);

                if (n == 1) {
                    try {
                        solicitar_Espacio(jLabel36.getText());
                    } catch (SQLException ex) {
                        Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(null, "El espacio fue borrado.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else if (n == -1) {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al conectar con la base de datos.", "Error", JOptionPane.INFORMATION_MESSAGE);
                } else if (n == -2) {
                    JOptionPane.showMessageDialog(null, "No es posible eliminar el espacio ya que tiene solicitudes en espera.", "Acción no valida", JOptionPane.INFORMATION_MESSAGE);
                } else if (n == -3) {
                    JOptionPane.showMessageDialog(null, "No tiene permisos para ejecutar esta acción", "Acción no valida", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado un espacio para borrar.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jLabelEliminar1MouseClicked

    private void jLabel47MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel47MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel47MousePressed

    private void JtfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtfUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtfUsuarioActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        cargando();
        hiloCargando.Iniciar("Cargando");   
        hiloFrame_Main.Iniciar("guardarCamContrasenia", ""); 
    }//GEN-LAST:event_jButton11ActionPerformed

    private void JtfUsuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtfUsuario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtfUsuario1ActionPerformed

    private void JtfUsuario2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtfUsuario2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtfUsuario2ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        cargando();  
        hiloCargando.Iniciar("camCodig");   
        hiloFrame_Main.Iniciar("camCodig", "");
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        cargando();  
        hiloCargando.Iniciar("camCorreoNotificar");   
        hiloFrame_Main.Iniciar("camCorreoNotificar", "");        
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jLabel49MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel49MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel49MousePressed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        configurar();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel43MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel43MouseClicked
        configurar();
    }//GEN-LAST:event_jLabel43MouseClicked

    private void jLabel46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseClicked
        ocultar_todosPanelesconfig();
        pintartodos();
        opcion1.setOpaque(true);
        Menu_confg.repaint();
        about.setVisible(true);
    }//GEN-LAST:event_jLabel46MouseClicked

    private void jLabel44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MouseClicked
        ocultar_todosPanelesconfig();
        pintartodos();
        opcion2.setOpaque(true);
        Menu_confg.repaint();
        CambiarContraseña.setVisible(true);
    }//GEN-LAST:event_jLabel44MouseClicked

    private void jLabel45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseClicked
        ocultar_todosPanelesconfig();
        pintartodos();
        opcion3.setOpaque(true);
        Menu_confg.repaint();
        notificaciones.setVisible(true);
    }//GEN-LAST:event_jLabel45MouseClicked

    private void jButton11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseEntered

        jButton11.setBackground(new Color(69, 162, 156));
    }//GEN-LAST:event_jButton11MouseEntered

    private void jButton11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseExited
        jButton11.setBackground(new Color(0, 255, 240));
    }//GEN-LAST:event_jButton11MouseExited

    private void dudaCorreoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dudaCorreoMouseEntered
        masInfoCorreo.setVisible(true);
        dudaCorreo.setOpaque(true);
    }//GEN-LAST:event_dudaCorreoMouseEntered

    private void dudaCorreoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dudaCorreoMouseExited
        masInfoCorreo.setVisible(false);
        dudaCorreo.setOpaque(false);
    }//GEN-LAST:event_dudaCorreoMouseExited

    private void dudaCodigoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dudaCodigoMouseEntered
        masInfoCodigo.setVisible(true);
        dudaCodigo.setOpaque(true);
    }//GEN-LAST:event_dudaCodigoMouseEntered

    private void dudaCodigoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dudaCodigoMouseExited
        masInfoCodigo.setVisible(false);
        dudaCodigo.setOpaque(false);


    }//GEN-LAST:event_dudaCodigoMouseExited

    private void jButton13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseEntered
        jButton13.setBackground(new Color(69, 162, 156));
    }//GEN-LAST:event_jButton13MouseEntered

    private void jButton13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseExited
        jButton13.setBackground(new Color(0, 255, 240));
    }//GEN-LAST:event_jButton13MouseExited

    private void jButton12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseEntered
        jButton12.setBackground(new Color(69, 162, 156));
    }//GEN-LAST:event_jButton12MouseEntered

    private void jButton12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseExited
        jButton12.setBackground(new Color(0, 255, 240));
    }//GEN-LAST:event_jButton12MouseExited

    private void jlLabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlLabMouseEntered
        jlLab.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_jlLabMouseEntered

    private void jlLabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlLabMouseExited
        jlLab.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_jlLabMouseExited

    private void jlAdmMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAdmMouseEntered

        jlAdm.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_jlAdmMouseEntered

    private void jlAdmMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAdmMouseExited
        jlAdm.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_jlAdmMouseExited

    private void jlSalaRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSalaRMouseEntered
        jlSalaR.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_jlSalaRMouseEntered

    private void jlSalaRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSalaRMouseExited
        jlSalaR.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_jlSalaRMouseExited

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        jLabel4.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        jLabel4.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        jLabel5.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        jLabel5.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        jLabel8.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        jLabel8.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        jLabel7.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        jLabel7.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_jLabel7MouseExited

    private void jLabel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseEntered
        jLabel18.setIcon(new ImageIcon("src/Imagenes/usuario (1).png"));
    }//GEN-LAST:event_jLabel18MouseEntered

    private void jLabel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseExited
        jLabel18.setIcon(new ImageIcon("src/Imagenes/usuario.png"));
    }//GEN-LAST:event_jLabel18MouseExited

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
        jLabel11.setIcon(new ImageIcon("src/Imagenes/configuraciones_1.png"));
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
        jLabel11.setIcon(new ImageIcon("src/Imagenes/configuraciones.png"));
    }//GEN-LAST:event_jLabel11MouseExited

    private void jlMinimize1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlMinimize1MouseEntered
        jlMinimize1.setIcon(new ImageIcon("src/Imagenes/menos.png"));
    }//GEN-LAST:event_jlMinimize1MouseEntered

    private void jlMinimize1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlMinimize1MouseExited
        jlMinimize1.setIcon(new ImageIcon("src/Imagenes/linea.png"));
    }//GEN-LAST:event_jlMinimize1MouseExited

    private void jlClose1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlClose1MouseEntered
        jlClose1.setIcon(new ImageIcon("src/Imagenes/cancelar-marca.png"));
    }//GEN-LAST:event_jlClose1MouseEntered

    private void jlClose1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlClose1MouseExited
        jlClose1.setIcon(new ImageIcon("src/Imagenes/incorrecto.png"));
    }//GEN-LAST:event_jlClose1MouseExited

    private void jLabel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseEntered
        jLabel19.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_jLabel19MouseEntered

    private void jLabel19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseExited
        jLabel19.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_jLabel19MouseExited

    private void jLabel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseEntered
        jLabel20.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_jLabel20MouseEntered

    private void jLabel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseExited
        jLabel20.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_jLabel20MouseExited

    private void jLabel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseEntered
        jLabel21.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_jLabel21MouseEntered

    private void jLabel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseExited
        jLabel21.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_jLabel21MouseExited

    private void jLabel22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseEntered
        jLabel22.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_jLabel22MouseEntered

    private void jLabel22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseExited
        jLabel22.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_jLabel22MouseExited

    private void jLabel23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseEntered
        jLabel23.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_jLabel23MouseEntered

    private void jLabel23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseExited
        jLabel23.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_jLabel23MouseExited

    private void jLabel24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseEntered
        jLabel24.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_jLabel24MouseEntered

    private void jLabel24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseExited
        jLabel24.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_jLabel24MouseExited

    private void jLabel43MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel43MouseEntered
        jLabel43.setIcon(new ImageIcon("src/Imagenes/configuraciones_1.png"));
    }//GEN-LAST:event_jLabel43MouseEntered

    private void jLabel43MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel43MouseExited
        jLabel43.setIcon(new ImageIcon("src/Imagenes/configuraciones.png"));
    }//GEN-LAST:event_jLabel43MouseExited

    private void jLabel26MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseEntered
        jLabel26.setIcon(new ImageIcon("src/Imagenes/usuario (1).png"));
    }//GEN-LAST:event_jLabel26MouseEntered

    private void jLabel26MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseExited
        jLabel26.setIcon(new ImageIcon("src/Imagenes/usuario.png"));
    }//GEN-LAST:event_jLabel26MouseExited

    private void dudaSolicitudMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dudaSolicitudMouseEntered
        masInfoSolicitud.setVisible(true);
    }//GEN-LAST:event_dudaSolicitudMouseEntered

    private void dudaSolicitudMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dudaSolicitudMouseExited
        masInfoSolicitud.setVisible(false);
    }//GEN-LAST:event_dudaSolicitudMouseExited

    private void dudaSolicitud2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dudaSolicitud2MouseEntered
        masInfoSolicitud2.setVisible(true);
    }//GEN-LAST:event_dudaSolicitud2MouseEntered

    private void dudaSolicitud2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dudaSolicitud2MouseExited
        masInfoSolicitud2.setVisible(false);
    }//GEN-LAST:event_dudaSolicitud2MouseExited

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        jButton3.setBackground(new Color(69, 162, 156));
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        jButton3.setBackground(new Color(0, 255, 240));
    }//GEN-LAST:event_jButton3MouseExited

    private void jButtonPersonalizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPersonalizarMouseEntered
        jButtonPersonalizar.setBackground(new Color(69, 162, 156));
    }//GEN-LAST:event_jButtonPersonalizarMouseEntered

    private void jButtonPersonalizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPersonalizarMouseExited
        jButtonPersonalizar.setBackground(new Color(0, 255, 240));
    }//GEN-LAST:event_jButtonPersonalizarMouseExited

    private void jLabelAñadir2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAñadir2MouseEntered
        jLabel2.setVisible(true);
    }//GEN-LAST:event_jLabelAñadir2MouseEntered

    private void jLabelAñadir2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAñadir2MouseExited
        jLabel2.setVisible(false);
    }//GEN-LAST:event_jLabelAñadir2MouseExited

    private void jLabelEliminar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEliminar1MouseEntered
        jLabel3.setVisible(true);
    }//GEN-LAST:event_jLabelEliminar1MouseEntered

    private void jLabelEliminar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEliminar1MouseExited
        jLabel3.setVisible(false);
    }//GEN-LAST:event_jLabelEliminar1MouseExited

    private void Aceptar_sol_botonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Aceptar_sol_botonMouseEntered
        Aceptar_sol_boton.setBackground(new Color(69, 162, 156));
    }//GEN-LAST:event_Aceptar_sol_botonMouseEntered

    private void Aceptar_sol_botonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Aceptar_sol_botonMouseExited
        Aceptar_sol_boton.setBackground(new Color(0, 255, 240));
    }//GEN-LAST:event_Aceptar_sol_botonMouseExited

    private void Rechazar_sol_botonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Rechazar_sol_botonMouseEntered
        Rechazar_sol_boton.setBackground(new Color(69, 162, 156));
    }//GEN-LAST:event_Rechazar_sol_botonMouseEntered

    private void Rechazar_sol_botonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Rechazar_sol_botonMouseExited
        Rechazar_sol_boton.setBackground(new Color(0, 255, 240));
    }//GEN-LAST:event_Rechazar_sol_botonMouseExited

    private void jButton10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseEntered
        jButton10.setBackground(new Color(69, 162, 156));
    }//GEN-LAST:event_jButton10MouseEntered

    private void jButton10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseExited
        jButton10.setBackground(new Color(0, 255, 240));
    }//GEN-LAST:event_jButton10MouseExited

    private void dudaadmSolicitud1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dudaadmSolicitud1MouseEntered
        masInfoAceptar.setVisible(true);
    }//GEN-LAST:event_dudaadmSolicitud1MouseEntered

    private void dudaadmSolicitud1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dudaadmSolicitud1MouseExited
        masInfoAceptar.setVisible(false);
    }//GEN-LAST:event_dudaadmSolicitud1MouseExited

    private void dudaadmSolicitud2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dudaadmSolicitud2MouseEntered
        masInfoRechazar.setVisible(true);
    }//GEN-LAST:event_dudaadmSolicitud2MouseEntered

    private void dudaadmSolicitud2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dudaadmSolicitud2MouseExited
        masInfoRechazar.setVisible(false);
    }//GEN-LAST:event_dudaadmSolicitud2MouseExited

    private void dudaadmSolicitud3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dudaadmSolicitud3MouseEntered
        masInfoCancelar.setVisible(true);
    }//GEN-LAST:event_dudaadmSolicitud3MouseEntered

    private void dudaadmSolicitud3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dudaadmSolicitud3MouseExited
        masInfoCancelar.setVisible(false);
    }//GEN-LAST:event_dudaadmSolicitud3MouseExited

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        cargando();
        hiloCargando.Iniciar("mostrarPorTipEspacio1");   
        hiloFrame_Main.Iniciar("mostrarPorTipEspacio", "");
    }//GEN-LAST:event_jButton8ActionPerformed
 
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        cargando();
        hiloCargando.Iniciar("mostrarPorEspacios1");   
        hiloFrame_Main.Iniciar("mostrarPorEspacios", "");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
    }//GEN-LAST:event_formMouseClicked

    private void jButton8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseEntered
        jButton8.setBackground(new Color(69, 162, 156));
    }//GEN-LAST:event_jButton8MouseEntered

    private void jButton8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseExited
     jButton8.setBackground(new Color(0, 255, 240));
    }//GEN-LAST:event_jButton8MouseExited

    private void jButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseEntered
      jButton7.setBackground(new Color(69, 162, 156));
    }//GEN-LAST:event_jButton7MouseEntered

    private void jButton7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseExited
     jButton7.setBackground(new Color(0, 255, 240));
    }//GEN-LAST:event_jButton7MouseExited

    private void dudaEstadisticasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dudaEstadisticasMouseEntered
       masInfoEstadisticas.setVisible(true);
    }//GEN-LAST:event_dudaEstadisticasMouseEntered

    private void dudaEstadisticasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dudaEstadisticasMouseExited
      masInfoEstadisticas.setVisible(false);
    }//GEN-LAST:event_dudaEstadisticasMouseExited

    private void jLabel57MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel57MouseEntered
        jLabel57.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_jLabel57MouseEntered

    private void jLabel57MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel57MouseExited
       jLabel57.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_jLabel57MouseExited

    private void jLabel57MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel57MousePressed
        ver_Estadisticas();          
    }//GEN-LAST:event_jLabel57MousePressed

    private void dudaSolicitud3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dudaSolicitud3MouseEntered
       masInfoSolicitud3.setVisible(true);
    }//GEN-LAST:event_dudaSolicitud3MouseEntered

    private void dudaSolicitud3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dudaSolicitud3MouseExited
        masInfoSolicitud3.setVisible(false);
    }//GEN-LAST:event_dudaSolicitud3MouseExited

    private void dudaSolicitud4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dudaSolicitud4MouseEntered
       masInfoSolicitud4.setVisible(true);
    }//GEN-LAST:event_dudaSolicitud4MouseEntered

    private void dudaSolicitud4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dudaSolicitud4MouseExited
       masInfoSolicitud4.setVisible(false);
    }//GEN-LAST:event_dudaSolicitud4MouseExited

    private void jLabel58MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel58MouseClicked
      if(seleccionar.showDialog(null, "Guardar")== JFileChooser.APPROVE_OPTION){          
          archivo=seleccionar.getSelectedFile();
              String respuesta=null;
              try {
                  respuesta = GuardarArchivo(archivo,graficar.graficarGeneral(usuario,jMonthChooser2.getMonth()+1, jYearChooser2.getYear()));
              } catch (IOException ex) {
                  Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
              }
              if(respuesta!=null){
                  JOptionPane.showMessageDialog(null, respuesta);
              }else{
                  JOptionPane.showMessageDialog(null, "Archivo No Guardado");
              }
      
      }
    }//GEN-LAST:event_jLabel58MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
            if(seleccionar.showDialog(null, "Guardar")== JFileChooser.APPROVE_OPTION){          
          archivo=seleccionar.getSelectedFile();          
              String respuesta=null;
              try {
                  respuesta = GuardarArchivo(archivo,graficar.graficarEspecifico(usuario, tipoEspacio_estadistica(), jMonthChooser1.getMonth()+1, jYearChooser1.getYear()));
              } catch (IOException ex) {
                  Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
              }
              if(respuesta!=null){
                  JOptionPane.showMessageDialog(null, respuesta);
              }else{
                  JOptionPane.showMessageDialog(null, "Archivo No Guardado");
              }
      }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel58MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel58MouseEntered
       jLabel58.setIcon(new ImageIcon("src/Imagenes/descargar (1).png"));
       jLabel58.setForeground(new Color(255, 255, 255));
       
    }//GEN-LAST:event_jLabel58MouseEntered

    private void jLabel58MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel58MouseExited
       jLabel58.setIcon(new ImageIcon("src/Imagenes/descargar.png"));
       jLabel58.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_jLabel58MouseExited

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
         jLabel6.setIcon(new ImageIcon("src/Imagenes/descargar (1).png"));
         jLabel58.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
      jLabel6.setIcon(new ImageIcon("src/Imagenes/descargar.png"));
      jLabel6.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_jLabel6MouseExited

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
    private javax.swing.JPanel CambiarContraseña;
    private javax.swing.JComboBox<String> Categorias;
    private javax.swing.JPanel Configuraciones;
    private javax.swing.JPanel Estadisticas;
    private javax.swing.ButtonGroup Estadisticas_por_tipo;
    private javax.swing.JLabel Fondo1;
    private javax.swing.JLabel Fondo2;
    private javax.swing.JLabel Fondo3;
    private javax.swing.JLabel Fondo4;
    private javax.swing.JLabel Fondo5;
    private javax.swing.JLabel Fondo6;
    private javax.swing.JLabel Fondo7;
    private javax.swing.JCheckBox Jcbox_aceptada;
    private javax.swing.JCheckBox Jcbox_cancelada;
    private javax.swing.JCheckBox Jcbox_espera;
    private javax.swing.JCheckBox Jcbox_rechazada;
    private javax.swing.JTextField JtfUsuario;
    private javax.swing.JTextField JtfUsuario1;
    private javax.swing.JTextField JtfUsuario2;
    private javax.swing.JLabel LbContraseña;
    private javax.swing.JLabel LbContraseña1;
    private javax.swing.JLabel LbContraseña2;
    private javax.swing.JLabel LbContraseña3;
    private javax.swing.JLabel LbContraseña4;
    private javax.swing.JLabel LbContraseña5;
    private javax.swing.JLabel LbContraseña6;
    private javax.swing.JLabel LbContraseña7;
    private javax.swing.JLabel LbUsuario;
    private javax.swing.JLabel LbUsuario1;
    private javax.swing.JLabel LbUsuario2;
    private javax.swing.JLabel LbUsuario3;
    private javax.swing.JLabel LbUsuario4;
    private javax.swing.JPanel MensajeBienvenida;
    public static javax.swing.JPanel Menu_UC;
    private javax.swing.JPanel Menu_UE;
    private javax.swing.JPanel Menu_confg;
    private javax.swing.JPanel Paneles_Menu;
    private javax.swing.JButton Rechazar_sol_boton;
    private javax.swing.JPanel Solicitar_Espacio;
    private javax.swing.ButtonGroup Tipo_estados;
    private javax.swing.JPanel about;
    private javax.swing.JLabel controlPanelTitle;
    private javax.swing.JLabel controlPanelTitle1;
    private javax.swing.JLabel controlPanelTitle2;
    private javax.swing.JLabel controlPanelTitle3;
    private javax.swing.JLabel dudaCodigo;
    private javax.swing.JLabel dudaCorreo;
    private javax.swing.JLabel dudaEstadisticas;
    private javax.swing.JLabel dudaSolicitud;
    private javax.swing.JLabel dudaSolicitud2;
    private javax.swing.JLabel dudaSolicitud3;
    private javax.swing.JLabel dudaSolicitud4;
    private javax.swing.JLabel dudaadmSolicitud1;
    private javax.swing.JLabel dudaadmSolicitud2;
    private javax.swing.JLabel dudaadmSolicitud3;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButtonPersonalizar;
    private com.toedter.calendar.JCalendar jCalendar2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JComboBox<String> jComboMotivos;
    private javax.swing.JComboBox<String> jComboSelectDuracion;
    public static javax.swing.JLabel jLCargando;
    public static javax.swing.JLabel jLCargandos0;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAñadir2;
    private javax.swing.JLabel jLabelEliminar1;
    private javax.swing.JLabel jLabelRepeticion;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private com.toedter.calendar.JMonthChooser jMonthChooser2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    private javax.swing.JPasswordField jPasswordField4;
    private javax.swing.JPasswordField jPasswordField5;
    private javax.swing.JPasswordField jPasswordField6;
    private javax.swing.JPasswordField jPasswordField7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
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
    private javax.swing.JSpinner jSpinnerHorainicio;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextMotivoSolicitud;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private com.toedter.calendar.JYearChooser jYearChooser2;
    private javax.swing.JLabel jlAdm;
    private javax.swing.JLabel jlClose1;
    private javax.swing.JLabel jlLab;
    private javax.swing.JLabel jlMinimize1;
    private javax.swing.JLabel jlSalaR;
    private javax.swing.JLabel masInfoAceptar;
    private javax.swing.JLabel masInfoCancelar;
    private javax.swing.JLabel masInfoCodigo;
    private javax.swing.JLabel masInfoCorreo;
    private javax.swing.JLabel masInfoEstadisticas;
    private javax.swing.JLabel masInfoRechazar;
    private javax.swing.JLabel masInfoSolicitud;
    private javax.swing.JLabel masInfoSolicitud2;
    private javax.swing.JLabel masInfoSolicitud3;
    private javax.swing.JLabel masInfoSolicitud4;
    private javax.swing.JPanel notificaciones;
    private javax.swing.JLabel opcion1;
    private javax.swing.JLabel opcion2;
    private javax.swing.JLabel opcion3;
    private javax.swing.JPanel panelCerrar;
    private javax.swing.JLabel roleLabel;
    private javax.swing.JLabel roleLabel1;
    private javax.swing.JLabel userLabel1;
    private javax.swing.JLabel userLabel2;
    // End of variables declaration//GEN-END:variables

}
