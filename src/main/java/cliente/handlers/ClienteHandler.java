package cliente.handlers;

import java.awt.event.*;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import almacen.Poblacion;
import cliente.frames.AvisoFrame;
import paa.provincias.*;
import cliente.frames.ClienteFrame;

public class ClienteHandler extends ClienteFrame {
    public static final long serialVersionUID = 43L;
    private static final String FICHERO = "almacen.dat";
    private IAlmacenPoblaciones almacen;
    private ActionListener buttonActualizarListener;
    private ActionListener menuItemGuardarAlmacenListener;
    private ActionListener menuItemRecuperarAlmacenListener;
    private ActionListener menuItemSalirListener;
    private ActionListener menuItemNuevaProvinciaListener;
    private ActionListener menuItemBorrarProvinciaListener;
    private ActionListener menuItemNuevaPoblacionListener;
    private ActionListener menuItemBorrarPoblacionListener;
    private ActionListener menuItemOrdenarPorNombreListener;
    private ActionListener menuItemOrdenarPorHabitantesListener;
    private ActionListener menuItemAcercaDeListener;
    private ItemListener listProvinciasListener;
    private ItemListener listPoblacionesListener;

    private GestorAEMET gestor;

    /**
     * Constructor de la clase ClienteHandler
     *
     * @param almacen IAlmacenPoblacion de las provincias
     * @param titulo String
     * @return ClienteHandler con la ventana
     */
    public ClienteHandler(
            IAlmacenPoblaciones almacen, String titulo) {
        super(titulo);
        this.almacen = almacen;
        gestor = new GestorAEMET();
        initialize();
        setVisible(true);
    }

    /**
     * Método auxiliar cerrar el programa
     *
     * @return void
     */
    public void salir() {
        almacen.guardar(ClienteHandler.FICHERO);
        System.out.println("Gracias por utilizar nuestro programa");
        System.exit(0);
    }

    /**
     * Crea una nueva provincia dentro del almacén de provincias
     *
     * @param provincia String con el nombre de la provincia
     * @return void
     */
    public void crearNuevaProvincia(String provincia) {
        almacen.addProvincia(provincia);
        Set<String> provincias = almacen.getProvincias();
        bindProvincias(provincias);
    }

    /**
     * Crea una nueva población para la provincia sleccionada
     * dentro del almacén de provincias
     *
     * @param nombre String con el nombre de la población
     * @param habitantes int con el número de habitantes
     * @param codigoAEMET distintivo de la provincia
     * @return void
     */
    public void crearNuevaPoblacion(String nombre, int habitantes, String codigoAEMET) {
        String provincia = listProvincias.getSelectedItem();
        if (provincia.isEmpty()) {
            new AvisoFrame(ClienteHandler.this, "Seleccione una provincia porfavor");
        }
        else {
            IPoblacion poblacion = new Poblacion(nombre, provincia, habitantes, codigoAEMET);
            almacen.addPoblacion(provincia, poblacion);
            SortedSet<IPoblacion> poblaciones = almacen.getPoblaciones(provincia);
            bindPoblaciones(poblaciones);
        }
    }

    /**
     * Consulta las predicciones para una poblacion
     *
     * @param poblacionAEMET IPoblacionAEMET con la poblacion
     * @return List<IPrediccion>
     */
    private List<IPrediccion> consultarPrediccion(IPoblacionAEMET poblacionAEMET) {
        List<IPrediccion> predicciones = null;
        try {
            predicciones = gestor.getPredicciones(poblacionAEMET);
        }
        catch (GestorAEMETException e) {
            new AvisoFrame(ClienteHandler.this, e.getMessage());
        }

        return predicciones;
    }

    /**
     * Actualiza las predicciones
     *
     * @return void
     */
    private void actualizarPredicciones() {
        List<IPrediccion> predicciones;
        String provincia = listProvincias.getSelectedItem();
        String nombre = listPoblaciones.getSelectedItem();
        IPoblacion poblacion = almacen.getPoblacion(provincia, nombre);
        predicciones = consultarPrediccion((Poblacion)poblacion);
        bindPredicciones(predicciones, nombre);

    }

    /**
     * Vincula el componente de la lista de provincias con las provincias
     * disponibles en el almacén
     *
     * @return void
     */
    private void bindProvincias() {
        Set<String> provincias = almacen.getProvincias();
        if (!provincias.isEmpty()) {
            bindProvincias(provincias);
        }
    }

    /**
     * Vincula el componente de la lista de provincias con las provincias
     * disponibles en el almacén
     *
     * @param provincias IPoblacionAEMET con la poblacion
     * @return void
     */
    private void bindProvincias(Set<String> provincias) {
        listProvincias.removeAll();
        for(String provincia: provincias) {
            listProvincias.add(provincia);
        }
    }

    /**
     * Vincula el componente de la lista de poblaciones
     * con las poblaciones disponibles para la provincia
     * seleccionada
     *
     * @return void
     */
    private void bindPoblaciones() {
        String provincia = listProvincias.getSelectedItem();
        SortedSet<IPoblacion> poblaciones = almacen.getPoblaciones(provincia);
        bindPoblaciones(poblaciones);
    }

    /**
     * Vincula el componente de la lista de poblaciones
     * con las poblaciones disponibles para la provincia
     * seleccionada
     *
     * @param poblaciones SortedSet<IPoblacion>
     * @return void
     */
    private void bindPoblaciones(SortedSet<IPoblacion> poblaciones) {
        listPoblaciones.removeAll();
        for(IPoblacion poblacion: poblaciones) {
            listPoblaciones.add(poblacion.getNombre());
        }
    }

    /**
     * Vincula el componente de la lista de predicciones
     * con las predicciones disponibles para la población
     * seleccionada
     *
     * @return void
     */
    private void bindPredicciones() {
        List<IPrediccion> predicciones;
        String provincia = listProvincias.getSelectedItem();
        String nombre = listPoblaciones.getSelectedItem();
        IPoblacion poblacion = almacen.getPoblacion(provincia, nombre);
        predicciones = ((Poblacion)poblacion).getPredicciones();
        if (predicciones == null || predicciones.isEmpty()) {
            predicciones = consultarPrediccion((Poblacion)poblacion);
        }

        bindPredicciones(predicciones, nombre);
    }

    /**
     * Vincula el componente de la lista de predicciones
     * con las predicciones disponibles para la población
     * seleccionada
     *
     * @param  predicciones List<IPrediccion> con las predicciones
     * @param  nombre String de la población
     * @return void
     */
    private void bindPredicciones(List<IPrediccion> predicciones, String nombre) {
        if (predicciones != null && !predicciones.isEmpty()) {
            labelPredicciones.setText("Predicciones de " + nombre);
            listPredicciones.removeAll();
            for (IPrediccion prediccion: predicciones) {
                StringBuilder info = new StringBuilder();
                info.append(prediccion.getFecha());
                info.append(", ");
                info.append(prediccion.getTemperaturaMinima());
                info.append("/");
                info.append(prediccion.getTemperaturaMaxima());
                info.append(", ");
                info.append(prediccion.getEstadoCielo());
                listPredicciones.add(info.toString());
            }
        }
    }

    /**
     * Recupera el almacen del ficher donde se encuentra
     * guardado de forma predefinida
     *
     * @return void
     */
    public void menuItemRecuperarAlmacenHandler() {
        almacen.recuperar(ClienteHandler.FICHERO);
        bindProvincias();
    }

    /**
     * Guarda el almacen en el fichero donde se
     * guardará de forma predefinida
     *
     * @return void
     */
    public void menuItemGuardarAlmacenHandler() {
        almacen.guardar(ClienteHandler.FICHERO);
    }

    /**
     * Borra la provincia seleccionada en la lista de
     * provincias
     *
     * @return void
     */
    public void menuItemBorrarProvinciaHandler() {
        String provincia = listProvincias.getSelectedItem();
        if (provincia == null || provincia.isEmpty()) {
            new AvisoFrame(ClienteHandler.this, "Por favor seleccione una provincia");
        }
        else {
            almacen.delProvincia(provincia);
            bindProvincias();
        }
    }

    /**
     * Borra la población seleccionada en la lista de
     * poblaciones
     *
     * @return void
     */
    public void menuItemBorrarPoblacionHandler() {
        String provincia = listProvincias.getSelectedItem();
        String poblacion = listPoblaciones.getSelectedItem();
        if (poblacion == null || poblacion.isEmpty()) {
            new AvisoFrame(ClienteHandler.this, "Por favor seleccione una poblacion");
        }
        else {
            almacen.delPoblacion(provincia, poblacion);
            bindPoblaciones();
        }
    }

    /**
     * Ordena las poblaciones por nombre
     *
     * @return void
     */
    public void menuItemOrdenarPorNombreHandler() {
        String provincia = listProvincias.getSelectedItem();
        if (provincia == null || provincia.isEmpty()) {
            new AvisoFrame(ClienteHandler.this, "Por favor seleccione una provincia");
        }
        else {
            almacen.ordenarPor(provincia, IAlmacenPoblaciones.ORDENARPORNOMBRE);
            bindPoblaciones();
        }
    }

    /**
     * Ordena las poblaciones por número de
     * habitantes
     *
     * @return void
     */
    public void menuItemOrdenarPorHabitantesHandler() {
        String provincia = listProvincias.getSelectedItem();
        if (provincia == null || provincia.isEmpty()) {
            new AvisoFrame(ClienteHandler.this, "Por favor seleccione una provincia");
        }
        else {
            almacen.ordenarPor(provincia, IAlmacenPoblaciones.ORDENARPORHABITANTES);
            bindPoblaciones();
        }
    }

    /**
     * Muestra la información general del programa
     *
     * @return void
     */
    public void menuItemAcercaDeHandler() {
        new AvisoFrame(ClienteHandler.this, "Práctica 2 de Programación Avanzada de Aplicaciones.\nUniversidad Politécnica de Madrid\nAuthor: Carlos I Pérez Sechi\nURL: https://github.com/seccijr/es.upm.euitt.paa.p2");
    }

    /**
     * Manejador del evento de crear una nueva provincia
     *
     * @return void
     */
    public void menuItemNuevaProvinciaHandler() {
        new NuevaProvinciaHandler(ClienteHandler.this);
    }

    /**
     * Manejador del evento de crear una nueva población
     *
     * @return void
     */
    public void menuItemNuevaPoblacionHandler() {
        String provincia = listProvincias.getSelectedItem();
        if (provincia == null || provincia.isEmpty()) {
            new AvisoFrame(ClienteHandler.this, "Seleccione una provincia porfavor");
        }
        else {
            new NuevaPoblacionHandler(ClienteHandler.this, provincia);
        }
    }

    /**
     * Manejador del evento de selección de una provincia en la lista
     * mostrando las poblaciones disponibles para la provincia
     * seleccionada
     *
     * @return void
     */
    public void listProvinciasHandler() {
        bindPoblaciones();
    }

    /**
     * Manejador del evento de selección de una población en la lista
     * mostrando las predicciones disponibles para la población
     * seleccionada
     *
     * @return void
     */
    public void listPoblacionesHandler() {
        bindPredicciones();
    }

    /**
     * Inicializa la ventana cliente
     *
     * @return void
     */
    private void initialize() {
        initData();
        initHandlers();
        bindHandlers();
        bindProvincias();
    }

    /**
     * Inicializa los datos para la ventana cliente
     *
     * @return void
     */
    private void initData() {
        boolean recuperado = almacen.recuperar(
                ClienteHandler.FICHERO);
        if (!recuperado) {
            new AvisoFrame(ClienteHandler.this,
                    "No se ha recuperado el fichero de almacen de datos");
        }
    }

    /**
     * Inicializa los manejadores para la ventana cliente
     *
     * @return void
     */
    private void initHandlers() {
        buttonActualizarListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarPredicciones();
            }
        };

        menuItemRecuperarAlmacenListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuItemRecuperarAlmacenHandler();
            }
        };

        menuItemGuardarAlmacenListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuItemGuardarAlmacenHandler();
            }
        };

        menuItemSalirListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salir();
            }
        };

        menuItemBorrarProvinciaListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuItemBorrarProvinciaHandler();
            }
        };

        menuItemBorrarPoblacionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuItemBorrarPoblacionHandler();
            }
        };

        menuItemOrdenarPorNombreListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuItemOrdenarPorNombreHandler();
            }
        };

        menuItemOrdenarPorHabitantesListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuItemOrdenarPorHabitantesHandler();
            }
        };

        menuItemNuevaProvinciaListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuItemNuevaProvinciaHandler();
            }
        };

        menuItemNuevaPoblacionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuItemNuevaPoblacionHandler();
            }
        };

        menuItemAcercaDeListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuItemAcercaDeHandler();
            }
        };

        listProvinciasListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                listProvinciasHandler();
            }
        };

        listPoblacionesListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                listPoblacionesHandler();
            }
        };
    }

    /**
     * Vincula los manejadores para la ventana cliente
     *
     * @return void
     */
    private void bindHandlers() {
        buttonActualizarPrediccion.addActionListener(buttonActualizarListener);
        menuItemRecuperarAlmacen.addActionListener(menuItemRecuperarAlmacenListener);
        menuItemGuardarAlmacen.addActionListener(menuItemGuardarAlmacenListener);
        menuItemSalir.addActionListener(menuItemSalirListener);
        menuItemBorrarProvincia.addActionListener(menuItemBorrarProvinciaListener);
        menuItemBorrarPoblacion.addActionListener(menuItemBorrarPoblacionListener);
        menuItemOrdenarPorNombre.addActionListener(menuItemOrdenarPorNombreListener);
        menuItemOrdenarPorHabitantes.addActionListener(menuItemOrdenarPorHabitantesListener);
        menuItemNuevaProvincia.addActionListener(menuItemNuevaProvinciaListener);
        menuItemNuevaPoblacion.addActionListener(menuItemNuevaPoblacionListener);
        menuItemAcercaDe.addActionListener(menuItemAcercaDeListener);
        buttonNuevaProvincia.addActionListener(menuItemNuevaProvinciaListener);
        buttonNuevaPoblacion.addActionListener(menuItemNuevaPoblacionListener);
        listProvincias.addItemListener(listProvinciasListener);
        listPoblaciones.addItemListener(listPoblacionesListener);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                salir();
            }
        });

    }
}
