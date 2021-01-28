/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DaoComponente;
import generals.CellRenderer;
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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Componente;
import views.VBusqueda;
import views.VComponente;
import views.VPrincipal;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
/**
 *
 * @author Programador 1
 */
public class ComponenteController implements ActionListener, KeyListener, FocusListener {

    DefaultTableModel modelo;
    VComponente viewComponente;
    VPrincipal viewPrincipal;
    Componente componente = new Componente();
    DaoComponente daoComponente = new DaoComponente();

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
        crearTablaCombo();
        modelo = (DefaultTableModel) viewComponente.tbComponente.getModel();
        viewComponente.tbComponente.setEnabled(false);
        viewComponente.btnNew.setEnabled(true);
        viewComponente.btnBuscar.setEnabled(true);  
    }

    private void initEvent() {
        viewComponente.btnNew.addActionListener(this);
        viewComponente.btnCancel.addActionListener(this);
        viewComponente.btnSave.addActionListener(this);
        viewComponente.btnAgregar.addActionListener(this);
        viewComponente.btnQuitar.addActionListener(this);
        viewComponente.btnDelete.addActionListener(this);
        viewComponente.btnBuscar.addActionListener(this);
        viewComponente.btnEdit.addActionListener(this);
        viewComponente.txtCodigo.addKeyListener(this);
        viewComponente.txtDescripcion.addKeyListener(this);
        viewComponente.txtCodigo.addFocusListener(this);
    }

    private void hideColumns() {
        int[] list = {0};
        ValidTable.hideColumnsTable(viewComponente.tbComponente, list);
    }

    private void loadSubComponente(int id) {
        if (id != 0) {
            Object[] list = daoComponente.getSubComponente(id);
            modelo.addRow(list);
            System.setProperty("id", "");
        }
    }

    private void loadComponente(int id) {
        if (id != 0) {

            modelo.setRowCount(0);

            componente = daoComponente.getComponte(id);

            viewComponente.txtCodigo.setText(componente.getCodigo());
            viewComponente.txtDescripcion.setText(componente.getDescripcion());

            ArrayList<Object[]> list = daoComponente.getComponenteDetalle(id);

            list.forEach((list1) -> {
                modelo.addRow(list1);
            });

            System.setProperty("id", "");
            ValidButtonSystem.enabledButton(viewComponente.pnlButton);
           // ValidTable.enableColumnsTableComponente(viewComponente.tbComponente);
            viewComponente.btnSave.setEnabled(false);
            viewComponente.btnCancel.setEnabled(false);
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
        componente.setCodigo(viewComponente.txtCodigo.getText());
        componente.setDescripcion(viewComponente.txtDescripcion.getText());;
        componente.setModelo((DefaultTableModel) viewComponente.tbComponente.getModel());
    }

    private void controlsClear() {
        componente = new Componente();
        viewComponente.txtCodigo.setText("");
        viewComponente.txtDescripcion.setText("");
        modelo.setRowCount(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == viewComponente.btnNew) {
            ValidControlsSystem.enabledControls(viewComponente.jLayeredPane1);
            ValidButtonSystem.disableButton(viewComponente.pnlButton);
            controlsClear();
            viewComponente.tbComponente.setEnabled(true);
            viewComponente.btnSave.setEnabled(true);
            viewComponente.btnCancel.setEnabled(true);
        }

        if (e.getSource() == viewComponente.btnCancel) {
            ValidControlsSystem.disableControls(viewComponente.jLayeredPane1);
            controlsClear();
            ValidButtonSystem.disableButton(viewComponente.pnlButton);
            viewComponente.tbComponente.setEnabled(false);
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

        if (e.getSource() == viewComponente.btnSave) {
            boolean resultado;

            if ("".equals(viewComponente.txtCodigo.getText())
                    || "".equals(viewComponente.txtDescripcion.getText())
                    || viewComponente.tbComponente.getRowCount() == 0) {
                JOptionPane.showMessageDialog(viewComponente, "¡ hay Datos sin realizar !");
            } else {
                loadComponente();

                if (componente.getIdComponente() != 0) {
                    resultado = daoComponente.update(componente);
                } else {
                    resultado = daoComponente.save(componente);
                }

                if (resultado) {
                    ValidControlsSystem.disableControls(viewComponente.jLayeredPane1);
                    ValidButtonSystem.enabledButton(viewComponente.pnlButton);
                    viewComponente.tbComponente.setEnabled(false);
                    viewComponente.btnSave.setEnabled(false);
                    viewComponente.btnCancel.setEnabled(false);
                    JOptionPane.showMessageDialog(viewComponente, "¡ Registrado con exito !");
                }
            }
        }

        if (e.getSource() == viewComponente.btnEdit) {
            int resp = JOptionPane.showConfirmDialog(viewComponente, "¿Esta seguro de editar el registro?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp != 1) {
                ValidControlsSystem.enabledControls(viewComponente.jLayeredPane1);
                ValidButtonSystem.disableButton(viewComponente.pnlButton);
                viewComponente.tbComponente.setEnabled(true);
                viewComponente.txtCodigo.setEnabled(false);
                viewComponente.btnSave.setEnabled(true);
                viewComponente.btnCancel.setEnabled(true);
            }
        }

        if (e.getSource() == viewComponente.btnBuscar) {
            VBusqueda viewBusqueda = new VBusqueda(viewPrincipal, true);
            BusquedaController busquedaC = new BusquedaController(viewBusqueda,
                    viewComponente,
                    Contans.QUERY_COMPONENTES_LISTAR,
                    createColumns());
            viewBusqueda.setVisible(true);
            loadComponente(Integer.parseInt(System.getProperty("id")));
        }

        if (e.getSource() == viewComponente.btnDelete) {
            int resp = JOptionPane.showConfirmDialog(viewComponente, "¿Esta seguro de eliminar el registro?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp != 1) {
                if (daoComponente.delete(componente)) {
                    ValidButtonSystem.disableButton(viewComponente.pnlButton);
                    controlsClear();
                    viewComponente.btnNew.setEnabled(true);
                    viewComponente.btnBuscar.setEnabled(true);
                    JOptionPane.showMessageDialog(viewComponente, "¡ Eliminado con Exito !");
                }
            }
        }
    }
    
       private void crearTablaCombo() {
        //Combo y valores
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("1|Longitud");
        comboBox.addItem("2|Unidad");
        comboBox.addItem("3|Cantidad");
        comboBox.addItem("4|Por su cantidad");
        //se indica que columna tendra el JComboBox
        viewComponente.tbComponente.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(comboBox));        
        viewComponente.tbComponente.setDefaultRenderer(Object.class, new CellRenderer(3));
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == viewComponente.txtCodigo) {
            ValidEnterCaracter.validMaxCaracter(viewComponente.txtCodigo, e, 20, viewComponente);
        }
        if (e.getSource() == viewComponente.txtDescripcion) {
            ValidEnterCaracter.validMaxCaracter(viewComponente.txtDescripcion, e, 200, viewComponente);
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
        if (e.getSource() == viewComponente.txtCodigo) {
            if (daoComponente.existsComponente(viewComponente.txtCodigo.getText())
                    && viewComponente.btnSave.isEnabled()) {
                JOptionPane.showMessageDialog(viewComponente, "¡ Codigo ya Existente en la base de datos !");
                viewComponente.txtCodigo.setText("");
            }
        }
    }

}
