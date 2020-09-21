package Laboral;

public class Persona {

    public String nombre, dni;
    public char sexo;

    public Persona(String nombre, String dni, char sexo){
        this.dni = dni;
        this.nombre = nombre;
        this.sexo = sexo;
    }

    public Persona (String nombre, char sexo){
        this.nombre = nombre;
        this.sexo = sexo;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String imprimir() {
        return "Empleado: "+this.nombre+"\nDNI: "+this.dni+".";
    }
}
