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
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import views.VPrincipal;
import views.VProyecto;

/**
 *
 * @author Programador 1
 */
public class FileTxt {

    public void openFile(VPrincipal viewPrincipal,
            VProyecto viewProyecto) throws IOException {
        ArrayList<Object[]> listData;
        int idDocumento;
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(".txt"));
        chooser.setDialogTitle("Selecciona la carpeta de los archivos");
        chooser.setMultiSelectionEnabled(true);

        if (chooser.showOpenDialog(viewPrincipal) == JFileChooser.APPROVE_OPTION) {
            File[] files = chooser.getSelectedFiles();
            for (File file : files) {
                idDocumento = Integer.parseInt(file.getName().split("-")[0].trim());
                listData = readFileTxt(file);
                showTab(idDocumento, viewProyecto, listData);
            }
        }
    }

    private void showTab(int index,
            VProyecto viewProyecto, ArrayList<Object[]> listData) {
        ArrayList<String> listColumns = GenerarColumns.setCreateColumns(index);
        DefaultTableModel modelo = new DefaultTableModel();

        listColumns.forEach((listColumns1) -> {
            modelo.addColumn(listColumns1);
        });

        listData.forEach((listData1) -> {
            modelo.addRow(listData1);
        });

        switch (index) {

            case 1:
                viewProyecto.jTabComponentes.add(viewProyecto.jPnPerfilMetalico, "PERFIL METALICO");
                viewProyecto.tbPerfilMetalico.setModel(modelo);
                break;
            case 2:
                viewProyecto.jTabComponentes.add(viewProyecto.jPnVidrioPanel, "VIDRIOS Y PANELES");
                viewProyecto.tbVidrioPanele.setModel(modelo);
                break;
            case 3:
                viewProyecto.jTabComponentes.add(viewProyecto.jPnUnionVidrio, "UNION DE VIDRIOS");
                viewProyecto.tbUnionVidrio.setModel(modelo);
                break;
            case 4:
                viewProyecto.jTabComponentes.add(viewProyecto.jPnPuerta, "PUERTAS");
                viewProyecto.tbPuerta.setModel(modelo);
                break;
            case 5:
                viewProyecto.jTabComponentes.add(viewProyecto.jPnUnionPanele, "UNION DE PANELES");
                viewProyecto.tbUnionPaneles.setModel(modelo);
                break;
            case 6:
                viewProyecto.jTabComponentes.add(viewProyecto.jPnTuboMetalico, "TUBOS METALICOS");
                viewProyecto.tbTuboMetalico.setModel(modelo);
                break;
            case 7:
                viewProyecto.jTabComponentes.add(viewProyecto.jPnMamparas, "MAMPARAS");
                viewProyecto.tbMampara.setModel(modelo);
                break;
        }
    }

    public ArrayList<Object[]> readFileTxt(File file) throws IOException {
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

    public static String convertCodeToUtf(String cadena) throws UnsupportedEncodingException {
        byte[] utf8 = cadena.getBytes(StandardCharsets.US_ASCII);
        cadena = new String(utf8, StandardCharsets.UTF_8);
        return cadena;
    }
}
