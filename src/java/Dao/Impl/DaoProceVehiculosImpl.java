
package Dao.Impl;

import Dao.DaoProceVehiculos;
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
public class DaoProceVehiculosImpl implements DaoProceVehiculos{
    
    final private DbConnection conn;
    private String sql;
    private Connection cn;
    private PreparedStatement pst;
    private CallableStatement cs;
    private ResultSet rs;
    private ProceVehiculos proceVehiculos;
    private String result;

    public DaoProceVehiculosImpl(DbConnection conn) {
        this.conn = conn;
    }

    @Override
    public List<ProceVehiculos> listDonaciones() {
        List<ProceVehiculos> listDonante = new LinkedList<>();
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
                    proceVehiculos = new ProceVehiculos();
                    proceVehiculos.setCOD_TIPO_VEHICULO(rs.getString("codigo"));
                    proceVehiculos.setCOD_TIPO_VEHICULO(rs.getString("nombre"));
                    proceVehiculos.setCOD_UNIDAD(rs.getString("telefono"));

                    listDonante.add(proceVehiculos);
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
