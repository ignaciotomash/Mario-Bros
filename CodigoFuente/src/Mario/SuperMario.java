package Mario;

import Fabricas.Sprite;
import Plataformas.Plataforma;

public class SuperMario extends MarioState{

	protected final int CAIDA = 130;
	protected final int INMOVIL_DERECHA=12;
	protected final int INMOVIL_IZQUIERDA=13;
	protected final int CAMINANDO_DERECHA=14;
	protected final int CAMINANDO_IZQUIERDA=15;
	protected final int SALTANDO_DERECHA=16;
	protected final int SALTANDO_IZQUIERDA=17;
	protected final int GANANDO = 26;
	
	private int nuevaPosicionY;

	public SuperMario(Mario mario) {
		super(mario);
		nuevaPosicionY = 198;
	}

	public void aplicarSuperChampinion() {
		mario.modificarPuntos(50);		
	}

	public void aplicarEstrella() {
		Invencible nuevoEstado = new Invencible(mario, this);
		mario.cambiarEstado(nuevoEstado);
		mario.modificarPuntos(30);
	}

	public void aplicarFlorDeFuego() {
		MarioFlorDeFuego nuevoEstado = new MarioFlorDeFuego(mario);
		mario.cambiarEstado(nuevoEstado);
        mario.modificarPuntos(30);
	}

	public void aplicarBuzzyBeetle() {
		MarioSimple nuevoEstado = new MarioSimple(mario);
		mario.cambiarEstado(nuevoEstado);
	}

	public void aplicarSpiny() {
		MarioSimple nuevoEstado = new MarioSimple(mario);
		mario.cambiarEstado(nuevoEstado);
	}

	public void aplicarLakitu() {
		MarioSimple nuevoEstado = new MarioSimple(mario);
		mario.cambiarEstado(nuevoEstado);
	}

	public void aplicarPiranhaPlant() {
		MarioSimple nuevoEstado = new MarioSimple(mario);
		mario.cambiarEstado(nuevoEstado);
	}

	public void aplicarGoomba() {
		MarioSimple nuevoEstado = new MarioSimple(mario);
		mario.cambiarEstado(nuevoEstado);
	}

	public void aplicarKoopaTroopa() {
		MarioSimple nuevoEstado = new MarioSimple(mario);
		mario.cambiarEstado(nuevoEstado);
	}

	public void romperBloque(Plataforma plataforma) {
		plataforma.eliminar();
		mario.reproducirSonido("sonidoRomperBloque");
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
	
}