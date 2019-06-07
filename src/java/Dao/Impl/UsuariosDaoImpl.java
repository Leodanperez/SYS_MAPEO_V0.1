package Dao.Impl;

import Dao.UsuariosDao;
import Models.Perfiles;
import Models.Persona;
import Models.Usuarios;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;

public class UsuariosDaoImpl implements UsuariosDao {

    private DbConnection conn;
    private String sql;
    private Connection cn;
    private PreparedStatement objPreparedStatement;
    private CallableStatement objCallableStatement;
    private ResultSet objResultSet;
    private Usuarios objUsuarios;
    private String result;
    private Persona objPersona;
    private Perfiles objPerfiles;

    public UsuariosDaoImpl(DbConnection conn) {
        this.conn = conn;
    }

    @Override
    public List<Usuarios> listUsuarios() {

        List<Usuarios> listUsuarios = new LinkedList<>();
        cn = conn.getConnection();
        sql = "SELECT usuarios.CUSUARIOS_COD as CODUSUARIO, usuarios.VUSUARIOS_LOGIN as LOGIN, usuarios.VUSUARIOS_EMAIL as EMAIL,usuarios.VUSUARIOS_FOTO as FOTO,\n"
                + "usuarios.CMILITARES_CIP as CIP, usuarios.CUSUARIOS_ESTADO as ESTADO, REPLACE(per_militares.VPERSONAL_APELLNOM, '/', ' ') as APELLNOM\n"
                + "FROM usuarios\n"
                + "INNER JOIN per_militares ON usuarios.CMILITARES_CIP = per_militares.CMILITARES_CIP";

        if (cn != null) {
            try {
                objPreparedStatement = cn.prepareStatement(sql);
                objResultSet = objPreparedStatement.executeQuery();
                while (objResultSet.next()) {
                    objUsuarios = new Usuarios();
                    objUsuarios.setCusuarios_Cod(objResultSet.getString("CODUSUARIO").charAt(0));
                    objUsuarios.setVpersonal_ApellNom(objResultSet.getString("APELLNOM"));
                    objUsuarios.setCmilitares_Cip(objResultSet.getInt("CIP"));
                    objUsuarios.setVusuarios_Login(objResultSet.getString("LOGIN"));
                    objUsuarios.setVusuairos_Email(objResultSet.getString("EMAIL"));
                    objUsuarios.setVusuarios_Foto(objResultSet.getString("FOTO"));
                    objUsuarios.setCusuarios_Estado(objResultSet.getString("ESTADO").charAt(0));
                    listUsuarios.add(objUsuarios);
                }
            } catch (SQLException e) {
                System.out.println("Error UsuarioDaoImpl.listUsuarios: " + e.getMessage());
            } finally {
                try {
                    if (objResultSet != null) {
                        objResultSet.close();
                        objPreparedStatement.close();
                    }
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexion en UsuarioDaoImpl.listUsuarios: " + e.getMessage());
                }
            }
        }

        return listUsuarios;
    }

    @Override
    public String insertUsuarios(Usuarios objUsuarios) {

        cn = conn.getConnection();
        sql = "{call SP_INSERTAR_USUARIOS(?,?,?,?,?,?,?)}";

        if (cn != null) {
            try {
                objCallableStatement = cn.prepareCall(sql);
                objCallableStatement.setString(1, objUsuarios.getVusuarios_Login());
                objCallableStatement.setString(2, objUsuarios.getVusuarios_Password());
                objCallableStatement.setString(3, objUsuarios.getVusuairos_Email());
                objCallableStatement.setString(4, objUsuarios.getVusuarios_Foto());
                objCallableStatement.setInt(5, objUsuarios.getCmilitares_Cip());
                objCallableStatement.setString(6, "A");
                objCallableStatement.registerOutParameter(7, Types.VARCHAR);
                objCallableStatement.executeUpdate();
                System.out.println("termina proc: " + objCallableStatement.getString(7));
                result = objCallableStatement.getString(7);
            } catch (SQLException e) {
                System.out.println("Error en UsuariosDaoImpl.insertUsuarios: " + e.getMessage());
                result = null;
            }
        }

        return result;

    }

    @Override
    public String updateUsuarios(Usuarios objUsuarios) {

        cn = conn.getConnection();
        sql = "{call SP_UPDATE_USUARIOS(?,?,?,?,?,?)}";

        if (cn != null) {
            try {
                objCallableStatement = cn.prepareCall(sql);
                objCallableStatement.setString(1, String.valueOf(objUsuarios.getCusuarios_Cod()));
                objCallableStatement.setString(2, objUsuarios.getVusuarios_Login());
                objCallableStatement.setString(3, objUsuarios.getVusuairos_Email());
                objCallableStatement.setString(4, objUsuarios.getVusuarios_Foto());
                objCallableStatement.setString(5, String.valueOf(objUsuarios.getCusuarios_Estado()));
                objCallableStatement.registerOutParameter(6, Types.VARCHAR);
                objCallableStatement.executeUpdate();
                result = objCallableStatement.getString(6);
            } catch (SQLException ex) {
                System.out.println("Error en UsuariosDaoImpl.updateUsuarios: " + ex.getMessage());
                result = null;
            }
        }

        return result;

    }

    @Override
    public String deleteUsuarios(String codUsuario) {

        cn = conn.getConnection();
        sql = "call SP_ELIMINAR_USUARIO(?,?)";

        if (cn != null) {
            try {
                objCallableStatement = cn.prepareCall(sql);
                objCallableStatement.setString(1, codUsuario);
                objCallableStatement.registerOutParameter(2, Types.VARCHAR);
                objCallableStatement.executeUpdate();
                result = objCallableStatement.getString(2);

            } catch (SQLException ex) {
                System.out.println("Error en UsuariosDaoImpl.deleteUsuarios: " + ex.getMessage());
                result = null;
            }

        }

        return result;
    }

    @Override
    public List<Persona> searchPersona(String valorBusqueda) {

        cn = conn.getConnection();
        List<Persona> listPersonal = new LinkedList<>();
        sql = "Select VPERSONA_NRODOC,\n"
                + "CMILITARES_CIP,\n"
                + "CGRADOS_COD,\n"
                + "VPERSONAL_APELLNOM\n"
                + "From\n"
                + "per_militares\n"
                + "where\n"
                + "vpersona_nrodoc LIKE '%" + valorBusqueda.replaceAll("/", "%") + "%' OR upper(vpersonal_apellnom) LIKE '%" + valorBusqueda.toUpperCase().replaceAll("/", "%") + "%'";

        if (cn != null) {
            try {
                objPreparedStatement = cn.prepareStatement(sql);
                objResultSet = objPreparedStatement.executeQuery();
                while (objResultSet.next()) {
                    objPersona = new Persona();
                    objPersona.setCmilitares_Cip(objResultSet.getInt(2));
                    objPersona.setVpersona_Nrodoc(objResultSet.getString(1));
                    objPersona.setCgrados_Cod(objResultSet.getString(3).charAt(0));
                    objPersona.setVpersonal_ApellNom(objResultSet.getString(4).replaceAll("/", " "));
                    listPersonal.add(objPersona);
                }
            } catch (SQLException ex) {
                System.out.println("Error usuariosdaoImpl.searchPersona: " + ex.getMessage());
            } finally {
                if (objResultSet != null) {
                    try {
                        objResultSet.close();
                        objPreparedStatement.close();
                    } catch (SQLException ex) {
                        System.out.println("Error al cerrar la conexion usuariosdaoImpl.searchPersona: " + ex.getMessage());
                    }
                }
            }
        }

        return listPersonal;

    }

    @Override
    public Persona datosPersona(String cipPersona) {

        cn = conn.getConnection();
        sql = "SELECT\n"
                + "CMILITARES_CIP,\n"
                + "VPERSONA_NRODOC,\n"
                + "CGRADOS_COD,\n"
                + "VPERSONAL_APELLNOM,\n"
                + "CUNIDADES_COD\n"
                + "FROM\n"
                + "per_militares\n"
                + "WHERE\n"
                + "CMILITARES_CIP = '" + cipPersona + "'";

        if (cn != null) {
            try {
                objPreparedStatement = cn.prepareStatement(sql);
                objResultSet = objPreparedStatement.executeQuery();

                while (objResultSet.next()) {
                    objPersona = new Persona();
                    objPersona.setCmilitares_Cip(objResultSet.getInt(1));
                    objPersona.setVpersona_Nrodoc(objResultSet.getString(2));
                    objPersona.setCgrados_Cod(objResultSet.getString(3).charAt(0));
                    objPersona.setVpersonal_ApellNom(objResultSet.getString(4).replaceAll("/", " "));
                    objPersona.setCunidades_Cod(objResultSet.getString(5).charAt(0));
                }
            } catch (SQLException e) {
                System.out.println("Error Usuariosdaoimpl.datosPersona: " + e.getMessage());
            } finally {
                if (objResultSet != null) {
                    try {
                        objResultSet.close();
                        objPreparedStatement.close();
                    } catch (SQLException ex) {
                        System.out.println("Error al cerrar conexion en Usuariosdaoimpl.datosPersona: " + ex.getMessage());
                    }
                }
            }
        }

        return objPersona;

    }

    @Override
    public List<Object[]> getPerfilesSelect() {

        List<Object[]> selectPerfiles = null;
        cn = conn.getConnection();
        sql = "select CPERFILES_COD, VPERFILES_DESCRIPCION from PERFILES where CPERFILES_ESTADO = 'A'";

        if (cn != null) {
            try {
                objPreparedStatement = cn.prepareCall(sql);
                objResultSet = objPreparedStatement.executeQuery();
                selectPerfiles = new LinkedList<>();
                while (objResultSet.next()) {
                    Object[] reg = new Object[2];
                    reg[0] = objResultSet.getString(1);
                    reg[1] = objResultSet.getString(2);
                    selectPerfiles.add(reg);
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

        return selectPerfiles;

    }

    @Override
    public List<Persona> searchUsuarios(String valorBusqueda) {

        cn = conn.getConnection();
        List<Persona> listUsuarios = new LinkedList<>();
        sql = "Select per_militares.VPERSONA_NRODOC, per_militares.CMILITARES_CIP, per_militares.CGRADOS_COD,\n"
                + "per_militares.VPERSONAL_APELLNOM, usuarios.CUSUARIOS_COD,  usuarios.VUSUARIOS_LOGIN\n"
                + "From per_militares\n"
                + "INNER JOIN usuarios ON usuarios.CMILITARES_CIP = per_militares.CMILITARES_CIP \n"
                + "WHERE (per_militares.vpersona_nrodoc LIKE '%" + valorBusqueda + "%')\n"
                + "OR upper(per_militares.vpersonal_apellnom) LIKE '%" + valorBusqueda.toUpperCase().replaceAll("/", "%") + "%'\n"
                + "OR usuarios.VUSUARIOS_LOGIN LIKE '%" + valorBusqueda + "%'";

        if (cn != null) {
            try {
                objPreparedStatement = cn.prepareStatement(sql);
                objResultSet = objPreparedStatement.executeQuery();
                while (objResultSet.next()) {
                    objPersona = new Persona();
                    objPersona.setCmilitares_Cip(objResultSet.getInt(2));
                    objPersona.setVpersona_Nrodoc(objResultSet.getString(1));
                    objPersona.setCgrados_Cod(objResultSet.getString(3).charAt(0));
                    objPersona.setVpersonal_ApellNom(objResultSet.getString(4).replaceAll("/", " "));
                    objPersona.setCusuarios_Cod(objResultSet.getString(5).charAt(0));
                    objPersona.setVusuarios_Login(objResultSet.getString(6));
                    listUsuarios.add(objPersona);
                }
            } catch (SQLException ex) {
                System.out.println("Error usuariosdaoImpl.searchUsuarios: " + ex.getMessage());
            } finally {
                if (objResultSet != null) {
                    try {
                        objResultSet.close();
                        objPreparedStatement.close();
                    } catch (SQLException ex) {
                        System.out.println("Error al cerrar la conexion usuariosdaoImpl.searchUsuarios: " + ex.getMessage());
                    }
                }
            }
        }

        return listUsuarios;

    }

    @Override
    public Persona datosUsuario(String cipUsuario) {

        cn = conn.getConnection();
        sql = "Select mil.CMILITARES_CIP, mil.VPERSONA_NRODOC, mil.CGRADOS_COD,\n"
                + "mil.VPERSONAL_APELLNOM, usu.CUSUARIOS_COD, usu.VUSUARIOS_LOGIN From per_militares mil, usuarios usu where \n"
                + "usu.CMILITARES_CIP = mil.CMILITARES_CIP \n"
                + "and mil.CMILITARES_CIP= ' " + cipUsuario + " ' ";

        if (cn != null) {

            try {
                objPreparedStatement = cn.prepareStatement(sql);
                objResultSet = objPreparedStatement.executeQuery();

                while (objResultSet.next()) {
                    objPersona = new Persona();
                    objPersona.setCmilitares_Cip(objResultSet.getInt(1));
                    objPersona.setVpersona_Nrodoc(objResultSet.getString(2));
                    objPersona.setCgrados_Cod(objResultSet.getString(3).charAt(0));
                    objPersona.setVpersonal_ApellNom(objResultSet.getString(4).replaceAll("/", " "));
                    objPersona.setCusuarios_Cod(objResultSet.getString(5).charAt(0));
                    objPersona.setVusuarios_Login(objResultSet.getString(6));
                }
            } catch (SQLException ex) {
                System.out.println("Error en UsuariosDaoimpl.datosUsuario: " + ex.getMessage());
            } finally {
                if (objResultSet != null) {
                    try {
                        objPreparedStatement.close();
                        objResultSet.close();
                    } catch (SQLException ex) {
                        System.out.println("Error al cerrar conexion en UsuariosDaoImpl.datosUsuario:  " + ex.getMessage());
                    }
                }
            }

        }

        return objPersona;

    }

    @Override
    public List<Usuarios> listUsuariosPerfiles(String cipUsuario) {

        List<Usuarios> listUsuariosPerfiles = new LinkedList<>();
        cn = conn.getConnection();
        sql = "SELECT usuperf.cusuarios_cod, usuperf.cperfiles_cod, usu.vusuarios_login, "
                + "usu.cmilitares_cip, perf.vperfiles_descripcion\n"
                + "FROM usuarios usu, perfiles perf, usuarios_perfiles usuperf\n"
                + "WHERE usuperf.cusuarios_cod = usu.cusuarios_cod\n"
                + "AND usuperf.cperfiles_cod = perf.cperfiles_cod\n"
                + "AND usu.cmilitares_cip= ' " + cipUsuario + " ' ";

        if (cn != null) {
            try {
                objPreparedStatement = cn.prepareStatement(sql);
                objResultSet = objPreparedStatement.executeQuery();
                while (objResultSet.next()) {
                    objUsuarios = new Usuarios();
                    objUsuarios.setCmilitares_Cip(objResultSet.getInt(4));
                    objUsuarios.setCusuarios_Cod(objResultSet.getString(1).charAt(0));
                    objUsuarios.setCperfiles_Cod(objResultSet.getString(2).charAt(0));
                    objUsuarios.setVusuarios_Login(objResultSet.getString(3));
                    objUsuarios.setVperfiles_Descripcion(objResultSet.getString(5));
                    listUsuariosPerfiles.add(objUsuarios);
                }
            } catch (SQLException ex) {
                System.out.println("Error en Usuariosdaoimpl.listUsuariosPerfiles: " + ex.getMessage());
            } finally {
                if (objResultSet != null) {
                    try {
                        objPreparedStatement.close();
                        objResultSet.close();
                    } catch (SQLException ex) {
                        System.out.println("Error al cerrar conexion.listUsuariosPerfiles: " + ex.getMessage());
                    }
                }
            }
        }

        return listUsuariosPerfiles;

    }

    @Override
    public boolean insertUsuariosPerfiles(String codUsuario, String codPerfil) {

        boolean res = false;
        cn = conn.getConnection();
        sql = "{call SP_INSERTAR_USUARIOSPERFILES(?,?)}";

        if (cn != null) {
            try {
                objCallableStatement = cn.prepareCall(sql);
                objCallableStatement.setString(1, codUsuario);
                objCallableStatement.setString(2, codPerfil);
                objCallableStatement.executeUpdate();
                res = true;
            } catch (SQLException ex) {
                System.out.println("Error en UsuariosDaoImpl.insertUsuariosPerfiles; " + ex.getMessage());
            }
        }

        return res;

    }

    @Override
    public boolean deleteUsuariosPerfiles(String codUsuario, String codPerfil) {

        boolean res = false;
        cn = conn.getConnection();
        sql = "{call SP_ELIMINAR_USUARIOSPERFILES(?,?)}";

        if (cn != null) {
            try {
                objCallableStatement = cn.prepareCall(sql);
                objCallableStatement.setString(1, codUsuario);
                objCallableStatement.setString(2, codPerfil);
                objCallableStatement.executeUpdate();
                res = true;
            } catch (SQLException ex) {
                System.out.println("Error en UsuariosDaoImpl.deleteUsuariosPerfiles: " + ex.getMessage());
            }
        }

        return res;

    }

}
