/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import com.mycompany.GUI.Styles;

public class TitlePanel extends JPanel {
    public TitlePanel(String title){
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBorder(Styles.padding);
        setBackground(Styles.bgLight);
        
        //crear lbl titulo
        JLabel lblTitle = new JLabel(title, SwingConstants.CENTER);
        lblTitle.setFont(Styles.fontTitle);
        lblTitle.setForeground(Styles.fontDark);

        //agregar lbl titulo a panel 
        add(lblTitle);
        
    }
}
