package cliente.handlers;

import cliente.frames.AvisoFrame;
import cliente.frames.NuevaPoblacionFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NuevaPoblacionHandler extends NuevaPoblacionFrame {
    public static final long serialVersionUID = 46L;
    private ClienteHandler clienteHandler;
    private ActionListener buttonCrearListener;
    private ActionListener buttonCancelarListener;
    private WindowAdapter closeWindowAdapter;

    public NuevaPoblacionHandler(Window clienteHandler, String provincia) {
        super(clienteHandler, provincia);
        this.clienteHandler = (ClienteHandler)clienteHandler;
        initHandlers();
        bindHandlers();
        setVisible(true);
    }

    private void closeWindow() {
        NuevaPoblacionHandler.this.dispose();
    }

    private void initHandlers() {
        buttonCrearListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textPoblacion.getText();
                int habitantes = Integer.parseInt(textHabitantes.getText());
                String codigoAEMET = textCodigoAEMET.getText();

                if (nombre.isEmpty() || codigoAEMET.isEmpty()) {
                    new AvisoFrame(NuevaPoblacionHandler.this, "Debe proporcionar todos los campos");
                }
                else {
                    clienteHandler.crearNuevaPoblacion(nombre, habitantes, codigoAEMET);
                    closeWindow();
                }
            }
        };

        buttonCancelarListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeWindow();
            }
        };

        closeWindowAdapter = new WindowAdapter() {
            @Override
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
