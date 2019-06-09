package Dao.Impl;

import Dao.DaoVehiculos;
import Models.TipoVehiculo;
import Models.UnidadMedida;
import Models.Vehiculo;
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
public class VehiculosDao implements DaoVehiculos {

    private final DbConnection conn;
    private Connection con;
    private String query;
    private CallableStatement objCallableStatement;
    private PreparedStatement ps;
    private ResultSet rs;
    private TipoVehiculo tipovehiculo;
    private Vehiculo vehiculo;
    private String result;
    private UnidadMedida unidad;

    public VehiculosDao(DbConnection conn) {
        this.conn = conn;
    }

    @Override
    public List<Vehiculo> listVehiculos() {

        List<Vehiculo> lista = new LinkedList<>();
        con = conn.getConnection();
        query = "SELECT V.CVEHICULO_COD AS codigo, V.DPESO_NETO AS peson, V.DVOLUMEN AS volumen, TV.VDESCRIPCION as decr,\n"
                + "V.VPLACA AS placa, V.DPESO_BRUTO as pbruto, V.DCPCIDAD_CARGA as carga, V.CESTADO as estado\n"
                + "FROM VEHICULO V\n"
                + "INNER JOIN TIP_VEHICULO TV ON TV.CTVEHICULO_COD=V.CVEHICULO_COD";

        if (con != null) {
            try {
                ps = con.prepareStatement(query);
                rs = ps.executeQuery();

                while (rs.next()) {
                    vehiculo = new Vehiculo();
                    vehiculo.setCVEHICULO_COD(rs.getString("codigo"));
                    vehiculo.setDPESO_NETO(rs.getInt("peson"));
                    vehiculo.setDVOLUMEN(rs.getInt("volumen"));
                    vehiculo.setCTVEHICULO_COD(rs.getString("decr"));
                    vehiculo.setVPLACA(rs.getString("placa"));
                    vehiculo.setDPESO_BRUTO(rs.getInt("pbruto"));
                    vehiculo.setDCPCIDAD_CARGA(rs.getInt("carga"));
                    vehiculo.setCESTADO(rs.getString("estado").charAt(0));

                    lista.add(vehiculo);
                }
            } catch (SQLException e) {
                System.out.println("Error al listar vehiculos" + e.getMessage());
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
    public String insertVehiculo(Vehiculo vehiculo) {
        con = conn.getConnection();
        query = "{call SP_INSERT_VEHICULO(?,?,?,?,?,?,?,?)}";

        if (con != null) {
            try {
                objCallableStatement = con.prepareCall(query);
                objCallableStatement.setInt(1, vehiculo.getDPESO_NETO());
                objCallableStatement.setInt(2, vehiculo.getDVOLUMEN());
                objCallableStatement.setString(3, vehiculo.getCTVEHICULO_COD());
                objCallableStatement.setString(4, vehiculo.getVPLACA());
                objCallableStatement.setString(5, "A");
                objCallableStatement.setInt(6, vehiculo.getDPESO_BRUTO());
                objCallableStatement.setInt(7, vehiculo.getDCPCIDAD_CARGA());
                objCallableStatement.registerOutParameter(8, Types.VARCHAR);
                objCallableStatement.executeUpdate();
                System.out.println("termina proc: " + objCallableStatement.getString(8));
                result = objCallableStatement.getString(8);
            } catch (SQLException e) {
                System.out.println("Error al insertar VehiculosDao: " + e.getMessage());
                result = null;
            }
        }
        return result;
    }

    @Override
    public String updateVehiculo(Vehiculo vehiculo) {
        con = conn.getConnection();
        query = "{call SP_UPDATE_VEHICULO(?,?,?,?,?,?,?,?,?)}";
        if (con != null) {
            try {
                objCallableStatement = con.prepareCall(query);
                objCallableStatement.setString(1, vehiculo.getCVEHICULO_COD());
                objCallableStatement.setInt(2, vehiculo.getDPESO_NETO());
                objCallableStatement.setInt(3, vehiculo.getDVOLUMEN());
                objCallableStatement.setString(4, vehiculo.getCTVEHICULO_COD());
                objCallableStatement.setString(5, vehiculo.getVPLACA());
                objCallableStatement.setString(6, "A");
                objCallableStatement.setInt(7, vehiculo.getDPESO_BRUTO());
                objCallableStatement.setInt(8, vehiculo.getDCPCIDAD_CARGA());
                objCallableStatement.registerOutParameter(9, Types.VARCHAR);
                objCallableStatement.executeUpdate();
                System.out.println("termina proc: " + objCallableStatement.getString(9));
                result = objCallableStatement.getString(9);
            } catch (SQLException e) {
                System.out.println("Error al actualizar vehiculodao: " + e.getMessage());
                result = null;
            }
        }
        return result;
    }

    @Override
    public String deleteVehiculo(String id) {
        con = conn.getConnection();
        query = "{call SP_DELETE_VEHICULO(?,?)}";
        if (con != null) {
            try {
                objCallableStatement = con.prepareCall(query);
                objCallableStatement.setString(1, id);
                objCallableStatement.registerOutParameter(2, Types.VARCHAR);
                objCallableStatement.executeUpdate();
                result = objCallableStatement.getString(2);
            } catch (SQLException e) {
                System.out.println("Error al eliminar vehiculodao: " + e.getMessage());
                result = null;
            }
        }
        return result;
    }

    @Override
    public List<TipoVehiculo> listtVehiculos() {

        List<TipoVehiculo> lista = new LinkedList<>();
        con = conn.getConnection();
        query = "SELECT T.CTVEHICULO_COD AS codigo, T.VDESCRIPCION AS des, T.CANTIDAD AS cantidad, T.CESTADO AS estado\n"
                + "FROM TIP_VEHICULO T";

        if (con != null) {
            try {
                ps = con.prepareStatement(query);
                rs = ps.executeQuery();
                while (rs.next()) {
                    tipovehiculo = new TipoVehiculo();
                    tipovehiculo.setCTVEHICULO_COD(rs.getString("codigo"));
                    tipovehiculo.setVDESCRIPCION(rs.getString("des"));
                    tipovehiculo.setCANTIDAD(rs.getInt("cantidad"));
                    tipovehiculo.setCESTADO(rs.getString("estado").charAt(0));

                    lista.add(tipovehiculo);
                }
            } catch (SQLException e) {
                System.out.println("Error al listar tvehiculo " + e.getMessage());
                return null;
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                        ps.close();
                    }
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexion en TipoVehiculo.listtVehiculos: " + e.getMessage());
                }
            }
        }
        return lista;
    }

    @Override
    public String inserttVehiculo(TipoVehiculo tvehiculo) {
        con = conn.getConnection();
        query = "{call SP_INSERTAR_TVEHICULOS(?,?,?,?)}";

        if (con != null) {
            try {
                objCallableStatement = con.prepareCall(query);
                objCallableStatement.setString(1, tvehiculo.getVDESCRIPCION());
                objCallableStatement.setString(2, "A");
                objCallableStatement.setInt(3, tvehiculo.getCANTIDAD());
                objCallableStatement.registerOutParameter(4, Types.VARCHAR);
                objCallableStatement.executeUpdate();
                System.out.println("termina proc: " + objCallableStatement.getString(4));
                result = objCallableStatement.getString(4);
            } catch (SQLException e) {
                System.out.println("Error al insertar TvehiculosDao: " + e.getMessage());
                result = null;
            }
        }
        return result;
    }

    @Override
    public String updatetVehiculo(TipoVehiculo tvehiculo) {
        con = conn.getConnection();
        query = "{call SP_UPDATE_TVEHICULOS(?,?,?,?,?)}";
        if (con != null) {
            try {
                objCallableStatement = con.prepareCall(query);
                objCallableStatement.setString(1, String.valueOf(tvehiculo.getCTVEHICULO_COD()));
                objCallableStatement.setString(2, tvehiculo.getVDESCRIPCION());
                objCallableStatement.setString(3, String.valueOf(tvehiculo.getCESTADO()));
                objCallableStatement.setInt(4, tvehiculo.getCANTIDAD());
                objCallableStatement.registerOutParameter(5, Types.VARCHAR);
                objCallableStatement.executeUpdate();
                System.out.println("termina proc: " + objCallableStatement.getString(5));
                result = objCallableStatement.getString(5);
            } catch (SQLException e) {
                System.out.println("Error al actualizartvehiculodao: " + e.getMessage());
                result = null;
            }
        }
        return result;
    }

    @Override
    public String deletetVehiculo(String id) {
        con = conn.getConnection();
        query = "{call SP_ELIMINAR_TVEHICULOS(?,?)}";
        if (con != null) {
            try {
                objCallableStatement = con.prepareCall(query);
                objCallableStatement.setString(1, id);
                objCallableStatement.registerOutParameter(2, Types.VARCHAR);
                objCallableStatement.executeUpdate();
                result = objCallableStatement.getString(2);
            } catch (SQLException e) {
                System.out.println("Error al eliminar tvehiculodao: " + e.getMessage());
                result = null;
            }
        }
        return result;
    }

    //COMBO TIPO DE VEHICULOS
    public static ArrayList<TipoVehiculo> listar() {
        try {
            String consulta = "select * from TIP_VEHICULO WHERE CTVEHICULO_COD = CTVEHICULO_COD and CESTADO='A' order by 1 desc";
            Connection conn = new DbConnection().getConnection();
            CallableStatement sentencia = (CallableStatement) conn.prepareCall(consulta);
            ResultSet rs = sentencia.executeQuery();
            ArrayList<TipoVehiculo> lista = new ArrayList<>();
            while (rs.next()) {
                TipoVehiculo tvehiculo = new TipoVehiculo();
                tvehiculo.setCTVEHICULO_COD(rs.getString("CTVEHICULO_COD"));
                tvehiculo.setVDESCRIPCION(rs.getString("VDESCRIPCION"));
                lista.add(tvehiculo);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Error ComboTVehiculos: " + e.getMessage());
        }
        return null;
    }
    
    public static ArrayList<UnidadMedida> listarUnidad() {
        try {
            String consulta = "select * from UNIDAD_MEDIDA WHERE CUNIMEDIDAD_COD = CUNIMEDIDAD_COD and CESTADO='A' order by 1 desc";
            Connection conn = new DbConnection().getConnection();
            CallableStatement sentencia = (CallableStatement) conn.prepareCall(consulta);
            ResultSet rs = sentencia.executeQuery();
            ArrayList<UnidadMedida> list = new ArrayList<>();
            while (rs.next()) {
                UnidadMedida unidad = new UnidadMedida();
                unidad.setCodigo(rs.getString("CUNIMEDIDAD_COD"));
                unidad.setDescripcion(rs.getString("VDESCRIPCION"));
                list.add(unidad);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Error ComboTVehiculos: " + e.getMessage());
        }
        return null;
    }

}
