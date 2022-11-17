import java.sql.Connection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import DAO.Implementaciones.AlumnoImpl;

public class App {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		AlumnoImpl a = (AlumnoImpl)context.getBean("AlumnoImpl");
		
		a.test();
		

	}

}
