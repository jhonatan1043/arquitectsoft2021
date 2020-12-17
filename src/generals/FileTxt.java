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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import views.VPrincipal;

/**
 *
 * @author Programador 1
 */
public class FileTxt {

    public static final String SEPARATOR = ";";
    public static final String QUOTE = "\"";

    public void openFile(VPrincipal viewPrincipal) {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(viewPrincipal) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            readFileTxt(selectedFile);
        }
    }

    public void createFileCsv(File file, ArrayList<String[]> contents) {
        try {
            File fileRename = new File(file.toString().replace("txt", "csv"));
          // Si el archivo no existe es creado
            if (!fileRename.exists()) {
                fileRename.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                for(String[] conten: contents){
                    bw.write(Arrays.toString(conten));
                }    
            }
        } catch (IOException e) {
        }
    }

    public  ArrayList<String[]> readFileTxt(File file) {
        ArrayList<String[]> list = new ArrayList<>();
        FileReader fr = null;
        BufferedReader br = null;
        String line;
  
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            try {
                line = br.readLine();
                while (null != line) {
                    String[] fields = line.split(SEPARATOR); 
                    list.add(removeTrailingQuotes(fields));
                    line = br.readLine();
                }
                createFileCsv(file, list);     
            } catch (IOException ex) {
                Logger.getLogger(FileTxt.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileTxt.class.getName()).log(Level.SEVERE, null, ex);
        }

//        String line;
//        try {
//            while ((line = br.readLine()) != null) {
//                String[] separado = line.split(",");
//                for (String separado1 : separado) {
//
//                }
//            }
        return list;
    }

    private static String[] removeTrailingQuotes(String[] fields) {

        String result[] = new String[fields.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = fields[i].replaceAll("^" + QUOTE, "").replaceAll(QUOTE + "$", "");
        }
        return result;
    }
}
