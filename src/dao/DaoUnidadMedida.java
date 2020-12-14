/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import generals.Conexion;
import generals.Contans;
import interfaces.IUnidadMedida;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.UnidadMedida;

/**
 *
 * @author Poseidon
 */
public class DaoUnidadMedida implements IUnidadMedida {

    @Override
    public boolean save(UnidadMedida unidadMedida) {
        boolean result = false;
        Conexion cnx = new Conexion();
        try {
            try (PreparedStatement psmt = cnx.getConnection().prepareStatement(Contans.QUERY_INSERT_UNIDAD_MEDIDA)) {
                psmt.setString(1, unidadMedida.getDescripcion());
                psmt.setString(2, unidadMedida.getConvencion());
                psmt.execute();
                cnx.getConnection().close();
                psmt.close();
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoSubComponente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean update(UnidadMedida UnidadMedida) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(UnidadMedida UnidadMedida) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UnidadMedida> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UnidadMedida getPerfilComponente(int idUnidadMedida) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
