package cliente;

import java.awt.*;
import java.awt.event.*;
import java.util.Set;
import paa.provincias.IAlmacenPoblaciones;

public class ClienteAWT extends ClienteAWTFrame {
    public static final long serialVersionUID = 43L;
    private static final String FICHERO = "almacen.dat";
    private IAlmacenPoblaciones almacen;
    private ActionListener menuItemNuevaProvinciaListener;
    private ActionListener menuItemAcercaDeListener;

    public ClienteAWT (
            IAlmacenPoblaciones almacen, String titulo, int ancho, int alto) {
        super(titulo, ancho, alto);
        this.almacen = almacen;
        this.init();
    }

    public void menuItemAcercaDeHandler(ActionEvent e) {

    }

    public void menuItemNuevaProvinciaHandler(ActionEvent e) {

    }

    private void init() {
        this.initData();
        this.initHandlers();
        this.bindHandlers();
    }

    private void initData() {
        boolean recuperado = this.almacen.recuperar(ClienteAWT.FICHERO);
        if (!recuperado) {

        }
        else {
        }
    }


    private void initHandlers() {
        this.menuItemNuevaProvinciaListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuItemNuevaProvinciaHandler(e);
            }
        };

        this.menuItemAcercaDeListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuItemAcercaDeHandler(e);
            }
        };
    }

    private void bindProvincias(Set<String> provincias) {
        this.listProvincias.removeAll();
        for(String provincia: provincias) {
            this.listProvincias.add(provincia);
        }
    }

    private void bindHandlers() {
        this.menuItemNuevaProvincia.addActionListener(
                this.menuItemNuevaProvinciaListener);
        this.menuItemAcercaDe.addActionListener(
                this.menuItemAcercaDeListener);
        this.buttonNuevaProvincia.addActionListener(
                this.menuItemNuevaProvinciaListener);
        this.addWindowListener(new WindowAdapter () {
            public void windowClosing(WindowEvent e) {
                System.out.println("Gracias por utilizar nuestro programa");
                System.exit(0);
            }
        });

    }
}
