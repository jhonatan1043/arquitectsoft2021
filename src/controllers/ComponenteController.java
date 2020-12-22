/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DaoComponente;
import generals.Contans;
import generals.ValidButtonSystem;
import generals.ValidControlsSystem;
import generals.ValidEnterCaracter;
import generals.ValidTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import views.VBusqueda;
import views.VComponente;
import views.VPrincipal;

/**
 *
 * @author Programador 1
 */
public class ComponenteController implements ActionListener, KeyListener {

    DefaultTableModel modelo;
    VComponente viewComponente;
    DaoComponente daoComponente = new DaoComponente();
    VPrincipal viewPrincipal;

    public ComponenteController(VComponente viewComponente,
            VPrincipal viewPrincipal) {
        this.viewComponente = viewComponente;
        this.viewPrincipal = viewPrincipal;
        start();
    }

    private void start() {
        ValidControlsSystem.disableControls(viewComponente.jLayeredPane1);
        ValidButtonSystem.disableButton(viewComponente.pnlButton);
        initEvent();
        hideColumns();
        modelo = (DefaultTableModel) viewComponente.tbComponente.getModel();
        viewComponente.btnNew.setEnabled(true);
        viewComponente.btnBuscar.setEnabled(true);
    }

    private void initEvent() {
        viewComponente.btnNew.addActionListener(this);
        viewComponente.btnCancel.addActionListener(this);
        viewComponente.btnSave.addActionListener(this);
        viewComponente.btnAgregar.addActionListener(this);
        viewComponente.btnQuitar.addActionListener(this);
        viewComponente.txtCodigo.addKeyListener(this);
        viewComponente.txtDescripcion.addKeyListener(this);
    }

    private void hideColumns() {
        int[] list = {0};
        ValidTable.hideColumnsTable(viewComponente.tbComponente, list);
    }

    private void loadSubComponente(int id) {
        Object[] list = daoComponente.getSubComponente(id);
        modelo.addRow(list);
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
            loadSubComponente(Integer.parseInt(System.getProperty("id")));
        }

        if (e.getSource() == viewComponente.btnQuitar) {
            modelo.removeRow(viewComponente.tbComponente.getSelectedRow());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == viewComponente.txtCodigo) {
            ValidEnterCaracter.validMaxCaracter(viewComponente.txtCodigo, e, 10, viewComponente);
        }
        if (e.getSource() == viewComponente.txtDescripcion) {
            ValidEnterCaracter.validMaxCaracter(viewComponente.txtDescripcion, e, 45, viewComponente);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
