package cliente.frames;

import java.awt.*;


public class NuevaProvinciaFrame extends Dialog {
    public static final long serialVersionUID = 45L;
    private int ancho = 375;
    private int alto = 100;
    protected Panel panelEntradas;
    protected Panel panelBotones;
    protected TextField textProvincia;
    protected Button buttonCrear;
    protected Button buttonCancelar;
    protected Label labelNuevaProvincia;

    public NuevaProvinciaFrame (Window f) {
        super(f, "Crear provincia", Dialog.ModalityType.APPLICATION_MODAL);
        initialize();
        setupLayout();
        setLocationRelativeTo(f);
    }

    private void initialize() {
        labelNuevaProvincia = new Label("Nueva provincia: ");
        textProvincia = new TextField("", 30);
        panelEntradas = new Panel();
        panelBotones = new Panel();
        buttonCancelar = new Button("Cancelar");
        buttonCrear = new Button("Crear");
    }

    private void setupLayout() {
        setSize(ancho, alto);
        setLayout(new BorderLayout());

        panelEntradas.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelEntradas.add(labelNuevaProvincia);
        panelEntradas.add(textProvincia);
        add(panelEntradas, BorderLayout.NORTH);

        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelBotones.add(buttonCancelar);
        panelBotones.add(buttonCrear);
        add(panelBotones, BorderLayout.SOUTH);
    }
}
