package fr.gtm.servlet;

import java.io.IOException;
import java.util.logging.Logger;

import javax.ejb.EJB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.timer.TestTimerBean;

/**
 * Servlet implementation class TestTimerServlet
 */
@WebServlet("/TestTimerServlet")
public class TestTimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger("time");
	@EJB private TestTimerBean ejb;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  //reccupération dans le formulaire
	
		String gon = request.getParameter("gon");
				
		if(gon.equals("start"))
		{
			String duree = request.getParameter("duree");
			ejb.departTimer(Integer.parseInt(duree));				
		}
		if(gon.equals("stop"))
		{
			ejb.stop();
		}
		
		String page = "/index.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
					
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
