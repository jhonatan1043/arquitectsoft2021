/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Corte;

/**
 *
 * @author Poseidon
 */
public interface ICorte {

    public boolean save(Corte corte);

    public boolean update(Corte corte);

    public boolean delete(Corte corte);

    public List<Corte> listar();

    public Corte getPerfilComponente(int idCorte);
}
