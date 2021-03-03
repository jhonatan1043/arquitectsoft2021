/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generals;

import java.util.ArrayList;

/**
 *
 * @author Programador 1
 */
public class GenerarColumns {

    public static ArrayList<String> setCreateColumns(int index) {
        ArrayList<String> listColumns = new ArrayList<>();

        switch (index) {

            case 1:
                //-----------------perfil 
                listColumns.add("Codigo");
                listColumns.add("ComponenteMayor");
                listColumns.add("Logitud");
                listColumns.add("Ubicacion");
                listColumns.add("Comentario");
                //-----------------
                break;
            case 2:
                //-----------------vidrios y paneles
                listColumns.add("Codigo");
                listColumns.add("Altura");
                listColumns.add("Anchura");
                listColumns.add("Anchura2");
                listColumns.add("Anchura3");
                listColumns.add("Anchura4");
                listColumns.add("Anchura5");
                listColumns.add("Ubicación");
                //-----------------
                break;
            case 3:
                //-----------------Union de Vidrios

                //-----------------
                break;
            case 4:
                //-----------------Puertas
                listColumns.add("Codigo");
                listColumns.add("Apertura de Puerta");
                listColumns.add("Codigo Acabado Perfileria Puerta");
                listColumns.add("Family");
                listColumns.add("Item");
                listColumns.add("Altura");
                listColumns.add("Anchura");
                listColumns.add("Conectado/pared Tubo L1");
                listColumns.add("Conectado/pared Tubo L2");
                listColumns.add("Cantidad");
                listColumns.add("Ubicación");
                listColumns.add("Area");
                //-----------------
                break;
            case 5:
                //-----------------Union de Paneles
                listColumns.add("Codigo");
                listColumns.add("item");
                listColumns.add("Ubicacion");
                listColumns.add("Altura de Postes 1");
                listColumns.add("Altura de Postes 2");
                //-----------------
                break;
            case 6:
                //-----------------Tubos Metalicos
                listColumns.add("Codigo");
                listColumns.add("Tipo");
                listColumns.add("Altura");
                listColumns.add("Largo");
                listColumns.add("Count");
                listColumns.add("Acabado");
                //-----------------
                break;
            case 7:
                //-----------------Mamparas
                listColumns.add("Codigo");
                listColumns.add("Tipo");
                listColumns.add("Area");
                listColumns.add("Ubicacion");
                //-----------------
                break;
        }

        return listColumns;
    }
}
