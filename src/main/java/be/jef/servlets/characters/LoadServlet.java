package be.jef.servlets.characters;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.jef.entities.Personage;
import be.jef.services.PersonageService;


@WebServlet("/characters/load.htm")
public class LoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/characters/load.jsp";
	private final PersonageService personageService = new PersonageService();

	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Personage> personages = personageService.findAll();
		request.setAttribute("personages", personages);
		String persId = request.getParameter("persId");
		if (persId != null) {
			request.setAttribute("personage",
					personageService.read(Long.parseLong(persId)));			
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
	
	
	

}
