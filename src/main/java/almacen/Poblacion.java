package almacen;

import paa.provincias.IPoblacion;
import paa.provincias.IPoblacionAEMET;
import paa.provincias.IPrediccion;

import java.io.Serializable;
import java.util.List;

public class Poblacion implements IPoblacion, IPoblacionAEMET, Comparable<IPoblacion>, Serializable {
    static final long serialVersionUID = -2756440049183558014L;
    private String nombre;
    private String provincia;
    private int habitantes;
    private String codigoAEMET;
    private List<IPrediccion> predicciones;

    /**
     * Constructor
     *
     * @return IPoblacion con la nueva población
     */
    public Poblacion() {}

    /**
     * Constructor con el nombre de la población
     *
     * @param nombre String nombre de la población
     * @return IPoblacion con la nueva población
     */
    public Poblacion(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Constructor con las dos principales propiedades de la
     * clase Población
     *
     * @param nombre String nombre de la población
     * @param provincia String nombre de la provincia
     * @return IPoblacion con la nueva población
     */
    public Poblacion(String nombre, String provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
    }

    /**
     * Constructor con todas las propiedades de la
     * clase Población
     *
     * @param nombre String nombre de la población
     * @param provincia String nombre de la provincia
     * @param habitantes int número de habitantes
     * @return IPoblacion con la nueva población
     */
    public Poblacion(String nombre, String provincia, int habitantes) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.habitantes = habitantes;
    }

    /**
     * Constructor con todas las propiedades de la
     * clase Población
     *
     * @param nombre String nombre de la población
     * @param provincia String nombre de la provincia
     * @param habitantes int número de habitantes
     * @param codigoAEMET String con el codigoAEMET
     * @return IPoblacion con la nueva población
     */
    public Poblacion(String nombre, String provincia, int habitantes, String codigoAEMET) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.habitantes = habitantes;
        this.codigoAEMET = codigoAEMET;
    }

    /**
     * Obtiene el nombre de la población
     *
     * @return String nombre de la población
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Obtiene el nombre de la provincia donde se
     * encuentra la población
     *
     * @return String nombre de la provincia
     */
    public String getProvincia() {
        return this.provincia;
    }

    /**
     * Obtiene el número de invitados de la población
     *
     * @return int número de habitantes
     */
    public int getHabitantes() {
        return this.habitantes;
    }

    /**
     * Establece el nombre de la poblacion
     *
     * @param nombre String nombre de la poblacion
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el nombre de la provincia
     *
     * @param provincia String nombre de la provincia
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * Establece el numero de habitantes de la población
     *
     * @param habitantes int número de habitantes
     */
    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }

    /**
     * Comparación de la población actual con una
     * segunda población
     *
     * @param p1 IPoblacion población a comparar
     * @return int cuyo signo indica cual es mayor
     */
    public int compareTo(IPoblacion p) {
        return this.getNombre().compareTo(p.getNombre());
    }

    /**
     * Getter codigoAEMET
     *
     * @return String del codigoAEMET
     */
    public String getCodigoAEMET() {
        return codigoAEMET;
    }

    /**
     * Setter codigoAEMET
     *
     * @param codigoAEMET
     */
    public void setCodigoAEMET(String codigoAEMET) {
        this.codigoAEMET = codigoAEMET;
    }

    /**
     * Getter predicciones
     *
     * @return List<IPrediccion> del predicciones
     */
    public List<IPrediccion> getPredicciones() {
        return predicciones;
    }

    /**
     * Setter predicciones
     *
     * @param predicciones
     */
    public void setPredicciones(List<IPrediccion> predicciones) {
        this.predicciones = predicciones;
    }
}
