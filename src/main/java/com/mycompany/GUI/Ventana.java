/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.GUI;

import com.mycompany.proyectofinal.Controladora;
import com.mycompany.GUI.Button;
import com.mycompany.GUI.TitlePanel;
import com.mycompany.GUI.Tabla;

import java.io.File;
import java.io.IOException;
import static javax.swing.GroupLayout.Alignment.CENTER;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;


public class Ventana extends javax.swing.JFrame {
    
    CardLayout card;
    Controladora control;
    
    /**
     * Creates new form Ventana
     */
    public Ventana() {
        initComponents();
        this.setVisible(true);
        this.setTitle("HY Peluquería");
        this.setSize(1000,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        control = new Controladora();
        
        card = (CardLayout) mainPanel.getLayout();
        
        //card.show(mainPanel, "Login1");
        card.show(mainPanel, "mainScreen");
        
        /*PANEL LOGIN 1*/
        btnLogin1.setBackground(Styles.accentDark);
        btnLogin1.setContentAreaFilled(false);
        btnLogin1.setBorderPainted(false);
        btnLogin1.setOpaque(true);
        
        
        /*LOGO MAIN SCREEN SIDEBAR*/
        label.setFont(Styles.customFontMd);
        label1.setFont(Styles.customFontMd);
        label2.setFont(Styles.customFontSm);
        
        label.setForeground(Styles.fontLight);
        label2.setForeground(Styles.fontLight);
        label1.setForeground(Styles.fontLight);
        
        
        /*UI MAIN SCREEN GESTIONES*/
        
        //CLIENTES
            
            TitlePanel titleCli = new TitlePanel("Clientes");
            cardClientes.add(titleCli, BorderLayout.NORTH);

            //crear tabla
            JPanel panelCenterCli = new JPanel(new BorderLayout()); //add flow layout center to this?
            cardClientes.add(panelCenterCli, BorderLayout.CENTER);
            
            Tabla tableCli = new Tabla();
            panelCenterCli.add(tableCli, BorderLayout.CENTER);

            //btns panel
            JPanel btnPanelCli = new JPanel(new FlowLayout(FlowLayout.CENTER));
            btnPanelCli.setBorder(new EmptyBorder(0, 0, 40, 0));
            btnPanelCli.setBackground(Styles.bgLight);
            //agregar panel a card
            cardClientes.add(btnPanelCli, BorderLayout.SOUTH);

            //crear btn
            Button btnNuevoCli = new Button("Nuevo");
            btnPanelCli.add(btnNuevoCli);
            //btn mod
            Button btnModCli = new Button("Editar");
            btnPanelCli.add(btnModCli);
            //btn eliminar
            Button btnElimCli = new Button("Eliminar");
            btnPanelCli.add(btnElimCli);
            //logica abrir form al clickear btn
            //abrir Form de alta
            btnNuevoCli.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    AltaClientes form = new AltaClientes();
                    form.setVisible(true);
                    form.setLocationRelativeTo(null);
                }
            });
            
        //TURNOS
            
            TitlePanel titleTur = new TitlePanel("Turnos");
            cardTurnos.add(titleTur, BorderLayout.NORTH);

            //crear tabla
            JPanel panelCenterTur = new JPanel(new BorderLayout()); //add flow layout center to this?
            cardTurnos.add(panelCenterTur, BorderLayout.CENTER);
            
            Tabla tableTur = new Tabla();
            panelCenterTur .add(tableTur, BorderLayout.CENTER);

            //btns panel
            JPanel btnPanelTur = new JPanel(new FlowLayout(FlowLayout.CENTER));
            btnPanelTur.setBorder(new EmptyBorder(0, 0, 40, 0));
            btnPanelTur.setBackground(Styles.bgLight);
            //agregar panel a card
            cardTurnos.add(btnPanelTur, BorderLayout.SOUTH);

            //crear btn
            Button btnNuevoTur = new Button("Nuevo");
            btnPanelTur.add(btnNuevoTur);
            //btn mod
            Button btnModTur = new Button("Editar");
            btnPanelTur.add(btnModTur);
            //btn eliminar
            Button btnElimTur = new Button("Eliminar");
            btnPanelTur.add(btnElimTur);
            //logica abrir form al clickear btn
            
        //SERVICIOS
            
            TitlePanel titleSer = new TitlePanel("Servicios");
            cardServicios.add(titleSer, BorderLayout.NORTH);

            //crear tabla
            JPanel panelCenterSer = new JPanel(new BorderLayout()); //add flow layout center to this?
            cardServicios.add(panelCenterSer , BorderLayout.CENTER);
            
            Tabla tableSer = new Tabla();
            panelCenterSer .add(tableSer, BorderLayout.CENTER);

            //btns panel
            JPanel btnPanelSer = new JPanel(new FlowLayout(FlowLayout.CENTER));
            btnPanelSer.setBorder(new EmptyBorder(0, 0, 40, 0));
            btnPanelSer.setBackground(Styles.bgLight);
            //agregar panel a card
            cardServicios.add(btnPanelSer, BorderLayout.SOUTH);

            //crear btn
            Button btnNuevoSer = new Button("Nuevo");
            btnPanelSer.add(btnNuevoSer);
            //btn mod
            Button btnModSer = new Button("Editar");
            btnPanelSer.add(btnModSer);
            //btn eliminar
            Button btnElimSer = new Button("Eliminar");
            btnPanelSer.add(btnElimSer);
            //logica abrir form al clickear btn
            
        //CAJA 
            TitlePanel titleCaja = new TitlePanel("Caja");
            cardCaja.add(titleCaja, BorderLayout.NORTH);

            //crear tabla
            JPanel panelCenterCaja = new JPanel(new BorderLayout()); //add flow layout center to this?
            cardCaja.add(panelCenterCaja , BorderLayout.CENTER);
            
            Tabla tableCaja = new Tabla();
            panelCenterCaja .add(tableCaja, BorderLayout.CENTER);

            //btns panel
            JPanel btnPanelCaja = new JPanel(new FlowLayout(FlowLayout.CENTER));
            btnPanelCaja.setBorder(new EmptyBorder(0, 0, 40, 0));
            btnPanelCaja.setBackground(Styles.bgLight);
            //agregar panel a card
            cardCaja.add(btnPanelCaja, BorderLayout.SOUTH);

            //crear btn
            Button btnNuevoCaja = new Button("Nuevo");
            btnPanelCaja.add(btnNuevoCaja);
            //btn mod
            Button btnModCaja = new Button("Editar");
            btnPanelCaja.add(btnModCaja);
            //btn eliminar
            Button btnElimCaja = new Button("Eliminar");
            btnPanelCaja.add(btnElimCaja);
            //logica abrir form al clickear btn
            
        //PROVEEDORES
            TitlePanel titleProv = new TitlePanel("Proveedores");
            cardProveedores.add(titleProv, BorderLayout.NORTH);

            //crear tabla
            JPanel panelCenterProv = new JPanel(new BorderLayout()); //add flow layout center to this?
            cardProveedores.add(panelCenterProv, BorderLayout.CENTER);
            
            Tabla tableProv = new Tabla();
            panelCenterProv .add(tableProv, BorderLayout.CENTER);

            //btns panel
            JPanel btnPanelProv = new JPanel(new FlowLayout(FlowLayout.CENTER));
            btnPanelProv.setBorder(new EmptyBorder(0, 0, 40, 0));
            btnPanelProv.setBackground(Styles.bgLight);
            //agregar panel a card
            cardProveedores.add(btnPanelProv, BorderLayout.SOUTH);

            //btn alta
            Button btnNuevoProv = new Button("Nuevo");
            btnPanelProv.add(btnNuevoProv);
            //btn mod
            Button btnModProv = new Button("Editar");
            btnPanelProv.add(btnModProv);
            //btn eliminar
            Button btnElimProv = new Button("Eliminar");
            btnPanelProv.add(btnElimProv);
            //logica abrir form al clickear btn
            btnNuevoProv.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    AltaProveedores form = new AltaProveedores();
                    form.setVisible(true);
                    form.setLocationRelativeTo(null);
                }
            });
            
            
        //INVENTARIO
            TitlePanel titleInv = new TitlePanel("Inventario");
            cardInventario.add(titleInv, BorderLayout.NORTH);

            //crear tabla
            JPanel panelCenterInv = new JPanel(new BorderLayout()); //add flow layout center to this?
            cardInventario.add(panelCenterInv , BorderLayout.CENTER);
            
            Tabla tableInv = new Tabla();
            panelCenterInv .add(tableInv, BorderLayout.CENTER);

            //btns panel
            JPanel btnPanelInv = new JPanel(new FlowLayout(FlowLayout.CENTER));
            btnPanelInv.setBorder(new EmptyBorder(0, 0, 40, 0));
            btnPanelInv.setBackground(Styles.bgLight);
            //agregar panel a card
            cardInventario.add(btnPanelInv, BorderLayout.SOUTH);

            //btn alta
            Button btnNuevoInv = new Button("Nuevo");
            btnPanelInv.add(btnNuevoInv);
            //btn mod
            Button btnModInv = new Button("Editar");
            btnPanelInv.add(btnModInv);
            //btn eliminar
            Button btnElimInv = new Button("Eliminar");
            btnPanelInv.add(btnElimInv);
            //logica abrir form al clickear btn
            
        
        //EMPLEADOS
            TitlePanel titleEmp= new TitlePanel("Empleados");
            cardEmpleados.add(titleEmp, BorderLayout.NORTH);

            //crear tabla
            JPanel panelCentral = new JPanel(new BorderLayout()); //add flow layout center to this?
            cardEmpleados.add(panelCentral, BorderLayout.CENTER);
            
            Tabla table = new Tabla();
            panelCentral.add(table, BorderLayout.CENTER);

            //btn alta
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            buttonPanel.setBorder(new EmptyBorder(0, 0, 40, 0));

            cardEmpleados.add(buttonPanel, BorderLayout.SOUTH);
            Button btnNuevoEmp = new Button("Nuevo");
            buttonPanel.add(btnNuevoEmp);
            buttonPanel.setBackground(Styles.bgLight);

            //abrir Form de alta
            btnNuevoEmp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    AltaEmpleados form = new AltaEmpleados();
                    form.setVisible(true);
                    form.setLocationRelativeTo(null);
                }
            });

            //btn modificar
            Button btnModEmp = new Button("Editar");
            buttonPanel.add(btnModEmp);

            //btn eliminar
            Button btnElimEmp = new Button("Eliminar");
            buttonPanel.add(btnElimEmp);
        
        
        
        /*LOGO LOGIN*/
        
        JLabel lblLogo = new JLabel("HECTOR");
        lblLogo.setBounds(130, 190, 250, 70); 
        lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
        jLayeredPane2.add(lblLogo, JLayeredPane.PALETTE_LAYER);
        lblLogo.setFont(Styles.customFontXl);
        lblLogo.setForeground(Styles.fontLight);
        
        JLabel lblLogo2 = new JLabel("YAGUSZ");
        lblLogo2.setBounds(130, 235, 250, 70); 
        lblLogo2.setHorizontalAlignment(SwingConstants.CENTER);
        jLayeredPane2.add(lblLogo2, JLayeredPane.PALETTE_LAYER);
        lblLogo2.setFont(Styles.customFontXl);
        lblLogo2.setForeground(Styles.fontLight);
        
        JLabel lblLogo3 = new JLabel(" P   E   L   U   Q   U   E   R   I   A");
        lblLogo3.setBounds(130, 270, 250, 70); 
        lblLogo3.setHorizontalAlignment(SwingConstants.CENTER);
        jLayeredPane2.add(lblLogo3, JLayeredPane.PALETTE_LAYER);
        lblLogo3.setFont(Styles.customFontMd);
        lblLogo3.setForeground(Styles.fontLight);
        
        this.addComponentListener(new ComponentAdapter(){
            @Override
            public void componentResized(ComponentEvent e){
                // Get the parent container's width and height
        int parentWidth = jLayeredPane2.getWidth();
        int parentHeight = jLayeredPane2.getHeight();
        
        // Get each label's width and height
        int lblLogoWidth = lblLogo.getWidth();
        int lblLogoHeight = lblLogo.getHeight();
        
        int lblLogo2Width = lblLogo2.getWidth();
        int lblLogo2Height = lblLogo2.getHeight();
        
        int lblLogo3Width = lblLogo3.getWidth();
        int lblLogo3Height = lblLogo3.getHeight();

        // Calculate new centered positions for each label
        int lblLogoX = (parentWidth - lblLogoWidth) / 2;
        int lblLogoY = (parentHeight - lblLogoHeight) / 2 - 30;

        int lblLogo2X = (parentWidth - lblLogo2Width) / 2;
        int lblLogo2Y = (parentHeight - lblLogo2Height) / 2 + 30;  // Adjust the y position if necessary

        int lblLogo3X = (parentWidth - lblLogo3Width) / 2;
        int lblLogo3Y = (parentHeight - lblLogo3Height) / 2 + 70;  // Adjust the y position if necessary

        // Set the new bounds (x, y, width, height) for each label
        lblLogo.setBounds(lblLogoX, lblLogoY, lblLogoWidth, lblLogoHeight);
        lblLogo2.setBounds(lblLogo2X, lblLogo2Y, lblLogo2Width, lblLogo2Height);
        lblLogo3.setBounds(lblLogo3X, lblLogo3Y, lblLogo3Width, lblLogo3Height);
            }
            
        }
        
        );
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        Login1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnLogin1 = new javax.swing.JButton();
        txtUser1 = new javax.swing.JTextField();
        lblUser1 = new javax.swing.JLabel();
        lblPass1 = new javax.swing.JLabel();
        txtPassword2 = new javax.swing.JPasswordField();
        lblLogin1 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel3 = new javax.swing.JLabel();
        mainScreen = new javax.swing.JPanel();
        sideMenu = new javax.swing.JPanel();
        btnTurnos = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnEmpleados = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();
        btnProveedores = new javax.swing.JButton();
        btnCaja = new javax.swing.JButton();
        btnServicios = new javax.swing.JButton();
        label = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        panelMain = new javax.swing.JPanel();
        cardInventario = new javax.swing.JPanel();
        cardProveedores = new javax.swing.JPanel();
        cardCaja = new javax.swing.JPanel();
        cardServicios = new javax.swing.JPanel();
        cardTurnos = new javax.swing.JPanel();
        cardClientes = new javax.swing.JPanel();
        cardEmpleados = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));

        mainPanel.setLayout(new java.awt.CardLayout());

        Login1.setBackground(new java.awt.Color(243, 239, 215));
        Login1.setPreferredSize(new java.awt.Dimension(800, 500));
        Login1.setVerifyInputWhenFocusTarget(false);

        jPanel3.setBackground(new java.awt.Color(250, 250, 250));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 238, 238)));
        jPanel3.setName("jPanel2"); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(500, 400));

        btnLogin1.setBackground(new java.awt.Color(149, 90, 207));
        btnLogin1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogin1.setForeground(new java.awt.Color(251, 251, 251));
        btnLogin1.setText("Iniciar Sesión");
        btnLogin1.setName("btnLogin"); // NOI18N
        btnLogin1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogin1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogin1MouseExited(evt);
            }
        });
        btnLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogin1ActionPerformed(evt);
            }
        });

        txtUser1.setBackground(new java.awt.Color(229, 229, 229));
        txtUser1.setForeground(new java.awt.Color(153, 153, 153));
        txtUser1.setText("usuario");
        txtUser1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUser1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUser1FocusLost(evt);
            }
        });

        lblUser1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblUser1.setForeground(new java.awt.Color(91, 91, 91));
        lblUser1.setText("Nombre de Usuario");

        lblPass1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPass1.setForeground(new java.awt.Color(93, 93, 93));
        lblPass1.setText("Contraseña");

        txtPassword2.setBackground(new java.awt.Color(229, 229, 229));
        txtPassword2.setForeground(new java.awt.Color(153, 153, 153));
        txtPassword2.setText("contrasena");
        txtPassword2.setName(""); // NOI18N

        lblLogin1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblLogin1.setForeground(new java.awt.Color(51, 51, 51));
        lblLogin1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogin1.setText("Iniciar Sesión");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtPassword2)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblUser1)
                        .addComponent(lblPass1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblLogin1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogin1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(lblUser1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lblPass1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane2.setBackground(new java.awt.Color(255, 204, 204));
        jLayeredPane2.setPreferredSize(new java.awt.Dimension(500, 400));

        jLabel3.setBackground(new java.awt.Color(255, 204, 204));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/7020304.jpg"))); // NOI18N
        jLabel3.setText("jLabel2");
        jLabel3.setPreferredSize(new java.awt.Dimension(500, 400));

        jLayeredPane2.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 621, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Login1Layout = new javax.swing.GroupLayout(Login1);
        Login1.setLayout(Login1Layout);
        Login1Layout.setHorizontalGroup(
            Login1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Login1Layout.createSequentialGroup()
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        Login1Layout.setVerticalGroup(
            Login1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 570, Short.MAX_VALUE)
        );

        mainPanel.add(Login1, "login");

        mainScreen.setBackground(new java.awt.Color(250, 250, 250));

        sideMenu.setBackground(new java.awt.Color(51, 51, 51));

        btnTurnos.setBackground(new java.awt.Color(51, 51, 51));
        btnTurnos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTurnos.setForeground(Styles.fontLight);
        btnTurnos.setText("TURNOS");
        btnTurnos.setBorder(null);
        btnTurnos.setBorderPainted(false);
        btnTurnos.setContentAreaFilled(false);  // Removes the background fill
        btnTurnos.setBorderPainted(false);      // Removes the border
        btnTurnos.setFocusPainted(false);       // Removes the focus border when clicked
        btnTurnos.setOpaque(false);
        btnTurnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTurnosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTurnosMouseExited(evt);
            }
        });
        btnTurnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTurnosActionPerformed(evt);
            }
        });

        btnClientes.setBackground(new java.awt.Color(51, 51, 51));
        btnClientes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClientes.setForeground(Styles.fontLight);
        btnClientes.setText("CLIENTES");
        btnClientes.setBorder(null);
        btnClientes.setBorderPainted(false);
        btnClientes.setContentAreaFilled(false);  // Removes the background fill
        btnClientes.setBorderPainted(false);      // Removes the border
        btnClientes.setFocusPainted(false);       // Removes the focus border when clicked
        btnClientes.setOpaque(false);
        btnClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClientesMouseExited(evt);
            }
        });
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnEmpleados.setBackground(new java.awt.Color(51, 51, 51));
        btnEmpleados.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEmpleados.setForeground(Styles.fontLight);
        btnEmpleados.setText("EMPLEADOS");
        btnEmpleados.setBorder(null);
        btnEmpleados.setBorderPainted(false);
        btnEmpleados.setContentAreaFilled(false);  // Removes the background fill
        btnEmpleados.setBorderPainted(false);      // Removes the border
        btnEmpleados.setFocusPainted(false);       // Removes the focus border when clicked
        btnEmpleados.setOpaque(false);
        btnEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEmpleadosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEmpleadosMouseExited(evt);
            }
        });
        btnEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadosActionPerformed(evt);
            }
        });

        btnInventario.setBackground(new java.awt.Color(51, 51, 51));
        btnInventario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInventario.setForeground(Styles.fontLight);
        btnInventario.setText("INVENTARIO");
        btnInventario.setBorder(null);
        btnInventario.setBorderPainted(false);
        btnInventario.setContentAreaFilled(false);  // Removes the background fill
        btnInventario.setBorderPainted(false);      // Removes the border
        btnInventario.setFocusPainted(false);       // Removes the focus border when clicked
        btnInventario.setOpaque(false);
        btnInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInventarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInventarioMouseExited(evt);
            }
        });
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });

        btnProveedores.setBackground(new java.awt.Color(51, 51, 51));
        btnProveedores.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnProveedores.setForeground(Styles.fontLight);
        btnProveedores.setText("PROVEEDORES");
        btnProveedores.setBorder(null);
        btnProveedores.setBorderPainted(false);
        btnProveedores.setContentAreaFilled(false);  // Removes the background fill
        btnProveedores.setBorderPainted(false);      // Removes the border
        btnProveedores.setFocusPainted(false);       // Removes the focus border when clicked
        btnProveedores.setOpaque(false);
        btnProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProveedoresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProveedoresMouseExited(evt);
            }
        });
        btnProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedoresActionPerformed(evt);
            }
        });

        btnCaja.setBackground(new java.awt.Color(51, 51, 51));
        btnCaja.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCaja.setForeground(Styles.fontLight);
        btnCaja.setText("CAJA");
        btnCaja.setBorderPainted(false);
        btnCaja.setContentAreaFilled(false);  // Removes the background fill
        btnCaja.setBorderPainted(false);      // Removes the border
        btnCaja.setFocusPainted(false);       // Removes the focus border when clicked
        btnCaja.setOpaque(false);
        btnCaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCajaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCajaMouseExited(evt);
            }
        });
        btnCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCajaActionPerformed(evt);
            }
        });

        btnServicios.setBackground(new java.awt.Color(51, 51, 51));
        btnServicios.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnServicios.setForeground(Styles.fontLight);
        btnServicios.setText("SERVICIOS");
        btnServicios.setBorder(null);
        btnServicios.setBorderPainted(false);
        btnServicios.setContentAreaFilled(false);  // Removes the background fill
        btnServicios.setBorderPainted(false);      // Removes the border
        btnServicios.setFocusPainted(false);       // Removes the focus border when clicked
        btnServicios.setOpaque(false);
        btnServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnServiciosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnServiciosMouseExited(evt);
            }
        });
        btnServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServiciosActionPerformed(evt);
            }
        });

        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("HECTOR");
        label.setAlignmentY(0.0F);

        label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label1.setText("YAGUSZ");

        label2.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label2.setText("P E L U Q U E R I A");

        javax.swing.GroupLayout sideMenuLayout = new javax.swing.GroupLayout(sideMenu);
        sideMenu.setLayout(sideMenuLayout);
        sideMenuLayout.setHorizontalGroup(
            sideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideMenuLayout.createSequentialGroup()
                .addGroup(sideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(btnServicios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTurnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        sideMenuLayout.setVerticalGroup(
            sideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideMenuLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(label)
                .addGap(1, 1, 1)
                .addComponent(label1)
                .addGap(2, 2, 2)
                .addComponent(label2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        panelMain.setBackground(new java.awt.Color(250, 250, 250));
        panelMain.setPreferredSize(new java.awt.Dimension(800, 500));
        panelMain.setLayout(new java.awt.CardLayout());

        cardInventario.setBackground(new java.awt.Color(250, 250, 250));
        cardInventario.setLayout(new java.awt.BorderLayout());
        panelMain.add(cardInventario, "cardInventario");

        cardProveedores.setBackground(new java.awt.Color(250, 250, 250));
        cardProveedores.setLayout(new java.awt.BorderLayout());
        panelMain.add(cardProveedores, "cardProveedores");

        cardCaja.setBackground(new java.awt.Color(250, 250, 250));
        cardCaja.setLayout(new java.awt.BorderLayout());
        panelMain.add(cardCaja, "cardCaja");

        cardServicios.setBackground(new java.awt.Color(250, 250, 250));
        cardServicios.setLayout(new java.awt.BorderLayout());
        panelMain.add(cardServicios, "cardServicios");

        cardTurnos.setBackground(new java.awt.Color(250, 250, 250));
        cardTurnos.setLayout(new java.awt.BorderLayout());
        panelMain.add(cardTurnos, "cardTurnos");

        cardClientes.setBackground(new java.awt.Color(250, 250, 250));
        cardClientes.setLayout(new java.awt.BorderLayout());
        panelMain.add(cardClientes, "cardClientes");

        cardEmpleados.setBackground(new java.awt.Color(250, 250, 250));
        cardEmpleados.setLayout(new java.awt.BorderLayout());
        panelMain.add(cardEmpleados, "cardEmpleados");

        javax.swing.GroupLayout mainScreenLayout = new javax.swing.GroupLayout(mainScreen);
        mainScreen.setLayout(mainScreenLayout);
        mainScreenLayout.setHorizontalGroup(
            mainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainScreenLayout.createSequentialGroup()
                .addComponent(sideMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE))
        );
        mainScreenLayout.setVerticalGroup(
            mainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sideMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mainPanel.add(mainScreen, "mainScreen");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    private void btnServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServiciosActionPerformed
        card = (CardLayout)  this.panelMain.getLayout();
        card.show(panelMain,"cardServicios");
    }//GEN-LAST:event_btnServiciosActionPerformed

    private void btnServiciosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServiciosMouseExited
        btnServicios.setForeground(Styles.fontLight);
    }//GEN-LAST:event_btnServiciosMouseExited

    private void btnServiciosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServiciosMouseEntered
        btnServicios.setForeground(Styles.fontLightHover);
    }//GEN-LAST:event_btnServiciosMouseEntered

    private void btnCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCajaActionPerformed
        card = (CardLayout)  this.panelMain.getLayout();
        card.show(panelMain,"cardCaja");
    }//GEN-LAST:event_btnCajaActionPerformed

    private void btnCajaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCajaMouseExited
        btnCaja.setForeground(Styles.fontLight);
    }//GEN-LAST:event_btnCajaMouseExited

    private void btnCajaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCajaMouseEntered
        btnCaja.setForeground(Styles.fontLightHover);
    }//GEN-LAST:event_btnCajaMouseEntered

    private void btnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedoresActionPerformed
        card = (CardLayout)  this.panelMain.getLayout();
        card.show(panelMain,"cardProveedores");
    }//GEN-LAST:event_btnProveedoresActionPerformed

    private void btnProveedoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProveedoresMouseExited
        btnProveedores.setForeground(Styles.fontLight);
    }//GEN-LAST:event_btnProveedoresMouseExited

    private void btnProveedoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProveedoresMouseEntered
        btnProveedores.setForeground(Styles.fontLightHover);
    }//GEN-LAST:event_btnProveedoresMouseEntered

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        card = (CardLayout)  this.panelMain.getLayout();
        card.show(panelMain,"cardInventario");
    }//GEN-LAST:event_btnInventarioActionPerformed

    private void btnInventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInventarioMouseExited
        btnInventario.setForeground(Styles.fontLight);
    }//GEN-LAST:event_btnInventarioMouseExited

    private void btnInventarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInventarioMouseEntered
        btnInventario.setForeground(Styles.fontLightHover);
    }//GEN-LAST:event_btnInventarioMouseEntered

    private void btnEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosActionPerformed
        card = (CardLayout)  this.panelMain.getLayout();
        card.show(panelMain,"cardEmpleados");
    }//GEN-LAST:event_btnEmpleadosActionPerformed

    private void btnEmpleadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmpleadosMouseExited
        btnEmpleados.setForeground(Styles.fontLight);
    }//GEN-LAST:event_btnEmpleadosMouseExited

    private void btnEmpleadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmpleadosMouseEntered
        btnEmpleados.setForeground(Styles.fontLightHover);
    }//GEN-LAST:event_btnEmpleadosMouseEntered

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        // TODO add your handling code here:
        card = (CardLayout)  this.panelMain.getLayout();
        card.show(panelMain,"cardClientes");
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientesMouseExited
        btnClientes.setForeground(Styles.fontLight);
    }//GEN-LAST:event_btnClientesMouseExited

    private void btnClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientesMouseEntered
        btnClientes.setForeground(Styles.fontLightHover);
    }//GEN-LAST:event_btnClientesMouseEntered

    private void btnTurnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTurnosActionPerformed
        // TODO add your handling code here:
        card = (CardLayout)  this.panelMain.getLayout();
        card.show(panelMain,"cardTurnos");
    }//GEN-LAST:event_btnTurnosActionPerformed

    private void btnTurnosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTurnosMouseExited
        btnTurnos.setForeground(Styles.fontLight);
    }//GEN-LAST:event_btnTurnosMouseExited

    private void btnTurnosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTurnosMouseEntered
        // TODO add your handling code here:
        btnTurnos.setForeground(Styles.fontLightHover);
    }//GEN-LAST:event_btnTurnosMouseEntered

    private void btnLogin1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogin1MouseEntered
        btnLogin1.setBackground(Styles.accentLightHover);
    }//GEN-LAST:event_btnLogin1MouseEntered

    private void btnLogin1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogin1MouseExited
        btnLogin1.setBackground(Styles.accentDark);
    }//GEN-LAST:event_btnLogin1MouseExited
/*LOGICA
    DE LOGIN*/
    private void btnLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogin1ActionPerformed
        //card = (CardLayout)  this.mainPanel.getLayout();
        //card.show(mainPanel,"mainScreen");
        
        String user = txtUser1.getText();
        String pass = txtPassword2.getText();
        
        boolean Login = control.validarUsuario(user,pass);
        
        if(Login){
            card = (CardLayout)  this.mainPanel.getLayout();
            card.show(mainPanel,"mainScreen");
        }else{
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.", "Login", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_btnLogin1ActionPerformed

    private void txtUser1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUser1FocusGained
        
    }//GEN-LAST:event_txtUser1FocusGained

    private void txtUser1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUser1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUser1FocusLost
 
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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Login1;
    private javax.swing.JButton btnCaja;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnEmpleados;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnLogin1;
    private javax.swing.JButton btnProveedores;
    private javax.swing.JButton btnServicios;
    private javax.swing.JButton btnTurnos;
    private javax.swing.JPanel cardCaja;
    private javax.swing.JPanel cardClientes;
    private javax.swing.JPanel cardEmpleados;
    private javax.swing.JPanel cardInventario;
    private javax.swing.JPanel cardProveedores;
    private javax.swing.JPanel cardServicios;
    private javax.swing.JPanel cardTurnos;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel lblLogin1;
    private javax.swing.JLabel lblPass1;
    private javax.swing.JLabel lblUser1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel mainScreen;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel sideMenu;
    private javax.swing.JPasswordField txtPassword2;
    private javax.swing.JTextField txtUser1;
    // End of variables declaration//GEN-END:variables
}
