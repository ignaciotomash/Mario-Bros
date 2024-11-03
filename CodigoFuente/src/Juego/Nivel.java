package Juego;
import java.util.LinkedList;
import java.util.List;
import Enemigos.Enemigo;
import Entidades.Entidad;
import Mario.BolaDeFuego;
import Mario.Mario;
import Plataformas.Plataforma;
import PowerUps.PowerUp;

public class Nivel {

	protected Mario mario;
	protected List<Plataforma> plataformas;
	protected List<PowerUp> powerUps;
	protected List<Enemigo> enemigos;
	protected List<BolaDeFuego> bolasDeFuego;

	public Nivel() {
		plataformas = new LinkedList<Plataforma>();
		powerUps = new LinkedList<PowerUp>();
		enemigos = new LinkedList<Enemigo>();
		bolasDeFuego = new LinkedList<BolaDeFuego>();
	}
	
	public Mario obtenerMario() {
		return mario;
	}

	public List<Plataforma> obtenerPlataformas(){
		return plataformas;
	}

	public List<PowerUp> obtenerPowerUps(){
		return powerUps;
	}

	public List<Enemigo> obtenerEnemigos(){
		return enemigos;
	}
	
	public List<BolaDeFuego> obtenerBolasDeFuego(){
		return bolasDeFuego;
	}

	public List<Entidad> obtenerEntidades(){
		LinkedList<Entidad> entidades= new LinkedList<Entidad>();
		for(PowerUp powerUp: powerUps)
			entidades.add(powerUp);
		for(Plataforma plataforma: plataformas)
			entidades.add(plataforma);
		for(Enemigo enemigo: enemigos)
			entidades.add(enemigo);
		for (BolaDeFuego bola: bolasDeFuego)
			entidades.add(bola);
		return entidades;

	}

	public void agregarMario(Mario mario) {
		this.mario = mario;

	}

	public void agregarEnemigo(Enemigo enemigo) {
		enemigos.add(enemigo);

	}

	public void agregarPlataforma(Plataforma plataforma) {
		plataformas.add(plataforma);

	}

	public void agregarPowerUp(PowerUp powerUp) {
		powerUps.add(powerUp);
    }
	
	public void agregarBolaDeFuego(BolaDeFuego bolaDeFuego) {
		bolasDeFuego.add(bolaDeFuego);
    }
	
	public void eliminarBolasLanzadas() {
		for (BolaDeFuego bola: bolasDeFuego) {
	    	bola.eliminar();
	    }
		bolasDeFuego.clear();
	}
	
	public void establecerMario(Mario mario) {
		this.mario=mario;
	}

}
