///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Dao.Impl;
//
//import Models.Modulos;
//import Models.Perfiles;
//import java.sql.CallableStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// *
// * @author LEO
// */
//public class ModuloPerfilDao {
//
//    DbConnection conn;
//
//    public ModuloPerfilDao(DbConnection conn) {
//        this.conn = conn;
//    }
//
//    //INSERTAR ASIGNACIÓN (MODULO-PERFIL)
//    public boolean insertPerModulo(ModuloPerfil perfilModulo) {
//        try {
//            String sql = "{CALL SP_INSERTAR_PERFIL_MODULO(?,?)}";
//            CallableStatement cs = (CallableStatement) conn.getConnection().prepareCall(sql);
//            cs.setInt(1, perfilModulo.getCperfil_codperfil());
//            cs.setString(2, perfilModulo.getCmodulos_codmodulo());
//            cs.executeUpdate();
//            return true;
//        } catch (SQLException e) {
//            System.out.println("Error en ModuloPerfilDao.insertPerModulo: " + e.getMessage());
//        }
//        return false;
//    }
//
//    public static ArrayList<Modulos> comboModulo() {
//        try {
//            String sql = "SELECT * FROM PER_MODULOS where CMODULOS_ESTADO='A' ORDER BY 1 DESC";
//            Connection conn = new DbConnection().getConnection();
//            CallableStatement cs = (CallableStatement) conn.prepareCall(sql);
//            ResultSet rs = cs.executeQuery();
//            ArrayList<Modulos> lista = new ArrayList<>();
//
//            Modulos roles;
//            while (rs.next()) {
//                roles = new Modulos(rs.getString("CMODULOS_CODMODULO"));
//                roles.setVmodulos_descor(rs.getString("VMODULOS_DESCOR"));
//                roles.setVmodulos_deslar(rs.getString("VMODULOS_DESLAR"));
//                roles.setModulos_estado(rs.getString("CMODULOS_ESTADO"));
//                lista.add(roles);
//            }
//            return lista;
//        } catch (SQLException ex) {
//            System.out.println("Error en RolesDao.comboRol" + ex.getMessage());
//            return null;
//        }
//    }
//
//    //BUSQUEDA DE MODULOS PARA LA ASIGNACION DE UN PERFIL 
//    public List<Perfiles> BuscarPerfil(String Buscar) {
//
//        String sql = "SELECT CPERFILES_CODPERFIL, VPERFILES_DESCOR,VPERFILES_DESLAR FROM PER_PERFILES \n"
//                + "WHERE  CPERFILES_CODPERFIL LIKE '%" + Buscar.toUpperCase() + "%' OR VPERFILES_DESLAR LIKE '%" + Buscar + "%'";
//        System.out.println(sql);
//        List list = null;
//        Connection cn = conn.getConnection();
//        if (cn != null) {
//            try {
//                PreparedStatement ps = cn.prepareStatement(sql);
//                ResultSet rs = ps.executeQuery();
//                list = new LinkedList<>();
//                while (rs.next()) {
//                    Perfiles perModulos = new Perfiles();
//                    perModulos.setCPERFILES_CODPERFIL(rs.getString(1));
//                    perModulos.setVPERFILES_DESCOR(rs.getString(2));
//                    perModulos.setVPERFILES_DESLAR(rs.getString(3));
//                    //reg.setCmodulos_estado(rs.getString(4));
//                    list.add(perModulos);
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
//    //MOSTRAR LISTA DE PERFILES (MODAL)
//    public Perfiles DatosPerfiles(String Cod) {
//
//        String sql = "SELECT CPERFILES_CODPERFIL,VPERFILES_DESCOR,VPERFILES_DESLAR,CPERFILES_ESTADO FROM PER_PERFILES\n"
//                + "WHERE CPERFILES_CODPERFIL='" + Cod + "'";
//        System.out.println(sql);
//        Perfiles perfil = new Perfiles();
//        Connection cn = conn.getConnection();
//        if (cn != null) {
//            try {
//                PreparedStatement ps = cn.prepareStatement(sql);
//                ResultSet rs = ps.executeQuery();
//
//                while (rs.next()) {
//                    perfil.setCPERFILES_CODPERFIL(rs.getString(1));
//                    perfil.setVPERFILES_DESCOR(rs.getString(2));
//                    perfil.setVPERFILES_DESLAR(rs.getString(3));
//                    perfil.setCPERFILES_ESTADO(rs.getString(4));
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
//        return perfil;
//        //return null;
//    }
//
//    //LISTA DE ASIGNACIÓN (MODULO-PERFIL)
//    public List<ModuloPerfil> getAllPerfil(Integer cod) {
//        try {
//            String sql = "select PMP.CPERFILES_CODPERFIL AS CODPERFIL, PMP.VPERFILES_DESCOR as PERFIL, PM.CMODULOS_CODMODULO AS CODMODULO, PM.VMODULOS_DESLAR AS MODULOS \n"
//                    + "FROM PER_PERFILES_PER_MODULOS PPM\n"
//                    + "INNER JOIN PER_PERFILES PMP ON PMP.CPERFILES_CODPERFIL=PPM.CPERFILES_CODPERFIL\n"
//                    + "INNER JOIN PER_MODULOS PM ON PM.CMODULOS_CODMODULO=PPM.CMODULOS_CODMODULO\n"
//                    + "WHERE PPM.CPERFILES_CODPERFIL=?";
//            System.out.println(sql);
//            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
//            preparedStatement.setInt(1, cod);
//            ResultSet rs = preparedStatement.executeQuery();
//            List<ModuloPerfil> lista = new LinkedList<>();
//
//            ModuloPerfil perModulo;
//            while (rs.next()) {
//                perModulo = new ModuloPerfil();
//                perModulo.setCodPerfil(rs.getString("CODPERFIL"));
//                perModulo.setPefil(rs.getString("PERFIL"));
//                perModulo.setCmodulos_codmodulo(rs.getString("CODMODULO"));
//                perModulo.setModulo(rs.getString("MODULOS"));
//                lista.add(perModulo);
//            }
//            return lista;
//        } catch (SQLException e) {
//            System.out.println("Error al listar PerfilModuloDao.getAllPerfil " + e.getMessage());
//            return null;
//        }
//    }
//
//    //ELIMINAR ASIGNACION PERFILMODULODAO
//    public boolean eliminar(ModuloPerfil perModulo) {
//
//        try {
//            String sql = "{CALL SP_ELIMINAR_MODPERFIL(?,?)}";
//            CallableStatement cs = (CallableStatement) conn.getConnection().prepareCall(sql);
//
//            cs.setString(1, perModulo.getCodPerfil());
//            cs.setString(2, perModulo.getCmodulos_codmodulo());
//            cs.executeUpdate();
//            return true;
//
//        } catch (SQLException e) {
//            System.out.println("Error al eliminar en PerfilModuloDao.eliminar: " + e.getMessage());
//            return false;
//        }
//
//    }
//
//}
