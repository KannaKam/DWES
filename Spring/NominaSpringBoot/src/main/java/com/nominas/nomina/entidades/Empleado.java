package com.nominas.nomina.entidades;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name = "empleado")
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "dni")
	private String dni;

	@Column(name = "sexo")
	private String sexo;
	
	@Column(name = "categoria")
	private int categoria;
	
	@Column(name = "antiguedad")
	private int antiguedad;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idNomina")
    private Nomina nomina;
    
	
}
