package cliente.frames;

import java.awt.*;
import java.awt.event.*;


public class NuevaProvinciaFrame extends Dialog {
    public static final long serialVersionUID = 45L;
    private Panel panelEntradas;
    private Panel panelBotones;
    private TextField provincia;

    public NuevaProvinciaFrame (Window f) {
        super(f, "Crear provincia", Dialog.ModalityType.APPLICATION_MODAL);
        setLocationRelativeTo(f);
        setLayout(new BorderLayout());

        panelEntradas = new Panel();
        panelEntradas.setLayout(new FlowLayout());
        add(panelEntradas, BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter() {
            public void windowClosing (WindowEvent e) {
                NuevaProvinciaFrame.this.dispose();
            }
        });
        pack();
        setVisible(true);
    }

    public String getProvincia() {
        String result = "";

        return result;
    }
}
