package Laboral;

import java.util.regex.Pattern;

public class DatosNoCorrectosException extends Exception {
    public DatosNoCorrectosException(String mensajeError) {
        super(mensajeError);
    }

    /*public DatosNoCorrectosException (String mensajeError, Throwable error){
        super(mensajeError,error);
    }*/
    public static int numeroCategoriaIncorrecta(int categoria) throws DatosNoCorrectosException {
        if (categoria < 0 || categoria > 10) {
            throw new DatosNoCorrectosException("El número de la categoría no existe.");
        } else {
            return categoria;
        }
    }

    public static String dniIncorrecto(String dni) throws DatosNoCorrectosException {
        String dniRegex = "\\d{8}[A-HJ-NP-TV-Z]";
        if (!Pattern.matches(dniRegex, dni)) {
            throw new DatosNoCorrectosException("El DNI introducido no es correcto.");
        } else {
            return dni;
        }
    }
    /*public static char sexoCorrecto(char sexo) throws DatosNoCorrectosException{
        String sexoRegex = "[M]|[F]";
    }*/
}
