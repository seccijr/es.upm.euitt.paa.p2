package cliente.handlers;

import java.awt.*;
import java.awt.event.*;
import java.util.Set;
import paa.provincias.IAlmacenPoblaciones;
import cliente.frames.ClienteFrame;
import cliente.frames.AvisoFrame;

public class ClienteHandler extends ClienteFrame {
    public static final long serialVersionUID = 43L;
    private static final String FICHERO = "almacen.dat";
    private IAlmacenPoblaciones almacen;
    private ActionListener menuItemNuevaProvinciaListener;
    private ActionListener menuItemAcercaDeListener;

    public ClienteHandler(
            IAlmacenPoblaciones almacen, String titulo,
            int ancho, int alto) {
        super(titulo, ancho, alto);
        this.almacen = almacen;
        init();
    }

    public void crearNuevaProvincia(String provincia) {
        this.almacen.addProvincia(provincia);
        Set<String> provincias = this.almacen.getProvincias();
        this.bindProvincias(provincias);
    }

    public void menuItemAcercaDeHandler(ActionEvent e) {
    }

    public void menuItemNuevaProvinciaHandler(ActionEvent e) {
        new NuevaProvinciaHandler(ClienteHandler.this);
    }

    private void init() {
        initData();
        initHandlers();
        bindHandlers();
    }

    private void initData() {
        boolean recuperado = almacen.recuperar(
                ClienteHandler.FICHERO);
        if (!recuperado) {
            new AvisoFrame(ClienteHandler.this,
                    "No se ha recuperado el fichero de almacen "
                    + "de datos");
        }
    }


    private void initHandlers() {
        menuItemNuevaProvinciaListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuItemNuevaProvinciaHandler(e);
            }
        };

        menuItemAcercaDeListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuItemAcercaDeHandler(e);
            }
        };
    }

    private void bindProvincias(Set<String> provincias) {
        listProvincias.removeAll();
        for(String provincia: provincias) {
            listProvincias.add(provincia);
        }
    }

    private void bindHandlers() {
        menuItemNuevaProvincia.addActionListener(
            menuItemNuevaProvinciaListener);
        menuItemAcercaDe.addActionListener(
            menuItemAcercaDeListener);
        buttonNuevaProvincia.addActionListener(
            menuItemNuevaProvinciaListener);
        addWindowListener(new WindowAdapter () {
            public void windowClosing(WindowEvent e) {
                System.out.println("Gracias por utilizar nuestro programa");
                System.exit(0);
            }
        });

    }
}
