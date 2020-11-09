package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PeliculaDAO {

	private static Connection dbConnection;
	
	private static final String peliculaPorDirector = "select * from pelicula where director = ?;";

	public static Connection getDBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/cine", "root", "");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}
	public static List<Pelicula> buscarPeliculas(String directorPK){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<Pelicula> peliculas = new ArrayList<>();

		try {
			connection = getDBConnection();

			preparedStatement = connection.prepareStatement(peliculaPorDirector);
			preparedStatement.setString(1, directorPK);

			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String director = rs.getString("director");
				String titulo = rs.getString("titulo");
				String fecha = rs.getString("fecha");
				peliculas.add(new Pelicula(director, titulo, fecha));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return peliculas;
	}
}
