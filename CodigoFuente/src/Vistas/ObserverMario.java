package Vistas;
import Entidades.EntidadMario;

@SuppressWarnings("serial")
public class ObserverMario extends ObserverGrafico {

	protected EntidadMario marioObservado;
	protected PantallaJuego pantallaJuego;

	public ObserverMario(PantallaJuego pantallaJuego , EntidadMario marioObservado) {
		super(marioObservado);
		this.marioObservado = marioObservado;
		this.pantallaJuego = pantallaJuego;
	}

	public void actualizar() {
		if (entidadObservada.estaEliminada()) {
			this.setVisible(false);
		}
		else
			super.actualizar();
	}

	public void actualizarPosicion(){
		super.actualizarPosicion();
		pantallaJuego.actualizarScrollMario(marioObservado);
		pantallaJuego.actualizarInformacion(marioObservado);
	}
	
}