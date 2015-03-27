import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaAcercaDe extends Dialog {
	
	public VentanaAcercaDe (Frame f) {
		super(f, "Acerca de ...", true);
		//setPreferredSize( new Dimension(300, 300) );
		setLocationRelativeTo(f);
		
		Panel panelDialogo = new Panel();
		panelDialogo.setLayout (new BorderLayout());
		panelDialogo.add(new Label("Aplicación realizada por PAA. Curso 2015"), BorderLayout.NORTH);
		
		add( panelDialogo );
		
		addWindowListener (new WindowAdapter (){ 
	          public void windowClosing(WindowEvent e) { 
	        	  VentanaAcercaDe.this.dispose(); 
	             } 
	          });
		pack();
	}
}
