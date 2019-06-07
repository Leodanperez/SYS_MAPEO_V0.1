/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Models.Modulos;
import java.util.List;

/**
 *
 * @author IVAN
 */
public interface ModulosDao {
    
    public List<Modulos> listModulosSuper();
    
    public String insertModulosSuper(Modulos objModulos);
    
    public String updateModulosSuper(Modulos objModulos);
    
    public List<Object[]> getModulosSuperSelect();
    
    public String deleteModulos(String codModulos);
    
    public List<Modulos> listSubModulos();
    
    public String insertSubModulos(Modulos objModulos);
    
    public String updateSubModulos(Modulos objModulos);
    
}
