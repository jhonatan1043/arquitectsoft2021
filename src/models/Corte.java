/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Poseidon
 */
public class Corte {

    public int getIdCorte() {
        return idCorte;
    }

    public void setIdCorte(int idCorte) {
        this.idCorte = idCorte;
    }

    public String getConvencion() {
        return convencion;
    }

    public void setConvencion(String convencion) {
        this.convencion = convencion;
    }

    public int getCorteDerecho() {
        return corteDerecho;
    }

    public void setCorteDerecho(int corteDerecho) {
        this.corteDerecho = corteDerecho;
    }

    public int getCorteIzquierdo() {
        return corteIzquierdo;
    }

    public void setCorteIzquierdo(int corteIzquierdo) {
        this.corteIzquierdo = corteIzquierdo;
    }
    private int idCorte;
    private String convencion;
    private int corteDerecho;
    private int corteIzquierdo;
    
}
