package be.jef.servlets.characters;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.jef.dao.CharacterDAO;

@WebServlet("/characters/load.htm")
public class LoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/characters/load.jsp";
	private final transient CharacterDAO characterDAO = new CharacterDAO();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getQueryString() != null) {
			try {
				request.setAttribute("character", characterDAO.read(Long
						.parseLong(request.getParameter("characterName"))));
			} catch (NumberFormatException ex) {
				request.setAttribute("fouten",
						Collections.singletonMap("characterName", "tik een naam"));
			}
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
