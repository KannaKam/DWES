package filmografiamvc.entidades;

import javax.persistence.*;

@Entity
@Table(name = "director")
public class Director {

	@Column(name = "nombre")
	@Id
	private String nombre;

	public Director() {
		this.nombre = "";
	}

	public Director(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
