package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NominaDAO {
	private static Connection dbConnection;
	
	private static final String empleadoPorDNI = "select sueldo from nominas where dniEmpleado = ?;";

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
	public static Nomina buscarNomina(String dniPK) {
		Nomina nomina = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			connection = getDBConnection();

			preparedStatement = connection.prepareStatement(empleadoPorDNI);

			preparedStatement.setString(1, dniPK);

			rs = preparedStatement.executeQuery();

			rs.absolute(1);
				int sueldo = rs.getInt("sueldo");
				
				nomina = new Nomina(sueldo, dniPK);
			
		} catch (SQLException e) {
			System.out.println("El DNI introducido no pertenece a ningún empleado.");
		}
		return nomina;
	}

}
