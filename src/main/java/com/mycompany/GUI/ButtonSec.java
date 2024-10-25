/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 *
 * @author duart
 */
public class ButtonSec extends JButton {
    public ButtonSec(String text) {
        super(text);
        setPreferredSize(Styles.btnSize); // Set the preferred size
        setBackground(Styles.bgLight);
        setForeground(Styles.fontDark);
        setContentAreaFilled(false);
        setBorderPainted(true);
        setBorder(BorderFactory.createLineBorder(Styles.bgGreyDark, 2));
        setOpaque(true);
        setFont(Styles.fontBtn);
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(Styles.bgGreyLight); // Change background on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(Styles.bgLight); // Reset background when not hovering
            }
        });
        
    }
}
