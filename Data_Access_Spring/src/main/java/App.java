import java.util.ArrayList;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import DAO.Entidades.AlumnoDAO;
import DAO.Implementaciones.AlumnoImpl;

public class App {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");		
		AlumnoImpl ac = (AlumnoImpl)context.getBean(AlumnoImpl.class);

		ac.insertAlumno("Diego", "No es mi direccion 5,2,1");
		ArrayList<AlumnoDAO> listAlumno = ac.selectEverything();

		for (AlumnoDAO a : listAlumno)
			System.out.println(String.format("Id_alumno = %d, nombre = %s, direccion = %s ", a.getId(), a.getNombre(), a.getDireccion()));

	}

}
