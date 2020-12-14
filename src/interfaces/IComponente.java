/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Componente;

/**
 *
 * @author Programador 1
 */
public interface IComponente {
    public boolean save(Componente perfilComponente);
    public boolean update(Componente perfilComponente);
    public boolean delete(Componente perfilComponente);
    public List<Componente> listar();
    public Componente getPerfilComponente(int idPerfil);
}
