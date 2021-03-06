public class Nomina {
    private static final int SUELDO_BASE[] =
            {50000, 70000, 90000, 110000, 130000,
                    150000, 170000, 190000, 210000, 230000};

    /**
     *
     * @param empleado empleado al que se le calcula el sueldo.
     * @return
     */
    protected static int sueldo (Empleado empleado){
        return SUELDO_BASE[empleado.getCategoria()-1]+5000* empleado.anyosTrabajados;
    }
}
