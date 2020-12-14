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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.SubComponente;

/**
 *
 * @author Programador 1
 */
public class SubComponenteController implements ActionListener {

    VSubComponente viewSubcomponente;
    DaoSubComponente eSubcomponente = new DaoSubComponente();
    SubComponente subcomponente = new SubComponente();

    public SubComponenteController(VSubComponente viewSubcomponente) {
        this.viewSubcomponente = viewSubcomponente;
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
        }

        if (e.getSource() == this.viewSubcomponente.btnSave) {
            if (this.validControls()) {
                this.loadSubComponente();
                if (eSubcomponente.save(subcomponente)) {
                    ValidControlsSystem.disableControls(viewSubcomponente.jLayeredPane1);
                    ValidButtonSystem.disableButton(viewSubcomponente.pnlButton);
                    viewSubcomponente.btnNew.setEnabled(true);
                    JOptionPane.showMessageDialog(viewSubcomponente, "¡ Registrado con exito !");
                }
            }
        }
    }

    private boolean validControls() {
        boolean result = false;
        if ("".equals(viewSubcomponente.txtDescripcion.getText())
                || viewSubcomponente.cbAcabado.getSelectedIndex() == 0
                || viewSubcomponente.cbUnidad.getSelectedIndex() == 0
                || "".equals(viewSubcomponente.txtCodigo.getText())
                ||viewSubcomponente.cbUnidadCalculada.getSelectedIndex() == 0 ) {
            JOptionPane.showMessageDialog(viewSubcomponente, "¡ hay Datos sin realizar !");
        } else {
            result = true;
        }
        return result;
    }

    private void loadSubComponente() {
        String idAcabado = viewSubcomponente.cbAcabado.getSelectedItem().toString().split("|")[0];
        String idUnidadMedida = viewSubcomponente.cbUnidad.getSelectedItem().toString().split("|")[0];
        int cantidadDefauld = (int)viewSubcomponente.txtCantidadDefauld.getValue();
        int cantidadAdicional = (int)viewSubcomponente.txtCantidadAdicional.getValue();
        
        subcomponente.setCodigo(viewSubcomponente.txtCodigo.getText());
        subcomponente.setDescripcion(viewSubcomponente.txtDescripcion.getText());
        subcomponente.setIdAcabado(Integer.parseInt(idAcabado));
        subcomponente.setIdUnidad(Integer.parseInt(idUnidadMedida));
        subcomponente.setIdUnidadCalculada(viewSubcomponente.cbUnidadCalculada.getSelectedIndex());
        subcomponente.setCantDefault(cantidadDefauld);
        subcomponente.setAplicaDecremento(viewSubcomponente.ckAplicaDecremento.isSelected());
        subcomponente.setCantAdicional(cantidadAdicional);
        
    }

    private void start() {
        ValidControlsSystem.disableControls(viewSubcomponente.jLayeredPane1);
        ValidButtonSystem.disableButton(viewSubcomponente.pnlButton);
        this.loadComboAcabados();
        this.loadComboUnidadMedicas();
        initEvent();
        viewSubcomponente.btnNew.setEnabled(true);
    }

    private void loadComboAcabados() {
        Combos combo = new Combos();
        combo.setSqlConsult(Contans.QUERY_ACABADO);
        try {
            combo.setCombo(viewSubcomponente.cbAcabado);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComponenteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadComboUnidadMedicas() {
        Combos combo = new Combos();
        combo.setSqlConsult(Contans.QUERY_UNIDAD_MEDIDA);
        try {
            combo.setCombo(viewSubcomponente.cbUnidad);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComponenteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initEvent() {
        viewSubcomponente.btnNew.addActionListener(this);
        viewSubcomponente.btnCancel.addActionListener(this);
        viewSubcomponente.btnSave.addActionListener(this);
    }

    private void controlsClean() {
        viewSubcomponente.txtCodigo.setText("");
        viewSubcomponente.txtDescripcion.setText("");
        viewSubcomponente.cbAcabado.setSelectedIndex(0);
        viewSubcomponente.cbUnidad.setSelectedIndex(0);
        viewSubcomponente.cbUnidadCalculada.setSelectedIndex(0);
    }

}
