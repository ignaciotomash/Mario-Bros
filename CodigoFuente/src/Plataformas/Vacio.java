package Plataformas;

import Enemigos.Enemigo;
import Entidades.Entidad;
import Fabricas.Sprite;
import Mario.BolaDeFuego;
import Mario.Mario;
import PowerUps.PowerUp;

public class Vacio extends Plataforma{

	public Vacio(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
	}

	public void afectar(Mario mario, String direccion) {
		mario.efectoVacio(direccion);
	}

	public void afectar(Enemigo enemigo) {
		enemigo.efectoVacio();
	}

	public void afectar(PowerUp powerUp) {
		powerUp.efectoVacio();
	}
	public void afectar(BolaDeFuego bolaDeFuego) {
		bolaDeFuego.efectoVacio();
	}
	
	public void afectar(PowerUp powerUp, String direccion) {
		powerUp.efectoVacio(direccion);
	}
	
	public void serAfectado(Entidad entidad, String direccion) {

	}

	public void afectar(BolaDeFuego bolaDeFuego, String direccion) {}
	
}
