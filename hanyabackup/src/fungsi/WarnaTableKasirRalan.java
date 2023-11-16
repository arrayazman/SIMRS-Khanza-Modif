/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fungsi;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Owner
 */
public class WarnaTableKasirRalan extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (row % 2 == 1){
            component.setBackground(new Color(255,244,244));
            component.setForeground(new Color(50,50,50));
        }else{
            component.setBackground(new Color(255,255,255));
            component.setForeground(new Color(50,50,50));
        } 
        
        // untuk rawat jalan
        if(table.getValueAt(row,10).toString().equals("Sudah")){
            component.setBackground(new Color(40, 180, 99));
            component.setForeground(new Color(255,230,230));
        }else if(table.getValueAt(row,10).toString().equals("Batal")){
            component.setBackground(new Color(243, 156, 18));
            component.setForeground(new Color(50,50,50));
        }else if(table.getValueAt(row,10).toString().equals("Dirujuk")||table.getValueAt(row,10).toString().equals("Pulang Paksa")){
            component.setBackground(new Color(210, 180, 222));
            component.setForeground(new Color(245,245,255));
        }else if(table.getValueAt(row,10).toString().equals("Meninggal")){
            component.setBackground(new Color(50,50,50));
            component.setForeground(new Color(245,255,245));
        }else if(table.getValueAt(row,10).toString().equals("Dirawat")){
            component.setBackground(new Color(52, 152, 219));
            component.setForeground(new Color(245,255,245));
        }
        if(table.getValueAt(row,15).toString().equals("Sudah Bayar")){
            component.setBackground(new Color(29, 131, 72 ));
            component.setForeground(new Color(245,245,255));
        }
        
        
        //untuk igd
        
        if(table.getValueAt(row,18).toString().equals("Sudah")){
            component.setBackground(new Color(40, 180, 99));
            component.setForeground(new Color(255,230,230));
        }else if(table.getValueAt(row,18).toString().equals("Batal")){
            component.setBackground(new Color(243, 156, 18));
            component.setForeground(new Color(50,50,50));
        }else if(table.getValueAt(row,18).toString().equals("Dirujuk")||table.getValueAt(row,18).toString().equals("Pulang Paksa")){
            component.setBackground(new Color(210, 180, 222));
            component.setForeground(new Color(245,245,255));
        }else if(table.getValueAt(row,18).toString().equals("Meninggal")){
            component.setBackground(new Color(50,50,50));
            component.setForeground(new Color(245,255,245));
        }else if(table.getValueAt(row,18).toString().equals("Dirawat")){
            component.setBackground(new Color(52, 152, 219));
            component.setForeground(new Color(245,255,245));
        }
        if(table.getValueAt(row,19).toString().equals("Sudah Bayar")){
            component.setBackground(new Color(29, 131, 72 ));
            component.setForeground(new Color(245,245,255));
        }
        return component;
    }

}
