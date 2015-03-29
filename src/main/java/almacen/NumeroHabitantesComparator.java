package almacen;

import java.io.Serializable;
import java.util.Comparator;
import paa.provincias.IPoblacion;

public class NumeroHabitantesComparator implements Comparator<IPoblacion>, Serializable {
    public static final long serialVersionUID = 50L;

    /**
     * Método auxiliar para detectar si una poblacion existe
     * dentro del almacen para una provincia dada
     *
     * @param p1 IPoblacion población anterior
     * @param p2 IPoblacion población posterios
     * @return int cuyo signo indica cual es mayor
     */
    public int compare(IPoblacion p1, IPoblacion p2) {
        int nHabitantes1 = p1.getHabitantes();
        int nHabitantes2 = p2.getHabitantes();

        return nHabitantes1 - nHabitantes2;
    }
}
