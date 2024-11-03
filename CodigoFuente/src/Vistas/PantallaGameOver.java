package Vistas;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PantallaGameOver extends JPanel {
	
	private ControladorVistas controladorVistas;
	private JLabel imagenFondo;
	private JButton botonSalir;

	public PantallaGameOver (ControladorVistas controlador) {
		this.controladorVistas = controlador;
		setPreferredSize(new Dimension(ConstantesVistas.ANCHO_FRAME, ConstantesVistas.ALTO_FRAME));	
		setLayout(null);
		
		agregarImagenFondo();
		agregarBotonSalir();
		registrarOyenteBotonSalir();
	}

	private void agregarImagenFondo() {
		imagenFondo = new JLabel(new ImageIcon(getClass().getResource("/imagenes/fondoPantallaGameOver.jpg"))); 
		imagenFondo.setLayout(null);  
		imagenFondo.setBounds(0, 0, ConstantesVistas.ANCHO_FRAME, ConstantesVistas.ALTO_FRAME);
		this.add(imagenFondo);
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
	
}