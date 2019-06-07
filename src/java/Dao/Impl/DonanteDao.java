package Dao.Impl;

import Dao.DaoDonante;
import Models.Donante;
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
 * @author LEO
 */
public class DonanteDao implements DaoDonante {

    private DbConnection conn;
    private String sql;
    private Connection cn;
    private PreparedStatement pst;
    private CallableStatement cs;
    private ResultSet rs;
    private Donante donante;
    private String result;

    public DonanteDao(DbConnection conn) {
        this.conn = conn;
    }

    @Override
    public List<Donante> listDonante() {
        List<Donante> listDonante = new LinkedList<>();
        cn = conn.getConnection();
        sql = "SELECT DN.CDONANTE_COD AS codigo, DN.VNOMBRE AS nombre, DN.CTELEFONO AS telefono, DN.VEMAIL AS email,\n"
                + "TD.VDESCRIPCION AS descripcion, DN.CNRODOC AS NRO\n"
                + "FROM DONANTE DN\n"
                + "INNER JOIN TIPO_DOC TD ON TD.CTIPODOC_COD = DN.CTIPODOC_COD";

        if (cn != null) {
            try {
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    donante = new Donante();
                    donante.setCDONANTE_COD(rs.getString("codigo"));
                    donante.setVNOMBRE(rs.getString("nombre"));
                    donante.setCTELEFONO(rs.getString("telefono"));
                    donante.setVEMAIL(rs.getString("email"));
                    donante.setCTIPODOC_COD(rs.getString("descripcion"));
                    donante.setCNRODOC(rs.getString("NRO"));

                    listDonante.add(donante);
                }
            } catch (SQLException e) {
                System.out.println("Error al listarDonante: " + e.getMessage());
                return null;
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                        pst.close();
                    }
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexion xd: " + e.getMessage());
                }
            }
        }
        return listDonante;
    }

    @Override
    public String insertDonante(Donante donante) {
        cn = conn.getConnection();
        sql = "{CALL SP_INSERT_DONANTE (?,?,?,?,?)}";
        if (cn != null) {
            try {
                cs = cn.prepareCall(sql);
                cs.setString(1, donante.getVNOMBRE());
                cs.setString(2, donante.getCTELEFONO());
                cs.setString(3, donante.getVEMAIL());
                cs.setString(4, donante.getCTIPODOC_COD());
                cs.setString(5, donante.getCNRODOC());
                cs.registerOutParameter(5, Types.VARCHAR);
                cs.executeUpdate();
                System.out.println("termina proc: " + cs.getString(5));
                cs.executeUpdate();
                result = cs.getString(5);
            } catch (SQLException e) {
                System.out.println("Error al insertar DonanteDao: " + e.getMessage());
                result = null;
            }
        }
        return result;
    }

    @Override
    public String updateDonante(Donante donante) {
        cn = conn.getConnection();
        sql = "{CALL SP_UPDATE_DONANTE (?,?,?,?,?,?)}";
        if (cn != null) {
            try {
                cs = cn.prepareCall(sql);
                cs.setString(1, donante.getCDONANTE_COD());
                cs.setString(2, donante.getVNOMBRE());
                cs.setString(3, donante.getCTELEFONO());
                cs.setString(4, donante.getVEMAIL());
                cs.setString(5, donante.getCTIPODOC_COD());
                cs.setString(6, donante.getCNRODOC());
                cs.registerOutParameter(6, Types.VARCHAR);
                cs.executeUpdate();
                System.out.println("termina proc: " + cs.getString(6));
                cs.executeUpdate();
                result = cs.getString(6);
            } catch (SQLException e) {
                System.out.println("Error al actualizar DonanteDao: " + e.getMessage());
                result = null;
            }
        }
        return result;
    }

    @Override
    public String deleteDonante(String id) {

        cn = conn.getConnection();
        sql = "{call SP_DELETE_DONANTE(?,?)}";
        if (cn != null) {
            try {
                cs = cn.prepareCall(sql);
                cs.setString(1, id);
                cs.registerOutParameter(2, Types.VARCHAR);
                cs.executeUpdate();
                result = cs.getString(2);
            } catch (SQLException e) {
                System.out.println("Error al eliminar donanteDao: " + e.getMessage());
                result = null;
            }
        }
        return result;
    }

    @Override
    public List<Object[]> getDonanteSeect() {
        List<Object[]> donanteSelect = null;
        cn = conn.getConnection();
        sql = "select CDONANTE_COD, VNOMBRE from DONANTE\n"
                + "where CDONANTE_COD = CDONANTE_COD";

        if (cn != null) {
            try {
                pst = cn.prepareCall(sql);
                rs = pst.executeQuery();
                donanteSelect = new LinkedList<>();
                while (rs.next()) {
                    Object[] reg = new Object[2];
                    reg[0] = rs.getString(1);
                    reg[1] = rs.getString(2);
                    donanteSelect.add(reg);
                }

            } catch (SQLException ex) {
                System.out.println("Error en ModulosDaoimpl.getModulosSuperSelect: " + ex.getMessage());
            } finally {
                if (rs != null) {
                    try {
                        rs.close();
                        pst.close();
                    } catch (SQLException ex) {
                        System.out.println("Error al cerrar conexion en ModulosDaoimpl.getModulosSuperSelect: " + ex.getMessage());
                    }
                }
            }
        }
        return donanteSelect;
    }

    @Override
    public List<Object[]> getTipodocSeect() {
        List<Object[]> donanteSelect = null;
        cn = conn.getConnection();
        sql = "select CTIPODOC_COD, VDESCRIPCION from TIPO_DOC\n"
                + "where CTIPODOC_COD = CTIPODOC_COD AND CESTADO = 'A'";

        if (cn != null) {
            try {
                pst = cn.prepareCall(sql);
                rs = pst.executeQuery();
                donanteSelect = new LinkedList<>();
                while (rs.next()) {
                    Object[] reg = new Object[2];
                    reg[0] = rs.getString(1);
                    reg[1] = rs.getString(2);
                    donanteSelect.add(reg);
                }
            } catch (SQLException ex) {
                System.out.println("Error en ModulosDaoimpl.getModulosSuperSelect: " + ex.getMessage());
            } finally {
                if (rs != null) {
                    try {
                        rs.close();
                        pst.close();
                    } catch (SQLException ex) {
                        System.out.println("Error al cerrar conexion en ModulosDaoimpl.getModulosSuperSelect: " + ex.getMessage());
                    }
                }
            }
        }

        return donanteSelect;
    }
}
