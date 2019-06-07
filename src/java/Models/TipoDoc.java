
package Models;

/**
 *
 * @author LEO
 */
public class TipoDoc {
    private String CTIPODOC_COD;
    private String VDESCRIPCION;
    private String CESTADO;

    public TipoDoc() {
    }

    public String getCTIPODOC_COD() {
        return CTIPODOC_COD;
    }

    public void setCTIPODOC_COD(String CTIPODOC_COD) {
        this.CTIPODOC_COD = CTIPODOC_COD;
    }

    public String getVDESCRIPCION() {
        return VDESCRIPCION;
    }

    public void setVDESCRIPCION(String VDESCRIPCION) {
        this.VDESCRIPCION = VDESCRIPCION;
    }

    public String getCESTADO() {
        return CESTADO;
    }

    public void setCESTADO(String CESTADO) {
        this.CESTADO = CESTADO;
    }
    
}
