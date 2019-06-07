package Dao.Impl;

import Dao.ModulosDao;
import Models.Modulos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModulosDaoImpl implements ModulosDao {

    private DbConnection conn;
    private String sql;
    private Connection cn;
    private PreparedStatement objPreparedStatement;
    private CallableStatement objCallableStatement;
    private ResultSet objResultSet;
    private Modulos objModulos;
    private String result;

    public ModulosDaoImpl(DbConnection conn) {
        this.conn = conn;
    }

    @Override
    public List<Modulos> listModulosSuper() {

        List<Modulos> listModulosSuper = new LinkedList<>();
        cn = conn.getConnection();
        sql = "SELECT * FROM MODULOS WHERE CMODULOS_COD=CMODULOS_MODSUPER ORDER BY CMODULOS_ORDEN ASC";

        if (cn != null) {
            try {
                objPreparedStatement = cn.prepareStatement(sql);
                objResultSet = objPreparedStatement.executeQuery();

                while (objResultSet.next()) {
                    objModulos = new Modulos();
                    objModulos.setCmodulos_Cod(objResultSet.getString("CMODULOS_COD"));
                    objModulos.setVmodulos_Desc(objResultSet.getString("VMODULOS_DESC"));
                    objModulos.setCmodulos_ModSuper(objResultSet.getString("CMODULOS_MODSUPER"));
                    objModulos.setVmodulos_Servlet(objResultSet.getString("VMODULOS_SERVLET"));
                    objModulos.setVmodulos_link(objResultSet.getString("VMODULOS_LINK"));
                    objModulos.setVmodulos_icon(objResultSet.getString("VMODULOS_ICON"));
                    objModulos.setCmodulos_Orden(objResultSet.getString("CMODULOS_ORDEN"));
                    objModulos.setCmodulos_Estado(objResultSet.getString("CMODULOS_ESTADO").charAt(0));
                    listModulosSuper.add(objModulos);
                }
            } catch (SQLException e) {
                System.out.println("Error ModulosDaoimpl.listModulosSuper: " + e.getMessage());
                return null;
            } finally {
                try {
                    if (objResultSet != null) {
                        objResultSet.close();
                        objPreparedStatement.close();
                    }
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexion en ModulosDaoimpl.listModulosSuper: " + e.getMessage());
                }
            }
        }

        return listModulosSuper;

    }

    @Override
    public String insertModulosSuper(Modulos objModulos) {

        cn = conn.getConnection();
        sql = "{call SP_INSERTAR_MODULO_SUPER(?,?,?,?,?)";

        if (cn != null) {
            try {
                objCallableStatement = cn.prepareCall(sql);
                objCallableStatement.setString(1, objModulos.getVmodulos_Desc());
                objCallableStatement.setString(2, objModulos.getVmodulos_icon());
                objCallableStatement.setString(3, objModulos.getCmodulos_Orden());
                objCallableStatement.setString(4, "A");
                objCallableStatement.registerOutParameter(5, Types.VARCHAR);
                objCallableStatement.executeUpdate();
                System.out.println("termina proc: " + objCallableStatement.getString(5));
                result = objCallableStatement.getString(5);

            } catch (SQLException e) {
                System.out.println("Error en insertModulosSuper: " + e.getMessage());
                result = null;
            }
        }

        return result;
    }

    @Override
    public String updateModulosSuper(Modulos objModulos) {

        cn = conn.getConnection();
        sql = "call SP_ACTUALIZAR_MODULO_SUPER(?,?,?,?,?)";

        if (cn != null) {
            try {
                objCallableStatement = cn.prepareCall(sql);
                objCallableStatement.setString(1, String.valueOf(objModulos.getCmodulos_Cod()));
                objCallableStatement.setString(2, objModulos.getVmodulos_Desc());
                objCallableStatement.setString(3, objModulos.getVmodulos_icon());
                objCallableStatement.setString(4, objModulos.getCmodulos_Orden());
                objCallableStatement.registerOutParameter(5, Types.VARCHAR);
                objCallableStatement.executeUpdate();
                System.out.println("termina proc: " + objCallableStatement.getString(5));
                result = objCallableStatement.getString(5);

            } catch (SQLException e) {
                System.out.println("Error en insertModulosSuper: " + e.getMessage());
                result = null;
            }
        }

        return result;
    }

    @Override
    public String deleteModulos(String codModulos) {

        cn = conn.getConnection();
        sql = "call SP_ELIMINAR_MODULOS(?,?)";

        if (cn != null) {
            try {
                objCallableStatement = cn.prepareCall(sql);
                objCallableStatement.setString(1, codModulos);
                objCallableStatement.registerOutParameter(2, Types.VARCHAR);
                objCallableStatement.executeUpdate();
                result = objCallableStatement.getString(2);

            } catch (SQLException e) {
                System.out.println("Error en ModulosDaoImpl: " + e.getMessage());
                result = null;
            }

        }

        return result;

    }

    @Override
    public List<Modulos> listSubModulos() {

        List<Modulos> listSubModulos = new LinkedList<>();
        cn = conn.getConnection();
        sql = "SELECT * FROM MODULOS WHERE CMODULOS_COD<>CMODULOS_MODSUPER ORDER BY CMODULOS_ORDEN DESC";

        if (cn != null) {
            try {
                objPreparedStatement = cn.prepareStatement(sql);
                objResultSet = objPreparedStatement.executeQuery();

                while (objResultSet.next()) {
                    objModulos = new Modulos();
                    objModulos.setCmodulos_Cod(objResultSet.getString("CMODULOS_COD"));
                    objModulos.setVmodulos_Desc(objResultSet.getString("VMODULOS_DESC"));
                    objModulos.setCmodulos_ModSuper(objResultSet.getString("CMODULOS_MODSUPER"));
                    objModulos.setVmodulos_Servlet(objResultSet.getString("VMODULOS_SERVLET"));
                    objModulos.setVmodulos_link(objResultSet.getString("VMODULOS_LINK"));
                    objModulos.setVmodulos_icon(objResultSet.getString("VMODULOS_ICON"));
                    objModulos.setCmodulos_Orden(objResultSet.getString("CMODULOS_ORDEN"));
                    objModulos.setCmodulos_Estado(objResultSet.getString("CMODULOS_ESTADO").charAt(0));
                    listSubModulos.add(objModulos);
                }
            } catch (SQLException e) {
                System.out.println("Error ModulosDaoimpl.listModulosSuper: " + e.getMessage());
                return null;
            } finally {
                try {
                    if (objResultSet != null) {
                        objResultSet.close();
                        objPreparedStatement.close();
                    }
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexion en ModulosDaoimpl.listModulosSuper: " + e.getMessage());
                }
            }
        }

        return listSubModulos;

    }

    @Override
    public List<Object[]> getModulosSuperSelect() {
        
         List<Object[]> modulosSuperSelect = null;
        cn = conn.getConnection();
        sql = "select CMODULOS_COD, VMODULOS_DESC from MODULOS"
                + " where CMODULOS_ESTADO = 'A' and CMODULOS_COD = CMODULOS_MODSUPER";

        if (cn != null) {
            try {
                objPreparedStatement = cn.prepareCall(sql);
                objResultSet = objPreparedStatement.executeQuery();
                modulosSuperSelect = new LinkedList<>();
                while (objResultSet.next()) {
                    Object[] reg = new Object[2];
                    reg[0] = objResultSet.getString(1);
                    reg[1] = objResultSet.getString(2);
                    modulosSuperSelect.add(reg);
                }

            } catch (SQLException ex) {
                System.out.println("Error en ModulosDaoimpl.getModulosSuperSelect: " + ex.getMessage());
            } finally {
                if (objResultSet != null) {
                    try {
                        objResultSet.close();
                        objPreparedStatement.close();
                    } catch (SQLException ex) {
                        System.out.println("Error al cerrar conexion en ModulosDaoimpl.getModulosSuperSelect: " + ex.getMessage());
                    }
                }
            }
        }

        return modulosSuperSelect;
        
    }

    @Override
    public String insertSubModulos(Modulos objModulos) {

        cn = conn.getConnection();
        sql = "{call SP_INSERTAR_SUBMODULOS(?,?,?,?,?,?,?,?)";

        if (cn != null) {
            try {
                objCallableStatement = cn.prepareCall(sql);
                objCallableStatement.setString(1, objModulos.getVmodulos_Desc());
                objCallableStatement.setString(2, "A");
                objCallableStatement.setString(3, objModulos.getCmodulos_ModSuper());
                objCallableStatement.setString(4, objModulos.getVmodulos_Servlet());
                objCallableStatement.setString(5, objModulos.getVmodulos_link());
                objCallableStatement.setString(6, objModulos.getVmodulos_icon());
                objCallableStatement.setString(7, objModulos.getCmodulos_Orden());
                objCallableStatement.registerOutParameter(8, Types.VARCHAR);
                objCallableStatement.executeUpdate();
                System.out.println("termina proc: " + objCallableStatement.getString(8));
                result = objCallableStatement.getString(8);

            } catch (SQLException e) {
                System.out.println("Error en ModulosDaoImpl.insertSubModulos: " + e.getMessage());
                result = null;
            }                  
        }

        return result;

    }

    @Override
    public String updateSubModulos(Modulos objModulos) {

        cn = conn.getConnection();
        sql = "call SP_ACTUALIZAR_SUBMODULOS(?,?,?,?,?,?,?,?)";

        if (cn != null) {
            try {
                objCallableStatement = cn.prepareCall(sql);
                objCallableStatement.setString(1, objModulos.getCmodulos_Cod());
                objCallableStatement.setString(2, objModulos.getVmodulos_Desc());
                objCallableStatement.setString(3, objModulos.getCmodulos_ModSuper());
                objCallableStatement.setString(4, objModulos.getVmodulos_Servlet());
                objCallableStatement.setString(5, objModulos.getVmodulos_link());
                objCallableStatement.setString(6, objModulos.getVmodulos_icon());
                objCallableStatement.setString(7, objModulos.getCmodulos_Orden());
                objCallableStatement.registerOutParameter(8, Types.VARCHAR);
                objCallableStatement.executeUpdate();
                System.out.println("termina proc: " + objCallableStatement.getString(8));
                result = objCallableStatement.getString(8);

            } catch (SQLException e) {
                System.out.println("Error en ModulosDaoImpl.updateSubModulos: " + e.getMessage());
                result = null;
            }
        }

        return result;
    }

}
