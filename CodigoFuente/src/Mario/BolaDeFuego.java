package Mario;

import Enemigos.Enemigo;
import Entidades.Entidad;
import Fabricas.Sprite;

public class BolaDeFuego extends Entidad{
	
	public static final int SUELO_DE_BOLA_DE_FUEGO = 116;
	public static final int ALTURA_DE_SALTO = 50;

	private Mario mario;
	private boolean contactoConSuperficie;
	private int posicionTopeDeSalto;

	public BolaDeFuego(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
		velocidadX = 12;
		contactoConSuperficie = false;
		gravedad = 8;
	}

	public void mover() {
		super.mover();
		irSaltando();
	}

	private void irSaltando() {
		if(!contactoConSuperficie) 
			posicionY -= gravedad;

		if(contactoConSuperficie) {
			posicionY += gravedad;
			if(posicionY >= posicionTopeDeSalto) {
				contactoConSuperficie = false;
			}
		}

		if(posicionY <= SUELO_DE_BOLA_DE_FUEGO) {
			posicionTopeDeSalto = posicionY + ALTURA_DE_SALTO;
			contactoConSuperficie = true;
		}
	}

	public void rebotarBolaDeFuego() {
		contactoConSuperficie= true;
		posicionTopeDeSalto = posicionY + ALTURA_DE_SALTO;
	}

	public void serAfectado(Entidad entidad, String direccion) {
		entidad.afectar(this, direccion);
	}

	public void afectar(Enemigo enemigo, String direccion) {
		enemigo.efectoBolaDeFuego(this, direccion);
	}

	public void efectoBloqueSolido(String direccion) {
		efectoGeneralPlataformas(direccion);
	}

	public void efectoLadrilloSolido(String direccion) {
		efectoGeneralPlataformas(direccion);
	}

	public void efectoBloqueDePregunta(String direccion) {
		efectoGeneralPlataformas(direccion);
	}

	public void efectoVacio(String direccion) {
		efectoGeneralPlataformas(direccion);
	}
	
	public void efectoTuberia(String direccion) {
		efectoGeneralPlataformas(direccion);
	}

	public void establecerMario(Mario mario) {
		this.mario = mario;
	}

	public void modificarPuntosMario(int puntos) {
		mario.modificarPuntos(puntos);
	}

	public void efectoGeneralPlataformas(String direccion) {
		
		if(direccion == "abajo") 
			rebotarBolaDeFuego();
		
		if(direccion == "derecha") {
			eliminar();
			observer.actualizar();
		}
		
		if(direccion == "izquierda") {
			eliminar();
			observer.actualizar();
		}
		
	}
}
