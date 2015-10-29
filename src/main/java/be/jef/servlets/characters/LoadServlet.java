package be.jef.servlets.characters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.jef.entities.Clan;
import be.jef.entities.Personage;
import be.jef.entities.attributes.AttributeColumn;
import be.jef.entities.attributes.PersAttCol;
import be.jef.services.AttributeColumnService;
import be.jef.services.ClanService;
import be.jef.services.PersAttColService;
import be.jef.services.PersonageService;


@WebServlet("/characters/load.htm")
public class LoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/characters/load.jsp";
	private final transient PersonageService personageService = new PersonageService();
	private final transient ClanService clanService = new ClanService();
	private final transient PersAttColService persAttColService = new PersAttColService();
	private final transient AttributeColumnService attributeColumnService = new AttributeColumnService();
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Personage> personages = personageService.findAll();
		request.setAttribute("personages", personages);
		String persId = request.getParameter("persId");
		if (persId != null) {
			Personage personage = personageService.read(Long.parseLong(persId));
			request.setAttribute("personage", personage);
			Clan clan = personage.getClan();
			request.setAttribute("clan", clan);
			List<AttributeColumn> attributeColumns = attributeColumnService.findAll();
			request.setAttribute("attributeColumns", attributeColumns);
			List<PersAttCol> persAttCols = new ArrayList<>();
			for(AttributeColumn attributeColumn : attributeColumns){
			persAttCols.add(persAttColService.findAttColForPers(personage, attributeColumn));
			}
			request.setAttribute("persAttCols", persAttCols);
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
	
	
	

}
