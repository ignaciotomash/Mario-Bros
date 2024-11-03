package PowerUps;

import Entidades.Entidad;
import Fabricas.Sprite;
import Mario.Mario;

public class FlorDeFuego extends PowerUp {

	public FlorDeFuego(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
	}

	public void serAfectado(Entidad entidad) {
		entidad.afectar(this);
	}
	
	public void afectar(Mario mario) {
		mario.reproducirSonido("sonidoSeConvierteASuperMario");
		mario.efectoFlorDeFuego();
		eliminar();
	}
	
	public void afectar(PowerUp powerUp) {
		powerUp.efectoFlorDeFuego();
	}

	public void serAfectado(Entidad entidad, String direccion) {}
	
	public void mover() {}
}
