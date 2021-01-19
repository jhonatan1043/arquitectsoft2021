/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generals;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import views.VPrincipal;

/**
 *
 * @author Programador 1
 */
public class GeneralExcel {

    private static final HSSFWorkbook book = new HSSFWorkbook();

    public static void GeneraExcel(String path, JTable table, String nameFile) {

        HSSFSheet sheet = book.createSheet();
        String document = path + nameFile + ".xls";
        System.out.println(document + "-------------");
        File file = new File(document);

        for (int i = 0; i < table.getRowCount(); i++) {
            HSSFRow row = sheet.createRow(i);
            if (i == 0) {
                for (int j = 0; j < table.getColumnCount(); j++) {
                    HSSFCell cell = row.createCell(j);

                    cell.setCellValue(new HSSFRichTextString(table.getColumnModel().getColumn(j).getHeaderValue().toString()));
                }
            } else {
                for (int j = 0; j < table.getColumnCount(); j++) {
                    HSSFCell cell = row.createCell(j);
                    if (table.getValueAt(i, j) != null) {
                        cell.setCellValue(new HSSFRichTextString(table.getValueAt(i, j).toString()));
                    }
                }
            }
            try {

                try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
                    book.write(fileOutputStream);
                    fileOutputStream.close();
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException ex) {
            Logger.getLogger(GeneralExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void saveFile(VPrincipal viewPrincipal, JTable table, String nameFile) {
        JFileChooser saveFile = new JFileChooser();
        
        if (saveFile.showSaveDialog(viewPrincipal) == JFileChooser.APPROVE_OPTION) {
            GeneraExcel(saveFile.getSelectedFile().getAbsolutePath(), table, nameFile);
        }
        
    }

}
