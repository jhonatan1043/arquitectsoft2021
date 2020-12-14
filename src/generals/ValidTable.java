/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generals;

/**
 *
 * @author Programador 1
 */
public class ValidTable {
    
    
    public static void hideColumnsTable(javax.swing.JTable table, int[] list) {
        int column = 0;
        for (int l = 0; l < list.length; l++) {
            column = list[l]; 
            table.getColumnModel().getColumn(column).setMaxWidth(0);
            table.getColumnModel().getColumn(column).setMinWidth(0);
            table.getColumnModel().getColumn(column).setPreferredWidth(0);
        }
    }
}
