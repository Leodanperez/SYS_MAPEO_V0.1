package Models;

/**
 *
 * @author IVAN
 */
public class Perfiles {
    
    private char Cperfiles_Cod;
    private String Vperfiles_Descripcion;
    private char Cperfiles_Estado;
    private char Cmodulos_Cod;
    private String Vmodulos_desc;
    
    public Perfiles(){
        
    }

    public char getCperfiles_Cod() {
        return Cperfiles_Cod;
    }

    public void setCperfiles_Cod(char Cperfiles_Cod) {
        this.Cperfiles_Cod = Cperfiles_Cod;
    }

    public String getVperfiles_Descripcion() {
        return Vperfiles_Descripcion;
    }

    public void setVperfiles_Descripcion(String Vperfiles_Descripcion) {
        this.Vperfiles_Descripcion = Vperfiles_Descripcion;
    }

    public char getCperfiles_Estado() {
        return Cperfiles_Estado;
    }

    public void setCperfiles_Estado(char Cperfiles_Estado) {
        this.Cperfiles_Estado = Cperfiles_Estado;
    }

    public char getCmodulos_Cod() {
        return Cmodulos_Cod;
    }

    public void setCmodulos_Cod(char Cmodulos_Cod) {
        this.Cmodulos_Cod = Cmodulos_Cod;
    }

    public String getVmodulos_desc() {
        return Vmodulos_desc;
    }

    public void setVmodulos_desc(String Vmodulos_desc) {
        this.Vmodulos_desc = Vmodulos_desc;
    }
    
    
}
