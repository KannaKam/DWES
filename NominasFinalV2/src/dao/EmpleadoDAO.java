package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Empleado;
import model.Nomina;

public class EmpleadoDAO {

	private static Connection dbConnection;

	private static final String insertarEmpleadoSQL = "INSERT INTO empleados"
			+ "  (nombre, dni, sexo, anyos, categoria) VALUES " + " (?, ?, ?, ? , ?);";

	private static final String extraerEmpleado = "select nombre, dni, sexo, anyos, categoria from empleados where dni =?";
	private static final String listarEmpleados = "select * from empleados";
	private static final String eliminarEmpleado = "delete from empleados where dni = ?;";
	private static final String eliminarNomina = "delete from nominas where dniEmpleados = ?;";
	private static final String actualizarEmpleado = "update empleados set nombre = ?,sexo= ?, categoria =?, anyos =? where dni = ?;";

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

	public static void insertarEmpleado(Empleado empleado) throws SQLException {

		// try-with-resource statement will auto close the connection.
		try (Connection connection = getDBConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(insertarEmpleadoSQL)) {
			preparedStatement.setString(1, empleado.getNombre());
			preparedStatement.setString(2, empleado.getDni());
			preparedStatement.setString(3, empleado.getSexo());
			preparedStatement.setInt(4, empleado.getAnyos());
			preparedStatement.setInt(5, empleado.getCategoria());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar el empleado");
		}
	}

	public Empleado pedirEmpleado(int id) {
		Empleado empleado = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			connection = getDBConnection();

			preparedStatement = connection.prepareStatement(extraerEmpleado);

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
			System.out.println("Error al extraer el empleado");
		}
		return empleado;
	}

	public static List<Empleado> listarEmpleados() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<Empleado> empleados = new ArrayList<>();

		try {
			connection = getDBConnection();

			preparedStatement = connection.prepareStatement(listarEmpleados);

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
	public static boolean eliminarEmpleado(String dni) throws SQLException {
        boolean rowDeleted;
        try {
        	Connection connection = getDBConnection(); 
        	PreparedStatement statement = connection.prepareStatement(eliminarEmpleado);
        	PreparedStatement statementNomina = connection.prepareStatement(eliminarNomina);
        	
            statement.setString(1, dni);
            statementNomina.setString(1, dni);
            
            rowDeleted = statement.executeUpdate() > 0;
            rowDeleted = statementNomina.executeUpdate() >0;
        return rowDeleted;
    }finally {
    	
    }
	}
	public static boolean actualizarEmpleado(Empleado empleado) throws SQLException {
        boolean filaActualizada;
        try (Connection connection = getDBConnection(); PreparedStatement statement = connection.prepareStatement(actualizarEmpleado);) {
            statement.setString(1, empleado.getNombre());
            statement.setString(2, empleado.getDni());
            statement.setString(3, empleado.getSexo());
            statement.setInt(4, empleado.getCategoria());
            statement.setInt(4, empleado.getAnyos());

            filaActualizada = statement.executeUpdate() > 0;
        }
        return filaActualizada;
    }
	public static Empleado extraerEmpleado(String dniEmpleado) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Empleado empleado = null;

		try {
			connection = getDBConnection();

			preparedStatement = connection.prepareStatement(extraerEmpleado);
			
			preparedStatement.setString(1, dniEmpleado);
			
			rs = preparedStatement.executeQuery();

			rs.absolute(1);
				String nombre = rs.getString("nombre");
				String dni = rs.getString("dni");
				String sexo = rs.getString("sexo");
				int anyos = rs.getInt("anyos");
				int categoria = rs.getInt("categoria");
				empleado =new Empleado(nombre, dni, sexo, anyos, categoria);
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empleado;
	}
}