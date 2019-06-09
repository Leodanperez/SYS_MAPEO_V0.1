
package Dao;

import Models.ListAllVehiculosProc;
import Models.ProceVehiculos;
import java.util.List;

/**
 *
 * @author EDITH GALINDO
 */
public interface DaoProceVehiculos {
    public List<ListAllVehiculosProc> listVehiculos();
    public String procDonaciones(ProceVehiculos proceVehiculos);
}
