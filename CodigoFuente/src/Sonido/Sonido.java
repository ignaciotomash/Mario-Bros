package Sonido;
import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class Sonido {

	protected static Sonido instanciaSonido;
	
	private Clip clipFondo;
	private Clip clipEfecto;
	private HashMap<String, String> rutasSonidos;
	
	private Sonido() {
        rutasSonidos = new HashMap<>();
        rutasSonidos.put("sonidoFondo", "/sonidos/sonidoJuego.wav");
        rutasSonidos.put("sonidoMarioSimpleSalta", "/sonidos/sonidoMarioSimpleSalta.wav");
        rutasSonidos.put("sonidoSuperChampinion", "/sonidos/SonidoSuperChampinion.wav");
        rutasSonidos.put("sonidoSeConvierteASuperMario", "/sonidos/sonidoSeConvierteASuperMario.wav");
        rutasSonidos.put("sonidoSalePowerUp", "/sonidos/SonidoSalePowerUp.wav");
        rutasSonidos.put("sonidoRomperBloque", "/sonidos/SonidoRomperBloque.wav");
        rutasSonidos.put("sonidoMarioMuere", "/sonidos/sonidoMarioSimpleMuere.wav");
        rutasSonidos.put("sonidoGanaNivel", "/sonidos/sonidoGanaNivel.wav");
        rutasSonidos.put("sonidoEstrella", "/sonidos/SonidoEstrella.wav");
        rutasSonidos.put("sonidoChoqueBloque", "/sonidos/SonidoChoqueBloque.wav");
        rutasSonidos.put("sonidoChampinionVerde", "/sonidos/SonidoChampinionVerde.wav");
        rutasSonidos.put("sonidoCaerSobreGoomba", "/sonidos/SonidoCaerSobreGoomba.wav");
        rutasSonidos.put("sonidoBolaDeFuego", "/sonidos/SonidoBolaDeFuego.wav");
        rutasSonidos.put("sonidoMarioBajaMastil", "/sonidos/sonidoMarioBajaMastil.wav");
        rutasSonidos.put("sonidoMoneda", "/sonidos/sonidoMoneda.wav");
        rutasSonidos.put("sonidoGameOver", "/sonidos/sonidoGameOver.wav");
        rutasSonidos.put("sonidoAgarrarPowerUp", "/sonidos/SonidoAgarrarPowerUp.wav");
    }

	public static Sonido obtenerInstancia() {
		if (instanciaSonido == null) 
			instanciaSonido = new Sonido();
		
		return instanciaSonido;
	}

	public void reproducirSonidoFondo(String nombreSonido) {
		try {
			String rutaArchivo = rutasSonidos.get(nombreSonido);
			InputStream audioStream = getClass().getResourceAsStream(rutaArchivo);
			if (audioStream == null) {
				System.out.println("Error: no se encontró el archivo de sonido.");
				return;
			}
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioStream);
			clipFondo = AudioSystem.getClip();
			clipFondo.open(audioInputStream);

			if (clipFondo != null) {
				clipFondo.setFramePosition(0);
				clipFondo.loop(Clip.LOOP_CONTINUOUSLY);
			}
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			System.out.println("Error al cargar el sonido: " + e.getMessage());
		}
	}

	public void reproducirSonidoEfecto(String nombreSonido) {
		try {
			if (clipEfecto != null && clipEfecto.isRunning()) {
				clipEfecto.stop();
				clipEfecto.flush(); 
			}
			String rutaArchivo = rutasSonidos.get(nombreSonido);
			InputStream audioStream = getClass().getResourceAsStream(rutaArchivo);
			if (audioStream == null) {
				System.out.println("Error: no se encontró el archivo de efecto.");
				return;
			}
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioStream);
			clipEfecto = AudioSystem.getClip();
			clipEfecto.open(audioInputStream);
			if(clipEfecto!=null) {
				clipEfecto.setFramePosition(0);
				clipEfecto.start();
			}
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			System.out.println("Error al reproducir el efecto: " + e.getMessage());
		}

	}

	public void detenerSonidoFondo() {
		if (clipFondo != null) {
			clipFondo.stop();
		}
	}
	public void detenerSonidoEfecto() {
		if (clipEfecto != null) {
			clipEfecto.stop();		}
	}

}
