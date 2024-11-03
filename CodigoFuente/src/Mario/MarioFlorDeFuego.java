package Mario;

import Fabricas.Sprite;

public class MarioFlorDeFuego extends SuperMario{
	
	protected final int INMOVIL_DERECHA = 6;
	protected final int INMOVIL_IZQUIERDA = 7;
	protected final int CAMINANDO_DERECHA = 8;
	protected final int CAMINANDO_IZQUIERDA = 9;
	protected final int SALTANDO_DERECHA = 10;
	protected final int SALTANDO_IZQUIERDA = 11;
	protected final int GANANDO = 27;	
    private long ultimoLanzamiento;

    
	public MarioFlorDeFuego(Mario mario) {
		super(mario);
		ultimoLanzamiento=0;

	}
	
	public void tirarBolaDeFuego() {
		long tiempoActual = System.currentTimeMillis();
		if(tiempoActual-ultimoLanzamiento>=1000) {
		  ultimoLanzamiento=tiempoActual;
		  mario.tirarBolaDeFuego();
		}
	}
	
	public void aplicarEstrella() {
		Invencible nuevoEstado = new Invencible(mario, this);
		mario.cambiarEstado(nuevoEstado);
		mario.modificarPuntos(30);
	}
	
	public void aplicarFlorDeFuego() {
        mario.modificarPuntos(50);
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
	
	public int indiceDeSpriteDeMarioGanando() {
		return GANANDO;
	}

	public int indiceDeSpriteDeMarioYendose() {
		return CAMINANDO_DERECHA;
	}

}
