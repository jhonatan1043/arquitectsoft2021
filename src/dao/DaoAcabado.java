/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import generals.Conexion;
import generals.Contans;
import interfaces.IAcabado;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Acabado;


/**
 *
 * @author Poseidon
 */
public class DaoAcabado implements IAcabado {

    @Override
    public boolean save(Acabado acabado) {
        boolean result = false;
        Conexion cnx = new Conexion();
        try {
            try (PreparedStatement psmt = cnx.getConnection().prepareStatement(Contans.QUERY_INSERT_ACABADOS)) {
                psmt.setInt(1, acabado.getCodigo());
                psmt.setString(2, acabado.getDescripcion());
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
    public boolean update(Acabado acabado) {
        boolean result = false;
        Conexion cnx = new Conexion();
        try {
            try (PreparedStatement psmt = cnx.getConnection().prepareStatement(Contans.QUERY_UPDATE_SUBCOMPONENTES)) {
                psmt.setInt(3, acabado.getCodigo());
                psmt.setString(4, acabado.getDescripcion());
            int affectedRows = psmt.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("No se pudo actualizar");
                }
                
                result = true;
                cnx.getConnection().close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoSubComponente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    @Override
    public boolean delete(Acabado Acabado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Acabado> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Acabado getPerfilComponente(int idAcabado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

