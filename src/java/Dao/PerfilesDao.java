/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Models.Perfiles;
import java.util.List;

/**
 *
 * @author IVAN
 */
public interface PerfilesDao {
    
    public List<Perfiles> listPerfiles();
    
    public String insertPerfiles(Perfiles objPerfiles);
    
    public String updatePerfiles(Perfiles objPerfiles);
    
    public String deletePerfiles(String codPerfil);
    
    public List<Perfiles> searchPerfiles( String valorBusqueda);
    
    public Perfiles datosPerfiles(String codPerfil);
    
    public List<Perfiles> listPerfilesModulos(String codPerfil);
    
    public List<Object[]> getModulosSelect();
    
    public boolean insertPerfilesModulos(String codPerfil, String codModulo);
    
    public boolean deletePerfilesModulos(String codPerfil, String codModulo);
    
}
