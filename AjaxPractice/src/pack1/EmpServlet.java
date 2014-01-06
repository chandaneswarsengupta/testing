package pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pack1.AddEmpService;

public class EmpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		AddEmpService newEmployee = new AddEmpService();
		boolean returnRecord = newEmployee.addEmployee(request, response);
		
		if(returnRecord)
			request.setAttribute("status", "saved");
		else
			request.setAttribute("status", "not saved");
		
		request.getRequestDispatcher("feedBack.jsp").forward(request,
				response);
	}

}
