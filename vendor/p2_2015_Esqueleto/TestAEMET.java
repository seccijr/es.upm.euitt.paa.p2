import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.io.*;

import paa.provincias.*;

public class TestAEMET  {

	public void doTest() {
		GestorAEMET gestor = new GestorAEMET();

		Poblacion poblacion = new Poblacion( "28005" ); // Alcala de Henares

		List<IPrediccion> lista = null;

		try {
			 lista = gestor.getPredicciones( poblacion );
			 poblacion.lista = lista;
		} catch( GestorAEMETException gae ) {
			System.out.println( gae.getMessage() );
		}

		if ( lista != null )
		{
			for (int i = 0; i < lista.size(); i++)
			{
				System.out.println( "-------------------------------------------------");
				System.out.println( lista.get(i).toString() );
				System.out.println( "-------------------------------------------------");
				System.out.println( "Fecha: "            +  lista.get(i).getFecha() );
				System.out.println( "Población: "        +  lista.get(i).getPoblacion() );
				System.out.println( "Provincia: "        +  lista.get(i).getProvincia() );
				System.out.println( "Máxima: "           +  lista.get(i).getTemperaturaMaxima() );
				System.out.println( "Mínima: "           +  lista.get(i).getTemperaturaMinima() );
				System.out.println( "Estado del cielo: " +  lista.get(i).getEstadoCielo() );
			}	
		}
	}

	public static void main(String[] args) {

		TestAEMET test = new TestAEMET();
		test.doTest();
	}
} // TestAEMET
