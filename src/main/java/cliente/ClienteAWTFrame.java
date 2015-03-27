package cliente;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Date;

public class ClienteAWTFrame extends Frame {
    public static final long serialVersionUID = 42L;
    private int ancho;
    private int alto;

    // AWT members
    protected MenuBar menuBar;
    protected Menu menuArchivo;
    protected Menu menuProvincias;
    protected Menu menuPoblaciones;
    protected Menu menuAyuda;

    protected MenuItem menuItemRecuperarAlmacen;
    protected MenuItem menuItemGuardarAlmacen;
    protected MenuItem menuItemSalir;
    protected MenuItem menuItemNuevaProvincia;
    protected MenuItem menuItemBorrarProvincia;
    protected MenuItem menuItemNuevaPoblacion;
    protected MenuItem menuItemBorrarPoblacion;
    protected MenuItem menuItemOrdenarPorNombre;
    protected MenuItem menuItemOrdenarPorHabitantes;
    protected MenuItem menuItemModificarPoblacion;
    protected MenuItem menuItemMoverPoblacion;
    protected MenuItem menuItemAcercaDe;

    protected Panel panelBotones;
    protected Panel panelEstado;
    protected Panel panelElementos;
    protected Panel panelPredicciones;
    protected Panel panelProvincias;
    protected Panel panelPoblaciones;

    protected Button buttonNuevaProvincia;
    protected Button buttonNuevaPoblacion;
    protected Button buttonActualizarPrediccion;

    protected Label labelProvincias;
    protected Label labelPoblaciones;
    protected Label labelPredicciones;
    protected Label labelEventos;

    protected List listProvincias;
    protected List listPoblaciones;
    protected List listPredicciones;

    public ClienteAWTFrame(String titulo, int ancho, int alto) {
        super(titulo);
        this.ancho = ancho;
        this.alto = alto;
        this.initialize();
        this.setupLayout();
    }

    private void initialize() {
        this.menuBar = new MenuBar();
        this.menuArchivo = new Menu("Archivo");
        this.menuProvincias = new Menu("Provincias");
        this.menuPoblaciones = new Menu("Poblaciones");
        this.menuAyuda = new Menu("Ayuda");

        this.menuItemRecuperarAlmacen = new MenuItem("Recuperar almacén");
        this.menuItemGuardarAlmacen = new MenuItem("Guardar almacén");
        this.menuItemSalir = new MenuItem("Salir");
        this.menuItemNuevaProvincia = new MenuItem ("Nueva provincia");
        this.menuItemBorrarProvincia = new MenuItem ("Borrar provincia");
        this.menuItemNuevaPoblacion = new MenuItem ("Nueva población");
        this.menuItemBorrarPoblacion = new MenuItem ("Borrar población");
        this.menuItemOrdenarPorNombre = new MenuItem ("Ordenar por nombre");
        this.menuItemOrdenarPorHabitantes = new MenuItem ("Ordenar por habitantes");
        this.menuItemModificarPoblacion = new MenuItem ("Modificar población");
        this.menuItemMoverPoblacion = new MenuItem ("Mover población");
        this.menuItemAcercaDe = new MenuItem("Acerca de");

        this.panelBotones = new Panel();
        this.panelEstado = new Panel();
        this.panelElementos = new Panel();
        this.panelPredicciones = new Panel();
        this.panelProvincias = new Panel();
        this.panelPoblaciones = new Panel();

        this.buttonActualizarPrediccion = new Button("Actualizar predicción");
        this.buttonNuevaProvincia = new Button("Nueva provincia");
        this.buttonNuevaPoblacion = new Button("Nueva población");

        this.labelProvincias = new Label("Provincias:");
        this.labelPoblaciones = new Label("Poblaciones:");
        this.labelPredicciones = new Label("Predicciones de ");
        this.labelEventos = new Label("Gestor AEMET v1.0 (PAA)");
    }

    private void setupLayout() {
        this.setSize(this.ancho, this.alto);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        this.menuArchivo.add(this.menuItemRecuperarAlmacen);
        this.menuArchivo.add(this.menuItemGuardarAlmacen);
        this.menuArchivo.addSeparator();
        this.menuArchivo.add(this.menuItemSalir);
        this.menuProvincias.add(this.menuItemNuevaProvincia);
        this.menuProvincias.add(this.menuItemBorrarProvincia);
        this.menuPoblaciones.add(this.menuItemNuevaPoblacion);
        this.menuPoblaciones.add(this.menuItemBorrarPoblacion);
        this.menuPoblaciones.add(this.menuItemOrdenarPorNombre);
        this.menuPoblaciones.add(this.menuItemOrdenarPorHabitantes);
        this.menuPoblaciones.addSeparator();
        this.menuPoblaciones.add(this.menuItemModificarPoblacion);
        this.menuPoblaciones.add(this.menuItemMoverPoblacion);
        this.menuAyuda.add(this.menuItemAcercaDe);

        this.menuBar.add(this.menuArchivo);
        this.menuBar.add(this.menuProvincias);
        this.menuBar.add(this.menuPoblaciones);
        this.menuBar.setHelpMenu(this.menuAyuda);
        this.setMenuBar(this.menuBar);

        this.panelBotones.setLayout (new FlowLayout(FlowLayout.LEFT));
        this.panelBotones.setBackground(Color.lightGray);
        this.panelBotones.add(this.buttonActualizarPrediccion);
        this.panelBotones.add(this.buttonNuevaProvincia);
        this.panelBotones.add(this.buttonNuevaPoblacion);
        this.add(this.panelBotones, BorderLayout.NORTH);

        this.panelEstado.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.panelEstado.setBackground(Color.lightGray);
        this.panelEstado.add(this.labelEventos);
        this.add(this.panelEstado, BorderLayout.SOUTH);

        this.panelElementos.setLayout(new BorderLayout());

        this.panelProvincias.add(this.labelProvincias);
        this.panelElementos.add(this.panelProvincias, BorderLayout.NORTH);

        this.panelPoblaciones.add(this.labelPoblaciones);
        this.panelElementos.add(this.panelPoblaciones, BorderLayout.SOUTH);

        this.add(this.panelElementos, BorderLayout.WEST);

        this.panelPredicciones.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.panelPredicciones.add(this.labelPredicciones);
        this.add(this.panelPredicciones, BorderLayout.CENTER);

        this.panelEstado.add(this.labelEventos);
        this.add(this.panelEstado, BorderLayout.SOUTH);
    }
}
