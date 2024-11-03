package Enemigos;

import java.util.LinkedList;

import Entidades.Entidad;

import Fabricas.Sprite;
import Hilos.HiloTiempoEfecto;
import Mario.BolaDeFuego;
import Mario.Mario;
import Mario.Notificable;

public class Lakitu extends Enemigo implements Notificable{

	private static final int CONTENIDO_EN_lAKITU = 2;
	private HiloTiempoEfecto temporizador;
	private LinkedList<Spiny> listaDeSpinys;

	public Lakitu(int posicionX, int posicionY, Sprite[] coleccionSprites, LinkedList<Spiny> spinys) {
		super(posicionX, posicionY, coleccionSprites);
		listaDeSpinys = spinys;
		for(Spiny spiny: listaDeSpinys) {
			spiny.modificarSprite(CONTENIDO_EN_lAKITU);
			spiny.establecerLanzadoPorLakitu(true);
			spiny.establecerDireccion(direccionDeMovimiento);
		}
		temporizador= new HiloTiempoEfecto(this,10000);
		temporizador.iniciarHilo();
	}

	public void efectoFinalizado() {
		lanzarSpiny();
	}

	private void lanzarSpiny() {
		if(!listaDeSpinys.isEmpty()) {
			Spiny spiny = listaDeSpinys.removeFirst();
			spiny.modificarSprite(SPRITE_POR_DEFECTO);
			spiny.establecerDireccion(ABAJO);
			spiny.obtenerObserver().actualizar();
		}
	}

	public void serAfectado(Entidad entidad, String direccion) {
		entidad.afectar(this, direccion);
	}

	public void afectar(Mario mario) {
		mario.eliminarEnemigo(this);
		mario.efectoLakitu();
	}

	public void afectar(Enemigo enemigo) {
		enemigo.efectoLakitu();
	}

	public void efectoBolaDeFuego(BolaDeFuego bolaDeFuego, String direccion) {
		this.eliminar();
		bolaDeFuego.modificarPuntosMario(60);
		bolaDeFuego.eliminar();
	}

	public void efectoSpiny() {}

}
