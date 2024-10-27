
package com.mycompany.GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class Tabla extends JPanel {
    
    private JTable table;

    public Tabla(DefaultTableModel model) {
        // Create a JTable with a DefaultTableModel (empty)
        table = new JTable(model);
       
        
        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(null);
        
        // Set the layout of the panel and add the scroll pane
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        
        // Optional: Set preferred size for the table panel
        setPreferredSize(new Dimension(400, 300));// Adjust size as needed
    }
}
