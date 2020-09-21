import java.util.regex.Pattern;

public class DatosNoCorrectosException extends Exception {
    /*public DatosNoCorrectosException(String mensajeError) {
        super(mensajeError);
    }

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
    public static char sexoIncorrecto(char sexo) throws DatosNoCorrectosException{
        String sexoRegex = "[HMhm]";
        String stringSexo = Character.toString(sexo);
        if (!Pattern.matches(sexoRegex, stringSexo)){
            throw new DatosNoCorrectosException("El sexo introducdido no es correcto.");
        }else{
            sexo = stringSexo.charAt(0);
            return sexo;
        }
    }
    public static int anyosTrabajadosIncorrectos(int anyosTrabajados) throws DatosNoCorrectosException{
        String anyosRegex = "^[0-9][0-9]*$";
        String stringAnyos = Integer.toString(anyosTrabajados);
        if (!Pattern.matches(anyosRegex,stringAnyos)){
            throw new DatosNoCorrectosException("Los años trabajados introducidos no son correctos.");
        }else{
            return Integer.parseInt(stringAnyos);
        }
    }*/
}
