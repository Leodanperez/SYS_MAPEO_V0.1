
package Models;

/**
 *
 * @author LEO
 */
public class Vehiculo {
    private String CVEHICULO_COD;
    private int DPESO_NETO;
    private int DVOLUMEN;
    private String CTVEHICULO_COD;
    private String VPLACA;
    private char CESTADO;
    private int DPESO_BRUTO;
    private int DCPCIDAD_CARGA;

    public Vehiculo() {
    }

    public String getCVEHICULO_COD() {
        return CVEHICULO_COD;
    }

    public void setCVEHICULO_COD(String CVEHICULO_COD) {
        this.CVEHICULO_COD = CVEHICULO_COD;
    }

    public int getDPESO_NETO() {
        return DPESO_NETO;
    }

    public void setDPESO_NETO(int DPESO_NETO) {
        this.DPESO_NETO = DPESO_NETO;
    }

    public int getDVOLUMEN() {
        return DVOLUMEN;
    }

    public void setDVOLUMEN(int DVOLUMEN) {
        this.DVOLUMEN = DVOLUMEN;
    }

    public String getCTVEHICULO_COD() {
        return CTVEHICULO_COD;
    }

    public void setCTVEHICULO_COD(String CTVEHICULO_COD) {
        this.CTVEHICULO_COD = CTVEHICULO_COD;
    }

    public String getVPLACA() {
        return VPLACA;
    }

    public void setVPLACA(String VPLACA) {
        this.VPLACA = VPLACA;
    }

    public char getCESTADO() {
        return CESTADO;
    }

    public void setCESTADO(char CESTADO) {
        this.CESTADO = CESTADO;
    }

    public int getDPESO_BRUTO() {
        return DPESO_BRUTO;
    }

    public void setDPESO_BRUTO(int DPESO_BRUTO) {
        this.DPESO_BRUTO = DPESO_BRUTO;
    }

    public int getDCPCIDAD_CARGA() {
        return DCPCIDAD_CARGA;
    }

    public void setDCPCIDAD_CARGA(int DCPCIDAD_CARGA) {
        this.DCPCIDAD_CARGA = DCPCIDAD_CARGA;
    }
    
}
