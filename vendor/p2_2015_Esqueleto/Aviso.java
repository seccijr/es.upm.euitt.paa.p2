import java.awt.*;
import java.awt.event.*;


public class Aviso extends Dialog {
	public Aviso (Window f, String aviso) {
		super(f, "Aviso", Dialog.ModalityType.APPLICATION_MODAL);
		setLocationRelativeTo(f);
		add(new Label(aviso));
		
		// Se pueden añadir más componentes
		
		addWindowListener (new WindowAdapter() {
			public void windowClosing (WindowEvent e) {
				Aviso.this.dispose();
			}
		});
		pack();
	}
}
