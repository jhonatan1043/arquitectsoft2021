/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import generals.Contans;
import generals.ValidButtonSystem;
import generals.ValidControlsSystem;
import generals.ValidTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import views.VBusqueda;
import views.VComponente;
import views.VPrincipal;

/**
 *
 * @author Programador 1
 */
public class ComponenteController implements ActionListener {

    VComponente viewComponente;
    VPrincipal viewPrincipal;

    public ComponenteController(VComponente viewComponente,
            VPrincipal viewPrincipal) {
        this.viewComponente = viewComponente;
        this.viewPrincipal = viewPrincipal;
        start();
        initEvent();
        hideColumns();
    }

    private void start() {
        ValidControlsSystem.disableControls(viewComponente.jLayeredPane1);
        ValidButtonSystem.disableButton(viewComponente.pnlButton);
        viewComponente.btnNew.setEnabled(true);
        viewComponente.btnBuscar.setEnabled(true);
    }

    private void initEvent() {
        viewComponente.btnNew.addActionListener(this);
        viewComponente.btnCancel.addActionListener(this);
        viewComponente.btnSave.addActionListener(this);
        viewComponente.btnAgregar.addActionListener(this);
        viewComponente.btnQuitar.addActionListener(this);
    }

    private void hideColumns() {
        int[] list = {0};
        ValidTable.hideColumnsTable(viewComponente.tbComponente, list);
    }

    private ArrayList<String> createColumns() {
        ArrayList<String> listColumns = new ArrayList<>();
        listColumns.add("Id");
        listColumns.add("Codigo");
        listColumns.add("Descripcion");
        return listColumns;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == viewComponente.btnNew) {
            ValidControlsSystem.enabledControls(viewComponente.jLayeredPane1);
            ValidButtonSystem.disableButton(viewComponente.pnlButton);
            viewComponente.btnSave.setEnabled(true);
            viewComponente.btnCancel.setEnabled(true);
        }

        if (e.getSource() == viewComponente.btnCancel) {
            ValidControlsSystem.disableControls(viewComponente.jLayeredPane1);
            ValidButtonSystem.disableButton(viewComponente.pnlButton);
            viewComponente.btnNew.setEnabled(true);
            viewComponente.btnBuscar.setEnabled(true);
        }

        if (e.getSource() == viewComponente.btnAgregar) {
            VBusqueda viewBusqueda = new VBusqueda(viewPrincipal, true);
            BusquedaController busquedaC = new BusquedaController(viewBusqueda,
                    viewComponente,
                    Contans.QUERY_SUBCOMPONENTES,
                    createColumns());
            viewBusqueda.setVisible(true);
        }

        if (e.getSource() == viewComponente.btnQuitar) {
            viewComponente.tbComponente.remove(viewComponente.tbComponente.getSelectedRow());
        }
    }

}
