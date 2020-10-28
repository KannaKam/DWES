package dao;

public class Nomina {

	int sueldo;
	String dni;
	
	public Nomina(int sueldo, String dni) {
		this.sueldo = sueldo;
		this.dni = dni;
	}
	
	private static final int[] SUELDO_BASE = {50000, 70000, 90000, 110000, 130000,
            150000, 170000, 190000, 210000, 230000};

    /**
     * Metodo que se encarga de calcular el sueldo de un empleado
     * @param empleado El empleado al que se le calcula el sueldo
     * @return El sueldo del empleado enviado ya calculado
     */
     public static int sueldo(Empleado empleado,int categoria){
        int sueldo;
        sueldo = SUELDO_BASE[categoria-1]+5000*empleado.getAnyos();
        return sueldo;
    }

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
     
}
