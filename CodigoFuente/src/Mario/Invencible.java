package Mario;

import Entidades.Entidad;
import Fabricas.Sprite;
import Hilos.HiloTiempoEfecto;
import Plataformas.Plataforma;

public class Invencible extends MarioState implements Notificable{

	private static final int CAIDA = 130;
	protected final int INMOVIL_DERECHA = 18;
	protected final int INMOVIL_IZQUIERDA = 19;
	protected final int CAMINANDO_DERECHA = 20;
	protected final int CAMINANDO_IZQUIERDA = 21;
	protected final int SALTANDO_DERECHA = 22;
	protected final int SALTANDO_IZQUIERDA = 23;
	protected final int GANANDO = 26;
	
	private HiloTiempoEfecto temporizador;
	private MarioState estadoAnterior;
	private int nuevaPosicionY;
	
	public Invencible(Mario mario, MarioState estadoAnterior) {
		super(mario);
		this.estadoAnterior=estadoAnterior;

		mario.detenerSonidoFondo();
		mario.reproducirSonidoDeFondo("sonidoEstrella");

		temporizador= new HiloTiempoEfecto(this,8000);
		temporizador.iniciarHilo();
		
		nuevaPosicionY = 193;
	}

	public void aplicarSuperChampinion() {
		mario.modificarPuntos(10);
	}

	public void aplicarEstrella() {
		mario.modificarPuntos(35);
	}

	public void aplicarFlorDeFuego() {
		mario.modificarPuntos(5);
	}

	public void aplicarBuzzyBeetle() {
		mario.modificarPuntos(30); 
	}

	public void aplicarSpiny() {
		mario.modificarPuntos(60);
	}

	public void aplicarLakitu() {
		mario.modificarPuntos(60);
	}

	public void aplicarPiranhaPlant() {
		mario.modificarPuntos(30);
	}

	public void aplicarGoomba() {
		mario.modificarPuntos(60);
	}

	public void aplicarKoopaTroopa() {
		mario.modificarPuntos(90);
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

	public void romperBloque(Plataforma plataforma) {
		plataforma.eliminar();
	}
	
	public void eliminarEnemigo(Entidad entidad) {
		entidad.eliminar();
	}

	public void efectoFinalizado() {
		 mario.cambiarEstado(estadoAnterior);
		 temporizador.detenerHilo();
		 mario.detenerSonidoFondo();
		 mario.reproducirSonidoDeFondo("sonidoFondo");
	}

	public int obtenerCaida() {
		return CAIDA;
	}
	
	public int obtenerNuevoPisoY() {
		return nuevaPosicionY;
	}
	
	public void establecerNuevoPisoY(int pos) {
		nuevaPosicionY = pos;
	}
	
	public void restarVida() {}
	
}

