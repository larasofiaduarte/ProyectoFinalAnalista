/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.GUI;

import javax.swing.table.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import com.mycompany.proyectofinal.Turno;
import com.mycompany.proyectofinal.Turno;
import java.util.List;


/**
 *
 * @author duart
 */
class CustomTableModel extends DefaultTableModel {
    private List<Turno> listaTurnos;  // Use List<Turno> as the type

    public CustomTableModel(List<Turno> listaTurnos, Object[] columnNames) {
        super(columnNames, 0);
        this.listaTurnos = listaTurnos;
    }

    @Override
    public int getRowCount() {
        return listaTurnos.size();
    }

    @Override
    public int getColumnCount() {
        return 7; // Assuming 7 columns: ID, Cliente, Servicio, Fecha, Hora, Estado, Detalle
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Turno turno = listaTurnos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return turno.getId();
            case 1:
                return turno.getCliente() != null ? turno.getCliente().getNombre() + " " + turno.getCliente().getApellido() : "No asignado";
            case 2:
                return turno.getServicio();
            case 3:
                return turno.getFecha().toLocalDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            case 4:
                return turno.getFecha().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"));
            case 5:
                return turno.getEstado();
            case 6:
                return turno.getDetalle();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Turno turno = listaTurnos.get(rowIndex);
        if (columnIndex == 0) {
            // When the checkbox is clicked, update the Estado value
            if (aValue instanceof Boolean) {
                boolean isChecked = (Boolean) aValue;
                if (isChecked) {
                    turno.setEstado("Finished");  // Set to "Finished" when checked
                } else {
                    turno.setEstado("Pending");  // Set to "Pending" when unchecked
                }
            }
        }
        // Notify that the table cell has been updated
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column == 0;  // Make only the checkbox column editable
    }
}
