package Plataformas;

import Enemigos.Enemigo;
import Entidades.Entidad;
import Fabricas.Sprite;
import Mario.BolaDeFuego;
import Mario.Mario;
import PowerUps.PowerUp;

public class BloqueSolido extends Plataforma {

	public BloqueSolido(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
	}

	public void serAfectado(Entidad entidad, String direccion) {
		entidad.afectar(this,direccion);
	}
	
	public void afectar(Enemigo enemigo, String direccion) {
		enemigo.efectoBloqueSolido(direccion);
	}
	
	public void afectar(PowerUp powerUp, String direccion) {
		powerUp.efectoBloqueSolido(direccion);
	}
	
	public void afectar(Mario mario, String direccion) {
		mario.efectoBloqueSolido(direccion);
	}

	public void afectar(BolaDeFuego bolaDeFuego, String direccion) {
		bolaDeFuego.efectoBloqueSolido(direccion);
	}
	
	public void afectar(Enemigo enemigo) {
		enemigo.efectoBloqueSolido();
	}
	
	public void afectar(PowerUp powerUp) {
		powerUp.efectoBloqueSolido();
	}
	
	public void afectar(BolaDeFuego bolaDeFuego) {
		bolaDeFuego.efectoBloqueSolido();
	}
}
