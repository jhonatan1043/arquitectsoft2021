/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Acabado;

/**
 *
 * @author danid
 */
public interface IAcabado {

    public boolean save(Acabado corte);

    public boolean update(Acabado corte);

    public boolean delete(Acabado corte);

    public List<Acabado> listar();

    public Acabado getPerfilComponente(int idCorte);
}
