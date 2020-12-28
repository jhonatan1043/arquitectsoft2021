/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import generals.Conexion;
import generals.Contans;
import java.util.List;
import models.Componente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import interfaces.IComponente;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.TableModel;

/**
 *
 * @author Programador 1
 */
public class DaoComponente implements IComponente {

    Conexion cnx = new Conexion();

    @Override
    public boolean save(Componente componente) {
        try {
            cnx.getConnection().setAutoCommit(false);
            PreparedStatement insertComponente = cnx.getConnection().prepareStatement(Contans.QUERY_INSERT_COMPONENTES, Statement.RETURN_GENERATED_KEYS);
            insertComponente.setString(1, componente.getCodigo());
            insertComponente.setString(2, componente.getDescripcion());
            insertComponente.executeUpdate();
            try (ResultSet idGenerador = insertComponente.getGeneratedKeys()) {
                idGenerador.next();
                int idComponente = idGenerador.getInt(1);
                idGenerador.close();
                insertComponente.close();

                try (PreparedStatement insertComponenteDetalle = cnx.getConnection().prepareStatement(Contans.QUERY_INSERT_COMPONENTE_DETALLE)) {
                    for (int i = 0; i < componente.getModelo().getRowCount(); i++) {
                        insertComponenteDetalle.setInt(1, idComponente);
                        insertComponenteDetalle.setInt(2, Integer.parseInt(componente.getModelo().getValueAt(i, 0).toString()));
                        insertComponenteDetalle.executeUpdate();
                    }

                    cnx.getConnection().commit();
                }
                componente.setIdComponente(idComponente);
            }
        } catch (SQLException ex) {
            try {
                Logger.getLogger(DaoComponente.class.getName()).log(Level.SEVERE, null, ex);
                cnx.getConnection().rollback();
                return false;
            } catch (SQLException ex1) {
                Logger.getLogger(DaoComponente.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                cnx.getConnection().setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(DaoComponente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
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
    public Componente getComponte(int idComponente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] getSubComponente(int idSubComponente) {
        Object[] list = new Object[3];

        ResultSet result;

        try (PreparedStatement preparedStatement = cnx.getConnection().prepareStatement(Contans.QUERY_SUBCOMPONENTES_CARGAR
                + idSubComponente + ";")) {
            result = preparedStatement.executeQuery();
            while (result.next()) {
                list[0] = idSubComponente;
                list[1] = result.getObject(1);
                list[2] = result.getObject(2);
            }

            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoComponente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public ArrayList<ArrayList<Object[]>> getSubComponenteCalc(TableModel modelo) {
        ArrayList<ArrayList<Object[]>> list = new ArrayList<>();
        ArrayList<Object[]> listDta;
        Object[] data;
        for (int i = 0; i < modelo.getRowCount(); i++) {

            ResultSet result;
                    
            String codigo = modelo.getValueAt(i, 0).toString().trim().replace("\"", "").replace("�", "");
            String auxLongitud = modelo.getValueAt(i, 2).toString().trim().replace("\"", "");
            String ubicacion = modelo.getValueAt(i, 3).toString().trim().replace("\"", "");

            int longitud = Integer.parseInt(auxLongitud.trim().replace(" ", "").replace("\"", ""));
            
            try {

                String query = "call spComponentePerfilesCargar(?,?,?);";

                try (PreparedStatement preparedStatement = cnx.getConnection().prepareStatement(query)) {
                    preparedStatement.setString(1, codigo);
                    preparedStatement.setInt(2, longitud);
                    preparedStatement.setString(3, ubicacion);
                    result = preparedStatement.executeQuery();

                    listDta = new ArrayList<>();

                    while (result.next()) {
                        data = new Object[6];

                        data[0] = result.getInt(1);
                        data[1] = result.getString(2);
                        data[2] = result.getString(3);
                        data[3] = result.getInt(4);
                        data[4] = result.getInt(5);
                        data[5] = result.getString(6);
                        listDta.add(data);
                    }

                    list.add(listDta);

                    result.close();
                }
                ///cnx.getConnection().close();

            } catch (SQLException ex) {
                Logger.getLogger(DaoComponente.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return list;
    }

}
