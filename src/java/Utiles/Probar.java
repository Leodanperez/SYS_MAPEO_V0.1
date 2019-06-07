/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

import Dao.Impl.DbConnection;
import Dao.Impl.LoginDaoImpl;
import Dao.Impl.ModulosDaoImpl;
import Dao.Impl.UsuariosDaoImpl;
import Dao.LoginDao;
import Dao.UsuariosDao;
import Models.Modulos;
import Models.Persona;
import Models.Usuarios;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author IVAN
 */
public class Probar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String valor = "123456789";
        DbConnection conn = new DbConnection();
        UsuariosDao users = new UsuariosDaoImpl(conn);
        List<Object[]> lista = new LinkedList<>();
        lista = users.getPerfilesSelect();
        
      for (Object[] reg: lista) {
            System.out.println(reg[1]);
        }        
    }
    
}
