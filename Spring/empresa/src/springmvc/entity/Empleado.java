package springmvc.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.context.annotation.PropertySource;

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    @Length(min=1, max=45, message="Entre 0 y 45 caracteres")
    @NotNull(message = "is required")
    private String nombre;

    @Column(name = "dni")
    @NotNull(message = "is required")
    @Pattern(regexp = "^[0-9]{8,8}[A-Za-z]$", message = "8 numeros y 1 letra")
    private String dni;

    @Column(name = "sexo")
    @NotNull(message = "is required")
    @Pattern(regexp = "^[HM]$", message = "M o F mayuscula")
    private String sexo;

    @Column(name = "categoria")
    @NotNull(message = "is required")
    @Range(min=1, max=10, message = "Entre 1 y 10")
    private int categoria;

    @Column(name = "antiguedad")
    @NotNull(message = "Minimo 1 año trabajado")
    @Min(value = 1, message = "Minimo 1 año trabajado")
    @Max(value = 50)
    private int antiguedad;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nomina_id")
    @NotNull(message = "is required")
    private Nomina nomina;

    public Empleado() {

    }

    public Empleado(String nombre, String dni, String sexo, int categoria, int antiguedad) {
        this.nombre = nombre;
        this.dni = dni;
        this.sexo = sexo;
        this.categoria = categoria;
        this.antiguedad = antiguedad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Nomina getNomina() {
        return nomina;
    }

    public void setNomina(Nomina nomina) {
        this.nomina = nomina;
    }

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", dni=" + dni + ", sexo=" + sexo + ", categoria="
				+ categoria + ", antiguedad=" + antiguedad + ", nomina=" + nomina + "]";
	}
    
    
}
