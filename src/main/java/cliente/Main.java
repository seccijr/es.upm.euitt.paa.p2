package cliente;

import paa.provincias.IAlmacenPoblaciones;
import almacen.AlmacenPoblaciones;
import cliente.handlers.ClienteHandler;

public class Main {
    public static void main(String[] args) {
        IAlmacenPoblaciones almacen = new AlmacenPoblaciones();
        ClienteHandler cliente = new ClienteHandler(
                almacen, "TEST_TITULO", 400, 400);
        cliente.setVisible(true);
    }
}
