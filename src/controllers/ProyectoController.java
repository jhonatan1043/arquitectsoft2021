/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DaoComponente;
import generals.FileTxt;
import generals.GeneralExcel;
import generals.ValidTable;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        viewComponente.btnCalcular.addActionListener(this);
        viewComponente.btnGenerar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.viewComponente.btnOpenTxt) {
            try {
                reset();
                FileTxt file = new FileTxt();
                file.openFile(viewPrincipal, viewComponente);
                viewComponente.btnCalcular.setEnabled(true);
            } catch (IOException ex) {
                Logger.getLogger(ProyectoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == this.viewComponente.btnCalcular) {
            loadSubcomponente();
        }
        if (e.getSource() == this.viewComponente.btnGenerar) {

            GeneralExcel.GeneraExcel(System.getProperty("java.io.tmpdir"), viewComponente.tbComponente, "perfil");

        }
    }

    public final void start() {
        this.hideColumns();
        this.initEvent();
        this.hideTab();
        viewComponente.btnCalcular.setEnabled(false);
        viewComponente.btnGenerar.setEnabled(false);
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

    private void reset() {
        hideTab();
        dataClear();
        viewComponente.btnCalcular.setEnabled(false);
        viewComponente.btnGenerar.setEnabled(false);
    }

    private void dataClear() {
        ValidTable.clearTable(viewComponente.tbComponente);
        ValidTable.clearTable(viewComponente.tbPerfilMetalico);
        ValidTable.clearTable(viewComponente.tbVidrioPanele);
        ValidTable.clearTable(viewComponente.tbUnionVidrio);
        ValidTable.clearTable(viewComponente.tbUnionPaneles);
        ValidTable.clearTable(viewComponente.tbPuerta);
        ValidTable.clearTable(viewComponente.tbTuboMetalico);
        ValidTable.clearTable(viewComponente.tbMampara);
    }

    private void loadSubcomponente() {
        ArrayList<ArrayList<Object[]>> list;
        list = daoComponente.getSubComponenteCalc(viewComponente.tbPerfilMetalico.getModel());

        list.forEach((list1) -> {
            list1.forEach((data) -> {
                modelo.addRow(data);
            });
        });

        if (viewComponente.tbComponente.getRowCount() > 0) {
            viewComponente.btnGenerar.setEnabled(true);
        }
    }

}
