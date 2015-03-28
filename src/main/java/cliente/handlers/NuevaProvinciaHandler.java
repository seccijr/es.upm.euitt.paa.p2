package cliente.handlers;

import java.awt.*;
import java.awt.event.*;
import java.util.Set;
import paa.provincias.IAlmacenPoblaciones;
import cliente.frames.NuevaProvinciaFrame;

public class NuevaProvinciaHandler extends NuevaProvinciaFrame {
    public static final long serialVersionUID = 46L;
    private ClienteHandler clienteHandler;
    private ActionListener buttonCrearListener;
    private ActionListener buttonCancelarListener;
    private WindowAdapter closeWindowAdapter;

    public NuevaProvinciaHandler(ClienteHandler clienteHandler) {
        super(clienteHandler);
        this.clienteHandler = clienteHandler;
        init();
    }

    private void init() {
        initHandlers();
        bindHandlers();
    }

    private void closeWindow() {
        NuevaProvinciaHandler.this.dispose();
    }

    private void initHandlers() {
        buttonCrearListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String provincia = textProvincia.getText();
                clienteHandler.crearNuevaProvincia(provincia);
            }
        };

        buttonCancelarListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                closeWindow();
            }
        };

        closeWindowAdapter = new WindowAdapter() {
            public void windowClosing (WindowEvent e) {
                closeWindow();
            }
        };
    }

    private void bindHandlers() {
        buttonCrear.addActionListener(
            buttonCrearListener);
        buttonCancelar.addActionListener(
            buttonCancelarListener);
        addWindowListener(closeWindowAdapter);
    }
}
