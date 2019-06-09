
package Dao;

import Models.ProceVehiculos;
import java.util.List;

/**
 *
 * @author EDITH GALINDO
 */
public interface DaoProceVehiculos {
    public List<ProceVehiculos> listDonaciones();
    public String procDonaciones(ProceVehiculos proceVehiculos);
}
