
package com.mycompany.GUI;

import com.mycompany.GUI.Styles;
import com.mycompany.GUI.Button;
import com.mycompany.GUI.ButtonSec;
import com.mycompany.proyectofinal.Controladora;
import com.mycompany.proyectofinal.Proveedor;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
        


public class ModifProveedores extends javax.swing.JFrame {
    
    Controladora control = new Controladora();
    int numProv;
    Proveedor prov;

    public ModifProveedores() {
        initComponents();
        panelNorth.setBorder(Styles.paddingTop);
        panelSouth.setBorder(Styles.paddingBottom);
        
        cargarDatos(numProv);
        
        JLabel lblTitle = new JLabel("Carga de Proveedores");
        lblTitle.setFont(Styles.fontTitle);
        lblTitle.setForeground(Styles.fontDark);
        panelNorth.add(lblTitle);
        
        Button btnAlta = new Button("Guardar");
        panelSouth.add(btnAlta);
        
        ButtonSec btnLimpiar = new ButtonSec("Limpiar");
        panelSouth.add(btnLimpiar);
        
        ButtonSec btnCerrar = new ButtonSec("Cerrar");
        panelSouth.add(btnCerrar);
        
        
        btnCerrar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
        });
        
        btnLimpiar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtNombre.setText("");
                    txtTelefono.setText("");
                    txtCorreo.setText("");
                }
        });
        
        btnAlta.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String nombre = txtNombre.getText();
                    String telefono = txtTelefono.getText();
                    String email = txtCorreo.getText();
                    
                    control.modificarProveedor(prov, nombre, telefono, email);
                    JOptionPane.showMessageDialog(null, "Producto guardado correctamente.", "Producto guardado.", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    
                }
        });
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelNorth = new javax.swing.JPanel();
        panelSouth = new javax.swing.JPanel();
        panelCenter = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(250, 250, 250));

        jPanel1.setLayout(new java.awt.BorderLayout());

        panelNorth.setBackground(new java.awt.Color(250, 250, 250));
        jPanel1.add(panelNorth, java.awt.BorderLayout.PAGE_START);

        panelSouth.setBackground(new java.awt.Color(250, 250, 250));
        jPanel1.add(panelSouth, java.awt.BorderLayout.PAGE_END);

        panelCenter.setBackground(new java.awt.Color(250, 250, 250));

        jLabel1.setText("Nombre");

        jLabel2.setText("Teléfono");

        jLabel3.setText("Correo Electrónico");

        txtNombre.setBackground(new java.awt.Color(240, 240, 240));
        txtNombre.setForeground(new java.awt.Color(102, 102, 102));
        txtNombre.setText("Proveedor");
        txtNombre.setBorder(null);
        txtNombre.setPreferredSize(new java.awt.Dimension(220, 30));
        txtNombre.setSelectionColor(new java.awt.Color(204, 204, 255));

        txtTelefono.setBackground(new java.awt.Color(240, 240, 240));
        txtTelefono.setForeground(new java.awt.Color(102, 102, 102));
        txtTelefono.setText("1234 567890");
        txtTelefono.setBorder(null);
        txtTelefono.setPreferredSize(new java.awt.Dimension(220, 30));
        txtTelefono.setSelectionColor(new java.awt.Color(204, 204, 255));

        txtCorreo.setBackground(new java.awt.Color(240, 240, 240));
        txtCorreo.setForeground(new java.awt.Color(102, 102, 102));
        txtCorreo.setText("Correo@gmail.com");
        txtCorreo.setBorder(null);
        txtCorreo.setPreferredSize(new java.awt.Dimension(220, 30));
        txtCorreo.setSelectionColor(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout panelCenterLayout = new javax.swing.GroupLayout(panelCenter);
        panelCenter.setLayout(panelCenterLayout);
        panelCenterLayout.setHorizontalGroup(
            panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCenterLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        panelCenterLayout.setVerticalGroup(
            panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCenterLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(29, 29, 29)
                .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(294, Short.MAX_VALUE))
        );

        jPanel1.add(panelCenter, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ModifProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifProveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelNorth;
    private javax.swing.JPanel panelSouth;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    private void cargarDatos(int numProv) {
        this.prov = control.findProveedor(numProv);
        
        txtNombre.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
    
    }
}
