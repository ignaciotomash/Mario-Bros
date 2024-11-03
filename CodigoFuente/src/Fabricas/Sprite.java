package Fabricas;

import java.awt.Rectangle;

public class Sprite extends Rectangle{

	private static final long serialVersionUID = 6566536910187505577L;

	private Rectangle rectanguloIzquierdo;
	private Rectangle rectanguloDerecho;
	private Rectangle rectanguloArriba;
	private Rectangle rectanguloAbajo;
	private String rutaImagen;

	public Sprite(String rutaImagen) {

		this.rutaImagen = rutaImagen;
		inicializarRectangulos();
	}

	public Rectangle obtenerRectanguloArriba() {
		return rectanguloArriba;
	}

	public Rectangle obtenerRectanguloIzquierdo() {
		return rectanguloIzquierdo;
	}

	public Rectangle obtenerRectanguloDerecho() {
		return rectanguloDerecho;
	}

	public Rectangle obtenerRectanguloAbajo() {
		return rectanguloAbajo;
	}

	public String obtenerRutaImagen() {
		return rutaImagen;
	}

	public void actualizarRectangulos(int x, int y, int ancho, int alto) {

		super.setBounds(x, y, ancho, alto);
		rectanguloArriba.setBounds( x , y - ancho/8, ancho, alto/4);
		rectanguloAbajo.setBounds( x , y + alto - alto/4, ancho, alto/4);
		rectanguloDerecho.setBounds(x + ancho - ancho/4, y + alto /8, ancho/4, alto - alto/4);
		rectanguloIzquierdo.setBounds(x, y + alto /8, ancho/4, alto - alto/4);

	}
	
	private void inicializarRectangulos() {

		rectanguloAbajo = new Rectangle(0,0,0,0);
		rectanguloIzquierdo = new Rectangle(0,0,0,0);
		rectanguloDerecho = new Rectangle(0,0,0,0);
		rectanguloArriba = new Rectangle(0,0,0,0);
		
	}
}
