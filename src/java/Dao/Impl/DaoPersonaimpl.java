//package Dao.Impl;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.LinkedList;
//import java.util.List;
//import Dao.Impl.DbConnection;
//import Models.Persona;
//import Models.PersonaBeans;
//import Models.UsuPerf;
//
//public class DaoPersonaimpl implements Dao.DaoPersona {
//
//    private final DbConnection db;
//
//    public DaoPersonaimpl() {
//        db = new DbConnection();
//    }
//
//    @Override
//    public List<PersonaBeans> BuscarPersona(String Buscar) {
//        String sql = "Select VPERSONA_NRODOC,\n"
//                + "CMILITARES_CIP,\n"
//                + "CGRADOS_COD,\n"
//                + "VPERSONAL_APELLNOM\n"
//                + "From\n"
//                + "per_lrmilitares\n"
//                + "where\n"
//                + "vpersona_nrodoc LIKE '%" + Buscar.replaceAll("/", "%") + "%' OR upper(vpersonal_apellnom) LIKE '%" + Buscar.toUpperCase().replaceAll("/", "%") + "%'";
//        System.out.println(sql);
//        List list = null;
//        Connection cn = db.getConnection();
//        if (cn != null) {
//            try {
//                PreparedStatement ps = cn.prepareStatement(sql);
//                ResultSet rs = ps.executeQuery();
//                list = new LinkedList<>();
//                while (rs.next()) {
//                    PersonaBeans reg = new PersonaBeans();
//                    reg.setCip(rs.getInt(2));
//                    reg.setDni(rs.getString(1));
//                    reg.setGrado(rs.getString(3));
//                    reg.setApellNom(rs.getString(4).replaceAll("/", " "));
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
//    //@Override
//    public List<Persona> BuscarUsuario(String Buscar) {
//        String sql = "Select mil.VPERSONA_NRODOC, mil.CMILITARES_CIP, mil.CGRADOS_COD,"
//                + " mil.VPERSONAL_APELLNOM, usu.CUSUARIOS_IDUSERS From per_lrmilitares mil, per_usuario usu where "
//                + "usu.CMILITARES_CIP = mil.CMILITARES_CIP "
//                + "and (mil.vpersona_nrodoc LIKE '%" + Buscar.replaceAll("/", "%") + "%' OR upper(mil.vpersonal_apellnom) LIKE '%" + Buscar.toUpperCase().replaceAll("/", "%") + "%')";
//        System.out.println(sql);
//        List list = null;
//        Connection cn = db.getConnection();
//        if (cn != null) {
//            try {
//                PreparedStatement ps = cn.prepareStatement(sql);
//                ResultSet rs = ps.executeQuery();
//                list = new LinkedList<>();
//                while (rs.next()) {
//                    PersonaBeans reg = new PersonaBeans();
//                    reg.setCip(rs.getInt(2));
//                    reg.setDni(rs.getString(1));
//                    reg.setGrado(rs.getString(3));
//                    reg.setApellNom(rs.getString(4).replaceAll("/", " "));
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
//    @Override
//    public PersonaBeans DatosPersona(String Cip) {
//        String sql = "SELECT\n"
//                + "CMILITARES_CIP,\n"
//                + "VPERSONA_NRODOC,\n"
//                + "CGRADOS_COD,\n"
//                + "VPERSONAL_APELLNOM,\n"
//                + "CUNIDADES_COD\n"
//                + "FROM\n"
//                + "per_planilla\n"
//                + "WHERE\n"
//                + "CMILITARES_CIP = '" + Cip + "'";
//        System.out.println(sql);
//        PersonaBeans reg = new PersonaBeans();
//        Connection cn = db.getConnection();
//        if (cn != null) {
//            try {
//                PreparedStatement ps = cn.prepareStatement(sql);
//                ResultSet rs = ps.executeQuery();
//
//                while (rs.next()) {
//                    reg.setCip(rs.getInt(1));
//                    reg.setDni(rs.getString(2));
//                    reg.setGrado(rs.getString(3));
//                    reg.setApellNom(rs.getString(4).replaceAll("/", " "));
//                    reg.setUnidad(rs.getString(5));
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
//    }
//
//    @Override
//    public PersonaBeans DatosUsuario(String Cip) {
//        String sql = "Select mil.CMILITARES_CIP, mil.VPERSONA_NRODOC, mil.CGRADOS_COD,"
//                + " mil.VPERSONAL_APELLNOM, usu.CUSUARIOS_IDUSERS From per_lrmilitares mil, per_usuario usu where "
//                + "usu.CMILITARES_CIP = mil.CMILITARES_CIP "
//                + "and mil.CMILITARES_CIP= '" + Cip + "'";
//
//        System.out.println(sql);
//        PersonaBeans reg = new PersonaBeans();
//        Connection cn = db.getConnection();
//        if (cn != null) {
//            try {
//                PreparedStatement ps = cn.prepareStatement(sql);
//                ResultSet rs = ps.executeQuery();
//
//                while (rs.next()) {
//                    reg.setCip(rs.getInt(1));
//                    reg.setDni(rs.getString(2));
//                    reg.setGrado(rs.getString(3));
//                    reg.setApellNom(rs.getString(4).replaceAll("/", " "));
//                    reg.setCodigo(rs.getString(5));
//                }
//                
//                System.out.println("listado"+reg);
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
//    }
//
//    @Override
//    public List<PersonaBeans> BuscarPersonaCip(String Buscar) {
//        String sql = "Select distinct CMILITARES_CIP,VPERSONA_NRODOC,CGRADOS_COD,VPERSONAL_APELLNOM From per_planilla where upper(vpersonal_apellnom) LIKE '%" + Buscar.toUpperCase().replaceAll("/", "%") + "%'";
//        System.out.println(sql);
//        List list = null;
//        Connection cn = db.getConnection();
//        if (cn != null) {
//            try {
//                PreparedStatement ps = cn.prepareStatement(sql);
//                ResultSet rs = ps.executeQuery();
//                list = new LinkedList<>();
//                while (rs.next()) {
//                    PersonaBeans reg = new PersonaBeans();
//                    reg.setCip(rs.getInt(1));
//                    reg.setDni(rs.getString(2));
//                    reg.setGrado(rs.getString(3));
//                    reg.setApellNom(rs.getString(4).replaceAll("/", " "));
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
//}
