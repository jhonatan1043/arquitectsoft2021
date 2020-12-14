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
public class UnidadMedida {

    private int idUnidad;
    private String descripcion;
    private String convencion;
    
    public UnidadMedida(){}
    
    public UnidadMedida(int idUnidad, String descripcion, String convencion){
        this.idUnidad = idUnidad;
        this.descripcion = descripcion;
        this.convencion = convencion;
    }

    public int getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(int idUnidad) {
        this.idUnidad = idUnidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getConvencion() {
        return convencion;
    }

    public void setConvencion(String convencion) {
        this.convencion = convencion;
    }

}
