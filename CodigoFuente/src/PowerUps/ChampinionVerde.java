package PowerUps;

import Entidades.Entidad;
import Fabricas.Sprite;
import Mario.Mario;

public class ChampinionVerde extends PowerUp {

	public ChampinionVerde(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
	}

	public void afectar(Mario mario) {
		mario.reproducirSonido("sonidoChampinionVerde");
		mario.efectoChampinionVerde();
		eliminar();
	}

	public void afectar(PowerUp powerUp) {
		powerUp.efectoChampinionVerde();
	}

	public void serAfectado(Entidad entidad, String direccion) {
		entidad.afectar(this,direccion);
	}
	
}
