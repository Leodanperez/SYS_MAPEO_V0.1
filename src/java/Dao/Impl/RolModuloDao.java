//package Dao.Impl;
//
//import Models.Modulos;
//import Models.RolModulo;
//import java.sql.CallableStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// *
// * @author CARTOLIN
// */
//public class RolModuloDao {
//
//    DbConnection conn;
//
//    public RolModuloDao(DbConnection conn) {
//        this.conn = conn;
//    }
//
//    //INSERTAR DATA A LA TABLA MODULO-ROLES
//    public boolean insert(RolModulo modrol) {
//        try {
//            String sql = "INSERT INTO PER_MODULOS_PER_ROLES VALUES (?,?)";
//            //String sql = "{CALL SP_INSERTAR_PERFUSUARIO(?,?,?)}";
//            //CallableStatement cs = (CallableStatement) conn.getConnection().prepareCall(sql);
//            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
//            ps.setInt(1, modrol.getCmodulos_codmodulo());
//            ps.setString(2, modrol.getCroles_codrol());
//            ps.executeUpdate();
//            return true;
//        } catch (SQLException e) {
//            System.out.println("Error RolModuloDao.insert: " + e.getMessage());
//            return false;
//        }
//    }
//
//    //LISTA TODO EL MODULO-ROLES
//    public List<RolModulo> getAllModRol(Integer Cod) {
//        try {
//            //   String sql = "select CMODULOS_CODMODULO,CROLES_CODROL from PER_MODULOS_PER_ROLES where CMODULOS_CODMODULO=?";
//
//            String sql = "SELECT PM.CMODULOS_CODMODULO AS CODMODULO, PM.VMODULOS_DESLAR MODULO,PR.CROLES_CODROL AS CODROL, PR.VROLES_DESLAR AS ROL\n"
//                    + "FROM PER_MODULOS_PER_ROLES PMR\n"
//                    + "INNER JOIN PER_MODULOS PM ON PM.CMODULOS_CODMODULO=PMR.CMODULOS_CODMODULO\n"
//                    + "INNER JOIN PER_ROLES PR ON PR.CROLES_CODROL=PMR.CROLES_CODROL\n" +
//            "WHERE PMR.CMODULOS_CODMODULO=?";
//
//            System.out.println(sql);
//            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
//            preparedStatement.setInt(1, Cod);
//            ResultSet rs = preparedStatement.executeQuery();
//            List<RolModulo> lista = new LinkedList<>();
//
//            RolModulo modrol;
//            while (rs.next()) {
//                modrol = new RolModulo();
//                modrol.setCodModulo(rs.getString("CODMODULO"));
//                modrol.setCroles_codrol(rs.getString("CODROL"));
//                modrol.setModulos(rs.getString("MODULO"));
//                modrol.setRoles(rs.getString("ROL"));
//                lista.add(modrol);
//            }
//            return lista;
//        } catch (SQLException ex) {
//            System.out.println("Error en RolModuloDao.getAllModRol" + ex.getMessage());
//            return null;
//        }
//    }
//
//    //BUSQUEDA DE MODULOS PARA LA ASIGNACION DE UN ROL
//    public List<Modulos> BuscarModulo(String Buscar) {
//        String sql = "SELECT CMODULOS_CODMODULO, VMODULOS_DESCOR,VMODULOS_DESLAR FROM PER_MODULOS WHERE "
//                + "VMODULOS_DESCOR LIKE '%" + Buscar + "%' OR VMODULOS_DESLAR LIKE '%" + Buscar.toUpperCase() + "%'";
//        /*String sqp = "SELECT CMODULOS_CODMODULO, VMODULOS_DESCOR,VMODULOS_DESLAR FROM PER_MODULOS WHERE CMODULOS_CODMODULO=CMODULOS_MODSUPER AND CMODULOS_ESTADO='A' "
//                + "AND (VMODULOS_DESCOR LIKE '%" + Buscar + "%' OR VMODULOS_DESLAR LIKE '%" + Buscar.toUpperCase() + "%')";*/
//        System.out.println(sql);
//        List list = null;
//        Connection cn = conn.getConnection();
//        if (cn != null) {
//            try {
//                PreparedStatement ps = cn.prepareStatement(sql);
//                ResultSet rs = ps.executeQuery();
//                list = new LinkedList<>();
//                while (rs.next()) {
//                    Modulos reg = new Modulos();
//                    reg.setCmodulos_codmodulo(rs.getInt(1));
//                    reg.setVmodulos_descor(rs.getString(2));
//                    reg.setVmodulos_deslar(rs.getString(3));
//                    //reg.setCmodulos_estado(rs.getString(4));
//                    list.add(reg);
//                }
//            } catch (SQLException e) {
//                System.out.println(e.getMessage());
//            } finally {
//                try {
//                    cn.close();
//                } catch (SQLException e) {
//                }
//            }
//        }
//        return list;
//    }
//
//    public Modulos DatosModulo(String Cod) {
//        String sql = "SELECT CMODULOS_CODMODULO,VMODULOS_DESCOR,VMODULOS_DESLAR FROM PER_MODULOS "
//                + "WHERE CMODULOS_CODMODULO='" + Cod + "'";
//        System.out.println(sql);
//        Modulos reg = new Modulos();
//        Connection cn = conn.getConnection();
//        if (cn != null) {
//            try {
//                PreparedStatement ps = cn.prepareStatement(sql);
//                ResultSet rs = ps.executeQuery();
//
//                while (rs.next()) {
//                    reg.setCmodulos_codmodulo(rs.getInt(1));
//                    reg.setVmodulos_descor(rs.getString(2));
//                    reg.setVmodulos_deslar(rs.getString(3));
//
//                }
//            } catch (SQLException e) {
//                System.out.println(e.getMessage());
//            } finally {
//                try {
//                    cn.close();
//                } catch (SQLException e) {
//                }
//            }
//        }
//        return reg;
//        //return null;
//    }
//    
//    public boolean eliminar (RolModulo modRol){
//        
//        try {
//            String sql="{CALL SP_ELIMINAR_ROLMODULO(?,?)}";
//            
//            CallableStatement cs=(CallableStatement)conn.getConnection().prepareCall(sql);
//            cs.setString(1, modRol.getCodModulo());
//            cs.setString(2, modRol.getCroles_codrol());
//            cs.executeUpdate();
//            return true;
//        } catch (SQLException e) {
//            System.out.println("Error en RolModuloDao.eliminar: "+e.getMessage());
//            return false;
//        }
//    }
//
//}
