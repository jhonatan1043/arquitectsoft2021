/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import javax.swing.table.TableModel;

/**
 *
 * @author Programador 1
 */
public interface IProyecto {
    
    public ArrayList<Object[]> getComponenteCalc(TableModel modelo);
    
}
