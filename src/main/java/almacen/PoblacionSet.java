package almacen;

import paa.provincias.IPoblacion;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Comparator;

class PoblacionSet extends TreeSet<IPoblacion> implements SortedSet<IPoblacion> {
    static final long serialVersionUID = -2428562859390458285L;

    /**
     * Constructor
     *
     * @return  PoblacionSet con el nuevo
     *          conjunto
     */
    public PoblacionSet() {
        super();
    }

    /**
     * Constructor donde se le establece una nuevo
     * comparador usado a la hora de generar el
     * orden de los elementos del conjunto
     *
     * @param c Comparator nuevo ordenador
     * @return  PoblacionSet con el nuevo
     *          conjunto
     */
    public PoblacionSet(Comparator<IPoblacion> c) {
        super(c);
    }

    /**
     * Método que busca una población dentro del conjunto
     * atendiendo al nombre
     *
     * @param name String nombre de la población
     * @return IPoblacion con la población encontrada
     */
    public IPoblacion find(String name) {
        IPoblacion result = null;
        for(IPoblacion p: this) {
            if (p.getNombre().equals(name)) {
                result = p;
                break;
            }
        }

        return result;
    }

    /**
     * Método que busca una población dentro del conjunto
     * atendiendo a la posición
     *
     * @param index int posición de la población
     * @return IPoblacion con la población encontrada
     */
    public IPoblacion find(int index) {
        IPoblacion p;
        IPoblacion[] pArray = this.toArray(new Poblacion[this.size()]);

        try {
            p = pArray[index];
        }
        catch(ArrayIndexOutOfBoundsException e) {
            p = null;
        }

        return p;
    }
}
