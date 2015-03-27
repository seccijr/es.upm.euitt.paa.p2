package cliente.frames;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Date;

public class ClienteFrame extends Frame {
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

    public ClienteFrame(String titulo, int ancho, int alto) {
        super(titulo);
        this.ancho = ancho;
        this.alto = alto;
        initialize();
        setupLayout();
    }

    private void initialize() {
        menuBar = new MenuBar();
        menuArchivo = new Menu("Archivo");
        menuProvincias = new Menu("Provincias");
        menuPoblaciones = new Menu("Poblaciones");
        menuAyuda = new Menu("Ayuda");

        menuItemRecuperarAlmacen = new MenuItem(
                "Recuperar almacén");
        menuItemGuardarAlmacen = new MenuItem("Guardar almacén");
        menuItemSalir = new MenuItem("Salir");
        menuItemNuevaProvincia = new MenuItem("Nueva provincia");
        menuItemBorrarProvincia = new MenuItem("Borrar provincia");
        menuItemNuevaPoblacion = new MenuItem("Nueva población");
        menuItemBorrarPoblacion = new MenuItem("Borrar población");
        menuItemOrdenarPorNombre = new MenuItem(
                "Ordenar por nombre");
        menuItemOrdenarPorHabitantes = new MenuItem(
                "Ordenar por habitantes");
        menuItemModificarPoblacion = new MenuItem(
                "Modificar población");
        menuItemMoverPoblacion = new MenuItem("Mover población");
        menuItemAcercaDe = new MenuItem("Acerca de");

        panelBotones = new Panel();
        panelEstado = new Panel();
        panelElementos = new Panel();
        panelPredicciones = new Panel();
        panelProvincias = new Panel();
        panelPoblaciones = new Panel();

        buttonActualizarPrediccion = new Button(
                "Actualizar predicción");
        buttonNuevaProvincia = new Button("Nueva provincia");
        buttonNuevaPoblacion = new Button("Nueva población");

        labelProvincias = new Label("Provincias:");
        labelPoblaciones = new Label("Poblaciones:");
        labelPredicciones = new Label("Predicciones de ");
        labelEventos = new Label("Gestor AEMET v1.0 (PAA)");
    }

    private void setupLayout() {
        setSize(ancho, alto);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        menuArchivo.add(menuItemRecuperarAlmacen);
        menuArchivo.add(menuItemGuardarAlmacen);
        menuArchivo.addSeparator();
        menuArchivo.add(menuItemSalir);
        menuProvincias.add(menuItemNuevaProvincia);
        menuProvincias.add(menuItemBorrarProvincia);
        menuPoblaciones.add(menuItemNuevaPoblacion);
        menuPoblaciones.add(menuItemBorrarPoblacion);
        menuPoblaciones.add(menuItemOrdenarPorNombre);
        menuPoblaciones.add(menuItemOrdenarPorHabitantes);
        menuPoblaciones.addSeparator();
        menuPoblaciones.add(menuItemModificarPoblacion);
        menuPoblaciones.add(menuItemMoverPoblacion);
        menuAyuda.add(menuItemAcercaDe);

        menuBar.add(menuArchivo);
        menuBar.add(menuProvincias);
        menuBar.add(menuPoblaciones);
        menuBar.setHelpMenu(menuAyuda);
        setMenuBar(menuBar);

        panelBotones.setLayout (new FlowLayout(FlowLayout.LEFT));
        panelBotones.setBackground(Color.lightGray);
        panelBotones.add(buttonActualizarPrediccion);
        panelBotones.add(buttonNuevaProvincia);
        panelBotones.add(buttonNuevaPoblacion);
        add(panelBotones, BorderLayout.NORTH);

        panelEstado.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelEstado.setBackground(Color.lightGray);
        panelEstado.add(labelEventos);
        add(panelEstado, BorderLayout.SOUTH);

        panelElementos.setLayout(new BorderLayout());

        panelProvincias.add(labelProvincias);
        panelElementos.add(panelProvincias, BorderLayout.NORTH);

        panelPoblaciones.add(labelPoblaciones);
        panelElementos.add(panelPoblaciones, BorderLayout.SOUTH);

        add(panelElementos, BorderLayout.WEST);

        panelPredicciones.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelPredicciones.add(labelPredicciones);
        add(panelPredicciones, BorderLayout.CENTER);

        panelEstado.add(labelEventos);
        add(panelEstado, BorderLayout.SOUTH);
    }
}
