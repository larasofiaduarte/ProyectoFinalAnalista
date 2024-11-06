/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.GUI;

import com.mycompany.GUI.*;
import com.mycompany.GUI.ButtonSec;
import com.mycompany.proyectofinal.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import com.mycompany.proyectofinal.Controladora;
import com.mycompany.proyectofinal.Turno;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import java.util.*;


public class ModifTurnos extends javax.swing.JFrame {

    Controladora control = new Controladora();
    
    int numTurno;
    Turno tur;
    
    public ModifTurnos(int numTurno) {
        initComponents();
        
        panelBtns.setBorder(Styles.padding);
        
        Button btnAlta = new Button("Guardar");
        panelBtns.add(btnAlta);
        
        ButtonSec btnLimpiar = new ButtonSec("Limpiar");
        panelBtns.add(btnLimpiar);
        
        ButtonSec btnCerrar = new ButtonSec("Cerrar");
        panelBtns.add(btnCerrar);
        
        txtCliente.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Consume the event if the character is not a digit
                }
            }
        });
        
        
        cargarDatos(numTurno);
        
        
        
        btnLimpiar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtCliente.setText("");
                    cboServicio.setSelectedIndex(-1);
                    cboHora.setSelectedIndex(-1);
                    
                }
        });
        
        btnCerrar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
        });
        
        
        btnAlta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    // Get the client ID from the input field
                    int idCliente = Integer.parseInt(txtCliente.getText()); 

                    // Check if client exists in the database
                    Cliente clienteEnt = control.findCliente(idCliente);
                    if (clienteEnt == null) {
                        JOptionPane.showMessageDialog(null, "Cliente no encontrado. Por favor, ingrese un ID de cliente válido.", "Error", JOptionPane.ERROR_MESSAGE);
                        return; // Exit the action if client does not exist
                    }

                    // Gather other details for the Turno
                    String servicio = (String) cboServicio.getSelectedItem();
                    String hora = (String) cboHora.getSelectedItem();
                    String estado = (String) cboEstado.getSelectedItem();
                    
                    Date fecha = calendar.getDate();
                    
                    LocalDateTime fechafinal = obtenerFecha(hora,fecha);
                    
                    
                    
                    Boolean turnoYaExiste = control.turnoYaExiste(servicio, fechafinal);
                    
                    if(turnoYaExiste){
                        JOptionPane.showMessageDialog(null, "Ya existe un turno para el servicio seleccionado en esa fecha y horario."
                                + "", "No se puede guardar el turno.", JOptionPane.ERROR_MESSAGE);
                    
                    }else{
                        // Save the Turno
                        //control.guardarTurno(servicio, fechafinal, clienteEnt, estado);
                        JOptionPane.showMessageDialog(null, "Turno guardado correctamente.", "Turno guardado.", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    }
                    

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un ID de cliente válido.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(null, "Error al procesar la fecha. Por favor, revise la entrada.", "Error de fecha", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar el turno. Por favor, intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
        
        
        
       
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblCargaTurnos = new javax.swing.JLabel();
        panelBtns = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboServicio = new javax.swing.JComboBox<>();
        txtCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cboHora = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox<>();
        calendar = new com.toedter.calendar.JDateChooser();
        Detalle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDetalle = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));

        lblCargaTurnos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCargaTurnos.setText("Carga de Turnos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 567, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(210, 210, 210)
                    .addComponent(lblCargaTurnos)
                    .addContainerGap(219, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addComponent(lblCargaTurnos)
                    .addContainerGap(38, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        panelBtns.setBackground(new java.awt.Color(250, 250, 250));
        getContentPane().add(panelBtns, java.awt.BorderLayout.PAGE_END);

        jPanel3.setBackground(new java.awt.Color(250, 250, 250));

        jLabel1.setText("ID Cliente");

        jLabel2.setText("Servicio");

        jLabel3.setText("Fecha");

        cboServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Corte Masculino", "Corte Femenino", "Colorista", "Estética" }));

        txtCliente.setBackground(new java.awt.Color(242, 242, 242));
        txtCliente.setForeground(new java.awt.Color(102, 102, 102));
        txtCliente.setText("1");
        txtCliente.setBorder(null);
        txtCliente.setPreferredSize(new java.awt.Dimension(73, 30));

        jLabel4.setText("Horario");

        cboHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", " " }));

        jLabel5.setText("Estado");

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente", "Finalizado" }));

        Detalle.setText("Estado");

        txtDetalle.setColumns(20);
        txtDetalle.setRows(5);
        jScrollPane1.setViewportView(txtDetalle);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Detalle, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(calendar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboServicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(calendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Detalle)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 88, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public void main(String args[]) {
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
            java.util.logging.Logger.getLogger(ModifTurnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifTurnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifTurnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifTurnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifTurnos(numTurno).setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Detalle;
    private com.toedter.calendar.JDateChooser calendar;
    private javax.swing.JComboBox<String> cboEstado;
    private javax.swing.JComboBox<String> cboHora;
    private javax.swing.JComboBox<String> cboServicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCargaTurnos;
    private javax.swing.JPanel panelBtns;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextArea txtDetalle;
    // End of variables declaration//GEN-END:variables

    private void cargarDatos(int numTurno) {
    
        this.tur = control.findTurno(numTurno);
        
        String id = String.valueOf(tur.getCliente().getId());
        
        txtCliente.setText(id);
        //cargar datos cbo
        
    }
    public LocalDateTime obtenerFecha(String hora, Date fecha){
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        String[] timeParts = hora.split(":");
        int hour = Integer.parseInt(timeParts[0]);
        int minute = Integer.parseInt(timeParts[1]);
        
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        
        Date combinedDate = calendar.getTime();
        
        return combinedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    
    }
}
