package Ranking;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Ranking {

	private static Ranking instanciaRanking;
	private static final int MAX_PUNTUACIONES = 5;
	private ArrayList<Puntuacion> puntuaciones;
	private static final String RANKING = "src/Ranking/ranking.txt";

	private Ranking() {
		puntuaciones = new ArrayList<>();
		cargarPuntuaciones();
		if (puntuaciones.isEmpty()) {
			for (int i = 0; i < MAX_PUNTUACIONES; i++) {
				puntuaciones.add(new Puntuacion("Nombre del Usuario", 0));
			}
		}
	}

	public static synchronized Ranking obtenerInstancia() {
		
		if (instanciaRanking == null) {
			instanciaRanking = new Ranking();
		}
		
		return instanciaRanking;
	}

	public String obtenerUsuario(int puntos) {
		String usuario;
		if (puntos > 0 && puntos <= puntuaciones.size()) {
			Puntuacion puntuacion = puntuaciones.get(puntos - 1);
			usuario = puntos + ". " + puntuacion.obtenerUsuario();
		} 
		else 
			usuario = puntos + ". Nombre de usuario"; 
		
		return usuario;
	}

	public String obtenerPuntos(int puntos) {
		String usuario;
		if (puntos > 0 && puntos <= puntuaciones.size()) {
			Puntuacion puntuacion = puntuaciones.get(puntos - 1);
			usuario = " " + puntuacion.obtenerPuntos();
		} 
		else 
			usuario = "00"; 
		
		return usuario;
	}

	public void agregarPuntuacion(Puntuacion nuevoPuntaje) {
		puntuaciones.add(nuevoPuntaje);
		Collections.sort(puntuaciones);
		if (puntuaciones.size() > MAX_PUNTUACIONES) {
			puntuaciones.remove(puntuaciones.size() - 1);
		}
		guardarPuntuaciones(); 
	}

	public void guardarPuntuaciones() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(RANKING))) {
			for (Puntuacion puntuacion : puntuaciones) {
				bw.write(puntuacion.obtenerUsuario() + "," + puntuacion.obtenerPuntos());
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void cargarPuntuaciones() {
		try (BufferedReader br = new BufferedReader(new FileReader(RANKING))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] partes = linea.split(",");
				String usuario = partes[0];
				int puntos = Integer.parseInt(partes[1]);
				puntuaciones.add(new Puntuacion(usuario, puntos));
			}
			Collections.sort(puntuaciones);
		} catch (IOException e) {
			System.out.println("No se pudo cargar el archivo de puntuaciones. Se creará uno nuevo.");
		}
	}
	
}
