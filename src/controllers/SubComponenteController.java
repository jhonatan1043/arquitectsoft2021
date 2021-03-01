/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import views.VSubComponente;
import dao.DaoSubComponente;
import generals.Combos;
import generals.Contans;
import generals.ValidButtonSystem;
import generals.ValidControlsSystem;
import generals.ValidEnterCaracter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.SubComponente;
import views.VBusqueda;
import views.VPrincipal;

/**
 *
 * @author Programador 1
 */
public class SubComponenteController implements ActionListener, FocusListener, KeyListener {

    VPrincipal viewPrincipal;
    BusquedaController busquedaC;
    VSubComponente viewSubcomponente;
    DaoSubComponente eSubcomponente = new DaoSubComponente();
    SubComponente subcomponente = new SubComponente();

    public SubComponenteController(VSubComponente viewSubcomponente, VPrincipal viewPrincipal) {
        this.viewSubcomponente = viewSubcomponente;
        this.viewPrincipal = viewPrincipal;
        this.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.viewSubcomponente.btnNew) {
            ValidControlsSystem.enabledControls(viewSubcomponente.jLayeredPane1);
            ValidButtonSystem.disableButton(viewSubcomponente.pnlButton);
            controlsClean();
            viewSubcomponente.btnSave.setEnabled(true);
            viewSubcomponente.btnCancel.setEnabled(true);

        }

        if (e.getSource() == this.viewSubcomponente.btnCancel) {
            ValidControlsSystem.disableControls(viewSubcomponente.jLayeredPane1);
            ValidButtonSystem.disableButton(viewSubcomponente.pnlButton);
            controlsClean();
            viewSubcomponente.btnNew.setEnabled(true);
            viewSubcomponente.btnBuscar.setEnabled(true);
        }

        if (e.getSource() == this.viewSubcomponente.btnSave) {
            if (this.validControls()) {
                this.loadSubComponente();
                boolean respuesta;

                if (subcomponente.getIdSubcomponente() == 0) {
                    respuesta = eSubcomponente.save(subcomponente);
                } else {
                    respuesta = eSubcomponente.update(subcomponente);
                }

                if (respuesta) {
                    ValidControlsSystem.disableControls(viewSubcomponente.jLayeredPane1);
                    ValidButtonSystem.enabledButton(viewSubcomponente.pnlButton);
                    viewSubcomponente.btnSave.setEnabled(false);
                    viewSubcomponente.btnCancel.setEnabled(false);
                    JOptionPane.showMessageDialog(viewSubcomponente, "¡ Registrado con exito !");
                }
            }
        }
        if (e.getSource() == this.viewSubcomponente.btnBuscar) {
            VBusqueda busqueda = new VBusqueda(viewPrincipal, true);
            busquedaC = new BusquedaController(busqueda, viewSubcomponente, Contans.QUERY_SUBCOMPONENTES, createColumns());
            busqueda.setVisible(true);
            if (System.getProperty("id") != null || "".equals(System.getProperty("id"))) {
                loadSubComponente(Integer.parseInt(System.getProperty("id")));
            }
        }

        if (e.getSource() == viewSubcomponente.btnEdit) {
            int resp = JOptionPane.showConfirmDialog(viewSubcomponente, "¿Esta seguro de editar el registro?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp != 1) {
                ValidControlsSystem.enabledControls(viewSubcomponente.jLayeredPane1);
                ValidButtonSystem.disableButton(viewSubcomponente.pnlButton);
                viewSubcomponente.txtCodigo.setEnabled(false);
                viewSubcomponente.btnSave.setEnabled(true);
                viewSubcomponente.btnCancel.setEnabled(true);
            }
        }

        if (e.getSource() == viewSubcomponente.btnDelete) {
            int resp = JOptionPane.showConfirmDialog(viewSubcomponente, "¿Esta seguro de eliminar el registro?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp != 1) {
                if (eSubcomponente.delete(subcomponente)) {
                    ValidButtonSystem.disableButton(viewSubcomponente.pnlButton);
                    controlsClean();
                    viewSubcomponente.btnNew.setEnabled(true);
                    viewSubcomponente.btnBuscar.setEnabled(true);
                    JOptionPane.showMessageDialog(viewSubcomponente, "¡ Eliminado con Exito !");
                }
            }
        }
    }

    private ArrayList<String> createColumns() {
        ArrayList<String> listColumns = new ArrayList<>();
        listColumns.add("Id");
        listColumns.add("Codigo");
        listColumns.add("Descripcion");
        return listColumns;
    }

    private boolean validControls() {
        boolean result = false;
        if ("".equals(viewSubcomponente.txtDescripcion.getText())
                || viewSubcomponente.cbAcabado.getSelectedIndex() == 0
                || "".equals(viewSubcomponente.txtCodigo.getText())) {
            JOptionPane.showMessageDialog(viewSubcomponente, "¡ hay Datos sin realizar !");
        } else {
            result = true;
        }
        return result;
    }

    private void loadSubComponente() {
        int idAcabado = viewSubcomponente.cbAcabado.getSelectedIndex();
        subcomponente.setCodigo(viewSubcomponente.txtCodigo.getText());
        subcomponente.setDescripcion(viewSubcomponente.txtDescripcion.getText());
        subcomponente.setIdAcabado(idAcabado);
        subcomponente.setEspecial(viewSubcomponente.ckComponenteEspecial.isSelected());
    }

    private void loadSubComponente(Object id) {
        if (id != null) {
            subcomponente = eSubcomponente.getSubcomponente((int) id);
            viewSubcomponente.txtCodigo.setText(subcomponente.getCodigo());
            viewSubcomponente.txtDescripcion.setText(subcomponente.getDescripcion());
            viewSubcomponente.cbAcabado.setSelectedIndex(subcomponente.getIdAcabado());
             viewSubcomponente.ckComponenteEspecial.setSelected(subcomponente.isEspecial());
             System.out.println(subcomponente);
            System.setProperty("id", "");
            ValidButtonSystem.enabledButton(viewSubcomponente.pnlButton);
            viewSubcomponente.btnSave.setEnabled(false);
            viewSubcomponente.btnCancel.setEnabled(false);
        }
    }

    private void start() {
        ValidControlsSystem.disableControls(viewSubcomponente.jLayeredPane1);
        ValidButtonSystem.disableButton(viewSubcomponente.pnlButton);
        this.loadComboAcabados();
        initEvent();
        viewSubcomponente.btnNew.setEnabled(true);
        viewSubcomponente.btnBuscar.setEnabled(true);
    }

    private void loadComboAcabados() {
        Combos combo = new Combos();
        combo.setSqlConsult(Contans.QUERY_ACABADO);
        try {
            combo.setCombo(viewSubcomponente.cbAcabado);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProyectoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initEvent() {
        viewSubcomponente.btnNew.addActionListener(this);
        viewSubcomponente.btnCancel.addActionListener(this);
        viewSubcomponente.btnSave.addActionListener(this);
        viewSubcomponente.btnBuscar.addActionListener(this);
        viewSubcomponente.btnEdit.addActionListener(this);
        viewSubcomponente.btnDelete.addActionListener(this);
        viewSubcomponente.txtCodigo.addKeyListener(this);
        viewSubcomponente.txtDescripcion.addKeyListener(this);
        viewSubcomponente.txtCodigo.addFocusListener(this);
    }

    private void controlsClean() {

        subcomponente = new SubComponente();
        viewSubcomponente.txtCodigo.setText("");
        viewSubcomponente.txtDescripcion.setText("");
        viewSubcomponente.cbAcabado.setSelectedIndex(0);
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == viewSubcomponente.txtCodigo) {
            if (eSubcomponente.existsSubcomponente(viewSubcomponente.txtCodigo.getText())
                    && viewSubcomponente.btnSave.isEnabled()) {
                JOptionPane.showMessageDialog(viewSubcomponente, "¡ Codigo ya Existente en la base de datos !");
                viewSubcomponente.txtCodigo.setText("");
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == viewSubcomponente.txtCodigo) {
            ValidEnterCaracter.validMaxCaracter(viewSubcomponente.txtCodigo, e, 20, viewSubcomponente);
        }
        if (e.getSource() == viewSubcomponente.txtDescripcion) {
            ValidEnterCaracter.validMaxCaracter(viewSubcomponente.txtDescripcion, e, 200, viewSubcomponente);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
