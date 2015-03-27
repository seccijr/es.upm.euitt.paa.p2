import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Date;

public class InterfazAWT_AEMET extends Frame {
    private static final String FICHERO = "almacen.dat";
    private MenuBar barraDeMenu;

    public InterfazAWT_AEMET(String titulo, int ancho, int alto){
        super(titulo);
        setSize(ancho,alto);
        setLocationRelativeTo(null);
        setLayout( new BorderLayout() );
        barraDeMenu = new MenuBar();
        setMenuBar(barraDeMenu);
        Menu menuProvincias = new Menu("Provincias");
        MenuItem crearProvincias = new MenuItem ("Crear provincia");
        crearProvincias.addActionListener(new CrearProvincia());
        menuProvincias.add(crearProvincias);
        barraDeMenu.add(menuProvincias);
        Menu ayuda = new Menu("Ayuda");
        MenuItem acercaDe = new MenuItem("Acerca de");
        acercaDe.addActionListener(new AcercaDe());
        ayuda.add(acercaDe);
        barraDeMenu.setHelpMenu(ayuda);
        Panel lineaDeBotones = new Panel();
        lineaDeBotones.setLayout (new FlowLayout (FlowLayout.LEFT));
        Button bcrear = new Button("Crear Provincia");
        bcrear.addActionListener(new CrearProvincia());
        lineaDeBotones.add(bcrear);
        add (lineaDeBotones,BorderLayout.NORTH);
        Panel lineaDeEstado = new Panel();
        lineaDeEstado.setLayout (new FlowLayout (FlowLayout.LEFT));
        lineaDeEstado.setBackground (Color.lightGray);
        Label ventanaDeeventos = new Label("Gestor AEMET v1.0 (PAA)");
        lineaDeEstado.add (ventanaDeeventos);
        add (lineaDeEstado, BorderLayout.SOUTH);
        addWindowListener (new WindowAdapter () {
            public void windowClosing(WindowEvent e) {
                guardarAntesDeSalir ();
                System.exit(0);
            }
        });
    }
    private void guardarAntesDeSalir () {
        System.out.println ("Gracias por utilizar nuestro programa");
    }

    class AcercaDe implements ActionListener{
        public void actionPerformed(ActionEvent e){
            VentanaAcercaDe ventanaAcercaDe = new VentanaAcercaDe(InterfazAWT_AEMET.this);
            ventanaAcercaDe.setVisible(true);
        }
    }
    class CrearProvincia implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Aviso aviso = new Aviso(InterfazAWT_AEMET.this, "Ventana de Crear Provincias");
            aviso.setVisible(true);
        }
    }

    public static void main(String[] args) {
        InterfazAWT_AEMET mimarco = new InterfazAWT_AEMET("Gestor AEMET",1000,500);
        mimarco.setVisible(true);
    }
}
