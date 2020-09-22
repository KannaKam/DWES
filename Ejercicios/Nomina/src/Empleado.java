import Laboral.Persona;

import java.util.regex.Pattern;

public class Empleado extends Persona {

    private int categoria;
    public int anyosTrabajados;

    /**
     *
     * @throws DatosNoCorrectosException Excepción creada para controlar el tipo de datos que se manejan en éste programa.
     */
    public Empleado(String nombre, String dni, char sexo) throws DatosNoCorrectosException {
        super(nombre, dni, sexo);
        if ((!Pattern.matches("\\d{8}[A-HJ-NP-TV-Z]", dni))|| (!Pattern.matches("^[MFmf]", sexo + ""))) {
            throw new DatosNoCorrectosException();
        }
        this.anyosTrabajados = 0;
        this.categoria = 1;
    }

    /**
     *
     * @param categoria variable que almacena la categoría en la que se encuentra el empleado.
     * @param anyosTrabajados variable que almacena los años que el empleado lleva trabajados.
     * @throws DatosNoCorrectosException
     */
    public Empleado(String nombre, String dni, char sexo, int categoria, int anyosTrabajados) throws DatosNoCorrectosException {
        super(nombre, dni, sexo);
        if (!Pattern.matches(("^[FMfm]"), sexo + "")|| !Pattern.matches(("(\\d{8})([-]?)([A-Z]{1})"),dni) || anyosTrabajados<0) {
            throw new DatosNoCorrectosException();
        }

        setCategoria(categoria);

        this.anyosTrabajados = anyosTrabajados;
    }

    public void setCategoria(int categoria) throws DatosNoCorrectosException {
        if (categoria < 0 || categoria > 10) {
            throw new DatosNoCorrectosException();
        }
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
