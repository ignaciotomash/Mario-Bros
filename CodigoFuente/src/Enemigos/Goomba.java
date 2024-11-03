package Enemigos;

import Entidades.Entidad;
import Fabricas.Sprite;
import Mario.BolaDeFuego;
import Mario.Mario;

public class Goomba extends Enemigo{

	public Goomba(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
	}

	public void afectar(Mario mario) {
		mario.eliminarEnemigo(this);
		mario.efectoGoomba();
	}

	public void afectar(Enemigo enemigo) {
		enemigo.efectoGoomba();
	}
	
	public void serAfectado(Entidad entidad, String direccion) {
		entidad.afectar(this, direccion);
	}

	public void efectoMario(Mario mario) {
		mario.reproducirSonido("sonidoCaerSobreGoomba");
		mario.modificarPuntos(60);
		eliminar();
		mario.rebotar();
	}
    
	public void efectoBolaDeFuego(BolaDeFuego bolaDeFuego, String direccion) {
		this.eliminar();
		bolaDeFuego.modificarPuntosMario(60);
		bolaDeFuego.eliminar();
	}
}
