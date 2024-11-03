package Plataformas;

import Enemigos.Enemigo;
import Entidades.Entidad;
import Fabricas.Sprite;
import Mario.BolaDeFuego;
import Mario.Mario;

public abstract class Plataforma extends Entidad{

	public Plataforma(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
	}

	public void serAfectado(Entidad entidad, String direccion) {
		entidad.afectar(this, direccion);
	}

	public void serAfectado(Mario mario) {
		mario.afectar(this);
	}

	public void afectar(Enemigo enemigo, String direccion) {
		if(direccion == "abajo") {
			enemigo.sobreSueloFirme(true);
			enemigo.establecerDireccion(DERECHA);
		}
	}

	public void efectoBolaDeFuego(BolaDeFuego bolaDeFuego, String direccion) {
		bolaDeFuego.efectoGeneralPlataformas(direccion);
	}

	public void mover() {}

}
