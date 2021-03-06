package GUI;

import java.awt.Color;
import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

public class Frame_PersonalizarRepeticion extends javax.swing.JFrame {

    private int x, y;
    private Frame_Main Frame;
    private String fecha;
    private String fechaInicio;
    private int[] DiasSeRepite = {0, 0, 0, 0, 0, 0, 0};
    private int repeticion;
    private int dia_Semana;

    public Frame_PersonalizarRepeticion() {
        initComponents();
        this.setLocationRelativeTo(null);
        masInfoRepeticion.setVisible(false);
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    private String repeticionDias() {
        String retorno = "";
        javax.swing.JCheckBox[] dias = {null, jCheckBoxLunes, jCheckBoxMartes, jCheckBoxMiercoles, jCheckBoxJueves, jCheckBoxViernes, jCheckBoxSabado};
        int diaSeleccionado = jCalendar1.getCalendar().get(Calendar.DAY_OF_WEEK) - 1;

        if (dia_Semana <= 7 && dia_Semana > 1) {
            dias[dia_Semana - 1].setSelected(true);
        }

        if (diaSeleccionado <= 6 && diaSeleccionado > 0) {
            dias[diaSeleccionado].setSelected(true);
        }

        for (int i = 1; i < 7; i++) {
            if (dias[i].isSelected()) {
                retorno = retorno + ", " + dias[i].getText();
            }
        }

        if ("".equals(retorno)) {
            return "pero no se ha seleccionado ningún dia, por favor, seleccione al menos uno.";
        }

        for (int i = 1; i < 7; i++) {
            if (dias[i].isSelected()) {
                DiasSeRepite[i] = i + 1;
            } else {
                DiasSeRepite[i] = 0;
            }
        }

        return "los dias " + retorno.substring(1);
    }

    public void setDia_Semana(int dia_Semana) {
        this.dia_Semana = dia_Semana;
    }

    private void mostrarPeriodicidad() {
        String text = "";

        int año = jCalendar1.getCalendar().get(Calendar.YEAR);
        int mes = jCalendar1.getCalendar().get(Calendar.MONTH) + 1;
        int dia = jCalendar1.getCalendar().get(Calendar.DAY_OF_MONTH);

        fecha = (año + "-" + mes + "-" + dia);

        if ("Semanalmente".equals(String.valueOf(jComboSelectorDia.getSelectedItem()))) {
            text = "Se repite semanalmente " + repeticionDias() + " desde el dia " + fechaInicio + " hasta el día " + fecha;
        } else if (!"Seleccione uno...".equals(String.valueOf(jComboSelectorDia.getSelectedItem()))) {
            text = "Se repite " + String.valueOf(jComboSelectorDia.getSelectedItem()) + " desde el dia " + fechaInicio
                    + " hasta el día " + fecha;
        }

        jLabelVisualizarRepetición.setText("<html>" + text + "</html>");
    }

    private void habilitarDias() {
        boolean ocultar;

        ocultar = "Semanalmente".equals((String.valueOf(jComboSelectorDia.getSelectedItem())));

        if ("Seleccione uno...".equals(jComboSelectorDia.getItemAt(0)) && jComboSelectorDia.getSelectedIndex() != 0) {

            jComboSelectorDia.removeItemAt(0);
        }

        jCheckBoxLunes.setEnabled(ocultar);
        jCheckBoxMartes.setEnabled(ocultar);
        jCheckBoxMiercoles.setEnabled(ocultar);
        jCheckBoxJueves.setEnabled(ocultar);
        jCheckBoxViernes.setEnabled(ocultar);
        jCheckBoxSabado.setEnabled(ocultar);
    }

    public void setFramePadre(Frame_Main frame) {
        this.Frame = frame;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRepetición = new javax.swing.JPanel();
        masInfoRepeticion = new javax.swing.JLabel();
        dudaSolicitud = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboSelectorDia = new javax.swing.JComboBox<>();
        jCheckBoxLunes = new javax.swing.JCheckBox();
        jCheckBoxMartes = new javax.swing.JCheckBox();
        jCheckBoxMiercoles = new javax.swing.JCheckBox();
        jCheckBoxJueves = new javax.swing.JCheckBox();
        jCheckBoxViernes = new javax.swing.JCheckBox();
        jCheckBoxSabado = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButtonGuardarsa = new javax.swing.JButton();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jLabelVisualizarRepetición = new javax.swing.JLabel();
        Fondo5 = new javax.swing.JLabel();
        panelCerrar = new javax.swing.JPanel();
        jlClose1 = new javax.swing.JLabel();
        jlMinimize1 = new javax.swing.JLabel();
        LbUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(558, 439));
        setUndecorated(true);
        setResizable(false);
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

        panelRepetición.setBackground(new java.awt.Color(204, 204, 204));
        panelRepetición.setMaximumSize(new java.awt.Dimension(560, 410));
        panelRepetición.setMinimumSize(new java.awt.Dimension(560, 410));
        panelRepetición.setPreferredSize(new java.awt.Dimension(560, 410));
        panelRepetición.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        masInfoRepeticion.setBackground(new java.awt.Color(255, 255, 255));
        masInfoRepeticion.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        masInfoRepeticion.setText("<html><Center>*Diario: El evento se repite todos los dias<p>" +
            "que se encuentren dentro de las fechas del <p>" +
            "evento.<p>" +
            "*Semanal: El evento se repite cada semana<p>" +
            "los dias escogidos incluyendo el dia de la<p>" +
            "semana de la fecha inicial y final del evento.<p>" +
            "Nota: En ningun caso, se agenda un evento <p>" +
            "los domingos. ");
        masInfoRepeticion.setOpaque(true);
        panelRepetición.add(masInfoRepeticion, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 240, 310));

        dudaSolicitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/signo-de-pregunta-en-circulos.png"))); // NOI18N
        dudaSolicitud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dudaSolicitudMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dudaSolicitudMouseExited(evt);
            }
        });
        panelRepetición.add(dudaSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 75, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel12.setText("Periodicidad personalizada");
        panelRepetición.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 490, 60));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Fecha termina: ");
        panelRepetición.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jComboSelectorDia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jComboSelectorDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione uno...", "Diario", "Semanalmente" }));
        jComboSelectorDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboSelectorDiaActionPerformed(evt);
            }
        });
        panelRepetición.add(jComboSelectorDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 170, 30));

        jCheckBoxLunes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBoxLunes.setText("Lunes");
        jCheckBoxLunes.setEnabled(false);
        jCheckBoxLunes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxLunesActionPerformed(evt);
            }
        });
        panelRepetición.add(jCheckBoxLunes, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));

        jCheckBoxMartes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBoxMartes.setText("Martes");
        jCheckBoxMartes.setEnabled(false);
        jCheckBoxMartes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMartesActionPerformed(evt);
            }
        });
        panelRepetición.add(jCheckBoxMartes, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        jCheckBoxMiercoles.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBoxMiercoles.setText("Miercoles");
        jCheckBoxMiercoles.setEnabled(false);
        jCheckBoxMiercoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMiercolesActionPerformed(evt);
            }
        });
        panelRepetición.add(jCheckBoxMiercoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, -1, -1));

        jCheckBoxJueves.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBoxJueves.setText("Jueves");
        jCheckBoxJueves.setEnabled(false);
        jCheckBoxJueves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxJuevesActionPerformed(evt);
            }
        });
        panelRepetición.add(jCheckBoxJueves, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, -1, -1));

        jCheckBoxViernes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBoxViernes.setText("Viernes");
        jCheckBoxViernes.setEnabled(false);
        jCheckBoxViernes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxViernesActionPerformed(evt);
            }
        });
        panelRepetición.add(jCheckBoxViernes, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, -1, -1));

        jCheckBoxSabado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBoxSabado.setText("Sabado");
        jCheckBoxSabado.setEnabled(false);
        jCheckBoxSabado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxSabadoActionPerformed(evt);
            }
        });
        panelRepetición.add(jCheckBoxSabado, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Repetir:");
        panelRepetición.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelRepetición.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 490, 1));

        jButtonGuardarsa.setBackground(new java.awt.Color(0, 255, 240));
        jButtonGuardarsa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonGuardarsa.setText("Guardar");
        jButtonGuardarsa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonGuardarsaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonGuardarsaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonGuardarsaMouseExited(evt);
            }
        });
        jButtonGuardarsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarsaActionPerformed(evt);
            }
        });
        panelRepetición.add(jButtonGuardarsa, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, 90, 30));

        jCalendar1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendar1PropertyChange(evt);
            }
        });
        panelRepetición.add(jCalendar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 370, 220));
        jCalendar1.setFont(new java.awt.Font("Segoe UI", 1, 10));

        jLabelVisualizarRepetición.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panelRepetición.add(jLabelVisualizarRepetición, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 130, 150));

        Fondo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo_blanco1 1 .jpg"))); // NOI18N
        Fondo5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        panelRepetición.add(Fondo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 880, -1));

        getContentPane().add(panelRepetición, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 560, 410));

        panelCerrar.setBackground(new java.awt.Color(86, 90, 92));
        panelCerrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlClose1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlClose1MouseExited(evt);
            }
        });
        panelCerrar.add(jlClose1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 30, 20));

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
        panelCerrar.add(jlMinimize1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 20, 20));

        LbUsuario.setBackground(new java.awt.Color(0, 51, 204));
        LbUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LbUsuario.setForeground(new java.awt.Color(255, 255, 255));
        LbUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo u_preview_rev_1_opt.png"))); // NOI18N
        LbUsuario.setText("Horarios de salas TIC's y Laboratorios");
        panelCerrar.add(LbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 6, 240, 20));

        getContentPane().add(panelCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlClose1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlClose1MouseClicked
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Desea cerrar el esta ventana? esto descartará los cambios", "Exit", dialog);

        if (result == 0) {
            this.setEnabled(false);
            this.Frame.setEnabled(true);
            this.dispose();
        }

    }//GEN-LAST:event_jlClose1MouseClicked

    private void jlMinimize1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlMinimize1MouseClicked
        this.setState(Frame_Login.ICONIFIED);
    }//GEN-LAST:event_jlMinimize1MouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void jComboSelectorDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboSelectorDiaActionPerformed
        habilitarDias();
        mostrarPeriodicidad();
    }//GEN-LAST:event_jComboSelectorDiaActionPerformed

    private void jCalendar1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendar1PropertyChange
        mostrarPeriodicidad();
    }//GEN-LAST:event_jCalendar1PropertyChange

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseDragged

    private void jCheckBoxLunesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxLunesActionPerformed

        mostrarPeriodicidad();
    }//GEN-LAST:event_jCheckBoxLunesActionPerformed

    private void jCheckBoxMartesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMartesActionPerformed
        mostrarPeriodicidad();
    }//GEN-LAST:event_jCheckBoxMartesActionPerformed

    private void jCheckBoxMiercolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMiercolesActionPerformed
        mostrarPeriodicidad();
    }//GEN-LAST:event_jCheckBoxMiercolesActionPerformed

    private void jCheckBoxJuevesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxJuevesActionPerformed
        mostrarPeriodicidad();
    }//GEN-LAST:event_jCheckBoxJuevesActionPerformed

    private void jCheckBoxViernesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxViernesActionPerformed
        mostrarPeriodicidad();
    }//GEN-LAST:event_jCheckBoxViernesActionPerformed

    private void jCheckBoxSabadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxSabadoActionPerformed
        mostrarPeriodicidad();
    }//GEN-LAST:event_jCheckBoxSabadoActionPerformed

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

    private void dudaSolicitudMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dudaSolicitudMouseEntered
        masInfoRepeticion.setVisible(true);
    }//GEN-LAST:event_dudaSolicitudMouseEntered

    private void dudaSolicitudMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dudaSolicitudMouseExited
        masInfoRepeticion.setVisible(false);
    }//GEN-LAST:event_dudaSolicitudMouseExited

    private void jButtonGuardarsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarsaActionPerformed
        String caso = (String) jComboSelectorDia.getSelectedItem();
        switch (caso) {
            case "Diario":
            this.repeticion = 1;
            break;
            case "Semanalmente":
            this.repeticion = 2;
            break;

            case "Mensualmente":
            this.repeticion = 3;
            break;
            case "Seleccione uno...":
            this.repeticion = 5;
            break;
            default:
            this.repeticion = 4;
            fecha = fechaInicio;
            this.Frame.setTextoMuestralabel("No se repite");
        }

        if (this.repeticion != 5) {
            this.setEnabled(false);
            this.Frame.setEnabled(true);
            this.Frame.setTextoMuestralabel(jLabelVisualizarRepetición.getText());

            int[] diasDIARIOS = {0, 0, 0, 0, 0, 0, 0};

            String[] fechaVec0 = fechaInicio.split("-");
            String[] fechaVec1 = fecha.split("-");

            TimeZone timezone = TimeZone.getDefault();
            Calendar calendarInicio = new GregorianCalendar(timezone);
            calendarInicio.set(Integer.valueOf(fechaVec0[0]), Integer.valueOf(fechaVec0[1]) - 1, Integer.valueOf(fechaVec0[2]));

            Calendar calendarFinal = new GregorianCalendar(timezone);
            calendarFinal.set(Integer.valueOf(fechaVec1[0]), Integer.valueOf(fechaVec1[1]) - 1, Integer.valueOf(fechaVec1[2]));

            Calendar calendarPivote = new GregorianCalendar(timezone);
            calendarPivote.set(Integer.valueOf(fechaVec0[0]), Integer.valueOf(fechaVec0[1]) - 1, Integer.valueOf(fechaVec0[2]));

            while (calendarPivote.compareTo(calendarFinal) <= 0) {
                diasDIARIOS[calendarPivote.get(Calendar.DAY_OF_WEEK) - 1] = calendarPivote.get(Calendar.DAY_OF_WEEK);
                calendarPivote.add(Calendar.DAY_OF_MONTH, 1); // suma un día al calendario 1

                if (calendarPivote.get(Calendar.DAY_OF_WEEK) == calendarInicio.get(Calendar.DAY_OF_WEEK)) {
                    break;
                }
            }
            diasDIARIOS[0] = 0;

            if (repeticion == 1) {
                DiasSeRepite = diasDIARIOS;
            } else if (repeticion == 3) {
                DiasSeRepite[dia_Semana - 1] = dia_Semana;
            }

            this.Frame.setDiasRepeticion(DiasSeRepite);
            this.Frame.setFechaTermina(fecha);
            this.Frame.setIndiceRepeticion(repeticion);
            this.Frame.setNombreRepeticion(jComboSelectorDia.getItemAt(jComboSelectorDia.getSelectedIndex()));

            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una opción", "Acción no valida", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonGuardarsaActionPerformed

    private void jButtonGuardarsaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonGuardarsaMouseExited
        jButtonGuardarsa.setBackground(new Color(0,255,240));
    }//GEN-LAST:event_jButtonGuardarsaMouseExited

    private void jButtonGuardarsaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonGuardarsaMouseEntered
        jButtonGuardarsa.setBackground(new Color(69, 162, 156));
    }//GEN-LAST:event_jButtonGuardarsaMouseEntered

    private void jButtonGuardarsaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonGuardarsaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonGuardarsaMouseClicked

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
            java.util.logging.Logger.getLogger(Frame_PersonalizarRepeticion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_PersonalizarRepeticion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_PersonalizarRepeticion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_PersonalizarRepeticion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_PersonalizarRepeticion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo5;
    private javax.swing.JLabel LbUsuario;
    private javax.swing.JLabel dudaSolicitud;
    private javax.swing.JButton jButtonGuardarsa;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JCheckBox jCheckBoxJueves;
    private javax.swing.JCheckBox jCheckBoxLunes;
    private javax.swing.JCheckBox jCheckBoxMartes;
    private javax.swing.JCheckBox jCheckBoxMiercoles;
    private javax.swing.JCheckBox jCheckBoxSabado;
    private javax.swing.JCheckBox jCheckBoxViernes;
    private javax.swing.JComboBox<String> jComboSelectorDia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelVisualizarRepetición;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jlClose1;
    private javax.swing.JLabel jlMinimize1;
    private javax.swing.JLabel masInfoRepeticion;
    private javax.swing.JPanel panelCerrar;
    private javax.swing.JPanel panelRepetición;
    // End of variables declaration//GEN-END:variables

}
