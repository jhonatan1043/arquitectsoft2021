/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Programador 1
 */
public class Acabado {

    private int idAcabado;
    private String descripcion;

    public Acabado() {
    }

    public Acabado(int idAcabado, String descripcion) {
      this.idAcabado = idAcabado;
      this.descripcion = descripcion;
    }

    public int getIdAcabado() {
        return idAcabado;
    }

    public void setIdAcabado(int idAcabado) {
        this.idAcabado = idAcabado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
