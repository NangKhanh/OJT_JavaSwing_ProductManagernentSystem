/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author hp
 */
public class ImageRenderer extends DefaultTableCellRenderer {

    @Override
    public void setValue(Object value) {
        if (value instanceof ImageIcon) {
            ImageIcon imageIcon = (ImageIcon) value;
            Image image = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            setIcon(new ImageIcon(image));
            setText(null);
        } else {
            setIcon(null);
            setText(value != null ? value.toString() : "");
        }
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setValue(value);
        return this;
    }
}
