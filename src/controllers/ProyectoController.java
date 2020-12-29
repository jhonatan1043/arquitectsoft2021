/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DaoComponente;
import generals.FileTxt;
import generals.ValidTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import views.VProyecto;
import views.VPrincipal;

/**
 *
 * @author Programador 1
 */
public class ProyectoController implements ActionListener {

    DefaultTableModel modelo;
    VProyecto viewComponente;
    VPrincipal viewPrincipal;
    BusquedaController busquedaC;
    DaoComponente daoComponente = new DaoComponente();

    public ProyectoController(VProyecto viewComponente, VPrincipal viewPrincipal) {
        this.viewComponente = viewComponente;
        this.viewPrincipal = viewPrincipal;
        start();
    }

    private void initEvent() {
        viewComponente.btnOpenTxt.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.viewComponente.btnOpenTxt) {
                FileTxt file = new FileTxt();
                file.openFile(viewPrincipal,
                        viewComponente.tbComponenteMayor,
                        setCreateColumns(1));
                loadSubcomponente();
        }
    }

    public final void start() {
        this.hideColumns();
        this.initEvent();
        modelo = (DefaultTableModel) viewComponente.tbComponente.getModel();
    }

    private ArrayList<String> setCreateColumns(int index) {
        ArrayList<String> listColumns = new ArrayList<>();

        switch (index) {

            case 1:
                //-----------------
                listColumns.add("Codigo");
                listColumns.add("ComponenteMayor");
                listColumns.add("Logitud");
                listColumns.add("Ubicacion");
                listColumns.add("Comentario");
                //-----------------
                break;
            case 2:

                break;
            case 3:

                break;
        }

        return listColumns;
    }

    private void hideColumns() {
        int[] list = {0};
        ValidTable.hideColumnsTable(viewComponente.tbComponente, list);
    }

    private void loadSubcomponente() {
        ArrayList<ArrayList<Object[]>> list;
        if (viewComponente.tbComponenteMayor.getRowCount() > 0) {
            list = daoComponente.getSubComponenteCalc(viewComponente.tbComponenteMayor.getModel());
            list.forEach((list1) -> {
                list1.forEach((data) -> {
                    modelo.addRow(data);
                });
            });
        }
    }

}
