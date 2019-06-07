package Models;

import java.util.Date;

/**
 *
 * @author IVAN
 */
public class ProcesoCalMaquinaria {
    
    private String CATENEMERG_MAQUINARIA_COD;
    private String CEMERGENCIA_COD;
    private String NCANTIDAD_MAQUINARIA;
    private Date DFECHA_PROC;

    public ProcesoCalMaquinaria() {
    }

    public String getCATENEMERG_MAQUINARIA_COD() {
        return CATENEMERG_MAQUINARIA_COD;
    }

    public void setCATENEMERG_MAQUINARIA_COD(String CATENEMERG_MAQUINARIA_COD) {
        this.CATENEMERG_MAQUINARIA_COD = CATENEMERG_MAQUINARIA_COD;
    }

    public String getCEMERGENCIA_COD() {
        return CEMERGENCIA_COD;
    }

    public void setCEMERGENCIA_COD(String CEMERGENCIA_COD) {
        this.CEMERGENCIA_COD = CEMERGENCIA_COD;
    }

    public String getNCANTIDAD_MAQUINARIA() {
        return NCANTIDAD_MAQUINARIA;
    }

    public void setNCANTIDAD_MAQUINARIA(String NCANTIDAD_MAQUINARIA) {
        this.NCANTIDAD_MAQUINARIA = NCANTIDAD_MAQUINARIA;
    }

    public Date getDFECHA_PROC() {
        return DFECHA_PROC;
    }

    public void setDFECHA_PROC(Date DFECHA_PROC) {
        this.DFECHA_PROC = DFECHA_PROC;
    }
    
    
}
