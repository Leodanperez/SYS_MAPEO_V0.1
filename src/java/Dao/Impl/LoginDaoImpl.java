package Dao.Impl;

import Dao.LoginDao;
import Models.Modulos;
import Models.Usuarios;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

public class LoginDaoImpl implements LoginDao {

    private DbConnection conn;
    private String sql;
    private Connection cn;
    private PreparedStatement objPreparedStatement;
    private CallableStatement objCallableStatement;
    private ResultSet objResultSet;
    private Usuarios objUsuarios;
    private Modulos objModulos;

    public LoginDaoImpl(DbConnection conn) {
        this.conn = conn;
    }

    public Usuarios autenticacion(String user, String password) {

        //cn = conn.getConnection();
        sql = "SELECT usu.CUSUARIOS_COD AS CODUSUARIO, usu.VUSUARIOS_LOGIN AS LOGIN, usu.VUSUARIOS_PASSWORD as PASSWORD,\n"
                + "usu.VUSUARIOS_EMAIL  AS EMAIL, usu.VUSUARIOS_FOTO as FOTO, REPLACE(mil.VPERSONAL_APELLNOM, '/', ' ') as NOMUSUARIO FROM USUARIOS usu \n"
                + "INNER JOIN PER_MILITARES mil ON mil.CMILITARES_CIP = usu.CMILITARES_CIP WHERE\n"
                + "usu.VUSUARIOS_LOGIN = ? AND\n"
                + "usu.VUSUARIOS_PASSWORD = ? AND\n"
                + "usu.CUSUARIOS_ESTADO= ? ";

        // if (cn != null) {
        try {
            objPreparedStatement = cn.prepareStatement(sql);
            objPreparedStatement.setString(1, user);
            objPreparedStatement.setString(2, password);
            objPreparedStatement.setString(3, "A");
            objResultSet = objPreparedStatement.executeQuery();
            objUsuarios = new Usuarios();
            if (objResultSet.next()) {
                objUsuarios.setCusuariosCod(objResultSet.getInt("CODUSUARIO"));
                objUsuarios.setVusuarios_Login(objResultSet.getString("LOGIN"));
                objUsuarios.setVusuarios_Password(objResultSet.getString("PASSWORD"));
                objUsuarios.setVusuairos_Email(objResultSet.getString("EMAIL"));
                objUsuarios.setVusuarios_Foto(objResultSet.getString("FOTO"));
                objUsuarios.setVpersonal_ApellNom(objResultSet.getString("NOMUSUARIO"));
            }
            return objUsuarios;
        } catch (SQLException e) {
            System.out.println("Error en LoginDaoImpl.autenticar: " + e.getMessage());
            return null;
            /*} finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexion en LoginDaoImpl.autenticar: " + e.getMessage());
                }*/
        }
        //}

    }

    
    @Override
    public List<Modulos> getListModulosSuper(String user) {

        List<Modulos> listModulosSuper = new LinkedList<>();
        cn = conn.getConnection();

        if (cn != null) {
            try {
                sql = "{call SP_CONSULTA_ACCESOS(?,?)}";
                objCallableStatement = cn.prepareCall(sql);
                objCallableStatement.setString(1, user);
                objCallableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                objCallableStatement.execute();
                objResultSet = (ResultSet) objCallableStatement.getObject(2);
                while (objResultSet.next()) {
                    objModulos = new Modulos();
                    objModulos.setCmodulos_Cod(objResultSet.getString("CMODULOS_COD"));
                    objModulos.setVmodulos_Desc(objResultSet.getString("VMODULOS_DESC"));
                    objModulos.setCmodulos_Estado(objResultSet.getString("CMODULOS_ESTADO").charAt(0));
                    objModulos.setCmodulos_ModSuper(objResultSet.getString("CMODULOS_MODSUPER"));
                    objModulos.setVmodulos_link(objResultSet.getString("VMODULOS_LINK"));
                    objModulos.setVmodulos_icon(objResultSet.getString("VMODULOS_ICON"));
                    listModulosSuper.add(objModulos);
                }

            } catch (SQLException e) {
                System.out.println("Error en LoginDaoImpl.getListModulosSuper: " + e.getMessage());
            } finally {
                /*try {
                    cn.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexion en LoginDaoImpl.getListModulosSuper: " + e.getMessage());
                }*/
            }
        }

        return listModulosSuper;

    }

    @Override
    public List<Modulos> getListSubModulos() {

        List<Modulos> listSubModulos = new LinkedList<>();
        cn = conn.getConnection();

        if (cn != null) {
            try {
                sql = "SELECT * FROM modulos  WHERE cmodulos_cod <> cmodulos_modsuper AND modulos.cmodulos_estado = 'A' ORDER BY CMODULOS_ORDEN";
                objPreparedStatement = cn.prepareStatement(sql);
                objResultSet = objPreparedStatement.executeQuery();
                while (objResultSet.next()) {
                    objModulos = new Modulos();
                    objModulos.setCmodulos_Cod(objResultSet.getString("CMODULOS_COD"));
                    objModulos.setVmodulos_Desc(objResultSet.getString("VMODULOS_DESC"));
                    objModulos.setCmodulos_Estado(objResultSet.getString("CMODULOS_ESTADO").charAt(0));
                    objModulos.setCmodulos_ModSuper(objResultSet.getString("CMODULOS_MODSUPER"));
                    objModulos.setVmodulos_Servlet(objResultSet.getString("VMODULOS_SERVLET"));
                    objModulos.setVmodulos_link(objResultSet.getString("VMODULOS_LINK"));
                    objModulos.setVmodulos_icon(objResultSet.getString("VMODULOS_ICON"));
                    listSubModulos.add(objModulos);
                }

            } catch (SQLException e) {
                System.out.println("Error en LoginDaoImpl.getListSubModulos: " + e.getMessage());
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexion en LoginDaoImpl.getListSubModulos: " + e.getMessage());
                }
            }
        }

        return listSubModulos;

    }

}
