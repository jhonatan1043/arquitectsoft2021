/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableModel;
import models.Componente;

/**
 *
 * @author Programador 1
 */
public interface IComponente {

    public boolean save(Componente componente);

    public boolean update(Componente componente);

    public boolean delete(Componente componente);

    public List<Componente> listar();

    public Componente getComponte(int idComponente);

    public ArrayList<ArrayList<Object[]>> getSubComponenteCalc(TableModel modelo);

    public Object[] getSubComponente(int idSubComponente);
}
