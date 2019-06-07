
package Dao.Impl;

import Models.DetalleDonacion;
import java.sql.CallableStatement;
import java.sql.Date;
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
public class DetallDonaDao {
    DbConnection conn;

    public DetallDonaDao(DbConnection conn) {
        this.conn = conn;
    }
    
    public List<DetalleDonacion> getAllDetallDonacion() {
        try {
            String consulta = "select * from DETALLE_DONACION where CDETADONA_COD=CDETADONA_COD order by 1 desc";
            PreparedStatement ps = conn.getConnection().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            List<DetalleDonacion> lista = new LinkedList<>();
            DetalleDonacion detalleDonacion;
            
            while(rs.next()){
                detalleDonacion = new DetalleDonacion(rs.getString("CDONA_COD"));
                detalleDonacion.setCDONA_COD(rs.getString("CDETADONA_COD"));
                detalleDonacion.setCPRODUCTO_COD(rs.getString("CPRODUCTO_COD"));
                detalleDonacion.setDPESO(rs.getInt("DPESO"));
                detalleDonacion.setDVOLUMEN(rs.getInt("DVOLUMEN"));
                detalleDonacion.setDFECHA_VENCIMIENTO(rs.getDate("DFECHA_VENCIMIENTO"));
                
                lista.add(detalleDonacion);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Error al listar detalleDonacion " + e.getMessage());
            return null;
        }
        
    }
    
    public boolean inserDetallDonacion(DetalleDonacion donacion){
        try {
            String query = "INSERT INTO DETALLE_DONACION VALUES (?,?,?,?,?)";
            PreparedStatement cs = conn.getConnection().prepareStatement(query);
            //CallableStatement cs = (CallableStatement) conn.getConnection().prepareCall(query);
            cs.setString(1, donacion.getCDONA_COD());
            cs.setString(2, donacion.getCDETADONA_COD());
            cs.setString(3, donacion.getCPRODUCTO_COD());
            cs.setInt(4, donacion.getDPESO());
            cs.setInt(5, donacion.getDVOLUMEN());
            cs.setDate(6, (Date) donacion.getDFECHA_VENCIMIENTO());
            cs.executeQuery();
            
        } catch (SQLException e) {
            System.out.println("Error al insertar: "+e.getMessage());
        }
        return false;
    }
    
    public String updateModuloSuper(DetalleDonacion donacion) {
        try {
            String sql = "{call SP_UPDATE_MODULO_SUPER(?,?,?,?,?,?,?,?)}";
            CallableStatement cs = (CallableStatement) conn.getConnection().prepareCall(sql);
            cs.setString(1, donacion.getCDETADONA_COD());
            cs.setString(2, donacion.getCPRODUCTO_COD());
            cs.setString(3, donacion.getCDONA_COD());
            cs.setDouble(4, donacion.getDPESO());
            cs.setDouble(5, donacion.getDVOLUMEN());
            cs.setDate(6, (Date) donacion.getDFECHA_VENCIMIENTO());
            cs.registerOutParameter(6, Types.VARCHAR);
            cs.executeUpdate();
            //cs.registerOutParameter(6, Types.VARCHAR);
            cs.executeUpdate();
            //System.out.println("Modulos: "+permodulos.getVmodulos_deslar());
            //System.out.println("termina proc: "+cs.getString(6));
            return cs.getString(6);

        } catch (SQLException ex) {
            System.out.println("Error en ModulosDao.updateModuloSuper: " + ex.getMessage());
            return null;
        }
    }
     
     //ELIMINAR REGISTRO A MODO LOGICO
    public boolean eliminaDonacion(int codigo) {
        try {
            String sql = "UPDATE DONACIONES SET CMODULOS_ESTADO='I' WHERE CMODULOS_CODMODULO=?";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error en ModulosDao.eliminaModulo : " + ex.getMessage());
            return false;
        }
    }
}
