package cliente;

import paa.provincias.IAlmacenPoblaciones;
import almacen.AlmacenPoblaciones;
import cliente.handlers.ClienteHandler;

public class Main {
    public static void main(String[] args) {
        IAlmacenPoblaciones almacen = new AlmacenPoblaciones();
        new ClienteHandler(almacen, "Cliente de AEMET");
    }
}
