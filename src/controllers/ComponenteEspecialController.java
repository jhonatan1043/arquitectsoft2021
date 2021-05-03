/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DaoComponenteEspecial;
import generals.CellRenderer;
import generals.Combos;
import generals.Contans;
import generals.ValidButtonSystem;
import generals.ValidControlsSystem;
import generals.ValidEnterCaracter;
import generals.ValidTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.ComponenteEspecial;
import views.VBusqueda;
import views.VComponenteEspecial;
import views.VPrincipal;

/**
 *
 * @author Programador 1
 */
public class ComponenteEspecialController implements ActionListener, KeyListener, FocusListener {

    DefaultTableModel modelo;
    VComponenteEspecial viewSubComponenteEspecial;
    VPrincipal viewPrincipal;
    ComponenteEspecial componenteEspecial = new ComponenteEspecial();
    DaoComponenteEspecial daoComponenteEspecial = new DaoComponenteEspecial();

    public ComponenteEspecialController(VComponenteEspecial viewSubComponenteEspecial,
            VPrincipal viewPrincipal) {
        this.viewSubComponenteEspecial = viewSubComponenteEspecial;
        this.viewPrincipal = viewPrincipal;
        start();
    }

    private void start() {
        ValidControlsSystem.disableControls(viewSubComponenteEspecial.jLayeredPane1);
        ValidButtonSystem.disableButton(viewSubComponenteEspecial.pnlButton);
        crearTablaCombo();
        comboCorte();
        initEvent();
        hideColumns();
        modelo = (DefaultTableModel) viewSubComponenteEspecial.tbComponente.getModel();
        viewSubComponenteEspecial.tbComponente.setEnabled(false);
        viewSubComponenteEspecial.btnNew.setEnabled(true);
        viewSubComponenteEspecial.btnBuscar.setEnabled(true);
    }

    private void initEvent() {
        viewSubComponenteEspecial.btnNew.addActionListener(this);
        viewSubComponenteEspecial.btnCancel.addActionListener(this);
        viewSubComponenteEspecial.btnSave.addActionListener(this);
        viewSubComponenteEspecial.btnAgregar.addActionListener(this);
        viewSubComponenteEspecial.btnQuitar.addActionListener(this);
        viewSubComponenteEspecial.btnDelete.addActionListener(this);
        viewSubComponenteEspecial.btnBuscar.addActionListener(this);
        viewSubComponenteEspecial.btnEdit.addActionListener(this);
        viewSubComponenteEspecial.txtCodigo.addKeyListener(this);
        viewSubComponenteEspecial.txtDescripcion.addKeyListener(this);
        viewSubComponenteEspecial.txtCodigo.addFocusListener(this);
    }

    private void hideColumns() {
        int[] list = {0};
        ValidTable.hideColumnsTable(viewSubComponenteEspecial.tbComponente, list);
    }

    private void loadSubComponente(int id) {
        if (id != 0) {
            Object[] list = daoComponenteEspecial.getSubComponenteEspecial(id);
            modelo.addRow(list);
            System.setProperty("id", "");
        }
    }

    private void loadComponente(int id) {
        if (id != 0) {

            modelo.setRowCount(0);

            componenteEspecial = daoComponenteEspecial.getComponenteEspecial(id);

            viewSubComponenteEspecial.txtCodigo.setText(componenteEspecial.getCodigo());
            viewSubComponenteEspecial.txtDescripcion.setText(componenteEspecial.getDescripcion());

            ArrayList<Object[]> list = daoComponenteEspecial.getComponenteEspecialDetalle(id);

            list.forEach((list1) -> {
                modelo.addRow(list1);
            });

            System.setProperty("id", "");
            ValidButtonSystem.enabledButton(viewSubComponenteEspecial.pnlButton);
            // ValidTable.enableColumnsTableComponente(viewComponente.tbComponente);
            viewSubComponenteEspecial.btnSave.setEnabled(false);
            viewSubComponenteEspecial.btnCancel.setEnabled(false);
        }
    }

    private ArrayList<String> createColumns() {
        ArrayList<String> listColumns = new ArrayList<>();
        listColumns.add("Id");
        listColumns.add("Codigo");
        listColumns.add("Descripcion");
        return listColumns;
    }

    private void loadComponente() {
        componenteEspecial.setCodigo(viewSubComponenteEspecial.txtCodigo.getText());
        componenteEspecial.setDescripcion(viewSubComponenteEspecial.txtDescripcion.getText());;
        componenteEspecial.setModelo((DefaultTableModel) viewSubComponenteEspecial.tbComponente.getModel());
    }

    private void controlsClear() {
        componenteEspecial = new ComponenteEspecial();
        viewSubComponenteEspecial.txtCodigo.setText("");
        viewSubComponenteEspecial.txtDescripcion.setText("");
        modelo.setRowCount(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == viewSubComponenteEspecial.btnNew) {
            ValidControlsSystem.enabledControls(viewSubComponenteEspecial.jLayeredPane1);
            ValidButtonSystem.disableButton(viewSubComponenteEspecial.pnlButton);
            controlsClear();
            viewSubComponenteEspecial.tbComponente.setEnabled(true);
            viewSubComponenteEspecial.btnSave.setEnabled(true);
            viewSubComponenteEspecial.btnCancel.setEnabled(true);
        }

        if (e.getSource() == viewSubComponenteEspecial.btnCancel) {
            ValidControlsSystem.disableControls(viewSubComponenteEspecial.jLayeredPane1);
            controlsClear();
            ValidButtonSystem.disableButton(viewSubComponenteEspecial.pnlButton);
            viewSubComponenteEspecial.tbComponente.setEnabled(false);
            viewSubComponenteEspecial.btnNew.setEnabled(true);
            viewSubComponenteEspecial.btnBuscar.setEnabled(true);
        }

        if (e.getSource() == viewSubComponenteEspecial.btnAgregar) {
            VBusqueda viewBusqueda = new VBusqueda(viewPrincipal, true);
            BusquedaController busquedaC = new BusquedaController(viewBusqueda,
                    viewSubComponenteEspecial,
                    Contans.QUERY_SUBCOMPONENTES_ESPECIAL,
                    createColumns());
            viewBusqueda.setVisible(true);

            loadSubComponente(Integer.parseInt(System.getProperty("id")));

        }

        if (e.getSource() == viewSubComponenteEspecial.btnQuitar) {
            modelo.removeRow(viewSubComponenteEspecial.tbComponente.getSelectedRow());
        }

        if (e.getSource() == viewSubComponenteEspecial.btnSave) {
            boolean resultado;

            if ("".equals(viewSubComponenteEspecial.txtCodigo.getText())
                    || "".equals(viewSubComponenteEspecial.txtDescripcion.getText())
                    || viewSubComponenteEspecial.tbComponente.getRowCount() == 0) {
                JOptionPane.showMessageDialog(viewSubComponenteEspecial, "¡ hay Datos sin realizar !");
            } else {
                loadComponente();

                if (componenteEspecial.getIdComponente() != 0) {
                    resultado = daoComponenteEspecial.update(componenteEspecial);
                } else {
                    resultado = daoComponenteEspecial.save(componenteEspecial);
                }

                if (resultado) {
                    ValidControlsSystem.disableControls(viewSubComponenteEspecial.jLayeredPane1);
                    ValidButtonSystem.enabledButton(viewSubComponenteEspecial.pnlButton);
                    viewSubComponenteEspecial.tbComponente.setEnabled(false);
                    viewSubComponenteEspecial.btnSave.setEnabled(false);
                    viewSubComponenteEspecial.btnCancel.setEnabled(false);
                    JOptionPane.showMessageDialog(viewSubComponenteEspecial, "¡ Registrado con exito !");
                }
            }
        }

        if (e.getSource() == viewSubComponenteEspecial.btnEdit) {
            int resp = JOptionPane.showConfirmDialog(viewSubComponenteEspecial, "¿Esta seguro de editar el registro?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp != 1) {
                ValidControlsSystem.enabledControls(viewSubComponenteEspecial.jLayeredPane1);
                ValidButtonSystem.disableButton(viewSubComponenteEspecial.pnlButton);
                viewSubComponenteEspecial.tbComponente.setEnabled(true);
                viewSubComponenteEspecial.txtCodigo.setEnabled(false);
                viewSubComponenteEspecial.btnSave.setEnabled(true);
                viewSubComponenteEspecial.btnCancel.setEnabled(true);
            }
        }

        if (e.getSource() == viewSubComponenteEspecial.btnBuscar) {
            VBusqueda viewBusqueda = new VBusqueda(viewPrincipal, true);
            BusquedaController busquedaC = new BusquedaController(viewBusqueda,
                    viewSubComponenteEspecial,
                    Contans.QUERY_COMPONENTES_ESPECIAL_LISTAR,
                    createColumns());
            viewBusqueda.setVisible(true);
            loadComponente(Integer.parseInt(System.getProperty("id")));
        }

        if (e.getSource() == viewSubComponenteEspecial.btnDelete) {
            int resp = JOptionPane.showConfirmDialog(viewSubComponenteEspecial, "¿Esta seguro de eliminar el registro?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp != 1) {
                if (daoComponenteEspecial.delete(componenteEspecial)) {
                    ValidButtonSystem.disableButton(viewSubComponenteEspecial.pnlButton);
                    controlsClear();
                    viewSubComponenteEspecial.btnNew.setEnabled(true);
                    viewSubComponenteEspecial.btnBuscar.setEnabled(true);
                    JOptionPane.showMessageDialog(viewSubComponenteEspecial, "¡ Eliminado con Exito !");
                }
            }
        }
    }

    private void crearTablaCombo() {
        //Combo y valores
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("1|Columna primera");
        comboBox.addItem("2|Columna segunda");
        comboBox.addItem("3|Columna tercera");
        comboBox.addItem("4|Columna cuarta");
        comboBox.addItem("5|Columna quinta");
        comboBox.addItem("6|Longitud ");
        comboBox.addItem("7|Unidad ");
        //se indica que columna tendra el JComboBox
        viewSubComponenteEspecial.tbComponente.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(comboBox));
        viewSubComponenteEspecial.tbComponente.setDefaultRenderer(Object.class, new CellRenderer(3));
    }

    private void comboCorte() {
        JComboBox comboBox = new JComboBox();
        Combos combo = new Combos();
        combo.setSqlConsult(Contans.QUERY_CORTE);
        try {
            combo.setCombo(comboBox);
            viewSubComponenteEspecial.tbComponente.getColumnModel().getColumn(8).setCellEditor(new DefaultCellEditor(comboBox));
            viewSubComponenteEspecial.tbComponente.setDefaultRenderer(Object.class, new CellRenderer(8));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProyectoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == viewSubComponenteEspecial.txtCodigo) {
            ValidEnterCaracter.validMaxCaracter(viewSubComponenteEspecial.txtCodigo, e, 20, viewSubComponenteEspecial);
        }
        if (e.getSource() == viewSubComponenteEspecial.txtDescripcion) {
            ValidEnterCaracter.validMaxCaracter(viewSubComponenteEspecial.txtDescripcion, e, 200, viewSubComponenteEspecial);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == viewSubComponenteEspecial.txtCodigo) {
            if (daoComponenteEspecial.existsComponenteEspecial(viewSubComponenteEspecial.txtCodigo.getText())
                    && viewSubComponenteEspecial.btnSave.isEnabled()) {
                JOptionPane.showMessageDialog(viewSubComponenteEspecial, "¡ Codigo ya Existente en la base de datos !");
                viewSubComponenteEspecial.txtCodigo.setText("");
            }
        }
    }

}
