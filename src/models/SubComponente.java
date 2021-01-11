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
    private String Acabado;
    private String codigo;
    private String descripcion;
    private int idUnidadCalculada;

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

    public String getAcabado() {
        return Acabado;
    }

    public void setAcabado(String Acabado) {
        this.Acabado = Acabado;
    }

    @Override
    public String toString() {
        return "SubComponente{" + "idSubcomponente=" + idSubcomponente
                + ", idAcabado=" + idAcabado
                + ", codigo=" + codigo
                + ", descripcion=" + descripcion
                + ", idUnidadCalculada=" + idUnidadCalculada;

    }

}
