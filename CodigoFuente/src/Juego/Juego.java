package Juego;

import java.util.List;

import Entidades.Entidad;
import Fabricas.FabricaEntidades;
import Fabricas.FabricaSprite;
import Fabricas.FabricaSpriteAlternativo;
import Fabricas.FabricaSpriteOriginal;
import Hilos.*;
import Mario.BolaDeFuego;
import Mario.Mario;
import Parser.GeneradorNivel;
import Sonido.Sonido;
import Vistas.ControladorVistas;
import Vistas.Observer;

public class Juego {

	private static final String NIVEL_1 = "./src/Parser/Nivel_1";
	private static final String NIVEL_2 = "./src/Parser/Nivel_2";
	private static final String NIVEL_3 = "./src/Parser/Nivel_3";

	protected ControladorVistas controladorVistas;
	protected FabricaEntidades fabricaEntidades;
	protected FabricaSprite fabricaSprite;
	protected GeneradorNivel generadorNivel;
	protected Nivel nivel;
	protected int nivelActual;
	protected DetectorColisiones detectorColisiones;
	protected Sonido sonido;
	protected HiloMario hiloMario;
	protected HiloEntidades hiloEntidades;
	protected HiloTiempoDeJuego hiloTiempoDeJuego;
	protected int tiempoDeJuego;
	protected boolean juegoTerminado;
	protected Mario mario;

	public Juego() {
		sonido = Sonido.obtenerInstancia();
		detectorColisiones = new DetectorColisiones();
		juegoTerminado = false;
		tiempoDeJuego = 400;
		nivelActual = 1;
	}

	public void establecerControladorVistas(ControladorVistas controladorVistas){
		this.controladorVistas=controladorVistas;
	}

	public int obtenerNivelActual() {
		return nivelActual;
	}

	public int obtenerPuntosMario() {
		return mario.obtenerPuntos();
	}

	public ControladorVistas obtenerControladorVistas() {
		return controladorVistas;
	}

	public void iniciarModoOriginal() {
		fabricaSprite = new FabricaSpriteOriginal();
		fabricaEntidades = new FabricaEntidades(fabricaSprite);
		generadorNivel = new GeneradorNivel(fabricaEntidades);
		controladorVistas.establecerFondoOriginal();
		this.iniciar();
	}

	public void iniciarModoAlternativo() {
		fabricaSprite = new FabricaSpriteAlternativo();
		fabricaEntidades = new FabricaEntidades(fabricaSprite);
		generadorNivel = new GeneradorNivel(fabricaEntidades);
		controladorVistas.establecerFondoAlternativo();
		this.iniciar();
	}

	private void iniciar() {
        nivel= generadorNivel.cargarNivel(NIVEL_1);
		registrarObservers();
		controladorVistas.mostrarPantallaJuego();
		sonido.reproducirSonidoFondo("sonidoFondo");
		this.crearHilos();
		mario = nivel.obtenerMario();
		mario.establecerJuego(this);
		this.iniciarHilos();
	}

	private void iniciarHilos() {
		hiloMario.iniciar();
		hiloEntidades.iniciar();
		hiloTiempoDeJuego.iniciar();
	}
	
	private void crearHilos() {
		hiloMario = new HiloMario(this);
		hiloEntidades = new HiloEntidades(this);
		hiloTiempoDeJuego = new HiloTiempoDeJuego(this);
	}

	private void registrarObservers() {
		registrarObserverMario(nivel.obtenerMario());
		registrarObserverEntidad(nivel.obtenerEntidades());
	}

	private void registrarObserverMario(Mario mario) {
		Observer observerMario= controladorVistas.registrarEntidadMario(mario);
		mario.registrarObserver(observerMario);
	}

	private void registrarObserverEntidad(List<Entidad> entidades) {
		for(Entidad entidad:entidades) {
			Observer observer = controladorVistas.registrarEntidad(entidad);
			entidad.registrarObserver(observer);
		}
	}

	private void detenerHilos() {
		hiloMario.detener();
		hiloEntidades.detener();
		hiloTiempoDeJuego.detener();
	}

	public void cambiarNivel(){
		eliminarEntidades();
		sonido.reproducirSonidoFondo("sonidoFondo");
		if(nivelActual == 1 || nivelActual == 2) {
			detenerHilos();
			nivelActual ++;

			if(nivelActual == 2)
				nivel = generadorNivel.cargarNivel(NIVEL_2);

			else if (nivelActual == 3)
				nivel = generadorNivel.cargarNivel(NIVEL_3);

			registrarObserverEntidad(nivel.obtenerEntidades());
			nivel.establecerMario(mario);
			mario.establecerPosicionInicial();
			hiloMario.reiniciar();
			hiloEntidades = new HiloEntidades(this);
			hiloEntidades.iniciar();
			hiloTiempoDeJuego = new HiloTiempoDeJuego(this);
			hiloTiempoDeJuego.iniciar();
		}
		
		else if (nivelActual == 3) {
			eliminarEntidades();
			detenerHilos();
			sonido.detenerSonidoEfecto();
			sonido.detenerSonidoFondo();
			juegoTerminado();
		}
		
	} 

	private void juegoTerminado() {
		controladorVistas.mostrarPantallaGanadora();
	}

	public void moverMario() {
		mario.mover();
	}

	public void establecerDireccionMario(char direccion) {
		mario.establecerDireccion(direccion);
	}

	public void activarBolaDeFuego() {
		mario.activarBolaDeFuego();
	}

	public void generarBolaDeFuego(int posicionX, int posicionY, char direccion) {
		BolaDeFuego bolaDeFuego=fabricaEntidades.crearBolaDeFuego(posicionX, posicionY);
		bolaDeFuego.establecerMario(mario);
		bolaDeFuego.establecerDireccion(direccion);
		Observer observer= controladorVistas.registrarEntidad(bolaDeFuego);
		bolaDeFuego.registrarObserver(observer);
		nivel.agregarBolaDeFuego(bolaDeFuego);
	}

	public void detectarColisionesMario() {
		detectorColisiones.detectarColisionesMarioPlataformas(nivel);
		detectorColisiones.detectarColisionesMarioEnemigos(nivel);
		detectorColisiones.detectarColisionesMarioPowerUps(nivel);
	}

	public void detectarColisionesEntidades() {
		detectorColisiones.detectarColisionesEntidadesPlataformas(nivel);
		detectorColisiones.detectarColisionesEntidadesBolasDeFuego(nivel);
		detectorColisiones.detectarColisionesEnemigoConEnemigo(nivel);
	}
	
	public void actualizarEntidades() {
		for(Entidad entidad : nivel.obtenerEntidades()) {
			if (!entidad.estaEliminada()) {
				entidad.mover();
			}
		}
	}

	public void eliminarEntidades() {
		for(Entidad entidad : nivel.obtenerEntidades()) {
			if(!entidad.estaEliminada())
				entidad.eliminar();
		}
	}

	public void reiniciarNivel() {
		mario.estaMuerto(false);
		mario.reiniciarPosicionMario();
		for(Entidad entidad: nivel.obtenerEntidades()) {
			entidad.reiniciar();
		}
		sonido.reproducirSonidoFondo("sonidoFondo");
	}

	public void reiniciar() {
		controladorVistas.obtenerPantallaJuego().reiniciarScroll();
		nivel.eliminarBolasLanzadas();
		if (juegoTerminado)
			this.juegoFinalizado();
		else
			this.reiniciarNivel();
	}
	
	public void reiniciarJuegoOriginal() {
		generadorNivel.establecerSpriteOriginal();
		mario.eliminar();
		mario.obtenerObserver().actualizar();
		controladorVistas.establecerFondoOriginal();
		this.reiniciarJuego();
	}
	
	public void reiniciarJuegoAlternativo() {
		generadorNivel.establecerSpriteAlternativa();
		mario.eliminar();
		mario.obtenerObserver().actualizar();
		controladorVistas.establecerFondoAlternativo();
		this.reiniciarJuego();
	}
	
	private void reiniciarJuego() {
		juegoTerminado=false;
		this.eliminarEntidades();
		nivel=generadorNivel.cargarNivel(NIVEL_1);
		nivelActual=1;
		tiempoDeJuego = 400;
		mario=nivel.obtenerMario();
		registrarObserverMario(mario);
		mario.establecerJuego(this);
		registrarObserverEntidad(nivel.obtenerEntidades());
		controladorVistas.mostrarPantallaJuego();
		this.crearHilos();
		this.iniciarHilos();
		sonido.reproducirSonidoFondo("sonidoFondo");
	}
	
	public void juegoFinalizado() {
		detenerHilos();
		controladorVistas.mostrarPantallaGameOver();
		sonido.detenerSonidoFondo();
		sonido.reproducirSonidoEfecto("sonidoGameOver");
	}

	public HiloMario obtenerHiloMario() {
		return hiloMario;
	}

	public void actualizarTiempo() {
		tiempoDeJuego--;
		controladorVistas.actualizarInformacionTiempo(tiempoDeJuego);
		if(tiempoDeJuego==0) {
			juegoTerminado=true;
			this.reiniciar();
		}
	}

	public void finalizoPartida(boolean Juegoterminado) {
		this.juegoTerminado=Juegoterminado;
	}

	public boolean terminoJuego() {
		return juegoTerminado;
	}

}
