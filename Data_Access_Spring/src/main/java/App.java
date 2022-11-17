import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import DAO.Entidades.AlumnoDAO;
import DAO.Implementaciones.AlumnoImpl;

public class App {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		DataSource ds = context.getBean(DataSource.class);
		AlumnoImpl alumno = new AlumnoImpl();
		
		alumno.insertAlumno("Juan","Antonio Rodriguez Zepellin" , ds);
		ArrayList<AlumnoDAO> listAlumno = alumno.selectEverything(ds);
		
		for(AlumnoDAO a : listAlumno)
			System.out.println(a.toString());
		
		
		
		
		

	}

}
