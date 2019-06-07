
package Models;

import java.util.Date;

/**
 *
 * @author LEO
 */
public class Donaciones {
    private String CDONA_COD;
    private String VLUG_ORIGEN;
    private Date DDONA_FECHA;
    private String CDONATE_COD;
    private char COD_UNIDAD;
    private int DPESO_TOTAL;
    private int DVOLUMEN_TOTAL;
    private int CPERMILITARES_COD;
    private String VRECEPCION;
    private String VMOVIMIENTO;
    private String VENTRADA;

    public Donaciones() {
    }

    public String getCDONA_COD() {
        return CDONA_COD;
    }

    public void setCDONA_COD(String CDONA_COD) {
        this.CDONA_COD = CDONA_COD;
    }

    public String getVLUG_ORIGEN() {
        return VLUG_ORIGEN;
    }

    public void setVLUG_ORIGEN(String VLUG_ORIGEN) {
        this.VLUG_ORIGEN = VLUG_ORIGEN;
    }

    public Date getDDONA_FECHA() {
        return DDONA_FECHA;
    }

    public void setDDONA_FECHA(Date DDONA_FECHA) {
        this.DDONA_FECHA = DDONA_FECHA;
    }

    public String getCDONATE_COD() {
        return CDONATE_COD;
    }

    public void setCDONATE_COD(String CDONATE_COD) {
        this.CDONATE_COD = CDONATE_COD;
    }

    public char getCOD_UNIDAD() {
        return COD_UNIDAD;
    }

    public void setCOD_UNIDAD(char COD_UNIDAD) {
        this.COD_UNIDAD = COD_UNIDAD;
    }

    public int getDPESO_TOTAL() {
        return DPESO_TOTAL;
    }

    public void setDPESO_TOTAL(int DPESO_TOTAL) {
        this.DPESO_TOTAL = DPESO_TOTAL;
    }

    public int getDVOLUMEN_TOTAL() {
        return DVOLUMEN_TOTAL;
    }

    public void setDVOLUMEN_TOTAL(int DVOLUMEN_TOTAL) {
        this.DVOLUMEN_TOTAL = DVOLUMEN_TOTAL;
    }

    public int getCPERMILITARES_COD() {
        return CPERMILITARES_COD;
    }

    public void setCPERMILITARES_COD(int CPERMILITARES_COD) {
        this.CPERMILITARES_COD = CPERMILITARES_COD;
    }

    public String getVRECEPCION() {
        return VRECEPCION;
    }

    public void setVRECEPCION(String VRECEPCION) {
        this.VRECEPCION = VRECEPCION;
    }

    public String getVMOVIMIENTO() {
        return VMOVIMIENTO;
    }

    public void setVMOVIMIENTO(String VMOVIMIENTO) {
        this.VMOVIMIENTO = VMOVIMIENTO;
    }

    public String getVENTRADA() {
        return VENTRADA;
    }

    public void setVENTRADA(String VENTRADA) {
        this.VENTRADA = VENTRADA;
    }
}
