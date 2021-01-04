/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generals;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Programador 1
 */
public class Conexion {
    private String user = "root";
    private String pass = "poseidon";
    private String db = "arquitectdb";
    private String url = "jdbc:mysql://localhost:3306/" +
                           db + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&"
                              + "useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&"
                              + "allowPublicKeyRetrieval=true";
    Connection cnx = null;
    
    public Conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                cnx = DriverManager.getConnection(url,user,pass);
                if(cnx != null){
                    System.out.println("Conexion Exitosa");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    public Connection getConnection(){
        return cnx;
    }

}
