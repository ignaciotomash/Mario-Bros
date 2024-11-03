package Mario;

import Enemigos.Enemigo;
import Entidades.Entidad;
import Entidades.EntidadMario;
import Fabricas.Sprite;
import Juego.Juego;
import Plataformas.Plataforma;
import PowerUps.PowerUp;
import Sonido.Sonido;

public class Mario extends Entidad implements EntidadMario{

	private static final int LIMITE_NIVEL_GANAR = 5050;
	private static final int BANDERA_FINAL = 4605;
	private static final int POSICION_DE_CAIDA_LIBRE = 0;

	private int vidas;
	private int monedas;
	private int puntos;
	private MarioState estadoDeMario;
	private double alturaSalto; 
	private char direccionAnterior;
	private int posicionAnteriorY;
	private Sonido sonido;
	private boolean muerto;
	private Juego juego;

	public Mario(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
		vidas = 3;
		monedas = 0;
		puntos = 0;
		estadoDeMario = new MarioSimple(this);
		direccionDeMovimiento = INMOVIL;
		direccionAnterior = DERECHA;
		alturaSalto = 15;
		velocidadX = 5;
		velocidadY = 0; 
		sobreSueloFirme = true;
		sobrePlataforma = false;
		sonido=Sonido.obtenerInstancia();
		gravedad = 0.5;
		muerto = false;
	}

	public int obtenerVidas() {
		return vidas;
	}

	public int obtenerPuntos() {
		return puntos;
	}

	public int obtenerMonedas() {
		return monedas;
	}

	public int obtenerPosicionAnteriorY() {
		return posicionAnteriorY;
	}

	public void establecerPosicionInicial() {
		posicionX = posicionInicialX;
		posicionY = posicionInicialY;
		establecerDireccion(INMOVIL);
		observer.actualizar();
	}

	public boolean estaSobrePlataforma() {
		return sobrePlataforma;
	}

	public void sumarVida() {
		vidas++;
	}

	public void restarVida() {
		vidas--;
		muerto = true;
		detenerSonidoFondo();
		if (vidas == 0) 
			juego.finalizoPartida(true); 
		juego.reiniciar();
	}

	public void reiniciarPosicionMario() {
		estadoDeMario = new MarioSimple(this);
		muerto = false;
		sprite = coleccionSprites[0];
		establecerPosicionInicial();
		observer.actualizar();
	}

	public void modificarPuntos(int puntos) {
		this.puntos += puntos;
	}

	public void sumarMoneda() {
		monedas++;
		if (monedas==0) {
			monedas=0;
			vidas++;
		}
	}

	public void activarBolaDeFuego() {
		estadoDeMario.tirarBolaDeFuego();
	}

	public void tirarBolaDeFuego() {
		reproducirSonido("sonidoBolaDeFuego");
		juego.generarBolaDeFuego(posicionX+25, posicionY-50, direccionAnterior);
	}

	public void establecerPosicionAnteriorY(int posicionAnteriorY) {
		this.posicionAnteriorY=posicionAnteriorY;
	}

	public void establecerDireccion(char direccionDeMovimiento) {

		if(this.direccionDeMovimiento != direccionDeMovimiento) {
			sprite = cambiarSprite(direccionDeMovimiento);
			this.direccionDeMovimiento = direccionDeMovimiento;
			observer.actualizar();
		}
	}


	private Sprite cambiarSprite(char direccion) {
		Sprite nuevoSprite = null;
		if(direccion == INMOVIL) {
			nuevoSprite = cambiarSpriteInmovil();
		}
		if(direccion == DERECHA) {
			direccionAnterior= DERECHA;
			nuevoSprite = cambiarSpriteDerecha();
		}
		if(direccion == IZQUIERDA) {
			direccionAnterior =IZQUIERDA;
			nuevoSprite = cambiarSpriteIzquierda();
		}
		if(direccion == ARRIBA) {
			nuevoSprite = cambiarSpriteArriba();
		}
		return nuevoSprite;
	}

	private Sprite cambiarSpriteInmovil() {
		Sprite nuevoSprite = null;
		switch(direccionDeMovimiento) {
		case INMOVIL:
			if(direccionAnterior == DERECHA)
				nuevoSprite = estadoDeMario.obtenerSpriteInmovilDerecha();
			else 
				nuevoSprite = estadoDeMario.obtenerSpriteInmovilIzquierda();
			break;
		case DERECHA:
			nuevoSprite = estadoDeMario.obtenerSpriteInmovilDerecha();
			break;
		case IZQUIERDA:
			nuevoSprite = estadoDeMario.obtenerSpriteInmovilIzquierda();
			break;
		case ARRIBA:
			if(direccionAnterior == DERECHA)
				nuevoSprite = estadoDeMario.obtenerSpriteInmovilDerecha();
			else 
				nuevoSprite = estadoDeMario.obtenerSpriteInmovilIzquierda();
			break;
		}
		return nuevoSprite;
	}

	private Sprite cambiarSpriteYendose() {
		Sprite nuevoSprite = null;
		nuevoSprite = estadoDeMario.obtenerSpriteYendose();
		return nuevoSprite; 
	}

	private Sprite cambiarSprtieGanando() {
		Sprite nuevoSprite = null;
		nuevoSprite = estadoDeMario.obtenerSpriteGanando();
		return nuevoSprite; 
	}

	private Sprite cambiarSpriteDerecha() {
		Sprite nuevoSprite = null;
		switch(direccionDeMovimiento) {
		case INMOVIL:
			nuevoSprite = estadoDeMario.obtenerSpriteCaminandoDerecha();
			break;
		case IZQUIERDA:
			nuevoSprite = estadoDeMario.obtenerSpriteCaminandoDerecha();
			break;
		case ARRIBA:
			nuevoSprite = estadoDeMario.obtenerSpriteSaltandoDerecha(); 
			break;
		case DERECHA:
			nuevoSprite = estadoDeMario.obtenerSpriteCaminandoDerecha(); 
			break;
		}
		return nuevoSprite;
	}

	private Sprite cambiarSpriteIzquierda() {
		Sprite nuevoSprite = null;
		switch(direccionDeMovimiento) {
		case INMOVIL:
			nuevoSprite = estadoDeMario.obtenerSpriteCaminandoIzquierda();
			break;
		case DERECHA:
			nuevoSprite = estadoDeMario.obtenerSpriteCaminandoIzquierda();
			break;
		case ARRIBA:
			nuevoSprite = estadoDeMario.obtenerSpriteSaltandoIzquierda();
			break;
		case IZQUIERDA:
			nuevoSprite = estadoDeMario.obtenerSpriteCaminandoIzquierda();
			break;
		}
		return nuevoSprite;
	}

	public Sprite cambiarSpriteArriba() {
		Sprite nuevoSprite = null;
		switch(direccionDeMovimiento) {
		case INMOVIL:
			if(direccionAnterior == DERECHA)
				nuevoSprite = estadoDeMario.obtenerSpriteSaltandoDerecha();
			else 
				nuevoSprite = estadoDeMario.obtenerSpriteSaltandoIzquierda();
			break;
		case IZQUIERDA:
			nuevoSprite = estadoDeMario.obtenerSpriteSaltandoIzquierda();
			break;
		case DERECHA:
			nuevoSprite = estadoDeMario.obtenerSpriteSaltandoDerecha();
			break;
		case ARRIBA:
			if(direccionAnterior == DERECHA)
				nuevoSprite = estadoDeMario.obtenerSpriteSaltandoDerecha();
			else 
				nuevoSprite = estadoDeMario.obtenerSpriteSaltandoIzquierda();
			break;
		}
		return nuevoSprite;
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

			if (sobreSueloFirme || sobrePlataforma) {
				reproducirSonido("sonidoMarioSimpleSalta");
				velocidadY = alturaSalto; 
				sobreSueloFirme = false;
				sobrePlataforma = false;
			}

			observer.actualizarPosicion();
		}

		if (!sobreSueloFirme && !sobrePlataforma) {
			velocidadY -= gravedad; 
			posicionY += velocidadY; 
			observer.actualizarPosicion();
		}

		if (posicionY <= estadoDeMario.obtenerNuevoPisoY() && !sobrePlataforma) { 
			posicionY = estadoDeMario.obtenerNuevoPisoY();
			sobreSueloFirme = true;
			sobrePlataforma = false;
			observer.actualizarPosicion();
		}  

		if (direccionDeMovimiento == INMOVIL && (sobreSueloFirme || sobrePlataforma) ) 
			observer.actualizarPosicion();

		if(cayoEnElVacio()) 
			estadoDeMario.marioCayoAlVacio();
		
		if(muerto) 
			caer();

		if(posicionX == BANDERA_FINAL) 
			animacionDeGanar();

		if(posicionX == LIMITE_NIVEL_GANAR) {
			juego.cambiarNivel();

		}
	}

	private void animacionDeGanar() {

		boolean descendio = false;
		if(!descendio) 
			agarrarseDeLaBandera();

		if(!descendio && posicionY > estadoDeMario.obtenerNuevoPisoY()) {
			descenderMastil();
		}
		descendio = (posicionY <= estadoDeMario.obtenerNuevoPisoY());

		if(descendio) 
			caminarHastaElFinDelMapa();
	}

	private void agarrarseDeLaBandera() {
		observer.actualizar();
		sprite = cambiarSprtieGanando();
		posicionX = BANDERA_FINAL;
		direccionDeMovimiento = INMOVIL;
		velocidadX = 0;
	}

	private void descenderMastil() {
		posicionY -= (velocidadY + 1);
	}

	private void caminarHastaElFinDelMapa() {
		velocidadX = 5;
		detenerSonidoFondo();
		reproducirSonido("sonidoGanaNivel");
		sprite = cambiarSpriteYendose();
		observer.actualizar();
		direccionDeMovimiento = DERECHA;
		reproducirSonido("sonidoMarioBajaMastil");
	}
	
	private boolean cayoEnElVacio() {
		return posicionY <= POSICION_DE_CAIDA_LIBRE;
	}

	public void cambiarEstado(MarioState estadoDeMario) {
		this.estadoDeMario = estadoDeMario;

		if(sobreSueloFirme) 
			posicionY = estadoDeMario.obtenerNuevoPisoY();

		else posicionY += 52;

		sprite = cambiarSprite(direccionDeMovimiento);
		observer.actualizar();
	}

	public void serAfectado(Entidad entidad, String direccion) {
		entidad.afectar(this, direccion);
	}

	public void serAfectado(Entidad entidad) {
		entidad.afectar(this);
	}

	public void afectar(Plataforma plataforma) {
		plataforma.efectoMario(this);
	}

	public void afectar(PowerUp powerUp) {
		powerUp.efectoMario(this);
	}

	public void afectar(Enemigo enemigo) {
		enemigo.efectoMario(this);
	}

	public void efectoChampinionVerde() {
		vidas++;
	}

	public void efectoMoneda() {
		monedas++;
		puntos += 5;
	}

	public void efectoEstrella(){
		estadoDeMario.aplicarEstrella();
	}

	public void efectoFlorDeFuego() {
		estadoDeMario.aplicarFlorDeFuego();
	}

	public void efectoSuperChampinion() {
		estadoDeMario.aplicarSuperChampinion();
	}

	public void efectoBloqueDePregunta(String direccion) {
		estadoDeMario.aplicarBloqueDePregunta(direccion);
	}

	public void efectoTuberia(String direccion){
		estadoDeMario.aplicarTuberia(direccion);
	}

	public void efectoBloqueSolido(String direccion) {
		estadoDeMario.aplicarBloqueSolido(direccion);
	}

	public void efectoLadrilloSolido(String direccion) {
		estadoDeMario.aplicarLadrilloSolido(direccion);;
	}

	public void efectoVacio(String direccion) {
		estadoDeMario.aplicarVacio(direccion);
	}

	public void efectoBuzzyBeetle() {
		estadoDeMario.aplicarBuzzyBeetle();
	}

	public void efectoSpiny() {
		estadoDeMario.aplicarSpiny();
	}

	public void efectoLakitu() {
		estadoDeMario.aplicarLakitu();
	}

	public void efectoPiranhPlant() {
		estadoDeMario.aplicarPiranhaPlant();
	}

	public void efectoGoomba() {
		estadoDeMario.aplicarGoomba();
	}

	public void efectoKoopaTroopa() {
		estadoDeMario.aplicarKoopaTroopa();
	}

	public void rebotar() {
		velocidadY = alturaSalto-5; 
	}

	public void caer() {
		posicionY -= velocidadY; 
		observer.actualizarPosicion();
	}

	public void sobreSueloFirme(boolean sobreSueloFirme) {
		if(!sobreSueloFirme && this.posicionY != estadoDeMario.obtenerNuevoPisoY())
			this.sobreSueloFirme = false;
		else
			if(sobreSueloFirme)
				this.sobreSueloFirme=true;
	}

	public void sobrePlataforma(boolean sobrePlataforma) {
		this.sobrePlataforma = sobrePlataforma;
	}

	public int obtenerPosicionDelSuelo() {
		return estadoDeMario.obtenerNuevoPisoY();
	}

	public void romperBloque(Plataforma plataforma) {
		estadoDeMario.romperBloque(plataforma);
	}

	public void eliminarEnemigo(Entidad entidad) {
		estadoDeMario.eliminarEnemigo(entidad);
	}

	public void establecerJuego(Juego juego) {
		this.juego = juego;
	}

	public void estaMuerto(boolean muerto) {
		this.muerto = muerto;
	}
	public void reproducirSonido(String nombreSonido) {
		sonido.reproducirSonidoEfecto(nombreSonido);
	}
	public void reproducirSonidoDeFondo(String nombreSonido) {
		sonido.reproducirSonidoFondo(nombreSonido);
	}
	public void detenerSonidoFondo() {
		sonido.detenerSonidoFondo();
	}
}