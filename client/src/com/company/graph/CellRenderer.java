package com.company.graph;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CellRenderer extends DefaultTableCellRenderer {

    String login;

    public CellRenderer(String login){
        this.login = login;

    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (table.getValueAt(row, 12).equals(this.login)){
            cell.setBackground(new Color(167, 243, 153));

        }
        else{
            cell.setBackground(new Color(239, 108, 108));
        }
        return cell;

    }

}
