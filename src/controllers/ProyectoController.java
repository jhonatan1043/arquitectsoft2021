/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DaoComponente;
import dao.DaoComponenteEspecial;
import dao.DaoProyecto;
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

    DaoProyecto daoProyecto = new DaoProyecto();
    DefaultTableModel modelo,
            modeloVidrioPanel,
            modeloUnionVidrio,
            modeloPuerta,
            modeloUnionPanel,
            modeloTuboMetalico,
            modeloMampara;
    VProyecto viewComponente;
    VPrincipal viewPrincipal;
    BusquedaController busquedaC;
    DaoComponente daoComponente = new DaoComponente();
    DaoComponenteEspecial daoComponenteEspecial = new DaoComponenteEspecial();

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
        modeloVidrioPanel = (DefaultTableModel) viewComponente.tbComponenteVidrioPanel.getModel();
//        modeloVidrioPanel = (DefaultTableModel) viewComponente.tbVidrioPanele.getModel();
//        modeloPuerta = (DefaultTableModel) viewComponente.tbPuerta.getModel();
//        modeloUnionPanel = (DefaultTableModel) viewComponente.tbUnionPaneles.getModel();
//        modeloTuboMetalico = (DefaultTableModel) viewComponente.tbTuboMetalico.getModel();
//        modeloMampara = (DefaultTableModel) viewComponente.tbMampara.getModel();
    }

    private void hideColumns() {
        int[] list = {0};
        ValidTable.hideColumnsTable(viewComponente.tbComponente, list);
        ValidTable.hideColumnsTable(viewComponente.tbComponenteVidrioPanel, list);
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

        DefaultTableModel modeloAux = modelo;
        DefaultTableModel modeloVidrioPanelAux = modeloVidrioPanel;

        calcularPerfilMetalico(modeloAux);
        calcularVidrioPanel(modeloVidrioPanelAux);

        if (viewComponente.tbComponente.getRowCount() > 0
                || viewComponente.tbComponenteVidrioPanel.getRowCount() > 0) {
            viewComponente.btnGenerar.setEnabled(true);
            viewComponente.btnCalcular.setEnabled(false);
        }
    }

    private void calcularPerfilMetalico(DefaultTableModel modeloAux) {
        ArrayList<ArrayList<Object[]>> list;
        list = daoComponente.getSubComponenteCalc(viewComponente.tbPerfilMetalico.getModel());
        list.forEach((list1) -> {
            list1.forEach((data) -> {
                modeloAux.addRow(data);
            });
        });
        groupList(modeloAux, daoProyecto.getComponenteCalc(modeloAux), 1);
    }

    private void calcularVidrioPanel(DefaultTableModel modeloAux) {

        ArrayList<ArrayList<Object[]>> list;

        list = daoComponenteEspecial.getSubComponenteEspecialCalc(viewComponente.tbVidrioPanele.getModel());

        list.forEach((list1) -> {
            list1.forEach((data) -> {
                modeloAux.addRow(data);
            });
        });
        
        groupList(modeloAux, daoProyecto.getComponenteVidrioPanelCalc(modeloAux), 2);
    }

    private void groupList(DefaultTableModel modeloAux, ArrayList<Object[]> list, int bdra) {
        modeloAux.setRowCount(0);
        if (bdra == 1) {
            modelo.setRowCount(0);
            System.out.print(bdra);
            list.forEach((list1) -> {
                modelo.addRow(list1);
            });
        } else if (bdra == 2) {
            System.out.print(bdra);
            modeloVidrioPanel.setRowCount(0);
            list.forEach((list1) -> {
                modeloVidrioPanel.addRow(list1);
            });
        }

    }

}
