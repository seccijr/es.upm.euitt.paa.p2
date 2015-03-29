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

    public ClienteHandler(
            IAlmacenPoblaciones almacen, String titulo) {
        super(titulo);
        this.almacen = almacen;
        gestor = new GestorAEMET();
        initialize();
        setVisible(true);
    }

    public void salir() {
        almacen.guardar(ClienteHandler.FICHERO);
        System.out.println("Gracias por utilizar nuestro programa");
        System.exit(0);
    }

    public void crearNuevaProvincia(String provincia) {
        almacen.addProvincia(provincia);
        Set<String> provincias = almacen.getProvincias();
        bindProvincias(provincias);
    }

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

    private void actualizarPredicciones() {
        List<IPrediccion> predicciones;
        String provincia = listProvincias.getSelectedItem();
        String nombre = listPoblaciones.getSelectedItem();
        IPoblacion poblacion = almacen.getPoblacion(provincia, nombre);
        predicciones = consultarPrediccion((Poblacion)poblacion);
        bindPredicciones(predicciones, nombre);

    }

    private void bindProvincias() {
        Set<String> provincias = almacen.getProvincias();
        if (!provincias.isEmpty()) {
            bindProvincias(provincias);
        }
    }

    private void bindProvincias(Set<String> provincias) {
        listProvincias.removeAll();
        for(String provincia: provincias) {
            listProvincias.add(provincia);
        }
    }

    private void bindPoblaciones() {
        String provincia = listProvincias.getSelectedItem();
        SortedSet<IPoblacion> poblaciones = almacen.getPoblaciones(provincia);
        bindPoblaciones(poblaciones);
    }

    private void bindPoblaciones(SortedSet<IPoblacion> poblaciones) {
        listPoblaciones.removeAll();
        for(IPoblacion poblacion: poblaciones) {
            listPoblaciones.add(poblacion.getNombre());
        }
    }

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

    public void menuItemRecuperarAlmacenHandler() {
        almacen.recuperar(ClienteHandler.FICHERO);
        bindProvincias();
    }

    public void menuItemGuardarAlmacenHandler() {
        almacen.guardar(ClienteHandler.FICHERO);
    }

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

    public void menuItemAcercaDeHandler() {
        new AvisoFrame(ClienteHandler.this, "Práctica 2 de Programación Avanzada de Aplicaciones.\nUniversidad Politécnica de Madrid\nAuthor: Carlos I Pérez Sechi\nURL: https://github.com/seccijr/es.upm.euitt.paa.p2");
    }

    public void menuItemNuevaProvinciaHandler() {
        new NuevaProvinciaHandler(ClienteHandler.this);
    }

    public void menuItemNuevaPoblacionHandler() {
        String provincia = listProvincias.getSelectedItem();
        if (provincia == null || provincia.isEmpty()) {
            new AvisoFrame(ClienteHandler.this, "Seleccione una provincia porfavor");
        }
        else {
            new NuevaPoblacionHandler(ClienteHandler.this, provincia);
        }
    }

    public void listProvinciasHandler() {
        bindPoblaciones();
    }

    public void listPoblacionesHandler() {
        bindPredicciones();
    }

    private void initialize() {
        initData();
        initHandlers();
        bindHandlers();
        bindProvincias();
    }

    private void initData() {
        boolean recuperado = almacen.recuperar(
                ClienteHandler.FICHERO);
        if (!recuperado) {
            new AvisoFrame(ClienteHandler.this,
                    "No se ha recuperado el fichero de almacen de datos");
        }
    }

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
