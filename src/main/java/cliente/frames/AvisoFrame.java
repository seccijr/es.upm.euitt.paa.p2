package cliente.frames;

import java.awt.*;
import java.awt.event.*;


public class AvisoFrame extends Dialog {
    public static final long serialVersionUID = 44L;

    public AvisoFrame (Window f, String aviso) {
        super(f, "Aviso", Dialog.ModalityType.APPLICATION_MODAL);
        setLocationRelativeTo(f);
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
