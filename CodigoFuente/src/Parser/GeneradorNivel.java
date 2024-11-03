package Parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import Enemigos.Spiny;
import Fabricas.FabricaEntidades;
import Fabricas.FabricaSprite;
import Fabricas.FabricaSpriteAlternativo;
import Fabricas.FabricaSpriteOriginal;
import Juego.Nivel;
import PowerUps.PowerUp;

public class GeneradorNivel {

	private static final FabricaSprite FABRICA_ORIGINAL= new FabricaSpriteOriginal();
	private static final FabricaSprite FABRICA_ALTERNATIVA= new FabricaSpriteAlternativo();

	private FabricaEntidades fabricaEntidades;

	public GeneradorNivel(FabricaEntidades fabricaEntidades) {
		this.fabricaEntidades= fabricaEntidades;
	}

	public Nivel cargarNivel(String rutaArchivo) {
		Nivel nivel = new Nivel();
		generarNivel(rutaArchivo, nivel);
		return nivel;
	}

	private void generarNivel(String rutaArchivo, Nivel nivel) {
		BufferedReader lector;
		try {
			lector = new BufferedReader(new FileReader(rutaArchivo));
			String linea = lector.readLine();
			while (linea != null) {
				String[] contenidoLinea = linea.split(" ");
				agregarEntidades(contenidoLinea, nivel);
				linea=lector.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void establecerSpriteOriginal() {
		fabricaEntidades.establecerFabricaSprite(FABRICA_ORIGINAL);
	}

	public void establecerSpriteAlternativa() {
		fabricaEntidades.establecerFabricaSprite(FABRICA_ALTERNATIVA);
	}

	private void agregarEntidades(String[] contenidoLinea, Nivel nivel) {
		int entidad, posicionX, posicionY, extras;
		entidad = Integer.parseInt(contenidoLinea[0]);
		posicionX = Integer.parseInt(contenidoLinea[1]);
		posicionY = Integer.parseInt(contenidoLinea[2]);
		switch (entidad) {
		
		case 1:
			nivel.agregarMario(fabricaEntidades.crearMario(posicionX, posicionY));
			break;
			
		case 2:
			nivel.agregarEnemigo(fabricaEntidades.crearBuzzyBeetle(posicionX, posicionY));
			break;
			
		case 3:
			nivel.agregarEnemigo(fabricaEntidades.crearSpiny(posicionX, posicionY));
			break;
			
		case 4:
			LinkedList<Spiny> spinys = crearSpinys(posicionX, posicionY, nivel);
			nivel.agregarEnemigo(fabricaEntidades.crearLakitu(posicionX, posicionY,spinys));
			break;
			
		case 5:
			nivel.agregarEnemigo(fabricaEntidades.crearPiranhaPlant(posicionX, posicionY));
			break;
			
		case 6:
			nivel.agregarEnemigo(fabricaEntidades.crearGoomba(posicionX, posicionY));
			break;
			
		case 7:
			nivel.agregarEnemigo(fabricaEntidades.crearKoopaTroopa(posicionX, posicionY));
			break;
			
		case 8:
			extras = Integer.parseInt(contenidoLinea[3]);
			PowerUp contenido = null;
			switch (extras) {
			
			case 13:
				contenido = fabricaEntidades.crearSuperChampinion(posicionX, posicionY);
				break;
				
			case 14:
				contenido = fabricaEntidades.crearEstrella(posicionX, posicionY);
				break;
				
			case 15:
				contenido = fabricaEntidades.crearMoneda(posicionX, posicionY);
				break;
				
			case 16:
				contenido = fabricaEntidades.crearFlorDeFuego(posicionX, posicionY);
				break;
				
			case 17:
				contenido = fabricaEntidades.crearChampinionVerde(posicionX, posicionY);
				break;
				
			}
			nivel.agregarPowerUp(contenido);
			nivel.agregarPlataforma(fabricaEntidades.crearBloqueDePregunta(posicionX, posicionY, contenido));
			break;
			
		case 9:
			nivel.agregarPlataforma(fabricaEntidades.crearTuberia(posicionX, posicionY));
			break;
			
		case 10:
			nivel.agregarPlataforma(fabricaEntidades.crearBloqueSolido(posicionX, posicionY));
			break;
			
		case 11:
			nivel.agregarPlataforma(fabricaEntidades.crearLadrilloSolido(posicionX, posicionY));
			break;
			
		case 12:
			nivel.agregarPlataforma(fabricaEntidades.crearVacio(posicionX, posicionY));
			break;
			
		case 13:
			nivel.agregarPowerUp(fabricaEntidades.crearSuperChampinion(posicionX, posicionY));
			break;
			
		case 14:
			nivel.agregarPowerUp(fabricaEntidades.crearEstrella(posicionX, posicionY));
			break;
			
		case 15:
			nivel.agregarPowerUp(fabricaEntidades.crearMoneda(posicionX, posicionY));
			break;
			
		case 16:
			nivel.agregarPowerUp(fabricaEntidades.crearFlorDeFuego(posicionX, posicionY));
			break;
			
		case 17:
			nivel.agregarPowerUp(fabricaEntidades.crearChampinionVerde(posicionX, posicionY));
			break;
		}
	}

	private LinkedList<Spiny> crearSpinys(int posicionX, int posicionY, Nivel nivel) {
		LinkedList<Spiny> listaDeSpinys = new LinkedList<Spiny>();
		
		for(int i=0; i<10; i++) {
			Spiny spiny = fabricaEntidades.crearSpiny(posicionX, posicionY);
			nivel.agregarEnemigo(spiny);
			listaDeSpinys.add(spiny);
		}
		
		return listaDeSpinys;
	}
}
