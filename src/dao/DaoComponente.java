/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import generals.Conexion;
import generals.Contans;
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

            int unidadCalculada;

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
                        unidadCalculada = Integer.parseInt(componente.getModelo().getValueAt(i, 3).toString().split("|")[0]);
                        insertComponenteDetalle.setInt(1, idComponente);
                        insertComponenteDetalle.setInt(2, Integer.parseInt(componente.getModelo().getValueAt(i, 0).toString()));
                        insertComponenteDetalle.setInt(3, unidadCalculada);
                        insertComponenteDetalle.setInt(4, Integer.parseInt(componente.getModelo().getValueAt(i, 4).toString()));
                        insertComponenteDetalle.setInt(5, Integer.parseInt(componente.getModelo().getValueAt(i, 5).toString()));
                        insertComponenteDetalle.setBoolean(6, Boolean.parseBoolean(componente.getModelo().getValueAt(i, 6).toString()));
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
        try {
            cnx.getConnection().setAutoCommit(false);

            int unidadCalculada;

            try (PreparedStatement insertComponente = cnx.getConnection().prepareStatement(Contans.QUERY_UPDATE_COMPONENTES)) {
                insertComponente.setString(1, componente.getCodigo());
                insertComponente.setString(2, componente.getDescripcion());
                insertComponente.setInt(3, componente.getIdComponente());
                insertComponente.executeUpdate();

                insertComponente.close();
            }

            try (PreparedStatement deleteComponenteDetalle = cnx.getConnection().prepareStatement(Contans.QUERY_DELETE_COMPONENTE_DETALLE)) {

                deleteComponenteDetalle.setInt(1, componente.getIdComponente());
                deleteComponenteDetalle.executeUpdate();

                deleteComponenteDetalle.close();

                try (PreparedStatement insertComponenteDetalle = cnx.getConnection().prepareStatement(Contans.QUERY_INSERT_COMPONENTE_DETALLE)) {
                    for (int i = 0; i < componente.getModelo().getRowCount(); i++) {
                        unidadCalculada = Integer.parseInt(componente.getModelo().getValueAt(i, 3).toString().split("|")[0]);
                        insertComponenteDetalle.setInt(1, componente.getIdComponente());
                        insertComponenteDetalle.setInt(2, Integer.parseInt(componente.getModelo().getValueAt(i, 0).toString()));
                        insertComponenteDetalle.setInt(3, unidadCalculada);
                        insertComponenteDetalle.setInt(4, Integer.parseInt(componente.getModelo().getValueAt(i, 4).toString()));
                        insertComponenteDetalle.setInt(5, Integer.parseInt(componente.getModelo().getValueAt(i, 5).toString()));
                        insertComponenteDetalle.setBoolean(6, Boolean.parseBoolean(componente.getModelo().getValueAt(i, 6).toString()));
                        insertComponenteDetalle.executeUpdate();

                    }

                    insertComponenteDetalle.close();

                    cnx.getConnection().commit();
                }

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
    public boolean delete(Componente componente) {
        boolean result = false;
        try {
            cnx.getConnection().setAutoCommit(false);

            try (PreparedStatement deleteComponenteDetalle = cnx.getConnection().prepareStatement(Contans.QUERY_DELETE_COMPONENTE_DETALLE)) {
                deleteComponenteDetalle.setInt(1, componente.getIdComponente());
                deleteComponenteDetalle.executeUpdate();
            }
            try (PreparedStatement deleteComponente = cnx.getConnection().prepareStatement(Contans.QUERY_DELETE_COMPONENTE)) {
                deleteComponente.setInt(1, componente.getIdComponente());
                deleteComponente.executeUpdate();
            }
            cnx.getConnection().commit();

            result = true;
        } catch (SQLException ex) {
            try {
                Logger.getLogger(DaoComponente.class.getName()).log(Level.SEVERE, null, ex);
                cnx.getConnection().rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(DaoComponente.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return result;
        } finally {
            try {
                cnx.getConnection().setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(DaoComponente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    @Override
    public Componente getComponte(int idComponente) {
        Componente componente = new Componente();

        ResultSet result;

        try (PreparedStatement preparedStatement = cnx.getConnection().prepareStatement(Contans.QUERY_COMPONENTES_CARGAR)) {
            preparedStatement.setInt(1, idComponente);
            result = preparedStatement.executeQuery();

            while (result.next()) {
                componente.setIdComponente(idComponente);
                componente.setCodigo(result.getString(1));
                componente.setDescripcion(result.getString(2));
            }

            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoComponente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return componente;
    }

    @Override
    public ArrayList<Object[]> getComponenteDetalle(int idComponente) {
        ArrayList<Object[]> list = new ArrayList<>();

        ResultSet result;

        try (PreparedStatement preparedStatement = cnx.getConnection().prepareStatement(Contans.QUERY_COMPONENTES_DETALLE_CARGAR)) {
            preparedStatement.setInt(1, idComponente);
            result = preparedStatement.executeQuery();

            while (result.next()) {
                Object[] lists = new Object[7];
                lists[0] = result.getInt(1);
                lists[1] = result.getString(2);
                lists[2] = result.getString(3);
                lists[3] = result.getString(4);
                lists[4] = result.getInt(5);
                lists[5] = result.getInt(6);
                lists[6] = result.getBoolean(7);
                list.add(lists);
            }

            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoComponente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    @Override
    public Object[] getSubComponente(int idSubComponente) {
        Object[] list = new Object[7];

        ResultSet result;

        try (PreparedStatement preparedStatement = cnx.getConnection().prepareStatement(Contans.QUERY_SUBCOMPONENTES_CARGAR
                + idSubComponente + ";")) {
            result = preparedStatement.executeQuery();
            while (result.next()) {
                list[0] = idSubComponente;
                list[1] = result.getObject(1);
                list[2] = result.getObject(2);
                list[3] = "1|Longitud";
                list[4] = 1;
                list[5] = 30;
                list[6] = false;

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
            float longitud = Float.parseFloat(auxLongitud.trim().replace(" ", "").replace("\"", ""));

            try {

                String query = "call spComponentePerfilesCargar(?,?);";

                try (PreparedStatement preparedStatement = cnx.getConnection().prepareStatement(query)) {
                    preparedStatement.setString(1, codigo);
                    preparedStatement.setFloat(2, longitud);
                    result = preparedStatement.executeQuery();

                    listDta = new ArrayList<>();

                    while (result.next()) {
                        data = new Object[8];
                        data[0] = result.getInt(1);
                        data[1] = result.getInt(2);
                        data[2] = result.getString(3);
                        data[3] = result.getString(4);
                        data[4] = result.getInt(5);
                        data[5] = result.getString(6);
                        data[6] = result.getInt(7);
                        data[7] = "";
                        listDta.add(data);
                    }

                    list.add(listDta);

                    result.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(DaoComponente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    @Override
    public boolean existsComponente(String codigo) {
        boolean result = false;
        ResultSet resultSet;
        try (PreparedStatement preparedStatement = cnx.getConnection().prepareStatement(Contans.QUERY_EXITS_COMPONENTES)) {
            preparedStatement.setString(1, codigo);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result = resultSet.getBoolean(1);
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoComponente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
