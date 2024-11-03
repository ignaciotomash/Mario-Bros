package Vistas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.InputStream;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Ranking.Puntuacion;
import Ranking.Ranking;

@SuppressWarnings("serial")
public class PantallaGanadora extends JPanel{

	private ControladorVistas controladorVistas;
	private JLabel imagenFondo;
	private JTextField campoNombre;
	private JButton botonRegistrar;
	private Ranking ranking;

	public PantallaGanadora (ControladorVistas controladorVistas) {
		this.controladorVistas = controladorVistas;
		setPreferredSize(new Dimension(ConstantesVistas.ANCHO_FRAME, ConstantesVistas.ALTO_FRAME));	
		setLayout(null);
		ranking = Ranking.obtenerInstancia();

		agregarImagenFondo();
		agregarCampoNombre();
	}

	private void agregarImagenFondo() {
		imagenFondo = new JLabel(new ImageIcon(getClass().getResource("/imagenes/FondoPantallaGanadora.png")));
		imagenFondo.setLayout(null);
		imagenFondo.setBounds(0, 0, ConstantesVistas.ANCHO_FRAME, ConstantesVistas.ALTO_FRAME);
		this.add(imagenFondo);
	}

	public void agregarCampoNombre() {
		setLayout(null);
		setPreferredSize(new Dimension(400, 200));

		campoNombre = new JTextField(" Escribe aqui");
		campoNombre.setBounds(183, 385, 360, 40);
		campoNombre.setOpaque(false); 
		campoNombre.setForeground(Color.WHITE); 
		campoNombre.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));

		try (InputStream is = getClass().getResourceAsStream("/Vistas/FuentePaneles/fuente_informacion.ttf")) {
			Font fuenteArcade = Font.createFont(Font.TRUETYPE_FONT, is);
			campoNombre.setFont(fuenteArcade.deriveFont(Font.PLAIN, 13));
		} catch (Exception e) {
			e.printStackTrace();
			campoNombre.setFont(new Font("SansSerif", Font.PLAIN, 18)); 
		}
		imagenFondo.add(campoNombre);

		botonRegistrar = new JButton("Registrar");
		ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/BotonRegistrar.png"));
		botonRegistrar.setIcon(icono);
		botonRegistrar.setBounds(550, 385, icono.getIconWidth(), icono.getIconHeight());

		imagenFondo.add(botonRegistrar);

		botonRegistrar.setBorderPainted(false);
		botonRegistrar.setFocusPainted(false);
		botonRegistrar.setContentAreaFilled(false);
		botonRegistrar.revalidate();
		botonRegistrar.repaint();
		botonRegistrar.addActionListener(e -> registrarNombre());
	}

	private void registrarNombre() {
		String nombreJugador = campoNombre.getText().trim();

		if (!nombreJugador.isEmpty() && nombreJugador.length() <= 20) {

			if (!nombreJugador.isEmpty()) {
				ranking.agregarPuntuacion(new Puntuacion(nombreJugador, controladorVistas.obtenerPuntosMario()));
				ranking.guardarPuntuaciones(); 
				controladorVistas.mostrarPantallaRanking();
				JOptionPane.showMessageDialog(this, "Nombre registrado con éxito.");

			} else 
				if(nombreJugador.length() > 20) 
					JOptionPane.showMessageDialog(this, "Ingresa un nombre más corto");

				else JOptionPane.showMessageDialog(this, "Por favor, ingresa un nombre válido");
		}
	}

	public void actualizarCampoNombre(){
		campoNombre.setText(" Escribe aqui");
	}
	
}