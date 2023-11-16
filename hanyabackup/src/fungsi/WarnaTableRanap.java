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
public class WarnaTableRanap extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (row % 2 == 1){
            component.setBackground(new Color(255,244,244));
            component.setForeground(new Color(50,50,50));
        }else{
            component.setBackground(new Color(255,255,255));
            component.setForeground(new Color(50,50,50));
        }  
        if(Integer.parseInt(table.getValueAt(row,17).toString())==3){
            component.setBackground(new Color(223, 255, 0));
            component.setForeground(new Color(50,50,50));
        }else if(Integer.parseInt(table.getValueAt(row,17).toString())>=4){
            component.setBackground(new Color(192, 57, 43));
            component.setForeground(new Color(253, 254, 254));
        }
        
         if(table.getValueAt(row,16).toString().equals("Meninggal")){
            component.setBackground(new Color(28, 40, 51 ));
            component.setForeground(new Color(253, 254, 254));
        }else if(table.getValueAt(row,16).toString().equals("Batal")){
            component.setBackground(new Color(214, 137, 16));
            component.setForeground(new Color(123, 36, 28));
        }
        
//        memberi warna pada colom tertentu
//        if ((column == 16)||(column == 17)){
//            if(Integer.parseInt(table.getValueAt(row,17).toString())==0){
//                component.setBackground(Color.GREEN);
//                component.setForeground(Color.BLUE);
//            }else if(Integer.parseInt(table.getValueAt(row,17).toString())>=10){
//                component.setBackground(Color.YELLOW);
//                component.setForeground(Color.GREEN);
//            }else if(Integer.parseInt(table.getValueAt(row,17).toString())==20){
//                component.setBackground(Color.ORANGE);
//                component.setForeground(Color.WHITE);
//            }else if(Integer.parseInt(table.getValueAt(row,17).toString())==150){
//                component.setBackground(Color.RED);
//                component.setForeground(Color.WHITE);
//            }
//        }
        return component;
    }

}
