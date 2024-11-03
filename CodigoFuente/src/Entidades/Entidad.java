package Entidades;

import Enemigos.Enemigo;
import Fabricas.Sprite;
import Mario.BolaDeFuego;
import Mario.Mario;
import Plataformas.Plataforma;
import PowerUps.PowerUp;
import Sonido.Sonido;
import Vistas.Observer;
import Vistas.PantallaJuego;

public abstract class Entidad implements EntidadLogica{

	protected static final char DERECHA = 'd';
	protected static final char IZQUIERDA = 'i';
	protected static final char ARRIBA = 'a';
	protected static final char INMOVIL = 'z';
	protected static final char ABAJO = 'x';
	protected static final int SPRITE_POR_DEFECTO = 0;
	protected static final int SUELO_DE_LA_ENTIDAD = 153;

	protected int posicionX;
	protected int posicionY;
	protected int posicionInicialX;
	protected int posicionInicialY;
	protected double velocidadX;
	protected double velocidadY;
	protected char direccionDeMovimiento;
	protected boolean sobreSueloFirme;
	protected boolean eliminada;
	protected Observer observer;
	protected Sprite sprite;
	protected Sprite[] coleccionSprites;
	protected Sonido sonido;
	protected boolean sobrePlataforma;
	protected double gravedad;

	public Entidad(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		posicionInicialX = posicionX;
		posicionInicialY = posicionY;
		this.coleccionSprites = coleccionSprites;
		sprite = coleccionSprites[SPRITE_POR_DEFECTO];
		eliminada = false;
		velocidadX = 1;
		velocidadY = 3;
		direccionDeMovimiento= DERECHA;
		gravedad = 0.5;
		sobreSueloFirme = true;
		sobrePlataforma = false;
	}

	public void modificarSprite(int posicion) {
		sprite = coleccionSprites[posicion];
	}

	public int obtenerPosicionX() {
		return posicionX;
	}

	public int obtenerPosicionY() {
		return posicionY;
	}

	public double obtenerVelocidadX() {
		return velocidadX;
	}

	public double obtenerVelocidadY() {
		return velocidadY;
	}

	public Sprite obtenerSprite() {
		return sprite;
	}

	public Sprite[] obtenerColeccionSprites() {
		return coleccionSprites;
	}

	public Sonido obtenerSonido() {
		return sonido;
	}

	public boolean enSueloFirme() {
		return sobreSueloFirme;
	}

	public boolean estaEliminada() {
		return  eliminada;
	}

	public char obtenerDireccionDeMovimiento() {
		return direccionDeMovimiento;
	}

	public void establecerPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}

	public void establecerPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}

	public void establecerVelocidadX(int velocidadX) {
		this.velocidadX = velocidadX;
	}

	public void establecerVelocidadY(int velocidadY) {
		this.velocidadY = velocidadY;
	}

	public void establecerDireccion(char direccionDeMovimiento) {
		this.direccionDeMovimiento = direccionDeMovimiento;
	}

	public void sobreSueloFirme(boolean sobreSueloFirme) {
		this.sobreSueloFirme = sobreSueloFirme;
	}

	public void eliminar() {
		eliminada = true;
		observer.actualizar();
	}

	public void establecerSonido(Sonido sonido) {
		this.sonido = sonido;
	}

	public void registrarObserver(Observer observer) {
		this.observer = observer;
		observer.actualizar();
	}

	public Observer obtenerObserver() {
		return observer;
	}

	public void mover() {

		if (direccionDeMovimiento == DERECHA) {
			posicionX += velocidadX;
			observer.actualizarPosicion();
		}

		if (direccionDeMovimiento == IZQUIERDA) {
			posicionX -= velocidadX;
			observer.actualizarPosicion();
		}

		if (direccionDeMovimiento == ARRIBA) {
			posicionY += velocidadY;
			observer.actualizarPosicion();
		}

		if(!sobrePlataforma && !sobreSueloFirme) 
			direccionDeMovimiento = ABAJO;

		if(sobrePlataforma) 
			sobreSueloFirme = false;

		if (direccionDeMovimiento == ABAJO && !sobrePlataforma) {

			sobrePlataforma = false;
			sobreSueloFirme = false;
			posicionY -= velocidadY;
			observer.actualizarPosicion();

			if(posicionY <= SUELO_DE_LA_ENTIDAD) {
				sobreSueloFirme = true;
				posicionY = SUELO_DE_LA_ENTIDAD;
				direccionDeMovimiento = DERECHA;
			}

		}

		if(sobrePlataforma) 
			direccionDeMovimiento = DERECHA;
	}

	public void establecerPosicionInicial() {
		posicionX = posicionInicialX;
		posicionY = posicionInicialY;
		observer.actualizar();
	}

	public void reiniciar() {
		eliminada = false;
		establecerPosicionInicial();
		direccionDeMovimiento = DERECHA;
		observer.reiniciar();
		observer.actualizar();
	}

	public boolean estaSobrePlataforma() {
		return sobrePlataforma;
	}

	public boolean estaSobreSueloFirme() {
		return sobreSueloFirme;
	}

	public void sobrePlataforma(boolean sobrePlataforma) {
		this.sobrePlataforma = sobrePlataforma;
	}

	public void restarVida() {}

	protected void actualizarSpriteDerecha() {} 

	protected void actualizarSpriteIzquierda() {}

	public void serAfectado(Entidad entidad) {}

	public void serAfectado(Mario mario) {}

	public void serAfectado(Entidad entidad, String direccion) {}

	public void afectar(Mario mario) {}

	public void afectar(Mario mario, String direccion) {}

	public void afectar(Plataforma plataforma) {}

	public void afectar(Plataforma plataforma, String direccion) {}

	public void afectar(PowerUp powerUp) {}

	public void afectar(PowerUp powerUp, String direccion) {}

	public void afectar(Entidad entidad) {}

	public void afectar(Enemigo enemigo) {}

	public void afectar(Enemigo enemigo, String direccion) {}

	public void efectoMario(Mario mario) {}

	public void afectar(BolaDeFuego bolaDeFuego, String direccion) {}

	public void efectoSuperChampinion() {}

	public void efectoEstrella() {}

	public void efectoFlorDeFuego() {}

	public void efectoChampinionVerde() {}

	public void efectoBloqueDePregunta() {}

	public void efectoMoneda() {}

	public void efectoTuberia() {}

	public void efectoBloqueSolido() {}

	public void efectoLadrilloSolido() {}

	public void efectoVacio() {}

	public void efectoBuzzyBeetle() {}

	public void efectoSpiny() {}

	public void efectoLakitu() {}

	public void efectoPiranhPlant() {}

	public void efectoGoomba() {}

	public void efectoKoopaTroopa() {}

	public void efectoBolaDeFuego(BolaDeFuego bolaDeFuego, String direccion) {}

	public void deshacerColision() {}

	public void establecerPosicionAnteriorY(int obtenerPosicionY) {}
}
