/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Models.Perfiles;
import Models.Persona;
import Models.Usuarios;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IVAN
 */
public interface UsuariosDao {
    
    public List<Usuarios> listUsuarios();
    
    public String insertUsuarios(Usuarios objUsuarios);
    
    public String updateUsuarios(Usuarios objUsuarios);
    
    public String deleteUsuarios(String codUsuario);
    
    public List<Persona> searchPersona(String valorBusqueda);
    
    public Persona datosPersona(String cipPersona);
    
    public List<Persona> searchUsuarios( String valorBusqueda);
    
    public Persona datosUsuario(String cipUsuario);
    
    public List<Usuarios> listUsuariosPerfiles(String cipUsuario);
    
    public List<Object[]> getPerfilesSelect();
    
    public boolean insertUsuariosPerfiles(String codUsuario, String codPerfil);
    
    public boolean deleteUsuariosPerfiles(String codUsuario, String codPerfil);
    
    
}
