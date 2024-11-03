package Hilos;

import Mario.Notificable;

public class HiloTiempoEfecto extends Thread{
	private Notificable notificable;
	private int duracion;
	private boolean HiloEnEjecucion;

	public HiloTiempoEfecto(Notificable notificable, int duracion) {
		HiloEnEjecucion = false;
		this.notificable= notificable;
		this.duracion=duracion;
	}

	public void iniciarHilo() {
		super.start();
		HiloEnEjecucion = true;
	}

	public void run(){
		while(HiloEnEjecucion) {
			try {
				Thread.sleep(duracion);
			}catch(Exception e) {
				e.printStackTrace();
			}
			notificable.efectoFinalizado();
		}
	}

	public void detenerHilo() {
		HiloEnEjecucion = false;
	}
}
