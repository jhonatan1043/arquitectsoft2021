/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Proyecto;

/**
 *
 * @author Programador 1
 */
public interface IProyecto {

    public boolean save(Proyecto componente);

    public boolean update(Proyecto componente);

    public boolean delete(Proyecto componente);

    public List<Proyecto> listar();

    public Proyecto getComponente(int idComponente);

    public Object[] getSubComponente(int idSubComponente, int logitud, int anchura, int altura, int area);
}
