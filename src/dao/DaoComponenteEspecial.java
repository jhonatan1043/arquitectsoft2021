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
                        insertComponenteDetalle.setInt(1, idComponente);
                        insertComponenteDetalle.setInt(2, Integer.parseInt(componenteEspecial.getModelo().getValueAt(i, 0).toString()));
                        insertComponenteDetalle.setObject(3, componenteEspecial.getModelo().getValueAt(i, 3) == null ? false : componenteEspecial.getModelo().getValueAt(i, 3));
                        insertComponenteDetalle.setObject(4, componenteEspecial.getModelo().getValueAt(i, 4) == null ? false : componenteEspecial.getModelo().getValueAt(i, 4));
                        insertComponenteDetalle.setObject(5, componenteEspecial.getModelo().getValueAt(i, 5) == null ? false : componenteEspecial.getModelo().getValueAt(i, 5));
                        insertComponenteDetalle.setObject(6, componenteEspecial.getModelo().getValueAt(i, 6) == null ? false : componenteEspecial.getModelo().getValueAt(i, 6));
                        insertComponenteDetalle.setObject(7, componenteEspecial.getModelo().getValueAt(i, 7) == null ? false : componenteEspecial.getModelo().getValueAt(i, 7));
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
                        insertComponenteDetalle.setInt(1, componenteEspecial.getIdComponente());
                        insertComponenteDetalle.setInt(2, Integer.parseInt(componenteEspecial.getModelo().getValueAt(i, 0).toString()));
                        insertComponenteDetalle.setBoolean(3, Boolean.parseBoolean(componenteEspecial.getModelo().getValueAt(i, 3).toString()));
                        insertComponenteDetalle.setBoolean(4, Boolean.parseBoolean(componenteEspecial.getModelo().getValueAt(i, 4).toString()));
                        insertComponenteDetalle.setBoolean(5, Boolean.parseBoolean(componenteEspecial.getModelo().getValueAt(i, 5).toString()));
                        insertComponenteDetalle.setBoolean(6, Boolean.parseBoolean(componenteEspecial.getModelo().getValueAt(i, 6).toString()));
                        insertComponenteDetalle.setBoolean(7, Boolean.parseBoolean(componenteEspecial.getModelo().getValueAt(i, 7).toString()));
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
                Object[] lists = new Object[8];
                lists[0] = result.getInt(1);
                lists[1] = result.getString(2);
                lists[2] = result.getString(3);
                lists[3] = result.getBoolean(4);
                lists[4] = result.getBoolean(5);
                lists[5] = result.getBoolean(6);
                lists[6] = result.getBoolean(7);
                lists[7] = result.getBoolean(8);
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
        Object[] list = new Object[7];
        
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
            Logger.getLogger(DaoComponenteEspecial.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    @Override
    public ArrayList<Object[]> getSubComponenteEspecialCalc(TableModel modelo) {
        ArrayList<Object[]> list = new ArrayList<>();
        Object[] data;
        String codigo;
        String auxAltura;
        
        for (int i = 0; i < modelo.getRowCount(); i++) {
            
            ResultSet result;
            codigo = modelo.getValueAt(i, 0).toString().trim().replace("\"", "").replace("�", "");
            auxAltura = modelo.getValueAt(i, 1).toString().trim().replace("\"", "");
            
            for (int j = 2; j < modelo.getColumnCount() - 1; j++) {
                try {
                    if (modelo.getValueAt(i, j) != "" || Integer.parseInt((String) modelo.getValueAt(i, j)) != 0) {
                        PreparedStatement preparedStatement = cnx.getConnection().prepareStatement("");
                        preparedStatement.setString(1, codigo);
                        preparedStatement.execute();
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(DaoComponenteEspecial.class.getName()).log(Level.SEVERE, null, ex);
                }
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
    
}

//238147
