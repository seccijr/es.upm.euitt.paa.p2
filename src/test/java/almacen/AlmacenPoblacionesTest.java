package almacen;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import paa.provincias.IPoblacion;
import paa.provincias.IAlmacenPoblaciones;
import java.util.Set;
import java.util.SortedSet;

public class AlmacenPoblacionesTest {

    @Test
    public void addGetProvinciaPass() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        Set<String> provincias = ap.getProvincias();

        assertThat(provincias, hasItem("TEST_PROVINCIA"));
    }

    @Test
    public void addGetPoblacionNombrePass() {
        IPoblacion p;
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", p = new Poblacion("TEST_POBLACION"));
        IPoblacion pt = ap.getPoblacion("TEST_PROVINCIA", "TEST_POBLACION");

        assertThat(p, equalTo(pt));
    }

    @Test
    public void containsProvinciaPass() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        boolean result = ap.containsProvincia("TEST_PROVINCIA");

        assertThat(result, is(true));
    }

    @Test
    public void containsProvinciaFails() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        boolean result = ap.containsProvincia("TEST_OTRA_PROVINCIA");

        assertThat(result, is(false));
    }

    @Test
    public void containsPoblacionNombrePass() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", new Poblacion("TEST_POBLACION"));
        boolean result = ap.containsPoblacion("TEST_PROVINCIA", "TEST_POBLACION");

        assertThat(result, is(true));
    }

    @Test
    public void containsPoblacionNombreFails() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", new Poblacion("TEST_POBLACION"));
        boolean result = ap.containsPoblacion("TEST_PROVINCIA", "TEST_OTRA_POBLACION");

        assertThat(result, is(false));
    }

    @Test
    public void containsPoblacionInstanciaPass() {
        IPoblacion p;
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", p = new Poblacion("TEST_POBLACION"));
        boolean result = ap.containsPoblacion("TEST_PROVINCIA", p);

        assertThat(result, is(true));
    }

    @Test
    public void containsPoblacionInstanciaFails() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", new Poblacion("TEST_POBLACION"));
        boolean result = ap.containsPoblacion("TEST_PROVINCIA",  new Poblacion("TEST_OTRA_POBLACION"));

        assertThat(result, is(false));
    }

    @Test
    public void delProvinciaPass() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        boolean result = ap.delProvincia("TEST_PROVINCIA");

        assertThat(result, is(true));
    }

    @Test
    public void delProvinciaFails() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        boolean result = ap.delProvincia("TEST_OTRA_PROVINCIA");

        assertThat(result, is(false));
    }

    @Test
    public void delPoblacionIntPass() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", new Poblacion("TEST_POBLACION"));
        boolean result = ap.delPoblacion("TEST_PROVINCIA", 0);

        assertThat(result, is(true));
    }

    @Test
    public void delPoblacionIntFails() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", new Poblacion("TEST_POBLACION"));
        boolean result = ap.delPoblacion("TEST_OTRA_PROVINCIA", 0);

        assertThat(result, is(false));
    }

    @Test
    public void delPoblacionNamePass() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", new Poblacion("TEST_POBLACION"));
        boolean result = ap.delPoblacion("TEST_PROVINCIA", "TEST_POBLACION");

        assertThat(result, is(true));
    }

    @Test
    public void delPoblacionNameFails() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", new Poblacion("TEST_POBLACION"));
        boolean result = ap.delPoblacion("TEST_OTRA_PROVINCIA", "TEST_POBLACION");

        assertThat(result, is(false));
    }

    @Test
    public void delPoblacionInstancePass() {
        IPoblacion p;
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", p = new Poblacion("TEST_POBLACION"));
        boolean result = ap.delPoblacion("TEST_PROVINCIA", p);

        assertThat(result, is(true));
    }

    @Test
    public void delPoblacionInstanceFails() {
        IPoblacion p = new Poblacion("TEST_OTRA_POBLACION");
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", new Poblacion("TEST_POBLACION"));
        boolean result = ap.delPoblacion("TEST_OTRA_PROVINCIA", p);

        assertThat(result, is(false));
    }

    @Test
    public void getPoblacionIntPass() {
        IPoblacion p;
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", p = new Poblacion("TEST_POBLACION"));
        IPoblacion pt = ap.getPoblacion("TEST_PROVINCIA", 0);

        assertThat(p, equalTo(pt));
    }

    @Test
    public void getPoblacionIntFails() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", new Poblacion("TEST_POBLACION"));
        IPoblacion pt = ap.getPoblacion("TEST_PROVINCIA", 1);

        assertThat(pt, nullValue());
    }

    @Test
    public void getPoblacionesPass() {
        IPoblacion p1;
        IPoblacion p2;
        SortedSet<IPoblacion> poblaciones = new PoblacionSet();
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", p1 = new Poblacion("TEST_POBLACION_I"));
        ap.addPoblacion("TEST_PROVINCIA", p2 = new Poblacion("TEST_POBLACION_II"));
        SortedSet<IPoblacion> result = ap.getPoblaciones("TEST_PROVINCIA");
        poblaciones.add(p1);
        poblaciones.add(p2);

        assertThat(result, equalTo(poblaciones));
    }

    @Test
    public void getPoblacionesFails() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", new Poblacion("TEST_POBLACION_I"));
        ap.addPoblacion("TEST_PROVINCIA", new Poblacion("TEST_POBLACION_II"));
        SortedSet<IPoblacion> result = ap.getPoblaciones("TEST_OTRA_PROVINCIA");

        assertThat(result, nullValue());
    }

    @Test
    public void getNumPoblacionesPass() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", new Poblacion("TEST_POBLACION_I"));
        ap.addPoblacion("TEST_PROVINCIA", new Poblacion("TEST_POBLACION_II"));
        int result = ap.getNumPoblaciones("TEST_PROVINCIA");

        assertThat(result, is(2));
    }

    @Test
    public void getNumPoblacionesFails() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", new Poblacion("TEST_POBLACION_I"));
        ap.addPoblacion("TEST_PROVINCIA", new Poblacion("TEST_POBLACION_II"));
        int result = ap.getNumPoblaciones("TEST_OTRA_PROVINCIA");

        assertThat(result, is(Integer.MIN_VALUE));
    }

    @Test
    public void ordenarPorHabitantesPass() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("Madrid");
        ap.addPoblacion("Madrid", new Poblacion("Alpedrete", "Madrid", 12357));
        ap.addPoblacion("Madrid", new Poblacion("Becerril", "Madrid", 5022));
        ap.addPoblacion("Madrid", new Poblacion("Cabrera", "Madrid", 2422));
        boolean result = ap.ordenarPor("Madrid", IAlmacenPoblaciones.ORDENARPORHABITANTES);

        assertThat(result, is(true));
    }

    @Test
    public void ordenarPorHabitantesFails() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("Madrid");
        ap.addPoblacion("Madrid", new Poblacion("Alpedrete", "Madrid", 12357));
        ap.addPoblacion("Madrid", new Poblacion("Becerril", "Madrid", 5022));
        ap.addPoblacion("Madrid", new Poblacion("Cabrera", "Madrid", 2422));
        boolean result = ap.ordenarPor("Barcelona", IAlmacenPoblaciones.ORDENARPORHABITANTES);

        assertThat(result, is(false));
    }

    @Test
    public void ordenarPorHabitantesOrdersMatch() {
        IPoblacion alpedrete;
        IPoblacion becerril;
        IPoblacion cabrera;
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("Madrid");
        ap.addPoblacion("Madrid", alpedrete = new Poblacion("Alpedrete", "Madrid", 12357));
        ap.addPoblacion("Madrid", becerril = new Poblacion("Becerril", "Madrid", 5022));
        ap.addPoblacion("Madrid", cabrera = new Poblacion("Cabrera", "Madrid", 2422));
        boolean result = ap.ordenarPor("Madrid", IAlmacenPoblaciones.ORDENARPORHABITANTES);
        PoblacionSet poblaciones = (PoblacionSet)ap.getPoblaciones("Madrid");
        IPoblacion first = poblaciones.find(0);
        IPoblacion second = poblaciones.find(1);
        IPoblacion third = poblaciones.find(2);


        assertThat(result, is(true));
        assertThat(first, is(cabrera));
        assertThat(second, is(becerril));
        assertThat(third, is(alpedrete));
    }

    @Test
    public void ordenarPorNombrePass() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("Madrid");
        ap.addPoblacion("Madrid", new Poblacion("Alpedrete", "Madrid", 12357));
        ap.addPoblacion("Madrid", new Poblacion("Becerril", "Madrid", 5022));
        ap.addPoblacion("Madrid", new Poblacion("Cabrera", "Madrid", 2422));
        boolean result = ap.ordenarPor("Madrid", IAlmacenPoblaciones.ORDENARPORNOMBRE);

        assertThat(result, is(true));
    }

    @Test
    public void ordenarPorNombreFails() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("Madrid");
        ap.addPoblacion("Madrid", new Poblacion("Alpedrete", "Madrid", 12357));
        ap.addPoblacion("Madrid", new Poblacion("Becerril", "Madrid", 5022));
        ap.addPoblacion("Madrid", new Poblacion("Cabrera", "Madrid", 2422));
        boolean result = ap.ordenarPor("Barcelona", IAlmacenPoblaciones.ORDENARPORNOMBRE);

        assertThat(result, is(false));
    }

    @Test
    public void ordenarPorNombreOrdersMatch() {
        IPoblacion alpedrete;
        IPoblacion becerril;
        IPoblacion cabrera;
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("Madrid");
        ap.addPoblacion("Madrid", alpedrete = new Poblacion("Alpedrete", "Madrid", 12357));
        ap.addPoblacion("Madrid", becerril = new Poblacion("Becerril", "Madrid", 5022));
        ap.addPoblacion("Madrid", cabrera = new Poblacion("Cabrera", "Madrid", 2422));
        boolean result = ap.ordenarPor("Madrid", IAlmacenPoblaciones.ORDENARPORNOMBRE);
        PoblacionSet poblaciones = (PoblacionSet)ap.getPoblaciones("Madrid");
        IPoblacion first = poblaciones.find(0);
        IPoblacion second = poblaciones.find(1);
        IPoblacion third = poblaciones.find(2);


        assertThat(result, is(true));
        assertThat(first, is(alpedrete));
        assertThat(second, is(becerril));
        assertThat(third, is(cabrera));
    }

    @Test
    public void guardarPass() {
        String nombreFichero = "/tmp/almacen.ser";
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("Madrid");
        ap.addPoblacion("Madrid", new Poblacion("Alpedrete", "Madrid", 12357));
        ap.addPoblacion("Madrid", new Poblacion("Becerril", "Madrid", 5022));
        ap.addPoblacion("Madrid", new Poblacion("Cabrera", "Madrid", 2422));
        boolean result = ap.guardar(nombreFichero);

        assertThat(result, is(true));
    }

    @Test
    public void recuperarPass() {
        String nombreFichero = "/tmp/almacen.ser";
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("Madrid");
        ap.addPoblacion("Madrid", new Poblacion("Alpedrete", "Madrid", 12357));
        ap.addPoblacion("Madrid", new Poblacion("Becerril", "Madrid", 5022));
        ap.addPoblacion("Madrid", new Poblacion("Cabrera", "Madrid", 2422));
        boolean rGuardar = ap.guardar(nombreFichero);
        boolean rRecuperar = ap.recuperar(nombreFichero);

        assertThat(rGuardar, is(true));
        assertThat(rRecuperar, is(true));
    }

    @Test
    public void guardarRecuperarMatch() {
        IPoblacion alpedrete, becerril, cabrera;
        String nombreFichero = "/tmp/almacen.ser";
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("Madrid");
        ap.addPoblacion("Madrid", alpedrete = new Poblacion("Alpedrete", "Madrid", 12357));
        ap.addPoblacion("Madrid", becerril = new Poblacion("Becerril", "Madrid", 5022));
        ap.addPoblacion("Madrid", cabrera = new Poblacion("Cabrera", "Madrid", 2422));
        ap.guardar(nombreFichero);
        ap.recuperar(nombreFichero);
        IPoblacion rAlpedrete = ap.getPoblacion("Madrid", "Alpedrete");
        IPoblacion rBecerril = ap.getPoblacion("Madrid", "Becerril");
        IPoblacion rCabrera = ap.getPoblacion("Madrid", "Cabrera");

        assertThat(rAlpedrete.getNombre(), equalTo(alpedrete.getNombre()));
        assertThat(rBecerril.getNombre(), equalTo(becerril.getNombre()));
        assertThat(rCabrera.getNombre(), equalTo(cabrera.getNombre()));
    }
}
