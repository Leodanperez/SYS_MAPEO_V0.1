package Dao;

import Models.ProcesoCalMaquinaria;
import java.util.ArrayList;

/**
 *
 * @author IVAN
 */
public interface ProcesoCalMaquinariaDao {
    
    public ArrayList<ProcesoCalMaquinaria> getSelectEmergencia();
    
    public ArrayList<ProcesoCalMaquinaria> getSelectUnidad();
    
    public String   calcularProceso(ProcesoCalMaquinaria objProcesoCalMaquinaria);
}
