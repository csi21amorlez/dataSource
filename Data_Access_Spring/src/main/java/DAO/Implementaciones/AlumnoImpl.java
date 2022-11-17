package DAO.Implementaciones;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoImpl implements DAO.Servicios.AlumnoService {

	@Autowired
	public ResultSet selectEverything(Connection conn) {
		// Declaramos la consulta sql
		System.out.println("[INFO] Entrando en implementaciones.AlumnoImpl.selectEverything");
		String sql = "SELECT * FROM \"alumnos\".\"alumnos\"";
		try {

			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[INFO] -- mimplementaciones.AlumnoImpl.selectEverything -- " + e.toString());
		}
		System.out.println("[INFO] -- Saliendo de implementaciones.AlumnoImpl.selectEverything");
		return null;
	}

	@Autowired
	public void insertAlumno(String nombre, String direccion, Connection conn) {

		System.out.println("[INFO] -- Entrando en consultas.AlumnoImpl.insertAlumno");
		try {
			// Realizamos el insert
			Statement st = conn.createStatement();

			String sql = "INSERT INTO \"alumnos\".\"alumnos\" VALUES(DEFAULT, 'test, 'test');";
			st.executeUpdate(sql);
			// Cerramos la conexión

		} catch (Exception e) {
			System.out.println("[ERROR] -- consultas.AlumnoImpl.insertAlumno -- " + e.toString());
		}
		System.out.println("[INFO] -- consultas.AlumnoImpl.insertAlumno");

	}
	
	public void test() {
		System.out.println("Joder");
	}

}
