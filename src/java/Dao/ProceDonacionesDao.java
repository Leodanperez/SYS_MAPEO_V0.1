
package Dao;

import Models.DetalleDonacion;
import Models.ProcesoDonaciones;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LEO
 */
public interface ProceDonacionesDao {
    public List<DetalleDonacion> getSelectEmergencia();
    
    public ArrayList<ProcesoDonaciones> getSelectUnidad();
    
    public String calcularProceso(ProcesoDonaciones objProcesoDonaciones);
}
