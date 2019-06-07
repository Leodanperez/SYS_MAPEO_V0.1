/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Models.Modulos;
import Models.Usuarios;
import java.util.List;

/**
 *
 * @author IVAN
 */
public interface LoginDao {
    
    //public abstract Usuarios autenticacion(String user, String password);
    
    public List<Modulos> getListModulosSuper(String user);
    
    public List<Modulos> getListSubModulos();
            
}
