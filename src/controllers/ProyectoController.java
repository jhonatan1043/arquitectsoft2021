/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DaoComponente;
import generals.Combos;
import generals.Contans;
import generals.FileTxt;
import generals.ValidTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
            if (validCampos()) {
                FileTxt file = new FileTxt();
                file.openFile(viewPrincipal,
                        viewComponente.tbComponenteMayor,
                        setCreateColumns(viewComponente.comboCategoria.getSelectedIndex()));
                loadSubcomponente();
            }
        }
    }

    public final void start() {
        this.hideColumns();
        this.initEvent();
        this.cargarComboCategoria();
        modelo = (DefaultTableModel) viewComponente.tbComponente.getModel();
    }

    private ArrayList<String> setCreateColumns(int idCategoria) {
        ArrayList<String> listColumns = new ArrayList<>();

        switch (idCategoria) {

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

    private void cargarComboCategoria() {
        Combos combo = new Combos();
        combo.setSqlConsult(Contans.QUERY_CATEGORIAS);
        try {
            combo.setCombo(viewComponente.comboCategoria);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProyectoController.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private boolean validCampos() {
        boolean result = false;

        if (viewComponente.comboCategoria.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(viewComponente, "¡ categoria del componente !");
        } else {
            result = true;
        }

        return result;
    }

}
