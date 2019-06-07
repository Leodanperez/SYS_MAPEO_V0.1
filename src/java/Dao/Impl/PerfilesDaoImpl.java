package Dao.Impl;

import Dao.PerfilesDao;
import Models.Perfiles;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author IVAN
 */
public class PerfilesDaoImpl implements PerfilesDao {

    private DbConnection conn;
    private String sql;
    private Connection cn;
    private PreparedStatement objPreparedStatement;
    private CallableStatement objCallableStatement;
    private ResultSet objResultSet;
    private Perfiles objPerfiles;
    private String result;

    public PerfilesDaoImpl(DbConnection conn) {
        this.conn = conn;
    }

    @Override
    public List<Perfiles> listPerfiles() {

        List<Perfiles> listPerfiles = new LinkedList<>();
        cn = conn.getConnection();
        sql = "SELECT * FROM PERFILES";

        if (cn != null) {
            try {
                objPreparedStatement = cn.prepareStatement(sql);
                objResultSet = objPreparedStatement.executeQuery();

                while (objResultSet.next()) {
                    objPerfiles = new Perfiles();
                    objPerfiles.setCperfiles_Cod(objResultSet.getString("CPERFILES_COD").charAt(0));
                    objPerfiles.setVperfiles_Descripcion(objResultSet.getString("VPERFILES_DESCRIPCION"));
                    objPerfiles.setCperfiles_Estado(objResultSet.getString("CPERFILES_ESTADO").charAt(0));
                    listPerfiles.add(objPerfiles);
                }

            } catch (SQLException e) {
                System.out.println("Error PerfilDao. listarPerl: " + e.getMessage());
                return null;
            } finally {
                try {
                    if (objResultSet != null) {
                        objResultSet.close();
                        objPreparedStatement.close();
                    }
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexion en PerfilesDaoImpl.listUsuarios: " + e.getMessage());
                }
            }
        }

        return listPerfiles;
    }

    @Override
    public String insertPerfiles(Perfiles objPerfiles) {

        cn = conn.getConnection();
        sql = "{CALL SP_INSERTAR_PERFILES(?,?,?)}";

        if (cn != null) {
            try {
                objCallableStatement = cn.prepareCall(sql);
                objCallableStatement.setString(1, objPerfiles.getVperfiles_Descripcion());
                objCallableStatement.setString(2, "A");
                objCallableStatement.registerOutParameter(3, Types.VARCHAR);
                objCallableStatement.executeUpdate();
                System.out.println("perfiles: " + objPerfiles.getVperfiles_Descripcion());
                System.out.println("termina proc: " + objCallableStatement.getString(3));
                result = objCallableStatement.getString(3);

            } catch (SQLException e) {
                System.out.println("Error PerfilDao.insert: " + e.getMessage());
                result = null;
            }
        }

        return result;

    }

    @Override
    public String updatePerfiles(Perfiles objPerfiles) {

        cn = conn.getConnection();
        sql = "{call SP_ACTUALIZAR_PERFILES(?,?,?)}";

        if (cn != null) {
            try {
                objCallableStatement = cn.prepareCall(sql);
                objCallableStatement.setString(1, String.valueOf(objPerfiles.getCperfiles_Cod()));
                objCallableStatement.setString(2, objPerfiles.getVperfiles_Descripcion());
                objCallableStatement.registerOutParameter(3, Types.VARCHAR);
                objCallableStatement.executeUpdate();
                result = objCallableStatement.getString(3);

            } catch (SQLException e) {
                System.out.println("Error PerfilDao.updatePerfil: " + e.getMessage());
                result = null;
            }
        }

        return result;

    }

    @Override
    public String deletePerfiles(String codPerfil) {

        cn = conn.getConnection();
        sql = "{call SP_ELIMINAR_PERFILES(?,?)}";

        if (cn != null) {
            try {
                objCallableStatement = cn.prepareCall(sql);
                objCallableStatement.setString(1, codPerfil);
                objCallableStatement.registerOutParameter(2, Types.VARCHAR);
                objCallableStatement.executeUpdate();
                result = objCallableStatement.getString(2);

            } catch (SQLException e) {
                System.out.println("Error PerfilDao.eliminarl: " + e.getMessage());
                result = null;
            }
        }

        return result;

    }

    @Override
    public List<Perfiles> searchPerfiles(String valorBusqueda) {

        cn = conn.getConnection();
        List<Perfiles> listPerfiles = new LinkedList<>();
        sql = "SELECT cperfiles_cod, vperfiles_descripcion FROM perfiles \n"
                + "WHERE  vperfiles_descripcion LIKE '%" + valorBusqueda.toUpperCase() + "%'";

        if (cn != null) {
            try {
                objPreparedStatement = cn.prepareStatement(sql);
                objResultSet = objPreparedStatement.executeQuery();
                while (objResultSet.next()) {
                    objPerfiles = new Perfiles();
                    objPerfiles.setCperfiles_Cod(objResultSet.getString(1).charAt(0));
                    objPerfiles.setVperfiles_Descripcion(objResultSet.getString(2));
                    listPerfiles.add(objPerfiles);
                }
            } catch (SQLException ex) {
                System.out.println("Error PerfilesDaoImpl.searchPerfiles: " + ex.getMessage());
            } finally {
                if (objResultSet != null) {
                    try {
                        objResultSet.close();
                        objPreparedStatement.close();
                    } catch (SQLException ex) {
                        System.out.println("Error al cerrar la conexion PerfilesDaoImpl.searchPerfiles: " + ex.getMessage());
                    }
                }
            }
        }

        return listPerfiles;

    }

    @Override
    public Perfiles datosPerfiles(String codPerfil) {

        cn = conn.getConnection();
        sql = "SELECT cperfiles_cod, vperfiles_descripcion, cperfiles_estado FROM perfiles \n"
                + "WHERE  cperfiles_cod = '" + codPerfil + "'";

        if (cn != null) {
            try {
                objPreparedStatement = cn.prepareStatement(sql);
                objResultSet = objPreparedStatement.executeQuery();
                while (objResultSet.next()) {
                    objPerfiles = new Perfiles();
                    objPerfiles.setCperfiles_Cod(objResultSet.getString(1).charAt(0));
                    objPerfiles.setVperfiles_Descripcion(objResultSet.getString(2));
                    objPerfiles.setCperfiles_Estado(objResultSet.getString(3).charAt(0));
                }
            } catch (SQLException ex) {
                System.out.println("Error en PerfilesDaoImpl.datosPerfiles: " + ex.getMessage());
            } finally {
                if (objResultSet != null) {
                    try {
                        objPreparedStatement.close();
                        objResultSet.close();
                    } catch (SQLException ex) {
                        System.out.println("Error al cerrar conexion en PerfilesDaoImpl.datosPerfiles:  " + ex.getMessage());
                    }
                }
            }
        }

        return objPerfiles;

    }

    @Override
    public List<Perfiles> listPerfilesModulos(String codPerfil) {

        List<Perfiles> listPerfilesModulos = new LinkedList<>();
        cn = conn.getConnection();
        sql = "SELECT perfiles.CPERFILES_COD, perfiles.VPERFILES_DESCRIPCION, perfiles.CPERFILES_ESTADO, modulos.CMODULOS_COD, modulos.VMODULOS_DESC\n"
                + "FROM perfiles_modulos, perfiles, modulos\n"
                + "WHERE perfiles_modulos.CPERFILES_COD = perfiles.CPERFILES_COD\n"
                + "AND perfiles_modulos.CMODULOS_COD = modulos.CMODULOS_COD\n"
                + "AND perfiles.CPERFILES_COD = '" + codPerfil + "'";

        if (cn != null) {
            try {
                objPreparedStatement = cn.prepareStatement(sql);
                objResultSet = objPreparedStatement.executeQuery();
                while (objResultSet.next()) {
                    objPerfiles = new Perfiles();
                    objPerfiles.setCperfiles_Cod(objResultSet.getString(1).charAt(0));
                    objPerfiles.setCmodulos_Cod(objResultSet.getString(4).charAt(0));
                    objPerfiles.setVperfiles_Descripcion(objResultSet.getString(2));
                    objPerfiles.setVmodulos_desc(objResultSet.getString(5));
                    listPerfilesModulos.add(objPerfiles);
                }
            } catch (SQLException ex) {
                System.out.println("Error en PerfilesDaoImpl.listPerfilesModulos: " + ex.getMessage());
            } finally {
                if (objResultSet != null) {
                    try {
                        objPreparedStatement.close();
                        objResultSet.close();
                    } catch (SQLException ex) {
                        System.out.println("Error al cerrar conexion en PerfilesDaoImpl.listPerfilesModulos: " + ex.getMessage());
                    }
                }
            }
        }

        return listPerfilesModulos;
    }

    @Override
    public List<Object[]> getModulosSelect() {

        List<Object[]> selectModulos = null;
        cn = conn.getConnection();
        sql = "select CMODULOS_COD, VMODULOS_DESC from MODULOS"
                + " where CMODULOS_ESTADO = 'A' and CMODULOS_COD = CMODULOS_MODSUPER";

        if (cn != null) {
            try {
                objPreparedStatement = cn.prepareCall(sql);
                objResultSet = objPreparedStatement.executeQuery();
                selectModulos = new LinkedList<>();
                while (objResultSet.next()) {
                    Object[] reg = new Object[2];
                    reg[0] = objResultSet.getString(1);
                    reg[1] = objResultSet.getString(2);
                    selectModulos.add(reg);
                }

            } catch (SQLException ex) {
                System.out.println("Error en UsuariosDaoImpl.getPerfilesSelect: " + ex.getMessage());
            } finally {
                if (objResultSet != null) {
                    try {
                        objResultSet.close();
                        objPreparedStatement.close();
                    } catch (SQLException ex) {
                        System.out.println("Error al cerrar conexion en Usuariosdaoimpl.getPerfilesSelect: " + ex.getMessage());
                    }
                }
            }
        }

        return selectModulos;

    }

    @Override
    public boolean insertPerfilesModulos(String codPerfil, String codModulo) {

        boolean res = false;
        cn = conn.getConnection();
        sql = "{call SP_INSERTAR_PERFIL_MODULO(?,?)}";

        if (cn != null) {
            try {
                objCallableStatement = cn.prepareCall(sql);
                objCallableStatement.setString(1, codPerfil);
                objCallableStatement.setString(2, codModulo);
                objCallableStatement.executeUpdate();
                res = true;
            } catch (SQLException ex) {
                System.out.println("Error en Usuariosdaoimpl.insertPerfilesModulos; " + ex.getMessage());
            }
        }

        return res;

    }

    @Override
    public boolean deletePerfilesModulos(String codPerfil, String codModulo) {
        
         boolean res = false;
        cn = conn.getConnection();
        sql = "{call SP_ELIMINAR_PERFIL_MODULO(?,?)}";

        if (cn != null) {
            try {
                objCallableStatement = cn.prepareCall(sql);
                objCallableStatement.setString(1, codPerfil);
                objCallableStatement.setString(2, codModulo);
                objCallableStatement.executeUpdate();
                res = true;
            } catch (SQLException ex) {
                System.out.println("Error en Usuariosdaoimpl.deletePerfilesModulos: " + ex.getMessage());
            }
        }

        return res;
        
    }

}
