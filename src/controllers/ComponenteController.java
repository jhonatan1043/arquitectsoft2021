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
import generals.ValidButtonSystem;
import generals.ValidControlsSystem;
import generals.ValidTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import views.VBusqueda;
import views.VComponente;
import views.VPrincipal;

/**
 *
 * @author Programador 1
 */
public class ComponenteController implements ActionListener {

    int index;
    DefaultTableModel modelo;
    VComponente viewComponente;
    VPrincipal viewPrincipal;
    BusquedaController busquedaC;
    DaoComponente daoComponente = new DaoComponente();

    public ComponenteController(VComponente viewComponente, VPrincipal viewPrincipal) {
        this.viewComponente = viewComponente;
        this.viewPrincipal = viewPrincipal;
        start();
    }

    private void initEvent() {
        viewComponente.btnAgregar.addActionListener(this);
        viewComponente.btnNew.addActionListener(this);
        viewComponente.btnCancel.addActionListener(this);
        viewComponente.btnOpenTxt.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.viewComponente.btnNew) {
            ValidControlsSystem.enabledControls(viewComponente.jLayeredPane1);
            ValidButtonSystem.disableButton(viewComponente.pnlButton);
            viewComponente.btnSave.setEnabled(true);
            viewComponente.btnCancel.setEnabled(true);

        }

        if (e.getSource() == this.viewComponente.btnCancel) {
            ValidControlsSystem.disableControls(viewComponente.jLayeredPane1);
            ValidButtonSystem.disableButton(viewComponente.pnlButton);
            viewComponente.btnNew.setEnabled(true);
            viewComponente.btnBuscar.setEnabled(true);
        }

        if (e.getSource() == this.viewComponente.btnAgregar) {
            VBusqueda busqueda = new VBusqueda(viewPrincipal, true);
            busquedaC = new BusquedaController(busqueda, viewComponente, Contans.QUERY_SUBCOMPONENTES, createColumns());
            busqueda.setVisible(true);
            loadSubcomponente(Integer.parseInt(System.getProperty("id")));
        }
        
        if(e.getSource() == this.viewComponente.btnOpenTxt){
            FileTxt file = new  FileTxt();
            file.openFile(viewPrincipal);
        }
    }

    public final void start() {
        ValidControlsSystem.disableControls(viewComponente.jLayeredPane1);
        ValidButtonSystem.disableButton(viewComponente.pnlButton);
        this.hideColumns();
        this.initEvent();
        this.cargarComboCategoria();
        modelo = (DefaultTableModel) viewComponente.tbComponente.getModel();
        viewComponente.btnNew.setEnabled(true);
        viewComponente.btnBuscar.setEnabled(true);
    }

    private ArrayList<String> createColumns() {
        ArrayList<String> listColumns = new ArrayList<>();
        listColumns.add("Id");
        listColumns.add("Codigo");
        listColumns.add("Descripcion");
        return listColumns;
    }

    private int setCalcularMedida(int idCategoria,
            int logitud,
            int altura,
            int anchura,
            int area,
            int incremento) {
        int resultado = 0;

        switch (idCategoria) {

            case 1:
                resultado = logitud + incremento;
                break;
            case 2:
                break;
            case 3:
                break;
        }

        return resultado;
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
            Logger.getLogger(ComponenteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadSubcomponente(int idSubcomponente){
       Object[] list = daoComponente.getSubComponente(idSubcomponente);
       modelo.addRow(list);
    }
}
