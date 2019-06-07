/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Impl;

import Models.Modulos;
import Models.Usuarios;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author IVAN
 */
public class Autenticacion {

    private DbConnection conn;
    private String sql;
    private Connection cn;
    private PreparedStatement objPreparedStatement;
    private CallableStatement objCallableStatement;
    private ResultSet objResultSet;
    private Usuarios objUsuarios;

    public Autenticacion() {

    }

    public Autenticacion(DbConnection conn) {
        this.conn = conn;
    }

    public Usuarios login(String user, String password) {

        try {
            sql = "SELECT usu.CUSUARIOS_COD AS CODUSUARIO, usu.VUSUARIOS_LOGIN AS LOGIN, usu.VUSUARIOS_PASSWORD as PASSWORD,\n"
                    + "usu.VUSUARIOS_EMAIL  AS EMAIL, usu.VUSUARIOS_FOTO as FOTO, REPLACE(mil.VPERSONAL_APELLNOM, '/', ' ') as NOMUSUARIO FROM USUARIOS usu \n"
                    + "INNER JOIN PER_MILITARES mil ON mil.CMILITARES_CIP = usu.CMILITARES_CIP WHERE\n"
                    + "usu.VUSUARIOS_LOGIN = ? AND\n"
                    + "usu.VUSUARIOS_PASSWORD = ? AND\n"
                    + "usu.CUSUARIOS_ESTADO= ? ";
            objPreparedStatement = conn.getConnection().prepareCall(sql);
            objPreparedStatement.setString(1, user);
            objPreparedStatement.setString(2, password);
            objPreparedStatement.setString(3, "A");
            objResultSet = objPreparedStatement.executeQuery();
            objUsuarios = new Usuarios();
            while (objResultSet.next()) {
                objUsuarios.setCusuariosCod(objResultSet.getInt("CODUSUARIO"));
                objUsuarios.setVusuarios_Login(objResultSet.getString("LOGIN"));
                objUsuarios.setVusuairos_Email(objResultSet.getString("EMAIL"));
                objUsuarios.setVusuarios_Foto(objResultSet.getString("FOTO"));
                objUsuarios.setVpersonal_ApellNom(objResultSet.getString("NOMUSUARIO"));
            }
            return objUsuarios;
        } catch (SQLException e) {
            System.out.println("Error en LoginDaoImpl.autenticar: " + e.getMessage());
            return null;
        }
    }

    /*public List<Modulos> getListModulosSuper(String login) {

        try {
            sql = "{call SP_CONSULTA_ACCESOS(?,?)}";
            objCallableStatement = conn.getConnection().prepareCall(sql);
            objCallableStatement.setString(1, login);
            objCallableStatement.registerOutParameter(2, OracleTypes.CURSOR);
            objCallableStatement.execute();
            objResultSet = (ResultSet) objCallableStatement.getObject(2);
            List<Modulos> listModulosSuper = new LinkedList<>();
            Modulos objModulos;
            while (objResultSet.next()) {
                objModulos = new Modulos();
                objModulos.setCmodulos_Cod(objResultSet.getString("CMODULOS_COD").charAt(0));
                objModulos.setVmodulos_Desc(objResultSet.getString("VMODULOS_DESC"));
                objModulos.setCmodulos_Estado(objResultSet.getString("CMODULOS_ESTADO").charAt(0));
                objModulos.setCmodulos_ModSuper(objResultSet.getString("CMODULOS_MODSUPER").charAt(0));
                objModulos.setVmodulos_link(objResultSet.getString("VMODULOS_LINK"));
                objModulos.setVmodulos_icon(objResultSet.getString("VMODULOS_ICON"));
                listModulosSuper.add(objModulos);
            }
            return listModulosSuper;
        } catch (SQLException e) {
            System.out.println("Error en LoginDaoImpl.getListModulosSuper: " + e.getMessage());
            return null;
        }
    }*/

}
