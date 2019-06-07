
package Dao;

import Models.Donante;
import java.util.List;

/**
 *
 * @author LEO
 */
public interface DaoDonante {
    public List<Donante> listDonante();
    public String insertDonante(Donante donante);
    public String updateDonante(Donante donante);
    public String deleteDonante(String id);
    public List<Object[]> getDonanteSeect();
    public List<Object[]> getTipodocSeect();
}
