/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DaoAcabado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Acabado;
import views.VAcabado;

/**
 *
 * @author Poseidon
 */
public class AcabadoController implements ActionListener {
    VAcabado viewAcabado;
    Acabado acabado =  new Acabado();
    DaoAcabado daoAcabado = new DaoAcabado();
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       
    }
    
    
    
}
