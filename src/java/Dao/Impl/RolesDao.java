package Dao.Impl;

import Models.Roles;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author CARTOLIN
 */
public class RolesDao {

    DbConnection conn;

    public RolesDao(DbConnection conn) {
        this.conn = conn;
    }
    
    //LISTA TODO EL REGISTRO
    public List<Roles> verRoles() {
        try {
            String sql = "SELECT * FROM ROLES ORDER BY 1 DESC";
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            List<Roles> lista = new LinkedList<>();

            Roles roles;
            while (rs.next()) {
                roles = new Roles();
                roles.setCroles_Cod(rs.getString("CROLES_COD").charAt(0));
                roles.setVroles_Descripcion(rs.getString("VDESCRIPCION"));
                roles.setCroles_Estado(rs.getString("CESTADO"));
                lista.add(roles);
            }
            return lista;
            
        } catch (SQLException ex) {
            System.out.println("Error en RolesDao.verRoles" + ex.getMessage());
            return null;
        }
    }

    //INSERTA DATOS A LA TABLA PER_ROLES
    /*public String insert(Roles roles) {
        System.out.println("Ingresa DAOinsertRoles");
        try {
            String sql = "{call SP_INSERTAR_ROLES(?,?,?,?)}";
            CallableStatement cs = (CallableStatement) conn.getConnection().prepareCall(sql);

            cs.setString(1, roles.getVROLES_DESCOR());
            cs.setString(2, roles.getVROLES_DESLAR());
            cs.setString(3, roles.getCROLES_ESTADO());
            cs.registerOutParameter(4, Types.VARCHAR);
            cs.executeUpdate();
            System.out.println("roles: "+roles.getVROLES_DESLAR());
            System.out.println("termina proc: " + cs.getString(4));
            
            return cs.getString(4);

        } catch (SQLException ex) {
            System.out.println("Error en RolesDao.insert: " + ex.getMessage());
            return null;
        }
    }

    //ACTUALIZAR ROLES
    public String update(Roles roles) {
        try {
            String sql = "{call SP_UPDATE_ROLES(?,?,?,?,?)}";
            CallableStatement cs = (CallableStatement) conn.getConnection().prepareCall(sql);

            cs.setString(1, roles.getCROLES_CODROL());
            cs.setString(2, roles.getVROLES_DESCOR());
            cs.setString(3, roles.getVROLES_DESLAR());
            cs.setString(4, roles.getCROLES_ESTADO());
            cs.registerOutParameter(5, Types.VARCHAR);
            cs.executeUpdate();
            
            System.out.println("roles: "+roles.getVROLES_DESLAR());
            System.out.println("termina proc: " + cs.getString(5));
            
            return cs.getString(5);

        } catch (SQLException ex) {
            System.out.println("Error en RolesDao.update: " + ex.getMessage());
            return null;
        }
    }

   
    //LISTA ROLES ACTIVOS
    public List<Roles> verRolesActivos() {
        try {
            String sql = "SELECT * FROM PER_ROLES WHERE CROLES_ESTADO='A' ORDER BY 1 DESC";
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            List<Roles> lista = new LinkedList<>();

            Roles roles;
            while (rs.next()) {
                roles = new Roles(rs.getString("CROLES_CODROL"));
                roles.setVROLES_DESCOR(rs.getString("VROLES_DESCOR"));
                roles.setVROLES_DESLAR(rs.getString("VROLES_DESLAR"));
                roles.setCROLES_ESTADO(rs.getString("CROLES_ESTADO"));
                lista.add(roles);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error en RolesDao.verRolesActivos" + ex.getMessage());
            return null;
        }
    }

    //ELIMINAR REGISTRO A MODO LÓGICO
    public boolean Eliminar(int codigo) {
        try {
            String sql = "UPDATE PER_ROLES SET CROLES_ESTADO='I' WHERE CROLES_CODROL=?";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error en RolesDao.Eliminar: " + ex.getMessage());
            return false;
        }
    }

    //LISTA EN UN COMBO A PER_ROLES
    public static ArrayList<Roles> comboRol() {
        try {
            String sql = "SELECT * FROM PER_ROLES ORDER BY 1 DESC";
            Connection conn = new DbConnection().getConnection();
            CallableStatement cs = (CallableStatement) conn.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            ArrayList<Roles> lista = new ArrayList<>();

            Roles roles;
            while (rs.next()) {
                roles = new Roles(rs.getString("CROLES_CODROL"));
                roles.setVROLES_DESCOR(rs.getString("VROLES_DESCOR"));
                roles.setVROLES_DESLAR(rs.getString("VROLES_DESLAR"));
                roles.setCROLES_ESTADO(rs.getString("CROLES_ESTADO"));
                lista.add(roles);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error en RolesDao.comboRol" + ex.getMessage());
            return null;
        }
    }

    
    public Roles getidRol(String idrol) {
        Roles roles = new Roles();
        try {
            String sql = "{call SP_CI_ROLES(?,?)}";
            CallableStatement preparedStatement = (CallableStatement) conn.getConnection().prepareCall(sql);
            preparedStatement.setString(1, idrol);
            preparedStatement.registerOutParameter(2, OracleTypes.CURSOR);
            preparedStatement.execute();
            ResultSet rs = (ResultSet) preparedStatement.getObject(2);
            
            while (rs.next()) {
                roles.setCROLES_CODROL(rs.getString("CROLES_CODROL"));
                roles.setVROLES_DESCOR(rs.getString("VROLES_DESCOR"));
                roles.setVROLES_DESLAR(rs.getString("VROLES_DESLAR"));
                roles.setCROLES_ESTADO(rs.getString("CROLES_ESTADO"));

            }

        } catch (SQLException e) {
            System.out.println("Error rol.ind: " + e.getMessage());

        }
        return roles;
    }*/

}
