package Enemigos;

import Entidades.Entidad;
import Fabricas.Sprite;
import Mario.BolaDeFuego;
import Mario.Mario;

public class BuzzyBeetle extends Enemigo {

	protected final int SPRITE_DERECHA=0;
	protected final int SPRITE_IZQUIERDA=1;

	public BuzzyBeetle(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
	}

	public void afectar(Mario mario) {
		mario.eliminarEnemigo(this);
		mario.efectoBuzzyBeetle();
	}

	public void afectar(Enemigo enemigo) {
		enemigo.efectoBuzzyBeetle();
	}

	public void serAfectado(Entidad entidad, String direccion) {
		entidad.afectar(this, direccion);
	}

	public void efectoMario(Mario mario) {
		mario.modificarPuntos(30);
		eliminar();
		mario.rebotar();
	}

	public void efectoBolaDeFuego(BolaDeFuego bolaDeFuego, String direccion) {
		this.eliminar();
		bolaDeFuego.modificarPuntosMario(30);
		bolaDeFuego.eliminar();
	}

	public void actualizarSpriteDerecha() {
		sprite=coleccionSprites[SPRITE_DERECHA];
		observer.actualizar();
	}

	public void actualizarSpriteIzquierda() {
		sprite=coleccionSprites[SPRITE_IZQUIERDA];
		observer.actualizar();
	}

}
