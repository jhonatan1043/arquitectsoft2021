/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Programador 1
 */
public class Componente {

    private int idComponente;
    private String codigo;
    private String descripcion;
    private boolean noSubComponente;
    private DefaultTableModel modelo;

    public Componente() {
    }

    
    public boolean isNoSubComponente() {
        return noSubComponente;
    }

    public void setNoSubComponente(boolean noSubComponente) {
        this.noSubComponente = noSubComponente;
    }
    
    public int getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(int idComponente) {
        this.idComponente = idComponente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

}
