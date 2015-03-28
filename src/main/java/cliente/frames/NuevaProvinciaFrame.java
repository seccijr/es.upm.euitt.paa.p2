package cliente.frames;

import java.awt.*;
import java.awt.event.*;


public class NuevaProvinciaFrame extends Dialog {
    public static final long serialVersionUID = 45L;
    protected Panel panelEntradas;
    protected Panel panelBotones;
    protected TextField textProvincia;
    protected Button buttonCrear;
    protected Button buttonCancelar;

    public NuevaProvinciaFrame (Window f) {
        super(f, "Crear provincia", Dialog.ModalityType.APPLICATION_MODAL);
        setLocationRelativeTo(f);
        setLayout(new BorderLayout());

        panelEntradas = new Panel();
        panelEntradas.setLayout(new FlowLayout());
        add(panelEntradas, BorderLayout.NORTH);

        panelBotones = new Panel();
        panelBotones.setLayout(new FlowLayout());
        add(panelBotones, BorderLayout.NORTH);

        pack();
        setVisible(true);
    }

    private void init() {

    }
}
