
package Dao;

import Models.TipoVehiculo;
import Models.Vehiculo;
import java.util.List;

/**
 *
 * @author LEO
 */
public interface DaoVehiculos {
    public List<Vehiculo> listVehiculos();
    public String insertVehiculo(Vehiculo vehiculo);
    public String updateVehiculo(Vehiculo vehiculo);
    public String deleteVehiculo(String id);
    
    public List<TipoVehiculo> listtVehiculos();
    public String inserttVehiculo(TipoVehiculo tvehiculo);
    public String updatetVehiculo(TipoVehiculo tvehiculo);
    public String deletetVehiculo(String id);
}
