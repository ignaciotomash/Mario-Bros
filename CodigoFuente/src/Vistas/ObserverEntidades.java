package Vistas;

import Entidades.EntidadLogica;

@SuppressWarnings("serial")
public class ObserverEntidades extends ObserverGrafico {

	public ObserverEntidades(EntidadLogica entidadObservada) {
		super(entidadObservada);
		actualizar();
	}

	public void actualizar() {
		if (entidadObservada.estaEliminada()) {
			this.setVisible(false);
		}
		else
			super.actualizar();
	}
	
	public void reiniciar() {
		this.setVisible(true);
	}
	
}