package Ranking;

public class Puntuacion implements Comparable<Puntuacion> {
	
    private String usuario;
    private int puntos;

    public Puntuacion(String usuario, int puntos) {
        this.usuario = usuario;
        this.puntos = puntos;
    }

    public int obtenerPuntos() {
        return puntos;
    }
    
    public String obtenerUsuario() {
        return usuario;
    }

    public int compareTo(Puntuacion other) {
        return other.puntos - this.puntos;
    }
    
    public String toString() {
        return usuario + " " + puntos;
    }

}
