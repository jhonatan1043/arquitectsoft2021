/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import generals.Conexion;
import generals.Contans;
import interfaces.IProyecto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;

/**
 *
 * @author Programador 1
 */
public class DaoProyecto implements IProyecto {

    Conexion cnx = new Conexion();

    @Override
    public ArrayList<Object[]> getComponenteCalc(TableModel modelo) {
        ResultSet result;
        ArrayList<Object[]> list = new ArrayList<>();

        try {
            PreparedStatement insertComponenteDetalle;
            insertComponenteDetalle = cnx.getConnection().prepareStatement(Contans.QUERY_INSERT_PROYECTO);

            for (int i = 0; i < modelo.getRowCount(); i++) {
                insertComponenteDetalle.setInt(1, Integer.parseInt(modelo.getValueAt(i, 0).toString()));
                insertComponenteDetalle.setInt(2, Integer.parseInt(modelo.getValueAt(i, 1).toString()));
                insertComponenteDetalle.setInt(3, Integer.parseInt(modelo.getValueAt(i, 4).toString()));
                insertComponenteDetalle.setInt(4, Integer.parseInt(modelo.getValueAt(i, 5).toString()));
                insertComponenteDetalle.setInt(5, Integer.parseInt(modelo.getValueAt(i, 6).toString()));
                insertComponenteDetalle.executeUpdate();
            }
            insertComponenteDetalle.close();
            
            PreparedStatement preparedStatement = cnx.getConnection().prepareStatement(Contans.QUERY_GET_PROYECTO);
            result = preparedStatement.executeQuery();

            while (result.next()) {
                Object[] lists = new Object[7];
                lists[0] = result.getInt(1);
                lists[1] = result.getString(2);
                lists[2] = result.getString(3);
                lists[3] = result.getInt(4);
                lists[4] = result.getInt(5);
                lists[5] = result.getInt(6);
                lists[6] = result.getString(7);
                list.add(lists);
            }

            result.close();
            cnx.getConnection().close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

}
