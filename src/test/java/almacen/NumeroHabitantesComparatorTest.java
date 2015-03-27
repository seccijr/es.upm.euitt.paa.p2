package almacen;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import paa.provincias.IPoblacion;

public class NumeroHabitantesComparatorTest {

    @Test
    public void comparePass() {
        IPoblacion p1 = new Poblacion("TEST_POBLACION_I", "TEST_PROVINCIA", 10);
        IPoblacion p2 = new Poblacion("TEST_POBLACION_II", "TEST_PROVINCIA", 20);
        NumeroHabitantesComparator nc = new NumeroHabitantesComparator();

        int result = nc.compare(p1, p2);

        assertThat(result, lessThan(0));
    }
}
