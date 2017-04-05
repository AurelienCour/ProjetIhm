package edu.ihm.liste_eleve_prof;

import java.awt.Component;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ImageCellRenderer extends DefaultTableCellRenderer {
 
    public ImageCellRenderer() {
        super();
    }
 
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        URL ur = (URL) value;
        setText("");
        ImageIcon ic = new ImageIcon(new ImageIcon(ur).getImage().getScaledInstance(60, 50, Image.SCALE_DEFAULT));
        setIcon(ic);
        return this;
    }
}
