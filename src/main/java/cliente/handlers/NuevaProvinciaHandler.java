package cliente.handlers;

import java.awt.event.*;
import cliente.frames.NuevaProvinciaFrame;

public class NuevaProvinciaHandler extends NuevaProvinciaFrame {
    public static final long serialVersionUID = 46L;
    private ClienteHandler clienteHandler;
    private ActionListener buttonCrearListener;
    private ActionListener buttonCancelarListener;
    private WindowAdapter closeWindowAdapter;

    /**
     * Constructor para la ventana de nueva provincia
     *
     * @param clienteHandler Window padre
     * @return void
     */
    public NuevaProvinciaHandler(ClienteHandler clienteHandler) {
        super(clienteHandler);
        this.clienteHandler = clienteHandler;
        initHandlers();
        bindHandlers();
        setVisible(true);
    }

    /**
     * Cierra la ventana
     *
     * @return void
     */
    private void closeWindow() {
        NuevaProvinciaHandler.this.dispose();
    }

    /**
     * Inicializa los manejadores para la ventana
     * de nueva provincia
     *
     * @return void
     */
    private void initHandlers() {
        buttonCrearListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String provincia = textProvincia.getText();
                clienteHandler.crearNuevaProvincia(provincia);
                closeWindow();
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

    /**
     * Vincula los manejadores para la ventana
     * de nueva provincia
     *
     * @return void
     */
    private void bindHandlers() {
        buttonCrear.addActionListener(
            buttonCrearListener);
        buttonCancelar.addActionListener(
            buttonCancelarListener);
        addWindowListener(closeWindowAdapter);
    }
}
