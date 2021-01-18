/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generals;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

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

    public static void enableColumnsTableComponente(javax.swing.JTable table) {

        for (int i = 0; i < table.getRowCount(); i++) {
            System.out.println(table.getValueAt(i, 3));
            if (Integer.parseInt(table.getValueAt(i, 3).toString()) == 2
                    || Integer.parseInt(table.getValueAt(i, 3).toString()) == 3) {
                table.isCellEditable(i, 6);
                table.isCellEditable(i, 7);

            }
        }

    }
}
