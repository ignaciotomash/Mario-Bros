package Plataformas;

import Enemigos.Enemigo;
import Entidades.Entidad;
import Fabricas.Sprite;
import Mario.BolaDeFuego;
import Mario.Mario;
import PowerUps.PowerUp;

public class Tuberia extends Plataforma{

	public Tuberia(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
	}

	public void afectar(Mario mario, String direccion) {
		mario.efectoTuberia(direccion);
	}
	
	public void afectar(Enemigo enemigo, String direccion) {
		enemigo.efectoTuberia(direccion);
	}
	
	public void afectar(PowerUp powerUp, String direccion) {
		powerUp.efectoTuberia(direccion);
	}

	public void afectar(BolaDeFuego bolaDeFuego, String direccion) {
		bolaDeFuego.efectoTuberia(direccion);
	}
	
	public void serAfectado(Entidad entidad, String direccion) {
		entidad.afectar(this,direccion);
	}

}
