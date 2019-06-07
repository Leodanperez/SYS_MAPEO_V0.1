package Dao.Impl;

import Models.Donaciones;
import Models.Donante;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author LEO
 */
public class DonacionesDao implements Dao.DaoDonaciones{

    private DbConnection conn;
    private Connection con;
    private String query;
    private CallableStatement objCallableStatement;
    private PreparedStatement ps;
    private ResultSet rs;
    private Donaciones donaciones;
    private String result;

    public DonacionesDao(DbConnection conn) {
        this.conn = conn;
    }

    @Override
    public List<Donaciones> listDonaciones() {
        try {
            List<Donaciones> lista = new LinkedList<>();
            con = conn.getConnection();
            query = "SELECT DN.CDONA_COD AS codigo, DN.VLUG_ORIGEN AS lugar, DN.DDONA_FECHA AS fecha, DT.VNOMBRE AS nombre,\n"
                    + "DN.COD_UNIDAD AS unidad, DN.DPESO_TOTAL as peso, DN.DVOLUMEN_TOTAL as volumen, DN.VRECEPCION as recp, DN.VMOVIMIENTO as mov,\n"
                    + "DN.VENTRADA as entrada, DN.CMILITARES_CIP as cip\n"
                    + "FROM DONACIONES DN\n"
                    + "INNER JOIN DONANTE DT ON DT.CDONANTE_COD = DN.CDONANTE_COD";
            
            ps = conn.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                donaciones = new Donaciones();
                donaciones.setCDONA_COD(rs.getString("codigo"));
                donaciones.setVLUG_ORIGEN(rs.getString("lugar"));
                donaciones.setDDONA_FECHA(rs.getDate("fecha"));
                donaciones.setCDONATE_COD(rs.getString("nombre"));
                donaciones.setCOD_UNIDAD(rs.getString("unidad").charAt(0));
                donaciones.setDPESO_TOTAL(rs.getInt("peso"));
                donaciones.setDVOLUMEN_TOTAL(rs.getInt("volumen"));
                donaciones.setVRECEPCION(rs.getString("recp"));
                donaciones.setVMOVIMIENTO(rs.getString("mov"));
                donaciones.setVENTRADA(rs.getString("entrada"));
                donaciones.setCPERMILITARES_COD(rs.getInt("cip"));

                lista.add(donaciones);
            }
            return lista;

        } catch (SQLException e) {
            System.out.println("Error verDonaciones: " + e.getMessage());
        }
        return null;
    }
    
    @Override
    public String insertDonaciones(Donaciones donaciones) {
        con = conn.getConnection();
        query = "{call SP_INSERT_DONACIONES(?,?,?,?,?,?,?,?,?,?,?)}";
        if (con != null) {
            try {
                objCallableStatement = con.prepareCall(query);
                objCallableStatement.setString(1, donaciones.getVLUG_ORIGEN());
                objCallableStatement.setDate(2, (Date) donaciones.getDDONA_FECHA());
                objCallableStatement.setString(3, String.valueOf(donaciones.getCDONATE_COD()));
                objCallableStatement.setString(4, String.valueOf(donaciones.getCOD_UNIDAD()));
                objCallableStatement.setInt(5, donaciones.getDPESO_TOTAL());
                objCallableStatement.setInt(6, donaciones.getDVOLUMEN_TOTAL());
                objCallableStatement.setInt(7, donaciones.getCPERMILITARES_COD());
                objCallableStatement.setString(8, donaciones.getVRECEPCION());
                objCallableStatement.setString(9, donaciones.getVMOVIMIENTO());
                objCallableStatement.setString(10, donaciones.getVENTRADA());

                objCallableStatement.registerOutParameter(11, Types.VARCHAR);

                objCallableStatement.executeUpdate();

                System.out.println("termina proc: " + objCallableStatement.getString(11));
                result = objCallableStatement.getString(11);
            } catch (SQLException e) {
                System.out.println("Error al insertar Donaciones Dao: " + e.getMessage());
                result = null;
            }
        }
        return result;
    }

    @Override
    public String updateDonaciones(Donaciones donaciones) {
        con = conn.getConnection();
        query = "{call SP_UPDATE_DONACIONES(?,?,?,?,?,?,?,?,?,?,?,?)}";
        if (con != null) {
            try {
                objCallableStatement = con.prepareCall(query);
                objCallableStatement.setString(1, String.valueOf(donaciones.getCDONA_COD()));
                objCallableStatement.setString(2, donaciones.getVLUG_ORIGEN());
                objCallableStatement.setDate(3, (Date) donaciones.getDDONA_FECHA());
                objCallableStatement.setString(4, String.valueOf(donaciones.getCDONATE_COD()));
                objCallableStatement.setString(5, String.valueOf(donaciones.getCOD_UNIDAD()));
                objCallableStatement.setInt(6, donaciones.getDPESO_TOTAL());
                objCallableStatement.setInt(7, donaciones.getDVOLUMEN_TOTAL());
                objCallableStatement.setInt(8, donaciones.getCPERMILITARES_COD());
                objCallableStatement.setString(9, donaciones.getVRECEPCION());
                objCallableStatement.setString(10, donaciones.getVMOVIMIENTO());
                objCallableStatement.setString(11, donaciones.getVENTRADA());

                objCallableStatement.registerOutParameter(11, Types.VARCHAR);

                objCallableStatement.executeUpdate();

                System.out.println("termina proc: " + objCallableStatement.getString(11));
                result = objCallableStatement.getString(11);
            } catch (SQLException e) {
                System.out.println("Error al actualizar Donaciones Dao: " + e.getMessage());
                result = null;
            }
        }
        return result;
    }

    @Override
    public String deleteDonaciones(String id) {
        con = conn.getConnection();
        query = "{call SP_ELIMINAR_DONACIONES(?,?)}";
        if (con != null) {
            try {
                objCallableStatement = con.prepareCall(query);
                objCallableStatement.setString(1, id);
                objCallableStatement.registerOutParameter(2, Types.VARCHAR);
                objCallableStatement.executeUpdate();
                result = objCallableStatement.getString(2);
            } catch (SQLException e) {
                System.out.println("Error al eliminar donaciones: " + e.getMessage());
                result = null;
            }
        }
        return result;
    }

    //llenar combo donante
    public static ArrayList<Donante> listTipoDoc() {
        try {
            //select * from per_modulos where cmodulos_codmodulos = cedmod_super and cmpdulos_estado='A' order by 1 desc
            String consulta = "select * from TIPO_DOC WHERE CTIPODOC_COD = CTIPODOC_COD and CESTADO='A' order by 1 desc";
            Connection conn = new DbConnection().getConnection();
            CallableStatement sentencia = (CallableStatement) conn.prepareCall(consulta);
            ResultSet rs = sentencia.executeQuery();
            ArrayList<Donante> lista = new ArrayList<>();
            while (rs.next()) {
                Donante donante = new Donante();
                donante.setCDONANTE_COD(rs.getString("CTIPODOC_COD"));
                donante.setVNOMBRE(rs.getString("VDESCRIPCION"));
                lista.add(donante);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Error comboDonante: " + e.getMessage());
            return null;
        }
    }
}
