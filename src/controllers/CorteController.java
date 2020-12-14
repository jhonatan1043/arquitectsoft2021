/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DaoCorte;
import generals.ValidButtonSystem;
import generals.ValidControlsSystem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.Corte;
import views.VCorte;

/**
 *
 * @author Poseidon
 */
public final class CorteController implements ActionListener {

   VCorte viewCorte;
    Corte corte = new Corte();
    DaoCorte daoUnidadMedida = new DaoCorte();

    public CorteController(VCorte viewCorte) {
        this.viewCorte = viewCorte;
        start();
        initEvent();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewCorte.btnNew) {
            ValidControlsSystem.enabledControls(viewCorte.jLayeredPane1);
            ValidButtonSystem.disableButton(viewCorte.pnlButton);
            viewCorte.btnSave.setEnabled(true);
            viewCorte.btnCancel.setEnabled(true);
        }
        if (e.getSource() == viewCorte.btnCancel) {
            ValidControlsSystem.disableControls(viewCorte.jLayeredPane1);
            ValidButtonSystem.disableButton(viewCorte.pnlButton);
            viewCorte.btnNew.setEnabled(true);
        }
        if (e.getSource() == viewCorte.btnSave) {
            if ("".equals(viewCorte.spCorteDerecho.getValue()) || 
                    "".equals(viewCorte.spCorteIzquierdo.getValue())
                    || "".equals(viewCorte.txtConvencion.getText())) {
                JOptionPane.showMessageDialog(viewCorte, "¡ hay Datos sin realizar !");
            } else {
                loadCorte();
                if (daoUnidadMedida.save(corte)) {
                    ValidControlsSystem.disableControls(viewCorte.jLayeredPane1);
                    ValidButtonSystem.disableButton(viewCorte.pnlButton);
                    viewCorte.btnNew.setEnabled(true);
                    JOptionPane.showMessageDialog(viewCorte, "¡ Registrado con exito !");
                }
            }
        }
    }

    private void loadCorte() {
      corte.setConvencion(viewCorte.txtConvencion.getText());
      corte.setCorteDerecho((int)viewCorte.spCorteDerecho.getValue());
      corte.setCorteIzquierdo((int)viewCorte.spCorteIzquierdo.getValue());
    }

    private void initEvent() {
        viewCorte.btnNew.addActionListener(this);
        viewCorte.btnCancel.addActionListener(this);
        viewCorte.btnSave.addActionListener(this);
    }

    public void start() {
        ValidControlsSystem.disableControls(viewCorte.jLayeredPane1);
        ValidButtonSystem.disableButton(viewCorte.pnlButton);
        viewCorte.btnNew.setEnabled(true);
    }
    
}
