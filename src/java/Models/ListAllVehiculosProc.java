
package Models;

/**
 *
 * @author LEO
 */
public class ListAllVehiculosProc {
    private String VOLUMEN;
    private String PLACA;
    private String COMBUSTIBLE;
    private String VEHICULO;
    private String SUB_TOTALCOMBUSTIBLE;
    private String UNIDAD;
    private String EMERGENCIA;

    public ListAllVehiculosProc() {
    }

    public String getCOMBUSTIBLE() {
        return COMBUSTIBLE;
    }

    public String getEMERGENCIA() {
        return EMERGENCIA;
    }

    public String getSUB_TOTALCOMBUSTIBLE() {
        return SUB_TOTALCOMBUSTIBLE;
    }

    public String getUNIDAD() {
        return UNIDAD;
    }

    public String getVEHICULO() {
        return VEHICULO;
    }

    public String getVOLUMEN() {
        return VOLUMEN;
    }

    public void setCOMBUSTIBLE(String COMBUSTIBLE) {
        this.COMBUSTIBLE = COMBUSTIBLE;
    }

    public void setEMERGENCIA(String EMERGENCIA) {
        this.EMERGENCIA = EMERGENCIA;
    }

    public void setSUB_TOTALCOMBUSTIBLE(String SUB_TOTALCOMBUSTIBLE) {
        this.SUB_TOTALCOMBUSTIBLE = SUB_TOTALCOMBUSTIBLE;
    }

    public void setUNIDAD(String UNIDAD) {
        this.UNIDAD = UNIDAD;
    }

    public void setVEHICULO(String VEHICULO) {
        this.VEHICULO = VEHICULO;
    }

    public void setVOLUMEN(String VOLUMEN) {
        this.VOLUMEN = VOLUMEN;
    }

    public String getPLACA() {
        return PLACA;
    }

    public void setPLACA(String PLACA) {
        this.PLACA = PLACA;
    }
    
    
}
