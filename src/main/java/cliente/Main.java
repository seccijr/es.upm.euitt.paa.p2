package cliente;

import paa.provincias.IAlmacenPoblaciones;
import almacen.AlmacenPoblaciones;

public class Main {
    public static void main(String[] args) {
        IAlmacenPoblaciones almacen = new AlmacenPoblaciones();
        ClienteAWT cliente = new ClienteAWT(almacen, "TEST_TITULO", 400, 400);
        cliente.setVisible(true);
    }
}
