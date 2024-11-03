package Launcher;

import Juego.Juego;
import Vistas.ControladorVistas;

public class Launcher {

	public static void main(String [] args) {
		Juego juego = new Juego();
		ControladorVistas controladorVistas = new ControladorVistas(juego);
		juego.establecerControladorVistas(controladorVistas);
		controladorVistas.mostrarPantallaInicial();
		
	}
}
