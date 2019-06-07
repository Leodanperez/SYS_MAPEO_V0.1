
package Models;

/**
 *
 * @author LEO
 */
public class Donante {
    private String CDONANTE_COD;
    private String CTIPODOC_COD;
    private String VNOMBRE;
    private String CTELEFONO;
    private String VEMAIL;
    private String CNRODOC;

    public Donante() {
    }

    public Donante(String CDONANTE_COD) {
        this.CDONANTE_COD = CDONANTE_COD;
    }

    public String getCDONANTE_COD() {
        return CDONANTE_COD;
    }

    public void setCDONANTE_COD(String CDONANTE_COD) {
        this.CDONANTE_COD = CDONANTE_COD;
    }

    public String getCTIPODOC_COD() {
        return CTIPODOC_COD;
    }

    public void setCTIPODOC_COD(String CTIPODOC_COD) {
        this.CTIPODOC_COD = CTIPODOC_COD;
    }

    public String getVNOMBRE() {
        return VNOMBRE;
    }

    public void setVNOMBRE(String VNOMBRE) {
        this.VNOMBRE = VNOMBRE;
    }

    public String getCTELEFONO() {
        return CTELEFONO;
    }

    public void setCTELEFONO(String CTELEFONO) {
        this.CTELEFONO = CTELEFONO;
    }

    public String getVEMAIL() {
        return VEMAIL;
    }

    public void setVEMAIL(String VEMAIL) {
        this.VEMAIL = VEMAIL;
    }

    public String getCNRODOC() {
        return CNRODOC;
    }

    public void setCNRODOC(String CNRODOC) {
        this.CNRODOC = CNRODOC;
    }
    
}
