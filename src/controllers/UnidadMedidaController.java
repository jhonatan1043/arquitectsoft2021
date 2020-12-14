/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DaoUnidadMedida;
import generals.ValidButtonSystem;
import generals.ValidControlsSystem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.UnidadMedida;
import views.VUnidadMedida;

/**
 *
 * @author Poseidon
 */
public final class UnidadMedidaController implements ActionListener {

    VUnidadMedida viewUnidadMedida;
    UnidadMedida unidadMedida = new UnidadMedida();
    DaoUnidadMedida daoUnidadMedida = new DaoUnidadMedida();

    public UnidadMedidaController(VUnidadMedida viewUnidadMedida) {
        this.viewUnidadMedida = viewUnidadMedida;
        start();
        initEvent();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewUnidadMedida.btnNew) {
            ValidControlsSystem.enabledControls(viewUnidadMedida.jLayeredPane1);
            ValidButtonSystem.disableButton(viewUnidadMedida.pnlButton);
            viewUnidadMedida.btnSave.setEnabled(true);
            viewUnidadMedida.btnCancel.setEnabled(true);
        }
        if (e.getSource() == viewUnidadMedida.btnCancel) {
            ValidControlsSystem.disableControls(viewUnidadMedida.jLayeredPane1);
            ValidButtonSystem.disableButton(viewUnidadMedida.pnlButton);
            viewUnidadMedida.btnNew.setEnabled(true);
        }
        if (e.getSource() == viewUnidadMedida.btnSave) {
            if ("".equals(viewUnidadMedida.txtDescripcion.getText())
                    || "".equals(viewUnidadMedida.txtConvencion.getText())) {
                JOptionPane.showMessageDialog(viewUnidadMedida, "¡ hay Datos sin realizar !");
            } else {
                loadUnidadMedida();

                if (daoUnidadMedida.save(unidadMedida)) {
                    ValidControlsSystem.disableControls(viewUnidadMedida.jLayeredPane1);
                    ValidButtonSystem.disableButton(viewUnidadMedida.pnlButton);
                    viewUnidadMedida.btnNew.setEnabled(true);
                    JOptionPane.showMessageDialog(viewUnidadMedida, "¡ Registrado con exito !");
                }
            }
        }
    }

    private void loadUnidadMedida() {
        unidadMedida.setDescripcion(viewUnidadMedida.txtDescripcion.getText());
        unidadMedida.setConvencion(viewUnidadMedida.txtConvencion.getText());
    }

    private void initEvent() {
        viewUnidadMedida.btnNew.addActionListener(this);
        viewUnidadMedida.btnCancel.addActionListener(this);
        viewUnidadMedida.btnSave.addActionListener(this);
    }

    public void start() {
        ValidControlsSystem.disableControls(viewUnidadMedida.jLayeredPane1);
        ValidButtonSystem.disableButton(viewUnidadMedida.pnlButton);
        viewUnidadMedida.btnNew.setEnabled(true);
    }

}
