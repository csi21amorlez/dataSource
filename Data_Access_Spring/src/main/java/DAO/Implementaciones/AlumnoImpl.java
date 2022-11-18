package DAO.Implementaciones;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import DAO.Entidades.AlumnoDAO;



@Component
public class AlumnoImpl implements DAO.Servicios.AlumnoService {

	private DataSource ds;
	public DataSource getDs() {
		return ds;
	}

	public void setDs(DataSource ds) {
		this.ds = ds;
	}

	@Autowired
	public ArrayList<AlumnoDAO> selectEverything() {
		// Declaramos la consulta sql

		System.out.println("[INFO] Entrando en implementaciones.AlumnoImpl.selectEverything");
		String sql = "SELECT * FROM \"alumnos\".\"alumnos\"";
		ArrayList<AlumnoDAO> listAlumnos = new ArrayList<AlumnoDAO>();
		try {

			Connection conn = ds.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (!rs.next()) {
				System.out.println("[INFO] -- mimplementaciones.AlumnoImpl.selectEverything -- La tabla alumnos esta vacia");
				return null;
			}

			while (rs.next()) {
				
				AlumnoDAO a = new AlumnoDAO();
				a.setId(rs.getInt("id_alumno"));
				a.setNombre(rs.getString("nombre"));
				a.setDireccion(rs.getString("direccion"));
				listAlumnos.add(a);

			}
			System.out.println("[INFO] -- Saliendo de implementaciones.AlumnoImpl.selectEverything");

			return listAlumnos;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[INFO] -- mimplementaciones.AlumnoImpl.selectEverything -- " + e.toString());
		}
		System.out.println("[INFO] -- Saliendo de implementaciones.AlumnoImpl.selectEverything");
		return null;
	}

	@Autowired
	public void insertAlumno(String nombre, String direccion) {

		System.out.println("[INFO] -- Entrando en consultas.AlumnoImpl.insertAlumno");
		try {
			Connection conn = ds.getConnection();
			// Realizamos el insert
			Statement st = conn.createStatement();

			String sql = "INSERT INTO \"alumnos\".\"alumnos\" VALUES(DEFAULT,\'" + nombre + "\', \' " + direccion
					+ "\');";
			System.out.println(sql);
			st.executeUpdate(sql);
			// Cerramos la conexión
		} catch (Exception e) {
			System.out.println("[ERROR] -- consultas.AlumnoImpl.insertAlumno -- " + e.toString());
			e.printStackTrace();
		}
		System.out.println("[INFO] -- consultas.AlumnoImpl.insertAlumno");

	}

}
