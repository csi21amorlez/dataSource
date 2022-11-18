package DAO.Servicios;

import DAO.Entidades.*;
import java.util.*;

import javax.sql.DataSource;

import java.sql.*;

import org.springframework.context.ApplicationContext;

public interface AlumnoService {

	// Método que realizara una consulta de todos los datos de la tabla alumno
	public ArrayList<AlumnoDAO> selectEverything(DataSource ds);

	// Metodo que inserta un alumno con los parametros indicados
	public void insertAlumno(String nombre, String direccion, DataSource ds);

}
