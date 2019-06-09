package Dao.Impl;

import Dao.DaoProceVehiculos;
import Models.ListAllVehiculosProc;
import Models.ProceVehiculos;
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
 * @author EDITH GALINDO
 */
public class DaoProceVehiculosImpl implements DaoProceVehiculos {

    final private DbConnection conn;
    private String sql;
    private Connection cn;
    private PreparedStatement pst;
    private CallableStatement cs;
    private ResultSet rs;
    private ProceVehiculos proceVehiculos;
    private String result;
    private ListAllVehiculosProc listvehiculo;

    public DaoProceVehiculosImpl(DbConnection conn) {
        this.conn = conn;
    }

    @Override
    public List<ListAllVehiculosProc> listVehiculos() {
        List<ListAllVehiculosProc> listDonan = new LinkedList<>();
        cn = conn.getConnection();
        sql = "SELECT VH.DVOLUMEN,VH.VPLACA,VH.COMBUSTIBLE,TP.VDESCRIPCION AS VEHICULOS,DTC.SUBTOTAL_COMBUSTIBLE,UM.VDESCRIPCION AS UNIDAD,\n"
                + "EMG.VDESCRIPCION AS EMERGENCIA\n"
                + "FROM VEHICULO VH\n"
                + "INNER JOIN TIP_VEHICULO TP ON VH.CTVEHICULO_COD = TP.CTVEHICULO_COD\n"
                + "INNER JOIN DETALLE_CAL_COMBUSTIBLE DTC ON VH.CVEHICULO_COD=DTC.CVEHICULO_COD\n"
                + "INNER JOIN PROC_CALC_COMBUSTIBLE PCC ON PCC.CALCCOMBUSTIBLE_COD = DTC.CALCCOMBUSTIBLE_COD\n"
                + "INNER JOIN EMERGENCIAS EMG ON EMG.CEMERGENCIA_COD = PCC.CEMERGENCIA_COD\n"
                + "INNER JOIN UNIDAD_MEDIDA UM ON UM.CUNIMEDIDAD_COD = PCC.CUNIDADES_CODUNIDAD";

        if (cn != null) {
            try {
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    listvehiculo = new ListAllVehiculosProc();
                    listvehiculo.setVOLUMEN(rs.getString("DVOLUMEN"));
                    listvehiculo.setPLACA(rs.getString("VPLACA"));
                    listvehiculo.setCOMBUSTIBLE(rs.getString("COMBUSTIBLE"));
                    listvehiculo.setVEHICULO(rs.getString("VEHICULOS"));
                    listvehiculo.setSUB_TOTALCOMBUSTIBLE(rs.getString("SUBTOTAL_COMBUSTIBLE"));
                    listvehiculo.setUNIDAD(rs.getString("UNIDAD"));
                    listvehiculo.setEMERGENCIA(rs.getString("EMERGENCIA"));

                    listDonan.add(listvehiculo);
                }
            } catch (SQLException e) {
                System.out.println("Error al listar procesos: " + e.getMessage());
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
        return listDonan;
    }

    @Override
    public String procDonaciones(ProceVehiculos proceVehiculos) {
        cn = conn.getConnection();
        sql = "{CALL SP_PROC_VEHICULOS (?,?,?,?)}";
        if (cn != null) {
            try {
                cs = cn.prepareCall(sql);
                cs.setString(1, proceVehiculos.getCOD_EMERGENCIA());
                cs.setString(2, proceVehiculos.getCOD_TIPO_VEHICULO());
                cs.setString(3, proceVehiculos.getCOD_UNIDAD());
                cs.registerOutParameter(4, Types.VARCHAR);
                cs.executeUpdate();
                System.out.println("termina proc: " + cs.getString(5));
                cs.executeUpdate();
                result = cs.getString(5);
            } catch (SQLException e) {
                System.out.println("Error al procesar Vehiculos: " + e.getMessage());
                result = null;
            }
        }
        return result;
    }

}
