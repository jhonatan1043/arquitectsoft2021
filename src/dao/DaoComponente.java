/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import generals.Conexion;
import generals.Contans;
import generals.Querys;
import java.util.List;
import models.Componente;
import interfaces.IComponente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Programador 1
 */
public class DaoComponente implements IComponente {

    Conexion cnx = new Conexion();

    @Override
    public boolean save(Componente componente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Componente componente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Componente componente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Componente> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Componente getComponente(int idComponente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] getSubComponente(int idSubComponente,
            int logitud,
            int anchura,
            int altura,
            int area) {

        Object[] list = new Object[5];

        ResultSet result = null;

        try (PreparedStatement preparedStatement = cnx.getConnection().prepareStatement(Contans.QUERY_SUBCOMPONENTES_CARGAR + idSubComponente + ","
                + logitud + ","
                + anchura + ","
                + altura + ","
                + area + ")")) {
            result = preparedStatement.executeQuery();

            while (result.next()) {
                list[0] = result.getObject(1);
                list[1] = result.getObject(2);
                list[2] = result.getObject(3);
                list[3] = result.getObject(4);
                list[4] = result.getObject(5);
            }

            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoComponente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
