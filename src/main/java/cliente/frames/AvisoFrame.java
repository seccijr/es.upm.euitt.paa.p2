package cliente.frames;

import java.awt.*;
import java.awt.event.*;
import cliente.handlers.ClienteHandler;


public class AvisoFrame extends Dialog {
    public static final long serialVersionUID = 44L;

    public AvisoFrame (ClienteHandler clienteHandler, String aviso) {
        super(clienteHandler, "Aviso", Dialog.ModalityType.APPLICATION_MODAL);
        setLocationRelativeTo(clienteHandler);
        add(new Label(aviso));

        addWindowListener(new WindowAdapter() {
            public void windowClosing (WindowEvent e) {
                AvisoFrame.this.dispose();
            }
        });
        pack();
        setVisible(true);
    }
}
