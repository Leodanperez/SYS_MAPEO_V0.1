package Dao.Impl;

import Models.ProcesoCalMaquinaria;
import java.sql.Connection;
import java.util.ArrayList;
import Dao.ProcesoCalMaquinariaDao;
import java.sql.CallableStatement;

/**
 *
 * @author IVAN
 */
public class ProcesoCalMaquinariaDaoImpl  implements ProcesoCalMaquinariaDao{
    
    private DbConnection  conn;
    private Connection cn;
    private String sql;
    private CallableStatement objCallableStatemnt;
    
    @Override
    public ArrayList<ProcesoCalMaquinaria> getSelectEmergencia() {
        
        cn = conn.getConnection();
        sql = "{CALL sp_calcularProcesoCalMaquinaria(?,?,?,?)}";
        
        if(cn != null){
            try{
                
            }catch(Exception e){
                
            }
                 
        }
        return null;
        
    }

    @Override
    public ArrayList<ProcesoCalMaquinaria> getSelectUnidad() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String calcularProceso(ProcesoCalMaquinaria objProcesoCalMaquinaria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
