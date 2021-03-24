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
        modeloPuerta = (DefaultTableModel) viewComponente.tbPuerta.getModel();
        modeloTuboMetalico = (DefaultTableModel) viewComponente.tbComponenteTuboMetalico.getModel();
        modeloMampara = (DefaultTableModel) viewComponente.tbComponenteMampara.getModel();
    }

    private void hideColumns() {
        int[] list = {0};
        ValidTable.hideColumnsTable(viewComponente.tbComponente, list);
        ValidTable.hideColumnsTable(viewComponente.tbComponenteVidrioPanel, list);
        ValidTable.hideColumnsTable(viewComponente.tbComponenteTuboMetalico, list);
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
        DefaultTableModel modeloTuboMetalicoAux = modeloTuboMetalico;

        calcularPerfilMetalico(modeloAux);
        calcularVidrioPanel(modeloVidrioPanelAux);
        calcularTuboMetalicos(modeloTuboMetalicoAux);
        calcularMampara((DefaultTableModel) viewComponente.tbMampara.getModel(), (DefaultTableModel) viewComponente.tbPuerta.getModel());

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

    private void calcularTuboMetalicos(DefaultTableModel modeloAux) {
        ArrayList<ArrayList<Object[]>> list;
        list = daoComponente.getSubComponenteCalc(viewComponente.tbTuboMetalico.getModel());
        list.forEach((list1) -> {
            list1.forEach((data) -> {
                modeloAux.addRow(data);
            });
        });
        groupList(modeloAux, daoProyecto.getComponenteCalc(modeloAux), 3);
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

    private void calcularMampara(DefaultTableModel modeloMamparaAux, DefaultTableModel modeloPuertaAux) {
        ArrayList<Object[]> listDta = new ArrayList<>();
        Object[] list;
        int[] listHide = {3};
        double areaMampara, areaPuerta, areaCalculada;
        String UbicacionMampara, UbicacionPuerta;
        DefaultTableModel modeloAux;

        for (int m = 0; m < modeloMamparaAux.getRowCount(); m++) {
            UbicacionMampara = modeloMamparaAux.getValueAt(m, 3).toString().replace("\"", "");
            if (!"".equals(UbicacionMampara)) {
                areaMampara = Double.parseDouble(modeloMamparaAux.getValueAt(m, 2).toString().replace("\"", ""));
                list = new Object[4];
                list[0] = modeloMamparaAux.getValueAt(m, 0).toString();
                list[1] = modeloMamparaAux.getValueAt(m, 1).toString();
                list[2] = areaMampara;
                list[3] = UbicacionMampara;
                listDta.add(list);
            }
        }

        listDta.forEach((list1) -> {
            modeloMampara.addRow(list1);
        });

        for (int p = 0; p < modeloPuertaAux.getRowCount(); p++) {
            UbicacionPuerta = modeloPuertaAux.getValueAt(p, 9).toString().replace("\"", "");

            if (!"".equals(UbicacionPuerta)) {
                areaPuerta = Double.parseDouble(modeloPuertaAux.getValueAt(p, 10).toString().replace("\"", ""));

                if (modeloMampara.getRowCount() > 0) {
                    for (int m = 0; m < modeloMampara.getRowCount(); m++) {
                        UbicacionMampara = modeloMampara.getValueAt(m, 3).toString();
                        if (UbicacionMampara == null ? UbicacionPuerta == null : UbicacionMampara.equals(UbicacionPuerta)) {
                            areaMampara = Double.parseDouble(modeloMampara.getValueAt(m, 2).toString());
                            areaCalculada = areaMampara - areaPuerta;
                            modeloMampara.setValueAt(Math.round(areaCalculada * 100.0) / 100.0, m, 2);
                        }
                    }
                }
            }
        }
        modeloAux = modeloMampara;

        groupList(modeloAux, daoProyecto.getComponenteMamparaCalc(modeloAux), 4);
        ValidTable.hideColumnsTable(viewComponente.tbComponenteMampara, listHide);

    }

    private void groupList(DefaultTableModel modeloAux, ArrayList<Object[]> list, int bdra) {
        modeloAux.setRowCount(0);
        switch (bdra) {
            case 1:
                modelo.setRowCount(0);
                list.forEach((list1) -> {
                    modelo.addRow(list1);
                });
                break;
            case 2:
                modeloVidrioPanel.setRowCount(0);
                list.forEach((list1) -> {
                    modeloVidrioPanel.addRow(list1);
                });
                break;
            case 3:
                modeloTuboMetalico.setRowCount(0);
                list.forEach((list1) -> {
                    modeloTuboMetalico.addRow(list1);
                });
                break;
            case 4:
                modeloMampara.setRowCount(0);
                list.forEach((list1) -> {
                    modeloMampara.addRow(list1);
                });
                break;
            default:
                break;
        }

    }

}
