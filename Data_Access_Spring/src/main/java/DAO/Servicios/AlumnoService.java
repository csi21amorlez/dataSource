package DAO.Servicios;

import java.sql.*;



public interface AlumnoService {

	// Método que realizara una consulta de todos los datos de la tabla alumno
	public ResultSet selectEverything(Connection conn);

	// Metodo que inserta un alumno con los parametros indicados
	public void insertAlumno(String nombre, String direccion, Connection conn);

}
