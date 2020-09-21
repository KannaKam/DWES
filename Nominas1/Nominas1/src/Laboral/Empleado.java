package Laboral;

public class Empleado extends Persona{

    private int categoria;
    public int anyosTrabajados;

    public Empleado(String nombre, String dni, char sexo, int categoria, int anyosTrabajados) {
        super(nombre, dni, sexo);
        this.anyosTrabajados = anyosTrabajados;
        this.categoria = categoria;
    }

    public Empleado(String nombre, String dni, char sexo) {
        super(nombre, dni, sexo);
        this.anyosTrabajados = 0;
        this.categoria = 1;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getCategoria() {
        return categoria;
    }
    public int incrAnyo(int anyosTrabajados){
        anyosTrabajados++;
        return anyosTrabajados;
    }

    public String imprime() {
        return "Empleado: "+this.nombre+".\nDNI: "+this.dni+
                ".\nSexo: "+this.sexo+".\nAños trabajados: "+this.anyosTrabajados+
                ".\nCategoría: "+categoria+".";
    }
}
