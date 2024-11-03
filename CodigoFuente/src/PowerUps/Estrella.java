package PowerUps;

import Entidades.Entidad;
import Fabricas.Sprite;
import Mario.Mario;

public class Estrella extends PowerUp{

	public Estrella(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
	}

	public void afectar(Mario mario) {
		mario.reproducirSonido("sonidoSeConvierteASuperMario");
		mario.efectoEstrella();
		eliminar();
	}

	public void afectar(PowerUp powerUp) {
		powerUp.efectoEstrella();
	}

	public void serAfectado(Entidad entidad, String direccion) {
		entidad.afectar(this,direccion);
	}
	
}
