package Plataformas;

import Enemigos.Enemigo;
import Entidades.Entidad;
import Fabricas.Sprite;
import Mario.BolaDeFuego;
import Mario.Mario;
import PowerUps.PowerUp;

public class BloqueDePregunta extends Plataforma {

	protected final int FUERA_DEL_BLOQUE = 46;
	protected final int SPRITE_BLOQUE_NO_USADO = 0;
	protected final int SPRITE_BLOQUE_USADO = 1;
	protected final int SPRITE_POWERUP_DENTRO_DE_BLOQUE = 1;
	protected final int SPRITE_POWERUP_NORMAL = 0;
	
	private PowerUp contenido;
	boolean usado;

	public BloqueDePregunta(int posicionX, int posicionY, Sprite[] coleccionSprites, PowerUp powerUp) {
		super(posicionX, posicionY, coleccionSprites);
		contenido = powerUp;
		contenido.establecerDireccion(INMOVIL);
		contenido.modificarSprite(SPRITE_POWERUP_DENTRO_DE_BLOQUE);
		usado = false;
	}

	public void serAfectado(Entidad entidad, String direccion) {
		entidad.afectar(this,direccion);
	}
	
	public void afectar(BolaDeFuego bolaDeFuego, String direccion) {
		bolaDeFuego.efectoBloqueDePregunta(direccion);
	}
	
	public void afectar(Mario mario, String direccion) {
		mario.efectoBloqueDePregunta(direccion);
	}

	public void afectar(PowerUp powerUp, String direccion) {
		powerUp.efectoBloqueDePregunta(direccion);
	}

	public void afectar(Enemigo enemigo) {
		enemigo.efectoBloqueDePregunta();
	}

	public void afectar(PowerUp powerUp) {
		powerUp.efectoBloqueDePregunta();
	}
	
	public void afectar(BolaDeFuego bolaDeFuego) {
		bolaDeFuego.efectoBloqueDePregunta();
	}
	
	public void reiniciar() {
		this.modificarSprite(SPRITE_BLOQUE_NO_USADO);
		usado = false;
		super.reiniciar();
	}

	public void efectoMario(Mario mario) {
		if(!usado) {
			usado = true;
			sprite = coleccionSprites[SPRITE_BLOQUE_USADO];
			contenido.modificarSprite(SPRITE_POWERUP_NORMAL);
			contenido.establecerPosicionY(obtenerPosicionY() + FUERA_DEL_BLOQUE);
			contenido.establecerPosicionX(obtenerPosicionX());
			observer.actualizar();
			contenido.obtenerObserver().actualizar();	
		}
	} 
}
