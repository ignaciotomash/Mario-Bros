package Hilos;

import Juego.Juego;
import Vistas.PantallaJuego;

public class HiloEntidades extends Thread{

	private static final int UN_SEGUNDO = 1000;
	
	private  Juego juego;
	private boolean hiloEnEjecucion;
	private PantallaJuego pantallaJuego;
	private int fotogramasPorSegundo;

	public HiloEntidades(Juego juego) {
		this.juego = juego;
		hiloEnEjecucion = false;
		fotogramasPorSegundo = 60;
		pantallaJuego = juego.obtenerControladorVistas().obtenerPantallaJuego();
	}

	public void iniciar() {
		super.start();
		hiloEnEjecucion = true;
	}

	public void reiniciar() {
		hiloEnEjecucion = true;
	}

	public void run(){
		long duracionIntervalo = UN_SEGUNDO/fotogramasPorSegundo;
		long siguienteIntervalo = System.currentTimeMillis() + duracionIntervalo; 
		while(hiloEnEjecucion) {
			juego.actualizarEntidades();
			juego.detectarColisionesEntidades();
			pantallaJuego.repaint();
			pantallaJuego.revalidate();
			try {
				long milisegundosRestantes = siguienteIntervalo - System.currentTimeMillis();
				if(milisegundosRestantes < 0) {
					milisegundosRestantes = 0;
				}
				Thread.sleep(milisegundosRestantes);
				siguienteIntervalo += duracionIntervalo;

			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void detener() {
		hiloEnEjecucion = false;
	}

}
