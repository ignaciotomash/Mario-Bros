
package Vistas;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PantallaInicial extends JPanel {

	private ControladorVistas controladorVistas;
	private JLabel imagenFondo;
	private JButton botonJugar;
	private JButton botonModoAlternativo;
	private JButton botonRanking;

	public PantallaInicial(ControladorVistas controlador) {
		this.controladorVistas = controlador;
		setPreferredSize(new Dimension(ConstantesVistas.ANCHO_FRAME, ConstantesVistas.ALTO_FRAME));	
		setLayout(null);

		agregarImagenFondo();
		agregarBotonIniciar();
		agregarBotonRanking();
		agregarBotonModoAlternativo();
		registrarOyenteBotonRanking();
		registrarOyenteBotonJugar();
		registrarOyenteBotonModoAlternativo();
	}

	private void agregarBotonIniciar() {

		ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/BotonJugar.png"));
		
		botonJugar = new JButton("botonJugar");
		botonJugar.setIcon(icono);
		botonJugar.setBounds(310, 335,icono.getIconWidth(), icono.getIconHeight());
		
		imagenFondo.add(botonJugar);
		
		botonJugar.setBorderPainted(false);
		botonJugar.setFocusPainted(false);
		botonJugar.setContentAreaFilled(false);
		botonJugar.revalidate();
		botonJugar.repaint();
	}

	private void agregarBotonRanking() {
		
		ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/BotonRanking.png"));
		
		botonRanking = new JButton("Ranking");
		botonRanking.setIcon(icono);
		botonRanking.setBounds(306, 450,icono.getIconWidth(), icono.getIconHeight());
		
		imagenFondo.add(botonRanking);
		
		botonRanking.setBorderPainted(false);
		botonRanking.setFocusPainted(false);
		botonRanking.setContentAreaFilled(false);
		botonRanking.revalidate();
		botonRanking.repaint();
	}
	
	private void agregarBotonModoAlternativo() {
		
		ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/BotonModoAlternativo.png"));
		
		botonModoAlternativo = new JButton("Modo Alternativo");
		botonModoAlternativo.setIcon(icono);
		botonModoAlternativo.setBounds(305, 392,icono.getIconWidth(), icono.getIconHeight());
		
		imagenFondo.add(botonModoAlternativo);
		
		botonModoAlternativo.setBorderPainted(false);
		botonModoAlternativo.setFocusPainted(false);
		botonModoAlternativo.setContentAreaFilled(false);
		botonModoAlternativo.revalidate();
		botonModoAlternativo.repaint();
	}

	private void agregarImagenFondo() {
		imagenFondo = new JLabel(new ImageIcon(getClass().getResource("/imagenes/FondoPantallaInicial.png"))); 
		imagenFondo.setLayout(null);  
		imagenFondo.setBounds(0, 0, ConstantesVistas.ANCHO_FRAME, ConstantesVistas.ALTO_FRAME);
		this.add(imagenFondo);
	}

	private void registrarOyenteBotonRanking() {
		botonRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorVistas.mostrarPantallaRanking();
			}
		});

	}

	private void registrarOyenteBotonJugar() {
		botonJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean finalizoPartida=controladorVistas.terminoJuego();
				if(finalizoPartida) {
					controladorVistas.reiniciarJuegoOriginal();
				}
				else {

					controladorVistas.iniciarJuegoOriginal();

				}
			}
		});
	}

	private void registrarOyenteBotonModoAlternativo() {
		botonModoAlternativo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean finalizoPartida=controladorVistas.terminoJuego();
				if(finalizoPartida) {
					controladorVistas.reiniciarJuegoAlternativo();
				}
				else {

					controladorVistas.iniciarJuegoAlternativo();
				}
			}
		});
	}
	
}
