package be.jef.servlets.characters;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.jef.services.CharacterService;


@WebServlet("/characters/load.htm")
public class LoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/characters/load.jsp";
	private final CharacterService characterService = new CharacterService();

	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("characters", characterService.findAll());
		String idCharacter = request.getParameter("idCharacter");
		if (idCharacter != null) {
			request.setAttribute("character",
					characterService.read(Long.parseLong(idCharacter)));			
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
	
	
	

}
