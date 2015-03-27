package cliente.handlers;

import java.awt.*;
import java.awt.event.*;
import java.util.Set;
import paa.provincias.IAlmacenPoblaciones;
import cliente.frames.ClienteFrame;
import cliente.frames.AvisoFrame;

public class NuevaProvinciaHandler extends NuevaProvinciaFrame {
    public static final long serialVersionUID = 46L;
    private static final String FICHERO = "almacen.dat";
    private IAlmacenPoblaciones almacen;
    private ActionListener buttonCrearListener;
    private ActionListener buttonCancelarListener;

    public NuevaProvinciaHandler(Window f,
            IAlmacenPoblaciones almacen) {
        super(f);
        this.almacen = almacen;
        init();
    }

    public void menuItemAcercaDeHandler(ActionEvent e) {

    }

    public void menuItemNuevaProvinciaHandler(ActionEvent e) {

    }

    private void init() {
        initHandlers();
        bindHandlers();
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
