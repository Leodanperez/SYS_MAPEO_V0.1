package Dao.Impl;

import Dao.ProceDonacionesDao;
import Models.DetalleDonacion;
import Models.Emergencias;
import Models.ProcesoDonaciones;
import java.sql.CallableStatement;
import java.sql.Connection;
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
public class DaoProcDonaciones implements ProceDonacionesDao {

    private final DbConnection conn;
    private Connection con;
    private String query;
    private CallableStatement objCallableStatement;
    private PreparedStatement ps;
    private ResultSet rs;
    private ProcesoDonaciones procesoDonaciones;
    private String result;
    private DetalleDonacion detalle;

    public DaoProcDonaciones(DbConnection conn) {
        this.conn = conn;
    }

    @Override
    public List<DetalleDonacion> getSelectEmergencia() {
        List<DetalleDonacion> lista = new LinkedList<>();
        con = conn.getConnection();
        query = "select CDETALLE_COD, TP.VDESCRIPCION, ICANTIDAD_PROD, PDB.CDONACIONBAH_COD,EA.VDESCRIPCION AS EDAD\n"
                + "from DETALLE_DONACION_BAH DTB\n"
                + "inner join PRODUCTOS PR ON DTB.CPRODUCTO_COD = PR.CPRODUCTO_COD\n"
                + "inner join PROC_DONACION_BAH PDB ON DTB.CDONACIONBAH_COD = PDB.CDONACIONBAH_COD\n"
                + "INNER JOIN EDAD_ANTROPOLOGICA EA ON DTB.CEDADANTROP_COD = EA.CEDADANTROP_COD\n"
                + "INNER JOIN TIPO_PRODUCTO TP ON PR.CTPRODUCTO_COD = TP.CTPRODUCTO_COD";

        if (con != null) {
            try {
                ps = con.prepareStatement(query);
                rs = ps.executeQuery();

                while (rs.next()) {
                    detalle = new DetalleDonacion();
                    detalle.setCDETADONA_COD(rs.getString("CDETALLE_COD"));
                    detalle.setTIPOPRODUCTO(rs.getString("VDESCRIPCION"));
                    detalle.setICANTIDAD_PROD(rs.getInt("ICANTIDAD_PROD"));
                    detalle.setCDONA_COD(rs.getString("CDONACIONBAH_COD"));
                    detalle.setEDADANTROPOLOGICA(rs.getString("EDAD"));

                    lista.add(detalle);
                }
            } catch (SQLException e) {
                System.out.println("Error al listar emergencias: " + e.getMessage());
                return null;
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                        ps.close();
                    }
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexion en ModulosDaoimpl.listModulosSuper: " + e.getMessage());
                }
            }
        }
        return lista;
    }

    @Override
    public ArrayList<ProcesoDonaciones> getSelectUnidad() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String calcularProceso(ProcesoDonaciones objProcesoDonaciones) {
        con = conn.getConnection();
        query = "{call SP_DONACION_BAH(?,?)}";

        if (con != null) {
            try {
                objCallableStatement = con.prepareCall(query);
                objCallableStatement.setString(1, objProcesoDonaciones.getCEMERGENCIA_COD());
                objCallableStatement.registerOutParameter(2, Types.VARCHAR);
                objCallableStatement.executeUpdate();
                System.out.println("termina proc: " + objCallableStatement.getString(2));
                result = objCallableStatement.getString(2);
            } catch (SQLException e) {
                System.out.println("Error al insertar ProcesoDonaciones: " + e.getMessage());
                result = null;
            }
        }
        return result;
    }

    //COMBO TIPO DE VEHICULOS
    public static ArrayList<Emergencias> getEmergencia() {
        try {
            String consulta = "select * from EMERGENCIAS WHERE CEMERGENCIA_COD = CEMERGENCIA_COD and CESTADO='A' order by 1 desc";
            Connection conn = new DbConnection().getConnection();
            CallableStatement sentencia = (CallableStatement) conn.prepareCall(consulta);
            ResultSet rs = sentencia.executeQuery();
            ArrayList<Emergencias> lista = new ArrayList<>();
            while (rs.next()) {
                Emergencias emregencia = new Emergencias();
                emregencia.setCEMERGENCIA_COD(rs.getString("CEMERGENCIA_COD"));
                emregencia.setVDESCRIPCION(rs.getString("VDESCRIPCION"));
                lista.add(emregencia);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Error ComboEmergencia: " + e.getMessage());
        }
        return null;
    }

}
