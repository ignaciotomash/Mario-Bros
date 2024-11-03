package Entidades;

import Fabricas.Sprite;
import Sonido.Sonido;

public interface EntidadLogica {
	
	public int obtenerPosicionX();
	public int obtenerPosicionY();
	public Sprite obtenerSprite();
	public Sonido obtenerSonido();
	public boolean estaEliminada();
	
}
