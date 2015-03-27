package almacen;

import org.junit.Test;
import static org.junit.Assert.*;
import paa.provincias.IPoblacion;

public class PoblacionTest {

    @Test
    public void setGetNombre() {
        IPoblacion p = new Poblacion();
        String tp = "TEST_POBLACION";
        p.setNombre(tp);
        String result = p.getNombre();

        assertEquals(tp, result);
    }

    @Test
    public void setGetProvincia() {
        IPoblacion p = new Poblacion();
        String tp = "TEST_PROVINCIA";
        p.setProvincia(tp);
        String result = p.getProvincia();

        assertEquals(tp, result);
    }

    @Test
    public void setGetHabitantes() {
        IPoblacion p = new Poblacion();
        int th = 99;
        p.setHabitantes(th);
        int result = p.getHabitantes();

        assertEquals(th, result);
    }
}
