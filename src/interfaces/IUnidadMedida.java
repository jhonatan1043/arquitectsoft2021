/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.UnidadMedida;

/**
 *
 * @author Poseidon
 */
public interface IUnidadMedida {

    public boolean save(UnidadMedida UnidadMedida);

    public boolean update(UnidadMedida UnidadMedida);

    public boolean delete(UnidadMedida UnidadMedida);

    public List<UnidadMedida> listar();

    public UnidadMedida getPerfilComponente(int idUnidadMedida);
}
