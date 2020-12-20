/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DaoAcabado;
import generals.ValidButtonSystem;
import generals.ValidControlsSystem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.Acabado;
import views.VAcabado;

/**
 *
 * @author Poseidon
 */
public final class AcabadoController implements ActionListener {

    VAcabado viewAcabado;
    Acabado acabado = new Acabado();
    DaoAcabado daoAcabado = new DaoAcabado();

    public AcabadoController(VAcabado viewAcabado) {
        this.viewAcabado = viewAcabado;
        start();
        initEvent();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewAcabado.btnNew) {
            ValidControlsSystem.enabledControls(viewAcabado.jLayeredPane1);
            ValidButtonSystem.disableButton(viewAcabado.pnlButton);
            viewAcabado.btnSave.setEnabled(true);
            viewAcabado.btnCancel.setEnabled(true);
        }
        if (e.getSource() == viewAcabado.btnCancel) {
            ValidControlsSystem.disableControls(viewAcabado.jLayeredPane1);
            ValidButtonSystem.disableButton(viewAcabado.pnlButton);
            viewAcabado.btnNew.setEnabled(true);
        }
        if (e.getSource() == viewAcabado.btnSave) {

            if ("".equals(viewAcabado.txtDescripcion.getText()) || "".equals(viewAcabado.txtCodigo.getText())) {
                JOptionPane.showMessageDialog(viewAcabado, "¡ hay Datos sin realizar !");
            } else {
                loadAcabado();
                if (daoAcabado.save(acabado)) {
                    ValidControlsSystem.disableControls(viewAcabado.jLayeredPane1);
                    ValidButtonSystem.disableButton(viewAcabado.pnlButton);
                    viewAcabado.btnNew.setEnabled(true);
                    JOptionPane.showMessageDialog(viewAcabado, "¡ Registrado con exito !");
                }
            }
        }
    }

    private void loadAcabado() {
        acabado.setDescripcion(viewAcabado.txtDescripcion.getText());
        acabado.setCodigo(Integer.parseInt(viewAcabado.txtCodigo.getText()));
    }

    private void initEvent() {
        viewAcabado.btnNew.addActionListener(this);
        viewAcabado.btnCancel.addActionListener(this);
        viewAcabado.btnSave.addActionListener(this);
    }

    public void start() {
        ValidControlsSystem.disableControls(viewAcabado.jLayeredPane1);
        ValidButtonSystem.disableButton(viewAcabado.pnlButton);
        viewAcabado.btnNew.setEnabled(true);
    }
    
}
