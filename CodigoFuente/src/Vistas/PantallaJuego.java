package Vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import Entidades.EntidadLogica;
import Entidades.EntidadMario;

@SuppressWarnings("serial")
public class PantallaJuego extends JLayeredPane {

	private static final String FONDO_ORIGINAL = "/imagenes/FondoPantallaJuego.png";
	private static final String FONDO_ALTERNATIVO = "/imagenes/fondoPantallaJuegoAlternativo.png";
	
	private JLabel imagenFondo; 
	private JScrollPane scroll;
	private ControladorVistas controladorVistas;
	private JLabel nivel;
	private JLabel puntaje;
	private JLabel vidas;
	private JLabel tiempo;
	private JLabel moneda;
	private JLabel contadorMoneda;
	private JPanel panelInformacion;
	private char anteriorTecla;

	public PantallaJuego(ControladorVistas controladorVistas) {
		this.controladorVistas = controladorVistas;

		setPreferredSize(new Dimension(ConstantesVistas.ANCHO_FRAME, ConstantesVistas.ALTO_FRAME));
		setLayout(new BorderLayout());
		setDoubleBuffered(true);
		setFocusable(true);
		requestFocusInWindow();

		registrarOyenteTeclado();
		agregarPanelInformacion();
		agregarImagenFondo();
	}

	private void agregarPanelInformacion() {
		panelInformacion = new JPanel();
		panelInformacion.setBounds(0,10, ConstantesVistas.ANCHO_FRAME, 120);
		panelInformacion.setOpaque(false);
		agregarInformacion();
		this.add(panelInformacion);
	}

	private void agregarInformacion() {
		nivel = new JLabel("NIVEL 1");
		puntaje = new JLabel(" 00000");
		vidas = new JLabel("  Vidas: 00");
		contadorMoneda = new JLabel("  x00");
		moneda = new JLabel(new ImageIcon(getClass().getResource("/imagenes/moneda.png")));
		tiempo = new JLabel("00"); 

		decorarPanelesInformacion();

		panelInformacion.add(nivel);
		panelInformacion.add(puntaje);
		panelInformacion.add(vidas);
		panelInformacion.add(moneda);
		panelInformacion.add(contadorMoneda);
		panelInformacion.add(tiempo);
	}

	private void decorarPanelesInformacion() {
		nivel.setVisible(true);
		puntaje.setVisible(true);
		contadorMoneda.setVisible(true);
		vidas.setVisible(true);
		tiempo.setVisible(true);
		moneda.setVisible(true);

		try (InputStream is = getClass().getResourceAsStream("/Vistas/FuentePaneles/fuente_informacion.ttf")) {
			Font fuenteArcade = Font.createFont(Font.TRUETYPE_FONT, is);
			fuenteArcade = fuenteArcade.deriveFont(Font.BOLD, 16);
			nivel.setFont(fuenteArcade);
			puntaje.setFont(fuenteArcade);
			vidas.setFont(fuenteArcade);
			contadorMoneda.setFont(fuenteArcade);
			tiempo.setFont(fuenteArcade);

		} catch (Exception e) {
			e.printStackTrace();
			puntaje.setFont(new Font("SansSerif", Font.PLAIN, 18));
		}

		nivel.setForeground(Color.WHITE);
		puntaje.setForeground(Color.WHITE);
		vidas.setForeground(Color.WHITE);
		contadorMoneda.setForeground(Color.WHITE);
		tiempo.setForeground(Color.WHITE);
	}

	private void agregarImagenFondo() {

		imagenFondo = new JLabel(new ImageIcon(getClass().getResource("/imagenes/fondoPantallaJuego.png"))); 
		imagenFondo.setLayout(null);  
		imagenFondo.setBounds(0, 0, ConstantesVistas.ANCHO_FRAME, ConstantesVistas.ALTO_FRAME);
		this.add(imagenFondo);
		imagenFondo.revalidate();
		imagenFondo.repaint();

		JPanel panelImagen = new JPanel();
		panelImagen.add(imagenFondo);
		panelImagen.setPreferredSize(imagenFondo.getPreferredSize());

		scroll = new JScrollPane(panelImagen);
		scroll.setPreferredSize(new Dimension(ConstantesVistas.ANCHO_FRAME, ConstantesVistas.ALTO_FRAME));
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

		add(scroll);
	}

	public Observer agregarEntidad(EntidadLogica entidadLogica) {
		ObserverEntidades observerEntidad = new ObserverEntidades(entidadLogica);
		imagenFondo.add(observerEntidad);
        return observerEntidad;
	}

	public Observer agregarEntidadMario(EntidadMario entidadMario) {
		ObserverMario observerMario = new ObserverMario(this, entidadMario);
		imagenFondo.add(observerMario);
        return observerMario;
	}

	public void actualizarScrollMario(EntidadMario marioObservado) {

		int posicionXdeMario = marioObservado.obtenerPosicionX(); 
		int pantallaAncho = scroll.getViewport().getWidth();
		int posicionDelScroll = scroll.getHorizontalScrollBar().getValue();
		int topeDelScroll = scroll.getHorizontalScrollBar().getMaximum();

		if (posicionXdeMario > posicionDelScroll + pantallaAncho - 400 && posicionDelScroll < topeDelScroll) {
			scroll.getHorizontalScrollBar().setValue(posicionXdeMario - pantallaAncho + 400);
		}

		if (posicionXdeMario < posicionDelScroll + 10 && posicionDelScroll > 0) {
			scroll.getHorizontalScrollBar().setValue(posicionXdeMario - 10);
		}
	}
	
	private void registrarOyenteTeclado() {
		anteriorTecla = 'z';
		this.addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent e) {}

			public void keyPressed(KeyEvent e) {

				if (e.getKeyChar() == 'a') {
					controladorVistas.establecerDireccion('i');
					anteriorTecla = 'a';
				}


				if (e.getKeyChar() == 'd') {
					controladorVistas.establecerDireccion('d');
					anteriorTecla = 'd'; 
				}


				if (e.getKeyChar() == 'w') {

					if (anteriorTecla == 'a') 
						controladorVistas.establecerDireccion('i');

					else if (anteriorTecla == 'd') 
						controladorVistas.establecerDireccion('d'); 

					controladorVistas.establecerDireccion('a'); 
				}

				if (e.getKeyCode() == KeyEvent.VK_SPACE) 
					controladorVistas.activarBolaDeFuego(); 

			}

			public void keyReleased(KeyEvent e) {

				if (e.getKeyChar() == 'a') {
					controladorVistas.establecerDireccion('z'); 
					anteriorTecla = 'z'; 
				}


				if (e.getKeyChar() == 'd') {
					controladorVistas.establecerDireccion('z'); 
					anteriorTecla = 'z'; 
				}


				if (e.getKeyChar() == 'w') {
					controladorVistas.establecerDireccion('z'); 

					if (anteriorTecla == 'a') 
						controladorVistas.establecerDireccion('i'); 

					else if (anteriorTecla == 'd') 
						controladorVistas.establecerDireccion('d'); 
				}
			}
		});
	}

	public void actualizarInformacion(EntidadMario marioObservado) {
		nivel.setText("Nivel " + controladorVistas.obtenerNivelActual() + "  ");
		puntaje.setText("Puntos:" + marioObservado.obtenerPuntos()+ "  ");
		vidas.setText("Vidas:" + marioObservado.obtenerVidas()+"   ");
		contadorMoneda.setText("x" + marioObservado.obtenerMonedas());
	}

	public void reiniciarScroll() {
		scroll.getHorizontalScrollBar().setValue(100);
	}

	public void actualizarTiempo(int tiempoDeJuego) {
		tiempo.setText("   "+tiempoDeJuego);
	}

	public void establecerFondoOriginal() {
		imagenFondo.setIcon(new ImageIcon(getClass().getResource(FONDO_ORIGINAL)));
		imagenFondo.repaint();
	}

	public void establecerFondoAlternativo() {
		imagenFondo.setIcon(new ImageIcon(getClass().getResource(FONDO_ALTERNATIVO)));
		imagenFondo.repaint();
	}

}