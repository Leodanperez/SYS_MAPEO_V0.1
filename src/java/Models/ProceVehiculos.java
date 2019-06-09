
package Models;

/**
 *
 * @author EDITH GALINDO
 */
public class ProceVehiculos {
    private String COD_TIPO_VEHICULO;
    private String COD_EMERGENCIA;
    private String COD_UNIDAD;

    public ProceVehiculos() {
    }

    public String getCOD_EMERGENCIA() {
        return COD_EMERGENCIA;
    }

    public String getCOD_TIPO_VEHICULO() {
        return COD_TIPO_VEHICULO;
    }

    public String getCOD_UNIDAD() {
        return COD_UNIDAD;
    }

    public void setCOD_EMERGENCIA(String COD_EMERGENCIA) {
        this.COD_EMERGENCIA = COD_EMERGENCIA;
    }

    public void setCOD_TIPO_VEHICULO(String COD_TIPO_VEHICULO) {
        this.COD_TIPO_VEHICULO = COD_TIPO_VEHICULO;
    }

    public void setCOD_UNIDAD(String COD_UNIDAD) {
        this.COD_UNIDAD = COD_UNIDAD;
    }
}
