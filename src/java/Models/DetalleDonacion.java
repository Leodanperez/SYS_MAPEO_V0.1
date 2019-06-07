
package Models;

import java.util.Date;

/**
 *
 * @author LEO
 */
public class DetalleDonacion {
    private String CDETADONA_COD;
    private String CPRODUCTO_COD;
    private String TIPOPRODUCTO;
    private int CANTIDAD;

    public String getTIPOPRODUCTO() {
        return TIPOPRODUCTO;
    }

    public int getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(int CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    public void setTIPOPRODUCTO(String TIPOPRODUCTO) {
        this.TIPOPRODUCTO = TIPOPRODUCTO;
    }
    private String CDONA_COD;
    private int ICANTIDAD_PROD;
    private String EDADANTROPOLOGICA;

    public int getICANTIDAD_PROD() {
        return ICANTIDAD_PROD;
    }

    public void setICANTIDAD_PROD(int ICANTIDAD_PROD) {
        this.ICANTIDAD_PROD = ICANTIDAD_PROD;
    }

    public String getEDADANTROPOLOGICA() {
        return EDADANTROPOLOGICA;
    }

    public void setEDADANTROPOLOGICA(String EDADANTROPOLOGICA) {
        this.EDADANTROPOLOGICA = EDADANTROPOLOGICA;
    }
    private int DPESO;
    private int DVOLUMEN;
    private Date DFECHA_VENCIMIENTO;

    public DetalleDonacion() {
    }

    public DetalleDonacion(String CDETADONA_COD) {
        this.CDETADONA_COD = CDETADONA_COD;
    }

    public String getCDETADONA_COD() {
        return CDETADONA_COD;
    }

    public void setCDETADONA_COD(String CDETADONA_COD) {
        this.CDETADONA_COD = CDETADONA_COD;
    }

    public String getCPRODUCTO_COD() {
        return CPRODUCTO_COD;
    }

    public void setCPRODUCTO_COD(String CPRODUCTO_COD) {
        this.CPRODUCTO_COD = CPRODUCTO_COD;
    }

    public String getCDONA_COD() {
        return CDONA_COD;
    }

    public void setCDONA_COD(String CDONA_COD) {
        this.CDONA_COD = CDONA_COD;
    }

    public int getDPESO() {
        return DPESO;
    }

    public void setDPESO(int DPESO) {
        this.DPESO = DPESO;
    }

    public int getDVOLUMEN() {
        return DVOLUMEN;
    }

    public void setDVOLUMEN(int DVOLUMEN) {
        this.DVOLUMEN = DVOLUMEN;
    }

    public Date getDFECHA_VENCIMIENTO() {
        return DFECHA_VENCIMIENTO;
    }

    public void setDFECHA_VENCIMIENTO(Date DFECHA_VENCIMIENTO) {
        this.DFECHA_VENCIMIENTO = DFECHA_VENCIMIENTO;
    }
    
}
