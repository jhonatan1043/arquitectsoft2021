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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import views.VBusqueda;
import views.VComponente;
import views.VPrincipal;

/**
 *
 * @author Programador 1
 */
public class ComponenteController implements ActionListener {

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
        viewComponente.btnTrabajar.addActionListener(this);
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
            if (validCampos()) {
                VBusqueda busqueda = new VBusqueda(viewPrincipal, true);
                busquedaC = new BusquedaController(busqueda, viewComponente, Contans.QUERY_SUBCOMPONENTES, createColumns());
                busqueda.setVisible(true);
                if (System.getProperty("id") != null) {
                    loadSubcomponente(Integer.parseInt(System.getProperty("id")));
                }
            }
        }

        if (e.getSource() == this.viewComponente.btnOpenTxt) {
            if (viewComponente.comboCategoria.getSelectedIndex() != 0) {
                FileTxt file = new FileTxt();
                file.openFile(viewPrincipal,
                        viewComponente.tbComponenteMayor,
                        setCreateColumns(viewComponente.comboCategoria.getSelectedIndex()));
            } else {
                JOptionPane.showMessageDialog(viewComponente, "¡ categoria del componente !");
            }
        }

        if (e.getSource() == this.viewComponente.btnTrabajar) {
            loadInfoComponenteMayor(viewComponente.comboCategoria.getSelectedIndex());
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
            Logger.getLogger(ComponenteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadSubcomponente(int idSubcomponente) {
        Object[] list = daoComponente.getSubComponente(idSubcomponente);
        modelo.addRow(list);
    }

    private boolean validCampos() {
        boolean result = false;

        if ("".equals(viewComponente.txtCodigo.getText())) {
            JOptionPane.showMessageDialog(viewComponente, "¡ Se necesita el codigo del componente !");
        } else if ("".equals(viewComponente.txtDescripcion.getText())) {
            JOptionPane.showMessageDialog(viewComponente, "¡ el nombre del componente !");
        } else if (viewComponente.comboCategoria.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(viewComponente, "¡ categoria del componente !");
        } else {
            result = true;
        }

        return result;
    }

    private void loadInfoComponenteMayor(int idCategoria) {

        int indexRow = viewComponente.tbComponenteMayor.getSelectedRow();
        int value = Integer.parseInt(viewComponente.tbComponenteMayor.getValueAt(indexRow, 2).toString().trim().replace("\"", ""));
        
        switch (idCategoria) {

            case 1:
                viewComponente.txtCodigo.setText(viewComponente.tbComponenteMayor.getValueAt(indexRow, 0).toString().trim());
                viewComponente.txtDescripcion.setText(viewComponente.tbComponenteMayor.getValueAt(indexRow, 1).toString().trim());
                viewComponente.txtLongitud.setValue(value);
                viewComponente.txtUbicacion.setText(viewComponente.tbComponenteMayor.getValueAt(indexRow, 3).toString().trim());
                break;
            case 2:

                break;
            case 3:

                break;
        }
    }
}
