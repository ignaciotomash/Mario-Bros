package Enemigos;

import Entidades.Entidad;
import Fabricas.Sprite;
import Mario.BolaDeFuego;
import Mario.Mario;

public abstract class Enemigo extends Entidad{

	public Enemigo(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
	}

	public void serAfectado(Entidad entidad) {
		entidad.afectar(this);
	}

	public void serAfectado(Mario mario) {
		mario.afectar(this);
	}

	public void serAfectado(Entidad entidad, String direccion) {
		entidad.afectar(this, direccion);
	}

	public void efectoTuberia(String direccion) {
		efectoGeneral(direccion);
	}

	public void efectoBloqueSolido(String direccion) {
		efectoGeneral(direccion);
	}

	public void efectoLadrilloSolido(String direccion) {
		efectoGeneral(direccion);
	}

	public void efectoBloqueDePregunta(String direccion) {
		efectoGeneral(direccion);
	}

	public void efectoVacio(String direccion) {
		if(direccion == "arriba") {
			velocidadY -= 5; 
			posicionY += velocidadY; 
			observer.actualizarPosicion();
		}
		else if(direccion == "abajo") 
			eliminar();

	}

	public void efectoPiranhPlant() {
		cambiarDireccion();
	}

	public void efectoBuzzyBeetle() {
		cambiarDireccion();
	}

	public void efectoSpiny() {
		cambiarDireccion();
	}

	public void efectoLakitu() {
		cambiarDireccion();
	}

	public void efectoGoomba() {
		cambiarDireccion();
	}

	public void efectoKoopaTroopa() {
		cambiarDireccion();
	}

	public void deshacerColision() {
		this.establecerDireccion(ABAJO);
	}

	private void cambiarDireccion() {
		if(direccionDeMovimiento == DERECHA) {
			establecerDireccion(IZQUIERDA);
			actualizarSpriteIzquierda();
		}
		else if(direccionDeMovimiento == IZQUIERDA) {
			establecerDireccion(DERECHA);
			actualizarSpriteDerecha();
		}
	}

	private void efectoGeneral(String direccion) {
		if (direccion == "derecha")
			cambiarDireccion();
		if (direccion == "izquierda")
			cambiarDireccion();
		if(direccion == "abajo" && !enSueloFirme()) 
			sobrePlataforma(true);
	}
	
	public void efectoBolaDeFuego(BolaDeFuego bolaDeFuego) {}
}
