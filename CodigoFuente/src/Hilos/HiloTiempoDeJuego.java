package Hilos;

import Juego.Juego;

public class HiloTiempoDeJuego extends Thread {
	
	private  Juego juego;
	private boolean hiloEnEjecucion;

	public HiloTiempoDeJuego(Juego juego) {
		this.juego = juego;
		hiloEnEjecucion = false;
	}

	public void iniciar() {
		super.start();
		hiloEnEjecucion = true;
	}

	public void run(){
		while(hiloEnEjecucion) {
			juego.actualizarTiempo();
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void detener() {
		hiloEnEjecucion = false;
	}

}

