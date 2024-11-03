package Vistas;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import Entidades.EntidadLogica;
import Entidades.EntidadMario;
import Juego.Juego;
import Ranking.Ranking;

public class ControladorVistas {

	protected JFrame frame;
	private Juego juego;
	private PantallaInicial pantallaInicial;
	private PantallaJuego pantallaJuego;
	private PantallaRanking pantallaRanking;
	private PantallaGameOver pantallaGameOver;
	private PantallaGanadora pantallaGanadora;
	
	
	public ControladorVistas(Juego juego) {
		this.juego = juego;
		pantallaInicial = new PantallaInicial(this);
		pantallaJuego = new PantallaJuego(this);
		pantallaRanking = new PantallaRanking(this);
		pantallaGameOver = new PantallaGameOver(this);
		pantallaGanadora = new PantallaGanadora(this);
		crearFrame();

	}

	private void crearFrame() {

		frame= new JFrame("Mario Bros");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		agregarOyenteCierreVentana();
		frame.setSize(ConstantesVistas.ANCHO_FRAME, ConstantesVistas.ALTO_FRAME);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);	
	}
	
	private void agregarOyenteCierreVentana() {
		frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Ranking ranking = Ranking.obtenerInstancia();
                ranking.guardarPuntuaciones();
                System.exit(0);
            }
        });
	}

	public int obtenerNivelActual() {
		return juego.obtenerNivelActual();
	}
	
	public int obtenerPuntosMario() {
		return juego.obtenerPuntosMario();
	}

    public void mostrarPantallaInicial (){
		frame.setContentPane(pantallaInicial);
		actualizarPanel();
	}

	public void mostrarPantallaJuego() {
		frame.setContentPane(pantallaJuego);
		pantallaJuego.requestFocus();
		actualizarPanel();
	} 

	private void actualizarPanel() {
		frame.revalidate();
		frame.repaint();
	}

	public void mostrarPantallaGameOver () {
		frame.setContentPane(pantallaGameOver);
		actualizarPanel();
    }
	
	public void mostrarPantallaGanadora () {
		pantallaGanadora.actualizarCampoNombre();
		frame.setContentPane(pantallaGanadora);
		actualizarPanel();
	}

	public void mostrarPantallaRanking() {
		pantallaRanking.actualizarRanking();
		frame.setContentPane(pantallaRanking);
		pantallaRanking.requestFocus();
		actualizarPanel();
	}

	public void iniciarJuegoOriginal() {
		juego.iniciarModoOriginal();
	}
	
	public void iniciarJuegoAlternativo() {
		juego.iniciarModoAlternativo();
	}
	
	public void establecerDireccion(char direccion) {
		juego.establecerDireccionMario(direccion);
	}
	
	public void establecerJuego(Juego juego) {
		this.juego = juego;
	}
	
    public void activarBolaDeFuego() {
    	juego.activarBolaDeFuego();
    }

	public Observer registrarEntidad(EntidadLogica entidadLogica) {
		Observer observerEntidad = pantallaJuego.agregarEntidad(entidadLogica);
		actualizarPanel();
		return observerEntidad;
	}

	public Observer registrarEntidadMario(EntidadMario entidadMario) {
		Observer observerMario = pantallaJuego.agregarEntidadMario(entidadMario);
		actualizarPanel();
		return observerMario;
	}
	
	public PantallaJuego obtenerPantallaJuego() { 
		return pantallaJuego;
	}

	public void actualizarInformacionTiempo(int tiempoDeJuego) {
		pantallaJuego.actualizarTiempo(tiempoDeJuego);
	}
	
	public boolean terminoJuego() {
		return juego.terminoJuego();
	}
	
	public void reiniciarJuegoOriginal() {
		juego.reiniciarJuegoOriginal();
	}
	
	public void reiniciarJuegoAlternativo() {
		juego.reiniciarJuegoAlternativo();
	}

	public void establecerFondoOriginal() {
		pantallaJuego.establecerFondoOriginal();
	}

	public void establecerFondoAlternativo() {
		pantallaJuego.establecerFondoAlternativo();
	}
	
}
