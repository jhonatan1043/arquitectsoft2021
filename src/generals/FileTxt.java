/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import views.VPrincipal;

/**
 *
 * @author Programador 1
 */
public class FileTxt {

    DefaultTableModel modelo = new DefaultTableModel();

    public void openFile(VPrincipal viewPrincipal, JTable tabla, ArrayList<String> listColumns) {
        JFileChooser chooser = new JFileChooser();
        ArrayList<Object[]> listData;

        if (chooser.showOpenDialog(viewPrincipal) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();

            listColumns.forEach((listColumns1) -> {
                modelo.addColumn(listColumns1);
            });

            listData = readFileTxt(selectedFile);

            listData.forEach((listData1) -> {
                modelo.addRow(listData1);
            });

            tabla.setModel(modelo);
        }
    }

    public ArrayList<Object[]> readFileTxt(File file) {
        ArrayList<Object[]> list = new ArrayList<>();

        FileReader fr = null;
        BufferedReader br = null;
        String line;
        Object[] array = null;
        try {

            fr = new FileReader(file);
            br = new BufferedReader(fr);

            try {
                while ((line = br.readLine()) != null) {
                    String[] separado = line.split(",");
                    array = new String[separado.length];
                    System.arraycopy(separado, 0, array, 0, separado.length);
                    br.readLine();
                    list.add(array);

                }

            } catch (IOException ex) {
                Logger.getLogger(FileTxt.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileTxt.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
}
