/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DaoComponente;
import generals.FileTxt;
import generals.ValidTable;
import java.awt.Component;
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
            file.openFile(viewPrincipal, viewComponente);
            loadSubcomponente();
        }
    }

    public final void start() {
        this.hideColumns();
        this.initEvent();
        this.hideTab();
        modelo = (DefaultTableModel) viewComponente.tbComponente.getModel();
    }

    private void hideColumns() {
        int[] list = {0};
        ValidTable.hideColumnsTable(viewComponente.tbComponente, list);
    }

    private void hideTab() {
        System.out.println(viewComponente.jTabComponentes.getTabCount());
        for (Component jPane : viewComponente.jTabComponentes.getComponents()) {
            viewComponente.jTabComponentes.remove(jPane);
        }
    }

    private void loadSubcomponente() {
        ArrayList<ArrayList<Object[]>> list;
            list = daoComponente.getSubComponenteCalc(viewComponente.tbPerfilMetalico.getModel());
            list.forEach((list1) -> {
                list1.forEach((data) -> {
                    modelo.addRow(data);
                });
            });
    }

}
