package Mario;

import Fabricas.Sprite;
import Plataformas.Plataforma;

public class MarioSimple extends MarioState{

	protected final int CAIDA = 100; 
	protected final int INMOVIL_DERECHA = 0;
	protected final int INMOVIL_IZQUIERDA = 1;
	protected final int CAMINANDO_DERECHA = 2;
	protected final int CAMINANDO_IZQUIERDA = 3;
	protected final int SALTANDO_DERECHA = 4;
	protected final int SALTANDO_IZQUIERDA = 5;
	protected final int MUERTO = 24;
	protected final int GANANDO = 25;

	private int nuevaPosicionY;
	
	public MarioSimple(Mario mario) {
		super(mario);
		nuevaPosicionY = 153;
	}

	public void aplicarSuperChampinion() {
		SuperMario nuevoEstado = new SuperMario(mario);
		mario.cambiarEstado(nuevoEstado);
		mario.reproducirSonido("sonidoSuperChampinion");
        mario.modificarPuntos(10);
	}

	public void aplicarEstrella() {
		Invencible nuevoEstado = new Invencible(mario,this);
		mario.cambiarEstado(nuevoEstado);
		mario.modificarPuntos(20);
		mario.reproducirSonido("sonidoAgarrarPowerUp");
		mario.reproducirSonido("sonidoEstrella");
	}

	public void aplicarFlorDeFuego() {
		MarioFlorDeFuego nuevoEstado = new MarioFlorDeFuego(mario);
		mario.cambiarEstado(nuevoEstado);
		mario.modificarPuntos(5);
	}

	public void aplicarBuzzyBeetle() {
		mario.modificarPuntos(-15);
		mario.restarVida();
	}

	public void aplicarSpiny() {
		mario.modificarPuntos(-30);
		mario.restarVida();
	}

	public void aplicarLakitu() {
		mario.restarVida();
	}

	public void aplicarPiranhaPlant() {
		mario.modificarPuntos(-30);
		mario.restarVida();
	}

	public void aplicarGoomba() {
		mario.modificarPuntos(-30);
		mario.restarVida();
	}

	public void aplicarKoopaTroopa() {
		mario.modificarPuntos(-45);
		mario.restarVida();
	}

	public Sprite obtenerSpriteInmovilDerecha() {
		Sprite[] arregloSprites=mario.obtenerColeccionSprites();
		return arregloSprites[INMOVIL_DERECHA];
	}

	public Sprite obtenerSpriteInmovilIzquierda() {
		Sprite[] arregloSprites=mario.obtenerColeccionSprites();
		return arregloSprites[INMOVIL_IZQUIERDA];
	}

	public Sprite obtenerSpriteCaminandoDerecha() {
		Sprite[] arregloSprites=mario.obtenerColeccionSprites();
		return arregloSprites[CAMINANDO_DERECHA];
	}

	public Sprite obtenerSpriteCaminandoIzquierda() {
		Sprite[] arregloSprites=mario.obtenerColeccionSprites();
		return arregloSprites[CAMINANDO_IZQUIERDA];
	}

	public Sprite obtenerSpriteSaltandoDerecha() {
		Sprite[] arregloSprites=mario.obtenerColeccionSprites();
		return arregloSprites[SALTANDO_DERECHA];
	}

	public Sprite obtenerSpriteSaltandoIzquierda() {
		Sprite[] arregloSprites=mario.obtenerColeccionSprites();
		return arregloSprites[SALTANDO_IZQUIERDA];
	}

	public Sprite obtenerSpriteGanando() {
		Sprite[] arregloSprites=mario.obtenerColeccionSprites();
		return arregloSprites[GANANDO];
	}

	public Sprite obtenerSpriteYendose() {
		Sprite[] arregloSprites=mario.obtenerColeccionSprites();
		return arregloSprites[CAMINANDO_DERECHA];
	}

	public int obtenerNuevoPisoY() {
		return nuevaPosicionY;
	}
	
	public void establecerNuevoPisoY(int pos) {
		nuevaPosicionY = pos;
	}

	public int obtenerCaida() {
		return CAIDA;
	}
	
	public void romperBloque() {}
	
	public void romperBloque(Plataforma plataforma) {}

}
