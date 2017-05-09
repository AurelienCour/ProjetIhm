package edu.ihm.renderer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class ImageCellRenderer extends DefaultTableCellRenderer {
 
    public ImageCellRenderer() {
        super();
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }
 
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if(value instanceof URL){
        	URL url = (URL) value;
            setText("");
            ImageIcon ic = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
            setIcon(ic);
            setBackground(Color.lightGray);
        }
        else if(value instanceof String){
        	this.setFont(new Font("Arial", Font.PLAIN, 20));
        	if(value.toString().equals("Corrigé")){
        		setForeground(Color.blue);
        	}
        	else if(value.toString().equals("A faire")){
        		setForeground(Color.red);
        	}
        	else if(value.toString().equals("Fait")){
        		setForeground(Color.green);
        	}
        	else
        		setForeground(Color.black);
        }
        return this;
    }
}
