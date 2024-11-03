package Enemigos;

import Entidades.Entidad;
import Fabricas.Sprite;
import Mario.BolaDeFuego;
import Mario.Mario;

public class KoopaTroopa extends Enemigo{

	private static final int PISO_CAPARAZON = 153;

	protected final int SPRITE_DERECHA=0;
	protected final int SPRITE_IZQUIERDA=1;
	protected final int SPRITE_DENTRO_CAPARAZON=2;
	protected boolean saltoRecibido;

	public KoopaTroopa(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
		saltoRecibido=false;
	}

	public void afectar(Mario mario) {
		mario.eliminarEnemigo(this);
		mario.efectoKoopaTroopa();
	}

	public void afectar(Enemigo enemigo) {
		enemigo.efectoKoopaTroopa();
	}

	public void serAfectado(Entidad entidad, String direccion) {
		entidad.afectar(this, direccion);
	}

	public void efectoMario(Mario mario) {
		
		if(!saltoRecibido) {
			sprite = coleccionSprites[SPRITE_DENTRO_CAPARAZON];
			this.establecerPosicionY(PISO_CAPARAZON);
			saltoRecibido = true;
			mario.rebotar();
			observer.actualizar();
		}
		
		else {
			mario.rebotar();
			mario.modificarPuntos(90);
			eliminar();
		}
	}

	public void efectoBolaDeFuego(BolaDeFuego bolaDeFuego, String direccion) {
		this.eliminar();
		bolaDeFuego.modificarPuntosMario(90);
		bolaDeFuego.eliminar();
	}

	public void mover() {
		if(!saltoRecibido)
			super.mover();
	}

	public void actualizarSpriteDerecha() {
		if(!saltoRecibido) {
			sprite=coleccionSprites[SPRITE_DERECHA];
			observer.actualizar();
		}
	}

	public void actualizarSpriteIzquierda() {
		if(!saltoRecibido) {
			sprite=coleccionSprites[SPRITE_IZQUIERDA];
			observer.actualizar();
		}
	}

	public void reiniciar() {
		saltoRecibido=false;
		sprite=coleccionSprites[SPRITE_DERECHA];
		super.reiniciar();
	}
	
}
