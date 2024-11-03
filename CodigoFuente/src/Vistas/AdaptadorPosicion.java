package Vistas;

public class AdaptadorPosicion {

	public static int transformarX(int posicionx) {
		return posicionx;
	}

	public static int transformarY(int posicionY) {
		return ConstantesVistas.ALTO_FRAME - posicionY;
	}
	
}