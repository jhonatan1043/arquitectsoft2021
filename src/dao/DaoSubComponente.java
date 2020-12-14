/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import generals.Conexion;
import generals.Contans;
import generals.Querys;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.SubComponente;
import interfaces.ISubComponente;
import java.sql.PreparedStatement;

/**
 *
 * @author Programador 1
 */
public class DaoSubComponente implements ISubComponente {

    Querys query = new Querys();

    @Override
    public boolean save(SubComponente subcomponente) {  
        boolean result = false;
        Conexion cnx = new Conexion();
        try {   
            try (PreparedStatement psmt = cnx.getConnection().prepareStatement(Contans.QUERY_INSERT_SUBCOMPONENTES)) {
                psmt.setInt(1, subcomponente.getIdAcabado());
                psmt.setInt(2, subcomponente.getIdUnidad());
                psmt.setString(3, subcomponente.getCodigo());
                psmt.setString(4, subcomponente.getDescripcion());
                psmt.setInt(5, subcomponente.getIdUnidadCalculada());
                psmt.setInt(6, subcomponente.getCantDefault());
                psmt.setBoolean(7, subcomponente.isAplicaDecremento());
                psmt.setInt(8, subcomponente.getCantAdicional());
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
    public boolean update(SubComponente subcomponente) {
            boolean result = false;
        Conexion cnx = new Conexion();
        try {   
            try (PreparedStatement psmt = cnx.getConnection().prepareStatement(Contans.QUERY_UPDATE_SUBCOMPONENTES)) {
                psmt.setInt(1, subcomponente.getIdAcabado());
                psmt.setInt(2, subcomponente.getIdUnidad());
                psmt.setString(3, subcomponente.getCodigo());
                psmt.setString(4, subcomponente.getDescripcion());
                psmt.setInt(5, subcomponente.getIdSubcomponente());
                psmt.execute();
                result = true;
                cnx.getConnection().close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoSubComponente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean delete(SubComponente componente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SubComponente> listar() {
        List<SubComponente> listComponente = new ArrayList<>();
        ResultSet result = query.queryListComponente(Contans.QUERY_COMPONENTES);
        try {
            while (result.next()) {
                SubComponente componente = new SubComponente();
                componente.setIdSubcomponente(result.getInt(0));
                componente.setCodigo(result.getString(1));
                componente.setDescripcion(result.getString(2));
                listComponente.add(componente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoSubComponente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listComponente;
    }

    @Override
    public SubComponente getComponente(int idComponente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
