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
import java.sql.Statement;

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
            try (PreparedStatement psmt = cnx.getConnection().prepareStatement(Contans.QUERY_INSERT_SUBCOMPONENTES,
                    Statement.RETURN_GENERATED_KEYS)) {
                psmt.setInt(1, subcomponente.getIdAcabado());
                psmt.setString(2, subcomponente.getCodigo());
                psmt.setString(3, subcomponente.getDescripcion());
                psmt.setInt(4, subcomponente.getIdUnidadCalculada());
                int affectedRows = psmt.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("No se pudo guardar");
                }

                ResultSet generatedKeys = psmt.getGeneratedKeys();

                if (generatedKeys.next()) {
                    subcomponente.setIdSubcomponente(generatedKeys.getInt(1));
                }

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
                psmt.setInt(2, subcomponente.getIdUnidadCalculada());
                psmt.setString(3, subcomponente.getCodigo());
                psmt.setString(4, subcomponente.getDescripcion());
                psmt.setInt(5, subcomponente.getIdSubcomponente());
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
    public boolean delete(SubComponente subComponente) {
        boolean result = false;
        Conexion cnx = new Conexion();

        try {
            try (PreparedStatement psmt = cnx.getConnection().prepareStatement(Contans.QUERY_DELETE_SUBCOMPONENTES)) {
                psmt.setInt(1, subComponente.getIdSubcomponente());
                int affectedRows = psmt.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("No se pudo ELIMINAR");
                }

                result = true;
                psmt.close();
                cnx.getConnection().close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoSubComponente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
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
    public SubComponente getSubcomponente(int idSubcomponente) {
        Conexion cnx = new Conexion();
        SubComponente subComponente = new SubComponente();

        ResultSet result;
        try (PreparedStatement preparedStatement = cnx.getConnection().prepareStatement(Contans.QUERY_SUBCOMPONENTES_FORM_CARGAR)) {
            preparedStatement.setInt(1, idSubcomponente);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                subComponente.setIdSubcomponente(idSubcomponente);
                subComponente.setIdAcabado(result.getInt(1));
                subComponente.setIdUnidadCalculada(result.getInt(2));
                subComponente.setCodigo(result.getString(3));
                subComponente.setDescripcion(result.getString(4));
            }
            result.close();
            cnx.getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoComponente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subComponente;
    }

}
