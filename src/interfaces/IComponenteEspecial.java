/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import javax.swing.table.TableModel;
import models.ComponenteEspecial;

/**
 *
 * @author Programador 1
 */
public interface IComponenteEspecial {

    public boolean save(ComponenteEspecial componenteEspecial);

    public boolean update(ComponenteEspecial componenteEspecial);

    public boolean delete(ComponenteEspecial componenteEspecial);

    public ComponenteEspecial getComponenteEspecial(int idComponente);

    public ArrayList<Object[]> getComponenteEspecialDetalle(int idSubComponente);

    public ArrayList<Object[]> getSubComponenteEspecialCalc(TableModel modelo);

    public Object[] getSubComponenteEspecial(int idSubComponente);

    public boolean existsComponenteEspecial(String codigo);
    
    public boolean saveAuxAnchura(TableModel modelo);
}
