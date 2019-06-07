
package Models;

/**
 *
 * @author LEO
 */
public class Emergencias {
    private String CEMERGENCIA_COD;
    private String VDESCRIPCION;

    public Emergencias() {
    }

    public String getCEMERGENCIA_COD() {
        return CEMERGENCIA_COD;
    }

    public String getVDESCRIPCION() {
        return VDESCRIPCION;
    }

    public void setCEMERGENCIA_COD(String CEMERGENCIA_COD) {
        this.CEMERGENCIA_COD = CEMERGENCIA_COD;
    }

    public void setVDESCRIPCION(String VDESCRIPCION) {
        this.VDESCRIPCION = VDESCRIPCION;
    }
    
}
