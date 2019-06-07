
package Dao;

import Models.Donaciones;
import java.util.List;

/**
 *
 * @author LEO
 */
public interface DaoDonaciones {
    public List<Donaciones> listDonaciones();
    public String insertDonaciones(Donaciones donaciones);
    public String updateDonaciones(Donaciones donaciones);
    public String deleteDonaciones(String id);
}
