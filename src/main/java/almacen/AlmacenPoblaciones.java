package almacen;

import paa.provincias.IPoblacion;
import paa.provincias.IAlmacenPoblaciones;
import java.io.FileNotFoundException;
import java.util.Set;
import java.util.SortedSet;
import java.util.HashMap;
import java.io.*;

public class AlmacenPoblaciones implements IAlmacenPoblaciones {
    private HashMap<String, SortedSet<IPoblacion>> almacenPoblaciones = null;

    /**
     * Class constructor for AlmacenPoblaciones
     *
     * @return      an instance of AlmacenPoblaciones
     */
    public AlmacenPoblaciones() {
        this.almacenPoblaciones = new HashMap<String, SortedSet<IPoblacion>>();
    }

    /**
     * Class constructor for AlmacenPoblaciones
     *
     * @param almacenPoblaciones    Hashmap<String, SortedSet<IPoblacion>>
     *                              with the prefilled almacen
     * @return                      an instance of AlmacenPoblaciones
     */
    public AlmacenPoblaciones(HashMap<String, SortedSet<IPoblacion>> almacenPoblaciones) {
        this.almacenPoblaciones = almacenPoblaciones;
    }

    /**
     * Método auxiliar para añadir provincias al almacen
     * de provincias instanciado
     *
     * @param provincia String con el nombre de la provincia
     * @return          Boolean que verifica si se ha añadido
     *                  correctamente la provincia
     */
    public boolean addProvincia(String provincia) {
        if (!almacenPoblaciones.containsKey(provincia)) {
            almacenPoblaciones.put(provincia, new PoblacionSet());
            return true;
        }

        return false;
    }

    /**
     * Método auxiliar para una población al la provincia
     * especificada como primer parámetro
     *
     * @param provincia String con el nombre de la provincia
     * @param poblacion IPoblacion la instancia de la población
     a añadir
     * @return          Boolean que verifica si se ha añadido
     *                  correctamente la población al contenedor
     */
    public boolean addPoblacion(String provincia, IPoblacion poblacion) {
        if (this.almacenPoblaciones.containsKey(provincia)) {
            PoblacionSet poblaciones = (PoblacionSet)this.almacenPoblaciones.get(provincia);
            poblaciones.add(poblacion);
            this.almacenPoblaciones.put(provincia, poblaciones);

            return true;
        }

        return false;
    }

    /**
     * Método auxiliar para detectar si una provincia existe
     * dentro del almacen
     *
     * @param provincia String con el nombre de la provincia
     * @return          Boolean que verifica si existe la
     *                  provincia
     */
    public boolean containsProvincia(String provincia) {
        return this.almacenPoblaciones.containsKey(provincia);
    }

    /**
     * Método auxiliar para detectar si una poblacion existe
     * dentro del almacen para una provincia dada
     *
     * @param provincia String con el nombre de la provincia
     * @param poblacion String con el nombre de la población
     * @return          Boolean que verifica si existe la
     *                  población dentro de la provincia
     */
    public boolean containsPoblacion(String provincia, String nombre) {
        if (this.almacenPoblaciones.containsKey(provincia)) {
            PoblacionSet poblaciones = (PoblacionSet)this.almacenPoblaciones.get(provincia);

            return poblaciones.contains(new Poblacion(nombre));
        }

        return false;
    }

    /**
     * Método auxiliar para detectar si una poblacion existe
     * dentro del almacen para una provincia dada
     *
     * @param provincia String con el nombre de la provincia
     * @param poblacion IPoblacion con la instancia de la población
     * @return          Boolean que verifica si existe la
     *                  población dentro de la provincia
     */
    public boolean containsPoblacion(String provincia, IPoblacion poblacion) {
        if (this.almacenPoblaciones.containsKey(provincia)) {
            PoblacionSet poblaciones = (PoblacionSet)this.almacenPoblaciones.get(provincia);

            return poblaciones.contains(poblacion);
        }

        return false;
    }

    /**
     * Método auxiliar para borrar si una provincia
     * dentro del almacen
     *
     * @param provincia String con el nombre de la provincia
     * @return          Boolean que verifica si se ha borrado
     *                  la provincia
     */
    public boolean delProvincia(String provincia) {
        if (this.almacenPoblaciones.containsKey(provincia)) {
            SortedSet<IPoblacion> result = this.almacenPoblaciones.remove(provincia);

            return result != null;
        }

        return false;
    }

    /**
     * Método auxiliar para borrar si una población de una
     * provincia existe dentro del almacen
     *
     * @param provincia String con el nombre de la provincia
     * @param poblacion int con el índice de la población
     *                  dentro de la provincia
     * @return          Boolean que verifica si se ha borrado
     *                  la provincia
     */
    public boolean delPoblacion(String provincia, int posicion) {
        if (this.almacenPoblaciones.containsKey(provincia)) {
            PoblacionSet poblaciones = (PoblacionSet)this.almacenPoblaciones.get(provincia);
            IPoblacion poblacion = poblaciones.find(posicion);
            boolean result = poblaciones.remove(poblacion);
            this.almacenPoblaciones.put(provincia, poblaciones);

            return result;
        }

        return false;
    }

    /**
     * Método auxiliar para borrar si una población de una
     * provincia existe dentro del almacen
     *
     * @param provincia String con el nombre de la provincia
     * @param poblacion String con el nombre de la población
     *                  dentro de la provincia
     * @return          Boolean que verifica si se ha borrado
     *                  la provincia
     */
    public boolean delPoblacion(String provincia, String nombre) {
        if (this.almacenPoblaciones.containsKey(provincia)) {
            PoblacionSet poblaciones = (PoblacionSet)this.almacenPoblaciones.get(provincia);
            IPoblacion poblacion = poblaciones.find(nombre);
            boolean result = poblaciones.remove(poblacion);
            this.almacenPoblaciones.put(provincia, poblaciones);

            return result;
        }

        return false;
    }

    /**
     * Método auxiliar para borrar si una población de una
     * provincia existe dentro del almacen
     *
     * @param provincia String con el nombre de la provincia
     * @param poblacion IPoblacion con la población
     *                  dentro de la provincia
     * @return          Boolean que verifica si se ha borrado
     *                  la provincia
     */
    public boolean delPoblacion(String provincia, IPoblacion poblacion) {
        if (this.almacenPoblaciones.containsKey(provincia)) {
            PoblacionSet poblaciones = (PoblacionSet)this.almacenPoblaciones.get(provincia);
            boolean result = poblaciones.remove(poblacion);
            this.almacenPoblaciones.put(provincia, poblaciones);

            return result;
        }

        return false;
    }

    /**
     * Método para extraer todas la provincias del almacén
     *
     * @return          Todas las provincias del
     *                  almacén en un Set
     */
    public Set<String> getProvincias() {
        if (this.almacenPoblaciones != null) {
            return this.almacenPoblaciones.keySet();
        }

        return null;
    }

    /**
     * Método auxiliar para extraer una población de una
     * provincia
     *
     * @param provincia String con el nombre de la provincia
     * @param poblacion int con el índice de la población
     *                  dentro de la provincia
     * @return          IPoblacion con la población
     */
    public IPoblacion getPoblacion(String provincia, int posicion) {
        IPoblacion p = null;
        if (this.almacenPoblaciones.containsKey(provincia)) {
            PoblacionSet poblaciones = (PoblacionSet)this.almacenPoblaciones.get(provincia);
            p = poblaciones.find(posicion);
        }

        return p;
    }

    /**
     * Método auxiliar para extraer una población de una
     * provincia
     *
     * @param provincia String con el nombre de la provincia
     * @param poblacion String con el nombre de la población
     *                  dentro de la provincia
     * @return          IPoblacion con la población
     */
    public IPoblacion getPoblacion(String provincia, String nombre) {
        IPoblacion p = null;
        if (this.almacenPoblaciones.containsKey(provincia)) {
            PoblacionSet poblaciones = (PoblacionSet)this.almacenPoblaciones.get(provincia);
            p = poblaciones.find(nombre);
        }

        return p;
    }

    /**
     * Método ue extrae todas las poblaciones para una provincia
     *
     * @param provincia String con el nombre de la provincia
     * @return          IPoblacion con la población
     */
    public SortedSet<IPoblacion> getPoblaciones(String provincia) {
        PoblacionSet poblaciones = null;
        if (this.almacenPoblaciones.containsKey(provincia)) {
            poblaciones = (PoblacionSet)this.almacenPoblaciones.get(provincia);
        }

        return poblaciones;
    }

    /**
     * Método que extrae el número de poblaciones para una
     * provincia dada
     *
     * @param provincia String con el nombre de la provincia
     * @return          int con el número de poblaciones
     */
    public int getNumPoblaciones(String provincia) {
        int result = Integer.MIN_VALUE;
        if (this.almacenPoblaciones.containsKey(provincia)) {
            result = this.almacenPoblaciones.get(provincia).size();
        }

        return result;
    }

    /**
     * Método que ordena un conjunto de poblaciones según
     * un criterio definido poe la libreria paa.provincias
     *
     * @param provincia String con el nombre de la provincia
     * @param ordenarPor int con el parámetro de ordenación
     * @return          boolean que refleja si la operación
     *                  se ha llevado a cabo con éxito
     */
    public boolean ordenarPor(String provincia, int ordenarPor) {
        if (this.almacenPoblaciones.containsKey(provincia)) {
            SortedSet<IPoblacion> poblaciones = this.almacenPoblaciones.get(provincia);
            SortedSet<IPoblacion> ordenado;
            if (ordenarPor == IAlmacenPoblaciones.ORDENARPORNOMBRE) {
                ordenado = new PoblacionSet();
                ordenado.addAll(poblaciones);
                almacenPoblaciones.put(provincia, ordenado);

                return true;
            }
            if (ordenarPor == IAlmacenPoblaciones.ORDENARPORHABITANTES) {
                ordenado = new PoblacionSet(new NumeroHabitantesComparator());
                ordenado.addAll(poblaciones);
                almacenPoblaciones.put(provincia, ordenado);

                return true;
            }
        }

        return false;
    }

    /**
     * Método que guardar el almacen en un fichero
     *
     * @param nombreFichero String con el nombre del fichero
     * @return          boolean que refleja si la operación
     *                  se ha llevado a cabo con éxito
     */
    public boolean guardar(String nombreFichero) {
        try {
            FileOutputStream fileOut = new FileOutputStream(nombreFichero);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.almacenPoblaciones);
            out.close();
            fileOut.close();

            return true;
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Método que recuperar el almacen desde un fichero
     *
     * @param nombreFichero String con el nombre del fichero
     * @return          boolean que refleja si la operación
     *                  se ha llevado a cabo con éxito
     */
    @SuppressWarnings("unchecked")
    public boolean recuperar(String nombreFichero) {
        try {
            FileInputStream fileIn = new FileInputStream(nombreFichero);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.almacenPoblaciones = (HashMap<String, SortedSet<IPoblacion>>) in.readObject();
            in.close();
            fileIn.close();

            return true;
        }
        catch (FileNotFoundException e) {
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }
}
