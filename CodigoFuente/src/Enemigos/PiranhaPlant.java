package Enemigos;

import Entidades.Entidad;
import Fabricas.Sprite;
import Mario.BolaDeFuego;
import Mario.Mario;

public class PiranhaPlant extends Enemigo {

	private static final int TOPE_ALTO = 228;
	private static final int TOPE_BAJO = 174;
	boolean subir;
	boolean bajar;

	public PiranhaPlant(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
		subir = false;
		bajar = true;
		direccionDeMovimiento = ABAJO;
		velocidadY = 1;
	}

	public void afectar(Mario mario) {
		mario.eliminarEnemigo(this);
		mario.efectoPiranhPlant();
	}

	public void afectar(Enemigo enemigo) {
		enemigo.efectoPiranhPlant();
	}

	public void efectoBolaDeFuego(BolaDeFuego bolaDeFuego, String direccion) {
		this.eliminar();
		bolaDeFuego.modificarPuntosMario(30);
		bolaDeFuego.eliminar();
	}

	public void mover() {
		
		if (bajar && posicionY <= (TOPE_ALTO + 2)) {
			bajar = posicionY != TOPE_BAJO + 2;
			subir = posicionY == TOPE_BAJO + 2;
			establecerDireccion(ABAJO);
			posicionY -= velocidadY;
			observer.actualizarPosicion();
		} 
		
		else if (subir && posicionY >= TOPE_BAJO ) {
			subir = posicionY != TOPE_ALTO;
			bajar = posicionY == TOPE_ALTO;
			establecerDireccion(ARRIBA);
			super.mover();
		}
		
		observer.actualizarPosicion();
	}
	
	public void serAfectado(Mario mario) {
		mario.efectoPiranhPlant();
	}
}
