/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import dao.DaoAcabado;
import generals.Contans;
import generals.ValidButtonSystem;
import generals.ValidControlsSystem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.Acabado;
import views.VAcabado;
import generals.ValidEnterCaracter;
import java.awt.event.KeyEvent;
import generals.ValidEnterCaracter;
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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 *
 * @author Poseidon
 */
public final class AcabadoController implements ActionListener,FocusListener,KeyListener {
    VPrincipal viewPrincipal;
    BusquedaController busquedaC;
    VAcabado viewAcabado;
    Acabado acabado = new Acabado();
    DaoAcabado daoAcabado = new DaoAcabado();

    public AcabadoController(VAcabado viewAcabado, VPrincipal viewPrincipal) {
        this.viewAcabado = viewAcabado;
        start();
        initEvent();
    }

    public AcabadoController(VAcabado viewAcabado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            viewAcabado.btnBuscar.setEnabled(true);
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
                    viewAcabado.btnBuscar.setEnabled(true);
                    JOptionPane.showMessageDialog(viewAcabado, "¡ Registrado con exito !");
                }
            }
        }
        if (e.getSource() == this.viewAcabado.btnBuscar) {
            VBusqueda busqueda = new VBusqueda(viewPrincipal, true);
            busquedaC = new BusquedaController(busqueda, viewAcabado, Contans.QUERY_ACABADO, createColumns());
            busqueda.setVisible(true);
            if (System.getProperty("id") != null || "".equals(System.getProperty("id"))) {
                loadAcabado(Integer.parseInt(System.getProperty("id")));
            }
        }

        if (e.getSource() == viewAcabado.btnEdit) {
            int resp = JOptionPane.showConfirmDialog(viewAcabado, "¿Esta seguro de editar el registro?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp != 1) {
                ValidControlsSystem.enabledControls(viewAcabado.jLayeredPane1);
                ValidButtonSystem.disableButton(viewAcabado.pnlButton);
                viewAcabado.txtCodigo.setEnabled(false);
                viewAcabado.btnSave.setEnabled(true);
                viewAcabado.btnCancel.setEnabled(true);
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


    private void loadAcabado() {

        acabado.setDescripcion(viewAcabado.txtDescripcion.getText());
        acabado.setCodigo(viewAcabado.txtCodigo.getText());
    }
    private void loadAcabado(Object id) {
        if (id != null) {
 
            viewAcabado.txtCodigo.setText(acabado.getCodigo());
            viewAcabado.txtDescripcion.setText(acabado.getDescripcion());
    
             System.out.println(acabado);
            System.setProperty("id", "");
            ValidButtonSystem.enabledButton(viewAcabado.pnlButton);
            viewAcabado.btnSave.setEnabled(false);
            viewAcabado.btnCancel.setEnabled(false);
        }
    }

    private void initEvent() {
        viewAcabado.btnNew.addActionListener(this);
        viewAcabado.btnCancel.addActionListener(this);
        viewAcabado.btnSave.addActionListener(this);
        viewAcabado.btnBuscar.addActionListener(this);
        viewAcabado.txtCodigo.addKeyListener(this);
    }

    public void start() {
        ValidControlsSystem.disableControls(viewAcabado.jLayeredPane1);
        ValidButtonSystem.disableButton(viewAcabado.pnlButton);
        viewAcabado.btnNew.setEnabled(true);
        viewAcabado.btnBuscar.setEnabled(true);
   
        
    }
 
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == viewAcabado.txtCodigo) {
            ValidEnterCaracter.validMaxCaracter(viewAcabado.txtCodigo, e, 2, viewAcabado);
        }
        if (e.getSource() == viewAcabado.txtDescripcion) {
            ValidEnterCaracter.validMaxCaracter(viewAcabado.txtDescripcion, e, 200, viewAcabado);
        }
    }
   
    @Override
    public void keyPressed(KeyEvent e) {
    }

   
    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override 
    public void focusGained(FocusEvent fe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void focusLost(FocusEvent fe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
