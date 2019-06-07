package Models;

/**
 *
 * @author CARTOLIN
 */
public class Roles {

    private char Croles_Cod;
    private String Vroles_Descripcion;
    private String Croles_Estado;

    public Roles() {

    }

    public char getCroles_Cod() {
        return Croles_Cod;
    }

    public void setCroles_Cod(char Croles_Cod) {
        this.Croles_Cod = Croles_Cod;
    }

    public String getVroles_Descripcion() {
        return Vroles_Descripcion;
    }

    public void setVroles_Descripcion(String Vroles_Descripcion) {
        this.Vroles_Descripcion = Vroles_Descripcion;
    }

    public String getCroles_Estado() {
        return Croles_Estado;
    }

    public void setCroles_Estado(String Croles_Estado) {
        this.Croles_Estado = Croles_Estado;
    }

}
