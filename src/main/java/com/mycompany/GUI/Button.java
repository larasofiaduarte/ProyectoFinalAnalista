
package com.mycompany.GUI;

import com.mycompany.GUI.Styles;

import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;

public class Button extends JButton {
    public Button(String text) {
        super(text);
        setPreferredSize(Styles.btnSize); // Set the preferred size
        setBackground(Styles.accentDark);
        setForeground(Styles.fontLight);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setOpaque(true);
        setFont(Styles.fontBtn);
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(Styles.accentLightHover); // Change background on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(Styles.accentDark); // Reset background when not hovering
            }
        });
        
    }
}