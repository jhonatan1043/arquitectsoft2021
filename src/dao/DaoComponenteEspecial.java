/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import generals.Conexion;
import generals.Contans;
import models.ComponenteEspecial;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import interfaces.IComponenteEspecial;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.TableModel;

/**
 *
 * @author Programador 1
 */
public class DaoComponenteEspecial implements IComponenteEspecial {

    Conexion cnx = new Conexion();

    @Override
    public boolean save(ComponenteEspecial componenteEspecial) {
        int corte = 0;
        try {
            cnx.getConnection().setAutoCommit(false);
            PreparedStatement insertComponente = cnx.getConnection().prepareStatement(Contans.QUERY_INSERT_COMPONENTES_ESPECIAL, Statement.RETURN_GENERATED_KEYS);
            insertComponente.setString(1, componenteEspecial.getCodigo());
            insertComponente.setString(2, componenteEspecial.getDescripcion());
            insertComponente.executeUpdate();
            try (ResultSet idGenerador = insertComponente.getGeneratedKeys()) {
                idGenerador.next();
                int idComponente = idGenerador.getInt(1);
                idGenerador.close();
                insertComponente.close();

                try (PreparedStatement insertComponenteDetalle = cnx.getConnection().prepareStatement(Contans.QUERY_INSERT_COMPONENTE_ESPECIAL_DETALLE)) {
                    for (int i = 0; i < componenteEspecial.getModelo().getRowCount(); i++) {

                        if (!Contans.SELECTING.equals(componenteEspecial.getModelo().getValueAt(i, 8).toString())) {
                            corte = Integer.parseInt(componenteEspecial.getModelo().getValueAt(i, 8).toString());
                        }

                        insertComponenteDetalle.setInt(1, idComponente);
                        insertComponenteDetalle.setInt(2, Integer.parseInt(componenteEspecial.getModelo().getValueAt(i, 0).toString()));
                        insertComponenteDetalle.setObject(3, componenteEspecial.getModelo().getValueAt(i, 3) == null ? 0 : componenteEspecial.getModelo().getValueAt(i, 3).toString().split("|")[0]);
                        insertComponenteDetalle.setInt(4, Integer.parseInt(componenteEspecial.getModelo().getValueAt(i, 4).toString()));
                        insertComponenteDetalle.setInt(5, Integer.parseInt(componenteEspecial.getModelo().getValueAt(i, 5).toString()));
                        insertComponenteDetalle.setBoolean(6, Boolean.parseBoolean(componenteEspecial.getModelo().getValueAt(i, 6).toString()));
                        insertComponenteDetalle.setInt(7, Integer.parseInt(componenteEspecial.getModelo().getValueAt(i, 7).toString()));
                        insertComponenteDetalle.setInt(8, corte);
                        insertComponenteDetalle.executeUpdate();
                    }

                    cnx.getConnection().commit();
                }
                componenteEspecial.setIdComponente(idComponente);
            }
        } catch (SQLException ex) {
            try {
                Logger.getLogger(DaoComponenteEspecial.class.getName()).log(Level.SEVERE, null, ex);
                cnx.getConnection().rollback();
                return false;
            } catch (SQLException ex1) {
                Logger.getLogger(DaoComponenteEspecial.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                cnx.getConnection().setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(DaoComponenteEspecial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

    @Override
    public boolean update(ComponenteEspecial componenteEspecial) {
        int corte = 0;
        try {
            cnx.getConnection().setAutoCommit(false);

            try (PreparedStatement insertComponente = cnx.getConnection().prepareStatement(Contans.QUERY_UPDATE_COMPONENTES_ESPECIAL)) {
                insertComponente.setString(1, componenteEspecial.getCodigo());
                insertComponente.setString(2, componenteEspecial.getDescripcion());
                insertComponente.setInt(3, componenteEspecial.getIdComponente());
                insertComponente.executeUpdate();

                insertComponente.close();
            }

            try (PreparedStatement deleteComponenteDetalle = cnx.getConnection().prepareStatement(Contans.QUERY_DELETE_COMPONENTE_ESPECIAL_DETALLE)) {

                deleteComponenteDetalle.setInt(1, componenteEspecial.getIdComponente());
                deleteComponenteDetalle.executeUpdate();

                deleteComponenteDetalle.close();

                try (PreparedStatement insertComponenteDetalle = cnx.getConnection().prepareStatement(Contans.QUERY_INSERT_COMPONENTE_ESPECIAL_DETALLE)) {
                    for (int i = 0; i < componenteEspecial.getModelo().getRowCount(); i++) {
                        
                        if (!Contans.SELECTING.equals(componenteEspecial.getModelo().getValueAt(i, 8).toString())) {
                            corte = Integer.parseInt(componenteEspecial.getModelo().getValueAt(i, 8).toString());
                        }
                        
                        insertComponenteDetalle.setInt(1, componenteEspecial.getIdComponente());
                        insertComponenteDetalle.setInt(2, Integer.parseInt(componenteEspecial.getModelo().getValueAt(i, 0).toString()));
                        insertComponenteDetalle.setObject(3, componenteEspecial.getModelo().getValueAt(i, 3) == null ? 0 : componenteEspecial.getModelo().getValueAt(i, 3).toString().split("|")[0]);
                        insertComponenteDetalle.setInt(4, Integer.parseInt(componenteEspecial.getModelo().getValueAt(i, 4).toString()));
                        insertComponenteDetalle.setInt(5, Integer.parseInt(componenteEspecial.getModelo().getValueAt(i, 5).toString()));
                        insertComponenteDetalle.setBoolean(6, Boolean.parseBoolean(componenteEspecial.getModelo().getValueAt(i, 6).toString()));
                        insertComponenteDetalle.setInt(7, Integer.parseInt(componenteEspecial.getModelo().getValueAt(i, 7).toString()));
                        insertComponenteDetalle.setInt(8, corte);
                        insertComponenteDetalle.executeUpdate();
                    }

                    insertComponenteDetalle.close();

                    cnx.getConnection().commit();
                }

            }
        } catch (SQLException ex) {
            try {
                Logger.getLogger(DaoComponenteEspecial.class.getName()).log(Level.SEVERE, null, ex);
                cnx.getConnection().rollback();
                return false;
            } catch (SQLException ex1) {
                Logger.getLogger(DaoComponenteEspecial.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                cnx.getConnection().setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(DaoComponenteEspecial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

    @Override
    public boolean delete(ComponenteEspecial componenteEspecial) {
        boolean result = false;
        try {
            cnx.getConnection().setAutoCommit(false);

            try (PreparedStatement deleteComponenteDetalle = cnx.getConnection().prepareStatement(Contans.QUERY_DELETE_COMPONENTE_ESPECIAL_DETALLE)) {
                deleteComponenteDetalle.setInt(1, componenteEspecial.getIdComponente());
                deleteComponenteDetalle.executeUpdate();
            }
            try (PreparedStatement deleteComponente = cnx.getConnection().prepareStatement(Contans.QUERY_DELETE_COMPONENTE_ESPECIAL)) {
                deleteComponente.setInt(1, componenteEspecial.getIdComponente());
                deleteComponente.executeUpdate();
            }
            cnx.getConnection().commit();

            result = true;
        } catch (SQLException ex) {
            try {
                Logger.getLogger(DaoComponenteEspecial.class.getName()).log(Level.SEVERE, null, ex);
                cnx.getConnection().rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(DaoComponenteEspecial.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return result;
        } finally {
            try {
                cnx.getConnection().setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(DaoComponenteEspecial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    @Override
    public ComponenteEspecial getComponenteEspecial(int idComponente) {
        ComponenteEspecial componenteEspecial = new ComponenteEspecial();

        ResultSet result;

        try (PreparedStatement preparedStatement = cnx.getConnection().prepareStatement(Contans.QUERY_COMPONENTES_ESPECIAL_CARGAR)) {
            preparedStatement.setInt(1, idComponente);
            result = preparedStatement.executeQuery();

            while (result.next()) {
                componenteEspecial.setIdComponente(idComponente);
                componenteEspecial.setCodigo(result.getString(1));
                componenteEspecial.setDescripcion(result.getString(2));
            }

            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoComponenteEspecial.class.getName()).log(Level.SEVERE, null, ex);
        }
        return componenteEspecial;
    }

    @Override
    public ArrayList<Object[]> getComponenteEspecialDetalle(int idComponente) {
        ArrayList<Object[]> list = new ArrayList<>();

        ResultSet result;

        try (PreparedStatement preparedStatement = cnx.getConnection().prepareStatement(Contans.QUERY_COMPONENTES_ESPECIAL_DETALLE_CARGAR)) {
            preparedStatement.setInt(1, idComponente);
            result = preparedStatement.executeQuery();

            while (result.next()) {
                Object[] lists = new Object[9];
                lists[0] = result.getInt(1);
                lists[1] = result.getString(2);
                lists[2] = result.getString(3);
                lists[3] = result.getString(4);
                lists[4] = result.getInt(5);
                lists[5] = result.getInt(6);
                lists[6] = result.getBoolean(7);
                lists[7] = result.getInt(8);
                lists[8] = result.getString(9);
                list.add(lists);
            }

            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoComponenteEspecial.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    @Override
    public Object[] getSubComponenteEspecial(int idSubComponente) {
        Object[] list = new Object[9];

        ResultSet result;

        try (PreparedStatement preparedStatement = cnx.getConnection().prepareStatement(Contans.QUERY_SUBCOMPONENTES_CARGAR
                + idSubComponente + ";")) {
            result = preparedStatement.executeQuery();
            while (result.next()) {
                list[0] = idSubComponente;
                list[1] = result.getObject(1);
                list[2] = result.getObject(2);
                list[3] = "1|Columna primera";
                list[4] = 1;
                list[5] = 30;
                list[6] = false;
                list[7] = 0;
                list[8] = Contans.SELECTING;
            }

            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoComponenteEspecial.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public ArrayList<ArrayList<Object[]>> getSubComponenteEspecialCalc(TableModel modelo) {
        ArrayList<ArrayList<Object[]>> list = new ArrayList<>();
        ArrayList<Object[]> listDta;

        Object[] data;

        String codigo;
        String auxAltura;

        for (int i = 0; i < modelo.getRowCount(); i++) {

            ResultSet result;
            codigo = modelo.getValueAt(i, 0).toString().trim().replace("\"", "").replace("�", "");
            auxAltura = modelo.getValueAt(i, 1).toString().trim().replace("\"", "");

            try {
                PreparedStatement preparedStatement = cnx.getConnection().prepareStatement("Call spComponenteVidrioPanel(?,?)");
                preparedStatement.setString(1, codigo);
                preparedStatement.setString(2, auxAltura);
                result = preparedStatement.executeQuery();

                listDta = new ArrayList<>();

                while (result.next()) {
                    data = new Object[6];
                    data[0] = result.getInt(1);
                    data[1] = result.getString(2);
                    data[2] = result.getString(3);
                    data[3] = result.getString(4);
                    data[4] = result.getString(5);
                    data[5] = result.getInt(6);
                    listDta.add(data);
                }

                list.add(listDta);

                result.close();

            } catch (SQLException ex) {
                Logger.getLogger(DaoComponenteEspecial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    @Override
    public boolean existsComponenteEspecial(String codigo) {
        boolean result = false;
        ResultSet resultSet;
        try (PreparedStatement preparedStatement = cnx.getConnection().prepareStatement(Contans.QUERY_EXITS_COMPONENTES_ESPECIAL)) {
            preparedStatement.setString(1, codigo);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result = resultSet.getBoolean(1);
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoComponenteEspecial.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean saveAuxAnchura(TableModel modelo) {
        boolean result = false;
        String col1, col2, col3, col4, col5, col6;

        try {
            PreparedStatement preparedStatement = cnx.getConnection().prepareStatement("truncate tbauxanchura;");
            preparedStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DaoComponenteEspecial.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < modelo.getRowCount(); i++) {

            col1 = modelo.getValueAt(i, 1).toString().trim().replace("\"", "");
            col2 = modelo.getValueAt(i, 2).toString().trim().replace("\"", "");
            col3 = modelo.getValueAt(i, 3).toString().trim().replace("\"", "");
            col4 = modelo.getValueAt(i, 4).toString().trim().replace("\"", "");
            col5 = modelo.getValueAt(i, 5).toString().trim().replace("\"", "");
            col6 = modelo.getValueAt(i, 6).toString().trim().replace("\"", "");

            try {
                PreparedStatement preparedStatement = cnx.getConnection().prepareStatement("INSERT tbauxanchura(Altura,Columna1,"
                        + "Columna2,"
                        + "Columna3,"
                        + "Columna4,"
                        + "Columna5)VALUES(?,?,?,?,?,?);");
                preparedStatement.setString(1, col1);
                preparedStatement.setString(2, "".equals(col2) ? "0" : col2);
                preparedStatement.setString(3, "".equals(col3) ? "0" : col3);
                preparedStatement.setString(4, "".equals(col4) ? "0" : col4);
                preparedStatement.setString(5, "".equals(col5) ? "0" : col5);
                preparedStatement.setString(6, "".equals(col6) ? "0" : col6);
                preparedStatement.execute();

            } catch (SQLException ex) {
                Logger.getLogger(DaoComponenteEspecial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

}

//238147
