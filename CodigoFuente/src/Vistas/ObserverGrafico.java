package Vistas;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Entidades.EntidadLogica;

@SuppressWarnings("serial")
public class ObserverGrafico extends JLabel implements Observer {
	
	protected EntidadLogica entidadObservada;

	public ObserverGrafico(EntidadLogica entidadObservada) {
		super();
		this.entidadObservada = entidadObservada;
	}

	public void actualizar() {
		actualizarImagen();
		actualizarPosicion();
	}

	private void actualizarImagen() {
	    String rutaImagen = entidadObservada.obtenerSprite().obtenerRutaImagen();
	    URL url = getClass().getClassLoader().getResource(rutaImagen);
	
	    ImageIcon iconoOriginal = new ImageIcon(url);

	    int nuevoAncho = iconoOriginal.getIconWidth(); 
	    int nuevoAlto = iconoOriginal.getIconHeight();
	    Image imagenRedimensionada = iconoOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_DEFAULT);
	    
		ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
		setIcon(iconoRedimensionado);
		int x = AdaptadorPosicion.transformarX(entidadObservada.obtenerPosicionX());
		int y = AdaptadorPosicion.transformarY(entidadObservada.obtenerPosicionY());
		setBounds(x, y, nuevoAncho, nuevoAlto);
	}

	public void actualizarPosicion() {
		int x = AdaptadorPosicion.transformarX(entidadObservada.obtenerPosicionX());
		int y = AdaptadorPosicion.transformarY(entidadObservada.obtenerPosicionY());
		int ancho = this.getIcon().getIconWidth();  
		int alto = this.getIcon().getIconHeight();
		
		setBounds(x, y, ancho, alto);
		
		entidadObservada.obtenerSprite().actualizarRectangulos(x, y, ancho, alto);
	}

	public void reiniciar() {}
	
}