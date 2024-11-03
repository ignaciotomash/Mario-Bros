package Vistas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints; 
import java.awt.GridBagLayout; 
import java.awt.Insets; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Ranking.Ranking;

@SuppressWarnings("serial")
public class PantallaRanking extends JPanel {

	private ControladorVistas controladorVistas;
	private Ranking ranking;
	private JLabel imagenFondo;
	private JButton botonSalir;
	private JLabel palabraRanking;
	private JPanel panelRanking;

	public PantallaRanking(ControladorVistas controladorVistas) {
		
		this.controladorVistas = controladorVistas;
		ranking = Ranking.obtenerInstancia();
		
		setPreferredSize(new Dimension(ConstantesVistas.ANCHO_FRAME, ConstantesVistas.ALTO_FRAME));
		setLayout(null);  
		setDoubleBuffered(true);
		setFocusable(true);
		requestFocusInWindow();
		
		agregarPanelRanking();
		agregarPalabraRanking();
		agragarImagenFondo();
		agregarBotonSalir();
		registrarOyenteBotonSalir();
	}

	private void agregarPanelRanking() {
		panelRanking = new JPanel();
		panelRanking.setLayout(new GridBagLayout()); 
		panelRanking.setBounds(118, 280, 520, 150);
		panelRanking.setOpaque(false);
		agregarRanking();
		add(panelRanking);
	}

	private void agregarRanking() {
		
		GridBagConstraints organizador = new GridBagConstraints();

		organizador.insets = new Insets(5, 5, 5, 5); 
		organizador.fill = GridBagConstraints.HORIZONTAL; 

		for (int puesto = 1; puesto <= 5; puesto++) {
			JLabel nombreLabel = new JLabel(ranking.obtenerUsuario(puesto));
			JLabel puntajeLabel = new JLabel(ranking.obtenerPuntos(puesto));
			puntajeLabel.setHorizontalAlignment(JLabel.RIGHT);

			decorarLabelsRanking(nombreLabel, puntajeLabel);

			organizador.gridx = 0;
			organizador.weightx = 1; 
			panelRanking.add(nombreLabel, organizador);

			organizador.gridx = 1;
			organizador.weightx = 0;
			organizador.anchor = GridBagConstraints.EAST; 
			panelRanking.add(puntajeLabel, organizador);
		}
	}

	private void decorarLabelsRanking(JLabel nombreLabel, JLabel puntajeLabel) {
		
		try (InputStream is = getClass().getResourceAsStream("/Vistas/FuentePaneles/fuente_informacion.ttf")) {
			Font fuenteArcade = Font.createFont(Font.TRUETYPE_FONT, is);
			fuenteArcade = fuenteArcade.deriveFont(Font.BOLD, 18);
			nombreLabel.setFont(fuenteArcade);
			puntajeLabel.setFont(fuenteArcade);
			
		} catch (Exception e) {
			e.printStackTrace();
			Font defaultFont = new Font("SansSerif", Font.PLAIN, 18);
			nombreLabel.setFont(defaultFont);
			puntajeLabel.setFont(defaultFont);
		}

		nombreLabel.setForeground(Color.WHITE);
		puntajeLabel.setForeground(Color.WHITE);
	}

	private void agragarImagenFondo() {
		imagenFondo = new JLabel(new ImageIcon(getClass().getResource("/imagenes/FondoPantallaRanking.png")));
		imagenFondo.setLayout(null);
		imagenFondo.setBounds(0, 0, ConstantesVistas.ANCHO_FRAME, ConstantesVistas.ALTO_FRAME);
		add(imagenFondo);
	}

	private void agregarPalabraRanking() {
		palabraRanking = new JLabel("Ranking");
		palabraRanking.setVisible(true);
		palabraRanking.setBounds(260, 210, 450, 50);

		try (InputStream is = getClass().getResourceAsStream("/Vistas/FuentePaneles/fuente_informacion.ttf")) {
			Font fuenteArcade = Font.createFont(Font.TRUETYPE_FONT, is);
			fuenteArcade = fuenteArcade.deriveFont(Font.BOLD, 35);
			palabraRanking.setFont(fuenteArcade);
			
		} catch (Exception e) {
			e.printStackTrace();
			palabraRanking.setFont(new Font("SansSerif", Font.PLAIN, 18));
		}
		
		palabraRanking.setForeground(Color.WHITE);
		add(palabraRanking);
	}

	private void agregarBotonSalir() {
		ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/BotonSalir.png"));
		
		botonSalir = new JButton("Ranking");
		botonSalir.setIcon(icono);
		botonSalir.setBounds(341, 458, icono.getIconWidth(), icono.getIconHeight());
		
		imagenFondo.add(botonSalir);
		
		botonSalir.setBorderPainted(false);
		botonSalir.setFocusPainted(false);
		botonSalir.setContentAreaFilled(false);
		botonSalir.revalidate();
		botonSalir.repaint();
	}

	private void registrarOyenteBotonSalir() {
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorVistas.mostrarPantallaInicial();
			}
		});
	}
	
	public void actualizarRanking() {
	    panelRanking.removeAll();
	    agregarRanking();
	    panelRanking.revalidate();
	    panelRanking.repaint();
	}
	
}