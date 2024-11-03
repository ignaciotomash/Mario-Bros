package Plataformas;

import Enemigos.Enemigo;
import Entidades.Entidad;
import Fabricas.Sprite;
import Mario.BolaDeFuego;
import Mario.Mario;
import PowerUps.PowerUp;

public class LadrilloSolido extends Plataforma {

	public LadrilloSolido(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
	}

	public void afectar(Mario mario, String direccion) {
		mario.efectoLadrilloSolido(direccion);
	}
	
	public void afectar(Enemigo enemigo, String direccion) {
		enemigo.efectoLadrilloSolido(direccion);
	}
	
	public void afectar(PowerUp powerUp, String direccion) {
		powerUp.efectoLadrilloSolido(direccion);
	}
	
	public void afectar(BolaDeFuego bolaDeFuego, String direccion) {
		bolaDeFuego.efectoLadrilloSolido(direccion);
	}

	public void efectoMario(Mario mario) {
		mario.romperBloque(this);
	}

	public void serAfectado(Entidad entidad, String direccion) {
		entidad.afectar(this,direccion);
	}

	public void afectar(Enemigo enemigo) {
		enemigo.efectoLadrilloSolido();
	}

	public void afectar(PowerUp powerUp) {
		powerUp.efectoLadrilloSolido();
	}

}
