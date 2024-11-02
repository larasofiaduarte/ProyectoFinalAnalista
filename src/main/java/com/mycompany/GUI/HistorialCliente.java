/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.GUI;

import com.mycompany.proyectofinal.Cliente;
import com.mycompany.proyectofinal.Controladora;
import com.mycompany.proyectofinal.Turno;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class HistorialCliente extends javax.swing.JFrame {
    
    private DefaultTableModel modeloTurnos;
    private Tabla tablaTurnos;
    public JPanel panelCenter = new JPanel();
    Controladora control = new Controladora();
    
    public HistorialCliente() {
        initComponents();
        
        
        TitlePanel title = new TitlePanel("Historial de Cliente");
        title.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPanel1.add(title, BorderLayout.NORTH);
        
        
        
        jPanel1.add(panelCenter, BorderLayout.CENTER);
        
        JPanel panelSouth = new JPanel();
        jPanel1.add(panelSouth, BorderLayout.SOUTH);
        
        panelCenter.setBackground(Styles.bgLight);
        
        panelSouth.setBackground(Styles.bgLight);
        
        Button btnCerrar = new Button("Cerrar");
        panelSouth.add(btnCerrar);
        
        btnCerrar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
        });
        
        panelCenter.setLayout(new BorderLayout());
        panelCenter.setBorder(Styles.paddingFull);
        
        
        //CREAR TABLA
            
            modeloTurnos = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int col){return false;}
            };
            //INICIALIZAR TABLA
            
            String titulosTur[] = {"ID","Cliente", "Servicio", "Fecha"}; //modelo
            modeloTurnos.setColumnIdentifiers(titulosTur); 
            
            
            tablaTurnos = new Tabla(modeloTurnos);
            panelCenter.add(tablaTurnos);
        tablaTurnos.setBackground(Styles.bgGreyLight);
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 500));
        setName("frameHistorial"); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));
        jPanel1.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(HistorialCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistorialCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistorialCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistorialCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistorialCliente().setVisible(true);
            }
        });
    }
    
    public void cargarTablaTurnos(int idCliente) {
        modeloTurnos.setRowCount(0); // Clear existing data in the model

        java.util.List<Turno> listaTurnos = control.traerTurnos(); // Fetch updated turno list
        
        
        
        
        if (listaTurnos != null) {
        for (Turno tur : listaTurnos) {
            Cliente cli = tur.getCliente();

            // Only add rows where Cliente ID matches numCliente
            if (cli != null && cli.getId() == idCliente) {
                String nombreCliente = cli.getNombre() + " " + cli.getApellido();
                
                Object[] objeto = {tur.getId(), nombreCliente, tur.getServicio(), tur.getFecha()};
                modeloTurnos.addRow(objeto); // Add new data to the model if it matches
            }
        }
    }

        panelCenter.revalidate(); // Refresh the panel to reflect changes
        panelCenter.repaint(); // Repaint the panel
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
