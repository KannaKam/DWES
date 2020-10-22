import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
	private static Connection dbConnection;

	private static final String datosEmpleado = "select * from empleados";
	
	private static final String empleadoPorDNI = "select * from empleados where dni=?;";

	public static Connection getDBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/nominas", "root", "");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}
	public static List<Empleado> mostrarEmpleados() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<Empleado> empleados = new ArrayList<>();

		try {
			connection = getDBConnection();

			preparedStatement = connection.prepareStatement(datosEmpleado);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String dni = rs.getString("dni");
				String sexo = rs.getString("sexo");
				int anyos = rs.getInt("anyos");
				int categoria = rs.getInt("categoria");
				empleados.add(new Empleado(nombre, dni, sexo, anyos, categoria));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empleados;
	}
	public Empleado buscarEmpleado(int dniPK) {
		Empleado empleado = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			connection = getDBConnection();

			preparedStatement = connection.prepareStatement(empleadoPorDNI);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String dni = rs.getString("dni");
				String sexo = rs.getString("sexo");
				int anyos = rs.getInt("anyos");
				int categoria = rs.getInt("categoria");
				empleado = new Empleado(nombre, dni, sexo, anyos, categoria);
			}
		} catch (SQLException e) {
			System.out.println("El DNI introducido no pertenece a ningún empleado.");
		}
		return empleado;
	}
}
