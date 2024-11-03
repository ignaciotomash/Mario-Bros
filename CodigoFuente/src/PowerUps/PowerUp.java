package PowerUps;

import Entidades.Entidad;
import Fabricas.Sprite;
import Plataformas.Plataforma;

public abstract class PowerUp extends Entidad{

	private static final int SPRITE_POWERUP_DENTRO_DE_BLOQUE = 1;

	public PowerUp(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
	}

	public void serAfectado(Entidad entidad) {
			entidad.afectar(this);
	}

	public void serAfectado(Plataforma plataforma, String direccion) {
			plataforma.afectar(this,direccion);
	}

	public void efectoSuperChampinion() {
		cambiarDireccion();
	}

	public void efectoEstrella() {
		cambiarDireccion();
	}

	public void efectoChampinionVerde() {
		cambiarDireccion();
	}

	private void cambiarDireccion() {

		if(direccionDeMovimiento == DERECHA)
			establecerDireccion(IZQUIERDA);

		else if(direccionDeMovimiento == IZQUIERDA)
			establecerDireccion(DERECHA);
	}

	public void efectoBloqueDePregunta(String direccion) {
		efectoGeneralDeBloque(direccion);
	}

	public void efectoTuberia(String direccion) {
		efectoGeneralDeBloque(direccion);
	}

	public void efectoBloqueSolido(String direccion) {
		efectoGeneralDeBloque(direccion);
	}

	public void efectoLadrilloSolido(String direccion) {
		efectoGeneralDeBloque(direccion);
	}

	public void efectoVacio(String direccion) {
		efectoGeneralDeBloque(direccion);
	}

	public void efectoBolaDeFuego(String direccion) {
		efectoGeneralDeBloque(direccion);
	}

	public void efectoFlorDeFuego(String direccion) {
		efectoGeneralDeBloque(direccion);
	}

	private void efectoGeneralDeBloque(String direccion) {
		
			if (direccion == "derecha")
				cambiarDireccion();

			if (direccion == "izquierda")
				cambiarDireccion();

			if(direccion == "abajo") 
				sobrePlataforma(true);
		
	}

	public void reiniciar() {
		eliminada = false;
		establecerPosicionInicial();
		modificarSprite(SPRITE_POWERUP_DENTRO_DE_BLOQUE);
		establecerDireccion(INMOVIL);
		observer.actualizar();
		observer.reiniciar();
		
	}
	
	public void efectoMoneda() {}

}
