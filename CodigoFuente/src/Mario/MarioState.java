package Mario;

import Entidades.Entidad;
import Fabricas.Sprite;
import Plataformas.Plataforma;

public abstract class MarioState {

	private static final int CAIDA_LIBRE = 0;

	protected Mario mario;

	public MarioState(Mario mario) {
		this.mario = mario;
	}

	public void tirarBolaDeFuego() {
	}

	public void eliminarEnemigo(Entidad entidad) {
	}


	abstract public Sprite obtenerSpriteInmovilDerecha();
	abstract public Sprite obtenerSpriteInmovilIzquierda();
	abstract public Sprite obtenerSpriteCaminandoDerecha();
	abstract public Sprite obtenerSpriteCaminandoIzquierda();
	abstract public Sprite obtenerSpriteSaltandoDerecha();
	abstract public Sprite obtenerSpriteSaltandoIzquierda();
	abstract public Sprite obtenerSpriteGanando();
	abstract public Sprite obtenerSpriteYendose();
	abstract public void aplicarSuperChampinion();
	abstract public void aplicarEstrella();
	abstract public void aplicarFlorDeFuego();
	abstract public void aplicarBuzzyBeetle();
	abstract public void aplicarSpiny();
	abstract public void aplicarLakitu();
	abstract public void aplicarPiranhaPlant();
	abstract public void aplicarGoomba();
	abstract public void aplicarKoopaTroopa();
	abstract public void romperBloque(Plataforma plataforma);
	abstract public int obtenerNuevoPisoY();
	abstract public void establecerNuevoPisoY(int pos);
	abstract public int obtenerCaida();

	public void aplicarBloqueDePregunta(String direccion) {
		efectoGeneralDeBloque(direccion);
	}

	public void aplicarTuberia(String direccion) { 
		efectoGeneralDeBloque(direccion);
	}

	public void aplicarBloqueSolido(String direccion) {
		efectoGeneralDeBloque(direccion);
	}

	public void aplicarLadrilloSolido(String direccion) {
		efectoGeneralDeBloque(direccion);
	}

	private void efectoGeneralDeBloque(String direccion) {
		int posicionAnteriorX = mario.obtenerPosicionX();

		if (direccion == "derecha")
			mario.establecerPosicionX(posicionAnteriorX - 5);

		if (direccion == "izquierda")
			mario.establecerPosicionX(posicionAnteriorX + 5);

		if(direccion == "arriba" && !mario.enSueloFirme())
			mario.establecerVelocidadY(-5);

		if(direccion == "abajo" && !mario.enSueloFirme()) 
			mario.sobrePlataforma(true);
	}

	public void aplicarVacio(String direccion) {

		if(direccion == "abajo" || direccion == "izquierda" || direccion == "derecha") {
			establecerNuevoPisoY(CAIDA_LIBRE);
			mario.sobreSueloFirme(false);
			mario.sobrePlataforma(false);
			mario.caer();
		}

	}
	
	public void marioCayoAlVacio() {
		mario.modificarPuntos(-15);
		mario.restarVida();
	}

}