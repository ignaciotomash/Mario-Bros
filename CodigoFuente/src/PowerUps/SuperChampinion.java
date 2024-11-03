package PowerUps;

import Entidades.Entidad;
import Fabricas.Sprite;
import Mario.Mario;

public class SuperChampinion extends PowerUp {

	public SuperChampinion(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
	}

	public void afectar(Mario mario) {	
		mario.reproducirSonido("sonidoSeConvierteASuperMario");
		mario.efectoSuperChampinion();
		eliminar();
	}

	public void afectar(PowerUp powerUp) {
		powerUp.efectoSuperChampinion();
	}
	
	public void serAfectado(Entidad entidad, String direccion) {
		entidad.afectar(this,direccion);
	}
	
}
