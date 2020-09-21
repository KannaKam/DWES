public class CalculaNominas {
    public static void main(String[] args) {
        Empleado empleado1 = null;
        Empleado empleado2 = null;

        try {
            empleado1 = new Empleado("James Cosling", "32000032G", 'M', 4, 7);
            empleado2 = new Empleado("Ada Lovelace", "32000031R", 'F');
        } catch (DatosNoCorrectosException exception) {
            System.out.println("Introduzca datos correctos");
        }
        if (empleado1 != null && empleado2 != null) {
            escribe(empleado1, empleado2);
            empleado2.incrAnyo(empleado2.anyosTrabajados);
            try {
                empleado1.setCategoria(9);
            } catch (DatosNoCorrectosException exception) {
                System.out.println("Introduzca datos correctos");
            }
            escribe(empleado1, empleado2);
        }

    }

    private static void escribe(Empleado empleado1, Empleado empleado2) {
        System.out.println(empleado1.imprime());
        System.out.println("El sueldo de " + empleado1.nombre + " es de: " + Nomina.sueldo(empleado1));
        System.out.println(empleado2.imprime());
        System.out.println("El sueldo de " + empleado1.nombre + " es de: " + Nomina.sueldo(empleado2));
    }
}
