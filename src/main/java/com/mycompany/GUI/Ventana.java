/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.GUI;

import com.formdev.flatlaf.FlatLaf;
import com.mycompany.proyectofinal.Controladora;
import com.mycompany.GUI.Button;
import com.mycompany.GUI.TitlePanel;
import com.mycompany.GUI.Tabla;
import com.mycompany.proyectofinal.Caja;
import com.mycompany.proyectofinal.Cliente;
import com.mycompany.proyectofinal.Producto;
import com.mycompany.proyectofinal.Proveedor;
import com.mycompany.proyectofinal.Servicio;
import com.mycompany.proyectofinal.Turno;
import com.mycompany.proyectofinal.Usuario;

import java.io.File;
import java.io.IOException;
import javax.swing.GroupLayout.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import java.util.List;


public class Ventana extends javax.swing.JFrame {
    
    CardLayout card;
    Controladora control;
    
    private Tabla tablaClientes2;
    private Tabla tablaTurnos;
    private DefaultTableModel modeloClientes2;
    private DefaultTableModel modeloTurnos;
    private Tabla tablaEmpleados;
    private DefaultTableModel modeloEmpleados;
    private Tabla tablaServicios;
    private DefaultTableModel modeloServicios;
    private Tabla tablaProductos;
    private DefaultTableModel modeloProductos;
    private Tabla tablaProveedores;
    private DefaultTableModel modeloProveedores;
    private Tabla tablaCaja;
    private DefaultTableModel modeloCaja;
    String currentUserRole2;
    int currentUserId2;
    
    
    /**
     * Creates new form Ventana
     */
    
    
    
    public Ventana(String role, int id) {
        initComponents();
        this.setVisible(true);
        this.setTitle("HY Peluquería");
        this.setSize(900,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        card = (CardLayout) mainPanel.getLayout();
        
        SwingUtilities.invokeLater(() -> {
            mainPanel.requestFocusInWindow();
        });
        
        
        
        
        control = new Controladora();
        
        
        this.currentUserRole2 = role;
        this.currentUserId2 = id;
        System.out.println(currentUserRole2);
        System.out.println(currentUserId2);
        
        //card.show(mainPanel, "Login1");
        card.show(mainPanel, "mainScreen");
        
        JButton btnlogout = new JButton("CERRAR SESIÓN");
        btnlogout.setBounds(11, sideMenu.getHeight() - 50, 150, 30);
        sideMenu.add(btnlogout);
        btnlogout.setContentAreaFilled(false);
        btnlogout.setBackground(Styles.bgDark2);
        btnlogout.setForeground(Styles.fontLight);
        btnlogout.setBorderPainted(false);
        btnlogout.setFont(Styles.fontBtn);
        
        
        btnlogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to execute when the button is clicked
                System.out.println("Logout button clicked");
                Login form = new Login();
                form.setVisible(true);
                form.setLocationRelativeTo(null);
                dispose();
            }
        });
        btnlogout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Code to execute when the mouse enters the button
                btnlogout.setForeground(Styles.fontLightHover);  // Example: Change the button's background color
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Code to execute when the mouse exits the button
                btnlogout.setForeground(Styles.fontLight);  // Reset the button's background color
            }
        });
        
        
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
        
        JLabel welc = new JLabel("Bienvenido", JLabel.CENTER);
        welc.setFont(Styles.fontTitleIt);
        cardWelcome.add(welc, BorderLayout.CENTER);
        
        
        /*UI MAIN SCREEN GESTIONES*/
        
        //CLIENTES
        
            
            TitlePanel titleCli = new TitlePanel("Clientes");
            cardClientes.add(titleCli, BorderLayout.NORTH);

            //crear panel contenedor para la tabla
            JPanel panelCenterCli = new JPanel(new BorderLayout()); 
            cardClientes.add(panelCenterCli, BorderLayout.CENTER);
            
            

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
            
            //Button btnUpdateCli = new Button("Actualizar");
            //btnPanelCli.add(btnUpdateCli);
            
            Button btnHistCli = new Button("Consultar Historial Cliente");
            btnHistCli.setPreferredSize(Styles.btnSize2);
            btnPanelCli.add(btnHistCli);
            
            //logica abrir form al clickear btn
            //abrir Form de alta
            btnNuevoCli.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    AltaClientes form = new AltaClientes();
                    
                    // Add a window listener to listen for close events
                    form.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            // This code will run after the form has closed
                            // Call the function you want here
                            cargarTablaClientes(panelCenterCli);
                        }
                    });
                    
                    form.setVisible(true);
                    form.setLocationRelativeTo(null);
                    
                }
            });
            //UPDATE
            /*
            btnUpdateCli.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cargarTablaClientes(panelCenterCli);
                    JOptionPane.showMessageDialog(null, "Tabla actualizada correctamente.", "Tabla actualizada.", JOptionPane.INFORMATION_MESSAGE);
                    
                }
            });*/
            
            
            
            
            
            //CREAR TABLA
            
            modeloClientes2 = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int col){return false;}
            };
            //INICIALIZAR TABLA
            String titulos2[] = {"ID","Nombre", "Apellido", "Telefono", "Genero"}; //modelo
            modeloClientes2.setColumnIdentifiers(titulos2); 
            //LOAD TABLE UPON LOADING PANEL
            cardClientes.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentShown(ComponentEvent e) {
                    cargarTablaClientes(panelCenterCli);
                }
            });
            
            tablaClientes2 = new Tabla(modeloClientes2);
            panelCenterCli.add(tablaClientes2, BorderLayout.CENTER);
            
            
            
            JTable tableClientes = tablaClientes2.getTable(); //useful para eliminar
            
            //ELIMINAR
            btnElimCli.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (modeloClientes2.getRowCount()>0){
                        if (tableClientes.getSelectedRow()!=-1){
                            int numCliente = Integer.parseInt(String.valueOf(tableClientes.getValueAt(tableClientes.getSelectedRow(),0)));
                            
                            if(control.checkIfClientReferenced(numCliente)){
                            JOptionPane.showMessageDialog(null, "No se puede eliminar el cliente porque tiene un turno asociado.", "No se puede eliminar.", JOptionPane.INFORMATION_MESSAGE);
                        
                            
                            }else{
                                control.borrarCliente(numCliente);
                                cargarTablaClientes(panelCenterCli);
                                // Show success message only if a record is deleted
                                JOptionPane.showMessageDialog(null, "Registro eliminado correctamente.", "Registro eliminado", JOptionPane.INFORMATION_MESSAGE);
                        
                            }
                        
                        } else {
                            JOptionPane.showMessageDialog(null, "Seleccione el registro que desea eliminar.", "Ninguna fila seleccionada", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La Tabla está vacía.", "Tabla vacía", JOptionPane.INFORMATION_MESSAGE);
                    }
                }   
            });
            
            //CONSULTAR HISTORIAL CLIENTE
            btnHistCli.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (modeloClientes2.getRowCount()>0){
                        if (tableClientes.getSelectedRow()!=-1){
                            int numCliente = Integer.parseInt(String.valueOf(tableClientes.getValueAt(tableClientes.getSelectedRow(),0)));
                        
                            
                            HistorialCliente form = new HistorialCliente();
                            form.setVisible(true);
                            form.setLocationRelativeTo(null);
                            
                            form.cargarTablaTurnos(numCliente);
                            
                        
                        
                        } else {
                            JOptionPane.showMessageDialog(null, "Seleccione el registro que desea consultar.", "Ninguna fila seleccionada", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La Tabla está vacía.", "Tabla vacía", JOptionPane.INFORMATION_MESSAGE);
                    }
                }   
            });
            
            //MODIFICAR
            btnModCli.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (modeloClientes2.getRowCount()>0){
                        if (tableClientes.getSelectedRow()!=-1){
                            //LOGICA MODIFICAR
                            int numCliente = Integer.parseInt(String.valueOf(tableClientes.getValueAt(tableClientes.getSelectedRow(),0)));
                        
                            //abrir form de modificacion
                            ModifClientes form = new ModifClientes(numCliente);
                            
                            form.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                // This code will run after the form has closed
                                // Call the function you want here
                                cargarTablaClientes(panelCenterCli);
                            }
                    });
                            
                            form.setVisible(true);
                            form.setLocationRelativeTo(null);
                            
                        
                            
                        } else {
                            JOptionPane.showMessageDialog(null, "Seleccione el registro que desea modificar.", "Ninguna fila seleccionada", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La Tabla está vacía.", "Tabla vacía", JOptionPane.INFORMATION_MESSAGE);
                    }
                }   
            });
            
            
            
        //TURNOS
            
            TitlePanel titleTur = new TitlePanel("Turnos");
            cardTurnos.add(titleTur, BorderLayout.NORTH);

            //crear tabla
            JPanel panelCenterTur = new JPanel(new BorderLayout()); //add flow layout center to this?
            cardTurnos.add(panelCenterTur, BorderLayout.CENTER);
            
            

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
            
            //Button btnUpdateTur = new Button("Actualizar");
            //btnPanelTur.add(btnUpdateTur);
            
            //logica abrir form al clickear btn
            btnNuevoTur.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    AltaTurnos form = new AltaTurnos();
                    
                    // Add a window listener to listen for close events
                    form.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            // This code will run after the form has closed
                            // Call the function you want here
                            cargarTablaTurnos(panelCenterTur);
                        }
                    });
                    
                    form.setVisible(true);
                    form.setLocationRelativeTo(null);
                }
            });
            
            //UPDATE
            /*
            btnUpdateTur.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cargarTablaTurnos(panelCenterTur);
                    //POPUP
                    JOptionPane.showMessageDialog(null, "Tabla actualizada correctamente.", "Tabla actualizada.", JOptionPane.INFORMATION_MESSAGE);
                }
            });*/
            
            
            
            
            
            //CREAR TABLA
            
            modeloTurnos = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int col){return col == 0;}
            };
            //INICIALIZAR TABLA
            
            String titulosTur[] = {"ID","Cliente", "Servicio", "Fecha","Horario", "Estado", "Detalle"}; //modelo
            modeloTurnos.setColumnIdentifiers(titulosTur); 
            
            cardTurnos.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentShown(ComponentEvent e) {
                    cargarTablaTurnos(panelCenterTur); //implementar funcion de carga
                }
            });
            
            tablaTurnos = new Tabla(modeloTurnos);
            panelCenterTur.add(tablaTurnos, BorderLayout.CENTER);
            cargarTablaTurnos(panelCenterTur);
            
            //ELIMINAR
            JTable tableTurnos = tablaTurnos.getTable();
            btnElimTur.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (modeloTurnos.getRowCount()>0){
                        if (tableTurnos.getSelectedRow()!=-1){
                            int numTurno = Integer.parseInt(String.valueOf(tableTurnos.getValueAt(tableTurnos.getSelectedRow(),0)));
                        
                            control.borrarTurno(numTurno);
                            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente.", "Registro eliminado.", JOptionPane.INFORMATION_MESSAGE);
                            cargarTablaTurnos(panelCenterTur);
                        }else{
                            JOptionPane.showMessageDialog(null, "Seleccione el registro que desea eliminar.", "Ninguna fila seleccionada", JOptionPane.INFORMATION_MESSAGE);
                        };
                    }else{
                        JOptionPane.showMessageDialog(null, "La Tabla esta vacia.", "Tabla vacia", JOptionPane.INFORMATION_MESSAGE);
                    };
                    
                }
                
                
            });
            
            
            //MODIFICAR
            btnModTur.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (modeloTurnos.getRowCount()>0){
                        if (tableTurnos.getSelectedRow()!=-1){
                            //LOGICA MODIFICAR
                            int numTurno = Integer.parseInt(String.valueOf(tableTurnos.getValueAt(tableTurnos.getSelectedRow(),0)));
                        
                            //abrir form de modificacion
                            ModifTurnos form = new ModifTurnos(numTurno);
                            
                            form.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                // This code will run after the form has closed
                                // Call the function you want here
                                cargarTablaTurnos(panelCenterTur);
                            }
                            });
                            
                            form.setVisible(true);
                            form.setLocationRelativeTo(null);
                            
                        
                            
                        } else {
                            JOptionPane.showMessageDialog(null, "Seleccione el registro que desea modificar.", "Ninguna fila seleccionada", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La Tabla está vacía.", "Tabla vacía", JOptionPane.INFORMATION_MESSAGE);
                    }
                }   
            });
            
            
            
            
        //SERVICIOS
            
            TitlePanel titleSer = new TitlePanel("Servicios");
            cardServicios.add(titleSer, BorderLayout.NORTH);

            //crear tabla
            JPanel panelCenterSer = new JPanel(new BorderLayout()); //add flow layout center to this?
            cardServicios.add(panelCenterSer , BorderLayout.CENTER);
            
            
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
            
            //TABLA
            modeloServicios = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int col){return false;}
            };
            //INICIALIZAR TABLA
            String titulosSer[] = {"ID","Nombre", "Precio", "Empleado"}; //modelo
            modeloServicios.setColumnIdentifiers(titulosSer); 
            
            cardServicios.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentShown(ComponentEvent e) {
                    cargarTablaServicios(panelCenterSer);
                }
            });
            
            tablaServicios = new Tabla(modeloServicios);
            panelCenterSer.add(tablaServicios, BorderLayout.CENTER);
            
            JTable tableServicios = tablaServicios.getTable(); //useful para eliminar
            
            
            //logica abrir form al clickear btn
            btnNuevoSer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    AltaServicios form = new AltaServicios();
                    
                    // Add a window listener to listen for close events
                    form.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            cargarTablaServicios(panelCenterSer);
                        }
                    });
                    
                    form.setVisible(true);
                    form.setLocationRelativeTo(null);
                }
            });
            
            //ELIMINAR
            btnElimSer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (modeloServicios.getRowCount()>0){
                        if (tableServicios.getSelectedRow()!=-1){
                            int numServicio = Integer.parseInt(String.valueOf(tableServicios.getValueAt(tableServicios.getSelectedRow(),0)));
                            
                            if(control.checkIfReferenced(numServicio)){
                                JOptionPane.showMessageDialog(null, "No se puede eliminar el servicio porque tiene turnos asociados.", "No se puede eliminar", JOptionPane.ERROR_MESSAGE);
                        
                            }else{
                               
                                control.borrarServicio(numServicio);
                                cargarTablaServicios(panelCenterSer); 
                                // Show success message only if a record is deleted
                                JOptionPane.showMessageDialog(null, "Registro eliminado correctamente.", "Registro eliminado", JOptionPane.INFORMATION_MESSAGE);
                        
                            }
                        
                        } else {
                            JOptionPane.showMessageDialog(null, "Seleccione el registro que desea eliminar.", "Ninguna fila seleccionada", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La Tabla está vacía.", "Tabla vacía", JOptionPane.INFORMATION_MESSAGE);
                    }
                }   
            });
            
            //MODIFICAR
            btnModSer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (modeloServicios.getRowCount()>0){
                        if (tableServicios.getSelectedRow()!=-1){
                            //LOGICA MODIFICAR
                            int numServicio = Integer.parseInt(String.valueOf(tableServicios.getValueAt(tableServicios.getSelectedRow(),0)));
                        
                            //abrir form de modificacion
                            ModifServicio form = new ModifServicio(numServicio);
                            
                            form.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                // This code will run after the form has closed
                                // Call the function you want here
                                cargarTablaServicios(panelCenterSer);
                            }
                    });
                            
                            form.setVisible(true);
                            form.setLocationRelativeTo(null);
                            
                        
                            
                        } else {
                            JOptionPane.showMessageDialog(null, "Seleccione el registro que desea modificar.", "Ninguna fila seleccionada", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La Tabla está vacía.", "Tabla vacía", JOptionPane.INFORMATION_MESSAGE);
                    }
                }   
            });
            
        //CAJA 
            TitlePanel titleCaja = new TitlePanel("Caja");
            cardCaja.add(titleCaja, BorderLayout.NORTH);

            //crear tabla
            JPanel panelCenterCaja = new JPanel(new BorderLayout()); //add flow layout center to this?
            cardCaja.add(panelCenterCaja , BorderLayout.CENTER);
            
            //Tabla tableCaja = new Tabla();
            //panelCenterCaja .add(tableCaja, BorderLayout.CENTER);

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
            
            btnNuevoCaja.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    AltaCaja form = new AltaCaja();
                    
                    // Add a window listener to listen for close events
                    form.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            // This code will run after the form has closed
                            // Call the function you want here
                            cargarTablaCaja(panelCenterCaja);
                        }
                    });
                    
                    form.setVisible(true);
                    form.setLocationRelativeTo(null);
                    
                }
            });
            
            //CREAR TABLA
            
            modeloCaja = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int col){return false;}
            };
            //INICIALIZAR TABLA
            String titulosCaja[] = {"ID","Tipo", "Monto", "Medio de Pago", "Detalle"}; //modelo
            modeloCaja.setColumnIdentifiers(titulosCaja); 
            //LOAD TABLE UPON LOADING PANEL
            cardCaja.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentShown(ComponentEvent e) {
                    cargarTablaCaja(panelCenterCaja);
                }
            });
            
            tablaCaja = new Tabla(modeloCaja);
            panelCenterCaja.add(tablaCaja, BorderLayout.CENTER);
            JTable tableCaja = tablaCaja.getTable(); //useful para eliminar
            
            //ELIMINAR
            btnElimCaja.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (modeloCaja.getRowCount()>0){
                        if (tableCaja.getSelectedRow()!=-1){
                            int numConcepto = Integer.parseInt(String.valueOf(tableCaja.getValueAt(tableCaja.getSelectedRow(),0)));
                        
                            control.borrarConcepto(numConcepto);
                            cargarTablaCaja(panelCenterCaja);
                        
                        // Show success message only if a record is deleted
                        JOptionPane.showMessageDialog(null, "Registro eliminado correctamente.", "Registro eliminado", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Seleccione el registro que desea eliminar.", "Ninguna fila seleccionada", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La Tabla está vacía.", "Tabla vacía", JOptionPane.INFORMATION_MESSAGE);
                    }
                }   
            });
            
            //MODIFICAR
            btnModCaja.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (modeloCaja.getRowCount()>0){
                        if (tableCaja.getSelectedRow()!=-1){
                            //LOGICA MODIFICAR
                            int numConcepto = Integer.parseInt(String.valueOf(tableCaja.getValueAt(tableCaja.getSelectedRow(),0)));
                        
                            //abrir form de modificacion
                            ModifCaja form = new ModifCaja(numConcepto);
                            
                            form.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                // This code will run after the form has closed
                                // Call the function you want here
                                cargarTablaCaja(panelCenterCaja);
                            }
                    });
                            
                            form.setVisible(true);
                            form.setLocationRelativeTo(null);
                            
                        
                            
                        } else {
                            JOptionPane.showMessageDialog(null, "Seleccione el registro que desea modificar.", "Ninguna fila seleccionada", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La Tabla está vacía.", "Tabla vacía", JOptionPane.INFORMATION_MESSAGE);
                    }
                }   
            });
            
            
        //PROVEEDORES
            TitlePanel titleProv = new TitlePanel("Proveedores");
            cardProveedores.add(titleProv, BorderLayout.NORTH);

            //crear tabla
            JPanel panelCenterProv = new JPanel(new BorderLayout()); //add flow layout center to this?
            cardProveedores.add(panelCenterProv, BorderLayout.CENTER);
            
            //Tabla tableProv = new Tabla();
            //panelCenterProv .add(tableProv, BorderLayout.CENTER);

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
                    
                    form.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                // This code will run after the form has closed
                                // Call the function you want here
                                cargarTablaProveedores(panelCenterProv);
                            }
                    });
                    
                    form.setVisible(true);
                    form.setLocationRelativeTo(null);
                }
            });
            
            //CREAR TABLA
            
            modeloProveedores = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int col){return false;}
            };
            //INICIALIZAR TABLA
            String titulosProv[] = {"ID","Nombre", "Correo", "Telefono"}; //modelo
            modeloProveedores.setColumnIdentifiers(titulosProv); 
            
            //LOAD TABLE UPON LOADING PANEL
            cardProveedores.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentShown(ComponentEvent e) {
                    cargarTablaProveedores(panelCenterProv);
                }
            });
            
            tablaProveedores = new Tabla(modeloProveedores);
            panelCenterProv.add(tablaProveedores, BorderLayout.CENTER);
            
            
            
            JTable tableProveedores = tablaProveedores.getTable(); //useful para eliminar
            
            btnElimProv.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (modeloProveedores.getRowCount()>0){
                        if (tableProveedores.getSelectedRow()!=-1){
                            int numProv = Integer.parseInt(String.valueOf(tableProveedores.getValueAt(tableProveedores.getSelectedRow(),0)));
                        
                            control.borrarProveedor(numProv);
                            cargarTablaProveedores(panelCenterProv);
                        
                        // Show success message only if a record is deleted
                        JOptionPane.showMessageDialog(null, "Registro eliminado correctamente.", "Registro eliminado", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Seleccione el registro que desea eliminar.", "Ninguna fila seleccionada", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La Tabla está vacía.", "Tabla vacía", JOptionPane.INFORMATION_MESSAGE);
                    }
                }   
            });
            
            //modif
            btnModProv.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (modeloProveedores.getRowCount()>0){
                        if (tableProveedores.getSelectedRow()!=-1){
                            //LOGICA MODIFICAR
                            int numProv = Integer.parseInt(String.valueOf(tableProveedores.getValueAt(tableProveedores.getSelectedRow(),0)));
                        
                            //abrir form de modificacion
                            ModifProveedores form = new ModifProveedores(numProv);
                            
                            form.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                // This code will run after the form has closed
                                // Call the function you want here
                                cargarTablaProveedores(panelCenterProv);
                            }
                    });
                            
                            form.setVisible(true);
                            form.setLocationRelativeTo(null);
                            
                        
                            
                        } else {
                            JOptionPane.showMessageDialog(null, "Seleccione el registro que desea modificar.", "Ninguna fila seleccionada", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La Tabla está vacía.", "Tabla vacía", JOptionPane.INFORMATION_MESSAGE);
                    }
                }   
            });
            
            
            
        //INVENTARIO
            TitlePanel titleInv = new TitlePanel("Inventario");
            cardInventario.add(titleInv, BorderLayout.NORTH);

            //crear tabla
            JPanel panelCenterInv = new JPanel(new BorderLayout()); //add flow layout center to this?
            cardInventario.add(panelCenterInv , BorderLayout.CENTER);
            
            //Tabla tableInv = new Tabla();
            //panelCenterInv .add(tableInv, BorderLayout.CENTER);

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
            
            //logica abrir form al clickear btn
            btnNuevoInv.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    AltaProductos form = new AltaProductos();
                    
                    form.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                // This code will run after the form has closed
                                // Call the function you want here
                                cargarTablaProductos(panelCenterInv);
                            }
                        });
                    
                    form.setVisible(true);
                    form.setLocationRelativeTo(null);
                }
            });
            
            
             //CREAR TABLA
            
            modeloProductos = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int col){return false;}
            };
            //INICIALIZAR TABLA
            String titulosProductos[] = {"ID","Nombre", "Stock", "Minimo", "Proveedor"}; //modelo
            modeloProductos.setColumnIdentifiers(titulosProductos); 
            //LOAD TABLE UPON LOADING PANEL
            cardInventario.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentShown(ComponentEvent e) {
                    cargarTablaProductos(panelCenterInv);
                }
            });
            
            tablaProductos = new Tabla(modeloProductos);
            panelCenterInv.add(tablaProductos, BorderLayout.CENTER);
            
            
            JTable tableProductos = tablaProductos.getTable(); //useful para eliminar
            //eliminar
            btnElimInv.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (modeloProductos.getRowCount()>0){
                        if (tableProductos.getSelectedRow()!=-1){
                            int numProducto = Integer.parseInt(String.valueOf(tableProductos.getValueAt(tableProductos.getSelectedRow(),0)));
                        
                            control.borrarProducto(numProducto);
                            cargarTablaProductos(panelCenterInv);
                        
                        // Show success message only if a record is deleted
                        JOptionPane.showMessageDialog(null, "Registro eliminado correctamente.", "Registro eliminado", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Seleccione el registro que desea eliminar.", "Ninguna fila seleccionada", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La Tabla está vacía.", "Tabla vacía", JOptionPane.INFORMATION_MESSAGE);
                    }
                }   
            });
            //modif
            
            btnModInv.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (modeloProductos.getRowCount()>0){
                        if (tableProductos.getSelectedRow()!=-1){
                            //LOGICA MODIFICAR
                            int numProd = Integer.parseInt(String.valueOf(tableProductos.getValueAt(tableProductos.getSelectedRow(),0)));
                        
                            //abrir form de modificacion
                            ModifProducto form = new ModifProducto(numProd);
                            
                            form.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                // This code will run after the form has closed
                                // Call the function you want here
                                cargarTablaProductos(panelCenterInv);
                            }
                    });
                            
                            form.setVisible(true);
                            form.setLocationRelativeTo(null);
                            
                        
                            
                        } else {
                            JOptionPane.showMessageDialog(null, "Seleccione el registro que desea modificar.", "Ninguna fila seleccionada", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La Tabla está vacía.", "Tabla vacía", JOptionPane.INFORMATION_MESSAGE);
                    }
                }   
            });
            
        
        //EMPLEADOS
        
            TitlePanel titleEmp= new TitlePanel("Empleados");
            cardEmpleados.add(titleEmp, BorderLayout.NORTH);

            //crear tabla
            JPanel panelCentral = new JPanel(new BorderLayout()); //add flow layout center to this?
            cardEmpleados.add(panelCentral, BorderLayout.CENTER);
            

            //btn alta
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            buttonPanel.setBorder(new EmptyBorder(0, 0, 40, 0));

            cardEmpleados.add(buttonPanel, BorderLayout.SOUTH);
            buttonPanel.setBackground(Styles.bgLight);
            
            Button btnNuevoEmp = new Button("Nuevo");
            buttonPanel.add(btnNuevoEmp);
            
            //abrir Form de alta
            btnNuevoEmp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    String currentRol = control.getLoggedInUserRole();
                    
                    if ("Administrador".equalsIgnoreCase(currentUserRole2)) {
                        
                        AltaEmpleados form = new AltaEmpleados();
                        // Add a window listener to listen for close events
                        form.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                // This code will run after the form has closed
                                // Call the function you want here
                                cargarTablaEmpleados(panelCentral);
                            }
                        });

                        //if current user rol = empleado, show an error message
                        form.setVisible(true);
                        form.setLocationRelativeTo(null);
                    }else{
                        JOptionPane.showMessageDialog(null, "Solo el Administrador puede dar de alta nuevos empleados.", "No permitido", JOptionPane.INFORMATION_MESSAGE);
                    };
                    
                }
            });

            //btn modificar
            Button btnModEmp = new Button("Editar");
            buttonPanel.add(btnModEmp);

            //btn eliminar
            Button btnElimEmp = new Button("Eliminar");
            buttonPanel.add(btnElimEmp);
            
            //CREAR TABLA
            
            modeloEmpleados = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int col){return false;}
            };
            
            //INICIALIZAR TABLA
            String titulosEmp[] = {"ID","Usuario","Nombre", "Apellido", "Telefono", "Rol"}; //modelo
            modeloEmpleados.setColumnIdentifiers(titulosEmp); 
            
            cardEmpleados.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentShown(ComponentEvent e) {
                    cargarTablaEmpleados(panelCentral);
                }
            });
            
            tablaEmpleados = new Tabla(modeloEmpleados);
            panelCentral.add(tablaEmpleados, BorderLayout.CENTER);
            
            //LOAD TABLE UPON LOADING PANEL
            
            JTable tableEmpleados = tablaEmpleados.getTable(); //useful para eliminar
            
            
            
            
            //ELIMINAR USUARIO
            btnElimEmp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    
                    String currentRol = control.getLoggedInUserRole();
                    
                    if ("Administrador".equalsIgnoreCase(currentUserRole2)) {
                        
                        if (modeloEmpleados.getRowCount()>0){
                            if (tableEmpleados.getSelectedRow()!=-1){
                                int numEmpleado = Integer.parseInt(String.valueOf(tableEmpleados.getValueAt(tableEmpleados.getSelectedRow(),0)));
                                int currentUserId = control.getLoggedInUserId();

                                if (numEmpleado == currentUserId2) {
                                    //chequear que el num a elminar no coincida con el user loggeado
                                    JOptionPane.showMessageDialog(null, "No se puede eliminar el usuario porque la sesión está iniciada.", "Error", JOptionPane.ERROR_MESSAGE);

                                } else {
                                    if(control.checkIfUsuReferenced(numEmpleado)){
                                        JOptionPane.showMessageDialog(null, "No se puede eliminar el usuario porque tiene un servicio asignado.", "Error", JOptionPane.ERROR_MESSAGE);

                                    }else{
                                        control.borrarUsuario(numEmpleado);
                                        cargarTablaEmpleados(panelCentral);
                                        // Show success message only if a record is deleted
                                        JOptionPane.showMessageDialog(null, "Registro eliminado correctamente.", "Registro eliminado", JOptionPane.INFORMATION_MESSAGE);

                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Seleccione el registro que desea eliminar.", "Ninguna fila seleccionada", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "La Tabla está vacía.", "Tabla vacía", JOptionPane.INFORMATION_MESSAGE);
                        }
                        
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "Solo el Administrador puede eliminar empleados.", "No permitido", JOptionPane.INFORMATION_MESSAGE);
                    };
                    
                    
                    
                }   
            });
            
            
            //MODIFICAR
            btnModEmp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    String currentRol = control.getLoggedInUserRole();
                    
                    if ("Administrador".equalsIgnoreCase(currentUserRole2)) {
                        
                        if (modeloEmpleados.getRowCount()>0){
                            if (tableEmpleados.getSelectedRow()!=-1){
                                //LOGICA MODIFICAR
                                int numEmpleado = Integer.parseInt(String.valueOf(tableEmpleados.getValueAt(tableEmpleados.getSelectedRow(),0)));

                                //abrir form de modificacion
                                ModifEmpleado form = new ModifEmpleado(numEmpleado);

                                form.addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowClosed(WindowEvent e) {
                                    // This code will run after the form has closed
                                    // Call the function you want here
                                    cargarTablaEmpleados(panelCentral);
                                }
                        });

                                form.setVisible(true);
                                form.setLocationRelativeTo(null);



                            } else {
                                JOptionPane.showMessageDialog(null, "Seleccione el registro que desea modificar.", "Ninguna fila seleccionada", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "La Tabla está vacía.", "Tabla vacía", JOptionPane.INFORMATION_MESSAGE);
                        }
                        
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "Solo el Administrador puede modificar datos de empleados.", "No permitido", JOptionPane.INFORMATION_MESSAGE);
                    };
                    
                    
                    
                    
                }   
            });
        
        
        
        /*LOGO LOGIN*/
        
        
        setupLoginPanel();
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
        cardWelcome = new javax.swing.JPanel();
        cardTurnos = new javax.swing.JPanel();
        cardClientes = new javax.swing.JPanel();
        cardEmpleados = new javax.swing.JPanel();
        cardInventario = new javax.swing.JPanel();
        cardProveedores = new javax.swing.JPanel();
        cardCaja = new javax.swing.JPanel();
        cardServicios = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

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
        btnLogin1.setFocusPainted(false);
        btnLogin1.setName("btnLogin"); // NOI18N
        btnLogin1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnLogin1FocusGained(evt);
            }
        });
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
        txtUser1.setText("Ingrese su nombre de usuario");
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
        txtPassword2.setText("contraseña");
        txtPassword2.setName(""); // NOI18N
        txtPassword2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPassword2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPassword2FocusLost(evt);
            }
        });

        lblLogin1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblLogin1.setForeground(new java.awt.Color(51, 51, 51));
        lblLogin1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogin1.setText("Iniciar Sesión");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtPassword2)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblUser1)
                        .addComponent(lblPass1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblLogin1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogin1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(114, Short.MAX_VALUE))
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
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        Login1Layout.setVerticalGroup(
            Login1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 574, Short.MAX_VALUE)
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
                .addContainerGap(95, Short.MAX_VALUE))
        );

        panelMain.setBackground(new java.awt.Color(250, 250, 250));
        panelMain.setPreferredSize(new java.awt.Dimension(800, 500));
        panelMain.setLayout(new java.awt.CardLayout());

        cardWelcome.setBackground(new java.awt.Color(250, 250, 250));
        cardWelcome.setLayout(new java.awt.BorderLayout());
        panelMain.add(cardWelcome, "cardTurnos");

        cardTurnos.setBackground(new java.awt.Color(250, 250, 250));
        cardTurnos.setLayout(new java.awt.BorderLayout());
        panelMain.add(cardTurnos, "cardTurnos");

        cardClientes.setBackground(new java.awt.Color(250, 250, 250));
        cardClientes.setLayout(new java.awt.BorderLayout());
        panelMain.add(cardClientes, "cardClientes");

        cardEmpleados.setBackground(new java.awt.Color(250, 250, 250));
        cardEmpleados.setLayout(new java.awt.BorderLayout());
        panelMain.add(cardEmpleados, "cardEmpleados");

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

        javax.swing.GroupLayout mainScreenLayout = new javax.swing.GroupLayout(mainScreen);
        mainScreen.setLayout(mainScreenLayout);
        mainScreenLayout.setHorizontalGroup(
            mainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainScreenLayout.createSequentialGroup()
                .addComponent(sideMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE))
        );
        mainScreenLayout.setVerticalGroup(
            mainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sideMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
         btnLogin1.setFocusPainted(false); // Remove the focus border
        btnLogin1.setBorder(BorderFactory.createEmptyBorder()); // Remove any border

        String user = txtUser1.getText();
        String pass = txtPassword2.getText();

        int userId = control.validarUsuario2(user, pass);

        if (userId != -1) {
            control.setLoggedInUserId(userId); // Store the logged-in user ID
            //store the current users role
            String role = control.getUserRole(userId); // Retrieve and store user role
            control.setLoggedInUserRole(role);

            // Switch to the main screen
            card = (CardLayout) this.mainPanel.getLayout();
            card.show(mainPanel, "mainScreen");
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.", "Login", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnLogin1ActionPerformed

    private void txtUser1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUser1FocusGained
        if(txtUser1.getText().equals("Ingrese su nombre de usuario")){
            txtUser1.setText("");
            txtUser1.setForeground(Styles.fontDark);
        }
        
    }//GEN-LAST:event_txtUser1FocusGained

    private void txtUser1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUser1FocusLost
       if (txtUser1.getText().isEmpty()){
           txtUser1.setText("Ingrese su nombre de usuario");
           txtUser1.setForeground(Styles.fontGreyDark);
       }
    }//GEN-LAST:event_txtUser1FocusLost

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //
    }//GEN-LAST:event_formWindowOpened

    private void txtPassword2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassword2FocusGained
        if(txtPassword2.getText().equals("contraseña")){
            txtPassword2.setText("");
            txtPassword2.setForeground(Styles.fontDark);
        }
    }//GEN-LAST:event_txtPassword2FocusGained

    private void txtPassword2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassword2FocusLost
        if (txtPassword2.getText().isEmpty()){
           txtPassword2.setText("contraseña");
           txtPassword2.setForeground(Styles.fontGreyLight);
       }
    }//GEN-LAST:event_txtPassword2FocusLost

    private void btnLogin1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnLogin1FocusGained
        btnLogin1.setFocusPainted(false); // Remove the focus border
        btnLogin1.setBorder(BorderFactory.createEmptyBorder()); // Remove any border

    }//GEN-LAST:event_btnLogin1FocusGained
 
    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana(currentUserRole2, currentUserId2).setVisible(true);
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
    private javax.swing.JPanel cardWelcome;
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

    
    //UI
    public void panelSetup(String titulo, JPanel card){
        //titulo, panel norte
        TitlePanel title = new TitlePanel(titulo);
        card.add(title, BorderLayout.NORTH);
        
        //panel para la tabla
        JPanel panelTabla = new JPanel(new BorderLayout());
        
        //panel de botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(new EmptyBorder(0, 0, 40, 0));
        card.add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setBackground(Styles.bgLight);
        
        Button btn = new Button("Action");
        
    
    }



    //CARGAR TABLAS
        private void cargarTablaClientes(JPanel panel) {
            modeloClientes2.setRowCount(0); // Clear existing data in the model

            List<Cliente> listaClientes = control.traerClientes(); // Fetch updated client list

            if (listaClientes != null) {
                for (Cliente cli : listaClientes) {
                    Object[] objeto = {cli.getId(),cli.getNombre(), cli.getApellido(), cli.getTelefono(), cli.getGenero()};
                    modeloClientes2.addRow(objeto); // Add new data to the model
                }
            }

            panel.revalidate(); // Refresh the panel to reflect changes
            panel.repaint(); // Repaint the panel
        }

        private void cargarTablaTurnos(JPanel panel) {
            modeloTurnos.setRowCount(0); // Clear existing data in the model

            List<Turno> listaTurnos = control.traerTurnos(); // Fetch updated turno list



            if (listaTurnos != null) {
                for (Turno tur : listaTurnos) {
                    
                    Cliente cli= tur.getCliente();
                    String nombreCliente;
                    
                    LocalDateTime fecha = tur.getFecha();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                    
                    String fechaformateada = fecha.format(formatter);
                    
                    // Split the formatted date-time string into date and time parts
                    String[] partesFecha = fechaformateada.split(" ");

                    // Assign the date and time to separate variables
                    String fechaParte = partesFecha[0];  // The date part (e.g., "06-11-2024")
                    String horaParte = partesFecha[1];
                    
                    Servicio serv = tur.getServicio();
                    String nombreServ;
                    if (serv != null){
                    
                        nombreServ = serv.getNombre();
                    }else{
                        nombreServ = "";
                    }
                    
                    
                    if (cli != null) {
                        nombreCliente = cli.getNombre() + " " + cli.getApellido();
                    } else {
                        nombreCliente = "No asignado"; // Or any default message when cliente is null
                    }
                    Object[] objeto = { tur.getId(),nombreCliente, nombreServ, fechaParte, horaParte, tur.getEstado(), tur.getDetalle()};
                    modeloTurnos.addRow(objeto); // Add new data to the model
                }
            }

            panel.revalidate(); // Refresh the panel to reflect changes
            panel.repaint(); // Repaint the panel
        }
        
        private void cargarTablaEmpleados(JPanel panel) {
            modeloEmpleados.setRowCount(0); // Clear existing data in the model

            List<Usuario> listaEmpleados = control.traerUsuarios(); // Fetch updated client list

            if (listaEmpleados != null) {
                for (Usuario emp : listaEmpleados) {
                    Object[] objeto = {emp.getId(),emp.getUsername(), emp.getNombre(), emp.getApellido(), emp.getTelefono(), emp.getRol()};
                    modeloEmpleados.addRow(objeto); // Add new data to the model
                }
            }

            panel.revalidate(); // Refresh the panel to reflect changes
            panel.repaint(); // Repaint the panel
        }
        
        private void cargarTablaServicios(JPanel panel) {
            modeloServicios.setRowCount(0); // Clear existing data in the model

            List<Servicio> listaServicios = control.traerServicios(); // Fetch updated client list

            if (listaServicios != null) {
                for (Servicio ser : listaServicios) {
                    
                    Usuario emp = ser.getEmpleado();
                    
                    String nombre = emp.getNombre() + " " + emp.getApellido();
                    
                    Object[] objeto = {ser.getId(),ser.getNombre(), ser.getPrecio(), nombre};
                    modeloServicios.addRow(objeto); // Add new data to the model
                }
            }

            panel.revalidate(); // Refresh the panel to reflect changes
            panel.repaint(); // Repaint the panel
        }
        
        private void cargarTablaProductos(JPanel panel) {
            modeloProductos.setRowCount(0); // Clear existing data in the model

            List<Producto> listaProductos = control.traerProductos(); // Fetch updated client list
            
            //guardar nombre Producto.getproveedor en un string
            
            if (listaProductos != null) {
                for (Producto prod : listaProductos) {
                    
                    Proveedor prov= prod.getProveedor();
                    String nombreProveedor;

                    if (prov != null) {
                        nombreProveedor = prov.getNombre();
                    } else {
                        nombreProveedor = "No asignado"; // Or any default message when cliente is null
                    }
                    
                    
                    Object[] objeto = {prod.getId(),prod.getNombre(), prod.getStock(), prod.getMinimo(), nombreProveedor};
                    modeloProductos.addRow(objeto); // Add new data to the model
                }
            }

            panel.revalidate(); // Refresh the panel to reflect changes
            panel.repaint(); // Repaint the panel
        }
        
        private void setupLoginPanel(){

                /*LOGO LOGIN*/

            JLabel lblLogo = new JLabel("HECTOR");
            lblLogo.setBounds(128, 190, 250, 70); 
            lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
            jLayeredPane2.add(lblLogo, JLayeredPane.PALETTE_LAYER);
            lblLogo.setFont(Styles.customFontXl);
            lblLogo.setForeground(Styles.fontLight);

            JLabel lblLogo2 = new JLabel("YAGUSZ");
            lblLogo2.setBounds(128, 235, 250, 70); 
            lblLogo2.setHorizontalAlignment(SwingConstants.CENTER);
            jLayeredPane2.add(lblLogo2, JLayeredPane.PALETTE_LAYER);
            lblLogo2.setFont(Styles.customFontXl);
            lblLogo2.setForeground(Styles.fontLight);

            JLabel lblLogo3 = new JLabel(" P   E   L   U   Q   U   E   R   I   A");
            lblLogo3.setBounds(128, 270, 250, 70); 
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
            
            jLayeredPane2.revalidate();
            jLayeredPane2.repaint();
            
        }
        
        private void cargarTablaProveedores(JPanel panel) {
            modeloProveedores.setRowCount(0); // Clear existing data in the model

            List<Proveedor> listaProveedores = control.traerProveedores(); // Fetch updated client list
            
            //guardar nombre Producto.getproveedor en un string
            
            if (listaProveedores != null) {
                for (Proveedor prov : listaProveedores) {
                    
                    Object[] objeto = {prov.getId(),prov.getNombre(), prov.getEmail(), prov.getTelefono()};
                    modeloProveedores.addRow(objeto); // Add new data to the model
                }
            }

            panel.revalidate(); // Refresh the panel to reflect changes
            panel.repaint(); // Repaint the panel
        }
        
        private void cargarTablaCaja(JPanel panel) {
            modeloCaja.setRowCount(0); // Clear existing data in the model

            List<Caja> listaCaja = control.traerConceptos(); // Fetch updated client list
            
            //guardar nombre Producto.getproveedor en un string
            
            if (listaCaja != null) {
                for (Caja caja : listaCaja) {
                    
                    Object[] objeto = {caja.getId(),caja.getTipo(), caja.getMonto(), caja.getMedio(),caja.getDetalle()};
                    modeloCaja.addRow(objeto); // Add new data to the model
                }
            }

            panel.revalidate(); // Refresh the panel to reflect changes
            panel.repaint(); // Repaint the panel
        }
        
        public String formatFecha(LocalDateTime fecha) {
        // Define the format for the output string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        
        // Format and return the LocalDateTime as a string
        return fecha.format(formatter);
        }
//FIN
}
    
    
    
    

