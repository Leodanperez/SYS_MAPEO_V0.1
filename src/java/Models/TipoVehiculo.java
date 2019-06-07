
package Models;

/**
 *
 * @author LEO
 */
public class TipoVehiculo {
    private String CTVEHICULO_COD;
    private String VDESCRIPCION;
    private char CESTADO;
    private int CANTIDAD;

    public TipoVehiculo() {
    }

    public String getCTVEHICULO_COD() {
        return CTVEHICULO_COD;
    }

    public void setCTVEHICULO_COD(String CTVEHICULO_COD) {
        this.CTVEHICULO_COD = CTVEHICULO_COD;
    }

    public String getVDESCRIPCION() {
        return VDESCRIPCION;
    }

    public void setVDESCRIPCION(String VDESCRIPCION) {
        this.VDESCRIPCION = VDESCRIPCION;
    }

    public char getCESTADO() {
        return CESTADO;
    }

    public void setCESTADO(char CESTADO) {
        this.CESTADO = CESTADO;
    }

    public int getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(int CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }
    
}
