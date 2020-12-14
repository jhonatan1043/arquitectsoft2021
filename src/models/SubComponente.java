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
public class SubComponente {

    private int idSubcomponente;
    private int idAcabado;
    private int idUnidad;
    private String codigo;
    private String descripcion;
    private int idUnidadCalculada;
    private int cantDefault;
    private int cantAdicional;
    private boolean aplicaDecremento;

    public SubComponente() {
    }

    public int getIdSubcomponente() {
        return idSubcomponente;
    }

    public void setIdSubcomponente(int idSubcomponente) {
        this.idSubcomponente = idSubcomponente;
    }

    public int getIdAcabado() {
        return idAcabado;
    }

    public void setIdAcabado(int idAcabado) {
        this.idAcabado = idAcabado;
    }

    public int getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(int idUnidad) {
        this.idUnidad = idUnidad;
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

    public int getIdUnidadCalculada() {
        return idUnidadCalculada;
    }

    public void setIdUnidadCalculada(int idUnidadCalculada) {
        this.idUnidadCalculada = idUnidadCalculada;
    }

    public int getCantDefault() {
        return cantDefault;
    }

    public void setCantDefault(int cantDefault) {
        this.cantDefault = cantDefault;
    }

    public int getCantAdicional() {
        return cantAdicional;
    }

    public void setCantAdicional(int cantAdicional) {
        this.cantAdicional = cantAdicional;
    }

    public boolean isAplicaDecremento() {
        return aplicaDecremento;
    }

    public void setAplicaDecremento(boolean aplicaDecremento) {
        this.aplicaDecremento = aplicaDecremento;
    }

    @Override
    public String toString() {
        return "SubComponente{" + "idSubcomponente=" + idSubcomponente
                + ", idAcabado=" + idAcabado
                + ", idUnidad=" + idUnidad
                + ", codigo=" + codigo
                + ", descripcion=" + descripcion
                + ", idUnidadCalculada=" + idUnidadCalculada
                + ", cantDefault=" + cantDefault
                + ", cantAdicional=" + cantAdicional
                + ", aplicaDecremento=" + aplicaDecremento + '}';
    }

}
