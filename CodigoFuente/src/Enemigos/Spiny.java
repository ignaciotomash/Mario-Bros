package Enemigos;

import Entidades.Entidad;
import Fabricas.Sprite;
import Mario.BolaDeFuego;
import Mario.Mario;

public class Spiny extends Enemigo{

	protected final int SPRITE_DERECHA = 0;
	protected final int SPRITE_IZQUIERDA = 1;
	protected final int CONTENIDO_EN_LAKITU = 2;
	protected boolean lanzadoPorLakitu;

	public Spiny(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
	}

	public void serAfectado(Entidad entidad, String direccion) {
		entidad.afectar(this, direccion);
	}

	public void afectar(Mario mario) {
		mario.eliminarEnemigo(this);
		mario.efectoSpiny();
	}

	public void afectar(Enemigo enemigo) {
		enemigo.efectoSpiny();
	}

	public void efectoLakitu() {
		efectoGeneral();
	}

	public void efectoSpiny() {
		efectoGeneral();
	}

	public void efectoBuzzyBeetle() {
		efectoGeneral();
	}

	public void efectoPiranhPlant() {
		efectoGeneral();
	}

	public void efectoGoomba() {
		efectoGeneral();
	}

	public void efectoKoopaTroopa() {
		efectoGeneral();
	}

	private void efectoGeneral() {
		if(!lanzadoPorLakitu)
			super.efectoSpiny();
	}

	public void efectoBolaDeFuego(BolaDeFuego bolaDeFuego, String direccion) {
		this.eliminar();
		bolaDeFuego.modificarPuntosMario(60);
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

	public void establecerLanzadoPorLakitu(boolean lanzado) {
		lanzadoPorLakitu = lanzado;
	}

	public boolean lanzadoPorLakitu() {
		return lanzadoPorLakitu;
	}

	public void reiniciar() {

		if(lanzadoPorLakitu) {
			establecerPosicionInicial();
			modificarSprite(CONTENIDO_EN_LAKITU);
			observer.reiniciar();
			observer.actualizar();
		}
		else 
			super.reiniciar();
		
	}

}
