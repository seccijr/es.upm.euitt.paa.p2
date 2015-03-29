package cliente.frames;

import java.awt.*;


public class NuevaPoblacionFrame extends Dialog {
    public static final long serialVersionUID = 45L;
    private int ancho = 400;
    private int alto = 180;
    private String provincia;

    protected Panel panelEntradas;
    protected Panel panelBotones;

    protected TextField textPoblacion;
    protected TextField textProvincia;
    protected TextField textHabitantes;
    protected TextField textCodigoAEMET;

    protected Button buttonCrear;
    protected Button buttonCancelar;

    protected Label labelNombrePoblacion;
    protected Label labelNombreProvincia;
    protected Label labelHabitantes;
    protected Label labelCodigoAEMET;

    /**
     * Constructor para la ventana de
     * nueva población
     *
     * @param f Window de la ventana padre
     * @param provincia
     * @return void
     */
    public NuevaPoblacionFrame(Window f, String provincia) {
        super(f, "Crear provincia", ModalityType.APPLICATION_MODAL);
        this.provincia = provincia;
        initialize();
        setupLayout();
        setLocationRelativeTo(f);
    }

    /**
     * Inicializa los componentes de esta venatana
     *
     * @return void
     */
    private void initialize() {
        textPoblacion = new TextField("", 30);
        textProvincia = new TextField(provincia, 30);
        textHabitantes = new TextField("", 30);
        textCodigoAEMET = new TextField("", 30);
        panelEntradas = new Panel();
        panelBotones = new Panel();
        buttonCancelar = new Button("Cancelar");
        buttonCrear = new Button("Crear");
        labelNombrePoblacion = new Label("Nombre población: ");
        labelNombreProvincia = new Label("Nombre de la provincia: ");
        labelHabitantes = new Label("Número de habitantes: ");
        labelCodigoAEMET = new Label("Código AEMET: ");
    }

    /**
     * Coloca los componentes de esta venatana
     * en las posiciones correspondientes
     *
     * @return void
     */
    private void setupLayout() {
        setSize(ancho, alto);
        setLayout(new BorderLayout());

        panelEntradas.setLayout(new GridLayout(4, 2));
        panelEntradas.add(labelNombrePoblacion);
        panelEntradas.add(textPoblacion);
        panelEntradas.add(labelNombreProvincia);
        panelEntradas.add(textProvincia);
        textProvincia.setEditable(false);
        panelEntradas.add(labelHabitantes);
        panelEntradas.add(textHabitantes);
        panelEntradas.add(labelCodigoAEMET);
        panelEntradas.add(textCodigoAEMET);
        add(panelEntradas, BorderLayout.NORTH);

        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelBotones.add(buttonCancelar);
        panelBotones.add(buttonCrear);
        add(panelBotones, BorderLayout.SOUTH);
    }
}
