package pack1;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddEmpService {
	
	public boolean addEmployee(HttpServletRequest request, HttpServletResponse response)
	{
		String userName = request.getParameter("userName");
		String address = request.getParameter("address");
		String designation = request.getParameter("designation");
		
		Employee newEmployee = new Employee();
		newEmployee.setUserName(userName);
		newEmployee.setDesignation(designation);
		newEmployee.setAddress(address);
		
		boolean result = false;
		
		try {
			PersistenceManager pm = JDOHelper.getPersistenceManagerFactory(
					"transactions-optional").getPersistenceManager();
			pm.makePersistent(newEmployee);
			result=true;

		} catch (Exception e) {
			System.out.println("Exception : " + e);
			result=false;
		}
		return result;
		
	}
	
	
	

}
