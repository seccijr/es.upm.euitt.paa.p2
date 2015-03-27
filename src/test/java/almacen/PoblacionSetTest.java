package almacen;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import paa.provincias.IPoblacion;

public class PoblacionSetTest {

    @Test
    public void findByName() {
        IPoblacion fuenlabrada;
        PoblacionSet ps = new PoblacionSet();
        ps.add(fuenlabrada = new Poblacion("Fuenlabrada"));

        IPoblacion result = ps.find("Fuenlabrada");

        assertThat(result, equalTo(fuenlabrada));
    }

    @Test
    public void findByNameFails() {
        IPoblacion fuenlabrada;
        PoblacionSet ps = new PoblacionSet();
        ps.add(fuenlabrada = new Poblacion("Fuenlabrada"));

        IPoblacion result = ps.find("Getafe");

        assertThat(result, not(equalTo(fuenlabrada)));
        assertThat(result, equalTo(null));
    }

    @Test
    public void findById() {
        IPoblacion alcobendas, fuenlabrada, parla;
        PoblacionSet ps = new PoblacionSet();
        ps.add(fuenlabrada = new Poblacion("Fuenlabrada"));
        ps.add(alcobendas = new Poblacion("Alcobendas"));
        ps.add(parla = new Poblacion("Parla"));

        IPoblacion result = ps.find(0);

        assertThat(result, equalTo(alcobendas));
    }

    @Test
    public void findByIdFails() {
        IPoblacion alcobendas, fuenlabrada, parla;
        PoblacionSet ps = new PoblacionSet();
        ps.add(fuenlabrada = new Poblacion("Fuenlabrada"));
        ps.add(alcobendas = new Poblacion("Alcobendas"));
        ps.add(parla = new Poblacion("Parla"));

        IPoblacion result = ps.find(0);

        assertThat(result, not(equalTo(fuenlabrada)));
        assertThat(result, not(equalTo(parla)));
    }
}
