import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.io.*;

import paa.provincias.*;

	class Poblacion implements IPoblacionAEMET, Serializable {

	private String codigoAEMET;

	public List<IPrediccion> lista = null;

	public Poblacion ( String codigoAEMET ) {
		this.codigoAEMET = codigoAEMET;
	}

	@Override
	public String getCodigoAEMET() { return codigoAEMET; }
	} // Poblacion

