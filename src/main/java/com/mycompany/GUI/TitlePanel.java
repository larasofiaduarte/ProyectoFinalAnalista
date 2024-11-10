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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;

public class TitlePanel extends JPanel {
    private JTextField search;
    private TableRowSorter<?> sorter;

    public TitlePanel(String title) {
        setLayout(new BorderLayout());
        setBorder(Styles.padding);
        setBackground(Styles.bgLight);

        // Create the title label
        JLabel lblTitle = new JLabel(title, SwingConstants.CENTER);
        lblTitle.setFont(Styles.fontTitle);
        lblTitle.setForeground(Styles.fontDark);

        // Add the title label to the panel
        add(lblTitle, BorderLayout.WEST);

        // Create the search field
        search = new JTextField("Buscar");
        search.setPreferredSize(new Dimension(220, 40));
        add(search, BorderLayout.EAST);
        
        search.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Clear placeholder text when the field gains focus
                if (search.getText().equals("Buscar")) {
                    search.setText("");
                    search.setForeground(Color.BLACK); // Optional: Set text color to normal
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Reset placeholder text if the field is empty when it loses focus
                if (search.getText().isEmpty()) {
                    search.setText("Buscar");
                    search.setForeground(Color.GRAY); // Optional: Set placeholder color
                }
            }
        });
        
    }

    // Method to set the table and apply the search functionality
    public void setTable(JTable table) {
        sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);

        // Add a DocumentListener to filter table rows based on search text
        search.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterTable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterTable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterTable();
            }
        });
    }

    // Method to filter table rows based on search text
    private void filterTable() {
        String text = search.getText();
        if (text.trim().length() == 0) {
            sorter.setRowFilter(null); // Show all rows if search is empty
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text)); // Filter rows by search text, case-insensitive
        }
    }
}