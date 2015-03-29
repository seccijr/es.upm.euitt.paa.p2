package cliente.frames;

import java.awt.*;
import java.awt.event.*;


public class AvisoFrame extends Dialog {
    public static final long serialVersionUID = 44L;

    public AvisoFrame (Window clienteHandler, String aviso) {
        super(clienteHandler, "Aviso", Dialog.ModalityType.APPLICATION_MODAL);
        setLocationRelativeTo(clienteHandler);
        add(new Label(aviso));

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing (WindowEvent e) {
                AvisoFrame.this.dispose();
            }
        });
        pack();
        setVisible(true);
    }
}
