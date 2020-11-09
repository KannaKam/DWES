package modelo;

public class Pelicula {

	private String director, titulo, fecha;
	
	public Pelicula(String director, String titulo, String fecha) {
		this.director = director;
		this.fecha = fecha;
		this.titulo = titulo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
}
