/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;



import java.util.List;
import models.SubComponente;
/**
 *
 * @author Programador 1
 */
public interface ISubComponente {
    
    public boolean save(SubComponente idSubcomponente);
    public boolean update(SubComponente idSubcomponente);
    public boolean delete(SubComponente idSubcomponente);
    public List<SubComponente> listar();
    public SubComponente getSubcomponente(int idSubcomponente);
    public boolean existsSubcomponente(String codigo);
}
